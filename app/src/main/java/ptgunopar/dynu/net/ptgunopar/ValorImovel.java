package ptgunopar.dynu.net.ptgunopar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Locale;

import ptgunopar.dynu.net.dados.DadosGlobais;
import ptgunopar.dynu.net.utils.Mascara;

public class ValorImovel extends AppCompatActivity {

    private static String ValorSugerido;
    private static Integer Tipo, Bairro, Cidade, Estado, Area, Quartos, Suites, Banheiros, Piscina, Vagas;
    DadosGlobais dados = new DadosGlobais();
    private EditText Et_ValorSugeridoImovel;
    private EditText Et_ValorImovel;
    private TextView Tv_ReferenciaValorSugerido;
    private CheckBox Cb_ValorSugerido;
    private Button Bt_ProximoValorImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_imovel);
        getSupportActionBar().hide();

        Et_ValorSugeridoImovel = findViewById(R.id.Et_ValorSugeridoImovel);
        Et_ValorImovel = findViewById(R.id.Et_ValorImovel);
        Tv_ReferenciaValorSugerido = findViewById(R.id.Tv_ReferenciaValorSugerido);
        Cb_ValorSugerido = findViewById(R.id.Cb_ValorSugerido);
        Bt_ProximoValorImovel = findViewById(R.id.Bt_ProximoValorImovel);
        CalcularValor();

        Et_ValorImovel.setInputType(InputType.TYPE_CLASS_NUMBER);

        Locale Local = new Locale("pt", "BR");
        Et_ValorSugeridoImovel.addTextChangedListener(new Mascara(Et_ValorSugeridoImovel, Local));
        Et_ValorImovel.addTextChangedListener(new Mascara(Et_ValorImovel, Local));

        Cb_ValorSugerido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CompoundButton) view).isChecked()) {
                    Et_ValorImovel.setEnabled(false);
                    Et_ValorImovel.setText(ValorSugerido);
                } else {
                    Et_ValorImovel.setEnabled(true);
                    Et_ValorImovel.setText("R$ 0,00");
                }
            }
        });
    }

    public void CalcularValor() {
        Ion.with(ValorImovel.this)
                .load("http://ptgunopar.dynu.net/sistema/get_bairro.php")
                .setTimeout(5000)
                .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                .setBodyParameter("Bairro", dados.getBairro())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {
                            Bairro = result.get("ID").getAsInt();

                        } catch (Exception ex) {
                            Toast.makeText(ValorImovel.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                        }

                        switch (dados.getTipo()) {
                            case "Casa":
                                Tipo = 1;
                                break;
                            case "Apartamento":
                                Tipo = 2;
                                break;
                            default:
                                Tipo = 1;
                        }

                        Cidade = 1;
                        Estado = 1;
                        Area = dados.getArea();
                        Quartos = dados.getQuartos();
                        Suites = dados.getSuites();
                        Banheiros = dados.getBanheiros();

                        switch (dados.getPiscina()) {
                            case "Sim":
                                Piscina = 1;
                                break;
                            case "Não":
                                Piscina = 0;
                                break;
                            default:
                                Piscina = 0;
                        }

                        Vagas = dados.getVagas();

                        JsonObject parametros = new JsonObject();
                        parametros.addProperty("tipo", Tipo);
                        parametros.addProperty("bairro", Bairro);
                        parametros.addProperty("cidade", Cidade);
                        parametros.addProperty("estado", Estado);
                        parametros.addProperty("area", Area);
                        parametros.addProperty("quartos", Quartos);
                        parametros.addProperty("suites", Suites);
                        parametros.addProperty("banheiros", Banheiros);
                        parametros.addProperty("piscina", Piscina);
                        parametros.addProperty("garagem", Vagas);

                        Ion.with(ValorImovel.this)
                                .load("http://dito.ml:8080/imovel")
                                .setTimeout(5000)
                                .setHeader("Content-Type", "application/json")
                                .setHeader("Secret", dados.getSenhaAcesso())
                                .setJsonObjectBody(parametros)
                                .asJsonObject()
                                .setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {
                                        try {
                                            String Resposta = result.get("resposta").getAsString();
                                            ValorSugerido = result.get("mensagem").getAsString();

                                            if (Resposta.equals("OK")) {
                                                Et_ValorSugeridoImovel.setText(ValorSugerido);
                                                Tv_ReferenciaValorSugerido.setText(null);
                                            } else {
                                                Tv_ReferenciaValorSugerido.setText(R.string.Tv_ReferenciaValorSugerido);
                                            }
                                        } catch (Exception ex) {
                                            Toast.makeText(ValorImovel.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });
    }

    public void Proximo(View view) {
        String ValorSugerido = Et_ValorSugeridoImovel.getText().toString();
        String ValorVenda = Et_ValorImovel.getText().toString();

        if (ValorVenda.isEmpty()) {
            Toast.makeText(ValorImovel.this, R.string.Campos_Pendentes, Toast.LENGTH_SHORT).show();
        } else {
            dados.setValorSugerido(ValorSugerido);
            dados.setValorVenda(ValorVenda);

            Intent abrirproximo = new Intent(ValorImovel.this, ContatosImovel.class);
            startActivity(abrirproximo);
        }
    }
}