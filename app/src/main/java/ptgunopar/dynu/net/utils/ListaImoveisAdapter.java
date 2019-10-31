package ptgunopar.dynu.net.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ptgunopar.dynu.net.dados.DadosListaImoveis;
import ptgunopar.dynu.net.ptgunopar.R;

public class ListaImoveisAdapter extends BaseAdapter {

    private Context contexto;
    private List<DadosListaImoveis> listaimoveis;

    public ListaImoveisAdapter(Context contexto2, List<DadosListaImoveis> listaimoveis2) {
        contexto = contexto2;
        listaimoveis = listaimoveis2;
    }

    @Override
    public int getCount() {
        return listaimoveis.size();
    }

    @Override
    public DadosListaImoveis getItem(int position) {
        return listaimoveis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) contexto).getLayoutInflater();
            view = inflater.inflate(R.layout.activity_lista_imoveis, null);
        } else {
            view = convertView;
        }

        DadosListaImoveis itenslistaimoveis = getItem(position);

        TextView Tv_ListaID = view.findViewById(R.id.Tv_ListaID);
        TextView Tv_ListaTipo = view.findViewById(R.id.Tv_ListaTipo);
        TextView Tv_ListaTitulo = view.findViewById(R.id.Tv_ListaTitulo);

        Tv_ListaID.setText(itenslistaimoveis.getID());
        Tv_ListaTipo.setText(itenslistaimoveis.getTipo());
        Tv_ListaTitulo.setText(itenslistaimoveis.getTitulo());

        return view;
    }
}