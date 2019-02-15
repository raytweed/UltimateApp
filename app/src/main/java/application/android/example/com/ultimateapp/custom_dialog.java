package application.android.example.com.ultimateapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class custom_dialog extends Dialog implements View.OnClickListener{
    public Activity ctx;
    public EditText new_name,new_number,new_email;
    public Button ok_btn;
    DatabaseSet mydb;String name,number,email;
    public custom_dialog(Activity context) {
        super(context);
        this.ctx=context;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_box_layout);
        mydb=new DatabaseSet(getContext());
        new_name=findViewById(R.id.new_name);
        new_number=findViewById(R.id.new_number);
        new_email=findViewById(R.id.new_email);
        ok_btn=findViewById(R.id.new_contact);
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=new_name.getText().toString();
                number=new_number.getText().toString();
                email=new_email.getText().toString();
                if(name.isEmpty()||number.toString().isEmpty()||email.isEmpty()){
                    if(name.isEmpty()){
                        new_name.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                if(name.isEmpty()){
                                    new_name.setHintTextColor(Color.rgb(255,0,0));
                                    new_name.setHint("*this text field is empty");
                                }else {

                                }
                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                if(!name.isEmpty()){
                                    new_name.setHint("nice");
                                }
                            }
                        });
                        new_number.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                if(number.isEmpty()){
                                    new_number.setHintTextColor(Color.rgb(255,0,0));
                                    new_number.setHint("*this text field is empty");
                                }
                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                if(!number.isEmpty()){
                                    new_number.setHint("nice");
                                }
                            }
                        });
                        new_email.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                if(email.isEmpty()){
                                    new_email.setHintTextColor(Color.rgb(255,0,0));
                                    new_email.setHint("*this text field is empty");
                                }
                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                if(!email.isEmpty()){
                                    new_email.setHint("nice");
                                }
                            }
                        });
                    }
                }else {
                    long insert=mydb.insertcontact(Global.session_id,new_name.getText().toString(),new_number.getText().toString(),new_email.getText().toString());
                    if(insert==-1){
                        Toast.makeText(getContext(),"No contact added",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getContext(),"Contact Added",Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                }
            }
        });
    }
}
