package bsuir.Model;


import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String password;
    private String email;
    private List<Element> results = new ArrayList<>();
    private List<Goal> goals = new ArrayList<>();
    private TeamLead boss;
    private Team team;
    private final int idPlan = 1;
    private final int idSuccess = 2;
    private final int idProblem = 3;

    public List<Element> getResults(){
        return results;
    }

    public List<Goal> getGoals(){
        return goals;
    }

    private void addElement(Element element){
        results.add(element);
    }

    public void removeElement(Element element){
        results.remove(element);
    }

    private void changeElement(Element element){

    }

    private void addKeyResult(){

    }

    private void changeKeyResult(){

    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlans(List<String> planList){

        for (String plan : planList) {
            Element elementPlan = new Element(plan,idPlan);
            results.add(elementPlan);
        }
    }

    public void setSuccess(List<String> successList){

        for (String success : successList) {
            Element elementSuccess = new Element(success,idSuccess);
            results.add(elementSuccess);
        }
    }

    public void setProblems(List<String> problemList){

        for (String problem : problemList) {
            Element elementProblem = new Element(problem,idProblem);
            results.add(elementProblem);
        }
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", password=" + password + ", email=" + email + "]";
    }

}
