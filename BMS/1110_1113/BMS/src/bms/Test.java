package bms;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
 
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.BorderLayout;
 
@SuppressWarnings("serial")
public class Test extends JDialog {
    
    private Object[] objColNms = new Object[] { "ISBN", "name", "author", "publisher","Del" };
 
    public static void main(String[] args) {
        new Test();
    }
 
    private JFrame jf;
    private DefaultTableModel dtm;
    private JTable jtable;
    private JScrollPane jsp;

 
    public Test() {
        jf = new JFrame("JTable Add Delete Button");
        jf.setTitle("\uB300\uCD9C");
        jf.setLocationRelativeTo(null);
        jf.setSize(800, 600);
 
        dtm = new DefaultTableModel(new Object[][] {}, objColNms);
        jtable = new JTable(dtm);
        jsp = new JScrollPane(jtable);
 
        jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
        jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell());
        jf.getContentPane().setLayout(new BorderLayout(0, 0));
 
        jf.getContentPane().add(jsp);
 
        jf.setVisible(true);
        
        try {
			String sql = "SELECT * FROM book";
			Connection conn= DriverManager.getConnection(Main.url, Main.user, Main.password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String bookName = rs.getString("ISBN");
				String bookISBN = rs.getString("name");
				String bookAuthor = rs.getString("author");
				String bookPublisher = rs.getString("publisher");
				
				Object data[] = {bookName, bookISBN, bookAuthor, bookPublisher};
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
            jtable.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
            jtable.getColumnModel().getColumn(4).setCellEditor(new TableCell());
 
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
            jb = new JButton("대출");
            jb.addActionListener(e -> {JTableRemoveRow();});
            jb.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				try {
    					String sql = "INSERT INTO client (?)";
    					Connection conn= DriverManager.getConnection(Main.url, Main.user, Main.password);
    					PreparedStatement pstmt = conn.prepareStatement(sql);
    					ResultSet rs= pstmt.executeQuery();
    					
    					while(rs.next()) {
    						String loanedbook1 = rs.getString("책이름");
    						Object data[] = {loanedbook1};
    						dtm.addRow(data);
    					}
    				} catch (SQLException e1) {
    					e1.printStackTrace();
    				}
    			}
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