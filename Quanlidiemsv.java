package doagainassignmentsof203;

import DAOassignmentsof203.DAO;
import DAOassignmentsof203.DAOSinhvien;
import DAOassignmentsof203.DAOdiem;
import DAOassignmentsof203.DAOdiemsv;
import DAOassignmentsof203.DAOdiemsvimplements;
import DAOassignmentsof203.DAOsv;
import DAOassignmentsof203.DAOsvimplements;
import DTOAssignments.Diemsv;
import DTOAssignments.Sinhvien;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Quanlidiemsv extends javax.swing.JInternalFrame {

   // DAOSinhvien listsv = new DAOsvimplements();
    DAO<Diemsv> dsdiem = new DAOdiem();
    private ArrayList<Diemsv> dsupdate=new ArrayList<>();
    private ArrayList<String> dsdelete=new ArrayList<>();
    String[] theag = {"Masv", "Họ Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB"};
    DefaultTableModel model = new DefaultTableModel(theag, 0);
    private JDesktopPane desktopPane;
    int i = -1;

    public Quanlidiemsv(JDesktopPane mdi) {
        initComponents();
        this.desktopPane = mdi;
        this.tbldiemsv.setModel(model);
        indata();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        btntim = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblten = new javax.swing.JLabel();
        lblma = new javax.swing.JLabel();
        lblta = new javax.swing.JLabel();
        lblTH = new javax.swing.JLabel();
        lblGDTC = new javax.swing.JLabel();
        lblDTB = new javax.swing.JLabel();
        txtgdtc = new javax.swing.JTextField();
        txttinhoc = new javax.swing.JTextField();
        txttienganh = new javax.swing.JTextField();
        txtmasv = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        txtdtb = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnloadexcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldiemsv = new javax.swing.JTable();
        btnthoat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbbtt = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbthutu = new javax.swing.JComboBox<>();
        btnsx = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Quản Lí Điểm Sinh Viên");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tìm Kiếm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel2.setText("Mã SV");

        btntim.setText("Tìm");
        btntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntim))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblten.setText("Họ Tên");

        lblma.setText("Mã SV");

        lblta.setText("Tiếng Anh");

        lblTH.setText("Tin Học");

        lblGDTC.setText("Giáo Dục TC");

        lblDTB.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblDTB.setText("Trung Bình");

        txthoten.setEnabled(false);

        txtdtb.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtdtb.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDTB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdtb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGDTC)
                            .addComponent(lblTH)
                            .addComponent(lblta)
                            .addComponent(lblma)
                            .addComponent(lblten))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtmasv, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttienganh, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttinhoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblten)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblma)
                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblta)
                    .addComponent(txttienganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTH)
                    .addComponent(txttinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGDTC)
                    .addComponent(txtgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDTB)
                    .addComponent(txtdtb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        btnloadexcel.setText("Loadexcel");
        btnloadexcel.setToolTipText("");
        btnloadexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadexcelActionPerformed(evt);
            }
        });

        tbldiemsv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbldiemsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldiemsvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldiemsv);

        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        jLabel3.setText("Thông tin");

        cbbtt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SV", "Họ Tên", "Điểm Tiếng Anh", "Điểm Tin Học", "Điểm GDTC", "Điểm Trung Bình" }));

        jLabel4.setText("Thứ Tự");

        cbbthutu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng Dần", "Giảm Dần" }));

        btnsx.setText("Sắp Xếp");
        btnsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsxActionPerformed(evt);
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnloadexcel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbthutu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnsx)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem)
                            .addComponent(btnluu)
                            .addComponent(btnsua)
                            .addComponent(btnxoa)
                            .addComponent(btnloadexcel))
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbbthutu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsx))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthoat)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if (check() && checktontai()) {
            Diemsv sv = new Diemsv();
            i = this.dsdiem.xuatdsd().size() + 1;
            sv.setId(i);
            sv.setMasv(txtmasv.getText());
            sv.setName(this.txthoten.getText());
            sv.setMarkE(Float.parseFloat(txttienganh.getText()));
            sv.setMarkP(Float.parseFloat(txttinhoc.getText()));
            sv.setMarkT(Float.parseFloat(txtgdtc.getText()));
            try {
                dsdiem.them(sv);
                createtable();
                clearform();
                JOptionPane.showMessageDialog(this, "nhập điểm thành công");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "nhập điểm thất bại");
            }

            i++;
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int row = tbldiemsv.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "xin mời chọn row để xóa");
        } else {
            try {
                int confirm = JOptionPane.showConfirmDialog(this, "bạn có chắc muốn xóa không???", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    this.dsdiem.deletesv(this.dsdiem.xuatdsd().get(row).getMasv());
                    
                    this.tbldiemsv.remove(row);
                    createtable();
                    JOptionPane.showMessageDialog(this, "xóa thành công");
                    clearform();
                    
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void tbldiemsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldiemsvMouseClicked
        int row = tbldiemsv.getSelectedRow();
        this.txtdtb.setText(this.tbldiemsv.getValueAt(row, 5) + "");
        this.txttienganh.setText(this.tbldiemsv.getValueAt(row, 2) + "");
        this.txtgdtc.setText(this.tbldiemsv.getValueAt(row, 4) + "");
        this.txttinhoc.setText(this.tbldiemsv.getValueAt(row, 3) + "");
        this.txtmasv.setText(this.tbldiemsv.getValueAt(row, 0) + "");
        this.txthoten.setText(this.tbldiemsv.getValueAt(row, 1) + "");
    }//GEN-LAST:event_tbldiemsvMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int row = tbldiemsv.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "xin mời chọn row để cập nhật");
        } else {

            try {

                //dsdiem.update(this.txtmasv.getText(), this.txtgdtc.getText(), this.txttienganh.getText(), this.txttinhoc.getText(), i);
                this.tbldiemsv.setValueAt(this.txtmasv.getText(), row, 0);
                this.tbldiemsv.setValueAt(this.txtgdtc.getText(), row, 4);
                this.tbldiemsv.setValueAt(this.txttienganh.getText(), row, 2);
                this.tbldiemsv.setValueAt(this.txttinhoc.getText(), row, 3);
                float a = (Float.parseFloat(this.txtgdtc.getText()) + Float.parseFloat(this.txtgdtc.getText()) + Float.parseFloat(this.txtgdtc.getText())) / 3;
                this.tbldiemsv.setValueAt(a, row, 5);
                //createtable();
                clearform();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "cập nhật thất bại");
            }
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
        try {
            this.dsdiem.luu(dsupdate,dsdelete);
            JOptionPane.showMessageDialog(this, "lưu dữ liệu thành công ");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "dữ liệu không được lưu vào database ");
        }
    }//GEN-LAST:event_btnluuActionPerformed

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
        try {
            dsdiem.search(this.txttimkiem.getText());
            this.txthoten.setText(dsdiem.xuatdsd().get(0).getName());
            this.txtmasv.setText(dsdiem.xuatdsd().get(0).getMasv());
            this.txttimkiem.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "sinh viên không tồn tại");
        }
    }//GEN-LAST:event_btntimActionPerformed

    private void btnloadexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadexcelActionPerformed
        try {
            dsdiem.themdiemvaoexcel();
            JOptionPane.showMessageDialog(this, "ghi dữ liệu vào excel thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "không ghi được vào excel");
        }
    }//GEN-LAST:event_btnloadexcelActionPerformed

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "bạn có chắc muốn thoát không???", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsxActionPerformed
        if (this.cbbthutu.getSelectedItem().toString().equalsIgnoreCase("Tăng Dần")) {
            if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Họ Tên")) {
                this.dsdiem.sapxeptdtensv(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Mã SV")) {
                this.dsdiem.sapxeptdmasv(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Điểm Tiếng Anh")) {
                this.dsdiem.sapxeptddiemta(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Điểm Tin Học")) {
                this.dsdiem.sapxeptddiemth(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Điểm GDTC")) {
                this.dsdiem.sapxeptddiemgdtc(this.dsdiem.xuatdsd());
                createtable();
            } else {
                this.dsdiem.sapxeptddtb(this.dsdiem.xuatdsd());
                createtable();
            }
        } else {
            if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Họ Tên")) {
                this.dsdiem.sapxepgdtensv(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Mã SV")) {
                this.dsdiem.sapxepgdmasv(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Điểm Tiếng Anh")) {
                this.dsdiem.sapxepgddiemta(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Điểm Tin Học")) {
                this.dsdiem.sapxepgddiemth(this.dsdiem.xuatdsd());
                createtable();
            } else if (this.cbbtt.getSelectedItem().toString().equalsIgnoreCase("Điểm GDTC")) {
                this.dsdiem.sapxepgddiemgdtc(this.dsdiem.xuatdsd());
                createtable();
            } else {
                this.dsdiem.sapxepgddtb(this.dsdiem.xuatdsd());
                createtable();
            }
        }
    }//GEN-LAST:event_btnsxActionPerformed

    private boolean check() {
        try {
            Float.parseFloat(this.txttienganh.getText());
            if (Float.parseFloat(this.txttienganh.getText()) < 0 || Float.parseFloat(this.txttienganh.getText()) > 10) {
                JOptionPane.showMessageDialog(this, "10>Điểm TA>0");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Điểm TA phải là số");
            return false;
        }
        try {
            Float.parseFloat(this.txtgdtc.getText());
            if (Float.parseFloat(this.txtgdtc.getText()) < 0 || Float.parseFloat(this.txtgdtc.getText()) > 10) {
                JOptionPane.showMessageDialog(this, "10>Điểm GDTC>0");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Điểm GDTC phải là số");
            return false;
        }
        try {
            Float.parseFloat(this.txttinhoc.getText());
            if (Float.parseFloat(this.txttinhoc.getText()) < 0 || Float.parseFloat(this.txttinhoc.getText()) > 10) {
                JOptionPane.showMessageDialog(this, "10>Điểm Tin học>0");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Điểm Tin học phải là số");
            return false;
        }
        return true;
    }

    private boolean checktontai() {
        for (Diemsv x : dsdiem.xuatdsd()) {
            if (x.getMasv().equalsIgnoreCase(this.txtmasv.getText())) {
                JOptionPane.showMessageDialog(this, "mã sinh viên đã đồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        for (Diemsv x : dsdiem.xuatlst()) {
            if (x.getMasv().equalsIgnoreCase(this.txtmasv.getText())) {
                JOptionPane.showMessageDialog(this, "mã sinh viên đã đồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void createtable() {
        model.setRowCount(0);
        for (Diemsv x : dsdiem.xuatdsd()) {
            Object[] row = new Object[]{x.getMasv(), x.getName(), x.getMarkE(), x.getMarkT(), x.getMarkP(), x.dtb()};
            model.addRow(row);
        }
    }

    private void clearform() {
        this.txtdtb.setText("");
        this.txthoten.setText("");
        this.txtmasv.setText("");
        this.txtgdtc.setText("");
        this.txttienganh.setText("");
        this.txttinhoc.setText("");
    }

    private void indata() {
        try {
            this.dsdiem.xuatdata();
            createtable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "không có dữ liệu");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnloadexcel;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnsx;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btntim;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbbthutu;
    private javax.swing.JComboBox<String> cbbtt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDTB;
    private javax.swing.JLabel lblGDTC;
    private javax.swing.JLabel lblTH;
    private javax.swing.JLabel lblma;
    private javax.swing.JLabel lblta;
    private javax.swing.JLabel lblten;
    private javax.swing.JTable tbldiemsv;
    private javax.swing.JTextField txtdtb;
    private javax.swing.JTextField txtgdtc;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txttienganh;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttinhoc;
    // End of variables declaration//GEN-END:variables
}
