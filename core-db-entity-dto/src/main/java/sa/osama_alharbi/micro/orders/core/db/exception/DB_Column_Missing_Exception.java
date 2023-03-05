package sa.osama_alharbi.micro.orders.core.db.exception;

public class DB_Column_Missing_Exception extends RuntimeException{
    public DB_Column_Missing_Exception(String txt) {
        super(txt);
    }
    public DB_Column_Missing_Exception() {
        super();
    }
}
