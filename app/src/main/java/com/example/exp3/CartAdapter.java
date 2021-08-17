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

public class CartAdapter extends ArrayAdapter {
    Activity context;
    ArrayList<String> pname;
    ArrayList<Integer> pprice;
    ArrayList<String> pspecs;
    ArrayList<Integer> pimg;
    ArrayList<String> quantity;

    public CartAdapter(Activity context, ArrayList<String> pname, ArrayList<Integer> pprice, ArrayList<String> pspecs, ArrayList<Integer> pimg, ArrayList<String> quantity) {
        super(context, R.layout.cart, pname);
        this.context = context;
        this.pname = pname;
        this.pprice = pprice;
        this.pspecs = pspecs;
        this.pimg = pimg;
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view1 = inflater.inflate(R.layout.cart, null, true);
        ImageView cimg = view1.findViewById(R.id.a_img);
        TextView cname = view1.findViewById(R.id.a_name);
        TextView cquan = view1.findViewById(R.id.a_quan);
        TextView cprice = view1.findViewById(R.id.a_price);
        TextView cdesc = view1.findViewById(R.id.a_desc);

        cimg.setImageResource(pimg.get(position));
        cname.setText(pname.get(position));
        cdesc.setText(pspecs.get(position));
        cquan.setText(": "+quantity.get(position));
        cprice.setText(": "+String.valueOf(pprice.get(position)));

        return view1;
    }
}
