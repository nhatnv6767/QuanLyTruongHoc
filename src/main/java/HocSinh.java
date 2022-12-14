/*
 * Mục đích: Các hàm, nghiệp vụ liên quan đến Hoc Sinh
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 19/10/2022
 * Version: 1.0
 * */
public class HocSinh extends ThanhVien {
    private float diemToan;
    private float diemVan;
    private float diemNgoaiNgu;
    private float diemTB;
    private String xepLoai;

    public float getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }

    public float getDiemVan() {
        return diemVan;
    }

    public void setDiemVan(float diemVan) {
        this.diemVan = diemVan;
    }

    public float getDiemNgoaiNgu() {
        return diemNgoaiNgu;
    }

    public void setDiemNgoaiNgu(float diemNgoaiNgu) {
        this.diemNgoaiNgu = diemNgoaiNgu;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public HocSinh(String hoTen, String namSinh, String noiSinh, String diaChi, float diemToan, float diemVan, float diemNgoaiNgu) {
        super(hoTen, namSinh, noiSinh, diaChi);
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemNgoaiNgu = diemNgoaiNgu;

    }

    public HocSinh() {

    }

    @Override
    public void nhap() {
        super.nhap();
        this.diemToan = Nhap.inputFloat("Nhập điểm toán: ");
        this.diemVan = Nhap.inputFloat("Nhập điểm văn: ");
        this.diemNgoaiNgu = Nhap.inputFloat("Nhập điểm ngoại ngữ: ");
    }


    @Override
    public void xuat() {
        super.xuat();
        String tieuDe = String.format("%8s%8s%12s%14s%15s",
                this.diemToan, this.diemVan, this.diemNgoaiNgu, this.diemTB, this.xepLoai);
        System.out.println(tieuDe);
    }

    public void tinhDiemTB() {
        float dtb = (this.diemToan + this.diemVan + this.diemNgoaiNgu) / 3;
        this.diemTB = (float) (Math.round(dtb * 100.0) / 100.0);
    }

    public void xepLoai() {
        this.xepLoai = this.diemTB >= 9 ? "Xuất sắc"
                : this.diemTB >= 8 ? "Giỏi"
                : this.diemTB >= 7 ? "Khá"
                : this.diemTB >= 5 ? "Trung Bình"
                : "Yếu";


    }
}
