package com.example.praiasdolitoral.ViewActivities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.praiasdolitoral.R;
import com.google.gson.Gson;

import java.net.URL;
import java.util.Objects;

import Controllers.Requisition;
import Models.Litoral;
import Utils.ListaAdapter;
import Utils.UtilShowInformation;

public class MainActivity extends Activity {

    private ListView lvLitorais;
    private Litoral[] litorais;
    private Activity thisActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        thisActivity = this;

        lvLitorais = (ListView) findViewById(R.id.lvLitorais);

        Requisition.sendRequisition(new Requisition.OnRequisitionCallback() {
            @Override
            public void finishedRequisition(int status, Object object, Exception e)
            {
                if (status == 200)
                {
                    litorais = (Litoral[])object;

                    ListaAdapter adpLitorais = new ListaAdapter(getApplicationContext(), litorais);
                    lvLitorais.setAdapter(adpLitorais);
                }
                else if(e != null)
                {
                    UtilShowInformation.showInformation(thisActivity, "Erro", "Houve um erro, tente novamente");
                }
                else if (object == null && status == -1)
                {
                    UtilShowInformation.showInformation(thisActivity, "Nada", "Não há Litorais para serem carregados");
                }
            }
        }, "http://www.contasuahistoria.somee.com/Services/Praias/GHListaListorais.ashx", "GET", null, thisActivity, Litoral[].class);


        lvLitorais.setOnItemClickListener(lvLitoraisListener);
	}

    AdapterView.OnItemClickListener lvLitoraisListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Litoral _litoral = litorais[i];
            int _id = _litoral.getID();

            Intent _Icidades = new Intent(getApplicationContext(), CidadesActivity.class);

            _Icidades.putExtra("id", _id);
            startActivity(_Icidades);
        }
    };
}
