package com.anuj.crud_interface;

import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ScriptEditor extends AppCompatActivity {

    FloatingActionButton fab,fab1,fab2,fab3;
    boolean isFABOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.script_editor);

        fab= findViewById(R.id.fab);
        fab1= findViewById(R.id.fab1);
        fab2= findViewById(R.id.fab2);
        fab3= findViewById(R.id.fab3);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff242431));
        actionBar.setTitle("Console");

        EditText editText=findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0)
                    if (charSequence.charAt(charSequence.length() - 1) == '\n') {
                        Toast.makeText(getApplicationContext(), "HI", Toast.LENGTH_SHORT).show();
                        //TODO:Send data to backend
                    }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fab.setOnClickListener(view -> {
            if(!isFABOpen){
                showFABMenu();
            }
            else{
                closeFABMenu();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.script_editor, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.submit) {
            //TODO:Link API Here, send instruction to API and get the data along with acknowledgement
            Toast.makeText(getApplicationContext(),"RUN",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ScriptEditor.this);
        builder.setTitle("ALERT!!");
        builder.setMessage("The database connection will be terminated if you continue.");
        builder.setCancelable(true);

        builder.setPositiveButton("Continue", (dialog, which) -> {
            //TODO:Link Page for Logout
            finish();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

    private void showFABMenu(){
        isFABOpen=true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
    }
}