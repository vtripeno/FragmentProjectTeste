package com.treinamento.victortripeno.fragmentprojecttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class FragmentPropagandaActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_propaganda);
    }

    public void onClickTelaDois(View view) {
        Intent intent = new Intent(this, ActivityPropagandaDois.class);
        startActivity(intent);
    }
}
