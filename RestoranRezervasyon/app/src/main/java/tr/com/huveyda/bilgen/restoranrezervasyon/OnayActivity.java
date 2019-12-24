package tr.com.huveyda.bilgen.restoranrezervasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class OnayActivity extends AppCompatActivity {
    String masaNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onay);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Intent myIntent = getIntent(); // gets the previously created intent
        masaNo = myIntent.getStringExtra("MasaNo");

        TextView textViewMasaNo = findViewById(R.id.textViewMasaNo);
        textViewMasaNo.setText("\n Masa Numaranız : \n" + masaNo +
                "\n Tarih : \n" +
                myIntent.getStringExtra("Tarih")+
                "\n Kişi Sayısı : \n" +
                myIntent.getStringExtra("KisiSayisi"));
    }
}