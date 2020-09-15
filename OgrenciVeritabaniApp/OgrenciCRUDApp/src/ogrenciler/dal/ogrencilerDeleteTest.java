package ogrenciler.dal;

import java.sql.SQLException;

public class ogrencilerDeleteTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ogrencilerDAL ogrDal = new ogrencilerDAL();
        long ogrenci_id = 1;
        boolean deleted = ogrDal.delete(ogrenci_id);
        System.out.println("Silindi mi? " + deleted);
    }
}
