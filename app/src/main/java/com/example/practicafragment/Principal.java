package com.example.practicafragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Principal extends AppCompatActivity  implements FragmentPizzas.OnFragmentInteractionListener,FragmentDetalle.OnFragmentInteractionListener,ComunicaFragment{


    FragmentPizzas fragmentActivity ;
    FragmentDetalle fragmentoDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        fragmentActivity = new FragmentPizzas();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentActivity).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarDatos(EntPizzas pizzas) {

       /* fragmentoDetalle = new FragmentDetalle();
        Bundle bundelenvio =new Bundle();
        bundelenvio.putSerializable("objeto",pizzas);
        fragmentoDetalle.setArguments(bundelenvio);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentoDetalle).commit();
*/
        String detalle;
        int fotodetalle;
        detalle=pizzas.getDetalle();
        fotodetalle=pizzas.getFotodetalle();

        Intent intent = new Intent(Principal.this,Detalle.class);
        Bundle bundle = new Bundle();
        bundle.putString("name",detalle);
        bundle.putInt("foto",fotodetalle);

        intent.putExtras(bundle);
        startActivity(intent);



    }
}
