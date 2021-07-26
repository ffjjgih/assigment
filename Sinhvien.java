package DTOAssignments;

public class Sinhvien {

    private String masv, name, address, email, sdt, gender, img;

    public Sinhvien(String masv, String name, String address, String email, String sdt, String gender, String img) {
        this.masv = masv;
        this.name = name;
        this.address = address;
        this.email = email;
        this.sdt = sdt;
        this.gender = gender;
        this.img = img;
    }

    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Sinhvien() {
    }

    public String getMasv() {
        return masv;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public String getGender() {
        return gender;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
