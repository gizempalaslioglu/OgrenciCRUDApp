package ogrenciler.entity;

import java.util.Objects;

public class ogrenciler {

    private int ogrenci_id;
    private String isim;
    private String soyisim;
    private int bitirme_not;

    public ogrenciler(int ogrenci_id, String isim, String soyisim, int bitirme_not) {
        this.ogrenci_id = ogrenci_id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.bitirme_not = bitirme_not;
    }

    public int getOgrenci_id() {
        return ogrenci_id;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public int getBitirme_not() {
        return bitirme_not;
    }

    public void setOgrenci_id(int ogrenci_id) {
        this.ogrenci_id = ogrenci_id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public void setBitirme_not(int bitirme_not) {
        this.bitirme_not = bitirme_not;
    }

    @Override
    public String toString() {
        return "ogrenciler{" + "ogrenci_id=" + ogrenci_id + ", isim=" + isim + ", soyisim=" + soyisim + ", bitirme_not=" + bitirme_not + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.ogrenci_id;
        hash = 83 * hash + Objects.hashCode(this.isim);
        hash = 83 * hash + Objects.hashCode(this.soyisim);
        hash = 83 * hash + this.bitirme_not;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ogrenciler other = (ogrenciler) obj;
        if (this.ogrenci_id != other.ogrenci_id) {
            return false;
        }
        if (this.bitirme_not != other.bitirme_not) {
            return false;
        }
        if (!Objects.equals(this.isim, other.isim)) {
            return false;
        }
        if (!Objects.equals(this.soyisim, other.soyisim)) {
            return false;
        }
        return true;
    }

}
