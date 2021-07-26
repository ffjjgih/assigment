package DAOassignmentsof203;

import DTOAssignments.Sinhvien;
import java.util.ArrayList;

public interface DAOSinhvien {

    public void themsv(Sinhvien sv);

    public void deletesv(int i, String ma) throws Exception;

    public void updatesv(String Ma, String ten, String gmail, String dchi, String phone, String phai, String img, int i) throws Exception;

    public ArrayList<Sinhvien> xuatdssv();

    public ArrayList<Sinhvien> xuatlstsv();

    public void luusv() throws Exception;

    public ArrayList<Sinhvien> xuatdatadssv() throws Exception;

    public ArrayList<Sinhvien> search(String a) throws Exception;
    
    
}
