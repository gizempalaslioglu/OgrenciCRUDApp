package ogrenciler.dal;

import java.sql.SQLException;
import java.util.List;
import ogrenciler.entity.ogrenciler;

public class ogrencilerListTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ogrencilerDAL ogrDal = new ogrencilerDAL();
        List<ogrenciler> ogrenciListesi = ogrDal.list();
        for (ogrenciler ogrenciler : ogrenciListesi) {
            System.out.printf("%d  %s %s %d \n", ogrenciler.getOgrenci_id(), ogrenciler.getIsim(), ogrenciler.getSoyisim(), ogrenciler.getBitirme_not());
        }
    }
}
