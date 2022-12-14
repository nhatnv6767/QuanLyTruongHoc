import java.util.ArrayList;
import java.util.Collections;

/*
 * Mục đích: Các hàm, nghiệp vụ liên quan đến Truong hoc
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 19/10/2022
 * Version: 1.0
 * */
public class TruongHoc {

    private DanhSachHocSinh objDSHocSinh;
    private DanhSachGiaoVien objDSGiaoVien;

    public DanhSachHocSinh getObjDSHocSinh() {
        return objDSHocSinh;
    }

    public void setObjDSHocSinh(DanhSachHocSinh objDSHocSinh) {
        this.objDSHocSinh = objDSHocSinh;
    }

    public DanhSachGiaoVien getObjDSGiaoVien() {
        return objDSGiaoVien;
    }

    public void setObjDSGiaoVien(DanhSachGiaoVien objDSGiaoVien) {
        this.objDSGiaoVien = objDSGiaoVien;
    }

    public TruongHoc() {

    }

    // tạo dữ liệu từ file
    public void taoDuLieu() {
        this.objDSHocSinh = new DanhSachHocSinh();
        this.objDSHocSinh.taoDuLieu();

        this.objDSGiaoVien = new DanhSachGiaoVien();
        this.objDSGiaoVien.taoDuLieu();
    }

    // nhập dữ liệu bằng tay
    public void nhap() {
        ThanhVien thanhVien;
        while (true) {
            System.out.println("1. -> Học sinh");
            System.out.println("2. -> Giáo viên");
            System.out.println("3. -> Thoát");
            int choice = Nhap.inputInt("Mời lựa chọn: ");
//            int temptChoice = 0;
            switch (choice) {
                case 1:
                    thanhVien = new HocSinh();
                    thanhVien.nhap();
                    this.objDSHocSinh.getListHocSinh().add((HocSinh) thanhVien);
                    this.tinhDiemTB();
                    this.xepLoaiHS();
                    break;

                case 2:
                    thanhVien = new GiaoVien();
                    thanhVien.nhap();
                    this.objDSGiaoVien.getListGiaoVien().add((GiaoVien) thanhVien);
                    this.tinhThamNien();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Chỉ được chọn 1, 2, 3");
            }
        }
    }

    // Học Sinh
    public void xuatDSHocSinh() {
        this.objDSHocSinh.xuat();
    }

    public void xepLoaiHS() {
        this.objDSHocSinh.xepLoai();
    }

    public void tinhDiemTB() {
        this.objDSHocSinh.tinhDiemTB();
    }

    // tìm học sinh có đtb cao nhất
    public float timDTBMaxHocSinh() {
        float dtbMaxHocSinh = 0;
        if (this.objDSHocSinh.getListHocSinh().size() != 0) {
            for (int i = 0; i < this.objDSHocSinh.getListHocSinh().size(); i++) {
                float dtbDangXet = objDSHocSinh.getListHocSinh().get(i).getDiemTB();
                if (dtbDangXet > dtbMaxHocSinh) {
                    dtbMaxHocSinh = dtbDangXet;
                }
            }
        }
        return dtbMaxHocSinh;
    }

    // danh sách các học sinh có dtb cao nhất
    public ArrayList<HocSinh> timDSHocSinhDTBMax() {
        float dtbMaxHS = timDTBMaxHocSinh();
        ArrayList<HocSinh> dsDTBMax = new ArrayList<HocSinh>();
        for (HocSinh hs : objDSHocSinh.getListHocSinh()) {
            if (hs.getDiemTB() == dtbMaxHS) {
                dsDTBMax.add(hs);
            }
        }
        return dsDTBMax;
    }

    // sắp xếp DTB giảm dần theo quicksort
    public static void sapXepDTBGiamDan(ArrayList<HocSinh> dsHocSinh, int left, int right) {
        float pivot = dsHocSinh.get((left + (right - left) / 2)).getDiemTB();
        int i = left;
        int j = right;
        while (i <= j) {
            while (dsHocSinh.get(i).getDiemTB() > pivot) {
                i++;
            }
            while (dsHocSinh.get(j).getDiemTB() < pivot) {
                j--;
            }
            if (i <= j) {
                Collections.swap(dsHocSinh, i, j);
                i++;
                j--;
            }
        }

        if (left < j)
            sapXepDTBGiamDan(dsHocSinh, left, j);
        if (i < right)
            sapXepDTBGiamDan(dsHocSinh, i, right);
    }

    public void quickSortDTB() {
        sapXepDTBGiamDan(this.objDSHocSinh.getListHocSinh(),
                0, this.objDSHocSinh.getListHocSinh().size() - 1);
    }


    // Săp xếp theo ABC dùng Bubble Sort
    public void bubbleSortTenHS() {
        ArrayList<HocSinh> dsHocSinh = this.objDSHocSinh.getListHocSinh();
        for (int i = 0; i < dsHocSinh.size() - 1; i++) {
            for (int j = dsHocSinh.size() - 1; j > i; j--) {
                if (dsHocSinh.get(j).getHoTen().compareToIgnoreCase(dsHocSinh.get(j - 1).getHoTen()) < 0) {
                    Collections.swap(dsHocSinh, j - 1, j);
                }
            }
        }
    }


    // Giáo viên
    public void xuatDSGiaoVien() {
        this.objDSGiaoVien.xuat();
    }

    public void tinhThamNien() {
        this.objDSGiaoVien.tinhThamNien();
    }


    // Giáo viên có thâm niên cao nhất
    public ArrayList<GiaoVien> timGVThamNienCaoNhat() {
        ArrayList<GiaoVien> listGVThamNienCaoNhat = new ArrayList<GiaoVien>();
        int viTriMax = 0;
        for (int i = 1; i < objDSGiaoVien.getListGiaoVien().size() - 1; i++) {
            int thamNienDangXet = objDSGiaoVien.getListGiaoVien().get(i).getThamNien();
            int thamNienCaoNhat = objDSGiaoVien.getListGiaoVien().get(viTriMax).getThamNien();
            if (thamNienDangXet > thamNienCaoNhat) {
                viTriMax = i;
            }
        }

        for (int i = viTriMax; i < objDSGiaoVien.getListGiaoVien().size(); i++) {
            int thamNienDangXet = objDSGiaoVien.getListGiaoVien().get(i).getThamNien();
            int thamNienCaoNhat = objDSGiaoVien.getListGiaoVien().get(viTriMax).getThamNien();
            if (thamNienDangXet == thamNienCaoNhat) {
                GiaoVien gv = objDSGiaoVien.getListGiaoVien().get(i);
                listGVThamNienCaoNhat.add(gv);
            }
        }

        return listGVThamNienCaoNhat;
    }

    // gv > 5 nam va thuoc khoi tu nhien
    public ArrayList<GiaoVien> timGVHon5NamThuocKhoiTuNhien() {
        ArrayList<GiaoVien> dsGiaoVien = new ArrayList<GiaoVien>();
        for (GiaoVien gv : this.objDSGiaoVien.getListGiaoVien()) {
            if (gv.getThamNien() > 5 && gv.getChuyenMon().equalsIgnoreCase("tự nhiên")) {
                dsGiaoVien.add(gv);
            }
        }
        return dsGiaoVien;
    }


}
