import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        doMenu();
    }

    public static void inMenu() {
        System.out.println("1. Nhập dữ liệu");
        System.out.println("2. Xuất danh sách học sinh");
        System.out.println("3. Xuất danh sách giáo viên");
        System.out.println("4. Giáo viên có thâm niên cao nhất");
        System.out.println("5. Giáo viên có thâm niên trên 5 năm và thuộc khối tự nhiên");
        System.out.println("6. Điểm trung bình cao nhất của học sinh");
        System.out.println("7. Học sinh có điểm trung bình cao nhất");
        System.out.println("8. Sắp xếp học sinh theo điểm trung bình giảm dần");
        System.out.println("9. Sắp xếp tên học sinh theo ABC");
        System.out.println("0. Thoát");
    }

    public static void doMenu() {
        TruongHoc th = new TruongHoc();
        String tieuDeHS = String.format("%10s%15s%18s%40s%8s%8s%12s%14s%15s",
                "Họ tên", "Năm sinh", "Nơi sinh", "Địa chỉ",
                "Đ.Toán", "Đ.Văn", "Đ.Ngoại Ngữ",
                "ĐTB", "Xếp Loại"
        );

        String tieuDeGV = String.format("%10s%15s%18s%40s%13s%20s%17s",
                "Họ tên", "Năm sinh", "Nơi sinh", "Địa chỉ",
                "Năm bắt đầu", "Chuyên môn", "Thâm niên (năm)"
        );
        th.taoDuLieu();
        th.tinhThamNien();
        th.tinhDiemTB();
        th.xepLoaiHS();
        while (true) {
            inMenu();
            int choice = Nhap.inputInt("Mời lựa chọn: ");
            switch (choice) {
                case 1:
                    th.nhap();
                    break;
                case 2:
                    System.out.println("*********** Danh sách học sinh ***********");
                    System.out.println(tieuDeHS);
                    th.xuatDSHocSinh();
                    break;
                case 3:
                    System.out.println("*********** Danh sách giáo viên ***********");
                    System.out.println(tieuDeGV);
                    th.xuatDSGiaoVien();
                    break;
                case 4:
                    System.out.println("*********** Giáo viên có thâm niên cao nhất ***********");
                    System.out.println(tieuDeGV);
                    ArrayList<GiaoVien> dsGiaoVienThamNienMax = th.timGVThamNienCaoNhat();
                    for (GiaoVien gv : dsGiaoVienThamNienMax) {
                        gv.xuat();
                    }
                    break;
                case 5:
                    System.out.println("*********** Giáo viên có 5 năm kinh nghiệm và thuộc khối tự nhiên ***********");
                    System.out.println(tieuDeGV);
                    ArrayList<GiaoVien> dsGiaoVien = th.timGVHon5NamThuocKhoiTuNhien();
                    for (GiaoVien gv : dsGiaoVien) {
                        gv.xuat();
                    }
                    break;
                case 6:
                    System.out.println("*********** Điểm trung bình cao nhất của học sinh ***********");
                    float tbMaxHS = th.timDTBMaxHocSinh();
                    System.out.println("ĐTB cao nhất là: " + tbMaxHS);
                    break;
                case 7:
                    System.out.println("*********** Học sinh có ĐTB cao nhất ***********");
                    System.out.println(tieuDeHS);
                    ArrayList<HocSinh> dsHocSinhDTBMax = th.timDSHocSinhDTBMax();
                    for (HocSinh hs : dsHocSinhDTBMax) {
                        hs.xuat();
                    }
                    break;
                case 8:
                    System.out.println("*********** Danh sách học sinh theo DTB giảm dần ***********");
                    System.out.println(tieuDeHS);
                    th.quickSortDTB();
                    th.xuatDSHocSinh();
                    break;
                case 9:
                    System.out.println("*********** Danh sách học sinh theo thứ tự ABC ***********");
                    System.out.println(tieuDeHS);
                    th.bubbleSortTenHS();
                    th.xuatDSHocSinh();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chỉ được chọn từ 0 -> 9");
            }
        }
    }
}
