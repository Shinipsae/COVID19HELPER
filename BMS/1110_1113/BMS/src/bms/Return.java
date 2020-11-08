package bms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import bms.Test.TableCell;

import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Return extends JFrame {
	
	private Object[] objColNms = new Object[] { "Title", "Return" };
	 
    public static void main(String[] args) {
        new Return();
    }
 
    private JFrame jf;
    private DefaultTableModel dtm;
    private JTable jtable;
    private JScrollPane jsp;

 
    public Return() {
        jf = new JFrame("¹Ý³³");
        jf.getContentPane().setBackground(Color.BLACK);
        jf.setTitle("\uBC18\uB0A9");
        jf.setLocationRelativeTo(null);
        jf.setSize(800, 600);
 
        dtm = new DefaultTableModel(new Object[][] {}, objColNms);
        jtable = new JTable(dtm);
        jsp = new JScrollPane(jtable);
 
        jtable.getColumnModel().getColumn(1).setCellRenderer(new TableCell());
        jtable.getColumnModel().getColumn(1).setCellEditor(new TableCell());
        jf.getContentPane().setLayout(new BorderLayout(0, 0));
 
        jf.getContentPane().add(jsp);
       
        jf.setVisible(true);
        
        try {
			String sql = "SELECT * FROM client";
			Connection conn= DriverManager.getConnection(Main.url, Main.user, Main.password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("´ëÃâÇÑÃ¥");	
				Object data[] = {};
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
 
    @SuppressWarnings("rawtypes")
    public void JTableRemoveRow() {
    	
        int row = jtable.getSelectedRow();
        if (row == -1)
            return;
 
        System.out.println(row);
        
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.removeRow(row);
 
        int rowCnt = jtable.getRowCount();
 
        if (rowCnt > 0) {
            Vector vector = model.getDataVector();
            Object[][] objData = new Object[vector.size()][((Vector) vector.get(0)).size()];
            for (int i = 0; i < vector.size(); i++) {
                Vector vec = (Vector) vector.get(i);
                for (int j = 0; j < vec.size(); j++) {
                    objData[i][j] = vec.get(j);
                }
            }
 
            DefaultTableModel clonModel = new DefaultTableModel(objData, objColNms);
            JTable clonTable = new JTable(clonModel);
 
            jf.getContentPane().removeAll();
 
            jtable = clonTable;
            jsp = new JScrollPane(jtable);
            jtable.getColumnModel().getColumn(1).setCellRenderer(new TableCell());
            jtable.getColumnModel().getColumn(1).setCellEditor(new TableCell());
 
            jf.getContentPane().add(jsp);
            jf.revalidate();
            jf.repaint();
        } else {
            DefaultTableModel clonModel = new DefaultTableModel(null, objColNms);
            JTable clonTable = new JTable(clonModel);
 
            jf.getContentPane().removeAll();
 
            jtable = clonTable;
            jsp = new JScrollPane(jtable);
 
            jf.getContentPane().add(jsp);
            jf.revalidate();
            jf.repaint();
        }
    } // end public void JTableRemoveRow()
 
    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
        JButton jb;
 
        public TableCell() {
            jb = new JButton("¹Ý³³");
            jb.addActionListener(e -> {
                JTableRemoveRow();
            });
        }
 
        @Override
        public Object getCellEditorValue() {
            return null;
        }
 
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            return jb;
        }
 
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            return jb;
        }
    }
}
