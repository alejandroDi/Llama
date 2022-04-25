package com.example.llama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNombre,tvTelefono,tvApellido,tvDireccion;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("NAMECONTACTO");
        String apellido = bundle.getString("APELLIDOCONTACTO");
        String telefono = bundle.getString("TELEFONOCONTACTO");
        String direccion = bundle.getString("DIRECCIONCONTACTO");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvApellido = (TextView) findViewById(R.id.tvApellido);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvDireccion = (TextView) findViewById(R.id.tvDireccion);
        relativeLayout = (RelativeLayout) findViewById(R.id.rlCall);

        tvNombre.setText(nombre);
        tvApellido.setText(apellido);
        tvTelefono.setText(""+telefono);
        tvDireccion.setText(direccion);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+telefono));
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    // TODO: Consider calling
                    // ActivityCompart#requestPerissions
                    //  here to request the missing permissions, and then overriding
                    //    public  void onRequestPermissionsResult (int requestCode, String[] permissions,
                    //                                             int[] grantResults)
                    //to handle the case where user granted permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(DetalleContacto.this,"Falta activar el permiso de llamadas", Toast.LENGTH_SHORT);
                    //Toast.makeText(DetalleContacto.this, "Falta activar el permiso de llamda", (Toast.LENGTH_SHORT));
                    return;

                }

                startActivity(intent);
            }
        });

    }
}