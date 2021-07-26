/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOassignmentsof203;

import static DAOassignmentsof203.DAOsvimplements.getconnection;
import DTOAssignments.Sinhvien;
import Sqlsever.Connect;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PC
 */
public class DAOsv implements DAO<Sinhvien>{
    private static Connect getconnect;
    
    public static Connection getconnection() throws Exception{
        Connection con=getconnect.getConnection();
        return con;
    }
    private ArrayList<Sinhvien> lst;
    private ArrayList<Sinhvien> lst1;
    public DAOsv() {
        this.lst=new ArrayList<>();
        this.lst1=new ArrayList<>();
    }
    @Override
    public ArrayList<Sinhvien> xuatdata() throws Exception {
        try (Statement stmt = getconnection().createStatement()) {
            String SQL = "SELECT * FROM SINHVIEN";
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
    public ArrayList<Sinhvien> xuatdsd() {
       return this.lst;
    }

    @Override
    public ArrayList<Sinhvien> xuatlst() {
        return this.lst1;
    }

    @Override
    public void them(Sinhvien sv){
        this.lst1.add(sv);
        this.lst.add(sv);
    }

    @Override
    public void themdiemvaoexcel() throws Exception {
        FileOutputStream fos = new FileOutputStream("src/assignmentsof301/diemsv1.xlsx");
        XSSFWorkbook xssfw = new XSSFWorkbook();
        XSSFSheet sheet = xssfw.createSheet("diemsv");
        XSSFRow row, row1;
        XSSFCell cellB, cellC, cellD, cellE, cellF, cellG,cellH;
        row1 = sheet.createRow((short) 0);
        cellH = row1.createCell((short) 7);
        cellB = row1.createCell((short) 1);
        cellC = row1.createCell((short) 2);
        cellD = row1.createCell((short) 3);
        cellE = row1.createCell((short) 4);
        cellF = row1.createCell((short) 5);
        cellG = row1.createCell((short) 6);
        cellB.setCellValue("Mã SV");
        cellC.setCellValue("Họ Và Tên");
        cellD.setCellValue("Giới Tính");
        cellE.setCellValue("Địa Chỉ");
        cellF.setCellValue("Gmail");
        cellG.setCellValue("Img");
        cellH.setCellValue("SDT");
        for (int i = 0; i < this.lst.size(); i++) {
            row = sheet.createRow((short) i + 1);
            cellB = row.createCell((short) 0);
            cellB.setCellValue(lst.get(i).getMasv());
            cellC = row.createCell((short) 1);
            cellC.setCellValue(lst.get(i).getName());
            cellD = row.createCell((short) 2);
            cellD.setCellValue(lst.get(i).getGender());
            cellE = row.createCell((short) 3);
            cellE.setCellValue(lst.get(i).getAddress());
            cellF = row.createCell((short) 4);
            cellF.setCellValue(lst.get(i).getEmail());
            cellG = row.createCell((short) 5);
            cellG.setCellValue(lst.get(i).getImg());
            cellH = row.createCell((short) 6);
            cellH.setCellValue(lst.get(i).getSdt());
        }
        xssfw.write(fos);
        xssfw.close();
        fos.close();
    }

    @Override
    public void deletesv(String ma) throws Exception {
        try{
            System.out.println(ma);
            PreparedStatement ps = getconnect.getConnection().prepareStatement("Delete from Diem where masv=?;DELETE from SINHVIEN where masv=?");
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
    public void update(ArrayList<Sinhvien> sv) throws Exception {
        try {
            String SQL = "Update SINHVIEN set hoten=?,email=?,sdt=?,Gender=?,diachi=?,img=? where masv=?";
            PreparedStatement ps = getconnection().prepareStatement(SQL);
            ps.setString(1, sv.get(0).getName());
            ps.setString(2, sv.get(0).getEmail());
            ps.setString(3, sv.get(0).getSdt());
            ps.setString(4, sv.get(0).getGender());
            ps.setString(5, sv.get(0).getAddress());
            ps.setString(6, sv.get(0).getImg());
            ps.setString(7, sv.get(0).getMasv());
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
    public void luu(ArrayList<Sinhvien> update,ArrayList<String> delete) throws Exception {
        try {
            Statement ps = getconnection().createStatement();
            for (Sinhvien x : this.lst1) {
                String SQL = "Insert into SINHVIEN values ('" + x.getMasv() + "',N'"
                        + x.getName() + "','" + x.getEmail() + "','" + x.getSdt() + "',N'"
                        + x.getGender() + "',N'" + x.getAddress() + "','" + x.getImg() + "');";
                ps.addBatch(SQL);
            }
            for (Sinhvien x : update) {
                String SQL = "UPDATE SINHVIEN SET HOTEN=N'" + x.getName()+ "',EMAIL='" + x.getEmail() + "',SDT='" + x.getSdt() + "',GENDER=N'"
                        + x.getGender() + "',DIACHI=N'" + x.getAddress() + "',IMG='" + x.getImg() + "'where MASV='"
                        + x.getMasv()+ "'";
                ps.addBatch(SQL);
            }
            for (String x : delete) {
                String SQL = "Delete from Diem where masv='"+x+"';DELETE from SINHVIEN where masv='"+x+"'";
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
}
