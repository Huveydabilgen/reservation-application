package tr.com.huveyda.bilgen.restoranrezervasyon;

import java.util.Date;

import io.realm.RealmObject;

public class Rezervasyon extends RealmObject {
    private Date RezervasyonZamani;
    private Date RezervasyonZamaniBitis;
    private int MasaNo;
    private int KisiSayisi;

    public Date getRezervasyonZamani() {
        return RezervasyonZamani;
    }

    public void setRezervasyonZamani(Date rezervasyonZamani) {
        RezervasyonZamani = rezervasyonZamani;
    }

    public int getMasaNo() {
        return MasaNo;
    }

    public void setMasaNo(int masaNo) {
        MasaNo = masaNo;
    }

    public int getKisiSayisi() {
        return KisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        KisiSayisi = kisiSayisi;
    }

    public Date getRezervasyonZamaniBitis() {
        return RezervasyonZamaniBitis;
    }

    public void setRezervasyonZamaniBitis(Date rezervasyonZamaniBitis) {
        RezervasyonZamaniBitis = rezervasyonZamaniBitis;
    }
}
