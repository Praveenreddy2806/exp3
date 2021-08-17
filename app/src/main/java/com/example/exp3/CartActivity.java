package com.example.exp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {


    TextView h1;
    ListView list;
    ArrayList<String> pname = new ArrayList<>();
    ArrayList<String> pspecs  = new ArrayList<>();
    ArrayList<Integer> pprice = new ArrayList<>();
    ArrayList<Integer> pimg = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();

    TextView tp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



        list = findViewById(R.id.list_cart);
        tp= findViewById(R.id.tp);

        Bundle intent = getIntent().getExtras();
        pname = intent.getStringArrayList("pname");
        pprice = intent.getIntegerArrayList("pprice");
        pspecs = intent.getStringArrayList("pspec");
        pimg = intent.getIntegerArrayList("pimage");
        quantity = intent.getStringArrayList("pquan");

        CartAdapter adapter = new CartAdapter(CartActivity.this, pname, pprice, pspecs, pimg, quantity);
        list.setAdapter(adapter);

        int p =0;
        for(int i=0; i<pprice.size(); i++){
            int price = pprice.get(i);
            int quan = Integer.parseInt(quantity.get(i));
            p = p+(price * quan);
        }

        tp.setText(": "+String.valueOf(p));

    }
}