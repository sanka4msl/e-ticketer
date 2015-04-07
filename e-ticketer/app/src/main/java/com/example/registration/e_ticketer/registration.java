package com.example.registration.e_ticketer;


import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class registration extends ActionBarActivity {

    EditText USER_NAME,USER_PASS,CON_PASS;
    String user_name ,user_pass ,con_pass;
    Button REG;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        USER_NAME = (EditText)findViewById(R.id.reg_user);
        USER_PASS = (EditText)findViewById(R.id.reg_pass);
        CON_PASS = (EditText)findViewById(R.id.con_pass);

        REG = (Button)findViewById(R.id.registration_button);
        REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = USER_NAME.getText().toString();
                user_pass = USER_PASS.getText().toString();
                con_pass = CON_PASS.getText().toString();

                if(!(user_pass.equals(con_pass))){
                    Toast.makeText(getBaseContext(),"Password are matching",Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CON_PASS.setText("");

                }else{
                    DatabaseOperations DB =  new DatabaseOperations(ctx);
                    DB.putInformation(DB,user_name,user_pass);
                    Toast.makeText(getBaseContext(),"Registration successed" ,Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
