package Controllers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.Praia;
import Utils.UtilPraia;
import Utils.UtilShowInformation;

/**
 * Created by enzo on 22/12/2014.
 */
public class ControllerPraia
{
    public static List<Praia> carregaListaDePraias(Context _context, Intent _i)
    {
        List<Praia> _praias = new ArrayList<Praia>();
        try
        {
            int _id = _i.getIntExtra("id", -1);
            if (_id == -1)
            {
                UtilShowInformation.showInformation(_context, "Erro", "Não foi possível carregar lista de praias");
            }
            else
            {
                UtilPraia _Upraia = new UtilPraia();
                _praias  = _Upraia.carregaListaDePraiaPorCidade(_id);
            }
        }
        catch(Exception e)
        {
            Log.e("Erro", e.getMessage());
        }

        return _praias;
    }
}
