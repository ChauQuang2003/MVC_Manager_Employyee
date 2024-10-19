package view;

import controller.UserManager;
import input.Input;
import model.User;

import javax.sound.midi.Soundbank;

public class UserView {
    private UserManager userManager = new UserManager();
    public void showUserMenu() {
        int choice;
        do {
            System.out.println("==========Menu User==========");
            System.out.println("1. Thông tin tài khoản.");
            System.out.println("2. Đăng ký.");
            System.out.println("3. Đăng nhập.");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn khác ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:showAddMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("===========Đăng ký=========");
        System.out.println("Nhập ID: ");
        int id = Input.inputNumber();
        System.out.println("Nhập tên đăng nhập: ");
        String name = Input.inputString();
        System.out.println("Nhập mật khẩu: ");
        String password = Input.inputString();

        User user = new User(id,userName, password);
        userManager.add(user);
        System.out.println("Đăng ký thành công!");
    }

    public void showLoginMenu() {
        System.out.println("==========Đăng nhập=========");
        System.out.println("Nhập tên đăng nhập: ");
        String name = Input.inputString();
        System.out.println("Nhập mật khẩu: ");
        String password = Input.inputString();

        User user = userManager.
    }
}
