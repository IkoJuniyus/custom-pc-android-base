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

public class edit extends AppCompatActivity {

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
    String idpcupdate,pc_nameupdate,pc_brandupdate,pc_prosessorupdate,pc_motherboardupdate,pc_ssdupdate,pc_hddupdate,pc_ramupdate,pc_vgaupdate,pc_psuupdate,pc_coolerupdate,currentdate,pcharga_psupdate,pcharga_mtupdate,pcharga_ssdupdate,pcharga_hddupdate,pcharga_ramupdate,pcharga_vgaupdate,pcharga_psuupdate,pcharga_coolupdate,pcharga_totalupdate,pcrating_pcupdate;
    EditText NamaPC1edit;
    Spinner BrandProcessor2edit, Processor3edit, MotherBoard4edit, SSD5edit, HDD6edit, RAM7edit, VGA8edit, PSU9edit, Cooler10edit;
    FloatingActionButton buttonupdate;
    Calendar calendar;
    EditText hargaps21edit,hargamoth22edit,hargassd23edit,hargahdd24edit,hargaram25edit,hargavga26edit,hargapsu27edit,hargacool28edit,hargatotal29edit;
    double ratingsetedit,ratingser1edit;
    RatingBar RatingPCedit;
    Button cekhargaedit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mydb = new DBHandler(this);
        NamaPC1edit = (EditText) findViewById(R.id.namaedit);
        BrandProcessor2edit = (Spinner) findViewById(R.id.bpsedit);
        Processor3edit = (Spinner) findViewById(R.id.prosessoredit);
        MotherBoard4edit = (Spinner) findViewById(R.id.mbsedit);
        SSD5edit = (Spinner) findViewById(R.id.ssdsedit);
        HDD6edit = (Spinner) findViewById(R.id.hddsedit);
        RAM7edit = (Spinner) findViewById(R.id.ramsedit);
        VGA8edit = (Spinner) findViewById(R.id.vgasedit);
        PSU9edit = (Spinner) findViewById(R.id.pcusedit);
        Cooler10edit = (Spinner) findViewById(R.id.coolersedit);
        buttonupdate = (FloatingActionButton) findViewById(R.id.btnupdate);
        hargaps21edit = (EditText)findViewById(R.id.hargaprosessoredit);
        hargamoth22edit = (EditText)findViewById(R.id.hargamotherboardedit);
        hargassd23edit = (EditText)findViewById(R.id.hargassdedit);
        hargahdd24edit = (EditText)findViewById(R.id.hargahddedit);
        hargaram25edit = (EditText)findViewById(R.id.hargaramedit);
        hargavga26edit = (EditText)findViewById(R.id.hargavgaedit);
        hargapsu27edit = (EditText)findViewById(R.id.hargapsuedit);
        hargacool28edit = (EditText)findViewById(R.id.hargacooledit);
        hargatotal29edit = (EditText)findViewById(R.id.hargatotaledit);
        RatingPCedit = (RatingBar)findViewById(R.id.ratingpcedit);
        cekhargaedit = (Button)findViewById(R.id.butoncekedit);
        calendar = Calendar.getInstance();
        currentdate = DateFormat.getDateInstance().format(calendar.getTime());
        hargatotal29edit.setEnabled(false);
        hargaps21edit.setEnabled(false);
        hargamoth22edit.setEnabled(false);
        hargassd23edit.setEnabled(false);
        hargahdd24edit.setEnabled(false);
        hargaram25edit.setEnabled(false);
        hargavga26edit.setEnabled(false);
        hargapsu27edit.setEnabled(false);
        hargacool28edit.setEnabled(false);
        idpcupdate = getIntent().getStringExtra("idpos");
        pc_nameupdate = getIntent().getStringExtra("namapc");
        pc_brandupdate = getIntent().getStringExtra("brandpc");
        NamaPC1edit.setText(pc_nameupdate);
        pc_prosessorupdate = getIntent().getStringExtra("prosspc");
        pc_motherboardupdate = getIntent().getStringExtra("mothpc");
        pc_ssdupdate = getIntent().getStringExtra("ssdpc");
        pc_hddupdate = getIntent().getStringExtra("hddpc");
        pc_ramupdate = getIntent().getStringExtra("rampc");
        pc_vgaupdate = getIntent().getStringExtra("vgapc");
        pc_psuupdate = getIntent().getStringExtra("psupc");
        pc_coolerupdate = getIntent().getStringExtra("coolpc");
        currentdate = getIntent().getStringExtra("tanggalpc");
        pcharga_psupdate = getIntent().getStringExtra("hargapspc");
        pcharga_mtupdate = getIntent().getStringExtra("hargamtpc");
        pcharga_ssdupdate = getIntent().getStringExtra("hargassdpc");
        pcharga_hddupdate = getIntent().getStringExtra("hargahddpc");
        pcharga_ramupdate = getIntent().getStringExtra("hargarampc");
        pcharga_vgaupdate = getIntent().getStringExtra("hargavgapc");
        pcharga_psuupdate = getIntent().getStringExtra("hargapsupc");
        pcharga_coolupdate = getIntent().getStringExtra("hargacoolpc");
        pcharga_totalupdate = getIntent().getStringExtra("hargatotalpc");
        hargatotal29edit.setText(pcharga_totalupdate);
        pcrating_pcupdate = getIntent().getStringExtra("ratingpcstpc");
        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogupadte();
            }
        });
        cekhargaedit.setOnClickListener(new View.OnClickListener() {
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



        String comparebrand = pc_brandupdate;
        final ArrayAdapter<String> brands = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brandpss);
        if (comparebrand!=null){
            int spinposition = brands.getPosition(comparebrand);
            BrandProcessor2edit.setSelection(spinposition);
        }
        if (pc_brandupdate=="INTEL"){
            String comparepross = pc_prosessorupdate;
            final ArrayAdapter<String> prosss = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, intel);
            if (comparepross!=null){
                int spinposition = prosss.getPosition(comparepross);
                Processor3edit.setSelection(spinposition);
            }
        }else {
            String compareprosss = pc_prosessorupdate;
            final ArrayAdapter<String> prosss = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, amd);
            if (compareprosss!=null){
                int spinposition = prosss.getPosition(compareprosss);
                Processor3edit.setSelection(spinposition);
            }
        }

        String comparemoth = pc_motherboardupdate;
        final ArrayAdapter<String> moths = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, matherboard);
        if (comparemoth!=null){
            int spinposition = moths.getPosition(comparemoth);
            MotherBoard4edit.setSelection(spinposition);
        }
        String comparessd = pc_ssdupdate;
        final ArrayAdapter<String> ssdss = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ssd);
        if (comparessd!=null){
            int spinposition = ssdss.getPosition(comparessd);
            SSD5edit.setSelection(spinposition);
        }
        String comparehdd = pc_hddupdate;
        final ArrayAdapter<String> hdds = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hdd);
        if (comparehdd!=null){
            int spinposition = hdds.getPosition(comparehdd);
            HDD6edit.setSelection(spinposition);
        }
        String compareram = pc_ramupdate;
        final ArrayAdapter<String> rams = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ram);
        if (compareram!=null){
            int spinposition = rams.getPosition(compareram);
            RAM7edit.setSelection(spinposition);
        }
        String comparevga = pc_vgaupdate;
        final ArrayAdapter<String> vgas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vga);
        if (comparevga!=null){
            int spinposition = vgas.getPosition(comparevga);
            VGA8edit.setSelection(spinposition);
        }
        String comparepsu = pc_psuupdate;
        final ArrayAdapter<String> psus = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, psu);
        if (comparepsu!=null){
            int spinposition = psus.getPosition(comparepsu);
            PSU9edit.setSelection(spinposition);
        }
        String comparecooler = pc_coolerupdate;
        final ArrayAdapter<String> coolers = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cpucooler);
        if (comparecooler!=null){
            int spinposition = coolers.getPosition(comparecooler);
            Cooler10edit.setSelection(spinposition);
        }


    }

    public void dialogupadte(){
        AlertDialog.Builder simpan = new AlertDialog.Builder(edit.this);
        simpan.setTitle("Simpan Data");
        simpan.setMessage("Apa anda yakin ingin menyimpan?");
        simpan.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UpdateDATA();
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

    public void setbrand(){
        final ArrayAdapter<String> brandspin = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brandpss);

        brandspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BrandProcessor2edit.setAdapter(brandspin);

        BrandProcessor2edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.bpsedit: {
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
        Processor3edit.setAdapter(intelspin);

        Processor3edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.prosessoredit: {
                        if (intel[position].equals("i3-7350K")){
                            hargaps21edit.setText("700");
                            ratingsetedit = 1.0;
                            setBARrating();
                        }
                        if (intel[position].equals("i5-8400K")){
                            hargaps21edit.setText("800");
                            ratingsetedit = 1.5;
                            setBARrating();
                        }
                        if (intel[position].equals("i7-8086K")){
                            hargaps21edit.setText("900");
                            ratingsetedit = 2.0;
                            setBARrating();
                        }
                        if (intel[position].equals("i9-9900K")){
                            hargaps21edit.setText("1000");
                            ratingsetedit = 2.5;
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
        Processor3edit.setAdapter(amdspin);

        Processor3edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.prosessoredit: {
                        if (amd[position].equals("AMD-Kaveri")){
                            hargaps21edit.setText("750");
                            ratingsetedit = 2.5;
                            setBARrating();
                        }
                        if (amd[position].equals("AMD-Godavari")){
                            hargaps21edit.setText("850");
                            ratingsetedit = 2.5;
                            setBARrating();
                        }
                        if (amd[position].equals("AMD-Carrizo")){
                            hargaps21edit.setText("950");
                            ratingsetedit = 2.5;
                            setBARrating();
                        }
                        if (amd[position].equals("AMD-Vishera")){
                            hargaps21edit.setText("1050");
                            ratingsetedit = 2.5;
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
        MotherBoard4edit.setAdapter(motherboardspin);

        MotherBoard4edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.mbsedit: {
                        if (matherboard[position].equals("AsRock X299")){
                            hargamoth22edit.setText("750");
                        }
                        if (matherboard[position].equals("AsRock Fatal1ty")){
                            hargamoth22edit.setText("850");
                        }
                        if (matherboard[position].equals("Asus Rog Strix")){
                            hargamoth22edit.setText("950");
                        }
                        if (matherboard[position].equals("MSI X299")){
                            hargamoth22edit.setText("1050");
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
        SSD5edit.setAdapter(ssdspin);

        SSD5edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.ssdsedit: {
                        if (ssd[position].equals("LaCie 500GB")){
                            hargassd23edit.setText("750");
                        }
                        if (ssd[position].equals("ASGARD 256GB")){
                            hargassd23edit.setText("850");
                        }
                        if (ssd[position].equals("GALAXY 120GB")){
                            hargassd23edit.setText("950");
                        }
                        if (ssd[position].equals("ADATA SX6000")){
                            hargassd23edit.setText("1050");
                        }
                        if (ssd[position].equals("AFOX 120GB")){
                            hargassd23edit.setText("1050");
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
        HDD6edit.setAdapter(hddspin);

        HDD6edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.hddsedit: {
                        if (hdd[position].equals("Seagate Baracuda")){
                            hargahdd24edit.setText("750");
                        }
                        if (hdd[position].equals("Toshiba")){
                            hargahdd24edit.setText("850");
                        }
                        if (hdd[position].equals("WDC")){
                            hargahdd24edit.setText("800");
                        }
                        if (hdd[position].equals("Hitachi")){
                            hargahdd24edit.setText("700");
                        }
                        if (hdd[position].equals("Kingston")){
                            hargahdd24edit.setText("650");
                        }
                        if (hdd[position].equals("Consair")){
                            hargahdd24edit.setText("950");
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
        RAM7edit.setAdapter(ramspin);

        RAM7edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.ramsedit: {
                        if (ram[position].equals("ASGARD 8GB 2Chanel")){
                            hargaram25edit.setText("850");
                        }
                        if (ram[position].equals("ADATA 8GB 2Chanel")){
                            hargaram25edit.setText("950");
                        }
                        if (ram[position].equals("Hitachi 8GB 2Chanel")){
                            hargaram25edit.setText("950");
                        }
                        if (ram[position].equals("Kingston 8GB 2Chanel")){
                            hargaram25edit.setText("850");
                        }
                        if (ram[position].equals("Consair 8GB 2Chanel")){
                            hargaram25edit.setText("980");
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
        VGA8edit.setAdapter(vgaspin);

        VGA8edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.vgasedit: {
                        if (vga[position].equals("Galax Geforce 8GB")){
                            hargavga26edit.setText("1150");
                            ratingser1edit = 0.5;
                            setBARrating();
                        }
                        if (vga[position].equals("AsRock Radeon 8GB")){
                            hargavga26edit.setText("1250");
                            ratingser1edit = 1.0;
                            setBARrating();
                        }
                        if (vga[position].equals("Gigabyte GeforceRTX 8GB")){
                            hargavga26edit.setText("1350");
                            ratingsetedit = 1.5;
                            setBARrating();
                        }
                        if (vga[position].equals("Leadtex Qudron 8GB")){
                            hargavga26edit.setText("1450");
                            ratingser1edit = 2.0;
                            setBARrating();
                        }
                        if (vga[position].equals("MSI Geforce 8GB")){
                            hargavga26edit.setText("1550");
                            ratingser1edit = 2.5;
                            setBARrating();
                        }
                        if (vga[position].equals("Zotac Geforcw 8GB")){
                            hargavga26edit.setText("1650");
                            ratingser1edit = 3.0;
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
        PSU9edit.setAdapter(psuspin);

        PSU9edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.pcusedit: {
                        if (psu[position].equals("Power Logig Magnum")){
                            hargapsu27edit.setText("550");
                        }
                        if (psu[position].equals("Caugar Gaming")){
                            hargapsu27edit.setText("650");
                        }
                        if (psu[position].equals("NZXT")){
                            hargapsu27edit.setText("750");
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
        Cooler10edit.setAdapter(cpuspin);

        Cooler10edit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()) {
                    case R.id.coolersedit: {
                        if (cpucooler[position].equals("Antex Mercury")){
                            hargacool28edit.setText("950");
                        }
                        if (cpucooler[position].equals( "Cyroric")){
                            hargacool28edit.setText("850");
                        }
                        if (cpucooler[position].equals("DeepCool")){
                            hargacool28edit.setText("980");
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
        double forrating = ratingser1edit+ratingsetedit;
        String torating = String.valueOf(forrating);
        RatingPCedit.setRating(Float.parseFloat(torating));
    }
    public void settotal(){
        String a1 = hargaps21edit.getText().toString();
        String a2 = hargamoth22edit.getText().toString();
        String a3 = hargassd23edit.getText().toString();
        String a4 = hargahdd24edit.getText().toString();
        String a5 = hargaram25edit.getText().toString();
        String a6 = hargavga26edit.getText().toString();
        String a7 = hargapsu27edit.getText().toString();
        String a8 = hargacool28edit.getText().toString();
        int b1 = Integer.parseInt(a1);
        int b2 = Integer.parseInt(a2);
        int b3 = Integer.parseInt(a3);
        int b4 = Integer.parseInt(a4);
        int b5 = Integer.parseInt(a5);
        int b6 = Integer.parseInt(a6);
        int b7 = Integer.parseInt(a7);
        int b8 = Integer.parseInt(a8);
        int total = b1+b2+b3+b4+b5+b6+b7+b8;
        String c1 = String.valueOf(total);
        hargatotal29edit.setText(c1);
    }
    public void UpdateDATA(){
        calendar = Calendar.getInstance();
        String intid = getIntent().getStringExtra("idpos");
        String pc_nameupdate = NamaPC1edit.getText().toString();
        String pc_brandupdate = BrandProcessor2edit.getSelectedItem().toString();
        String pc_prosessorupdate = Processor3edit.getSelectedItem().toString();
        String pc_motherboardupdate = MotherBoard4edit.getSelectedItem().toString();
        String pc_ssdupdate = SSD5edit.getSelectedItem().toString();
        String pc_hddupdate = HDD6edit.getSelectedItem().toString();
        String pc_ramupdate = RAM7edit.getSelectedItem().toString();
        String pc_vgaupdate = VGA8edit.getSelectedItem().toString();
        String pc_psuupdate = PSU9edit.getSelectedItem().toString();
        String pc_coolerupdate = Cooler10edit.getSelectedItem().toString();
        String currentdateupdate = DateFormat.getDateInstance().format(calendar.getTime());
        String harga_pross = hargaps21edit.getText().toString();
        String harga_moth = hargamoth22edit.getText().toString();
        String harga_ssd = hargassd23edit.getText().toString();
        String harga_hdd = hargahdd24edit.getText().toString();
        String harga_ram = hargaram25edit.getText().toString();
        String harga_vga = hargavga26edit.getText().toString();
        String harga_psu = hargapsu27edit.getText().toString();
        String harga_cool = hargacool28edit.getText().toString();
        String hargapc_total = hargatotal29edit.getText().toString();
        String pcrating  = String.valueOf(RatingPCedit.getRating());
        String idts2 = intid;
        settotal();
        int IDPC = Integer.parseInt(idts2);
        if (NamaPC1edit.equals("")){
            Toast.makeText(edit.this,"Tolong isi kolom Nama",Toast.LENGTH_SHORT).show();
        }else {
            try {
                mydb.updateData(pc_nameupdate.trim(),pc_brandupdate.trim(),pc_prosessorupdate.trim(),pc_motherboardupdate.trim(),pc_ssdupdate.trim(),pc_hddupdate.trim(),pc_ramupdate.trim(),pc_vgaupdate.trim(),pc_psuupdate.trim(),pc_coolerupdate.trim(),currentdateupdate.trim(),harga_pross.trim(),harga_moth.trim(),harga_ssd.trim(),harga_hdd.trim(),harga_ram.trim(),harga_vga.trim(),harga_psu.trim(),harga_cool.trim(),hargapc_total.trim(),pcrating.trim(),IDPC);
                Intent comeback = new Intent(edit.this,MainActivity.class);
                Toast.makeText(edit.this,"Data Berhasil Di Perbarui",Toast.LENGTH_SHORT).show();
                NamaPC1edit.setText("");
                startActivity(comeback);
                finish();
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(edit.this,"Data Gagal Di Perbarui",Toast.LENGTH_SHORT).show();
            }
        }
    }

}

