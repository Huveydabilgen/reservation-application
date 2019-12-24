package tr.com.huveyda.bilgen.restoranrezervasyon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    EditText editTextTarih;
    EditText editTextSaat;
    int kisiSayisi = 0;
    TextView textViewKisiSayisi;

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth+"."+(monthOfYear+1)+"."+year;
        editTextTarih.setText(date);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Intent myIntent = getIntent(); // gets the previously created intent
        TextView textView = findViewById(R.id.textViewAdi);
        textView.setText(myIntent.getStringExtra("KullaniciAdi"));
        Button buttonMasaSecimi = findViewById(R.id.buttonMasaSecimi);
        Button buttonTarihSec = findViewById(R.id.buttonTarihSec);
        Button buttonSaatSec = findViewById(R.id.buttonSaatSec);
        ImageView imageButtonKisiArtir = findViewById(R.id.imageButtonKisiArtir);
        ImageView imageButtonKisiEksilt = findViewById(R.id.imageButtonKisiEksilt);

        editTextTarih = findViewById(R.id.editTextTarih);
        editTextSaat = findViewById(R.id.editTextSaat);
        textViewKisiSayisi = findViewById(R.id.textViewKisiSayisi);



        buttonMasaSecimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(editTextSaat.getText()) && !TextUtils.isEmpty(editTextTarih.getText()) && kisiSayisi > 0 ) {
                    Intent myIntent = new Intent(MainActivity.this, MasaSecimiActivity.class);
                    myIntent.putExtra("Tarih",editTextTarih.getText() + " " + editTextSaat.getText());
                    myIntent.putExtra("KisiSayisi",textViewKisiSayisi.getText());
                    MainActivity.this.startActivity(myIntent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Lütfen Bütün Bilgileri Yaz");
                    builder.show();
                }
            }
        });

        buttonTarihSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        MainActivity.this,
                        now.get(Calendar.YEAR), // Initial year selection
                        now.get(Calendar.MONTH), // Initial month selection
                        now.get(Calendar.DAY_OF_MONTH) // Inital day selection

                );
                dpd.show(getSupportFragmentManager(), "Datepickerdialog");
            }
        });

        buttonSaatSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dia = TimePickerDialog.newInstance(MainActivity.this, true);
                dia.show(getSupportFragmentManager(), "Timepickerdialog");
            }
        });

        imageButtonKisiArtir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kisiSayisi++;
                if(kisiSayisi > 30)
                    kisiSayisi = 30;
                textViewKisiSayisi.setText(String.valueOf( kisiSayisi));
            }
        });

        imageButtonKisiEksilt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kisiSayisi--;
                if(kisiSayisi < 0)
                    kisiSayisi = 0;
                textViewKisiSayisi.setText(String.valueOf( kisiSayisi));
            }
        });
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        editTextSaat.setText(hourOfDay + ":"+minute);
    }
}
