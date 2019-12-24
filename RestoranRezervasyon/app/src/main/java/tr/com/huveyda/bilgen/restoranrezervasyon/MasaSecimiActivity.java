package tr.com.huveyda.bilgen.restoranrezervasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;

public class MasaSecimiActivity extends AppCompatActivity {

    String Tarih;
    String KisiSayisi;
    Realm realm;

    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa_secimi);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        realm= Realm.getDefaultInstance();

        Intent myIntent = getIntent();
        Tarih = myIntent.getStringExtra("Tarih");
        KisiSayisi = myIntent.getStringExtra("KisiSayisi");

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            date = format.parse(Tarih);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ImageView imageViewT1 = findViewById(R.id.imageViewT1);
        ImageView imageViewT2 = findViewById(R.id.imageViewT2);
        ImageView imageViewT3 = findViewById(R.id.imageViewT3);
        ImageView imageViewT4 = findViewById(R.id.imageViewT4);
        ImageView imageViewT5 = findViewById(R.id.imageViewT5);
        ImageView imageViewT6 = findViewById(R.id.imageViewT6);
        ImageView imageViewT7 = findViewById(R.id.imageViewT7);
        ImageView imageViewT8 = findViewById(R.id.imageViewT8);
        ImageView imageViewT9 = findViewById(R.id.imageViewT9);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 1);
        calendar.getTime();

        for (Rezervasyon rez:realm.where(Rezervasyon.class).between("RezervasyonZamani",date, calendar.getTime()).findAll()) {
            if(rez.getMasaNo() == 1)
                imageViewT1.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 2)
                imageViewT2.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 3)
                imageViewT3.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 4)
                imageViewT4.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 5)
                imageViewT5.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 6)
                imageViewT6.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 7)
                imageViewT7.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 8)
                imageViewT8.setVisibility(View.INVISIBLE);
            if(rez.getMasaNo() == 9)
                imageViewT9.setVisibility(View.INVISIBLE);
        };

        imageViewT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(1);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","1");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);


            }
        });

        imageViewT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(2);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();


                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","2");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });

        imageViewT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(3);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","3");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });

        imageViewT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(4);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","4");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });

        imageViewT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(5);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","5");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });

        imageViewT6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(6);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","6");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });

        imageViewT7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(7);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","7");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });

        imageViewT8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(8);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","8");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });

        imageViewT9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                Rezervasyon rez = realm.createObject(Rezervasyon.class);
                rez.setKisiSayisi(Integer.parseInt(KisiSayisi));
                rez.setMasaNo(9);
                rez.setRezervasyonZamani(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR, 1);
                rez.setRezervasyonZamaniBitis(calendar.getTime());
                realm.commitTransaction();

                Intent myIntent = new Intent(MasaSecimiActivity.this, OnayActivity.class);
                myIntent.putExtra("MasaNo","9");
                myIntent.putExtra("Tarih",Tarih);
                myIntent.putExtra("KisiSayisi",KisiSayisi);
                MasaSecimiActivity.this.startActivity(myIntent);
            }
        });
    }
}
