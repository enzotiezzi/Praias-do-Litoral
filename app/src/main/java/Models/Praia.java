package Models;

import java.util.List;

/**
 * Created by enzo on 22/12/2014.
 */
public class Praia
{
    private int id;
    private int idCidade;
    private String nome;
    private String estado;
    private String cidade;
    private List<Quiosque> quioesques;

    public Praia(int _id, int _idCidade, String _nome, String _estado, String _cidade)
    {
        this.id = _id;
        this.idCidade = _idCidade;
        this.nome = _nome;
        this.estado = _estado;
        this.cidade = _cidade;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCidade()
    {
        return cidade;
    }

    public String getEstado()
    {
        return estado;
    }

    public List<Quiosque> getQuioesques()
    {
        return quioesques;
    }

    public int getId()
    {
        return id;
    }

    public int getIdCidade()
    {
        return idCidade;
    }

    public void setQuioesques(List<Quiosque> quioesques)
    {
        this.quioesques = quioesques;
    }

    @Override
    public String toString()
    {
        return this.nome;
    }
}
