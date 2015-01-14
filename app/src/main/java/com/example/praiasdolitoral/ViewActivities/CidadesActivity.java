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
import Models.Cidade;
import Models.Praia;
import Utils.ListaAdapter;
import Utils.UtilShowInformation;


/**
 * Created by enzo on 22/12/2014.
 */
public class CidadesActivity extends Activity
{
    private TextView tvSubTitleCidades;
    private ListView lvCidades;
    private Cidade[] cidades;
    private Activity thisActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidades);

        thisActivity = this;

        lvCidades = (ListView) findViewById(R.id.lvCidades);
        tvSubTitleCidades = (TextView) findViewById(R.id.tvSubTitleCidades);
        tvSubTitleCidades.setText(getIntent().getStringExtra("nome"));

        lvCidades.setOnItemClickListener(lvCidadesListener);


        int id = getIntent().getIntExtra("id", -1);
        String url = "http://www.contasuahistoria.somee.com/Services/Praias/GHListaCidades.ashx?id="+id;

        Requisition.sendRequisition(new Requisition.OnRequisitionCallback() {
            @Override
            public void finishedRequisition(int status, Object object, Exception e) {
                if (e != null) {
                    UtilShowInformation.showInformation(thisActivity, "Erro", e.getMessage());
                } else if (object instanceof Exception) {
                    UtilShowInformation.showInformation(thisActivity, "Erro", "Houve um erro");
                } else if (status == 200) {
                    cidades = (Cidade[]) object;

                    ListaAdapter adapter = new ListaAdapter(getApplicationContext(), cidades);
                    lvCidades.setAdapter(adapter);
                }
            }
        }, url, "GET", null, thisActivity, Cidade[].class);
    }

    AdapterView.OnItemClickListener lvCidadesListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Cidade _c = cidades[i];

            Intent _i = new Intent(getApplicationContext(), PraiasActivity.class);

            _i.putExtra("id", _c.getID());
            _i.putExtra("nome", _c.getNome());

            startActivity(_i);
        }
    };
}
