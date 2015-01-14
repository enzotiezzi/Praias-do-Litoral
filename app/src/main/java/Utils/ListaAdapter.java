package Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.praiasdolitoral.R;

import org.w3c.dom.Text;

import java.net.URI;
import java.net.URL;

import Models.Cidade;
import Models.Litoral;
import Models.Lugar;
import Models.Praia;
import Models.Quiosque;

/**
 * Created by enzo on 13/01/2015.
 */
public class ListaAdapter extends BaseAdapter {

    private Lugar[] lugares;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListaAdapter(Context context, Lugar[] lugares)
    {
        this.lugares = lugares;
        this.context = context;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lugares.length;
    }

    @Override
    public Object getItem(int i) {
        return lugares[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ItemLitoralHelper litoralHelper;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_litoral, null);

            litoralHelper = new ItemLitoralHelper();

            litoralHelper.ivLitoral = (ImageView) view.findViewById(R.id.ivLitoral);
            litoralHelper.tvNomeObj = (TextView) view.findViewById(R.id.tvNomeObj);
            litoralHelper.tvQuantidadeObj = (TextView) view.findViewById(R.id.tvQuantidadeObj);

            view.setTag(litoralHelper);
        } else {
            litoralHelper = (ItemLitoralHelper) view.getTag();
        }

        Lugar l = lugares[i];

        String qtd = "Quantidade de ";
        if (l instanceof Litoral)
        {
            qtd += "cidades: ";
        }
        else if(l instanceof Cidade)
        {
            qtd += "praias: ";
        }
        else if (l instanceof Praia)
        {
            qtd += "quiosques: ";
        }
        else if (l instanceof  Quiosque)
        {
            qtd = "";
        }

        litoralHelper.tvNomeObj.setText(l.getNome());
        if (l instanceof Quiosque)
        {
            litoralHelper.tvQuantidadeObj.setText("");
        }
        else
        {
            litoralHelper.tvQuantidadeObj.setText(qtd+String.valueOf(l.getQtd()));
        }
        litoralHelper.ivLitoral.setImageBitmap(l.getImage());

        return view;
    }

    private class ItemLitoralHelper
    {
        ImageView ivLitoral;
        TextView tvNomeObj;
        TextView tvQuantidadeObj;
    }
}
