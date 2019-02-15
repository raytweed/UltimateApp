package application.android.example.com.ultimateapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdAdapter extends ArrayAdapter<ThirdReturn>{

    public ThirdAdapter(Activity context, ArrayList<ThirdReturn> listof) {
        super(context,0,listof);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listofcontacts=convertView;
        if(listofcontacts==null){
            listofcontacts= LayoutInflater.from(getContext()).inflate(R.layout.layout,parent,false);
        }
        ThirdReturn currentconttact=getItem(position);
        TextView listname=listofcontacts.findViewById(R.id.name);
        listname.setText(currentconttact.getXname());
        TextView listcontact=listofcontacts.findViewById(R.id.contact);
        listcontact.setText(currentconttact.getXcontact());
        final ImageView call=listofcontacts.findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Call Selected",Toast.LENGTH_SHORT).show();
            }
        });
        final ImageView whatsap=listofcontacts.findViewById(R.id.whatsap);
        whatsap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Whatsap Selected",Toast.LENGTH_SHORT).show();

            }
        });
        return  listofcontacts;
    }
}
