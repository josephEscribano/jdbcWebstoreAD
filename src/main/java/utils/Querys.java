package utils;

public class Querys {
    public static final String SELECT_CUSTOMERS_QUERY = "select * from Customers";
    public static final String SELECT_CUSTOMER_BY_ID_QUERY = "select * from Customers where idCustomer = ?";
    public static final String SELECT_ITEMS_QUERY = "select * from Items";
    public static final String SELECT_ITEM_BY_ID_QUERY = "select * from Items where idItem = ?";
    public static final String SELECT_PURCHASE_BY_DATE_QUERY = "select idPurchase,date,C.idCustomer,C.name,C.telephone,C.address,I.idItem,I.name,I.company,I.price\n" +
            "from Purchases inner join (Customers C,Items I) on Purchases.idCustomer = C.idCustomer and Purchases.idItem = I.idItem where date = ?";
    public static final String SELECT_PURCHASES_QUERY = "select idPurchase,date,C.idCustomer,C.name,C.telephone,C.address,I.idItem,I.name,I.company,I.price\n" +
            "from Purchases inner join (Customers C,Items I) on Purchases.idCustomer = C.idCustomer and Purchases.idItem = I.idItem";
    public static final String SELECT_PURCHASES_BY_ITEM_QUERY = "select idPurchase,date,C.idCustomer,C.name,C.telephone,C.address,I.idItem,I.name,I.company,I.price\n" +
            "from Purchases inner join (Customers C,Items I) on Purchases.idCustomer = C.idCustomer and Purchases.idItem = I.idItem\n" +
            "where I.idItem = ?";
    public static final String SELECT_PURCHASES_BY_CUSTOMER_QUERY = "select idPurchase,date,C.idCustomer,C.name,C.telephone,C.address,I.idItem,I.name,I.company,I.price\n" +
            "from Purchases inner join (Customers C,Items I) on Purchases.idCustomer = C.idCustomer and Purchases.idItem = I.idItem where C.idCustomer = ? ";
    public static final String SELECT_PURCHASE_IN_REVIEW_QUERY = "select Purchases.idPurchase,Purchases.date,C.idCustomer,C.name,C.telephone,C.address,I.idItem,I.name,I.company,I.price\n" +
            "from Purchases inner join (Customers C,Items I,Reviews R ) on Purchases.idCustomer = C.idCustomer and Purchases.idItem = I.idItem and Purchases.idPurchase = R.idPurchase where R.idPurchase = ?";
    public static final String INSERT_CUSTOMER_QUERY ="INSERT INTO Customers (name,telephone,address) values(?,?,?)";
    public static final String INSERT_PURCHASE_QUERY = "INSERT INTO Purchases (date,idCustomer,idItem) values(?,?,?)";
    public static final String INSERT_ITEM_QUERY = "INSERT INTO Items (name,company,price) values(?,?,?)";
    public static final String UPDATE_CUSTOMER_QUERY = "update Customers set name = ?, telephone = ?, address = ? where idCustomer= ? ";
    public static final String UPDATE_ITEM_QUERY = "update Items set name = ?, company = ?, price = ? where idItem = ?";
    public static final String UPDATE_PURCHASES_QUERY = "update Purchases set date = ? where idPurchase = ?";
    public static final String DELETE_CUSTOMER_QUERY = "DELETE from Customers where idCustomer = ?";
    public static final String DELETE_PURCHASE_QUERY = "DELETE from Purchases where idPurchase = ?";
    public static final String DELETE_PURCHASES_BY_IDITEM_QUERY = "DELETE from Purchases where idItem = ?";
    public static final String DELETE_ITEM_QUERY = "DELETE from Items where idItem = ?";


}
