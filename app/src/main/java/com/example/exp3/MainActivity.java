package com.example.exp3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    FloatingActionButton fb;

    ArrayList<String> categories = new ArrayList<>(Arrays.asList("Acer","Asus", "Dell", "Lenovo", "Hp", "Apple", "Microsoft", "Redmi"));
    ArrayList<Integer> images =new ArrayList<>(Arrays.asList(R.drawable.acer, R.drawable.asus, R.drawable.dell, R.drawable.lenovo, R.drawable.hp, R.drawable.apple, R.drawable.microsoft, R.drawable.redmi));

    ArrayList<String> acer =new ArrayList<>(Arrays.asList("Acer Aspire 7", "Acer Nitro 5", "Acer Prediator", "Acer Swift"));
    ArrayList<Integer> acerimg = new ArrayList<>(Arrays.asList(R.drawable.aceraspire, R.drawable.acernitro, R.drawable.acerprediator, R.drawable.acerswift));
    ArrayList<String> acerspecs = new ArrayList<>(Arrays.asList("Acer Aspire 7 Ryzen 5 Core (8 Gb/512 Gb Ssd/Windows 10 Home/4 Gb Graphics/Nvidia Geforce Gtx 1650 Gaming Laptop)",
            "Acer Nitro 5 Intel Core i5 9th Gen (8GB/1TB+256GB SSD/Windows 10 Home/4 Gb Graphics/Nvidia Geforce Gtx 1650 Gaming Laptop)",
            "Acer Predator Intel i5 10th Gen (8GB RAM/512GB SSD/Win10/GTX 1650Ti Graphics/19.9mm Thin/Abyssal Black)",
            "Acer Swift 5  Intel i7 - 11th Gen/16GB RAM/1TB SSD/Win10/Intel Iris Xe Graphics/1.05 Kg/Mist Green)"));
    ArrayList<Integer> acerprice =new ArrayList<>(Arrays.asList(56000, 69000, 90000, 95000));

    ArrayList<String> asus = new ArrayList<>(Arrays.asList("ASUS ROG", "ASUS TUF", "ASUS ZENBOOK PRO", "ASUS ChroeBook"));
    ArrayList<String> asusspecs = new ArrayList<>(Arrays.asList("ASUS ROG Strix G17 Intel Core i7-10750H 10th Gen, GTX 1660Ti 6GB Graphics (16GB RAM/512GB NVMe SSD/Windows 10/Original Black/2.83 Kg)",
            "ASUS TUF Gaming F1 Intel Core i5-10300H 10th Gen, NVIDIA GeForce GTX 1650 4GB Graphics, Gaming Laptop(8GB/512GB SSDWindows 10/Gray/2.3 Kg)",
            "ASUS ZenBook 14 Intel Core i5-1135G7 11th Gen 14-inch (8GB RAM/512GB NVMe SSD/Windows 10/MS Office 2019/Intel Iris Xᵉ Graphics/Pine Grey/1.17 kg)",
            "ASUS Chromebook Dual Core - (4 GB/64 GB EMMC Storage/Chrome OS) C214MA-BU0452 2 in 1 Laptop  (11.6 inch, Dark Grey, 1.20 Kg)"));
    ArrayList<Integer> asusprice = new ArrayList<>(Arrays.asList(90000, 60000, 72000, 25000));
    ArrayList<Integer> asusimg = new ArrayList<>(Arrays.asList(R.drawable.rog, R.drawable.tuf, R.drawable.zenbookpro, R.drawable.chromebook));

    ArrayList<String> apple = new ArrayList<>(Arrays.asList("MacBook Air", "MacBook Pro", "MacMini", "iMAC"));
    ArrayList<String> applespecs = new ArrayList<>(Arrays.asList("Apple MacBook Air (13-inch, 8GB RAM, 128GB Storage, 1.8GHz Intel Core i5) - Silver",
            "2019 Apple MacBook Pro (16-inch/40.65 cm, 16GB RAM, 512GB Storage, 2.6GHz 9th Gen Intel Core i7) - Space Grey",
            "New Apple Mac Mini with Apple M1 Chip (8GB RAM, 512GB SSD)",
            "2021 Apple iMac with 4.5K Retina Display (24-inch/60.96 cm, Apple M1 chip with 8‑core CPU and 7‑core GPU, 8GB RAM, 256GB) - Silver"));
    ArrayList<Integer> appleprice = new ArrayList<>(Arrays.asList(88000, 180000, 80000, 120000));
    ArrayList<Integer> appleimg = new ArrayList<>(Arrays.asList(R.drawable.macbookair, R.drawable.macbookpro, R.drawable.macmini, R.drawable.imac));

    ArrayList<String> dell = new ArrayList<>(Arrays.asList("DELL AlienWare", "Dell Inspiron", "DELL Vostro", "DELL XPS"));
    ArrayList<String> dellspecs = new ArrayList<>(Arrays.asList("DDell Alienware (10th Gen Core i7-10750H/16GB/512GB SSD/Windows 10 Home & MS Office/6GB NVIDIA GTX 1660 Ti Graphics))",
            "Dell Inspiron (Lucienne Ryzen 5 5500U / 8GB / 512GB SSD / AMD Lucienne Graphic / Win 10 + MS Office / Backlit KB + FPR / Silver)",
            "Dell Vostro 3400 14\" FHD Display Laptop (i5-1135G7 / 8GB / 512GB SSD / Integrated Graphics / Win10 + MSO / Black)",
            "Dell XPS (10th Gen Core i7-10510U/16GB/512GB SSD/Win 10 + MS Office/Integrated Graphics), Silver"));
    ArrayList<Integer> dellprice =new ArrayList<>(Arrays.asList(120000, 58000, 55000, 170000));
    ArrayList<Integer> dellimg =new ArrayList<>(Arrays.asList(R.drawable.dellalienware, R.drawable.dellinspiron, R.drawable.dellvostro, R.drawable.dellxps));

    ArrayList<String>  hp = new ArrayList<>(Arrays.asList("Hp Pavilion", "Hp Omen", "Hp ProBook", "Hp ChromeBook"));
    ArrayList<String> hpspecs =new ArrayList<>(Arrays.asList("HP Pavilion (Ryzen 5-4600H/8GB/1TB HDD/M.2 Slot/Windows 10/NVIDIA GTX 1650 4GB/Shadow Black)",
            "HP OMEN 15.6-inch (39.62 cms) FHD Gaming Laptop (Ryzen 5-4600H/8GB/512GB SSD/Windows 10/NVIDIA GTX 1660ti 6GB/Shadow Black/2.36 kg)",
            "HP G4 Core i7 7th Gen - (16 GB/1 TB SSD/8 GB EMMC Storage/Windows 10 Pro, Silver, With MS Office)",
            "HP Chromebook  (Intel N4020/4GB/64GB SSD + 256GB Expandable/Chrome OS/1.46 kgs Light)"));
    ArrayList<Integer> hpprice =new ArrayList<>(Arrays.asList(56000, 83000, 120000, 27000));
    ArrayList<Integer> hpimgs = new ArrayList<>(Arrays.asList(R.drawable.hppavilion, R.drawable.hpomen, R.drawable.hpprobook, R.drawable.hpchromebook));

    ArrayList<String> lenovo = new ArrayList<>(Arrays.asList("Lenovo Legion", "Lenovo IdeaPad", "Lenovo ThinkPad", "Lenovo Yoga"));
    ArrayList<String> lenovospecs =new ArrayList<>(Arrays.asList("Lenovo Legion 5 10th Gen (8GB/512GB SSD/Windows 10/NVIDIA GTX 1650 4GB/120Hz Refresh Display/Phantom Black/2.3Kg)",
            "Lenovo IdeaPad 11th Gen Intel Core i5 (8GB/256GB SSD/Windows 10/MS Office/Backlit Keyboard/2 Year Warranty/Arctic Grey/1.65Kg)",
            "Lenovo ThinkPad X1 Carbon 7th Gen, 8GB RAM, 256GB Nvme SSD, Win 10 Pro, I5-8265U, Black",
            "Lenovo Yoga Slim 7 11th gen Intel Core i7 (16GB/1TB SSD/Win10/Office/Intel Iris Graphics/Fingerprint Reader/Slate Grey/1.33Kg)"));
    ArrayList<Integer> lenovoprice =new ArrayList<>(Arrays.asList(65000, 56000, 120000, 80000));
    ArrayList<Integer> lenovoimgs = new ArrayList<>(Arrays.asList(R.drawable.lenovolegion, R.drawable.lenovoideapad, R.drawable.lenovothinkpad, R.drawable.lenovoyoga));

    ArrayList<String> microsoft = new ArrayList<>(Arrays.asList("Surface Go", "Suface 3", "Surface 7", "Surface X"));
    ArrayList<String> microsoftspecs =new ArrayList<>(Arrays.asList("Microsoft Surface GO (Gold Processor 4425Y/8GB/128GB SSD/Windows 10 Home in S Mode/Intel UHD 615 Graphics)",
            "Microsoft Surface 3 Intel Core i5 10th Gen (8GB/128GB SSD/Windows 10 Home/Integrated Graphics/Platinum/1.265kg)",
            "Microsoft Surface 7 (10th Gen Intel Core i5/8GB/128GB SSD/Windows 10 Home/Intel Iris Plus Graphics)",
            "Microsoft Surface X (Microsoft SQ1/8GB/128GB SSD/Windows 10 Home/Microsoft SQ1 Adreno 685 GPU Graphics)"));
    ArrayList<Integer> microsoftprice =new ArrayList<>(Arrays.asList(55000, 80000, 89000, 91000));
    ArrayList<Integer> microsoftimgs = new ArrayList<>(Arrays.asList(R.drawable.surfacego, R.drawable.surfacebook3, R.drawable.surface7, R.drawable.surfacex));

    ArrayList<String> redmi = new ArrayList<>(Arrays.asList("Mi NoteBook 14", "Mi NoteBook 15"));
    ArrayList<String> redmispecs =new ArrayList<>(Arrays.asList("Mi Notebook Horizon Edition 14 Intel Core i5-10210U 10th Gen (8GB/512GB SSD/Windows 10/Nvidia MX350 2GB Graphics/Grey/1.35Kg)",
            "RedmiBook 15 e-Learning Edition i3 11th Gen + UHD Graphics 8GB RAM + 256GB SSD Charcoal"));
    ArrayList<Integer> redmiprice =new ArrayList<>(Arrays.asList(54000, 41999));
    ArrayList<Integer> redmiimgs =new ArrayList<>(Arrays.asList(R.drawable.minotebook14, R.drawable.minotebook15));


    ArrayList<String> prodname = new ArrayList<String>();
    ArrayList<String> prodspec = new ArrayList<String>();
    ArrayList<Integer> prodprice = new ArrayList<Integer>();
    ArrayList<Integer> prodimage = new ArrayList<Integer>();

    ArrayList<String> cprodname = new ArrayList<String>();
    ArrayList<String> cprodspec = new ArrayList<String>();
    ArrayList<Integer> cprodprice = new ArrayList<Integer>();
    ArrayList<Integer> cprodimage = new ArrayList<Integer>();
    ArrayList<String> cquantity = new ArrayList<String>();

    ListView list;
    int  status=0;


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        grid = findViewById(R.id.prodlist);
        fb = findViewById(R.id.floatbtn);
        list = findViewById(R.id.catlist);

        CategoryAdapter adapter = new CategoryAdapter(this, categories, images);
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getprod(position);
                if (status==1){
                    prodAdapter adapter1 = new prodAdapter(MainActivity.this, prodname, prodimage);
                    grid.setAdapter(adapter1);
                }
                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setMessage("Add to cart ");
                        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                                View view1 = inflater.inflate(R.layout.alert, null, true);
                                ImageView imageView = view1.findViewById(R.id.a_img);
                                TextView desc = view1.findViewById(R.id.a_desc);
                                TextView price = view1.findViewById(R.id.a_price);
                                EditText Q = view1.findViewById(R.id.a_quan);

                                imageView.setImageResource(prodimage.get(position1));
                                desc.setText(prodname.get(position1)+ "\n" +prodspec.get(position1));
                                price.setText("Rs : "+String.valueOf(prodprice.get(position1)));



                                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        cprodname.add(prodname.get(position1));
                                        cprodspec.add(prodspec.get(position1));
                                        cprodprice.add(prodprice.get(position1));
                                        cprodimage.add(prodimage.get(position1));
                                        cquantity.add(Q.getText().toString());
                                    }
                                });

                                AlertDialog d = builder.create();
                                d.setView(view1);
                                d.setCancelable(false);
                                d.show();

                            }
                        });
                        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        AlertDialog alertDialog = alert.create();
                        alertDialog.setCancelable(false);
                        alertDialog.show();
                    }
                });

            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                intent.putExtra("pname", cprodname);
                intent.putExtra("pspec", cprodspec);
                intent.putExtra("pprice", cprodprice);
                intent.putExtra("pimage", cprodimage);
                intent.putExtra("pquan", cquantity);
                startActivity(intent);
            }
        });

        



    }
//
    private void getprod(int position) {
        prodprice.clear(); prodname.clear(); prodprice.clear(); prodimage.clear();
        String name = categories.get(position);
        status = 0;
        if (name.equals("Acer")){
           prodname.addAll(acer);
           prodprice.addAll(acerprice);
           prodspec.addAll(acerspecs);
           prodimage.addAll(acerimg);
           status=1;
        }else if (name.equals("Asus")){
            prodname.addAll(asus);
            prodprice.addAll(asusprice);
            prodspec.addAll(asusspecs);
            prodimage.addAll(asusimg);
            status=1;
        }else  if (name.equals("Dell")){
            prodname.addAll(dell);
            prodprice.addAll(dellprice);
            prodspec.addAll(dellspecs);
            prodimage.addAll(dellimg);
            status=1;
        }else if (name.equals("Apple")){
            prodname.addAll(apple);
            prodprice.addAll(appleprice);
            prodspec.addAll(applespecs);
            prodimage.addAll(appleimg);
            status=1;
        }else if (name.equals("Lenovo")){
            prodname.addAll(lenovo);
            prodprice.addAll(lenovoprice);
            prodspec.addAll(lenovospecs);
            prodimage.addAll(lenovoimgs);
            status=1;
        }else if (name.equals("Hp")){
            prodname.addAll(hp);
            prodprice.addAll(hpprice);
            prodspec.addAll(hpspecs);
            prodimage.addAll(hpimgs);
            status=1;
        }else if (name.equals("Microsoft")){
            prodname.addAll(microsoft);
            prodprice.addAll(microsoftprice);
            prodspec.addAll(microsoftspecs);
            prodimage.addAll(microsoftimgs);
            status=1;
        }else if (name.equals("Redmi")){
            prodname.addAll(redmi);
            prodprice.addAll(redmiprice);
            prodspec.addAll(redmispecs);
            prodimage.addAll(redmiimgs);
            status=1;
        }

    }
}