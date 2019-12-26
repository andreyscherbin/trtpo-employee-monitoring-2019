package bsuir.View;

import bsuir.Controller.RegistrationAndLoginManager;
import bsuir.Model.Employee;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginWindowForTheRegisteredUser  {


    private RegistrationAndLoginManager manager = new RegistrationAndLoginManager();
    private Group group;
    private Scene scene;
    private Stage stage;
    private TextField email;
    private TextField password;
    private Text noSuchEmployee;
    private Employee employee;

    private void loginClick(ActionEvent event) {

        employee = manager.LogIn(email.getText(),password.getText());
        /*if(employee == null) {
            System.out.println("no such employee");
        }
        else {
            stage.close();*/
            MainWindow window = new MainWindow(employee);

        //}

    }

    public LoginWindowForTheRegisteredUser()
    {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        email = new TextField();
        password = new TextField();
        noSuchEmployee = new Text();
        Text emailText = new Text("email");
        Text passwordText = new Text("password");
        Button SignIn = new Button("Вход");
        SignIn.setOnAction(this::loginClick);
        gridPane.add(emailText, 0, 0);
        gridPane.add(email, 1, 0);
        gridPane.add(passwordText, 0, 1);
        gridPane.add(password, 1, 1);
        gridPane.add(SignIn, 0, 2);
        //Styling nodes
        SignIn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        emailText.setStyle("-fx-font: normal bold 20px 'serif' ");
        passwordText.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");

        scene = new Scene(gridPane);
        stage = new Stage();
        stage.setTitle("Окно входа для зарегистрированных пользователей");
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(300);
        stage.setResizable(false);
        stage.show();
    }

}
