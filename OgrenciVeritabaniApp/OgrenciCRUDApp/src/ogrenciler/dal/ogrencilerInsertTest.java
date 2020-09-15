package ogrenciler.dal;

import java.sql.SQLException;
import ogrenciler.dal.ogrencilerDAL;
import ogrenciler.entity.ogrenciler;

public class ogrencilerInsertTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ogrenciler ogrenci = new ogrenciler(0, "Ali", "Palaslioglu", 100);
        ogrencilerDAL ogrDal = new ogrencilerDAL();
        boolean inserted = ogrDal.insert(ogrenci);
        System.out.println("Eklendi mi? " + inserted);
    }

}
