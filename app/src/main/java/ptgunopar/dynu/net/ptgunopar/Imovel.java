package ptgunopar.dynu.net.ptgunopar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import ptgunopar.dynu.net.dados.DadosGlobais;

public class Imovel extends AppCompatActivity {

    private static String ID;
    DadosGlobais dados = new DadosGlobais();
    private TextView Tv_IDImovel;
    private TextView Tv_TipoImovel;
    private TextView Tv_QuartosImovel;
    private TextView Tv_SuitesImovel;
    private TextView Tv_BanheirosImovel;
    private TextView Tv_VagasImovel;
    private TextView Tv_AreaImovel;
    private TextView Tv_PiscinaImovel;
    private TextView Tv_CidadeImovel;
    private TextView Tv_EstadoImovel;
    private TextView Tv_BairroImovel;
    private TextView Tv_DescricaoImovel;
    private TextView Tv_ValorSugeridoImovel;
    private TextView Tv_ValorVendaImovel;
    private TextView Tv_TelefoneImovel;
    private TextView Tv_CelularImovel;
    private TextView Tv_EmailImovel;
    private Button Bt_ExcluirImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imovel);

        Tv_IDImovel = findViewById(R.id.Tv_IDImovel);
        Tv_TipoImovel = findViewById(R.id.Tv_TipoImovel);
        Tv_QuartosImovel = findViewById(R.id.Tv_QuartosImovel);
        Tv_SuitesImovel = findViewById(R.id.Tv_SuitesImovel);
        Tv_BanheirosImovel = findViewById(R.id.Tv_BanheirosImovel);
        Tv_VagasImovel = findViewById(R.id.Tv_VagasImovel);
        Tv_AreaImovel = findViewById(R.id.Tv_AreaImovel);
        Tv_PiscinaImovel = findViewById(R.id.Tv_PiscinaImovel);
        Tv_CidadeImovel = findViewById(R.id.Tv_CidadeImovel);
        Tv_EstadoImovel = findViewById(R.id.Tv_EstadoImovel);
        Tv_BairroImovel = findViewById(R.id.Tv_BairroImovel);
        Tv_DescricaoImovel = findViewById(R.id.Tv_DescricaoImovel);
        Tv_ValorSugeridoImovel = findViewById(R.id.Tv_ValorSugeridoImovel);
        Tv_ValorVendaImovel = findViewById(R.id.Tv_ValorVendaImovel);
        Tv_TelefoneImovel = findViewById(R.id.Tv_TelefoneImovel);
        Tv_CelularImovel = findViewById(R.id.Tv_CelularImovel);
        Tv_EmailImovel = findViewById(R.id.Tv_EmailImovel);
        Bt_ExcluirImovel = findViewById(R.id.Bt_ExcluirImovel);

        ID = dados.getID();

        Ion.with(Imovel.this)
                .load("http://ptgunopar.dynu.net/sistema/get_imovel.php")
                .setTimeout(5000)
                .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                .setBodyParameter("ID", ID)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {
                            String Tipo = result.get("TIPO").getAsString();
                            String Quartos = result.get("QUARTOS").getAsString();
                            String Suites = result.get("SUITES").getAsString();
                            String Banheiros = result.get("BANHEIROS").getAsString();
                            String Vagas = result.get("VAGAS").getAsString();
                            String Area = result.get("AREA").getAsString();
                            String Piscina = result.get("PISCINA").getAsString();
                            String Cidade = result.get("CIDADE").getAsString();
                            String Estado = result.get("ESTADO").getAsString();
                            String Bairro = result.get("BAIRRO").getAsString();
                            String Descricao = result.get("DESCRICAO").getAsString();
                            String ValorSugerido = result.get("VALORSUGERIDO").getAsString();
                            String ValorVenda = result.get("VALORVENDA").getAsString();
                            String Telefone = result.get("TELEFONE").getAsString();
                            String Celular = result.get("CELULAR").getAsString();
                            String Email = result.get("EMAIL").getAsString();

                            Tv_IDImovel.setText(getString(R.string.ID_Imovel).concat(" " + ID));
                            Tv_TipoImovel.setText(getString(R.string.Tipo_Imovel).concat(" " + Tipo));
                            Tv_QuartosImovel.setText(getString(R.string.Quartos_Imovel).concat(" " + Quartos));
                            Tv_SuitesImovel.setText(getString(R.string.Suites_Imovel).concat(" " + Suites));
                            Tv_BanheirosImovel.setText(getString(R.string.Banheiros_Imovel).concat(" " + Banheiros));
                            Tv_VagasImovel.setText(getString(R.string.Vagas_Imovel).concat(" " + Vagas));
                            Tv_AreaImovel.setText(getString(R.string.Area_Imovel).concat(" " + Area + "m²"));
                            Tv_PiscinaImovel.setText(getString(R.string.Piscina_Imovel).concat(" " + Piscina));
                            Tv_CidadeImovel.setText(getString(R.string.Cidade_Imovel).concat(" " + Cidade));
                            Tv_EstadoImovel.setText(getString(R.string.Estado_Imovel).concat(" " + Estado));
                            Tv_BairroImovel.setText(getString(R.string.Bairro_Imovel).concat(" " + Bairro));
                            Tv_DescricaoImovel.setText(getString(R.string.Descricao_Imovel).concat(" " + Descricao));
                            Tv_ValorSugeridoImovel.setText(getString(R.string.ValorSugerido_Imovel).concat(" " + ValorSugerido));
                            Tv_ValorVendaImovel.setText(getString(R.string.ValorVenda_Imovel).concat(" " + ValorVenda));
                            Tv_TelefoneImovel.setText(getString(R.string.Telefone_Imovel).concat(" " + Telefone));
                            Tv_CelularImovel.setText(getString(R.string.Celular_Imovel).concat(" " + Celular));
                            Tv_EmailImovel.setText(getString(R.string.Email_Imovel).concat(" " + Email));
                        } catch (Exception ex) {
                            Toast.makeText(Imovel.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void ExcluirImovel(View view) {

        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(Imovel.this);
        builder.setTitle(R.string.Alerta);
        builder.setMessage(R.string.AlertaExcluirImovel);

        builder.setPositiveButton(R.string.Sim, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                Ion.with(Imovel.this)
                        .load("http://ptgunopar.dynu.net/sistema/excluir_imovel.php")
                        .setTimeout(5000)
                        .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                        .setBodyParameter("ID", ID)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                try {
                                    String Resposta = result.get("EXCLUI").getAsString();
                                    if (Resposta.equals("SUCESSO")) {
                                        Toast.makeText(Imovel.this, R.string.ExcluirImovel, Toast.LENGTH_SHORT).show();
                                        Intent abririmoveiscadastrados = new Intent(Imovel.this, ImoveisCadastrados.class);
                                        startActivity(abririmoveiscadastrados);
                                    } else {
                                        Toast.makeText(Imovel.this, R.string.ErroExcluirImovel, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (Exception ex) {
                                    Toast.makeText(Imovel.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        builder.setNegativeButton(R.string.Nao, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });

        alerta = builder.create();
        alerta.show();
    }
}