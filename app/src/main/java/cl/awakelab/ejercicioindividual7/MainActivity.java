package cl.awakelab.ejercicioindividual7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton switchNight = findViewById(R.id.switchNight);



        switchNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchNight.isChecked()) {
                    setDayNight(0);
                    Toast.makeText(getBaseContext(), "Enable Dark Mode", Toast.LENGTH_SHORT).show();
                } else {
                    setDayNight(1);
                    Toast.makeText(getBaseContext(), "Enable Light Mode", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public void setDayNight(int mode){
        if(mode==0){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout, "Actividad iniciada", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
    }

}