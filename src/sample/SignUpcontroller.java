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

public class SignUpcontroller {

    @FXML
    private Button btnSignup;

    @FXML
    private Hyperlink hyplogin;

    @FXML
    private Label lblEreursignup;

    @FXML
    private TextField txtFirstNameSignup;

    @FXML
    private TextField txtLastNameSignup;

    @FXML
    private PasswordField txtPasswordSignup;

    @FXML
    private TextField txtUserNameSignup;


public void btnSignup(ActionEvent a){
    if((txtFirstNameSignup.getText().isBlank())||(txtLastNameSignup.getText().isBlank())||(txtPasswordSignup.getText().isBlank())|| (txtUserNameSignup.getText().isBlank())){
        lblEreursignup.setText("Please fill in all the fields.");
    }else{
       validesignup();
    }


}
public void validesignup(){
    DbConnection connNow = new DbConnection();
    Connection conn = connNow.getConnexion();
    String sql ="INSERT INTO usersaccounts (FirstName,LastName,UserName,Password) VALUES ('"+txtFirstNameSignup.getText()+"','"+txtLastNameSignup.getText()+"','"+txtUserNameSignup.getText()+"','"+txtPasswordSignup.getText()+"');";

    try{



        Statement stmt = conn.createStatement();
        int res = stmt.executeUpdate(sql);
      if(res !=0){
          openlogin();
      }else{
          lblEreursignup.setText("try again.");
      }


    }catch(SQLException e){
        System.out.println(e.getMessage());
    }

}
























public void openlogin() {
    try {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxmlFile/login.fxml")));


        Stage p = new Stage();
        p.setTitle("Library");
        p.setScene(new Scene(root, 600, 500));
        p.show();


        Stage currentStage = (Stage) btnSignup.getScene().getWindow();
        currentStage.close();
    } catch (Exception ex) {

        System.out.println(ex.getMessage());
    }
}

    public void HyploginAction(ActionEvent ex) {
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxmlFile/login.fxml")));


            Stage p = new Stage();
            p.setTitle("Library");
            p.setScene(new Scene(root, 600, 500));
            p.show();


            Stage currentStage = (Stage) hyplogin.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }


}


