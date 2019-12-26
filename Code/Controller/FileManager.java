package bsuir.Controller;

import bsuir.Model.Employee;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileManager {

    private static List<Employee> employees = new ArrayList<>();


    public List<Employee> getEmployees()
    {
        return employees;
    }

    private List<String> getFileNames()
    {
        return null;
    }

    public Employee getEmployee(String email, String password)
    {

        for (Employee element : employees) {
           if(element.getEmail().equals(email) && element.getPassword().equals(password))
               return element;
        }

        return null;
    }

    public FileManager(){
        try {
            File fXmlFile = new File("D:\\trtpo\\trtpo-employee-monitoring-2019\\src\\bsuir\\Employees\\Andrey.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList employeeNodeList = doc.getElementsByTagName("employee");

            for (int parameter = 0; parameter < employeeNodeList.getLength(); parameter++) {
                Employee employee = new Employee();
                Node node = employeeNodeList.item(parameter);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String password = eElement.getElementsByTagName("password").item(0).getTextContent();
                    String email = eElement.getElementsByTagName("email").item(0).getTextContent();
                    NodeList plan = eElement.getElementsByTagName("plan");
                    List<String> planList = new ArrayList<>();
                    IntStream.range(0, plan.getLength()).forEach(bName -> {
                        planList.add(plan.item(bName).getTextContent());
                    });
                    NodeList succes = eElement.getElementsByTagName("succes");
                    List<String> succesList = new ArrayList<>();
                    IntStream.range(0, succes.getLength()).forEach(bName -> {
                        succesList.add(succes.item(bName).getTextContent());
                    });
                    NodeList problem = eElement.getElementsByTagName("problem");
                    List<String> problemList = new ArrayList<>();
                    IntStream.range(0, problem.getLength()).forEach(bName -> {
                        problemList.add(problem.item(bName).getTextContent());
                    });
                    employee.setPlans(planList);
                    employee.setSuccess(succesList);
                    employee.setProblems(problemList);
                    employee.setName(name);
                    employee.setPassword(password);
                    employee.setEmail(email);
                    employees.add(employee);
                }
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!  Exception while reading xml file :" + e.getMessage());
        }

        employees.forEach(bus -> {
            System.out.println("name = " + bus.getName());
            System.out.println("password = " + bus.getPassword());
            System.out.println("email = " + bus.getEmail());
            System.out.println("#####################################################");
        });
    }
}
