package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button Bt_Entrar;
    private Button Bt_CriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Bt_Entrar = findViewById(R.id.Bt_Entrar);
        Bt_CriarConta = findViewById(R.id.Bt_CriarConta);
    }

    protected void onResume() {
        if (getIntent().getBooleanExtra("SAIR", false)) {
            finish();
        }
        super.onResume();
    }

    public void AbrirEntrar(View view) {
        Intent abrirentrar = new Intent(MainActivity.this, Entrar.class);
        startActivity(abrirentrar);
    }

    public void AbrirCriarConta(View view) {
        Intent abrircriarconta = new Intent(MainActivity.this, CriarConta.class);
        startActivity(abrircriarconta);
    }

    public void onBackPressed() {
        finish();
    }
}