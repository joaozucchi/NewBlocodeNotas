package com.joaoh.newBlocodenotas;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences.Editor editor = null;
    private SharedPreferences preferences;

    EditText nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota = findViewById(R.id.editText);

        preferences = getSharedPreferences("Notas", MODE_PRIVATE);
        editor = preferences.edit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nota", nota.getText().toString());
                editor.commit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        nota.setText(preferences.getString("nota",""));

    }
}