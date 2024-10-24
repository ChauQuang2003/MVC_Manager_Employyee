package controller;

import java.util.List;

public interface IManager <T>{
    void add(T t);

    void update(String phoneNumber,T t);

    void remove(String phoneNumber);

    List<T> getAll();

    int findIndexByPhoneNumber(String phoneNumber);
}
