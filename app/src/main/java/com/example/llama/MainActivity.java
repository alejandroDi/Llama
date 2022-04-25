package com.example.llama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContactos;
    ArrayList<Conctacto> conctactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContactos = (ListView) findViewById(R.id.lvContactos);
        conctactos = new ArrayList<>();
        conctactos.add(new Conctacto("Enrique","Alcala","3317595411","hules "));
        conctactos.add(new Conctacto("Alexis","Cruz","3320669274","jalisco "));
        conctactos.add(new Conctacto("Alejandro","Tovar","3312646491","gunajuato"));
        conctactos.add(new Conctacto("Jenni","Hernandez","331759548","Monterrey "));
        conctactos.add(new Conctacto("Ines","Mendez","331759544","Corazon "));

        ArrayList<String> nombreContactos = new ArrayList<>();

        for (Conctacto contacto:conctactos) {
            nombreContactos.add(contacto.getNombre()+" "+contacto.getApellido());

        }
        lvContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombreContactos));
        lvContactos.setOnItemClickListener(new  AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Intent intent =new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra("NAMECONTACTO",conctactos.get(posicion).getNombre());
                intent.putExtra("APELLIDOCONTACTO",conctactos.get(posicion).getApellido());
                intent.putExtra("TELEFONOCONTACTO",conctactos.get(posicion).getTelefono());
                intent.putExtra("DIRECCIONCONTACTO",conctactos.get(posicion).getDireccion());
                startActivity(intent);
            }
        });


    }
}