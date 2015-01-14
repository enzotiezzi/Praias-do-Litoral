package Models;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by enzo on 22/12/2014.
 */
public class Cidade extends Lugar
{
    private String Estado;

    public Cidade(int _id, String _nome, String _estado, String _imageURL, int _qtd)
    {
        super(_id, _nome, _imageURL, _qtd);
        this.Estado = _estado;
    }

    public String getEstado()
    {
        return Estado;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public void setImage(Bitmap image) {
        super.setImage(image);
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    }

    @Override
    public String toString()
    {
        return super.getNome();
    }
}
