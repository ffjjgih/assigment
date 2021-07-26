/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOassignmentsof203;

import DTOAssignments.Admin;
import Sqlsever.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class DAOloginimplements implements DAOlogin {

    private static Connect getconnect;
    
    @Override
    public String chucvu(String account, String password) throws Exception {
        Admin v = new Admin();
        try  {
            String SQL = "SELECT rolefpt FROM loginfpt where accountfpt=? and passwordfpt=?";
            PreparedStatement ps=getconnect.getConnection().prepareStatement(SQL);
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                v.setRole(rs.getString("rolefpt"));
            }
            System.out.println(v.getRole());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return v.getRole();
    }
}

