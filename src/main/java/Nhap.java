/*
 * Mục đích: Các hàm liên quan đến nhập liệu, chuyển đổi sang dạng tiền Việt
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 19/10/2022
 * Version: 1.0
 * */

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Nhap {
    public static Scanner scan = new Scanner(System.in);

    public static int inputInt(String noiDung) {
        int result = 0;
        boolean gotInt = false;
        while (!gotInt) {
            System.out.print(noiDung);
            if (scan.hasNextInt()) {
                gotInt = true;
            } else {
                scan.next();// xoa input hien tai
                System.out.print("Nhập sai kiểu, hãy nhập vào dạng số <Int>");
            }
        }

        result = Integer.parseInt(scan.nextLine());
        return result;
    }

    public static double inputDouble(String noiDung) {
        double result = 0;
        boolean gotDouble = false;
        while (!gotDouble) {
            System.out.print(noiDung);
            if (scan.hasNextDouble()) {
                gotDouble = true;
            } else {
                scan.next();// xoa input hien tai
                System.out.print("Nhập sai kiểu, hãy nhập vào dạng số <Double>");
            }
        }

        result = Double.parseDouble(scan.nextLine());
        return result;
    }

    public static float inputFloat(String noiDung) {
        float result = 0;
        boolean gotFloat = false;
        while (!gotFloat) {
            System.out.print(noiDung);
            if (scan.hasNextFloat()) {
                gotFloat = true;
            } else {
                scan.next();// xoa input hien tai
                System.out.print("Nhập sai kiểu, hãy nhập vào dạng số <Float>");
            }
        }

        result = Float.parseFloat(scan.nextLine());
        return result;
    }

    public static float inputLong(String noiDung) {
        long result = 0;
        boolean gotLong = false;
        while (!gotLong) {
            System.out.print(noiDung);
            if (scan.hasNextLong()) {
                gotLong = true;
            } else {
                scan.next();// xoa input hien tai
                System.out.print("Nhập sai kiểu, hãy nhập vào dạng số <Long>");
            }
        }

        result = Long.parseLong(scan.nextLine());
        return result;
    }

    public static String inputString(String noiDung) {
        String result = "";
        System.out.print(noiDung);
        result = scan.nextLine();
        return result;
    }

    public static String inputDate() {
        String result = "";
        do {
            System.out.print("Enter date (yyyy/MM/dd): ");
            result = scan.nextLine();
        } while (!isSimpleValidateDate(result));
        return result;
    }

    private static boolean isSimpleValidateDate(String noiDung) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        try {
            LocalDate ld = LocalDate.parse(noiDung, f);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

//    public static String toVnd(double tienNhapVao) {
//        DecimalFormat df = new DecimalFormat("###,###,###");
//        String result = "";
//        result = df.format(tienNhapVao);
//        return result;
//    }
}
