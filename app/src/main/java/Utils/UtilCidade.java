package Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.Cidade;
import Models.Litoral;

/**
 * Created by enzo on 22/12/2014.
 */
public class UtilCidade
{
    public UtilCidade()
    {

    }

    public List<Cidade> carregaListaDeCidadePorLitoral(int _id)
    {
        List<Cidade> _cidades = new ArrayList<Cidade>();
        UtilLitoral _Ulitoral = new UtilLitoral();

        try
        {
            for (Litoral _l : _Ulitoral.carregaLitorais())
            {
                if(_l.getId() == _id)
                {
                    _cidades = _l.getCidades();
                }
            }
        }
        catch(Exception e)
        {
            Log.e("Erro", e.getMessage());
        }

        return _cidades;
    }

    public static List<Cidade> carregaCidades()
    {
        List<Cidade> _cidades = new ArrayList<Cidade>();

        Cidade _c1 = new Cidade(1, "Caraguatatuba", "São Paulo");
        _c1.setPraias(UtilPraia.carregaPraias());

        Cidade _c2 = new Cidade(2, "Ubatuba", "São Paulo");

        _cidades.add(_c1);
        _cidades.add(_c2);

        return _cidades;
    }
}
