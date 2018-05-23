package valentine.lab3;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String databaseName = "flowerstore.db"; // название бд
    private static final int schema = 1; // версия базы данных
    static final String table = "flowers"; // название таблицы в бд

    public static final String columnID = "_id";
    public static final String columnName = "name";
    public static final String columnColor = "color";
    public static final String columnStartPrice = "start_price";
    public static final String columnEndPrice = "end_price";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, schema);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + table + " (" +
                columnID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                columnName + " TEXT, " +
                columnColor + " TEXT, " +
                columnStartPrice + " INTEGER, " +
                columnEndPrice + " INTEGER);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table);
        onCreate(db);
    }
}