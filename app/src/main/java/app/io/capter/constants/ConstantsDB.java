package app.io.capter.constants;


/**
 * Constantes para crear la BD
 */

public class ConstantsDB {

    public final static String DB_NAME = "database.db";
    public final static int DB_VERSION = 1;

    public final static String TABLE_NAME = "IMAGE_CAPTURE";
    public final static String IMAGE_ID = "IMAGE_ID";
    public final static String IMAGE_CATEGORY = "IMAGE_CATEGORY";
    public final static String IMAGE_DATA = "IMAGE_DATA";

    public final static String IMAGE_SQL =
            "CREATE TABLE  " + TABLE_NAME + " ( " +
                    IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    IMAGE_CATEGORY + " TEXT NOT NULL, " +
                    IMAGE_DATA + " BLOB NOT NULL);";

    public final static String IMAGE_SQL_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


}
