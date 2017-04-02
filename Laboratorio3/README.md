Actividad 4 
============
 - [Introducción](#introducción)
  - [¿Qué es Markdown?](#qué-es-markdown)
  - [Ejemplos](#ejemplos)
  - [Sintaxis básica](#sintaxis-básica)
  - [GFM](#gfm)
# Dispositivos-moviles Android Studio
creamos una clase pública que herede de AppCompatActivity llamada SegundaActividad
```java
package com.example.bitzer.primeraaplicacion;

/**
 * Created by bitzer on 02/04/17.
 */

public class SegundaActividad {
}
```
Al poner extends AppCompatActivity nos solicita importar la siguiente libreria 

**import android.support.v7.app.AppCompatActivity;**
```java
package com.example.bitzer.primeraaplicacion;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by bitzer on 02/04/17.
 */

public class SegundaActividad extends AppCompatActivity {
}
```
Al igual que el caso anterior al implementar el metodo onCreate nos solicita importar la libreria 
***import android.os.Bundle;***
```java
package com.example.bitzer.primeraaplicacion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bitzer on 02/04/17.
 */

public class SegundaActividad extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

