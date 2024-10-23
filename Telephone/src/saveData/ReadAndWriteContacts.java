package saveData;

import model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteContacts {
    private File file = new File("D:\\MVC_demo\\Telephone\\database\\contact.csv");

    public void WriteData(List<Contacts> list ,boolean append) {
        try {
            String data = "";
            for (Contacts item : list) {
                data += item.toString() + "," + item.getPhoneNumber() + "," + item.getGroup() + "," + item.getName() + "," + item.getGender() + "," + item.getAddress() + "," + item.getDataOfBirth() + "," + item.getEmail() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data );
//            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Contacts> ReadData() {
        List<Contacts> list = new ArrayList<Contacts>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String [] data = bufferedReader.readLine().split(",");
            Contacts contacts = new Contacts(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
            list.add(contacts);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}
