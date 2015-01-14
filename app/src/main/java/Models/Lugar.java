package Models;

import android.graphics.Bitmap;

/**
 * Created by enzo on 13/01/2015.
 */
public abstract class Lugar
{
    private int ID;
    private String Nome;
    private String ImageURL;
    private int Qtd;
    private Bitmap image;

    public Lugar(int id, String nome, String imageURL, int qtd)
    {
        this.ID = id;
        this.Nome = nome;
        this.ImageURL = imageURL;
        this.Qtd = qtd;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public int getQtd() {
        return Qtd;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setQtd(int qtd) {
        Qtd = qtd;
    }
}
