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

import Controllers.ControllerCidade;
import Models.Cidade;


/**
 * Created by enzo on 22/12/2014.
 */
public class CidadesActivity extends Activity
{
    private TextView tvSubTitleCidades;
    private ListView lvCidades;
    private List<Cidade> cidades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidades);

        lvCidades = (ListView) findViewById(R.id.lvCidades);
        tvSubTitleCidades = (TextView) findViewById(R.id.tvSubTitleCidades);
        tvSubTitleCidades.setText(getIntent().getStringExtra("nome"));

        cidades = ControllerCidade.carregaListaDeCidades(getApplicationContext(), getIntent());

        lvCidades.setOnItemClickListener(lvCidadesListener);
        ArrayAdapter<Cidade> _adpCidades = new ArrayAdapter<Cidade>(this, android.R.layout.simple_list_item_1, cidades);
        lvCidades.setAdapter(_adpCidades);
    }

    AdapterView.OnItemClickListener lvCidadesListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Cidade _c = cidades.get(i);

            Intent _i = new Intent(getApplicationContext(), PraiasActivity.class);

            _i.putExtra("id", _c.getId());
            _i.putExtra("nome", _c.getNome());

            startActivity(_i);
        }
    };
}
