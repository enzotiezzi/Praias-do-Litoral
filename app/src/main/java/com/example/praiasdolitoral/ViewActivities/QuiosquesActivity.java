package com.example.praiasdolitoral.ViewActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.praiasdolitoral.R;

import java.util.List;

import Controllers.Requisition;
import Models.Quiosque;
import Utils.ListaAdapter;
import Utils.UtilShowInformation;

/**
 * Created by enzo on 23/12/2014.
 */
public class QuiosquesActivity extends Activity
{
    private TextView tvSubTitleQuiosques;
    private ListView lvQuiosques;
    private Quiosque[] quiosques;
    private Activity thisActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiosques);

        thisActivity = this;

        tvSubTitleQuiosques = (TextView) findViewById(R.id.tvSubtitleQuiosques);
        lvQuiosques = (ListView) findViewById(R.id.lvQuiosques);
        tvSubTitleQuiosques.setText(getIntent().getStringExtra("nome"));
        lvQuiosques.setOnItemClickListener(lvQuiosquesListener);

        int id = getIntent().getIntExtra("id", -1);
        String url = "http://www.contasuahistoria.somee.com/Services/Praias/GHListaQuiosques.ashx?id="+id;

        Requisition.sendRequisition(new Requisition.OnRequisitionCallback() {
            @Override
            public void finishedRequisition(int status, Object object, Exception e)
            {
                if (status == 200)
                {
                    quiosques = (Quiosque[])object;
                    ListaAdapter _adpQuiosques = new ListaAdapter(thisActivity, quiosques);
                    lvQuiosques.setAdapter(_adpQuiosques);

                }else if (e != null)
                {
                    UtilShowInformation.showInformation(thisActivity, "Erro", "Ocorreu um erro");
                }else if (status == -1)
                {
                    UtilShowInformation.showInformation(thisActivity, "Erro", "Ocorreu um erro");
                }
            }
        }, url, "GET", null, thisActivity, Quiosque[].class);
    }

    AdapterView.OnItemClickListener lvQuiosquesListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Quiosque _q = quiosques[i];

            Intent _i = new Intent(getApplicationContext(), DetalhesQuiosqueActivity.class);
            _i.putExtra("id", _q.getID());
            _i.putExtra("nome", _q.getNome());
            _i.putExtra("numeroQuiosque", _q.getNumeroQuiosque());
            _i.putExtra("rua", _q.getRua());
            _i.putExtra("bairro", _q.getBairro());

            startActivity(_i);
        }
    };
}
