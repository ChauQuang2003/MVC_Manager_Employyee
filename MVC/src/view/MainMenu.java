package view;

import controller.ContactsManager;
import input.Input;

import java.util.Scanner;

public class MainMenu {
    ContactsView contactsView = new ContactsView();
    Scanner scanner = new Scanner(System.in);

    public void manMenu() {
        int choice;
        do {
            System.out.println("=========Menu Danh Bạ=======");
            System.out.println("1.Menu Contacts");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn!");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:contactsView.showMenu();
                    break;
                case 0:
                    System.out.println("Thoát chương trình! ");
                    break;
            }
        } while (choice != 0);
    }
}
