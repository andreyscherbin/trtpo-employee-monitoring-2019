package bsuir.Controller;

import bsuir.Model.Element;
import bsuir.Model.Employee;

public class WeeklyPlanning {

    private Employee employee;

    public WeeklyPlanning(){

    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public int[] weeklyPlanningEmployee(){
        int countPlans = 0,countSuccess = 0,countProblems = 0;
        for(Element e : employee.getResults()){
            if(e.getId() == 1)
                countPlans++;
            if(e.getId() == 2)
                countSuccess++;
            if(e.getId() == 3)
                countProblems++;

        }
        int[]result = new int[3];
        result[0] = countPlans;
        result[1] = countSuccess;
        result[2] = countProblems;
        return result;

    }

    private void weeklyPlanningTeam(){

    }
}
