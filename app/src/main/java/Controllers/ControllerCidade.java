package Controllers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.Cidade;
import Utils.UtilCidade;
import Utils.UtilShowInformation;

/**
 * Created by enzo on 22/12/2014.
 */
public class ControllerCidade
{
    public static List<Cidade> carregaListaDeCidades(Context _context, Intent _i)
    {
        List<Cidade> _cidades = new ArrayList<Cidade>();

        try
        {
            int _id = _i.getIntExtra("id", -1);

            if (_id == -1)
            {
                UtilShowInformation.showInformation(_context, "Erro", "Não foi possível carregar a lista de Cidades");
            }
            else
            {
                UtilCidade _Ucidade = new UtilCidade();
                _cidades = _Ucidade.carregaListaDeCidadePorLitoral(_id);
            }
        }
        catch(Exception e)
        {
            Log.e("Erro", e.getMessage());
        }

        return _cidades;
    }
}
