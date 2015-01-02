package com.example.praiasdolitoral.ViewActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.praiasdolitoral.R;

import Controllers.ControllerQuiosque;
import Models.Quiosque;

/**
 * Created by enzo on 23/12/2014.
 */
public class DetalhesQuiosqueActivity extends Activity
{
    private TextView tvSubTitleDetalhesQuiosque;
    private TextView tvRua;
    private TextView tvBairro;
    private TextView tvNumeroQuiosque;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_quiosque);

        tvSubTitleDetalhesQuiosque = (TextView) findViewById(R.id.tvSubTitleDetalhesQuiosque);
        tvBairro = (TextView) findViewById(R.id.tvBairro);
        tvRua = (TextView) findViewById(R.id.tvRua);
        tvNumeroQuiosque = (TextView) findViewById(R.id.tvNumeroQuiosque);

        Quiosque _q = ControllerQuiosque.carregaQuiosque(getApplicationContext(), getIntent());

        tvSubTitleDetalhesQuiosque.setText(_q.getNome());
        tvNumeroQuiosque.setText("Número do Quiosque: " + String.valueOf(_q.getNumeroQuiosque()));
        tvRua.setText("Rua: " + _q.getRua());
        tvBairro.setText("Bairro: " + _q.getBairro());
    }
}
