package view;

import controller.UserManager;
import input.Input;
import model.User;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class UserView {
    private UserManager userManager = new UserManager();

    public void showUserMenu() {
        int choice;
        do {
            System.out.println("==========Menu User==========");
            System.out.println("1. Thông tin tài khoản.");
            System.out.println("2. Đăng ký.");
            System.out.println("3. Đăng nhập.");
            System.out.println("4. Đăng xuất.");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn khác ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:findAll();
                    break;
                case 2:showAddMenu();
                    break;
                case 3:showLoginMenu();
                    break;
                    case 4:showLogout();
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! vui lòng nhập lại.");
                    break;
            }
        } while (choice != 0);
    }
    public void findAll() {
        User currentUser = userManager.getCurrentUser();
        if (currentUser != null) {
            System.out.println("Thông tin tài khoản của bạn: ");
            System.out.println(currentUser);
        } else {
            System.out.println("Bạn cần đăng nhập để xem thông tin tài khoản.");
        }
    }

    public void showAddMenu() {
        System.out.println("===========Đăng ký=========");
        System.out.println("Nhập ID: ");
        int id = Input.inputNumber();
        System.out.println("Nhập tên đăng nhập: ");
        String userName = Input.inputString();
        System.out.println("Nhập mật khẩu: ");
        String password = Input.inputString();

        User user = new User(id, userName, password);
        if (userManager.add(user)) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Đăng ký thất bại.");
        }
    }

    public void showLoginMenu() {
        System.out.println("==========Đăng nhập=========");
        System.out.println("Nhập tên đăng nhập: ");
        String userName = Input.inputString();
        System.out.println("Nhập mật khẩu: ");
        String password = Input.inputString();

        User user = userManager.login(userName, password);
        if (user != null) {
            System.out.println("Đăng nhập thành công " + user.getUserName());
        } else {
            System.out.println("Đăng nhập thất bại! Vui lòng nhập lại.");
        }
    }

    public void showLogout() {
        userManager.logout();
    }
}
