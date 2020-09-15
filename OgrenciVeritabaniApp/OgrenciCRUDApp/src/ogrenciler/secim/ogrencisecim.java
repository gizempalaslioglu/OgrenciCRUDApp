package ogrenciler.secim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ogrenciler.dal.ogrencilerDAL;

public class ogrencisecim {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Statement s = null;
        ResultSet rs = null;
        int choice;
        ogrencilerDAL pm = new ogrencilerDAL();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ogrenciler?useTimezone=true&serverTimezone=UTC", "root", "ianninasobrev");
                System.out.println("connection is established...you can control your database");
                System.out.println("\n\n");

                do {
                    String menu = JOptionPane.showInputDialog("jdbc programming menu" + "\n\n 1.insert values" + "\n2.delete values" + "\n3.update values" + "\n4.view values" + "\n 5.exit");
                    choice = Integer.parseInt(menu);

                    String y;

                    switch (choice) {
                        case 1:

                            y = JOptionPane.showInputDialog("enter id:");
                            int ogrenci_id = Integer.parseInt(y);

                            String isim = JOptionPane.showInputDialog("enter name:");
                            String soyisim = JOptionPane.showInputDialog("enter surname:");
                            y = JOptionPane.showInputDialog("enter point:");
                            int bitirme_not = Integer.parseInt(y);

                            try {
                                String query = "Insert into ogrenciler values('" + ogrenci_id + "','" + isim + "','" + soyisim + "','" + bitirme_not + "')";
                                s = con.createStatement();
                                s.executeUpdate(query);
                                JOptionPane.showMessageDialog(null, "row inserted");

                            } catch (Exception e) {
                                System.out.println("error2" + e);

                            }
                            break;

                        case 2:
                            try {
                                String z = JOptionPane.showInputDialog("enter the ogrenciId:");
                                ogrenci_id = Integer.parseInt(z);

                                s = con.createStatement();
                                int x = s.executeUpdate("delete from ogrenciler where ogrenci_id=" + "'" + z + "'");

                            } catch (Exception e) {
                                System.out.println("error3" + e);

                            }
                            break;
                        case 3:
                            try {

                                String k = JOptionPane.showInputDialog("enter ogrenciId to be updated:");
                                ogrenci_id = Integer.parseInt(k);

                                String query = "update ogrenciler set bitirme_not=80 where ogrenci_id='" + k + "'";
                                s = con.createStatement();
                                int x = s.executeUpdate(query);

                            } catch (Exception e) {
                                System.out.println("error4" + e);

                            }
                            break;

                        case 4:
                            try {

                                String query = "select * from ogrenciler ";
                                s = con.createStatement();
                                rs = s.executeQuery(query);
                                boolean rec = rs.next();
                                while (!rec) {
                                    System.out.println("no record");
                                }

                                do {
                                    ogrenci_id = rs.getInt(1);
                                    isim = rs.getString(2);
                                    soyisim = rs.getString(3);
                                    bitirme_not = rs.getInt(4);
                                    String msg = " id= " + ogrenci_id + " name= " + isim + " surname= " + soyisim + " point= " + bitirme_not;
                                    JOptionPane optionpane = new JOptionPane();
                                    optionpane.setMessage(msg);
                                    optionpane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                                    JDialog dialog = optionpane.createDialog(null, "your values");
                                    dialog.setVisible(true);

                                } while (rs.next());

                                s.close();
                                con.close();

                            } catch (Exception e) {
                                System.out.println("error5" + e);

                            }
                            break;
                        case 5:
                            System.exit(5);
                            break;

                        default:
                            System.out.println("iam default");

                    }

                } while (choice != 5);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
