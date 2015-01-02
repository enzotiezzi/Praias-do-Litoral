package com.example.praiasdolitoral.ViewActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.praiasdolitoral.R;

import java.util.List;

import Controllers.ControllerQuiosque;
import Models.Quiosque;

/**
 * Created by enzo on 23/12/2014.
 */
public class QuiosquesActivity extends Activity
{
    private TextView tvSubTitleQuiosques;
    private ListView lvQuiosques;
    private List<Quiosque> quiosques;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiosques);

        tvSubTitleQuiosques = (TextView) findViewById(R.id.tvSubtitleQuiosques);
        lvQuiosques = (ListView) findViewById(R.id.lvQuiosques);

        tvSubTitleQuiosques.setText(getIntent().getStringExtra("nome"));

        lvQuiosques.setOnItemClickListener(lvQuiosquesListener);

        quiosques = ControllerQuiosque.carregaQuiosques(getApplicationContext(), getIntent());

        ArrayAdapter<Quiosque> _adpQuiosques = new ArrayAdapter<Quiosque>(this, android.R.layout.simple_list_item_1, quiosques);

        lvQuiosques.setAdapter(_adpQuiosques);
    }

    AdapterView.OnItemClickListener lvQuiosquesListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Quiosque _q = quiosques.get(i);

            Intent _i = new Intent(getApplicationContext(), DetalhesQuiosqueActivity.class);
            _i.putExtra("id", _q.getId());
            _i.putExtra("nome", _q.getNome());
            _i.putExtra("numeroQuiosque", _q.getNumeroQuiosque());
            _i.putExtra("rua", _q.getRua());
            _i.putExtra("bairro", _q.getBairro());

            startActivity(_i);
        }
    };
}
