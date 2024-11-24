package com.example.manybuttons;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class appbar extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appbar);
        toolbar=findViewById(R.id.mytoolbar);

        setSupportActionBar(toolbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if  (item.getItemId() == R.id.star){
            Toast.makeText(this, "Star selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if  (item.getItemId() == R.id.share){
            Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if  (item.getItemId() == R.id.setting){
            Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if  (item.getItemId() == R.id.search){
            Toast.makeText(this, "search selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if  (item.getItemId() == R.id.logout){
            Toast.makeText(this, "logout selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
