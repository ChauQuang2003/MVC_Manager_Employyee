package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements IManager<User> {
    private List<User> listUser = new ArrayList<>();

    @Override
    public void add(User user) {
        listUser.add(user);
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
        return listUser;
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
}
