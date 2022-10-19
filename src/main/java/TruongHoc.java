import java.util.ArrayList;
import java.util.Collection;
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

    public void taoDuLieu() {
        this.objDSHocSinh = new DanhSachHocSinh();
        this.objDSHocSinh.taoDuLieu();

        this.objDSGiaoVien = new DanhSachGiaoVien();
        this.objDSGiaoVien.taoDuLieu();
    }

    public void nhap() {
        ThanhVien thanhVien;
        while (true) {
            System.out.println("1. Học sinh");
            System.out.println("2. Giáo viên");
            System.out.println("3. Thoát");
            int choice = Nhap.inputInt("Mời lựa chọn: ");
            int temptChoice = 0;
            switch (choice) {
                case 1:
                    thanhVien = new HocSinh();
                    thanhVien.nhap();
                    this.objDSHocSinh.getListHocSinh().add((HocSinh) thanhVien);
//                    this.tinhDiemTB();

                    break;
            }
        }
    }

    public void xuatDSHocSinh() {
        this.objDSHocSinh.xuat();
    }

    public void xepLoaiHS() {
        this.objDSHocSinh.xepLoai();
    }

    public void tinhDiemTB() {
        this.objDSHocSinh.tinhDiemTB();
    }

    public void xuatDSGiaoVien() {
        this.objDSGiaoVien.xuat();
    }

    public void tinhThamNien() {
        this.objDSGiaoVien.tinhThamNien();
    }

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

    public static void sapXepDTBGiamDan(ArrayList<HocSinh> dsHocSinh, int left, int right) {
        float pivot = dsHocSinh.get((left + (right - left) / 2)).getDiemTB();
        int i = left;
        int j = right;
        while (i <= j) {
            while (dsHocSinh.get(i).getDiemTB() > pivot) {
                i++;
            }
            while (dsHocSinh.get(i).getDiemTB() < pivot) {
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
}
