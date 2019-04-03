package Models;

import java.security.PrivateKey;
import java.sql.*;
import java.util.ArrayList;

public class DBInventory implements Inventory{
    private final String DB_URL = "jdbc:derby:DoorknobDB;create=true";
    private ArrayList<Product> productList = new ArrayList<>();

    private static DBInventory DBINVENTORY = new DBInventory();

    public static DBInventory getInstance(){return DBINVENTORY;}

    private DBInventory(){
        try{


            Connection conn = DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Coffee table.
            buildProductTable(conn);


            buildCartTable(conn);

            populateList(conn);

            conn.close();


        }
            catch(Exception e){
        }
    }
    private static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Product");
                System.out.println("Product table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("Cart table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void buildProductTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Product (" +
                    "ProdNum INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "+
                    "Name VARCHAR(25)," +
                    "ShortDesc VARCHAR(40)," +
                    "LongDesc CLOB," +
                    "Price DOUBLE " +
                    ")");

            stmt.executeUpdate("INSERT INTO Product VALUES" +
                    "(default, 'Brass Knob', 'A knob made of premium brass'," +
                    " 'A classic style knob made of the finest swiss brass', 5.99 )");
            stmt.executeUpdate("INSERT INTO Product VALUES" +
                    "(default, 'Glass Knob', 'A luxurious glass knob'," +
                    " 'A knob crafted by the finest glassblower in all of Mozambique', 8.99 )");
            stmt.executeUpdate("INSERT INTO Product VALUES" +
                    "(default, 'Stainless Steel Knob', 'A sleek modern knob'," +
                    " 'A fresh new style of knob made of 100% recycled railroad steel', 7.99 )");
            System.out.println("Product table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCustomerTable method creates the
     * Customer table and adds some rows to it.
     */
    private static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Cart" +
                    "( CartItemNum INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "  ProdNum INT NOT NULL)");

            System.out.println("Cart table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    private void populateList(Connection conn) {
        {
            try {

                Statement stmt = conn.createStatement();
                String sql;
                sql = "SELECT ProdNum, Name, ShortDesc, LongDesc, Price FROM Product";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    productList.add(new Product(rs.getString("Name"), rs.getString("ShortDesc"), rs.getString("LongDesc"), rs.getDouble("Price")));
                }

                rs.close();
                stmt.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


