/*
 * Mục đích: Các hàm, nghiệp vụ liên quan đến Danh Sach Hoc Sinh
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 19/10/2022
 * Version: 1.0
 * */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachGiaoVien {
    private ArrayList<GiaoVien> listGiaoVien;

    public ArrayList<GiaoVien> getListGiaoVien() {
        return listGiaoVien;
    }

    public void setListGiaoVien(ArrayList<GiaoVien> listGiaoVien) {
        this.listGiaoVien = listGiaoVien;
    }

    public DanhSachGiaoVien() {
        this.listGiaoVien = new ArrayList<GiaoVien>();
    }

    public void nhap() {
        for (GiaoVien gv : this.listGiaoVien) {
            gv.nhap();
        }
    }

    public void xuat() {
        for (GiaoVien gv : this.listGiaoVien) {
            gv.xuat();
        }
    }

    public void tinhThamNien() {
        for (GiaoVien gv : this.listGiaoVien) {
            gv.tinhThamNien();
        }
    }

    public void taoDuLieu() {
        try {
            FileReader reader = new FileReader("src/main/java/GiaoVien.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] listInfo = line.split(" # ");
                GiaoVien gv = new GiaoVien(
                        listInfo[0],
                        listInfo[1],
                        listInfo[2],
                        listInfo[3],
                        Integer.parseInt(listInfo[4]),
                        listInfo[5]
                );
                this.listGiaoVien.add(gv);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
