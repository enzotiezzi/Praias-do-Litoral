package Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.Praia;
import Models.Quiosque;

/**
 * Created by enzo on 22/12/2014.
 */
public class UtilQuiosque
{

    public UtilQuiosque()
    {

    }

    public List<Quiosque> carregaQuiosquesPorPraia(int _id, int _idCidade)
    {
        List<Quiosque> _quiosques = new ArrayList<Quiosque>();

        try
        {
            UtilPraia _Upraia = new UtilPraia();
            List<Praia> _praias = _Upraia.carregaListaDePraiaPorCidade(_idCidade);

            for (Praia _p : _praias)
            {
                if(_p.getId() == _id)
                {
                    _quiosques = _p.getQuioesques();
                }
            }
        }
        catch(Exception e)
        {
            Log.e("Erro", e.getMessage());
        }

        return _quiosques;
    }

    public static List<Quiosque> carregaQuiosques()
    {
        List<Quiosque> _quiosques = new ArrayList<Quiosque>();

        Quiosque _q1 = new Quiosque(1, "Vista Linda", 12, "Rua Mococa", "Bairoo");
        Quiosque _q2 = new Quiosque(2, "Quiosque do Serjão", 11, "Rua Mococa", "Bairro");

        _quiosques.add(_q1);
        _quiosques.add(_q2);

        return _quiosques;
    }
}


