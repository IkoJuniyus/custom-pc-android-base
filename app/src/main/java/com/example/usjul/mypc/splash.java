package com.example.usjul.mypc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    private ImageView ix;
    DBHandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mydb = new DBHandler(this);
        mydb.queryData("CREATE TABLE IF NOT EXISTS pc_table(id_pc INTEGER PRIMARY KEY AUTOINCREMENT,nama_pc VARCHAR," +
                "brand_pc VARCHAR,prosessor_pc VARCHAR,motherboard_pc VARCHAR,ssd_pc VARCHAR,hdd_pc VARCHAR,ram_pc VARCHAR," +
                "vga_pc VARCHAR,psu_pc VARCHAR,cooler_pc VARCHAR,tanggal_pc VARCHAR,harga_ps VARCHAR,harga_mt VARCHAR," +
                "harga_ssd VARCHAR,harga_hdd VARCHAR,harga_ram VARCHAR,harga_vga VARCHAR,harga_psu VARCHAR," +
                "harga_cool VARCHAR,harga_total VARCHAR,rating_pc VARCHAR)");
        ix = (ImageView)findViewById(R.id.ix);
        Animation anima = AnimationUtils.loadAnimation(this,R.anim.mytrans);
        ix.startAnimation(anima);
        final Intent inte = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(inte);
                    finish();
                }
            }
        };
        timer.start();
    }
}
