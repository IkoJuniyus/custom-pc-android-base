package com.example.usjul.mypc;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetSpanner;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class add extends AppCompatActivity {

    String brandpss[] = {"INTEL", "AMD"};
    String intel[] = {"i3-7350K", "i5-8400", "i7-8086K", "i9-9900K"};
    String amd[] = {"AMD-Kaveri", "AMD-Godavari", "AMD-Carrizo", "AMD-Vishera"};
    String matherboard[] = {"AsRock X299", "AsRock Fatal1ty", "Asus Rog Strix", "MSI X299"};
    String ssd[] = {"LaCie 500GB", "ASGARD 256GB", "GALAXY 120GB", "ADATA SX6000", "AFOX 120GB"};
    String hdd[] = {"Seagate Baracuda", "Toshiba", "WDC", "Hitachi", "Kingston", "Consair"};
    String ram[] = {"ASGARD 8GB 2Chanel", "ADATA 8GB 2Chanel", "Hitachi 8GB 2Chanel", "Kingston 8GB 2Chanel", "Consair 8GB 2Chanel"};
    String vga[] = {"Galax Geforce 8GB", "AsRock Radeon 8GB", "Gigabyte GeforceRTX 8GB", "Leadtex Qudron 8GB", "MSI Geforce 8GB", "Zotac Geforcw 8GB"};
    String psu[] = {"Power Logig Magnum", "Caugar Gaming", "NZXT"};
    String cpucooler[] = {"Antex Mercury", "Cyroric", "DeepCool"};
    DBHandler mydb;
    String pc_name,pc_brand,pc_prosessor,pc_motherboard,pc_ssd,pc_hdd,pc_ram,pc_vga,pc_psu,pc_cooler,currentdate,pcharga_ps,pcharga_mt,pcharga_ssd,pcharga_hdd,pcharga_ram,pcharga_vga,pcharga_psu,pcharga_cool,pcharga_total,pcrating_pc;
    EditText NamaPC1,hargatotaladd29;
    Spinner BrandProcessor2, Processor3, MotherBoard4, SSD5, HDD6, RAM7, VGA8, PSU9, Cooler10;
    FloatingActionButton buttoncreate;
    Calendar calendar;
    EditText hargaprosessor,hargaps21,hargamoth22,hargassd23,hargahdd24,hargaram25,hargavga26,hargapsu27,hargacool28;
    double ratingset,ratingser1;
    RatingBar RatingPC;
    Button cekharga;
    String c1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mydb = new DBHandler(this);
        NamaPC1 = (EditText) findViewById(R.id.namapc);
        BrandProcessor2 = (Spinner) findViewById(R.id.bps);
        Processor3 = (Spinner) findViewById(R.id.ps);
        MotherBoard4 = (Spinner) findViewById(R.id.mbs);
        SSD5 = (Spinner) findViewById(R.id.ssds);
        HDD6 = (Spinner) findViewById(R.id.hdds);
        RAM7 = (Spinner) findViewById(R.id.rams);
        VGA8 = (Spinner) findViewById(R.id.vgas);
        PSU9 = (Spinner) findViewById(R.id.pcus);
        Cooler10 = (Spinner) findViewById(R.id.coolers);
        buttoncreate = (FloatingActionButton) findViewById(R.id.btncreate);
        hargaps21 = (EditText)findViewById(R.id.hargaprosessoradd);
        hargamoth22 = (EditText)findViewById(R.id.hargamotherboardadd);
        hargassd23 = (EditText)findViewById(R.id.hargassdadd);
        hargahdd24 = (EditText)findViewById(R.id.hargahddadd);
        hargaram25 = (EditText)findViewById(R.id.hargaramadd);
        hargavga26 = (EditText)findViewById(R.id.hargavgaadd);
        hargapsu27 = (EditText)findViewById(R.id.hargapsuadd);
        hargacool28 = (EditText)findViewById(R.id.hargacooladd);
        hargatotaladd29 = (EditText)findViewById(R.id.hargatotaladd);
        RatingPC = (RatingBar)findViewById(R.id.ratingpc);
        cekharga = (Button)findViewById(R.id.butoncek);
        calendar = Calendar.getInstance();
        currentdate = DateFormat.getDateInstance().format(calendar.getTime());
        hargatotaladd29.setEnabled(false);
        hargaps21.setEnabled(false);
        hargamoth22.setEnabled(false);
        hargassd23.setEnabled(false);
        hargahdd24.setEnabled(false);
        hargaram25.setEnabled(false);
        hargavga26.setEnabled(false);
        hargapsu27.setEnabled(false);
        hargacool28.setEnabled(false);
        buttoncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settotal();
                dialogsimpan();
            }
        });
        cekharga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settotal();
            }
        });
        setbrand();
        setmotheboard();
        setssd();
        sethdd();
        setram();
        setvga();
        setpsu();
        setcool();

    }

    public void dialogsimpan(){
        AlertDialog.Builder simpan = new AlertDialog.Builder(add.this);
        simpan.setTitle("Simpan Data");
        simpan.setMessage("Apa anda yakin ingin menyimpan?");
        simpan.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CreateData();
            }
        });
        simpan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        simpan.show();
    }

    public void CreateData(){
        calendar = Calendar.getInstance();
        pc_name = NamaPC1.getText().toString();
        pc_brand = BrandProcessor2.getSelectedItem().toString();
        pc_prosessor = Processor3.getSelectedItem().toString();
        pc_motherboard = MotherBoard4.getSelectedItem().toString();
        pc_ssd = SSD5.getSelectedItem().toString();
        pc_hdd = HDD6.getSelectedItem().toString();
        pc_ram = RAM7.getSelectedItem().toString();
        pc_vga = VGA8.getSelectedItem().toString();
        pc_psu = PSU9.getSelectedItem().toString();
        pc_cooler = Cooler10.getSelectedItem().toString();
        currentdate = DateFormat.getDateInstance().format(calendar.getTime());
        pcharga_ps = hargaps21.getText().toString();
        pcharga_mt = hargamoth22.getText().toString();
        pcharga_ssd = hargassd23.getText().toString();
        pcharga_hdd = hargahdd24.getText().toString();
        pcharga_ram = hargaram25.getText().toString();
        pcharga_vga = hargavga26.getText().toString();
        pcharga_psu = hargapsu27.getText().toString();
        pcharga_cool = hargacool28.getText().toString();
        pcharga_total = hargatotaladd29.getText().toString();
        pcrating_pc = String.valueOf(RatingPC.getRating());
            if (pc_name.equals("")){
                Toast.makeText(add.this,"Tolong isi kolom Nama",Toast.LENGTH_SHORT).show();
            }else {
                try {
                    mydb.insertData(pc_name.trim(),pc_brand.trim(),pc_prosessor.trim(),pc_motherboard.trim()
                            ,pc_ssd.trim(),pc_hdd.trim(),pc_ram.trim(),pc_vga.trim(),pc_psu.trim(),pc_cooler.trim()
                            ,currentdate.trim(),pcharga_ps.trim(),pcharga_mt.trim(),pcharga_ssd.trim(),pcharga_hdd.trim()
                            ,pcharga_ram.trim(),pcharga_vga.trim(),pcharga_psu.trim(),pcharga_cool.trim(),pcharga_total.trim()
                            ,pcrating_pc.trim());
                    Intent backlistadd = new Intent(add.this,MainActivity.class);
                    startActivity(backlistadd);
                    Toast.makeText(add.this,"Data Tersimpan",Toast.LENGTH_SHORT).show();
                    NamaPC1.setText("");
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(add.this,"Data Tidak Tersimpan",Toast.LENGTH_SHORT).show();
                }
            }
    }

    public void setbrand(){
        final ArrayAdapter<String> brandspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brandpss);

        brandspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BrandProcessor2.setAdapter(brandspin);

        BrandProcessor2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.bps: {
                        if (brandpss[position].equals("INTEL")){
                            setprosessor();
                        }
                        if (brandpss[position].equals("AMD")){
                            setprosessoramd();
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setprosessor(){
        final ArrayAdapter<String> intelspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, intel);

        intelspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Processor3.setAdapter(intelspin);

        Processor3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.ps: {
                        if (intel[position].equals("i3-7350K")){
                            hargaps21.setText("700");
                            ratingset = 1.0;
                            setBARrating();
                        }
                        if (intel[position].equals("i5-8400K")){
                            hargaps21.setText("800");
                            ratingset = 1.5;
                            setBARrating();
                        }
                        if (intel[position].equals("i7-8086K")){
                            hargaps21.setText("900");
                            ratingset = 2.0;
                            setBARrating();
                        }
                        if (intel[position].equals("i9-9900K")){
                            hargaps21.setText("1000");
                            ratingset = 2.5;
                            setBARrating();
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setprosessoramd(){
        final ArrayAdapter<String> amdspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, amd);

        amdspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Processor3.setAdapter(amdspin);

        Processor3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.ps: {
                        if (amd[position].equals("AMD-Kaveri")){
                            hargaps21.setText("750");
                            ratingset = 1.0;
                            setBARrating();
                        }
                        if (amd[position].equals("AMD-Godavari")){
                            hargaps21.setText("850");
                            ratingset = 1.5;
                            setBARrating();
                        }
                        if (amd[position].equals("AMD-Carrizo")){
                            hargaps21.setText("950");
                            ratingset = 2.0;
                            setBARrating();
                        }
                        if (amd[position].equals("AMD-Vishera")){
                            hargaps21.setText("1050");
                            ratingset = 2.5;
                            setBARrating();
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setmotheboard(){
        final ArrayAdapter<String> motherboardspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, matherboard);

        motherboardspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MotherBoard4.setAdapter(motherboardspin);

        MotherBoard4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.mbs: {
                        if (matherboard[position].equals("AsRock X299")){
                            hargamoth22.setText("750");
                        }
                        if (matherboard[position].equals("AsRock Fatal1ty")){
                            hargamoth22.setText("850");
                        }
                        if (matherboard[position].equals("Asus Rog Strix")){
                            hargamoth22.setText("950");
                        }
                        if (matherboard[position].equals("MSI X299")){
                            hargamoth22.setText("1050");
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setssd(){
        final ArrayAdapter<String> ssdspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ssd);

        ssdspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SSD5.setAdapter(ssdspin);

        SSD5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.ssds: {
                        if (ssd[position].equals("LaCie 500GB")){
                            hargassd23.setText("750");
                        }
                        if (ssd[position].equals("ASGARD 256GB")){
                            hargassd23.setText("850");
                        }
                        if (ssd[position].equals("GALAXY 120GB")){
                            hargassd23.setText("950");
                        }
                        if (ssd[position].equals("ADATA SX6000")){
                            hargassd23.setText("1050");
                        }
                        if (ssd[position].equals("AFOX 120GB")){
                            hargassd23.setText("1050");
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void sethdd(){
        final ArrayAdapter<String> hddspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hdd);

        hddspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HDD6.setAdapter(hddspin);

        HDD6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.hdds: {
                        if (hdd[position].equals("Seagate Baracuda")){
                            hargahdd24.setText("750");
                        }
                        if (hdd[position].equals("Toshiba")){
                            hargahdd24.setText("850");
                        }
                        if (hdd[position].equals("WDC")){
                            hargahdd24.setText("800");
                        }
                        if (hdd[position].equals("Hitachi")){
                            hargahdd24.setText("700");
                        }
                        if (hdd[position].equals("Kingston")){
                            hargahdd24.setText("650");
                        }
                        if (hdd[position].equals("Consair")){
                            hargahdd24.setText("950");
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setram(){
        final ArrayAdapter<String> ramspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ram);

        ramspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RAM7.setAdapter(ramspin);

        RAM7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.rams: {
                        if (ram[position].equals("ASGARD 8GB 2Chanel")){
                            hargaram25.setText("850");
                        }
                        if (ram[position].equals("ADATA 8GB 2Chanel")){
                            hargaram25.setText("950");
                        }
                        if (ram[position].equals("Hitachi 8GB 2Chanel")){
                            hargaram25.setText("950");
                        }
                        if (ram[position].equals("Kingston 8GB 2Chanel")){
                            hargaram25.setText("850");
                        }
                        if (ram[position].equals("Consair 8GB 2Chanel")){
                            hargaram25.setText("980");
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setvga(){
        final ArrayAdapter<String> vgaspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vga);

        vgaspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        VGA8.setAdapter(vgaspin);

        VGA8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.vgas: {
                        if (vga[position].equals("Galax Geforce 8GB")){
                            hargavga26.setText("1150");
                            ratingser1 = 0.5;
                            setBARrating();
                        }
                        if (vga[position].equals("AsRock Radeon 8GB")){
                            hargavga26.setText("1250");
                            ratingser1 = 1.0;
                            setBARrating();
                        }
                        if (vga[position].equals("Gigabyte GeforceRTX 8GB")){
                            hargavga26.setText("1350");
                            ratingset = 1.5;
                            setBARrating();
                        }
                        if (vga[position].equals("Leadtex Qudron 8GB")){
                            hargavga26.setText("1450");
                            ratingser1 = 2.0;
                            setBARrating();
                        }
                        if (vga[position].equals("MSI Geforce 8GB")){
                            hargavga26.setText("1550");
                            ratingser1 = 2.5;
                            setBARrating();
                        }
                        if (vga[position].equals("Zotac Geforcw 8GB")){
                            hargavga26.setText("1650");
                            ratingser1 = 3.0;
                            setBARrating();
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setpsu(){
        final ArrayAdapter<String> psuspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, psu);

        psuspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PSU9.setAdapter(psuspin);

        PSU9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.pcus: {
                        if (psu[position].equals("Power Logig Magnum")){
                            hargapsu27.setText("550");
                        }
                        if (psu[position].equals("Caugar Gaming")){
                            hargapsu27.setText("650");
                        }
                        if (psu[position].equals("NZXT")){
                            hargapsu27.setText("750");
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setcool(){
        final ArrayAdapter<String> cpuspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cpucooler);

        cpuspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Cooler10.setAdapter(cpuspin);

        Cooler10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.coolers: {
                        if (cpucooler[position].equals("Antex Mercury")){
                            hargacool28.setText("950");
                        }
                        if (cpucooler[position].equals( "Cyroric")){
                            hargacool28.setText("850");
                        }
                        if (cpucooler[position].equals("DeepCool")){
                            hargacool28.setText("980");
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setBARrating(){
        double forrating = ratingser1+ratingset;
        String torating = String.valueOf(forrating);
        RatingPC.setRating(Float.parseFloat(torating));
    }
    public void settotal(){
        String a1 = hargaps21.getText().toString();
        String a2 = hargamoth22.getText().toString();
        String a3 = hargassd23.getText().toString();
        String a4 = hargahdd24.getText().toString();
        String a5 = hargaram25.getText().toString();
        String a6 = hargavga26.getText().toString();
        String a7 = hargapsu27.getText().toString();
        String a8 = hargacool28.getText().toString();
        int b1 = Integer.parseInt(a1);
        int b2 = Integer.parseInt(a2);
        int b3 = Integer.parseInt(a3);
        int b4 = Integer.parseInt(a4);
        int b5 = Integer.parseInt(a5);
        int b6 = Integer.parseInt(a6);
        int b7 = Integer.parseInt(a7);
        int b8 = Integer.parseInt(a8);
        int total = b1+b2+b3+b4+b5+b6+b7+b8;
        c1 = String.valueOf(total);
        hargatotaladd29.setText(c1);
    }
}

