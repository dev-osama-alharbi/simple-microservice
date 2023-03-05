package sa.osama_alharbi.micro.orders.core.db.exception;

public class DB_Insert_AlreadyExists_Exception extends RuntimeException{
    public DB_Insert_AlreadyExists_Exception(String txt) {
        super(txt);
    }
    public DB_Insert_AlreadyExists_Exception() {
        super();
    }
}
