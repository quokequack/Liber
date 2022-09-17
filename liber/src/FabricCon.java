import java.sql.*;

public class FabricCon{
    public static Connection createConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/liber","root","");
        }catch(SQLException e){
            throw new RuntimeException("A conexão não pôde ser estabelecida. Erro: "+ e);
        }
    }
}