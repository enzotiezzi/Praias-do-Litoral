package com.example.praiasdolitoral.ViewActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.praiasdolitoral.R;

import java.util.List;

import Controllers.ControllerLitoral;
import Models.Litoral;
import Models.Praia;

public class MainActivity extends Activity {

    private ListView lvLitorais;
    private List<Litoral> litorais;
	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        lvLitorais = (ListView) findViewById(R.id.lvLitorais);
        litorais = ControllerLitoral.carregaLitoraisDaBase();

        ArrayAdapter<Litoral> adpLitorais = null;
        adpLitorais = new ArrayAdapter<Litoral>(this, android.R.layout.simple_list_item_1, litorais);
        lvLitorais.setAdapter(adpLitorais);

        lvLitorais.setOnItemClickListener(lvLitoraisListener);
	}

    AdapterView.OnItemClickListener lvLitoraisListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Litoral _litoral = litorais.get(i);
            String _nome = _litoral.getNome();
            int _id = _litoral.getId();

            Intent _Ipraias = new Intent(getApplicationContext(), CidadesActivity.class);

            _Ipraias.putExtra("nome", _nome);
            _Ipraias.putExtra("id", _id);
            startActivity(_Ipraias);
        }
    };
}
