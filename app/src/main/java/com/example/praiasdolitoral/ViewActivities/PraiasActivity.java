package com.example.praiasdolitoral.ViewActivities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.praiasdolitoral.R;

import java.util.List;

import Controllers.ControllerPraia;
import Models.Litoral;
import Models.Praia;

/**
 * Created by enzo on 22/12/2014.
 */
public class PraiasActivity extends Activity
{
    private ListView lvPraias;
    private TextView tvSubTitlePraias;
    private List<Praia> _praias;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praias);

        tvSubTitlePraias = (TextView) findViewById(R.id.tvSubTitlePraias);
        tvSubTitlePraias.setText(getIntent().getStringExtra("nome"));
        lvPraias = (ListView) findViewById(R.id.lvlPraias);

        _praias = ControllerPraia.carregaListaDePraias(getApplicationContext(), getIntent());

        lvPraias.setOnItemClickListener(lvPraiasListener);

        ArrayAdapter<Praia> _adpPraias = new ArrayAdapter<Praia>(this, android.R.layout.simple_list_item_1, _praias);

        lvPraias.setAdapter(_adpPraias);
    }

    AdapterView.OnItemClickListener lvPraiasListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
        {
            Praia _p = _praias.get(i);

            Intent _i = new Intent(getApplicationContext(), QuiosquesActivity.class);

            _i.putExtra("id", _p.getId());
            _i.putExtra("idCidade", _p.getIdCidade());
            _i.putExtra("nome", _p.getNome());

            startActivity(_i);
        }
    };
}
