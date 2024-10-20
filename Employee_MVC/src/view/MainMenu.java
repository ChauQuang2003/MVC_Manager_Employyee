package view;

import java.util.Scanner;

public class MainMenu {
    EmployeeView employeeViewmenu = new EmployeeView();
    UserView userViewmenu = new UserView();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        int choice;
        do {
            System.out.println("=========Menu Chính=======");
            System.out.println("1. Employee Menu");
            System.out.println("2. User Menu");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn!");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    employeeViewmenu.showEmployeeMenu();
                    break;
                case 2:  userViewmenu.showUserMenu();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);

    }

}
