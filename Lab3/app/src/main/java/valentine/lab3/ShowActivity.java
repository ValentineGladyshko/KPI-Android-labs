package valentine.lab3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ShowActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    ListView flowerList;
    Cursor flowerCursor;
    SimpleCursorAdapter flowerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        flowerList = (ListView) findViewById(R.id.list);

        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    @Override
    public void onResume() {
        super.onResume();

        db = databaseHelper.getReadableDatabase();

        flowerCursor =  db.rawQuery("select * from "+ DatabaseHelper.table, null);
        String[] headers = new String[] {DatabaseHelper.columnName, DatabaseHelper.columnColor,
                DatabaseHelper.columnStartPrice, DatabaseHelper.columnEndPrice};
        // создаем адаптер, передаем в него курсор
        flowerAdapter = new SimpleCursorAdapter(this, R.layout.list_item,
                flowerCursor, headers, new int[]{R.id.nameValue, R.id.colorValue, R.id.startPriceValue, R.id.endPriceValue}, 0);
        flowerList.setAdapter(flowerAdapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        flowerCursor.close();
    }
}
