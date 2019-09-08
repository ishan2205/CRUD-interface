package com.anuj.crud_interface;

import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ScriptEditor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.script_editor);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff242431));
        actionBar.setTitle("Console");

        EditText editText=findViewById(R.id.editText);
        /*editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                Toast.makeText(getApplicationContext(),"Here",Toast.LENGTH_SHORT).show();
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(getApplicationContext(),"Enter",Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

         */
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
        builder.setTitle("Are you sure you want to Log Out?");
        builder.setMessage("Test");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", (dialog, which) -> {
            //TODO:Link Page for Logout
            finish();
        });

        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

}