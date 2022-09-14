import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database{
    private Connection connection;

    public Database(){
        this.connection = FabricCon.createConnection();
    }
    public void CreateTables() throws SQLException{
        String createBook = "CREATE TABLE IF NOT EXISTS BOOK"+
    }
}
