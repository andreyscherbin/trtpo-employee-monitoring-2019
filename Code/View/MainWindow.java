package bsuir.View;

import bsuir.Controller.QuarterPlanning;
import bsuir.Controller.WeeklyPlanning;
import bsuir.Model.Element;
import bsuir.Model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

import java.util.List;


public class MainWindow {

    private Group group;
    private Scene scene;
    private Stage stage;
    private Employee employee;
    private WeeklyPlanning weekPlanning = new WeeklyPlanning();
    private QuarterPlanning quarterPlanning = new QuarterPlanning();

    private ToggleButton weeklyPlanning;
    private ToggleButton quartePlanning;
    private ToggleButton name;
    private ToggleButton addTeam;
    private ToggleButton addToTeam;
    private ToggleButton team;
    private GridPane gridPane;
    private PieChart chart;
    private Text yourWeek;
    private Text thisTextWillSend7Days;
    private Text planText;
    private Text successText;
    private Text problemText;


    private void addElementClick(ActionEvent event) {

    }

    private void changeElementClick(ActionEvent event) {

    }

    private void deleteElementClick(ActionEvent event) {

    }


    private void nameButtonClick(ActionEvent event) {


        createPieChart();
        yourWeek = new Text("Твоя неделя");
        thisTextWillSend7Days = new Text("Этот отчет будет отослан через 7 дней");
        planText = new Text("Планы");
        successText = new Text("Успехи");
        problemText = new Text("Проблемы");

        ListView<Element> planList = new ListView<>();
        ListView<Element> successList = new ListView<>();
        ListView<Element> problemList = new ListView<>();

        setCellFactoryMethod(planList);
        setCellFactoryMethod(successList);
        setCellFactoryMethod(problemList);

        List<Element> listElements = this.employee.getResults();
        for(Element e : listElements){
           if(e.getId() == 1)
               planList.getItems().add(e);
            if(e.getId() == 2)
                successList.getItems().add(e);
            if(e.getId() == 3)
                problemList.getItems().add(e);
        }

        ContextMenu changeElementOptionsPlans = new ContextMenu();
        ContextMenu changeElementOptionsSuccess = new ContextMenu();
        ContextMenu changeElementOptionsProblems = new ContextMenu();

        MenuItem deleteElementPlans = new MenuItem("Удалить элемент");
        MenuItem changeElementPlans = new MenuItem("Изменить элемент");
        MenuItem addElementPlans = new MenuItem("Добавить элемент");

        MenuItem deleteElementSuccess = new MenuItem("Удалить элемент");
        MenuItem changeElementSuccess = new MenuItem("Изменить элемент");
        MenuItem addElementSuccess = new MenuItem("Добавить элемент");

        MenuItem deleteElementProblems = new MenuItem("Удалить элемент");
        MenuItem changeElementProblems = new MenuItem("Изменить элемент");
        MenuItem addElementProblems = new MenuItem("Добавить элемент");

        deleteElementMethod(planList,deleteElementPlans);
        deleteElementMethod(successList,deleteElementSuccess);
        deleteElementMethod(problemList,deleteElementProblems);
        changeElementMethod(planList,changeElementPlans);
        changeElementMethod(successList,changeElementSuccess);
        changeElementMethod(problemList,changeElementProblems);


        changeElementOptionsPlans.getItems().addAll(deleteElementPlans, changeElementPlans,addElementPlans);
        changeElementOptionsSuccess.getItems().addAll(deleteElementSuccess, changeElementSuccess,addElementSuccess);
        changeElementOptionsProblems.getItems().addAll(deleteElementProblems, changeElementProblems,addElementProblems);

        setListener(planList,changeElementOptionsPlans);
        setListener(successList,changeElementOptionsSuccess);
        setListener(problemList,changeElementOptionsProblems);

        gridPane.add(yourWeek,3,5);
        gridPane.add(thisTextWillSend7Days,6,5);
        gridPane.add(planText,3,6);
        gridPane.add(planList,3,7);
        gridPane.add(successText,3,8);
        gridPane.add(successList,3,9);
        gridPane.add(problemText,3,10);
        gridPane.add(problemList,3,11);


    }

    private void setListener(ListView<Element> elementList, ContextMenu changeElementOptions){

        elementList.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                Element currentItemSelected = elementList.getSelectionModel()
                        .getSelectedItem();
                System.out.println(currentItemSelected);
                changeElementOptions.show(elementList, event.getScreenX(), event.getScreenY());
            }
        });

        elementList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 1) {

                    //Use ListView's getSelected Item
                    changeElementOptions.hide();
                    //use this to do whatever you want to. Open Link etc.
                }
            }
        });
    }

    private void setCellFactoryMethod(ListView<Element> list){

        list.setCellFactory(param -> new ListCell<Element>() {
            @Override
            protected void updateItem(Element item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getDescription() == null) {
                    setText(null);
                } else {
                    setText(item.getDescription());
                }
            }
        });
    }

    private void deleteElementMethod(ListView<Element> list,MenuItem deleteElement ){
        deleteElement.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                final int indexSelectedString = list.getSelectionModel().getSelectedIndex();
                Element element = list.getSelectionModel().getSelectedItem();
                list.getItems().remove(indexSelectedString);
                employee.removeElement(element);
                gridPane.getChildren().remove(chart);
                createPieChart();
            }
        });

    }

    private void changeElementMethod(ListView<Element> list, MenuItem changeElement ){
        changeElement.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                final int indexSelectedString = list.getSelectionModel().getSelectedIndex();
                Element element = list.getSelectionModel().getSelectedItem();
                list.setEditable(true);

                //list.setCellFactory(TextFieldListCell.forListView());
            }
        });

    }

    private void createPieChart(){

        weekPlanning.setEmployee(this.employee);
        int[] resultsEmployee = weekPlanning.weeklyPlanningEmployee();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Проблемы",resultsEmployee[0]),
                        new PieChart.Data("Планы", resultsEmployee[1]),
                        new PieChart.Data("Успехи", resultsEmployee[2]));
        chart = new PieChart(pieChartData);
        chart.setTitle("Прогресс за неделю");
        gridPane.add(chart,7,5,6,6);
    }

    public MainWindow(Employee employee)
    {
        this.employee = employee;

        weeklyPlanning = new ToggleButton("Еженедельное планирование");
        quartePlanning = new ToggleButton("Ежеквартальное планирование");
        name = new ToggleButton(employee.getName());
        addTeam = new ToggleButton("Добавить команду");
        addToTeam = new ToggleButton("Добавить в команду");
        team = new ToggleButton("Команда");

        gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_LEFT);

        gridPane.add(weeklyPlanning, 0, 2);
        gridPane.add(quartePlanning, 0, 3);
        gridPane.add(name, 1, 2);
        gridPane.add(team, 1, 3);
        gridPane.add(addTeam, 1, 4);
        gridPane.add(addToTeam, 1, 5);

        name.setOnAction(this::nameButtonClick);

        scene = new Scene(gridPane);
        stage = new Stage();
        stage.setTitle("Главно окно");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    }



