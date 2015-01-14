package Models;

import android.graphics.Bitmap;

/**
 * Created by enzo on 22/12/2014.
 */
public class Quiosque extends Lugar
{
    private int NumeroQuiosque;
    private String Rua;
    private String Bairro;
    private double Lat;
    private double Lng;

    public Quiosque(int _id, String _nome, int _numeroQuiosque, String _rua, String _bairro, String _imageURL, int _qtd)
    {
        super(_id, _nome, _imageURL, _qtd);
        this.NumeroQuiosque = _numeroQuiosque;
        this.Rua = _rua;
        this.Bairro = _bairro;
    }

    public int getNumeroQuiosque()
    {
        return NumeroQuiosque;
    }

    public String getBairro()
    {
        return Bairro;
    }

    public String getRua()
    {
        return Rua;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    public double getLat() {
        return Lat;
    }

    public double getLng() {
        return Lng;
    }

    public void setLat(double lat) {
        this.Lat = lat;
    }

    public void setLng(double lng) {
        this.Lng = lng;
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
