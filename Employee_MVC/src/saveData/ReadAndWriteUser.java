package saveData;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteUser {
    private File file = new File("D:\\MVC_demo\\database\\User.csv");

    public void writeData(List<User> userList) {
        try {
            String data = "";
            for (User user : userList) {
                data += user.getId() + "," + user.getUserName() + "," + user.getPassword() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<User> readData() {
        List<User> List = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                User user = new User(Integer.parseInt(data[0]), data[1], data[2]);
                List.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return List;
    }
}
