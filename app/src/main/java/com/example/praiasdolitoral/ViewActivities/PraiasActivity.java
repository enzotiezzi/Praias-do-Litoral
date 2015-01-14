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
import Models.Praia;
import Utils.ListaAdapter;
import Utils.UtilShowInformation;

/**
 * Created by enzo on 22/12/2014.
 */
public class PraiasActivity extends Activity
{
    private ListView lvPraias;
    private TextView tvSubTitlePraias;
    private Praia[] praias;
    private Activity thisActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praias);

        thisActivity = this;

        tvSubTitlePraias = (TextView) findViewById(R.id.tvSubTitlePraias);
        tvSubTitlePraias.setText(getIntent().getStringExtra("nome"));
        lvPraias = (ListView) findViewById(R.id.lvlPraias);
        lvPraias.setOnItemClickListener(lvPraiasListener);

        tvSubTitlePraias.setText(getIntent().getStringExtra("nome"));

        int id = getIntent().getIntExtra("id", -1);
        String url = "http://www.contasuahistoria.somee.com/Services/Praias/GHListaPraias.ashx?id="+id;

        Requisition.sendRequisition(new Requisition.OnRequisitionCallback() {
            @Override
            public void finishedRequisition(int status, Object object, Exception e)
            {
                if (e != null)
                {
                    UtilShowInformation.showInformation(thisActivity, "Erro", "Houve um erro");
                }
                else if (status != 200)
                {
                    UtilShowInformation.showInformation(thisActivity, "Erro", "Houve um erro com o servidor");
                }
                else
                {
                    praias = (Praia[])object;
                    ListaAdapter _adpPraias = new ListaAdapter(thisActivity, praias);
                    lvPraias.setAdapter(_adpPraias);
                }
            }
        }, url, "GET", null, thisActivity, Praia[].class);
    }

    AdapterView.OnItemClickListener lvPraiasListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Praia _p = praias[i];

            Intent _i = new Intent(getApplicationContext(), QuiosquesActivity.class);

            _i.putExtra("id", _p.getID());
            _i.putExtra("nome", _p.getNome());

            startActivity(_i);
        }
    };
}
