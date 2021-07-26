/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOassignmentsof203;

import DTOAssignments.Diemsv;
import Sqlsever.Connect;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class DAOdiemsvimplements implements DAOdiemsv {

    private static Connect getconnect;
    
    public static Connection getconnection() throws Exception{
        Connection con=getconnect.getConnection();
        return con;
    }
    private ArrayList<Diemsv> ds;
    private ArrayList<Diemsv> lst;

    public DAOdiemsvimplements() {
        this.ds = new ArrayList<>();
        this.lst = new ArrayList<>();
    }

    @Override
    public ArrayList<Diemsv> xuatdatadsdiem() throws Exception {
        try ( Statement stmt = getconnection().createStatement()) {
            String SQL = "Select ID,hoten,qlsv.masv,ENGLISH,TINHOC,GDTC from QLDiem join qlsv on qlsv.masv=qldiem.masv";
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
    public void luudiem() throws Exception {
        try {
            Statement s = getconnection().createStatement();
            for (Diemsv x : this.lst) {
                String filesql = "Insert into QLDiem values ('" + x.getId() + "','"
                        + x.getMasv() + "','" + x.getMarkE() + "','"
                        + x.getMarkT() + "','" + x.getMarkP() + "')";
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
    public ArrayList<Diemsv> xuatdsdiem() {
        return this.ds;
    }

    @Override
    public void deleteđiem(int ma) throws Exception {
        try {
            Statement ps = getconnection().createStatement();
            ps.executeUpdate("DELETE from QLDiem where ID='" + ma + "'");
            getconnection().commit();
            getconnection().close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatediem(String ma,String markE,String markT,String markP,int i) throws Exception {
        try {
            String SQL = "update qldiem set masv=?,English=?,TINHOC =?,GDTC=? where ID=?;";
            PreparedStatement ps = getconnection().prepareStatement(SQL);
            ps.setString(1, ma);
            ps.setString(2, markE);
            ps.setString(3, markT);
            ps.setString(4, markP);
            ps.setString(5, this.xuatdsdiem().get(i+1).getId() + "");
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
    public ArrayList<Diemsv> xuatlstdiem(){
        return this.lst;
    }

    @Override
    public void themdiem(Diemsv sv) throws Exception {
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
    public ArrayList<Diemsv> xuatdsexcel() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
