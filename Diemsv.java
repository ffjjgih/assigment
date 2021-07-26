package DTOAssignments;

public class Diemsv {

    private String masv, name;
    private float markE, markT, markP;
    private int id;

    public Diemsv() {
    }

    public Diemsv(String masv, String name, float markE, float markT, float markP) {
        this.masv = masv;
        this.name = name;
        this.markE = markE;
        this.markT = markT;
        this.markP = markP;
    }

    public String getMasv() {
        return masv;
    }

    public String getName() {
        return name;
    }

    public float getMarkE() {
        return markE;
    }

    public float getMarkT() {
        return markT;
    }

    public float getMarkP() {
        return markP;
    }

    public int getId() {
        return id;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarkE(float markE) {
        this.markE = markE;
    }

    public void setMarkT(float markT) {
        this.markT = markT;
    }

    public void setMarkP(float markP) {
        this.markP = markP;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float dtb() {
        return (this.markE + this.markP + this.markT) / 3;
    }
}
