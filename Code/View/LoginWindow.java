package bsuir.View;


import bsuir.Controller.RegistrationAndLoginManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import bsuir.Model.Employee;



public class LoginWindow extends Application {

    private Group group;
    private Scene scene;
    private Stage stage;

    private RegistrationAndLoginManager manager = new RegistrationAndLoginManager();

    public LoginWindow(){

    }

    private void LogIn_Click(ActionEvent event) {
     //LoginWindowForTheRegisteredUser window = new LoginWindowForTheRegisteredUser();
        Employee employee = manager.LogIn("andrey123scherbin@gmail.com","12345");
        MainWindow window = new MainWindow(employee);
     stage.close();


    }
    private void Register_Click(ActionEvent event) {
        RegistrationWindow window = new RegistrationWindow();
    }

    @Override
    public void start(Stage _stage) {
        stage = _stage;
        // установка надписи
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        Text text = new Text("Войдите или зарегистрируйтесь!");
        Button SignIn = new Button("Вход");
        SignIn.setOnAction(this::LogIn_Click);
        Button Registration = new Button("Регистрация");
        Registration.setOnAction(this::Register_Click);
        gridPane.add(text, 0, 0);
        gridPane.add(SignIn, 0, 1);
        gridPane.add(Registration, 0, 2);
        //Styling nodes
        SignIn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        Registration.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        text.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");

        scene = new Scene(gridPane);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Окно входа в приложение");
        stage.setWidth(400);
        stage.setHeight(300);
        stage.show();
    }
}
