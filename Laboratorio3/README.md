Actividad 4 
============
# Pregunta 1 a la 11
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
Cambiamos el nombre de la interfaz gráfica llamandola 
***activity_segunda_actividad***
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
        setContentView(R.layout.activity_segunda_actividad);
    }
}
```
Lo anterior genera un error por lo que no existe dicha interfaz, por lo que creamos nuestra nueva interfaz
***activity_segunda_actividad.xml***
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.bitzer.primeraaplicacion.SegundaActividad">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/app_nombre"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
Para esto creamos nuestra nueva variable y asignarle un valor en ***strings.xml***
```xml
<resources>
    <string name="app_name">PrimeraAplicacion</string>
    <string name="app_nombre">SegundaActividad</string>
 </resources>
 ```
 Creada nuestra Segunda Activida debemos indicarlo en el ***AndroidManifest.xml***
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.bitzer.primeraaplicacion">

    <application
             ----------
            >
        -------------
        -------------
        <!--Añadimos lo siguiente -->
        <activity
            android:name=".SegundaActividad"
            android:label="@string/seg_actividad" >
        </activity>
    </application>

</manifest>
```
Creamos otro string en ***strings.xml***
```xml
<resources>
    <string name="app_name">PrimeraAplicacion</string>
    <string name="app_nombre">SegundaActividad</string>
    <string name="seg_actividad">Mi Segunda Actividad</string>
</resources>
```
