package Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.Cidade;
import Models.Litoral;
import Models.Praia;

/**
 * Created by enzo on 22/12/2014.
 */
public class UtilPraia
{
    public UtilPraia()
    {

    }

    public List<Praia> carregaListaDePraiaPorCidade(int _id)
    {
        List<Praia> _praias = new ArrayList<Praia>();

        try
        {
            UtilCidade _Ucidade = new UtilCidade();
            List<Cidade> _cidades = _Ucidade.carregaListaDeCidadePorLitoral(_id);

            for (Cidade _c : _cidades)
            {
                if (_c.getId() == _id)
                {
                    _praias = _c.getPraias();
                }
            }
        }
        catch(Exception e)
        {
            Log.e("Erro", e.getMessage());
        }

        return _praias;
    }

    public static List<Praia> carregaPraias()
    {
        List<Praia> _praias = new ArrayList<Praia>();

        Praia _p1 = new Praia(1, 1,"Mococa", "São Paulo", "Caraguatatuba");
        _p1.setQuioesques(UtilQuiosque.carregaQuiosques());
        _praias.add(_p1);

        return _praias;
    }
}
