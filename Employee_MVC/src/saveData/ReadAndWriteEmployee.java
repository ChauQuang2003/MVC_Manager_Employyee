package saveData;

import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployee {
    private File file = new File("D:\\MVC_demo\\Employee_MVC\\database\\Employee.csv");

    public void WriteData(List<Employee> list) {
        try {
            String data ="";
            for (Employee item : list) {
                data += item.getId() + ", " + item.getName() + "," + item.getSalary() + "," + item.getIsFullTime() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Employee> ReadData() {
        List<Employee> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String [] data = bufferedReader.readLine().split(",");
            Employee employee = new Employee(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3]),Boolean.parseBoolean(data[4]));
            list.add(employee);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
