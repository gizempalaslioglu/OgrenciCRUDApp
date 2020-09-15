package ogrenciler.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ogrenciler.databaseutilities.databaseutilities;
import ogrenciler.entity.ogrenciler;

public class ogrencilerDAL {

    public boolean insert(ogrenciler ogrenciler) throws ClassNotFoundException, SQLException {
        Connection connection = databaseutilities.getConnection();

        String sql = "insert into ogrenciler(isim,soyisim,bitirme_not) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ogrenciler.getIsim());
        statement.setString(2, ogrenciler.getSoyisim());
        statement.setDouble(3, ogrenciler.getBitirme_not());

        int affected = statement.executeUpdate();

        connection.close();
        return affected == 1 ? true : false;
    }

    public boolean update(ogrenciler ogrenciler) throws ClassNotFoundException, SQLException {

        Connection connection = databaseutilities.getConnection();

        String sql = "update ogrenciler set isim=?,soyisim=?,bitirme_not=? where ogrenci_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ogrenciler.getIsim());
        statement.setString(2, ogrenciler.getSoyisim());
        statement.setDouble(3, ogrenciler.getBitirme_not());
        statement.setDouble(4, ogrenciler.getOgrenci_id());

        int affected = statement.executeUpdate();

        connection.close();
        return affected == 1 ? true : false;
    }

    public boolean delete(long ogrenci_id) throws ClassNotFoundException, SQLException {
        Connection connection = databaseutilities.getConnection();

        String sql = "delete from ogrenciler where ogrenci_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, ogrenci_id);
        int affected = statement.executeUpdate();
        connection.close();
        return affected == 1 ? true : false;
    }

    public ArrayList<ogrenciler> list() throws ClassNotFoundException, SQLException {

        Connection conn = databaseutilities.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "select * from ogrenciler";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<ogrenciler> ogrenciListesi = new ArrayList<>();
        while (rst.next()) {
            ogrenciler ogrenci = new ogrenciler(rst.getInt("ogrenci_id"), rst.getString("isim"), rst.getString("soyisim"), rst.getInt("bitirme_not"));
            ogrenciListesi.add(ogrenci);
        }
        return ogrenciListesi;
    }

}
