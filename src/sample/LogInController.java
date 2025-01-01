package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class LogInController {
    @FXML
    private Button btnLogin;
    @FXML
    private Hyperlink hypSignUp;
    @FXML
    private TextField txtUsernameLogin;
    @FXML
    private PasswordField txtPasswordLogin;
    @FXML
    private Label lblLoginMessage;
    @FXML
    private Label UserNameAccounts;



    public void btnLoginAction(ActionEvent actionEvent) {
        if((txtUsernameLogin.getText().isBlank()) && (txtPasswordLogin.getText().isBlank())){
            lblLoginMessage.setText("Please enter username and password.");
        }else{
            valideLogin();
        }

    }
    public void valideLogin(){
        DbConnection connectNow = new DbConnection();
        Connection conn = connectNow.getConnexion();
        String sqlVerified = "SELECT COUNT(1) FROM usersaccounts WHERE UserName = '" + txtUsernameLogin.getText() + "' AND Password = '" + txtPasswordLogin.getText() + "';";

        try{
            Statement stmt=conn.createStatement();
            ResultSet res = stmt.executeQuery(sqlVerified);
            while(res.next()){
                if(res.getInt(1)==1){
                    openLibrary();
//                    UserNameAccounts.setText(txtUsernameLogin.getText());
//                    System.out.println(UserNameAccounts.getText());

                      }else {lblLoginMessage.setText("Login or password is incorrect. Please try again.");}

                }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }










public void openLibrary(){
    try{
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxmlFile/bib1.fxml")));
        Stage p = new Stage();
        p.setTitle("library");
        p.setScene(new Scene(root,1050,700));
        p.show();
        Stage currentStag = (Stage) btnLogin.getScene().getWindow();
        currentStag.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

    public void HypSignUpAction(ActionEvent e) {
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxmlFile/SignUp.fxml")));


            Stage p = new Stage();
            p.setTitle("Library");
            p.setScene(new Scene(root, 600, 500));
            p.show();


            Stage currentStage = (Stage) hypSignUp.getScene().getWindow();
            currentStage.close();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }


}
