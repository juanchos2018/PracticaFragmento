package com.example.practicafragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPizzas extends RecyclerView.Adapter<AdapterPizzas.ViewHolderDatos> implements View.OnClickListener {
    ArrayList<EntPizzas> listapizzas;

    private View.OnClickListener listener;

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public AdapterPizzas(ArrayList<EntPizzas> listapizzas) {
        this.listapizzas = listapizzas;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,null,false);
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
    holder.nombrepizza.setText(listapizzas.get(position).getNomnbre());
    holder.foto.setImageResource(listapizzas.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listapizzas.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

    TextView nombrepizza;
    ImageView foto;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            nombrepizza=(TextView)itemView.findViewById(R.id.idnombrepizza);
            foto=(ImageView)itemView.findViewById(R.id.idImagen);

        }
    }
}
