    package com.example.manybuttons;

    import android.os.Bundle;
    import android.view.ActionMode;
    import android.view.ContextMenu;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import androidx.activity.EdgeToEdge;
    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class contextualmenu extends AppCompatActivity {

        private Button actionbtn;
        private Button floatbtn;
        ActionMode mode = null;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_contextualmenu);

            actionbtn = findViewById(R.id.buttonaction);
            actionbtn.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mode==null){

                        mode = startActionMode(callback);
                        return true;
                    }

                    return false;
                }
            });
            floatbtn = findViewById(R.id.buttonfloat);
            registerForContextMenu(floatbtn);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater menuInflater = new MenuInflater(this);
            menuInflater.inflate(R.menu.floatmenu, menu);
        }

        @Override
        public boolean onContextItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.num1) {
                Toast.makeText(this, "Selected num1", Toast.LENGTH_SHORT).show();
            } else if(item.getItemId() == R.id.num2){
                Toast.makeText(this, "Selected num2", Toast.LENGTH_SHORT).show();
            } else if(item.getItemId() == R.id.num3){
                Toast.makeText(this, "Selected num3", Toast.LENGTH_SHORT).show();
            } else if(item.getItemId() == R.id.num4){
                Toast.makeText(this, "Selected num4", Toast.LENGTH_SHORT).show();
            }
            return super.onContextItemSelected(item);
        }

        private ActionMode.Callback callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.contextmenu, menu);
                setTitle("Action Mode");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.contextshare) {
                    Toast.makeText(contextualmenu.this, "Selected Share", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.contextheart){
                    Toast.makeText(contextualmenu.this, "Liked", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.contextreport){
                    Toast.makeText(contextualmenu.this, "reported", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                mode = null;
            }
        };
    }