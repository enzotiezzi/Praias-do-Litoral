package com.example.praiasdolitoral.ViewActivities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.praiasdolitoral.R;

import Controllers.Requisition;
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
    private ImageView ivQuiosque;
    private Activity thisActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_quiosque);

        this.thisActivity = this;

        tvSubTitleDetalhesQuiosque = (TextView) findViewById(R.id.tvSubTitleDetalhesQuiosque);
        tvBairro = (TextView) findViewById(R.id.tvBairro);
        tvRua = (TextView) findViewById(R.id.tvRua);
        tvNumeroQuiosque = (TextView) findViewById(R.id.tvNumeroQuiosque);
        ivQuiosque = (ImageView)findViewById(R.id.ivQuiosque);

        tvSubTitleDetalhesQuiosque.setText(getIntent().getStringExtra("nome"));
        tvNumeroQuiosque.setText(String.valueOf(getIntent().getIntExtra("numeroQuiosque", -1)));
        tvRua.setText(getIntent().getStringExtra("rua"));
        tvBairro.setText(getIntent().getStringExtra("bairro"));

        int id = getIntent().getIntExtra("id", -1);
        String url = "http://www.contasuahistoria.somee.com/Services/Praias/GHRetornaImageURL.ashx?id="+id;

        Requisition.sendRequisition(new Requisition.OnRequisitionCallback() {
            @Override
            public void finishedRequisition(int status, Object object, Exception e)
            {
                if (status == 200)
                {
                    Bitmap image = (Bitmap) object;
                    ivQuiosque.setImageBitmap(image);
                }
            }
        }, url, "GET", null, thisActivity, String.class);
    }
}
