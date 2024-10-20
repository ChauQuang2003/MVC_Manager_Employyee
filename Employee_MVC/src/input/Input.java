package input;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static int inputNumber() {
        do {
            try {
                String dataInput = input.nextLine();
                int number = Integer.parseInt(dataInput);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Định dạng không hợp lệ! Vui lòng nhập lại số ");
            }
        } while (true);
    }
    public static String inputString() {
        String dataInput = input.nextLine();
        return dataInput;
    }

    public static double inputDouble() {
        do {
            try {
                String dataInput = input.nextLine();
                double number = Double.parseDouble(dataInput.trim()); // Bỏ khoảng trắng đầu/cuối
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Định dạng không hợp lệ! Vui lòng nhập lại số thực: ");
            }
        } while (true);
    }

    public static boolean inputBoolean() {
        do {
            String dataInput = input.nextLine().trim();
            if (dataInput.equalsIgnoreCase("true") || dataInput.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(dataInput);
            } else {
                System.out.println("Định dạng không hợp lệ! Vui lòng nhập 'true' hoặc 'false': ");
            }
        } while (true);
    }
}
