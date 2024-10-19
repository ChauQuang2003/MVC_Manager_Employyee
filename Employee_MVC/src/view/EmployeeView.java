package view;

import controller.EmployeeManager;
import input.Input;

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
            System.out.println("5. Thay đổi trạng thái nhân viên.");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn khác ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while (choice != 0);
    }

}




