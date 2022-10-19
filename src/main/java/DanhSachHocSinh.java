import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Mục đích: Các hàm, nghiệp vụ liên quan đến Danh Sach Hoc Sinh
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 19/10/2022
 * Version: 1.0
 * */
public class DanhSachHocSinh {
    private ArrayList<HocSinh> listHocSinh;

    public ArrayList<HocSinh> getListHocSinh() {
        return listHocSinh;
    }

    public void setListHocSinh(ArrayList<HocSinh> listHocSinh) {
        this.listHocSinh = listHocSinh;
    }

    public DanhSachHocSinh() {
        this.listHocSinh = new ArrayList<HocSinh>();
    }

    public void nhap() {
        // Tiêu đề
        for (HocSinh hs : this.listHocSinh) {
            hs.nhap();
        }
        // kết thúc
    }

    public void xuat() {
        // Tiêu đề
        for (HocSinh hs : this.listHocSinh) {
            hs.xuat();
        }
        // kết thúc
    }

    public void tinhDiemTB() {
        for (HocSinh hs : this.listHocSinh) {
            hs.tinhDiemTB();
        }
    }

    public void xepLoai() {
        for (HocSinh hs : this.listHocSinh) {
            hs.xepLoai();
        }
    }

    public void taoDuLieu() {
        try {
            FileReader reader = new FileReader("src/main/java/HocSinh.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] listInfo = line.split(" # ");
                HocSinh hs = new HocSinh(
                        listInfo[0],
                        listInfo[1],
                        listInfo[2],
                        listInfo[3],
                        Float.parseFloat(listInfo[4]),
                        Float.parseFloat(listInfo[5]),
                        Float.parseFloat(listInfo[6])
                );
                this.listHocSinh.add(hs);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
