
package application.android.example.com.ultimateapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    DatabaseSet mydb;
    TextView forget,textView,textView2;
    Button login_button,button,setlogin;
    EditText login,password;
    Intent i,j;
    int co=0;
    ImageView back,cross,plus,Xplus;
    Bitmap res;
    String getlogin,getpass;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mydb=new DatabaseSet(this);
        forget=findViewById(R.id.forget);
        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);
        drawerLayout=findViewById(R.id.drawer);
        login_button=findViewById(R.id.login_btn);
        back=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        login=findViewById(R.id.login);
        textView2=findViewById(R.id.textView2);
        setlogin=findViewById(R.id.setlogin);
        cross=findViewById(R.id.cross);
        Xplus=findViewById(R.id.Xplus);
        cross.setVisibility(View.INVISIBLE);
        setlogin.setVisibility(View.INVISIBLE);
        forget.setVisibility(View.INVISIBLE);
        login.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        getlogin=login.getText().toString();
        res=BlurBuilder.blur(getApplicationContext(), BitmapFactory.decodeResource(getResources(),R.drawable.back));
        getpass=password.getText().toString();
        Xplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
                if(co==0){
                    Xplus.setVisibility(View.INVISIBLE);
                    co=1;
                }else if(co==1){
                    Xplus.setVisibility(View.VISIBLE);
                    co=0;
                }
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               back.setImageBitmap(res);
                forget.setVisibility(View.VISIBLE);
                login.setVisibility(View.VISIBLE);
                password.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                setlogin.setVisibility(View.VISIBLE);
                cross.setVisibility(View.VISIBLE);
                login_button.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);

                }
        });
        setlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checknull()==true){
                    getlogin=login.getText().toString();
                    getpass=password.getText().toString();
                    Global.session_id=getlogin;
                    boolean checklogin=mydb.checkidandpassword(getlogin,getpass);
                    if(checklogin==true){
                        j=new Intent(MainActivity.this,Third_Activty.class);
                        j.putExtra("id",getlogin);
                        startActivity(j);
                        onStop();
                    }else {
                        Toast.makeText(getApplicationContext(),"Invalid Login",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forget.setVisibility(View.INVISIBLE);
                login.setVisibility(View.INVISIBLE);
                password.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                setlogin.setVisibility(View.INVISIBLE);
                cross.setVisibility(View.INVISIBLE);
                login_button.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             i=new Intent(MainActivity.this,Second_Activity.class);
             startActivity(i);
             onStop();
            }
        });
      drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Xplus.setVisibility(View.INVISIBLE);
                if(drawerLayout.isDrawerVisible(GravityCompat.START)==true){
                    Toast.makeText(getApplicationContext(),"Open",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)==false){
                    Toast.makeText(getApplicationContext(),"Closed",Toast.LENGTH_SHORT).show();
                    Xplus.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

    }
    private boolean checknull(){
        getlogin=login.getText().toString();
        getpass=password.getText().toString();
        if(getpass.isEmpty()&&getlogin.isEmpty()){
            Toast.makeText(getApplicationContext(),"You had not entered anything",Toast.LENGTH_SHORT).show();
            return  false;
        }
        else if(getlogin.isEmpty()||getpass.isEmpty()){
            if(getlogin.isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter login",Toast.LENGTH_SHORT).show();
            }else if(getpass.isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_SHORT).show();
            }
            return false;
        }
        else
            return true;
    }


}
