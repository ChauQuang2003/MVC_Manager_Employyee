package controller;

import model.User;
import saveData.ReadAndWriteUser;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements IManager<User> {
    private List<User> listUser = new ArrayList<>();
    private User currentUser = null;
    ReadAndWriteUser readAndWriteUser = new ReadAndWriteUser();

    public UserManager() {
        listUser = readAndWriteUser.readData();
        if (listUser == null) {
            listUser = new ArrayList<>();
        }
    }

    @Override
    public boolean add(User user) {
//        readAndWriteUser.writeData(listUser);
        for (User existUser : listUser) {
            if (existUser.getUserName().equals(user.getUserName())) {
                return false;
            }
        }
        listUser.add(user);
        readAndWriteUser.writeData(listUser);
        return true;
    }

    @Override
    public void update(int id, User user) {
        int index = findIndexById(id);
        if (index >= 0) {
            listUser.set(index, user);
            System.out.println("Cập nhập thành công! ");
        } else {
            System.out.println("Không tìm thấy User.");
        }

    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        if (index >= 0) {
            listUser.remove(index);
            System.out.println("Xóa User thành công với: " + id);
        }else {
            System.out.println("Không tìm thấy User: " + id);
        }

    }

    @Override
    public List<User> getAll() {
        return this.listUser;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public User login(String username, String password) {
        for ( User user : listUser) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return user;
            }
        }
        return null;
    }

    public void logout() {
        if (currentUser != null) {
            System.out.println("Đăng xuất thành công!");
            currentUser = null;
        } else {
            System.out.println("Người dùng chưa đăng nhập.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
