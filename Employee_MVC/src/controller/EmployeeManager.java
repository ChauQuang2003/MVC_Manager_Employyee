package controller;

import model.Employee;
import saveData.ReadAndWriteEmployee;
import saveData.ReadAndWriteUser;

import java.util.ArrayList;
import java.util.List;


public class EmployeeManager implements IManager<Employee>{
    List<Employee> listEmployees = new ArrayList<>();
    ReadAndWriteEmployee readAndWriteEmployee = new ReadAndWriteEmployee();
    public EmployeeManager() {
        listEmployees = readAndWriteEmployee.ReadData();
    }

    @Override
    public boolean add(Employee employee) {
        listEmployees.add(employee);
        readAndWriteEmployee.WriteData(listEmployees);
        return true;
    }

    @Override
    public void update(int id, Employee employee) {
        int index = findIndexById(id);
        if (index >=0) {
            listEmployees.set(index, employee);
            System.out.println("Cập nhập thành công!");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID. " + id);
        }
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        if (index >= 0) {
            listEmployees.remove(index);
            System.out.println("Xóa nhân viên thành công với ID: " + id);
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    @Override
    public List<Employee> getAll() {
        return listEmployees;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Employee findById(int id) {
        for ( Employee employee : listEmployees ) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
