
package UI;

import java.awt.Color;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import DataAccess.DBConnection;

/**
 *
 * @author vatsala
 */
//for display of data-uses sql and swing both
public class SelectQuery {

    public SelectQuery() {
    }

    public int Select_Q(String sql, JScrollPane scrollpane, JTable jTable1) {
        ResultSet rs = null;
        Statement stmt = null;
        //ResultSetMetaData md = null;
        Connection con = null;
        Vector columnNames = new Vector();
        Vector data = new Vector();
        try {
            
            con = DBConnection.getConnection();
            if (!con.isClosed()) {
                stmt = con.createStatement();
            }
            rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnLabel(i).toUpperCase());
            }
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    Object o = rs.getObject(i);
                    row.addElement(o);
                }
                data.addElement(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    stmt.close();
                }
            } catch (SQLException ce) {
                ce.printStackTrace();
            }
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data, columnNames) {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        });
        scrollpane.setViewportView(jTable1);
        if (data == null ? "" != null : !data.equals("")) {
            try {
                jTable1.setRowSelectionInterval(0, 0);
            } catch (Exception e) {
            }
        }
        jTable1.setSelectionBackground(Color.CYAN);
        jTable1.setSelectionForeground(Color.MAGENTA);
        jTable1.setRowHeight(20);
        return 1;
    }
}
