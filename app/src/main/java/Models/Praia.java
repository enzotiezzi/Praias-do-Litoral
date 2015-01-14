package Models;

import android.graphics.Bitmap;

/**
 * Created by enzo on 22/12/2014.
 */
public class Praia extends Lugar
{
    private int IDCidade;

    public Praia(int _id, int _idCidade, String _nome, String _estado, String _cidade, String _imageURL, int _qtd)
    {
        super(_id, _nome, _imageURL, _qtd);
        this.IDCidade = _idCidade;
    }


    public int getIDCidade() {
        return IDCidade;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public void setImage(Bitmap image) {
        super.setImage(image);
    }

    @Override
    public String toString()
    {
        return super.getNome();
    }
}
