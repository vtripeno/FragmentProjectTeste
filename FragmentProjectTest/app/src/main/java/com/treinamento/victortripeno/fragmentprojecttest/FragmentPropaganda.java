package com.treinamento.victortripeno.fragmentprojecttest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by victor.tripeno on 13/02/2017.
 */
public class FragmentPropaganda extends Fragment {

    private int contador;
    private static final String URL = "http://google.com/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_fragment, container);

        contador = 0;
        Button buttonCliqueAqui = (Button) view.findViewById(R.id.button_clique_aqui);

        // Handler usado para multithread, fazendo a mensagem mudar a cada 60 segundos
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                mudarString(view, retornoStringsValue());
                handler.postDelayed(this, 1*5*1000);
                contador++;
            }
        };

        handler.postDelayed(r, 1*5*1000);


        buttonCliqueAqui.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                irParaSite();
            }
        });

        return view;
    }

    private void irParaSite() {
        Uri uriVideo = Uri.parse(URL);
        Intent intent = new Intent(Intent.ACTION_VIEW, uriVideo);
        startActivity(intent);
    }

    private void mudarString(View view, String name) {

        final TextView propaganda = (TextView) view.findViewById(R.id.propaganda);
        propaganda.setText(name);
    }

    public String retornoStringsValue() {
        Field[] listaStrings = R.string.class.getDeclaredFields();

        String name = "";

        if(listaStrings.length == contador) {
            contador = 0;
        }

        for(int i = 0; i < listaStrings.length; i++) {
            int id = getResources().getIdentifier(listaStrings[contador].getName(), "string", getContext().getPackageName());
            if (id != 0) {
                name = getResources().getString(id);
                Log.d("Values ", name);
                contador++;
                break;
            } else {
                contador++;
            }

        }
        return name;
    }

}