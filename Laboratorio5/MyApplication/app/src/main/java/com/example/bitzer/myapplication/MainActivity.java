package com.example.bitzer.myapplication;
//como se observo al ejecutar se cargo la barra y descargo la imagen
//ambos procesos se hicieron al mismo tiempo
//Estan todos los paquetes que se uso para lograr hacer ambos
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;

public class MainActivity extends Activity {
    //definimos las variables Button
    private Button btnHilo; //btnHilo ejecuatara la carga de la barra con Threads
    private Button btnAsyncTask; // btnAsyncTask descargargara la imagen

    private ProgressBar pbarProgreso; // declaramos un control ProgressBar
    private ImageView imgImagen; //declaramos la variable instancia de ImageView

    //definimos una variable estatica que tendra la url de nuestra imagen a descargar
    public static final String URL = "http://blog.capacityacademy.com/wp-content/uploads/2014/11/linux-tux.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO ESTO ES PARA TRABAJAR CON THREADS
        pbarProgreso = (ProgressBar)findViewById(R.id.pbarProgreso); //asociamos pbarProgreso con el id del control ProgressBar
        btnHilo = (Button)findViewById(R.id.btnHilo); //el id del button asociamos con la variable
        //btnHilo ejecutara el metodo setOnClikListener
        btnHilo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //instanciamos un objeto de la clase Thread
                new Thread(new Runnable() {
                    public void run() {
                        //el primer post para interactuar con la interfaz
                        //los post reciben como parametro Runnable que se construyen con run
                        pbarProgreso.post(new Runnable() {
                            public void run() {
                                pbarProgreso.setProgress(0);//iniciamos la el ProgressBar vacio
                            }
                        });
                        //empezamos la interacion para cargar la barra
                        for(int i=1; i<=10; i++) {
                            tareaLarga(); //llamamos al metodo que espera un segundo
                            //se inicia el segundo post como se sabe los metodo post reciben como parametro Runnable que se construyen con el metodo run()
                            pbarProgreso.post(new Runnable() {
                                public void run() {
                                    pbarProgreso.incrementProgressBy(10); //Incrementa la barra en 10 unidades
                                }
                            });
                        }
                    }
                    //metodo hace esperar un segundo
                    private void tareaLarga()
                    {
                        try {
                            Thread.sleep(1000);  //espera 1000ms
                        } catch(InterruptedException e) {}
                    }
                }).start();//iniciamos el metodo start del objeto Thread para comenzar la ejecucion en segundo plano
            }
        });
        //AHORA EMPEZEMOS CON ASYNTASK
        //inicializamos ImageView
        imgImagen = (ImageView)findViewById(R.id.imagen);
        btnAsyncTask = (Button)findViewById(R.id.btnAsyncTask); //inicializamos el button

        //Creamos el objeto nuevaTarea del metodo CargaImagenes que es extension de AsynTask
        CargaImagenes nuevaTarea = new CargaImagenes();

        //el objeto btnAsynctask usa el metodo setOnClickListener
        btnAsyncTask.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                CargaImagenes nuevaTarea = new CargaImagenes();
                nuevaTarea.execute(URL);//ejecutamos el objeto nueva Tarea
            }

        });
    }

    //el metodo AsyncTask
    //recibe tres parmetros
    private class CargaImagenes extends AsyncTask<String, Void, Bitmap>{
        @Override
        //implementamos la tarea a realizar
        protected Bitmap doInBackground(String... params) {

            String url = params[0];  //cogemos el param[0] de la lista de parametros ya que solo ingresamos un parametro
            Bitmap imagen = descargarImagen(url); //definimos un objeto de la clase Bitmap que guardara la imagen pasamos como parametro la url
            return imagen; //retorna una instancia
        }

        @Override
        //inicia al terminar doInBackground se interactua con el hilo principal
        //onPostExecute inicia al terminar doInBackground
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imgImagen.setImageBitmap(result); //con este metodo establecemos la imagen en el ImageView
        }

    }
    //este metodo verifica la conexion con internet para descargar la imagen
    private Bitmap descargarImagen (String imageHttpAddress){
        URL imageUrl = null;
        Bitmap imagen = null;
        try{
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return imagen;
    }
}
