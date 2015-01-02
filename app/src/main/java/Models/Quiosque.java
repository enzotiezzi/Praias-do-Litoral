package Models;

/**
 * Created by enzo on 22/12/2014.
 */
public class Quiosque
{
    private int id;
    private String nome;
    private int numeroQuiosque;
    private String rua;
    private String bairro;

    public Quiosque(int _id, String _nome, int _numeroQuiosque, String _rua, String _bairro)
    {
        this.id = _id;
        this.nome = _nome;
        this.numeroQuiosque = _numeroQuiosque;
        this.rua = _rua;
        this.bairro = _bairro;
    }

    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public int getNumeroQuiosque()
    {
        return numeroQuiosque;
    }

    public String getBairro()
    {
        return bairro;
    }

    public String getRua()
    {
        return rua;
    }

    @Override
    public String toString()
    {
        return this.nome;
    }
}
