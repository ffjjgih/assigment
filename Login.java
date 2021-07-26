package doagainassignmentsof203;

import DAOassignmentsof203.DAOlogin;
import DAOassignmentsof203.DAOloginimplements;
import DTOAssignments.Diemsv;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JInternalFrame {

    DAOlogin dao = new DAOloginimplements();
    JDesktopPane desktopPane;

    public Login(JDesktopPane mdi) {
        this.desktopPane = mdi;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltaikhoan = new javax.swing.JLabel();
        lblmatkhau = new javax.swing.JLabel();
        txttaikhoan = new javax.swing.JTextField();
        txtmatkhau = new javax.swing.JPasswordField();
        btndangnhap = new javax.swing.JButton();
        btnthoat = new javax.swing.JButton();

        lbltaikhoan.setText("Tài Khoản");

        lblmatkhau.setText("Mật Khẩu");

        btndangnhap.setText("Đăng Nhập");
        btndangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangnhapActionPerformed(evt);
            }
        });

        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbltaikhoan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblmatkhau)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtmatkhau)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btndangnhap)
                        .addGap(18, 18, 18)
                        .addComponent(btnthoat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltaikhoan)
                    .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmatkhau)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndangnhap)
                    .addComponent(btnthoat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangnhapActionPerformed
        try {
            Quanlidiemsv sv = new Quanlidiemsv(this.desktopPane);
            
            this.desktopPane.add(sv);
            Quanlisinhvien st = new Quanlisinhvien(this.desktopPane);
            this.desktopPane.add(st);
            String quanli = dao.chucvu(this.txttaikhoan.getText(), this.txtmatkhau.getText());
            System.out.println(quanli);
            if (quanli.equalsIgnoreCase("admin")) {
                this.dispose();
                st.setVisible(true);
                JOptionPane.showMessageDialog(this, "Admin");
            } else {
                this.dispose();
                sv.setVisible(true);
                JOptionPane.showMessageDialog(this, "teacher");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "ko có account trong database");
        }
    }//GEN-LAST:event_btndangnhapActionPerformed

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btnthoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndangnhap;
    private javax.swing.JButton btnthoat;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lbltaikhoan;
    private javax.swing.JPasswordField txtmatkhau;
    private javax.swing.JTextField txttaikhoan;
    // End of variables declaration//GEN-END:variables
}
