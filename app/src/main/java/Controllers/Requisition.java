package Controllers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.lang.reflect.Type;
import java.net.URL;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

import Models.Cidade;
import Models.Litoral;
import Models.Lugar;
import Models.Praia;
import Models.Quiosque;
import Utils.UtilShowInformation;

/**
 * Created by enzo on 13/01/2015.
 */
public class Requisition
{
    public interface OnRequisitionCallback
    {
        public void finishedRequisition(int status, Object object, Exception e);
    }

    public static void sendRequisition(final OnRequisitionCallback callback, final String url, final String requisitionMethod, final Object object, final Activity activity, final Type type)
    {

        (new AsyncTask<String, Void, Object>() {
            private int status = -1;
            private ProgressDialog progressDialog;

            @Override
            protected void onPreExecute()
            {
                progressDialog = ProgressDialog.show(activity, "Aguarde", "Estamos carregando a lista");
            }

            @Override
            protected Object doInBackground(String... strings)
            {
                HttpClient httpClient = new DefaultHttpClient();
                HttpUriRequest method = null;

                try
                {
                    if (requisitionMethod.toUpperCase() == "POST") {
                        Gson gson = new Gson();

                        HttpPost post = new HttpPost(url);
                        post.setEntity(new ByteArrayEntity(gson.toJson(object).getBytes()));

                        method = post;
                        method.setHeader("Content-Type", "appliation/json");
                    }
                    if (requisitionMethod.toUpperCase() == "GET") {
                        HttpGet httpGet = new HttpGet(url);
                        method = httpGet;
                    }

                    method.setHeader("Accept", "application/json");
                    method.setHeader("Accept-Charset", "utf-8");

                    HttpResponse response = httpClient.execute(method);

                    status = response.getStatusLine().getStatusCode();

                    String jsonBody = EntityUtils.toString(response.getEntity());

                    Object generic = convertJson(jsonBody, type, activity);

                    return generic;
                }
                catch(Exception e)
                {
                    callback.finishedRequisition(-1, null, e);
                    return e;
                }
            }

            @Override
            protected void onPostExecute(Object s)
            {
                if (s == null)
                {
                    callback.finishedRequisition(-1, null, null);
                }
                else if(status == 200)
                {
                    callback.finishedRequisition(status, s, null);
                }
                else if (s instanceof Exception)
                {
                    callback.finishedRequisition(-1, null, null);
                }
                progressDialog.dismiss();
            }
        }).execute();
    }

    private static Object convertJson(String jsonBody, Type type, Activity activity)
    {
        if (type == Litoral[].class)
        {
            Litoral[] litorais = new Gson().fromJson(jsonBody, type);
            downloadImage(litorais, activity);
            return litorais;
        }else if (type == Cidade[].class)
        {
            Cidade[] cidades = new Gson().fromJson(jsonBody, type);
            downloadImage(cidades, activity);
            return cidades;
        }else if (type == Praia[].class)
        {
            Praia[] praias = new Gson().fromJson(jsonBody, type);
            downloadImage(praias, activity);
            return praias;
        }
        else if (type == Quiosque[].class)
        {
            Quiosque[] quiosques = new Gson().fromJson(jsonBody, type);
            downloadImage(quiosques, activity);
            return quiosques;
        }
        else if (type == Quiosque.class)
        {
            Quiosque quiosque = new Gson().fromJson(jsonBody, type);
            return quiosque;
        }
        else if (type == String.class)
        {
            return downloadImage(jsonBody, activity);
        }
        return null;
    }

    private static void downloadImage(Lugar[] lista, Activity activity)
    {
        try {
            for (int i = 0; i < lista.length; i++) {
                URL url = new URL(lista[i].getImageURL());
                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                lista[i].setImage(bitmap);
            }
        }catch(Exception e)
        {
            UtilShowInformation.showInformation(activity, "Erro", "Erro durante o download das imagens");
        }
    }

    private static Bitmap downloadImage(String _url, Activity activity)
    {
        Bitmap bitmap = null;
        try
        {
            URL url = new URL(_url);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }
        catch(Exception e)
        {
            UtilShowInformation.showInformation(activity, "Erro", "Erro durante o download daa imagen");
        }
        return bitmap;
    }
}
