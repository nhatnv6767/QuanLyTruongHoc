import java.util.Scanner;

/*
 * Mục đích: Các hàm, nghiệp vụ liên quan đến Giáo Viên
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 19/10/2022
 * Version: 1.0
 * */
public class GiaoVien extends ThanhVien {
    private int namBatDauDay;
    private String chuyenMon;
    private int thamNien;

    public int getNamBatDauDay() {
        return namBatDauDay;
    }

    public void setNamBatDauDay(int namBatDauDay) {
        this.namBatDauDay = namBatDauDay;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public int getThamNien() {
        return thamNien;
    }

    public GiaoVien(String hoTen, String namSinh, String noiSinh, String diaChi, int namBatDauDay, String chuyenMon) {
        super(hoTen, namSinh, noiSinh, diaChi);
        this.namBatDauDay = namBatDauDay;
        this.chuyenMon = chuyenMon;
    }

    public GiaoVien() {
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scan = new Scanner(System.in);
        this.namBatDauDay = Nhap.inputInt("Nhập năm bắt đầu dạy: ");
        do {
            System.out.println("Nhập chuyên môn (Tự nhiên, xã hội): ");
            this.chuyenMon = scan.nextLine().toLowerCase();
        } while (!this.chuyenMon.equalsIgnoreCase("tự nhiên") && !this.chuyenMon.equalsIgnoreCase("xã hội"));
    }

    @Override
    public void xuat() {
        super.xuat();
        String tieuDe = String.format("%5s%15s%5s",
                this.namBatDauDay, this.chuyenMon, this.thamNien);
        System.out.println(tieuDe);
    }
}
