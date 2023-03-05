package sa.osama_alharbi.micro.orders.core.db.exception;

public class DB_Column_Error_Exception extends RuntimeException{
    public DB_Column_Error_Exception(String txt) {
        super(txt);
    }
    public DB_Column_Error_Exception() {
        super();
    }
}
