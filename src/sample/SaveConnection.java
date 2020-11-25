package sample;

public class SaveConnection {
    private static SaveConnection INSTANCE;
    public DB_Work[] dbWorks;

    private SaveConnection(DB_Work[] db) {
        dbWorks=db;
    }

    public static SaveConnection getInstance(DB_Work[] db) {
        if (INSTANCE == null) {
            INSTANCE = new SaveConnection(db);
        }
        return INSTANCE;
    }

    public static SaveConnection getInstance() {
        return INSTANCE;
    }
}

