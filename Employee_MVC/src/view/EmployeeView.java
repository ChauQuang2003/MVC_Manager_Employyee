package view;

import controller.EmployeeManager;
import input.Input;
import model.Employee;
import saveData.ReadAndWriteUser;

public class EmployeeView {
    private EmployeeManager employeeManager = new EmployeeManager();

    public void showEmployeeMenu() {
        int choice;
        do {
            System.out.println("==========Menu Employee==========");
            System.out.println("1. Thêm nhân viên.");
            System.out.println("2. Tìm kếm nhân viên.");
            System.out.println("3. Kiểm tra nhân viên.");
            System.out.println("4. Sửa thông tin nhân viên.");
            System.out.println("5. Xóa nhân viên.");
            System.out.println("6. Thay đổi trạng thái nhân viên.");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn khác ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:searchEmployee();
                    break;
                case 3:checkEmloyeeList();
                    break;
                case 4:editEmployee();
                    break;
                case 5:deleteEmployee();
                    break;
                case 6:changeEmployeeStatus();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }

    public void addEmployee() {
        System.out.println("==========Thêm Nhân Viên==========");
        System.out.println("Nhập ID: ");
        int id = Input.inputNumber();
        System.out.println("Nhập Tên: ");
        String name = Input.inputString();
        System.out.println("Nhập mức lương: ");
        double salary = Input.inputDouble();
        System.out.println("Nhân viên toàn thời gian (1- có/ 0- không): ");
        double isFullTime = Input.inputDouble();
        System.out.println("Nhân viên đang làm việc (true/false): ");
        boolean isActive = Input.inputBoolean();

        Employee employee = new Employee(id, name, salary, isFullTime, isActive);
        employeeManager.add(employee);
        System.out.println("Thêm nhân viên thành công! ");
    }

    public void searchEmployee() {
        System.out.println("=========Tìm Kiếm Nhân Viên=======");
        System.out.println("Nhập ID nhân viên:  ");
        int id = Input.inputNumber();
        Employee employee = employeeManager.findById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    public void checkEmloyeeList() {
        System.out.println("==========Danh sách nhân viên========");
        for (Employee employee : employeeManager.getAll()) {
            System.out.println(employee);
        }
    }

    public void editEmployee() {
        System.out.println("============Sửa Thông Tin Nhân Viên==========");
        System.out.println("Nhập ID nhân viên cần sửa: ");
        int id = Input.inputNumber();
        Employee employee = employeeManager.findById(id);
        if (employee != null) {
            System.out.println("Nhập tên mới: ");
            String name = Input.inputString();
            System.out.println("Nhập mức lương mới: ");
            double salary = Input.inputDouble();
            System.out.println("Nhân viên toàn thời gian (1- có/ 0- không): ");
            boolean isFullTime = Input.inputNumber() == 1;
            System.out.println("Nhân viên đang làm việc (true/false): ");
            boolean isActive = Input.inputBoolean();

            employee.setName(name);
            employee.setSalary(salary);
           // employee.setIsFullTime(isFullTime);
            employee.setActive(isActive);
            employeeManager.update(id, employee);
            System.out.println("Sửa thông tin nhân viên thành công!");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    public void deleteEmployee() {
        System.out.println("===========Xóa Nhân Viên==========");
        System.out.println("Nhập ID nhân viên: ");
        int id = Input.inputNumber();
        employeeManager.delete(id);
    }

    public void changeEmployeeStatus() {
        System.out.println("============Thay Đổi Trạng Thái Nhân Viên============");
        System.out.println("Nhập ID nhân viên cần thay đôi trạng thái:");
        int id = Input.inputNumber();
        Employee employee = employeeManager.findById(id);
        if (employee != null) {
            if (employee.isActive()) {
                System.out.println("Trạng thái đang làm việc");
            } else {
                System.out.println("Trạng thái đã nghỉ việc");
            }
            System.out.println("Bạn có muốn thay đổi trạng thái không? (true/false): ");
            boolean newStatus = Input.inputBoolean();
            employee.setActive(newStatus);
            employeeManager.update(id, employee);
            System.out.println("Thay đổi trạng thái thành công!");
        } else {
            System.out.println("Không tìm nhân viên với ID: " + id);
        }

    }
}




