package com.charles.charlestube;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;

import com.charles.charlestube.R;
import com.charles.charlestube.Search_Fragment;


public class MainActivity extends FragmentActivity {
    private Button searchButton;
    public boolean videoplaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        showsearch();
    }


    private void showsearch() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Search_Fragment search_fragment = new Search_Fragment();
        fragmentTransaction.replace( R.id.contentFrame, search_fragment ).addToBackStack( "search" );
        fragmentTransaction.commit();
    }
}