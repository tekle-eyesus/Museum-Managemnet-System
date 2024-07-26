package class_project;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserLoginViewController implements Initializable {

    @FXML
    private PasswordField tfpassword;
    @FXML
    private TextField tfusername;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btnclose;
    @FXML
    private ImageView image;
    @FXML
    private AnchorPane login_form;
    @FXML
    private Button btnlogin11;
    @FXML
    private AnchorPane register_form;
    @FXML
    private TextField tfUserLname;
    @FXML
    private TextField tfUserFname;
    @FXML
    private TextField tfUserEmail;
    @FXML
    private TextField tfUserUsername;
    @FXML
    private TextField tfUserPassword;
    @FXML
    private Button btnBackToLogin;
    @FXML
    private Button btnUserRegister;
    @FXML
    private Button btnRegister;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void userlogin(ActionEvent event) throws IOException {
        userLogin();
    }

    private double x = 0;
    private double y = 0;

    public void userLogin() throws IOException {
        Alert alert;
//        UserData user1;

        try {
            if (tfusername.getText().isEmpty() || tfpassword.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error message");
                alert.setHeaderText(null);
                alert.setContentText("please fill blank fields");
                alert.showAndWait();
            } else {
                Connection conn = (Connection) DBconnection.connectDB();
                String sql = "SELECT * FROM users WHERE username=? and password=?";
                PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
                st.setString(1, tfusername.getText());
                st.setString(2, tfpassword.getText());
                ResultSet rs = (ResultSet) st.executeQuery();
                if (rs.next()) {

                    loggedInUser(rs.getInt(1), rs.getString(5), rs.getString(6));

//                display the dashboard
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Imformation message");
                    alert.setHeaderText(null);
                    alert.setContentText("succssfully login!");
                    alert.showAndWait();

                    btnlogin.getScene().getWindow().hide();  //to hide the login window after successfull login

                    Parent root = FXMLLoader.load(getClass().getResource("main_dashboard.fxml"));//welcome page displayed
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMouseDragged((MouseEvent event) -> {
                        x = event.getScreenX();
                        y = event.getScreenY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error message");
                    alert.setHeaderText(null);
                    alert.setContentText("wrong password/username");
                    alert.showAndWait();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == btnBackToLogin) {
            login_form.setVisible(true);
            register_form.setVisible(false);
        } else if (event.getSource() == btnRegister) {
            register_form.setVisible(true);
            login_form.setVisible(false);
        }
    }

    public void userRegister() {
        if (tfUserFname.getText().isEmpty()
                || tfUserLname.getText().isEmpty()
                || tfUserEmail.getText().isEmpty()
                || tfUserUsername.getText().isEmpty()
                || tfUserPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Fill all Fields Please!");
            alert.showAndWait();

        } else {
            String addItem = "INSERT INTO users (user_id,fname,lname,email,username,password) VALUES (?,?,?,?,?,?)";

            Connection conn = DBconnection.connectDB();
            try {// to check Item id is unique
                PreparedStatement st = (PreparedStatement) conn.prepareStatement(addItem);
                st.setInt(1, 0);
                st.setString(2, tfUserFname.getText());
                st.setString(3, tfUserLname.getText());
                st.setString(4, tfUserEmail.getText());
                st.setString(5, tfUserUsername.getText());
                st.setString(6, tfUserPassword.getText());

                int rs = st.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText(null);
                alert.setContentText("User Data Inserted Successfully!!");
                alert.showAndWait();

                userReset();
                //switch to login form arter successfull register

                login_form.setVisible(true);
                register_form.setVisible(false);

                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(Main_dashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void userReset() {
        tfUserFname.setText("");
        tfUserLname.setText("");
        tfUserEmail.setText("");
        tfUserUsername.setText("");
        tfUserPassword.setText("");
    }

    @FXML
    private void closeAction(ActionEvent event) {
        close();
    }

    public void close() {
        System.exit(0);
    }

    private void loggedInUser(int userI, String userN, String userP) {
        //Store logged in user into login table 
        String sql = "INSERT INTO login VALUES (?,?,?)";
        Connection conn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);

            st.setInt(1, userI);
            st.setString(2, userN);
            st.setString(3, userP);

            st.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserLoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
