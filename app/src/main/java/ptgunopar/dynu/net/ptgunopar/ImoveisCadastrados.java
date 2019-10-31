package ptgunopar.dynu.net.ptgunopar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import ptgunopar.dynu.net.dados.DadosGlobais;
import ptgunopar.dynu.net.dados.DadosListaImoveis;
import ptgunopar.dynu.net.utils.ListaImoveisAdapter;

public class ImoveisCadastrados extends AppCompatActivity {

    DadosGlobais dados = new DadosGlobais();
    private Button Bt_CadastrarNovo;
    private ListView Lv_Imoveis;
    private TextView Tv_SemRegistros;
    private String CPFLogado = dados.getCPFLogado();
    private ListaImoveisAdapter listaimoveisadapter;
    private List<DadosListaImoveis> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imoveis_cadastrados);

        Bt_CadastrarNovo = findViewById(R.id.Bt_CadastrarNovo);
        Lv_Imoveis = findViewById(R.id.Lv_Imoveis);

        lista = new ArrayList<DadosListaImoveis>();
        listaimoveisadapter = new ListaImoveisAdapter(ImoveisCadastrados.this, lista);
        Lv_Imoveis.setAdapter(listaimoveisadapter);

        Ion.with(ImoveisCadastrados.this)
                .load("http://ptgunopar.dynu.net/sistema/get_usuario.php")
                .setTimeout(5000)
                .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                .setBodyParameter("CPFLogado", CPFLogado)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {
                            String Usuario = result.get("NOME").getAsString();
                            if (dados.getPrimeiraExecucao()) {
                                Toast.makeText(ImoveisCadastrados.this, Usuario.concat(getString(R.string.Bem_Vindo)), Toast.LENGTH_SHORT).show();
                                dados.setPrimeiraExecucao(false);
                            }
                        } catch (Exception ex) {
                            Toast.makeText(ImoveisCadastrados.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        Ion.with(getBaseContext())
                .load("http://ptgunopar.dynu.net/sistema/get_imoveis_cadastrados.php")
                .setTimeout(5000)
                .setBodyParameter("SenhaAcesso", dados.getSenhaAcesso())
                .setBodyParameter("CPFLogado", CPFLogado)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        try {
                            for (int i = 0; i < result.size(); i++) {
                                JsonObject objeto = result.get(i).getAsJsonObject();
                                DadosListaImoveis dadoslistaimoveis = new DadosListaImoveis();
                                String ID = objeto.get("ID").getAsString();
                                if (!ID.equals("SEMREGISTROS")) {
                                    String Tipo = objeto.get("TIPO").getAsString();
                                    String Titulo = objeto.get("TITULO").getAsString();

                                    dadoslistaimoveis.setID("ID: " + ID);
                                    dadoslistaimoveis.setTipo("Tipo: " + Tipo);
                                    dadoslistaimoveis.setTitulo("Títudo: " + Titulo);
                                    lista.add(dadoslistaimoveis);
                                } else {
                                    Tv_SemRegistros = findViewById(R.id.Tv_SemRegistros);
                                    Tv_SemRegistros.setText(R.string.Tv_SemRegistros);
                                }
                            }
                            listaimoveisadapter.notifyDataSetChanged();
                        } catch (Exception ex) {
                            Toast.makeText(ImoveisCadastrados.this, R.string.Erro_Conexao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        Lv_Imoveis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                DadosListaImoveis dadoslistaimoveis = (DadosListaImoveis) adapterView.getAdapter().getItem(position);
                String ID = dadoslistaimoveis.getID().replace("ID: ", "");
                dados.setID(ID);
                Intent abririmovel = new Intent(ImoveisCadastrados.this, Imovel.class);
                startActivity(abririmovel);
            }
        });
    }

    public void AbrirCadastrarNovo(View view) {
        Intent abrircadastrarnovo = new Intent(ImoveisCadastrados.this, CadastrarNovo.class);
        startActivity(abrircadastrarnovo);
    }

    public void onBackPressed() {
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(ImoveisCadastrados.this);
        builder.setTitle(R.string.Alerta);
        builder.setMessage(R.string.AlertaFecharAplicativo);

        builder.setPositiveButton(R.string.Sim, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                Intent fecharaplicativo = new Intent(getApplicationContext(), MainActivity.class);
                fecharaplicativo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                fecharaplicativo.putExtra("SAIR", true);
                startActivity(fecharaplicativo);
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