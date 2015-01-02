package Controllers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.Quiosque;
import Utils.UtilQuiosque;
import Utils.UtilShowInformation;

/**
 * Created by enzo on 23/12/2014.
 */
public class ControllerQuiosque
{
    public static List<Quiosque> carregaQuiosques(Context _context, Intent _i)
    {
        List<Quiosque> _quiosques = new ArrayList<Quiosque>();
        try
        {
            int _idCidade = _i.getIntExtra("idCidade", -1);
            int _id = _i.getIntExtra("id", -1);
            if (_idCidade == -1 || _id == -1)
            {
                UtilShowInformation.showInformation(_context, "Erro", "Não foi possível carregar a lista de quiosque");
            }
            else
            {
                UtilQuiosque _Uquiosque = new UtilQuiosque();
                _quiosques = _Uquiosque.carregaQuiosquesPorPraia(_id, _idCidade);
            }
        }
        catch(Exception e)
        {
            Log.e("Erro", e.getMessage());
        }
        return _quiosques;
    }

    public static Quiosque carregaQuiosque(Context _context, Intent _i)
    {
        Quiosque _q = null;

        try
        {
            int _id = _i.getIntExtra("id", -1);
            if(_id == -1)
            {
                UtilShowInformation.showInformation(_context, "Erro", "Não foi possível carregar as informações");
            }
            else
            {
                int _numeroQuiosque = _i.getIntExtra("numeroQuiosque", -1);
                String _nome = _i.getStringExtra("nome");
                String _rua = _i.getStringExtra("rua");
                String _baiiro = _i.getStringExtra("bairro");

                _q = new Quiosque(_id, _nome, _numeroQuiosque, _rua, _baiiro);
            }
        }
        catch(Exception e)
        {
            Log.e("Erro", e.getMessage());
        }

        return _q;
    }
}
