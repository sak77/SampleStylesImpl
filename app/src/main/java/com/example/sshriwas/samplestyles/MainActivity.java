package com.example.sshriwas.samplestyles;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    boolean orangeTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            setTheme(orangeTheme ? R.style.MyStyle1 : R.style.MyStyle2);
        }else {
            orangeTheme = savedInstanceState.getBoolean("THEME");
            setTheme(orangeTheme ? R.style.MyStyle1 : R.style.MyStyle2);
        }
        setContentView(R.layout.activity_main);
        ToggleButton toggleButton = findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if ( orangeTheme != b ) {
                    orangeTheme = b;
                    //Re launch the activity
                    recreate();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("THEME", orangeTheme);
        super.onSaveInstanceState(outState);
    }
}
