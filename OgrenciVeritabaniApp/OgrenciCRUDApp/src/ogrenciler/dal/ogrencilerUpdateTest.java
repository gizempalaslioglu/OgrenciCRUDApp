package ogrenciler.dal;

import java.sql.SQLException;
import ogrenciler.entity.ogrenciler;
import ogrenciler.dal.ogrencilerDAL;

public class ogrencilerUpdateTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ogrencilerDAL ogrDal = new ogrencilerDAL();
        ogrenciler ogrenci = new ogrenciler(8, "Gizem", "P", 85);
        boolean updated = ogrDal.update(ogrenci);
        System.out.println("Güncellendi mi? " + updated);

    }
}
