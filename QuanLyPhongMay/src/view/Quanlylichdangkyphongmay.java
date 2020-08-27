/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.DangKySuDungService;
import Service.MonHocService;
import Service.PhongMayService;
import java.util.List;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.ObjDoubleConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import object.GiaoVien;
import object.DangKySuDung;
import object.MonHoc;
import object.PhongMay;

/**
 *
 * @author Nam
 */
public class Quanlylichdangkyphongmay extends javax.swing.JFrame {

    /**
     * Creates new form Quanlyphongmay
     */
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    DangKySuDungService lichTrucService=null;
    DefaultTableModel  tableModel;
    public Quanlylichdangkyphongmay() {
        initComponents();
        lichTrucService= new DangKySuDungService();
        tableModel= (DefaultTableModel) jTable1.getModel();
        List<DangKySuDung> listLichTruc= lichTrucService.getAllDangKySuDung();
        System.out.println(listLichTruc);
        String[] rowData;
        for(DangKySuDung i: listLichTruc){
            rowData= new String[8];
            rowData[0]= i.getMaDangKy();
            rowData[1]=i.getPhongMay().getMaPhongMay();
            rowData[2]=i.getGiaoVien().getMaGiaoVien();
            rowData[3]= i.getGiaoVien().getTenGiaoVien();
            rowData[4]= i.getBatDau();
            rowData[5]= i.getKeThuc();
            rowData[6]= i.getMonHoc().getMaMonHoc();
            rowData[7]= i.getMonHoc().getTenMonHoc();
            tableModel.addRow(rowData);
        }
        String sql="select * from giaovien";
          loadCBMonHoc();
        String sql3="select * from phongmay";
        lichTrucService.LoadDataCB(sql, cbMaGiaoVien, "magiaovien");
        
        lichTrucService.LoadDataCB(sql3, cbMaPhong, "maphongmay");
        cbMaPhong.addItem("");
        //cbMaPhong.setSelectedItem("");
        cbMaMon.addItem("");
        //cbMaMon.setSelectedItem("");
        cbMaGiaoVien.addItem("");
        //cbMaGiaoVien.setSelectedItem("");
        setLocationRelativeTo(null);
    }
    
    public void loadCBMonHoc(){
      String sql2="select * from monhoc";
      lichTrucService.LoadDataCB(sql2, cbMaMon, "mamonhoc");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnThoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMaLichTruc = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        cbMaPhong = new javax.swing.JComboBox<>();
        cbMaGiaoVien = new javax.swing.JComboBox<>();
        cbMaMon = new javax.swing.JComboBox<>();
        txtTimMaMon = new javax.swing.JTextField();
        txtTimMaPhong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        chooserBatdau = new com.toedter.calendar.JDateChooser();
        chooserKetthuc = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý lịch đăng ký phòng máy ");

        btnXoa.setText("Xóa lịch đăng ký");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa lịch đăng ký");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lịch trực", "Mã phòng máy", "Mã giáo viên", "Tên giáo viên", "Thời gian bắt đầu  ", "Thời gian kết thúc", "Mã môn", "Tên môn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã phòng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã giáo viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Thời gian bắt đầu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian kết thúc");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mã môn");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnThem1.setText("Thêm lịch đăng ký");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mã lịch trực");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        cbMaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaMonActionPerformed(evt);
            }
        });

        jLabel8.setText("(tìm theo mã môn)");

        jLabel9.setText("(tìm theo mã phòng)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaLichTruc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbMaGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(txtTimMaMon))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(txtTimMaPhong))
                            .addComponent(chooserBatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chooserKetthuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(111, 111, 111)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(136, 136, 136))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 100, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel3))
                                    .addComponent(cbMaGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaLichTruc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTimMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(43, 43, 43)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooserBatdau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(chooserKetthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        new trangchu().setVisible(true);
        setVisible(false);        
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        DangKySuDung lichTruc = new DangKySuDung();
        lichTruc.setMaDangKy(txtMaLichTruc.getText());
        lichTruc.setPhongMay(new PhongMay(String.valueOf(cbMaPhong.getSelectedItem()), null, null));
        lichTruc.setGiaoVien(new GiaoVien(String.valueOf(cbMaGiaoVien.getSelectedItem()), null, null, 0));
        lichTruc.setMonHoc(new MonHoc(String.valueOf(cbMaMon.getSelectedItem()), null, null, null));
        lichTruc.setBatDau(String.valueOf(dateFormat.format(chooserBatdau.getDate()) ));
        lichTruc.setKeThuc(String.valueOf(dateFormat.format(chooserKetthuc.getDate()) ));
        //lichTruc.setBatDau(txtTGBatDau.getText());
        if(lichTrucService.addLichTruc(lichTruc)==0){
            //in ra 1 dialog thoong baos thanh cong
            JOptionPane.showMessageDialog(this, "Them thanh cong","thanh cong", JOptionPane.ERROR_MESSAGE);
            
        }else {
            JOptionPane.showMessageDialog(this, "K thanh cong","Lỗi", JOptionPane.ERROR_MESSAGE);
        };
        
        btnRefreshActionPerformed(evt);
        
    }//GEN-LAST:event_btnThem1ActionPerformed
    public void hienThi(List<DangKySuDung> listLichSuDung) {
        tableModel.setRowCount(0);
        for(DangKySuDung lichtruc:listLichSuDung){
            tableModel.addRow(new Object[]{lichtruc.getMaDangKy(),lichtruc.getPhongMay().getMaPhongMay(),
                lichtruc.getGiaoVien().getMaGiaoVien(), lichtruc.getGiaoVien().getTenGiaoVien(),lichtruc.getBatDau(),lichtruc.getKeThuc(), lichtruc.getMonHoc().getMaMonHoc(), lichtruc.getMonHoc().getTenMonHoc()});
        }
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tableModel.setRowCount(0);
        List<DangKySuDung> lichtrucs= lichTrucService.getAllDangKySuDung();
        for(DangKySuDung lichtruc:lichtrucs){
            tableModel.addRow(new Object[]{lichtruc.getMaDangKy(),lichtruc.getPhongMay().getMaPhongMay(),
                lichtruc.getGiaoVien().getMaGiaoVien(), lichtruc.getGiaoVien().getTenGiaoVien(),lichtruc.getBatDau(),lichtruc.getKeThuc(), lichtruc.getMonHoc().getMaMonHoc(), lichtruc.getMonHoc().getTenMonHoc()});
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row= jTable1.getSelectedRow();
       txtMaLichTruc.setText((String) jTable1.getValueAt(row, 0));
       cbMaPhong.setSelectedItem((String) jTable1.getValueAt(row, 1));
       cbMaGiaoVien.setSelectedItem((String) jTable1.getValueAt(row, 2));
       cbMaMon.setSelectedItem((String) jTable1.getValueAt(row, 6));
        try {
            chooserBatdau.setDate(dateFormat.parse((String) jTable1.getValueAt(row, 4)));
            chooserKetthuc.setDate(dateFormat.parse((String) jTable1.getValueAt(row, 5)));
        } catch (ParseException ex) {
            Logger.getLogger(Quanlylichdangkyphongmay.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row=jTable1.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn user trước","Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm=JOptionPane.showConfirmDialog(this, "Bạn muốn chắc chắn xóa không");
            if(confirm==JOptionPane.YES_OPTION){
                String malichtruc= (String) jTable1.getValueAt(row, 0);
                lichTrucService.DeleteDangKy(malichtruc);               
            }
        }
        btnRefreshActionPerformed(evt);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        DangKySuDung lichTruc=new DangKySuDung();
        lichTruc.setMaDangKy(txtMaLichTruc.getText());
        lichTruc.setPhongMay(new PhongMay(String.valueOf(cbMaPhong.getSelectedItem()),null,null));
        lichTruc.setGiaoVien(new GiaoVien(String.valueOf(cbMaGiaoVien.getSelectedItem()),null,null,0));
        lichTruc.setMonHoc(new MonHoc(String.valueOf(cbMaMon.getSelectedItem()),null,null,null));
        lichTruc.setBatDau(String.valueOf(dateFormat.format(chooserBatdau.getDate()) ));
        lichTruc.setKeThuc(String.valueOf(dateFormat.format(chooserKetthuc.getDate()) ));
        if(lichTrucService.UpdateDangKy(lichTruc)==0){
            //in ra 1 dialog thoong baos thanh cong
            JOptionPane.showMessageDialog(this, "Sua thanh cong","thanh cong", JOptionPane.ERROR_MESSAGE);
            
        }else {
            JOptionPane.showMessageDialog(this, "K thanh cong","Lỗi", JOptionPane.ERROR_MESSAGE);
        };
        btnRefreshActionPerformed(evt);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void cbMaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaMonActionPerformed
        // TODO add your handling code here:
        //load combo
        MonHoc mh = MonHocService.getMonHoc(String.valueOf(cbMaMon.getSelectedItem()));
        //JOptionPane.showMessageDialog(rootPane, mh.getMaMonHoc()+" - "+mh.getCauHinhMay()+" - "+mh.getPhanMem().getMaPhanMem());
       // JOptionPane.showMessageDialog(rootPane, mh.getCauHinhMay()+" - "+mh.getPhanMem().getMaPhanMem());
        ArrayList<PhongMay> li= PhongMayService.getPhongMayTheoCauHinh(mh.getCauHinhMay(),mh.getPhanMem().getMaPhanMem());
     //   JOptionPane.showMessageDialog(rootPane,li.size());
        DefaultComboBoxModel model = new DefaultComboBoxModel();       
        for(PhongMay it:li){
           model.addElement(it.getMaPhongMay());
          
        }
        cbMaPhong.setModel(model);
        cbMaPhong.setSelectedIndex(0);
    }//GEN-LAST:event_cbMaMonActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String malichtruc=null;
        PhongMay phongMay = null;
        GiaoVien giaoVien = null;
        MonHoc monHoc = null;
        String ngay = null;
       
        if (!txtTimMaPhong.getText().equals("")) {
            phongMay = new PhongMay(txtTimMaPhong.getText(), "", null);
        }
        if (!((String) cbMaGiaoVien.getSelectedItem()).equals("")) {
            giaoVien = new GiaoVien((String) cbMaGiaoVien.getSelectedItem(), "", "", 0);
        }
        if (!txtTimMaMon.getText().equals("")) {
            monHoc = new MonHoc(txtTimMaMon.getText(), "", null, "");
        }
        if (chooserBatdau.getDate()!=null) {
            ngay = String.valueOf(dateFormat.format(chooserBatdau.getDate()));
        } else if (chooserKetthuc.getDate()!=null) {
            ngay = String.valueOf(dateFormat.format(chooserKetthuc.getDate()));
        }
//        if (!txtTGBatDau.getText().equals("")) {
//            ngay = txtTGBatDau.getText();
//        } else if (!txtTGKetThuc.getText().equals("")) {
//            ngay = txtTGKetThuc.getText();
//        }
        hienThi(lichTrucService.find(phongMay,giaoVien,monHoc, ngay));
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbMaGiaoVien;
    private javax.swing.JComboBox<String> cbMaMon;
    private javax.swing.JComboBox<String> cbMaPhong;
    private com.toedter.calendar.JDateChooser chooserBatdau;
    private com.toedter.calendar.JDateChooser chooserKetthuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtMaLichTruc;
    private javax.swing.JTextField txtTimMaMon;
    private javax.swing.JTextField txtTimMaPhong;
    // End of variables declaration//GEN-END:variables
}