package com.example.manybuttons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openappbar(View view) {
        startActivity(new Intent(this,appbar.class));
    }

    public void opencontextualmenu(View view) {
        startActivity(new Intent(this,contextualmenu.class));
    }

    public void openpopup(View view) {

        startActivity(new Intent(this, PopupActivity.class));
    }

    public void opendialogs(View view) {

        startActivity(new Intent(this, dialogs.class));
    }

    public void openpickers(View view) {
        startActivity(new Intent(this, pickers.class));
    }
}