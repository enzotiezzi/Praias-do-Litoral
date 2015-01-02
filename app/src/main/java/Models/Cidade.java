package Models;

import java.util.List;

/**
 * Created by enzo on 22/12/2014.
 */
public class Cidade
{
    private int id;
    private String nome;
    private String estado;
    private List<Praia> praias;

    public Cidade(int _id, String _nome, String _estado)
    {
        this.id = _id;
        this.nome = _nome;
        this.estado = _estado;
    }

    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public String getEstado()
    {
        return estado;
    }

    public List<Praia> getPraias()
    {
        return praias;
    }

    public void setPraias(List<Praia> praias)
    {
        this.praias = praias;
    }

    public void adicionaPraia(Praia _p)
    {
        this.praias.add(_p);
    }

    public Praia selecionaPraia(int _indice)
    {
        return this.praias.get(_indice);
    }

    @Override
    public String toString()
    {
        return nome;
    }
}
