/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOassignmentsof203;

import static DAOassignmentsof203.DAOsvimplements.getconnection;
import DTOAssignments.Diemsv;
import DTOAssignments.Sinhvien;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 * @param <T>
 */
public interface DAO<T> {
    public ArrayList<T> xuatdata() throws Exception;

    public ArrayList<T> xuatdsd();

    public ArrayList<T> xuatlst();

    public void them(T sv);

    public void themdiemvaoexcel() throws Exception;

    public void deletesv(String ma) throws Exception;

    public void update(ArrayList<T> sv) throws Exception;

    public void luu(ArrayList<T> update,ArrayList<String> delete) throws Exception;

    default ArrayList<Sinhvien> search(String a) throws Exception{
        ArrayList<Sinhvien> lstsv=new ArrayList<>();
        try {
            String SQL = "Select hoten,qlsv.masv,English,Tinhoc,gdtc from QLDiem full join qlsv on qlsv.masv=qldiem.masv where qlsv.masv='" + a + "'";
            Statement stmt = getconnection().createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Sinhvien sv = new Sinhvien();
                sv.setName(rs.getString("hoten"));
                sv.setMasv(rs.getString("MAsv"));
                lstsv.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }   
        return lstsv;
    };

    default void sapxeptddtb(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.dtb();
            Float d2 = o2.dtb();
            return d1.compareTo(d2);
        });
    }

    default void sapxepgddtb(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.dtb();
            Float d2 = o2.dtb();
            return d2.compareTo(d1);
        });
    }

    default void sapxeptddiemta(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkE();
            Float d2 = o2.getMarkE();
            return d2.compareTo(d1);
        });
    }

    default void sapxepgddiemta(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkE();
            Float d2 = o2.getMarkE();
            return d2.compareTo(d1);
        });
    }

    default void sapxeptddiemth(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkT();
            Float d2 = o2.getMarkT();
            return d2.compareTo(d1);
        });
    }

    default void sapxepgddiemth(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkT();
            Float d2 = o2.getMarkT();
            return d2.compareTo(d1);
        });
    }
    
    default void sapxeptddiemgdtc(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkP();
            Float d2 = o2.getMarkP();
            return d2.compareTo(d1);
        });
    }

    default void sapxepgddiemgdtc(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            Float d1 = o1.getMarkP();
            Float d2 = o2.getMarkP();
            return d2.compareTo(d1);
        });
    }
    
    default void sapxeptdtensv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
    }

    default void sapxepgdtensv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o2.getName().compareTo(o1.getName());
        });
    }
    
    default void sapxeptdmasv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o1.getMasv().compareTo(o2.getMasv());
        });
    }

    default void sapxepgdmasv(ArrayList<Diemsv> ds) {
        ds.sort((o1, o2) -> {
            return o2.getMasv().compareTo(o1.getMasv());
        });
    }
}
