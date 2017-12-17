package app.io.capter.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import app.io.capter.constants.ConstantsDB;
import app.io.capter.entity.ImageCapture;



public class DataBaseManager {
    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataBaseManager(Context context) {
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    /**
     *
     * @param imageCapture
     */
    public void insert(ImageCapture imageCapture) {
        ContentValues values = new ContentValues();
        values.put(ConstantsDB.IMAGE_CATEGORY, imageCapture.getCategory());
        values.put(ConstantsDB.IMAGE_DATA, imageCapture.getImageByte());
        sqLiteDatabase.insert(ConstantsDB.TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }

    /**
     * @return Retorna todos los Jugadores
     * Order By PLAY_SCORE (Ordenado por Puntajes)
     * Orden: DESC (Descendente)
     */
    public Cursor getDataPlayer() {
        String[] columns = new String[]{
                ConstantsDB.IMAGE_ID,
                ConstantsDB.IMAGE_CATEGORY,
                ConstantsDB.IMAGE_DATA};
        return sqLiteDatabase.query(ConstantsDB.TABLE_NAME, columns, null, null, null, null, ConstantsDB.IMAGE_ID + " DESC");
    }


}
