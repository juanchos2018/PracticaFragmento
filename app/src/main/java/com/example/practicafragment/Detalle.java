package com.example.practicafragment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Detalle extends AppCompatActivity implements View.OnClickListener {


    TextView detalle;
    ImageView fotodetalle;
    Button btnplay;

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        detalle=(TextView)findViewById(R.id.iddescripcion1);
        fotodetalle=(ImageView)findViewById(R.id.idImagendetalle1);

        btnplay=(Button)findViewById(R.id.idbtnplay);
        video=(VideoView)findViewById(R.id.videview);
        String path ="android.resource://"+getPackageName()+"/"+R.raw.pizzah;

        video.setVideoURI(Uri.parse(path));

        Bundle bundle = this.getIntent().getExtras();
        if (bundle!=null){
            String me=bundle.getString("name");
            int fo = bundle.getInt("foto");

            detalle.setText(me);
            fotodetalle.setImageResource(fo);
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        btnplay.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.idbtnplay:
                video.start();
        }
    }
}
