package class_project;

import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Main_dashboardController implements Initializable {
    
    @FXML
    private Button close;
    @FXML
    private Button minimize;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button manageItems_btn;
    @FXML
    private Button bookingTicket_btn;
    private Button customers_btn;
    @FXML
    private Button logout;
    private Button routes_btn;
    private Button drivers_btn;
    private AnchorPane cutomers_Form;
    @FXML
    private AnchorPane dashboard_Form;
    @FXML
    private AreaChart<?, ?> dashboard_income_chart;
    @FXML
    private AreaChart<?, ?> dashboard_visitors_chart;
    @FXML
    private Label dashboard_items;
    @FXML
    private Label dashboard_visitors;
    @FXML
    private Label dashboard_totalincome;
    @FXML
    private AnchorPane bookingTicket_Form;
    @FXML
    private TextField bookingTicket_firstName;
    @FXML
    private TextField bookingTicket_lastName;
    @FXML
    private ComboBox<?> bookingTicket_gender;
    @FXML
    private TextField bookingTicket_phoneNum;
    @FXML
    private Button bookingTicket_btn_select;
    @FXML
    private Button bookingTicket_btn_rest;
    private TextField bookingTicket_date;
    @FXML
    private TextField bookingTicket_emailAddress;
    @FXML
    private Label bookingTicket_l_fname;
    @FXML
    private Label bookingTicket_l_lname;
    @FXML
    private Label bookingTicket_l_gender;
    @FXML
    private Label bookingTicket_l_phoneNo;
    @FXML
    private Label bookingTicket_l_date;
    @FXML
    private Label bookingTicket_l_emailAdd;
    @FXML
    private Label bookingTicket_l_total;
    @FXML
    private Button bookingTicket_btn_receipt;
    private AnchorPane avilableB_Form;
    @FXML
    private TextField tfitemSource;
    private TextField tfitemDate;
    private TextField tfitemCatagory;
    @FXML
    private TextField tfitemName;
    @FXML
    private TextField tfItemId;
    @FXML
    private Button btnAddItem;
    @FXML
    private Button btnUpdateItem;
    @FXML
    private Button btnResetItem;
    @FXML
    private Button btnDeleteItem;
    @FXML
    private TextArea taitemDes;
    @FXML
    private TableView<Item> item_TableView;
    @FXML
    private TableColumn<Item, String> item_col_itemid;
    @FXML
    private TableColumn<Item, String> item_col_itemName;
    @FXML
    private TableColumn<Item, String> item_col_catagory;
    @FXML
    private TableColumn<Item, String> item_col_date;
    @FXML
    private TableColumn<Item, String> item_col_source;
    @FXML
    private TextField item_search;
    private AnchorPane drivers;
    @FXML
    private AnchorPane visitors_form;
    @FXML
    private AnchorPane manageStuff_form;
    @FXML
    private Button visitors_btn;
    @FXML
    private Button profile_btn;
    @FXML
    private AnchorPane profile_form;
    @FXML
    private AnchorPane manageItem_form;
    @FXML
    private Button manageStuff_btn;
    @FXML
    private TextField visitors_search;
    @FXML
    private TextField tfStaffPhone;
    @FXML
    private TextField tfStuffLname;
    @FXML
    private TextField tfStaffFname;
    @FXML
    private TextField tfStaffID;
    @FXML
    private Button btnAddStaff;
    @FXML
    private Button btnUpdateStaff;
    @FXML
    private Button btnResetStaff;
    @FXML
    private Button btnDeleteStaff;
    @FXML
    private ComboBox<?> cbStaffGender;
    @FXML
    private TextField tfStaffAddress;
    @FXML
    private TextField tfStaffEmail;
    @FXML
    
    private TableView<Staff> staff_tableview;
    @FXML
    private TableColumn<Staff, String> stuff_col_id;
    @FXML
    private TableColumn<Staff, String> stuff_col_fname;
    @FXML
    private TableColumn<Staff, String> stuff_col_lname;
    @FXML
    private TableColumn<Staff, String> stuff_col_gender;
    @FXML
    private TableColumn<Staff, String> stuff_col_address;
    @FXML
    private TableColumn<Staff, String> stuff_col_phone;
    @FXML
    private TableColumn<Staff, String> stuff_col_email;
    @FXML
    private TextField staff_search;
    @FXML
    
    private TableView<Visitor> visitors_tableView;
    @FXML
    private TableColumn<Visitor, String> visitors_col_fname;
    @FXML
    private TableColumn<Visitor, String> visitors_col_lname;
    @FXML
    private TableColumn<Visitor, String> visitors_col_gender;
    @FXML
    private TableColumn<Visitor, String> visitors_col_phone;
    @FXML
    private TableColumn<Visitor, String> visitors_col_email;
    @FXML
    private TableColumn<Visitor, String> visitors_col_payment;
    @FXML
    private Label dashboard_totalStaff;
    @FXML
    private TextField tfUserId;
    @FXML
    private Button profile_btnEdit;
    @FXML
    private Button profile_btnUpdate;
    @FXML
    private Button profile_btnReset;
    @FXML
    private TextField tfUserFname;
    @FXML
    private TextField tfUserLname;
    @FXML
    private TextField tfUserEmail;
    @FXML
    private TextField tfUserUsername;
    @FXML
    private TextField tfUserPassword;
    @FXML
    private ComboBox<?> bookingTicket_payment;
    @FXML
    private TableColumn<Visitor, String> visitors_col_visitorsid;
    @FXML
    private TextField tfVisitorFname;
    @FXML
    private TextField tfVisitorLname;
    @FXML
    private TextField tfVisitorPhone;
    @FXML
    private TextField tfVisitorEmail;
    private TextField tfVisitorDate;
    private TextField tfVisitorPayment;
    @FXML
    private ComboBox<?> cbVisitorSex;
    @FXML
    private TextField tfVisitorId;
    @FXML
    private TableColumn<Visitor, String> visitor_col_date;
    @FXML
    private ComboBox<?> cbVisitorPayment;
    @FXML
    private Label labelFname;
    @FXML
    private Label labelLname;
    @FXML
    private Label LabelEmail;
    @FXML
    private Label labelUserId;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPassword;
    @FXML
    private Label staffMarkLabel;
    @FXML
    private Label visitorMark2;
    @FXML
    private Label visitorMark1;
    @FXML
    private ComboBox<?> cbItemsCategory;
    @FXML
    private Label itemMark;
    private DatePicker testDate;
    @FXML
    private DatePicker tfitemdate;
    @FXML
    private DatePicker bpVisiteDate;
    @FXML
    private DatePicker bookingTicket_dp_date;
    @FXML
    private Label greetingLabel;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ItemData();
        staffData();
        VisitorData();
        comboBoxGender();
        comboBoxPayment();
        comboBoxItemCategory();
        ShowItemDAta();
        ShowVisitorData();
        start();
        
        
    }
    
    public void start() {
        countItems();
        countVisitors();
        countStaffs();
        totalIncome();
        dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#c98282,#494ee2)");
        greetingLabel.setText(getUserName());
    }
    // *******************Dashboard section *************************
    public void totalIncome() {
        String totalIncome = "SELECT payment FROM visitors";
        double sum = 0;
        Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(totalIncome);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                sum += Double.parseDouble(rs.getString("payment"));
            }
            dashboard_totalincome.setText(String.valueOf(sum + " ETB"));
        } catch (SQLException ex) {
            Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void countItems() {
        String totalItems = "SELECT itemid FROM items";
        int counter = 0;
        Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(totalItems);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                counter++;
            }
            dashboard_items.setText(String.valueOf(counter));
        } catch (SQLException ex) {
            Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void countVisitors() {
        String totalVisitors = "SELECT visitorid FROM visitors";
        int counter = 0;
        Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(totalVisitors);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                counter++;
            }
            dashboard_visitors.setText(String.valueOf(counter));
        } catch (SQLException ex) {
            Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void countStaffs() {
        String totalStaffs = "SELECT stuffid FROM staffs";
        int counter = 0;
        Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(totalStaffs);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                counter++;
            }
            dashboard_totalStaff.setText(String.valueOf(counter));
        } catch (SQLException ex) {
            Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getUserName(){
         String sql = "SELECT user FROM login";
         String userN="";
        Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet result = st.executeQuery();
            while(result.next()){
                userN = result.getString(1).toString();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userN;
    }
    
    @FXML
    public void displayProfile(){
        String name = getUserName();
        
         Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement("SELECT * FROM users WHERE username='"+name +"'");
            ResultSet result = st.executeQuery();
            while (result.next()) {
                labelUserId.setText(result.getString(1));
                labelFname.setText(result.getString(2).toUpperCase());
                labelLname.setText(result.getString(3).toUpperCase());
                LabelEmail.setText(result.getString(4));
                labelUsername.setText(result.getString(5));
                labelPassword.setText(result.getString(6));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @FXML
    public void userEdit() {
        tfUserId.setText(labelUserId.getText());
        tfUserFname.setText(labelFname.getText());
        tfUserLname.setText(labelLname.getText());
        tfUserEmail.setText(LabelEmail.getText());
        tfUserUsername.setText(labelUsername.getText());
        tfUserPassword.setText(labelPassword.getText());
    }
    
    @FXML
    public void userReset() {
        tfUserId.setText("");
        tfUserFname.setText("");
        tfUserLname.setText("");
        tfUserEmail.setText("");
        tfUserUsername.setText("");
        tfUserPassword.setText("");
    }
    
    @FXML
    public void userUpdate() {
        String name = getUserName();
        if (tfUserId.getText().isEmpty()
                || tfUserFname.getText().isEmpty()
                || tfUserLname.getText().isEmpty()
                || tfUserUsername.getText().isEmpty()
                || tfUserPassword.getText().isEmpty()) {

            return;
        } else {
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message!");
            alert.setHeaderText(null);
            alert.setContentText("Are You Sure?");
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get().equals(ButtonType.OK)) {
                
                Connection conn = DBconnection.connectDB();
                
                try {
                    PreparedStatement st = (PreparedStatement) conn.prepareStatement("UPDATE users SET fname=?,lname=?,email=?,username=?,password=? WHERE username = '"+name+"'");
                    st.setString(1, tfUserFname.getText());
                    st.setString(2, tfUserLname.getText());
                    st.setString(3, tfUserEmail.getText());
                    st.setString(4, tfUserUsername.getText());
                    st.setString(5, tfUserPassword.getText());
                    
                    st.executeUpdate();
                    
                    displayProfile();
                    userReset();
                    
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    // FOR MANAGE ITEMS FORM TABLE VIEW
    @FXML
    public void itemAdd() {
        if (tfItemId.getText().isEmpty()
                || tfitemName.getText().isEmpty()
                || cbItemsCategory.getSelectionModel().isEmpty()
                || tfitemdate.getValue().toString().isEmpty()
                || tfitemSource.getText().isEmpty()
                || taitemDes.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Fill all Fields Please!");
            alert.showAndWait();
            
        } else {
            String addItem = "INSERT INTO items (itemid,itemName,category,date,source,describtion) VALUES (?,?,?,?,?,?)";
            
            Connection conn = DBconnection.connectDB();
            try {// to check Item id is unique
                Connection connect = DBconnection.connectDB();
                PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM items WHERE itemid=" + tfItemId.getText());
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("Item ID Already Exist!");
                    alert.showAndWait();
                } else {
                    PreparedStatement st = (PreparedStatement) conn.prepareStatement(addItem);
                    st.setString(1, tfItemId.getText());
                    st.setString(2, tfitemName.getText());
                    st.setString(3, cbItemsCategory.getSelectionModel().getSelectedItem().toString());
                    st.setString(4, tfitemdate.getValue().toString());
                    st.setString(5, tfitemSource.getText());
                    st.setString(6, taitemDes.getText());
                    
                    int rs = st.executeUpdate();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("Item Inserted Successfully!!");
                    alert.showAndWait();
                    
                    itemReset();
                    ShowItemDAta();
                    
                    conn.close();
                    connect.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @FXML
    public void itemDelete() {
        
        String deleteItem = "DELETE FROM items WHERE  itemid ='" + tfItemId.getText() + "'";
        
        if (tfItemId.getText().isEmpty()
                || tfitemName.getText().isEmpty()
                || tfitemdate.getValue().toString().isEmpty()
                || tfitemSource.getText().isEmpty()) {
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Select The Item First!");
            alert.showAndWait();
            
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message!");
            alert.setHeaderText(null);
            alert.setContentText("Are You Sure?");
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get().equals(ButtonType.OK)) {
                Connection conn = DBconnection.connectDB();
                try {
                    PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteItem);
                    int rs = st.executeUpdate();
                    
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("Item Deleted Successfully!");
                    alert.showAndWait();
                    
                    itemReset();
                    ShowItemDAta();
                    
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return;
            }
            
        }
    }
    
    @FXML
    public void itemUpdate() {
        if (cbItemsCategory.getSelectionModel().isEmpty()) {
            itemMark.setText("*");
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("CHOOSE ITEM CATEGORY!!");
            alert.setTitle("!");
            alert.setHeaderText("");
            alert.showAndWait();
            
        } else {
            String updateItem = "UPDATE items SET itemName='" + tfitemName.getText()
                    + "',category='" + cbItemsCategory.getSelectionModel().getSelectedItem().toString()
                    + "',date='" + tfitemdate.getValue().toString()
                    + "',source='" + tfitemSource.getText()
                    + "',describtion='" + taitemDes.getText() + "' WHERE itemid='" + tfItemId.getText() + "'";

            //to vrrify the selection process 
            if (tfItemId.getText().isEmpty()
                    || tfitemName.getText().isEmpty()
                    || tfitemdate.getValue().toString().isEmpty()
                    || tfitemSource.getText().isEmpty()) {
                
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText(null);
                alert.setContentText("Select The Item First!");
                alert.showAndWait();
                
            } else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message!");
                alert.setHeaderText(null);
                alert.setContentText("Are You Sure?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if (option.get().equals(ButtonType.OK)) {
                    Connection conn = DBconnection.connectDB();
                    try {
                        PreparedStatement st = (PreparedStatement) conn.prepareStatement(updateItem);
                        int rs = st.executeUpdate();
                        
                        alert.setTitle("");
                        alert.setHeaderText(null);
                        alert.setContentText("Item Updated Successfully!");
                        alert.showAndWait();
                        
                        itemReset();
                        ShowItemDAta();
                        
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return;
                }
            }
        }
    }
    
    @FXML
    public void itemReset() {
        tfItemId.setText("");
        tfitemName.setText("");
        tfitemSource.setText("");
        taitemDes.setText("");
        itemMark.setText("");
    }
    //SEARCH METHODS 
    public void searchDatabase() {
        ObservableList<Item> itemsListData = FXCollections.observableArrayList();
        String searchKey = item_search.getText();

        // SQL query to retrieve items matching the search key
        String sql = "SELECT * FROM items WHERE itemid LIKE ? OR itemName LIKE ? OR category LIKE ? OR date LIKE ? OR source LIKE ? OR describtion LIKE ?";
        
        try (Connection conn = DBconnection.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Set the parameters for the prepared statement
            for (int i = 1; i <= 6; i++) {
                pstmt.setString(i, "%" + searchKey + "%");
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                // Assuming Item class has a constructor that matches the columns in your table
                Item item = new Item(rs.getString("itemid"), rs.getString("itemName"), rs.getString("category"), rs.getString("date"), rs.getString("source"), rs.getString("describtion"));
                itemsListData.add(item);
            }
            
            item_TableView.setItems(itemsListData); // Display the results in the TableView
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions such as no suitable driver found, SQL syntax errors, etc.
        }
    }
    
     public void visitorSearch() {
        ObservableList<Visitor> visitorsListData = FXCollections.observableArrayList();
        String searchKey = visitors_search.getText();

        // SQL query to retrieve items matching the search key
        String sql = "SELECT * FROM visitors WHERE visitorid LIKE ? OR fname LIKE ? OR lname LIKE ? OR sex LIKE ? OR phone LIKE ? OR email LIKE ? OR date LIKE ? OR payment LIKE ?";
        
        try {
             Connection conn = DBconnection.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the parameters for the prepared statement
            for (int i = 1; i <= 8; i++) {
                pstmt.setString(i, "%" + searchKey + "%");
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                // Assuming Item class has a constructor that matches the columns in your table
                Visitor visitor = new Visitor(rs.getString("visitorid"),
                        rs.getString("fname"),
                        rs.getString("lname"), 
                        rs.getString("sex"), 
                        rs.getString("phone"), 
                        rs.getString("email"),
                        rs.getString("date"),
                        rs.getString("payment"));
                visitorsListData.add(visitor);
            }
            
            visitors_tableView.setItems(visitorsListData); // Display the results in the TableView
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions such as no suitable driver found, SQL syntax errors, etc.
        }
    }
     
      public void staffSearch() {
        ObservableList<Staff> staffsListData = FXCollections.observableArrayList();
        String searchKey = staff_search.getText();

        // SQL query to retrieve items matching the search key
        String sql = "SELECT * FROM staffs WHERE stuffid LIKE ? OR fname LIKE ? OR lname LIKE ? OR sex LIKE ? OR phone LIKE ? OR address LIKE ? OR email LIKE ?";
        
        try {
             Connection conn = DBconnection.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            // Set the parameters for the prepared statement
            for (int i = 1; i <= 7; i++) {
                pstmt.setString(i, "%" + searchKey + "%");
            }
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                // Assuming Item class has a constructor that matches the columns in your table
                Staff staff = new Staff(rs.getString("stuffid"),
                        rs.getString("fname"),
                        rs.getString("lname"), 
                        rs.getString("sex"), 
                        rs.getString("phone"), 
                        rs.getString("address"),
                        rs.getString("email"));
                staffsListData.add(staff);
            }
            
            staff_tableview.setItems(staffsListData); // Display the results in the TableView
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions such as no suitable driver found, SQL syntax errors, etc.
        }
    }
    
    
    @FXML
    
    public ObservableList<Item> ItemData() {
        ObservableList<Item> ItemList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM items";
        
        Item ItemData;
        
        try {
            Connection conn = DBconnection.connectDB();
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ItemData = new Item(rs.getString("itemid"),
                        rs.getString("itemName"),
                        rs.getString("category"),
                        rs.getString("date"),
                        rs.getString("source"),
                        rs.getString("describtion"));
                ItemList.add(ItemData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ItemList;
    }
    
    private ObservableList<Item> ItemsListData;
    
    public void ShowItemDAta() {
        ItemsListData = ItemData();
        
        item_col_itemid.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        item_col_itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        item_col_catagory.setCellValueFactory(new PropertyValueFactory<>("category"));
        item_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        item_col_source.setCellValueFactory(new PropertyValueFactory<>("source"));
//        item_col_itemid.setCellValueFactory(new PropertyValueFactory<>("itemId"));  description column

        item_TableView.setItems(ItemsListData);
        
    }

    //when item data is selected ...
    @FXML
    public void SelectItemData() {
        Item ItemData = item_TableView.getSelectionModel().getSelectedItem();
        int num = item_TableView.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < -1) {
            return;
        }
        
        tfItemId.setText(String.valueOf(ItemData.getItemId()));
        tfitemName.setText(String.valueOf(ItemData.getItemName()));
//        tfitemCatagory.setText(String.valueOf(ItemData.getCategory()));
        tfitemdate.setValue(LocalDate.parse(String.valueOf(ItemData.getDate())));
        tfitemSource.setText(String.valueOf(ItemData.getSource()));
        taitemDes.setText(String.valueOf(ItemData.getDescription()));
    }

//**************************MANAGE staffs SECTION ************************
    @FXML
    public void staffAdd() {
        if (tfStaffID.getText().isEmpty()
                || tfStaffFname.getText().isEmpty()
                || tfStuffLname.getText().isEmpty()
                || cbStaffGender.getSelectionModel().getSelectedItem().toString().isEmpty()
                || tfStaffPhone.getText().isEmpty()
                || tfStaffAddress.getText().isEmpty()
                || tfStaffEmail.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Fill all Fields Please!");
            alert.showAndWait();
            
        } else {
            String addItem = "INSERT INTO staffs (stuffid,fname,lname,sex,phone,address,email) VALUES (?,?,?,?,?,?,?)";
            
            Connection conn = DBconnection.connectDB();
            try {// to check Item id is unique
                Connection connect = DBconnection.connectDB();
                PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM staffs WHERE stuffid=" + tfStaffID.getText());
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff ID Already Exist!");
                    alert.showAndWait();
                } else {
                    PreparedStatement st = (PreparedStatement) conn.prepareStatement(addItem);
                    st.setString(1, tfStaffID.getText());
                    st.setString(2, tfStaffFname.getText());
                    st.setString(3, tfStuffLname.getText());
                    st.setString(4, cbStaffGender.getSelectionModel().getSelectedItem().toString());
                    st.setString(5, tfStaffPhone.getText());
                    st.setString(6, tfStaffAddress.getText());
                    st.setString(7, tfStaffEmail.getText());
                    
                    int rs = st.executeUpdate();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("Item Inserted Successfully!!");
                    alert.showAndWait();
                    
                    staffReset();
                    ShowStaffData();
                    
                    conn.close();
                    connect.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @FXML
    public void staffReset() {
        tfStaffID.setText("");
        tfStaffFname.setText("");
        tfStuffLname.setText("");
        tfStaffPhone.setText("");
        tfStaffAddress.setText("");
        tfStaffEmail.setText("");
        staffMarkLabel.setText("");
    }
    
    @FXML
    public void staffUpdate() {
        
        int index = cbStaffGender.getSelectionModel().getSelectedIndex();
        if (index == 0 || index == 1) {
            String updateStaff = "UPDATE staffs SET fname='" + tfStaffFname.getText()
                    + "',lname='" + tfStuffLname.getText()
                    + "',sex='" + cbStaffGender.getSelectionModel().getSelectedItem().toString()
                    + "',phone='" + tfStaffPhone.getText()
                    + "',address='" + tfStaffAddress.getText()
                    + "',email='" + tfStaffEmail.getText() + "' WHERE stuffid='" + tfStaffID.getText() + "'";

            //to vrrify the selection process 
            if (tfStaffID.getText().isEmpty()
                    || tfStaffFname.getText().isEmpty()
                    || tfStuffLname.getText().isEmpty()
                    || tfStaffPhone.getText().isEmpty()
                    || tfStaffAddress.getText().isEmpty()
                    || tfStaffEmail.getText().isEmpty()) {
                
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText(null);
                alert.setContentText("Select The Staff Data First!");
                alert.showAndWait();
                
            } else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message!");
                alert.setHeaderText(null);
                alert.setContentText("Are You Sure?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if (option.get().equals(ButtonType.OK)) {
                    Connection conn = DBconnection.connectDB();
                    try {
                        PreparedStatement st = (PreparedStatement) conn.prepareStatement(updateStaff);
                        int rs = st.executeUpdate();
                        
                        alert.setTitle("");
                        alert.setHeaderText(null);
                        alert.setContentText("Staff Updated Successfully!");
                        alert.showAndWait();
                        
                        staffReset();
                        ShowStaffData();
                        
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return;
                }
                
            }
        } else {
            staffMarkLabel.setText("*");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("CHOOSE STAFF GENDER!");
            alert.setTitle("!");
            alert.setHeaderText("");
            alert.showAndWait();
        }
        
    }
    
    @FXML
    public void staffDelete() {
        
        String deleteItem = "DELETE FROM staffs WHERE  stuffid ='" + tfStaffID.getText() + "'";
        
        if (tfStaffID.getText().isEmpty()
                || tfStaffFname.getText().isEmpty()
                || tfStuffLname.getText().isEmpty()
                || tfStaffPhone.getText().isEmpty()
                || tfStaffAddress.getText().isEmpty()
                || tfStaffEmail.getText().isEmpty()) {
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Select The Item First!");
            alert.showAndWait();
            
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message!");
            alert.setHeaderText(null);
            alert.setContentText("Are You Sure?");
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get().equals(ButtonType.OK)) {
                Connection conn = DBconnection.connectDB();
                try {
                    PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteItem);
                    int rs = st.executeUpdate();
                    
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("Staff data Deleted Successfully!");
                    alert.showAndWait();
                    
                    staffReset();
                    ShowStaffData();
                    
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return;
            }
            
        }
    }

    //gender combo box fill array list
    private String[] genderList = {"Male", "Female"};
    private double[] paymentList = {10, 15, 20, 25, 30, 50, 100};
    private String[] categoryList = {"Archaeological", "Paintings and Artwork", "Historical Documents", "Weapons and Armor", "Ethnographic Objects"};
    
    @FXML
    public void comboBoxGender() {
        List<String> list = new ArrayList<>();
        for (String data : genderList) {
            list.add(data);
        }
        ObservableList listGender = FXCollections.observableArrayList(list);
        cbStaffGender.setItems(listGender);
        bookingTicket_gender.setItems(listGender);
        cbVisitorSex.setItems(listGender);
    }

    @FXML
    public void comboBoxPayment() {
        List<Double> list = new ArrayList<>();
        for (double data : paymentList) {
            list.add(data);
        }
        ObservableList listGender = FXCollections.observableArrayList(list);
        bookingTicket_payment.setItems(listGender);
        cbVisitorPayment.setItems(listGender);
    }

    @FXML
    public void comboBoxItemCategory() {
        List<String> list = new ArrayList<>();
        for (String data : categoryList) {
            list.add(data);
        }
        ObservableList listCategory = FXCollections.observableArrayList(list);
        cbItemsCategory.setItems(listCategory);
    }

    // main staff data
    public ObservableList<Staff> staffData() {
        ObservableList<Staff> staffList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM staffs";
        
        Staff staffData;
        
        try {
            Connection conn = DBconnection.connectDB();
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                staffData = new Staff(rs.getString("stuffid"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("sex"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("email"));
                
                staffList.add(staffData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffList;
    }

    // table select in staff table view
    @FXML
    public void SelectStaffData() {
        Staff staffData = staff_tableview.getSelectionModel().getSelectedItem();
        int num = staff_tableview.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < -1) {
            return;
        }
        
        tfStaffID.setText(String.valueOf(staffData.getStaffId()));
        tfStaffFname.setText(String.valueOf(staffData.getStaffFname()));
        tfStuffLname.setText(String.valueOf(staffData.getStaffLname()));
        cbStaffGender.getSelectionModel().select(cbStaffGender.getSelectionModel().getSelectedIndex());;
        tfStaffPhone.setText(String.valueOf(staffData.getStaffPhone()));
        tfStaffAddress.setText(String.valueOf(staffData.getStaffAddress()));
        tfStaffEmail.setText(String.valueOf(staffData.getStaffEmail()));
    }

    //show staff data in table 
    private ObservableList<Staff> staffsListData;
    
    public void ShowStaffData() {
        staffsListData = staffData();
        
        stuff_col_id.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        stuff_col_fname.setCellValueFactory(new PropertyValueFactory<>("staffFname"));
        stuff_col_lname.setCellValueFactory(new PropertyValueFactory<>("staffLname"));
        stuff_col_gender.setCellValueFactory(new PropertyValueFactory<>("staffGender"));
        stuff_col_address.setCellValueFactory(new PropertyValueFactory<>("staffAddress"));
        stuff_col_phone.setCellValueFactory(new PropertyValueFactory<>("staffPhone"));
        stuff_col_email.setCellValueFactory(new PropertyValueFactory<>("staffEmail"));
        
        staff_tableview.setItems(staffsListData);
        
    }

    //************************ BOOKING TICKET SECTION *************************//
    // main visitor data
    public ObservableList<Visitor> VisitorData() {
        ObservableList<Visitor> visitorList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM visitors";
        
        Visitor visitorData;
        
        try {
            Connection conn = DBconnection.connectDB();
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                visitorData = new Visitor(String.valueOf(rs.getInt("visitorid")),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("sex"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("date"),
                        rs.getString("payment"));
                
                visitorList.add(visitorData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visitorList;
    }

    //select visitor table view
    @FXML
    public void selectVisitorData() {
        Visitor visitorData = visitors_tableView.getSelectionModel().getSelectedItem();
        int num = visitors_tableView.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < -1) {
            return;
        }
        tfVisitorId.setText(String.valueOf(visitorData.getVisitorId()));
        tfVisitorFname.setText(String.valueOf(visitorData.getVisitorFname()));
        tfVisitorLname.setText(String.valueOf(visitorData.getVisitorLname()));
        tfVisitorPhone.setText(String.valueOf(visitorData.getVisitorPhone()));
//        cbVisitorSex.getSelectionModel().(String.valueOf(staffData.getStaffGender()));
        tfVisitorEmail.setText(String.valueOf(visitorData.getVisitorEmail()));
//        tfVisitorPayment.setText(String.valueOf(visitorData.getVisitorPayment()));
        bpVisiteDate.setValue(LocalDate.parse(String.valueOf(visitorData.getVisitorVisitDate())));
    }

    //show staff data in table 
    private ObservableList<Visitor> visitorsListData;
    
    public void ShowVisitorData() {
        visitorsListData = VisitorData();
        
        visitors_col_visitorsid.setCellValueFactory(new PropertyValueFactory<>("visitorId"));
        visitors_col_fname.setCellValueFactory(new PropertyValueFactory<>("visitorFname"));
        visitors_col_lname.setCellValueFactory(new PropertyValueFactory<>("visitorLname"));
        visitors_col_gender.setCellValueFactory(new PropertyValueFactory<>("visitorGender"));
        visitors_col_phone.setCellValueFactory(new PropertyValueFactory<>("visitorPhone"));
        visitors_col_email.setCellValueFactory(new PropertyValueFactory<>("visitorEmail"));
        visitor_col_date.setCellValueFactory(new PropertyValueFactory<>("visitorVisitDate"));
        visitors_col_payment.setCellValueFactory(new PropertyValueFactory<>("VisitorPayment"));
        
        visitors_tableView.setItems(visitorsListData);
        
    }
    
    @FXML
    public void visitorAdd() {
        if (bookingTicket_firstName.getText().isEmpty()
                || bookingTicket_lastName.getText().isEmpty()
                || bookingTicket_phoneNum.getText().isEmpty()
                || bookingTicket_gender.getSelectionModel().getSelectedItem().toString().isEmpty()
                || bookingTicket_emailAddress.getText().isEmpty()
                || bookingTicket_dp_date.getValue().toString().isEmpty()
                ||bookingTicket_payment.getSelectionModel().getSelectedItem().toString().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Fill all Fields Please!");
            alert.showAndWait();
            
        } else {
            String addItem = "INSERT INTO visitors (visitorid,fname,lname,sex,phone,email,date,payment) VALUES (?,?,?,?,?,?,?,?)";
            
            Connection conn = DBconnection.connectDB();
            try {// to check Item id is unique
//                   Random
                PreparedStatement st = (PreparedStatement) conn.prepareStatement(addItem);
                st.setInt(1, 0);
                st.setString(2, bookingTicket_firstName.getText());
                st.setString(3, bookingTicket_lastName.getText());
                st.setString(4, bookingTicket_gender.getSelectionModel().getSelectedItem().toString());
                st.setString(5, bookingTicket_phoneNum.getText());
                st.setString(6, bookingTicket_emailAddress.getText());
                st.setString(7, bookingTicket_dp_date.getValue().toString());
                st.setString(8, bookingTicket_payment.getSelectionModel().getSelectedItem().toString());
                
                int rs = st.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText(null);
                alert.setContentText("Visitor Added Successfully!!");
                alert.showAndWait();

                //visito's summery at the bottom
                bookingTicket_l_fname.setText(bookingTicket_firstName.getText());
                bookingTicket_l_lname.setText(bookingTicket_lastName.getText());
                bookingTicket_l_gender.setText(bookingTicket_gender.getSelectionModel().getSelectedItem().toString());
                bookingTicket_l_emailAdd.setText(bookingTicket_emailAddress.getText());
                bookingTicket_l_phoneNo.setText(bookingTicket_phoneNum.getText());
                bookingTicket_l_date.setText(bookingTicket_dp_date.getValue().toString());
                bookingTicket_l_total.setText(bookingTicket_payment.getSelectionModel().getSelectedItem().toString() + " ETB");
                
                visitorReset();
//                    ShowVisitorData();

                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @FXML
    public void visitorDelete() {
        String deleteItem = "DELETE FROM visitors WHERE  visitorid ='" + tfVisitorId.getText() + "'";
        
        if (bpVisiteDate.getValue().toString().isEmpty()
                || tfVisitorFname.getText().isEmpty()
                || tfVisitorLname.getText().isEmpty()
                || tfVisitorPhone.getText().isEmpty()
                || tfVisitorEmail.getText().isEmpty()) {
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Select The Visitor Data First!");
            alert.showAndWait();
            
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message!");
            alert.setHeaderText(null);
            alert.setContentText("Are You Sure?");
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get().equals(ButtonType.OK)) {
                Connection conn = DBconnection.connectDB();
                try {
                    PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteItem);
                    int rs = st.executeUpdate();
                    
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText(null);
                    alert.setContentText("Visitor data Deleted Successfully!");
                    alert.showAndWait();
                    
                    visitorReset();
                    ShowVisitorData();
                    
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return;
            }
            
        }
    }
    
    @FXML
    public void visitorUpdate() {
        if (cbVisitorPayment.getSelectionModel().isEmpty() || cbVisitorSex.getSelectionModel().isEmpty()) {
            visitorMark1.setText("*");
            visitorMark2.setText("*");
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("CHOOSE VISITOR GENDER/PAYMENT PLEASE!!");
            alert.setTitle("!");
            alert.setHeaderText("");
            alert.showAndWait();
            
        } else {
            String updateStaff = "UPDATE visitors SET fname='" + tfVisitorFname.getText()
                    + "',lname='" + tfVisitorLname.getText()
                    + "',sex='" + cbVisitorSex.getSelectionModel().getSelectedItem().toString()
                    + "',phone='" + tfVisitorPhone.getText()
                    + "',date='" + bpVisiteDate.getValue().toString()
                    + "',payment='" + cbVisitorPayment.getSelectionModel().getSelectedItem().toString()
                    + "',email='" + tfVisitorEmail.getText() + "' WHERE visitorid='" + tfVisitorId.getText() + "'";

            //to vrrify the selection process 
            if (bpVisiteDate.getValue().toString().isEmpty()
                    || tfVisitorFname.getText().isEmpty()
                    || tfVisitorLname.getText().isEmpty()
                    || tfVisitorPhone.getText().isEmpty()
                    || tfVisitorEmail.getText().isEmpty()) {
                
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText(null);
                alert.setContentText("Select The Visitor Data First!");
                alert.showAndWait();
                
            } else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message!");
                alert.setHeaderText(null);
                alert.setContentText("Are You Sure?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if (option.get().equals(ButtonType.OK)) {
                    Connection conn = DBconnection.connectDB();
                    try {
                        PreparedStatement st = (PreparedStatement) conn.prepareStatement(updateStaff);
                        int rs = st.executeUpdate();
                        
                        alert.setTitle("");
                        alert.setHeaderText(null);
                        alert.setContentText("Visitor Updated Successfully!");
                        alert.showAndWait();
                        
                        visitorReset();
                        ShowVisitorData();
                        
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return;
                }
                
            }
        }
        
    }
    
    @FXML
    public void visitorReset() {
        bookingTicket_firstName.setText("");
        bookingTicket_lastName.setText("");
        bookingTicket_phoneNum.setText("");
        bookingTicket_emailAddress.setText("");
//        bookingTicket_dp_date.setValue(LocalDate.parse(""));
        
        tfVisitorFname.setText("");
        tfVisitorLname.setText("");
        tfVisitorPhone.setText("");
        tfVisitorEmail.setText("");
//        bpVisiteDate.setValue(LocalDate.parse(""));
        tfVisitorId.setText("");
        visitorMark1.setText("");
        visitorMark2.setText("");
    }
    
    @FXML
    private void close(ActionEvent event) {
        closeAction();
   
        
    }
    
    public void closeAction() {
        loggedOutUser();
        System.exit(0);
         
    }
    
    @FXML
    private void minimize(ActionEvent event) {
        Stage stage = (Stage) dashboard_Form.getScene().getWindow();
        stage.setIconified(true);
    }
    
    

    @FXML
    public void switchForm(ActionEvent event) {
        
        if (event.getSource() == dashboard_btn) {
            
            dashboard_Form.setVisible(true);
            manageStuff_form.setVisible(false);
            bookingTicket_Form.setVisible(false);
            visitors_form.setVisible(false);
            profile_form.setVisible(false);
            manageItem_form.setVisible(false);
            
            start();
            
            bookingTicket_btn.setStyle("-fx-background-color:transparent");
            visitors_btn.setStyle("-fx-background-color:transparent");
            manageItems_btn.setStyle("-fx-background-color:transparent");
            dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#c98282,#494ee2)");
            manageStuff_btn.setStyle("-fx-background-color:transparent");
            profile_btn.setStyle("-fx-background-color:transparent");
            
        } else if (event.getSource() == manageItems_btn) {
            dashboard_Form.setVisible(false);
            manageItem_form.setVisible(true);
            bookingTicket_Form.setVisible(false);
            visitors_form.setVisible(false);
            manageStuff_form.setVisible(false);
            profile_form.setVisible(false);
            
            bookingTicket_btn.setStyle("-fx-background-color:transparent");
            visitors_btn.setStyle("-fx-background-color:transparent");
            manageItems_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#c98282,#494ee2)");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            manageStuff_btn.setStyle("-fx-background-color:transparent");
            profile_btn.setStyle("-fx-background-color:transparent");
            
            ItemData();
            ShowItemDAta();//to refreash item view table
//            itemSearch();
          
            
        } else if (event.getSource() == visitors_btn) {
            dashboard_Form.setVisible(false);
            manageItem_form.setVisible(false);
            bookingTicket_Form.setVisible(false);
            visitors_form.setVisible(true);
            manageStuff_form.setVisible(false);
            profile_form.setVisible(false);
            
            ShowVisitorData();
            VisitorData();
            bookingTicket_btn.setStyle("-fx-background-color:transparent");
            visitors_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#c98282,#494ee2)");
            manageStuff_btn.setStyle("-fx-background-color:transparent");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            manageItems_btn.setStyle("-fx-background-color:transparent");
            profile_btn.setStyle("-fx-background-color:transparent");
            
        } else if (event.getSource() == bookingTicket_btn) {
            dashboard_Form.setVisible(false);
            manageItem_form.setVisible(false);
            bookingTicket_Form.setVisible(true);
            visitors_form.setVisible(false);
            manageStuff_form.setVisible(false);
            profile_form.setVisible(false);
            
            bookingTicket_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#c98282,#494ee2)");
            visitors_btn.setStyle("-fx-background-color:transparent");
            manageStuff_btn.setStyle("-fx-background-color:transparent");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            manageItems_btn.setStyle("-fx-background-color:transparent");
            profile_btn.setStyle("-fx-background-color:transparent");
            
        } else if (event.getSource() == manageStuff_btn) {
            dashboard_Form.setVisible(false);
            manageItem_form.setVisible(false);
            bookingTicket_Form.setVisible(false);
            visitors_form.setVisible(false);
            manageStuff_form.setVisible(true);
            profile_form.setVisible(false);
            
            staffData();
            ShowStaffData();
            
            bookingTicket_btn.setStyle("-fx-background-color:transparent");
            manageItems_btn.setStyle("-fx-background-color:transparent");
            visitors_btn.setStyle("-fx-background-color:transparent");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            manageStuff_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#c98282,#494ee2)");
            profile_btn.setStyle("-fx-background-color:transparent");
            
        } else if (event.getSource() == profile_btn) {
            dashboard_Form.setVisible(false);
            manageItem_form.setVisible(false);
            bookingTicket_Form.setVisible(false);
            visitors_form.setVisible(false);
            manageStuff_form.setVisible(false);
            profile_form.setVisible(true);
            
            displayProfile();
            
            bookingTicket_btn.setStyle("-fx-background-color:transparent");
            visitors_btn.setStyle("-fx-background-color:transparent");
            manageStuff_btn.setStyle("-fx-background-color:transparent");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            profile_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,#c98282,#494ee2)");
            manageItems_btn.setStyle("-fx-background-color:transparent");
            
        }
    }
    private double x = 0;
    private double y = 0;
    
    @FXML
    private void logout(ActionEvent event) throws IOException {
        loggedOutUser();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        
        Optional<ButtonType> option = alert.showAndWait();
        
        if (option.get().equals((ButtonType.OK))) {
            
            try {
                dashboard_btn.getScene().getWindow().hide();// to hide the dashboard afeter the logout btn is clicked

                Parent root = FXMLLoader.load(getClass().getResource("userLoginView.fxml"));
                Stage stage = new Stage();
                
                root.setOnMouseDragged(e -> {
                    x = e.getScreenX();
                    y = e.getScreenY();
                });
                
                root.setOnMouseDragged(e -> {
                    stage.setX(e.getScreenX() - x);
                    stage.setY(e.getScreenX() - y);
                });
                
                stage.initStyle(StageStyle.TRANSPARENT);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
     public void loggedOutUser() {
        //delete user data from login table after logout
        String sql = "DELETE FROM login";
        Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);

            st.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
