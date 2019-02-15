package application.android.example.com.ultimateapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Third_Activty extends AppCompatActivity {
    DatabaseSet mydb;
    Cursor cur;
    ImageView add_contact;
    Intent id,add_new;
    ListView listView;
    ThirdAdapter adapter;
    ArrayList<ThirdReturn> listof;
    String receivedid;
    custom_dialog custom_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().hide();
        mydb=new DatabaseSet(this);
        custom_dialog=new custom_dialog(Third_Activty.this);
        custom_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        display();
        custom_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                display();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fir=adapter.getItem(position).getXcontact().toString();
                String sec=adapter.getItem(position).getXname().toString();
                String thi=adapter.getItem(position).getXemail().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(Third_Activty.this);
                builder.setMessage("Name="+fir+"\n"+"Contact="+sec+"\n"+"Email="+thi).setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alter=builder.create();
                alter.setTitle("Your Details! ");
                alter.show();
            }
        });
        add_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               custom_dialog.show();
            }
        });

    }
public void display(){
    id=getIntent();
    receivedid=id.getStringExtra("id");
    add_contact=findViewById(R.id.ok_add_contact);
    listof=new ArrayList<>();
    cur=mydb.showcontact(receivedid);
    cur.moveToFirst();
    if(cur.moveToFirst()){
        do{
            listof.add(new ThirdReturn(cur.getString(1),cur.getString(2),cur.getString(3)));
        }while (cur.moveToNext());
    }
    adapter=new ThirdAdapter(this,listof);
    listView=findViewById(R.id.listofcontact);
    listView.setAdapter(adapter);
}
    @Override
    protected void onResume() {
        super.onResume();
        display();
    }
}