package com.anuj.crud_interface;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        /*ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(0xFF2554F9));
        actionBar.setTitle("MongoDB Login");

         */

        Button button=findViewById(R.id.login_button);
        button.setOnClickListener(view -> {
            //TODO:Send Login Info and get Acknowledgement if Success then proceed
            Intent intent=new Intent(getApplicationContext(),ScriptEditor.class);
            startActivity(intent);
        });


    }

}

/*
uri (mongodb+://[username]:[password]@[host name]:[port]/[database name]

query: String
skip: Integer
limit: Integer
order: asc/desc or boolean
collection Name: people/person
 */
