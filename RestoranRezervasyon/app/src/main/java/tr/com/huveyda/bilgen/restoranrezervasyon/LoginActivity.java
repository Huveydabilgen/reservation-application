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

public class LoginActivity extends AppCompatActivity {
    EditText editTextKullaniciAdi;
    EditText editTextSifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        editTextKullaniciAdi = findViewById(R.id.editTextKullaniciAdi);
        editTextSifre = findViewById(R.id.editTextSifre);

        Button buttonGiris =  findViewById(R.id.buttonGiris);
        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(editTextKullaniciAdi.getText()) && !TextUtils.isEmpty(editTextSifre.getText()) ) {
                    if(editTextKullaniciAdi.getText().toString().equals("admin")){
                        Intent myIntent = new Intent(LoginActivity.this, RezervasyonlarActivity.class);
                        myIntent.putExtra("KullaniciAdi", editTextKullaniciAdi.getText());
                        LoginActivity.this.startActivity(myIntent);
                    }else {
                        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                        myIntent.putExtra("KullaniciAdi", editTextKullaniciAdi.getText());
                        LoginActivity.this.startActivity(myIntent);
                    }
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Lütfen Kullanıcı Adı Şifreyi Yaz");
                    builder.show();
                }
            }
        });
    }
}
