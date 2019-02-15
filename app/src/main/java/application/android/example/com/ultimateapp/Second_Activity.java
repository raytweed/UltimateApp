package application.android.example.com.ultimateapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity  {
   EditText id,name,contact,email,password;
   DatabaseSet mydb;
   Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
        mydb=new DatabaseSet(this);
        id=findViewById(R.id.s_id);
        name=findViewById(R.id.s_name);
        contact=findViewById(R.id.s_contact);
        email=findViewById(R.id.s_email);
        password=findViewById(R.id.s_pass);
        submit=findViewById(R.id.submit);
        save_user();
    }
    public void save_user(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long res=mydb.insertData(id.getText().toString(),name.getText().toString(),contact.getText().toString(),email.getText().toString(),password.getText().toString());
                if(res==-1){
                    Toast.makeText(getApplicationContext(),"No Data Saved Please Try Again!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
