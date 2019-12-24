package tr.com.huveyda.bilgen.restoranrezervasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class RezervasyonlarActivity extends AppCompatActivity {

    ListView listRezervasyonlar;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyonlar);

        ListView listRezervasyonlar = findViewById(R.id.listRezervasyonlar);
        realm= Realm.getDefaultInstance();

        List<String> ListRez = new ArrayList<>();
        for(Rezervasyon rez : realm.where(Rezervasyon.class).findAll()){
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            String date = format.format(rez.getRezervasyonZamani());

            ListRez.add(date + " " + rez.getKisiSayisi() +" Kişi, Masa No : " + rez.getMasaNo() );
        }

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ListRez);

        //(C) adımı
        listRezervasyonlar.setAdapter(veriAdaptoru);
    }
}
