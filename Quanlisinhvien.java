package doagainassignmentsof203;

import DAOassignmentsof203.DAO;
import DAOassignmentsof203.DAOSinhvien;
import DAOassignmentsof203.DAOsv;
import DAOassignmentsof203.DAOsvimplements;
import DTOAssignments.Sinhvien;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Quanlisinhvien extends javax.swing.JInternalFrame {

    private DAOSinhvien listsv = new DAOsvimplements();
    private DAO<Sinhvien> dssvDao=new DAOsv();
    private ArrayList<Sinhvien> lstupdate=new ArrayList<>();
    private ArrayList<String> lstdelete=new ArrayList<>();
    String[] thead = {"Mã Sv", "Họ Tên", "Giới Tính", "Địa Chỉ", "Phone", "Email"};
    DefaultTableModel model = new DefaultTableModel(thead, 0);
    String namefile;
    private int count=0;
    private JDesktopPane desktopPane;

    public Quanlisinhvien(JDesktopPane idm) {
        this.desktopPane = idm;
        initComponents();
        //this.setResizable(false);
        this.tblsv.setModel(model);
        displaydata();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblmasv = new javax.swing.JLabel();
        lblten = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblsdt = new javax.swing.JLabel();
        lblphai = new javax.swing.JLabel();
        lblque = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtque = new javax.swing.JTextArea();
        radionam = new javax.swing.JRadioButton();
        radionu = new javax.swing.JRadioButton();
        txtsdt = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtmasv = new javax.swing.JTextField();
        pnlimg = new javax.swing.JPanel();
        btnimg = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsv = new javax.swing.JTable();
        btnthoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Quản Lí Sinh Viên");

        lblmasv.setText("Masv");

        lblten.setText("Họ Tên");

        lblemail.setText("Email");

        lblsdt.setText("Số ĐT");

        lblphai.setText("Giới Tính");

        lblque.setText("Quê Quán");

        txtque.setColumns(20);
        txtque.setRows(5);
        jScrollPane1.setViewportView(txtque);

        buttonGroup1.add(radionam);
        radionam.setSelected(true);
        radionam.setText("Nam");

        buttonGroup1.add(radionu);
        radionu.setText("Nữ");

        pnlimg.setLayout(new java.awt.GridLayout(1, 0));

        btnimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimgActionPerformed(evt);
            }
        });
        pnlimg.add(btnimg);

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnluu.setText("Lưu");
        btnluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        tblsv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsvMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblsv);

        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        jLabel2.setText("Sắp xếp");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SV", "Tên SV", "Giới Tính", "Quê Quán" }));

        jLabel3.setText("Thứ Tự");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng dần", "Giảm dần" }));

        jButton1.setText("Sắp Xếp");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblque)
                                    .addComponent(lblphai)
                                    .addComponent(lblsdt)
                                    .addComponent(lblemail)
                                    .addComponent(lblten)
                                    .addComponent(lblmasv))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radionam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radionu))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtmasv, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtten, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(pnlimg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(btnluu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnthem)
                        .addGap(18, 18, 18)
                        .addComponent(btnluu)
                        .addGap(18, 18, 18)
                        .addComponent(btnsua)
                        .addGap(18, 18, 18)
                        .addComponent(btnxoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnthoat))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmasv)
                            .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblten)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblemail)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblsdt)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblphai)
                            .addComponent(radionam)
                            .addComponent(radionu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblque)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlimg, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimgActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("img", "png", "jpg");
        jfc.setFileFilter(fnef);
        jfc.setMultiSelectionEnabled(false);
        this.btnimg.setSize(160, 220);
        this.pnlimg.setSize(160, 220);
        int ktr = jfc.showDialog(this, "chọn file");
        if (ktr == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            namefile = f.getAbsolutePath();
            this.btnimg.setIcon(new ImageIcon(namefile));

        }
    }//GEN-LAST:event_btnimgActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if (check() == true && checktontai() == true) {
            Sinhvien sv = dulieu();
            dssvDao.them(sv);
            listtable();
            reset();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int row = this.tblsv.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "xin mời chọn sv để xóa");
        } else {
            try {
                this.lstdelete.add(this.tblsv.getValueAt(row, 0).toString());
                this.model.removeRow(row);
                //this.dssvDao.deletesv(this.tblsv.getValueAt(row, 0).toString());
                reset();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "xóa thất bại");
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int row = this.tblsv.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "xin mời chọn sv để cập nhật");
        } else {
            if (check()) {
                try {
                    Sinhvien sv=dulieu();
                    lstupdate.add(sv);
                    this.model.setValueAt(sv.getName(), row, 1);
                    this.model.setValueAt(sv.getEmail(), row, 5);
                    this.model.setValueAt(sv.getAddress(), row, 3);
                    this.model.setValueAt(sv.getMasv(), row, 0);
                    this.model.setValueAt(sv.getSdt(), row, 4);
                    this.model.setValueAt(sv.getGender(), row, 2);
                    //this.dssvDao.update(lstupdate);
                    reset();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "cập nhật thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
        try {
            dssvDao.luu(lstupdate,lstdelete);
            JOptionPane.showMessageDialog(this, "Lưu Thành Công", "Thông báo", JOptionPane.NO_OPTION);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lưu thất bại", "Thông báo", JOptionPane.NO_OPTION);
        }
    }//GEN-LAST:event_btnluuActionPerformed

    private void tblsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsvMouseClicked
        int row = this.tblsv.getSelectedRow();
        this.txtemail.setText((this.tblsv.getValueAt(row, 5) + "").replaceAll("\\s", ""));
        this.txtque.setText(this.tblsv.getValueAt(row, 3) + "");
        this.txtmasv.setText(this.tblsv.getValueAt(row, 0) + "");
        this.txtten.setText(this.tblsv.getValueAt(row, 1) + "");
        this.txtsdt.setText(this.tblsv.getValueAt(row, 4) + "");
        try {
            this.btnimg.setIcon(new ImageIcon(this.listsv.xuatdatadssv().get(row).getImg()));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "sinh viên không có ảnh thẻ");
        }
        String readgender = this.tblsv.getValueAt(row, 2) + "";
        if (readgender.equalsIgnoreCase("Nam")) {
            this.radionam.setSelected(true);
        } else {
            this.radionu.setSelected(true);
        }
    }//GEN-LAST:event_tblsvMouseClicked

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnthoatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void displaydata() {

        try {
            dssvDao.xuatdata();
            listtable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không có dữ liệu");
        }
    }

    private Sinhvien dulieu(){
        Sinhvien sv=new Sinhvien();
            sv.setAddress(this.txtque.getText());
            sv.setEmail(this.txtemail.getText());
            sv.setMasv(this.txtmasv.getText());
            sv.setName(this.txtten.getText());
            sv.setSdt(this.txtsdt.getText());
            sv.setImg(namefile);
            System.out.println(namefile);
            if (this.radionam.isSelected()) {
                sv.setGender("Nam");
            } else {
                sv.setGender("Nữ");
            }
            return sv;  
    }
    private boolean check() {
        if (this.txtemail.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Email Không được bỏ trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.txtque.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ Không được bỏ trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.txtmasv.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Mã SV Không được bỏ trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.txtten.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Họ Tên Không được bỏ trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.txtsdt.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Số ĐT Không được bỏ trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean checktontai() {
        for (Sinhvien x : dssvDao.xuatdsd()) {
            if (x.getMasv().equalsIgnoreCase(this.txtmasv.getText())) {
                JOptionPane.showMessageDialog(this, "mã sinh viên đã đồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        for (Sinhvien x : dssvDao.xuatlst()) {
            if (x.getMasv().equalsIgnoreCase(this.txtmasv.getText())) {
                JOptionPane.showMessageDialog(this, "mã sinh viên đã đồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void reset() {
        this.txtemail.setText("");
        this.txtque.setText("");
        this.txtmasv.setText("");
        this.txtten.setText("");
        this.txtsdt.setText("");
        this.radionam.setSelected(true);
    }

    private void listtable() {
        model.setRowCount(0);
        for (Sinhvien x : this.dssvDao.xuatdsd()) {
            Object[] row;
            row = new Object[]{x.getMasv(), x.getName(), x.getGender(), x.getAddress(), x.getSdt(), x.getEmail()};
            model.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimg;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblmasv;
    private javax.swing.JLabel lblphai;
    private javax.swing.JLabel lblque;
    private javax.swing.JLabel lblsdt;
    private javax.swing.JLabel lblten;
    private javax.swing.JPanel pnlimg;
    private javax.swing.JRadioButton radionam;
    private javax.swing.JRadioButton radionu;
    private javax.swing.JTable tblsv;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextArea txtque;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
