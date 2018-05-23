package valentine.lab3;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String colorName;
    TextView startPrice;
    TextView endPrice;
    EditText editTextName;
    Button addButton;
    Button showAllButton;
    Button deleteAllButton;
    CrystalRangeSeekbar priceRange;
    int  start = 0, end = 1000;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.name);
        startPrice = (TextView) findViewById(R.id.start_price);
        endPrice = (TextView) findViewById(R.id.end_price);
        addButton = (Button) findViewById(R.id.addButton);
        showAllButton = (Button) findViewById(R.id.showAllButton);
        deleteAllButton = (Button) findViewById(R.id.deleteAllButton);
        priceRange = (CrystalRangeSeekbar) findViewById(R.id.priceRange);
        priceRange.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                startPrice.setText(String.valueOf(minValue));
                start = minValue.intValue();
                endPrice.setText(String.valueOf(maxValue));
                end = maxValue.intValue();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(view);
            }
        });
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAll(view);
            }
        });
        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAll(view);
            }
        });

        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        RadioButton radioButton = (RadioButton) view;
        if (checked) {
            colorName = radioButton.getText().toString();
        }
        switch(view.getId()) {
            case R.id.red:
                if (checked){
                }
                break;
            case R.id.orange:
                if (checked){
                }
                break;
            case R.id.yellow:
                if (checked){
                }
                break;
            case R.id.green:
                if (checked){
                }
                break;
            case R.id.cyan:
                if (checked){
                }
                break;
            case R.id.blue:
                if (checked){
                }
                break;
            case R.id.violet:
                if (checked){
                }
                break;
        }
    }

    public void add(View view) {
        if(editTextName.getText().toString().equals(""))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Помилка");
            String message="Будь ласка введіть назву";
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
        else if(colorName == null)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Помилка");
            String message="Будь ласка виберіть колір";
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
        else {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseHelper.columnName, editTextName.getText().toString());
            cv.put(DatabaseHelper.columnColor, colorName);
            cv.put(DatabaseHelper.columnStartPrice, start);
            cv.put(DatabaseHelper.columnEndPrice, end);

            db = databaseHelper.getWritableDatabase();
            db.insert(DatabaseHelper.table, null, cv);
            db.close();
            Toast.makeText(getApplicationContext(), "Дані успішно додано!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void showAll(View view)
    {
        db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DatabaseHelper.table , null);
        int num = cursor.getCount();
        db.close();
        cursor.close();
        if(num == 0)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Помилка");
            String message="База даних порожня!";
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
        else
        {
            Intent intent = new Intent(this, ShowActivity.class);
            startActivity(intent);
        }
    }

    public void deleteAll(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        String message="Ви впевнені що хочете видалити базу даних?";
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                db = databaseHelper.getWritableDatabase();
                db.execSQL(" DELETE FROM " + DatabaseHelper.table);
                db.close();
                Toast.makeText(getApplicationContext(), "Дані успішно видалено!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("CANCEL",null);
        builder.show();
    }
}
