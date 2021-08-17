package com.example.exp3;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class prodAdapter extends ArrayAdapter {

    Activity context;
    ArrayList<String> p_name;
    ArrayList<String> p_specs;
    ArrayList<Integer> p_price;
    ArrayList<Integer> p_images;
    public prodAdapter(Activity context, ArrayList<String> p_name, ArrayList<Integer> p_images){
        super(context, R.layout.prod, p_name);
        this.context = context;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_specs = p_specs;
        this.p_images = p_images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v1 = inflater.inflate(R.layout.prod, null, true);

        ImageView imageView = v1.findViewById(R.id.prodimage);
        TextView lapname = v1.findViewById(R.id.prodname);

        imageView.setImageResource(p_images.get(position));
        lapname.setText(p_name.get(position));

        return v1;

    }
}
