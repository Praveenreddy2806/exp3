package com.example.exp3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter {
    Activity context;
    ArrayList<String> categories;
    ArrayList<Integer> images;

    public CategoryAdapter(Activity context, ArrayList<String> categories, ArrayList<Integer> images){
        super(context, R.layout.cat, categories);

        this.context = context;
        this.categories = categories;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.cat, null, true);
        ImageView img = v.findViewById(R.id.catimg);
        img.setImageResource(images.get(position));
        return v;
    }
}
