package sa.osama_alharbi.micro.orders.core.db.exception;

public class DB_Select_ListEmpty_Exception extends RuntimeException{
    public DB_Select_ListEmpty_Exception(String txt) {
        super(txt);
    }
    public DB_Select_ListEmpty_Exception() {
        super();
    }
}
