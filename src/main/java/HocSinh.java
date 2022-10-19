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
        String tieuDe = String.format("%5s%5s%5s%5s%5s",
                this.diemToan, this.diemVan, this.diemNgoaiNgu, this.diemTB, this.xepLoai);
        System.out.println(tieuDe);
    }

    public void tinhDiemTB() {
        this.diemTB = (this.diemToan + this.diemVan + this.diemNgoaiNgu) / 3;
    }

    public void xepLoai() {
        this.xepLoai = this.diemTB >= 9 ? "Xuất sắc"
                : this.diemTB >= 8 ? "Giỏi"
                : this.diemTB >= 7 ? "Khá"
                : this.diemTB >= 5 ? "Trung Bình"
                : "Yếu";
        

    }
}
