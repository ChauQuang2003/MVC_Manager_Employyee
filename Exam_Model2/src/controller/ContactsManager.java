package controller;

import model.Contacts;
import saveData.ReadAndWriteContacts;

import java.util.ArrayList;
import java.util.List;

public class ContactsManager implements IManager<Contacts> {
    List<Contacts> contactsList = new ArrayList<>();
    ReadAndWriteContacts readAndWriteContacts = new ReadAndWriteContacts();
    public ContactsManager() {
        contactsList = readAndWriteContacts.ReadData();
    }

    @Override
    public void add(Contacts contacts) {
        contactsList.add(contacts);
        readAndWriteContacts.WriteData(contactsList,false);
    }

    @Override
    public void update(String phoneNumber, Contacts contacts) {
        int index = findIndexByPhoneNumber(phoneNumber);
        if (index >= 0) {
            contactsList.set(index, contacts);
            writeContactsFile();
            System.out.println("Cập nhập thành công!");
        } else {
            System.out.println("Không tìm thấy: "+phoneNumber);
        }
    }

    @Override
    public void remove(String phoneNumber) {
        int index = findIndexByPhoneNumber(phoneNumber);
        if (index != 0) {
            contactsList.remove(index);
            writeContactsFile();
            System.out.println("Xóa thành công: "+phoneNumber);
        }
        else {
            System.out.println("Không tìm thấy: "+phoneNumber);
        }
    }

    @Override
    public List<Contacts> getAll() {
        return contactsList;
    }

    @Override
    public int findIndexByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

    public void readContactsFile() {
        contactsList = readAndWriteContacts.ReadData();
    }

    public void writeContactsFile() {
        readAndWriteContacts.WriteData(contactsList,false);
    }
}
