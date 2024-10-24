package view;

import controller.ContactsManager;
import input.Input;
import model.Contacts;

import java.util.List;

public class ContactsView {
    private ContactsManager contactsManager = new ContactsManager();

    public void showMenu() {
        int choice;
        do {
            System.out.println("========== QUẢN LÝ CHƯƠNG TRÌNH DANH BẠ ========");
            System.out.println("1. Xem danh sách ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhập ");
            System.out.println("4. Xóa ");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Đọc từ file ");
            System.out.println("7. Ghi vào file ");
            System.out.println("0. Thoát ");
            System.out.println("Vui lòng chọn chức năng: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:showAllContacts();
                    break;
                case 2:showaddContacts();
                    break;
                case 3:showUpdateContacts();
                    break;
                case 4: showdeleteContacts();
                    break;
                case 5:showSearchContacts();
                    break;
                case 6:readContactsFile();
                    break;
                case 7:writeContactsFile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình ");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại. ");
                    break;
            }
        } while (choice != 0);
    }

    public void showAllContacts() {
        List<Contacts> contactsList = contactsManager.getAll();
        if (contactsList.isEmpty()) {
            System.out.println("Danh sách danh bạ trống.");
        } else {
            for (Contacts contact : contactsList) {
                System.out.println(contact);
            }
        }
    }

    public void showaddContacts() {
        System.out.println("======Thêm Danh Bạ Mới=======");
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = Input.inputString();
        System.out.println("Nhập nhóm danh bạ: ");
        String group = Input.inputString();
        System.out.println("Nhập tên: ");
        String name = Input.inputString();
        System.out.println("Nhập giới tính: ");
        String gender = Input.inputString();
        System.out.println("Nhập địa chỉ: ");
        String address = Input.inputString();
        System.out.println("Nhập ngày sinh: ");
        String dataOfBirth = Input.inputString();
        System.out.println("Nhập email: ");
        String email = Input.inputString();

        Contacts contacts = new Contacts(phoneNumber, group, name, gender, address, dataOfBirth, email);
        contactsManager.add(contacts);
        System.out.println("Thêm danh bạ thành công! ");
    }

    public void showUpdateContacts() {
        System.out.println("=========Cập Nhập Danh Bạ=========");
        System.out.println("Nhập số điện thoại cần cập nhập: ");
        String phoneNumber = Input.inputString();
        int index = contactsManager.findIndexByPhoneNumber(phoneNumber);
        if (index >= 0) {
            System.out.println("Nhập nhóm dạnh bạ: ");
            String group = Input.inputString();
            System.out.println("Nhập tên: ");
            String name = Input.inputString();
            System.out.println("Nhập giới tính: ");
            String gender = Input.inputString();
            System.out.println("Nhập địa chỉ: ");
            String address = Input.inputString();
            System.out.println("Nhập ngày sinh: ");
            String dataOfBirth = Input.inputString();
            System.out.println("Nhập email: ");
            String email = Input.inputString();

            Contacts updateContacts = new Contacts(phoneNumber, group, name, gender, address, dataOfBirth, email);
            contactsManager.update(phoneNumber, updateContacts);
            System.out.println("Cập nhập thành công!");
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại:  " + phoneNumber);
        }

    }

    public void showdeleteContacts() {
        System.out.println("===========Xóa Danh Bạ Điện Thoại=========");
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = Input.inputString();
        contactsManager.remove(phoneNumber);
    }

    public void showSearchContacts() {
        System.out.println("=========Tìm Kiếm Danh Bạ==========");
        System.out.println("Nhập số điện thoại cần tìm: ");
        String phoneNumber = Input.inputString();
        int index = contactsManager.findIndexByPhoneNumber(phoneNumber);
        if (index >= 0) {
            Contacts contacts = contactsManager.getAll().get(index);
            System.out.println(contacts);
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại:  " + phoneNumber);
        }
    }

    private void readContactsFile() {
        contactsManager.readContactsFile();
        System.out.println("Đọc danh bạ từ File thành công! ");
    }

    public void writeContactsFile() {
        contactsManager.writeContactsFile();
        System.out.println("Ghi danh bạ vào File thành công! ");
    }
}
