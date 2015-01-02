package Controllers;

import android.util.Log;

import java.util.List;

import Models.Litoral;
import Utils.UtilLitoral;

/**
 * Created by enzo on 22/12/2014.
 */
public class ControllerLitoral
{
    public static List<Litoral> carregaLitoraisDaBase()
    {
        List<Litoral> _litorais = null;
        try
        {
            UtilLitoral _Ulitorais = new UtilLitoral();
            _litorais = _Ulitorais.carregaLitorais();
        }catch (Exception e)
        {
            Log.e("Erro: ", e.getMessage());
        }
        return _litorais;
    }
}
