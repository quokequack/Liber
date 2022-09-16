import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database{
    private Connection connection;

    public Database(){
        this.connection = FabricCon.createConnection();
    }
    public void CreateTables() throws SQLException{
        String createEmployee = "CREATE TABLE IF NOT EXISTS EMPLOYEE"+
        "(CODE_EMPLOYEE INT(4) PRIMARY KEY,"+
        "NAME_EMPLOYEE CHAR(40),"+
        "POST_EMPLOYEE CHAR(40),"+
        "ADRESS_EMPLOYEE CHAR(60))";
        PreparedStatement stmt = connection.prepareStatement(createEmployee);
        stmt.executeUpdate(createEmployee);

        String createBookstore = "CREATE TABLE IF NOT EXISTS BOOKSTORE"+
        "(CODE_BOOKSTORE INT(14) PRIMARY KEY,"+
        "NAME_BOOKSTORE CHAR(40),"+
        "ADRESS_BOOKSTORE CHAR(60),"+
        "EMPLOYEE INT(4),"+
        "FOREIGN KEY (MANAGER) REFERENCES EMPLOYEE (CODE_EMPLOYEE))";
        PreparedStatement stmt2 = connection.prepareStatement(createBookstore);
        stmt2.executeUpdate(createBookstore);

        String createWriter = "CREATE TABLE IF NOT EXISTS WRITER"+
        "(CODE_WRITER INT(11) PRIMARY KEY,"+
        "NAME_WRITER CHAR(60), "+
        "GENDER_WRITER CHAR(15), "+
        "LITERARY_GENDER CHAR (50),"+
        "COUNTRY_WRITER CHAR(30))";
        PreparedStatement stmt3 = connection.prepareStatement(createWriter);
        stmt3.executeUpdate(createWriter);

        String createBook = "CREATE TABLE IF NOT EXISTS BOOK"+
        "(CODE_BOOK INT(6) PRIMARY KEY,"+
        "NAME_BOOK CHAR(60),"+
        "PRICE_BOOK DECIMAL(5,2),"+
        "PUBLISHING_COMPANY CHAR(50),"+
        "PUBLISH_DATE DATE,"+
        "GENRE_BOOK CHAR(50),"+
        "WRITER INT(11),"+
        "FOREIGN KEY (WRITER) REFERENCES WRITER(CODE_WRITER))";
        PreparedStatement stmt4 = connection.prepareStatement(createBook);
        stmt4.executeUpdate(createBook);

        String createClient = "CREATE TABLE IF NOT EXISTS CLIENT"+
        "(CODE_CLIENT INT(4) PRIMARY KEY,"+
        "NAME_CLIENT CHAR(60),"+
        "ADRESS_CLIENT CHAR(60))";
        PreparedStatement stmt5 = connection.prepareStatement(createClient);
        stmt5.executeUpdate(createClient);

        String createSale = "CREATE TABLE IF NOT EXISTS SALE"+
        "(CODE_SALE INT(4) PRIMARY KEY,"+
        "PAYMENT CHAR(20),"+
        "TOTAL SALE DECIMAL(5,2),"+
        "BOOK INT(6),"+
        "EMPLOYEE INT(4),"+
        "CLIENT INT(4),"+
        "FOREIGN KEY (BOOK) REFERENCES BOOK(CODE_BOOK),"+
        "FOREIGN KEY (SELLER) REFERENCES EMPLOYEE(CODE_EMPLOYEE),"+
        "FOREIGN KEY (CLIENT) REFERENCES CLIENT(CODE_CLIENT))";
        PreparedStatement stmt6 = connection.prepareStatement(createSale);
        stmt6.executeUpdate(createSale);

        String value = "INSERT INTO EMPLOYEE (CODE_EMPLOYEE, NAME_EMPLOYEE, POST_EMPLOYEE, ADRESS_EMPLOYEE)"+"VALUES(?,?,?,?)";
        PreparedStatement stmt7 = connection.prepareStatement(value);
        stmt7.setInt(1, 001);
        stmt7.setString(2, "Ana Paula");
        stmt7.setString(3, "Gerente");
        stmt7.setString(4, "11th Street Brooklyn New York");
        stmt7.execute();
    }
}
