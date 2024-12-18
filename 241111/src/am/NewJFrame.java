/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package am;

import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ted19Horse
 */
public class NewJFrame extends javax.swing.JFrame {

    // 파일 읽기에 필요한 스트림 준비
    File selectedFile;
    BufferedInputStream bis;
    BufferedOutputStream bos;

    String old_data; // 파일로부터 데이터 읽기가 완료되면 현재 변수에 저장.

    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 450));
        setSize(new java.awt.Dimension(550, 450));

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("New");
        jMenu1.add(jMenuItem1);

        jMenuItem5.setText("Open");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Save as...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
        // 저장기능

        // 먼저 열려있는 파일이 없을 경우
        if (selectedFile == null) { // false인 경우는 파일이 열려져있는 상태
            JFileChooser jfc = new JFileChooser("d:/code");
            int cmd = jfc.showOpenDialog(this);
            if (cmd != JFileChooser.APPROVE_OPTION) {
                return; // 제어권 반환...굳이?
            } else {
                selectedFile = jfc.getSelectedFile();
            }
        }
        saveFile();
    }// GEN-LAST:event_jMenuItem2ActionPerformed

    private void saveFile() {
        try {
            bos = new BufferedOutputStream(new FileOutputStream(selectedFile));
            // JTextArea에 있는 모든 문자열들을 가져와서
            // 파일에 넣는다.
            byte[] data = ta.getText().getBytes();
            bos.write(ta.getText().getBytes(), 0, data.length);
            bos.flush();
            old_data = ta.getText();
        } catch (Exception e) {
        }
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
        // 종료 전에 처리해야 할 일이 있다면 여기서 기술한다.
        closed();
    }// GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed
        // 읽기 기능
        JFileChooser jfc = new JFileChooser("d:/code");
        int cmd = jfc.showOpenDialog(this);
        if (cmd == JFileChooser.APPROVE_OPTION) {
            // 파일 선택기에서 사용자가 선택한 파일을 얻어낸다.
            selectedFile = jfc.getSelectedFile(); // ***********************
            readFile();
        }
    }// GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
        // Save as 기능
        JFileChooser jfc = new JFileChooser("d:/code");
        int cmd = jfc.showOpenDialog(this);
        if (cmd == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            saveFile();
        }
    }// GEN-LAST:event_jMenuItem3ActionPerformed

    private void readFile() {
        // 현재 영역에 왔을 때는 이미 사용자가 선택한 파일이 있다.
        // 해당 파일은 멤버변수인 selectedFile에 담겨진 상태다.
        try {
            bis = new BufferedInputStream(new FileInputStream(selectedFile));
            // bis는 선택된 파일과 연결되어 있다. bis.read() >> 파일 읽기
            byte[] buf = new byte[2048];
            int size = -1;
            ta.setText("");
            while ((size = bis.read(buf)) != -1) {
                // 읽은 자원들을 문자열로 만들어서 ta에 표현한다.
                String str = new String(buf, 0, size);
                ta.append(str);
            } // 반복문의 끝
            old_data = ta.getText();
            ta.setCaretPosition(0);
            this.setTitle(selectedFile.getName());
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea ta;
    // End of variables declaration//GEN-END:variables

    private void closed() {
        try {
            if (old_data != null && !old_data.equals(ta.getText())) {
                int cmd = JOptionPane.showConfirmDialog(this, "Save?", "Warning", JOptionPane.YES_NO_OPTION);
                if (cmd == JOptionPane.YES_OPTION) {
                    saveFile();
                }
            }
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        } catch (IOException e) {
        }
        System.exit(0);
    }
}
