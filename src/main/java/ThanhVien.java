/*
 * Mục đích: Các hàm, nghiệp vụ liên quan đến Thành Viên
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 19/10/2022
 * Version: 1.0
 * */
public class ThanhVien {
    protected String hoTen;
    protected String namSinh;
    protected String noiSinh;
    protected String diaChi;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ThanhVien(String hoTen, String namSinh, String noiSinh, String diaChi) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.noiSinh = noiSinh;
        this.diaChi = diaChi;
    }

    public ThanhVien() {
    }

    public void nhap() {
        this.hoTen = Nhap.inputString("Nhập họ tên: ");
        this.namSinh = Nhap.inputDate();
        this.noiSinh = Nhap.inputString("Nhập nơi sinh: ");
        this.diaChi = Nhap.inputString("Nhập địa chỉ: ");
    }
}
