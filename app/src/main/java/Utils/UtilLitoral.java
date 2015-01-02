package Utils;

import java.util.ArrayList;
import java.util.List;

import Models.Cidade;
import Models.Litoral;

/**
 * Created by enzo on 22/12/2014.
 */
public class UtilLitoral
{
    public UtilLitoral()
    {
        //conectara ao banco
    }

    public List<Litoral> carregaLitorais()
    {
        List<Litoral> _litorais = new ArrayList<Litoral>();

        Litoral _l1 = new Litoral(1, "Norte");
        Litoral _l2 = new Litoral(2, "Sul");

        _l1.setCidades(UtilCidade.carregaCidades());

        _litorais.add(_l1);
        _litorais.add(_l2);

        return _litorais;
    }
}
