/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOassignmentsof203;

import static DAOassignmentsof203.DAOdiemsvimplements.getconnection;
import DTOAssignments.Diemsv;
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
public class DAOdiem implements DAO<Diemsv>{
    private static Connect getconnect;
    
    public static Connection getconnection() throws Exception{
        Connection con=getconnect.getConnection();
        return con;
    }
    private ArrayList<Diemsv> ds;
    private ArrayList<Diemsv> lst;

    public DAOdiem() {
        this.ds = new ArrayList<>();
        this.lst = new ArrayList<>();
    }

    @Override
    public void them(Diemsv sv){
        this.ds.add(sv);
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
        cellH = row1.createCell((short) 0);
        cellB = row1.createCell((short) 1);
        cellC = row1.createCell((short) 2);
        cellD = row1.createCell((short) 3);
        cellE = row1.createCell((short) 4);
        cellF = row1.createCell((short) 5);
        cellG = row1.createCell((short) 6);
        cellH.setCellValue("ID");
        cellB.setCellValue("Mã SV");
        cellC.setCellValue("Họ Và Tên");
        cellD.setCellValue("Điểm TA");
        cellE.setCellValue("Điểm TH");
        cellF.setCellValue("Điểm GDTC");
        cellG.setCellValue("Điểm TB");
        for (int i = 0; i < this.ds.size(); i++) {
            row = sheet.createRow((short) i + 1);
            cellH = row.createCell((short) 0);
            cellH.setCellValue(ds.get(i).getId());
            cellB = row.createCell((short) 1);
            cellB.setCellValue(ds.get(i).getMasv());
            cellC = row.createCell((short) 2);
            cellC.setCellValue(ds.get(i).getName());
            cellD = row.createCell((short) 3);
            cellD.setCellValue(ds.get(i).getMarkE());
            cellE = row.createCell((short) 4);
            cellE.setCellValue(ds.get(i).getMarkP());
            cellF = row.createCell((short) 5);
            cellF.setCellType(CellType.NUMERIC);
            cellF.setCellValue(ds.get(i).getMarkT());
            cellG = row.createCell((short) 6);
            cellG.setCellType(CellType.NUMERIC);
            cellG.setCellValue(ds.get(i).dtb());
        }
        xssfw.write(fos);
        xssfw.close();
        fos.close();
    }



    @Override
    public void deletesv(String ma) throws Exception {
        try {
            Statement ps = getconnection().createStatement();
            ps.executeUpdate("DELETE from QLDiem where masv='" + ma + "'");
            getconnection().commit();
            getconnection().close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }




    @Override
    public void luu(ArrayList<Diemsv> update,ArrayList<String> delete) throws Exception {
        try {
            Statement s = getconnection().createStatement();
            for (Diemsv x : this.lst) {
                String filesql = "Insert into Diem values ('" + x.getId() + "','"
                        + x.getMasv() + "','" + x.getMarkE() + "','"
                        + x.getMarkT() + "','" + x.getMarkP() + "')";
                s.addBatch(filesql);
            }
            for (Diemsv x : update) {
                //"update Diem set English=?,TINHOC =?,GDTC=? where masv=?;"
                String filesql = "update diem set English='" + x.getMarkE()+ "',TinHOc='"
                        
                        + x.getMarkT()+ "',GDTC'" + x.getMarkP()+ "'where masv='"
                        + x.getMasv()+ "'";
                s.addBatch(filesql);
            }
            for (String x : delete) {
                String filesql = "delete from diem where masv= '" + x+ "')";
                s.addBatch(filesql);
            }
            getconnection().commit();
            s.executeBatch();
            s.close();
            getconnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<Diemsv> xuatdata() throws Exception {
        try ( Statement stmt = getconnection().createStatement()) {
            String SQL = "Select ID,hoten,sinhvien.masv,ENGLISH,TINHOC,GDTC from Diem join sinhvien on SINHVIEN.masv=Diem.masv";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Diemsv sv = new Diemsv();
                sv.setName(rs.getString("hoten"));
                sv.setId(Integer.parseInt(rs.getString("ID")));
                sv.setMasv(rs.getString("masv"));
                sv.setMarkE(Float.parseFloat(rs.getString("ENGLISH")));
                sv.setMarkT(Float.parseFloat(rs.getString("TINHOC")));
                sv.setMarkP(Float.parseFloat(rs.getString("GDTC")));
                this.ds.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return this.ds;
    }

    @Override
    public ArrayList<Diemsv> xuatdsd() {
        return this.ds;
    }

    @Override
    public ArrayList<Diemsv> xuatlst() {
       return this.lst;
    }

    @Override
    public void update(ArrayList<Diemsv> sv) throws Exception {
        try {
            String SQL = "update Diem set English=?,TINHOC =?,GDTC=? where masv=?;";
            PreparedStatement ps = getconnection().prepareStatement(SQL);
            ps.setFloat(1, sv.get(0).getMarkE());
            ps.setFloat(2, sv.get(0).getMarkT());
            ps.setFloat(3, sv.get(0).getMarkP());
            ps.setString(4, sv.get(0).getMasv());
            ps.executeUpdate();
            getconnection().commit();
            getconnection().close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
