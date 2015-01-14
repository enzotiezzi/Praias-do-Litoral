package Models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enzo on 22/12/2014.
 * Classe modelo dos litorais.
 */
public class Litoral extends Lugar
{

    public Litoral(int _id, String _nome, String _imageURL, int _qtdCidades)
    {
        super(_id, _nome, _imageURL, _qtdCidades);
    }

    @Override
    public int getQtd() {
        return super.getQtd();
    }

    @Override
    public Bitmap getImage() {
        return super.getImage();
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
