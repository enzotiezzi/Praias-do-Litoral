package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enzo on 22/12/2014.
 * Classe modelo dos litorais.
 */
public class Litoral
{
    private int id;
    private String nome;
    private List<Cidade> cidades;

    public Litoral(int _id, String _nome)
    {
        this.id = _id;
        this.nome = _nome;
        this.cidades = new ArrayList<Cidade>();
    }

    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public List<Cidade> getCidades()
    {
        return cidades;
    }

    public void colocarLista(List<Cidade> _cidades)
    {
        this.cidades = _cidades;
    }

    public void adicionarCidade(Cidade _cidade)
    {
        this.cidades.add(_cidade);
    }

    public Cidade selecionarCidade(int _indice)
    {
        return cidades.get(_indice);
    }

    public void setCidades(List<Cidade> cidades)
    {
        this.cidades = cidades;
    }

    @Override
    public String toString()
    {
        return nome;
    }
}
