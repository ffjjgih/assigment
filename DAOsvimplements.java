/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOassignmentsof203;

import DTOAssignments.Sinhvien;
import Sqlsever.Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DAOsvimplements implements DAOSinhvien{
    private static Connect getconnect;
    
    public static Connection getconnection() throws Exception{
        Connection con=getconnect.getConnection();
        return con;
    }
    private ArrayList<Sinhvien> lst;
    private ArrayList<Sinhvien> lst1;
    public DAOsvimplements() {
        this.lst=new ArrayList<>();
        this.lst1=new ArrayList<>();
    }
    
    @Override
    public void themsv(Sinhvien sv) {
        this.lst1.add(sv);
        this.lst.add(sv);
    }

    @Override
    public void deletesv(int i, String ma) throws Exception {
        try{
            this.lst.remove(i);
            PreparedStatement ps = getconnect.getConnection().prepareStatement("Delete from QLDiem where masv=?;DELETE from QLSV where masv=?");
            ps.setString(1, ma);
            ps.setString(2, ma);
            ps.executeUpdate();
            getconnection().commit();
            getconnection().close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatesv(String Ma, String ten, String gmail, String dchi, String phone, String phai, String img, int i) throws Exception {
        try {
            String SQL = "update qldiem set masv=? where masv=?;Update QLSV set masv=?,hoten=?,email=?,sdt=?,Gender=?,diachi=?,img=? where masv=?";
            PreparedStatement ps = getconnection().prepareStatement(SQL);
            ps.setString(2, this.xuatdssv().get(i).getMasv());
            ps.setString(1, Ma);
            ps.setString(3, Ma);
            ps.setString(4, ten);
            ps.setString(5, gmail);
            ps.setString(6, phone);
            ps.setString(8, dchi);
            ps.setString(7, phai);
            ps.setString(9, img);
            ps.setString(10, this.xuatdssv().get(i).getMasv());
            ps.executeUpdate();
            getconnection().commit();
            getconnection().close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<Sinhvien> xuatdssv() {
        return this.lst;
    }

    @Override
    public void luusv() throws Exception {
        try {
            Statement ps = getconnection().createStatement();
            for (Sinhvien x : this.lst1) {
                String SQL = "Insert into QLSV values ('" + x.getMasv() + "',N'"
                        + x.getName() + "','" + x.getEmail() + "','" + x.getSdt() + "',N'"
                        + x.getGender() + "',N'" + x.getAddress() + "','" + x.getImg() + "');";
                ps.addBatch(SQL);
            }
            getconnection().commit();
            ps.executeBatch();
            getconnection().close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<Sinhvien> xuatdatadssv() throws Exception {
        try (Statement stmt = getconnection().createStatement()) {
            String SQL = "SELECT * FROM sinhvien";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Sinhvien sv = new Sinhvien();
                sv.setAddress(rs.getString("diachi"));
                sv.setEmail(rs.getString("Email"));
                sv.setGender(rs.getString("Gender"));
                sv.setMasv(rs.getString("Masv"));
                sv.setName(rs.getString("hoten"));
                sv.setSdt(rs.getString("SDT"));
                sv.setImg(rs.getString("img"));
                this.lst.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return this.lst;
    }

    @Override
    public ArrayList<Sinhvien> search(String a) throws Exception {
        try {
            String SQL = "Select hoten,qlsv.masv,English,Tinhoc,gdtc from QLDiem full join qlsv on qlsv.masv=qldiem.masv where qlsv.masv='" + a + "'";
            Statement stmt = getconnection().createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Sinhvien sv = new Sinhvien();
                sv.setName(rs.getString("hoten"));
                sv.setMasv(rs.getString("MAsv"));
                this.themsv(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }   
        return this.lst;
    }

    @Override
    public ArrayList<Sinhvien> xuatlstsv() {
        return this.lst1;
    }
    
}
