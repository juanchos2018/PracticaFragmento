package com.example.practicafragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentPizzas extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<EntPizzas> listapizzas;
    RecyclerView recyclerView;
    ComunicaFragment comunicaFragment;
    Activity activity;

    public FragmentPizzas() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentPizzas newInstance(String param1, String param2) {
        FragmentPizzas fragment = new FragmentPizzas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_fragment_pizzas, container, false);
        listapizzas =new ArrayList<>();
        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LLienarlista();

        AdapterPizzas adapter =new AdapterPizzas(listapizzas);
        recyclerView.setAdapter(adapter);
    adapter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(), listapizzas.get(recyclerView.getChildAdapterPosition(view)).getNomnbre(), Toast.LENGTH_SHORT).show();
            comunicaFragment.enviarDatos(listapizzas.get(recyclerView.getChildAdapterPosition(view)));

        }
    });

        return vista;
    }

    private void LLienarlista() {

        listapizzas.add(new EntPizzas("piza peruana", R.drawable.piza1,"piza peruana  muuy rica y sabora",R.drawable.piza1detalle));
        listapizzas.add(new EntPizzas("piza Huawaiana", R.drawable.pizza2,"piza peruana  muuy rica y sabora de otro pais wey",R.drawable.pizza2detalle));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        if(context instanceof Activity){
            this.activity=(Activity) context;
            comunicaFragment=(ComunicaFragment) this.activity;

        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {

        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
