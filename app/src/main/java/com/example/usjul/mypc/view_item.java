package com.example.usjul.mypc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class view_item extends AppCompatActivity {

    protected Cursor cursor;
    DBHandler mydb;
    Button backlist;
    TextView idget,namapc1, namabrand2, namaprosessor3, namamotherboard4, namassd5,
            namahdd6, namaram7, namavga8, namapsu9, namacooler10, namatangal11,
            hargapsview,hargamtview,hargassdview,hargahddview,hargaramview,
            hargavgaview,hargapsuview,hargacoolview,hargatotalview;
    RatingBar ratingview;

    FloatingActionButton nextlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        mydb = new DBHandler(this);
        idget = (TextView)findViewById(R.id.idGET);
        namapc1 = (TextView)findViewById(R.id.namapcView);
        namabrand2 = (TextView)findViewById(R.id.brandView);
        namaprosessor3 = (TextView)findViewById(R.id.prosessorView);
        namamotherboard4 = (TextView)findViewById(R.id.motherboardView);
        namassd5 = (TextView)findViewById(R.id.ssdView);
        namahdd6 = (TextView)findViewById(R.id.hddView);
        namaram7 = (TextView)findViewById(R.id.ramView);
        namavga8 = (TextView)findViewById(R.id.vgaView);
        namapsu9 = (TextView)findViewById(R.id.psuView);
        namacooler10 = (TextView)findViewById(R.id.coolerView);
        namatangal11 = (TextView)findViewById(R.id.viewtanggal);
        nextlist = (FloatingActionButton)findViewById(R.id.backlist);
        hargapsview = (TextView)findViewById(R.id.hargaprosessorview);
        hargamtview = (TextView)findViewById(R.id.hargamotherboardview);
        hargassdview = (TextView)findViewById(R.id.hargassdview);
        hargahddview = (TextView)findViewById(R.id.hargahddview);
        hargaramview = (TextView)findViewById(R.id.hargaramview);
        hargavgaview = (TextView)findViewById(R.id.hargavgaview);
        hargapsuview = (TextView)findViewById(R.id.hargapsuview);
        hargacoolview = (TextView)findViewById(R.id.hargacoolerview);
        hargatotalview = (TextView)findViewById(R.id.hargaview);
        ratingview = (RatingBar)findViewById(R.id.ratingpclistview);
        SQLiteDatabase db = mydb.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pc_table WHERE id_pc = '" +
                getIntent().getStringExtra("id") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            idget.setText(cursor.getString(0).toString());
            namapc1.setText(cursor.getString(1).toString());
            namabrand2.setText(cursor.getString(2).toString());
            namaprosessor3.setText(cursor.getString(3).toString());
            namamotherboard4.setText(cursor.getString(4).toString());
            namassd5.setText(cursor.getString(5).toString());
            namahdd6.setText(cursor.getString(6).toString());
            namaram7.setText(cursor.getString(7).toString());
            namavga8.setText(cursor.getString(8).toString());
            namapsu9.setText(cursor.getString(9).toString());
            namacooler10.setText(cursor.getString(10).toString());
            namatangal11.setText(cursor.getString(11).toString());
            hargapsview.setText(cursor.getString(12).toString());
            hargamtview.setText(cursor.getString(13).toString());
            hargassdview.setText(cursor.getString(14).toString());
            hargahddview.setText(cursor.getString(15).toString());
            hargaramview.setText(cursor.getString(16).toString());
            hargavgaview.setText(cursor.getString(17).toString());
            hargapsuview.setText(cursor.getString(18).toString());
            hargacoolview.setText(cursor.getString(19).toString());
            hargatotalview.setText(cursor.getString(20).toString());
            ratingview.setRating(Float.parseFloat(cursor.getString(21).toString()));
        }
    nextlist.setOnClickListener(new View.OnClickListener() {
        String idst = idget.getText().toString();
        String pcnamast = namapc1.getText().toString();
        String pcbrandst = namabrand2.getText().toString();
        String pcprossst = namaprosessor3.getText().toString();
        String pcmothst = namamotherboard4.getText().toString();
        String pcssdst = namassd5.getText().toString();
        String pchddst = namahdd6.getText().toString();
        String pcramst = namaram7.getText().toString();
        String pcvgast = namavga8.getText().toString();
        String pcpsust = namapsu9.getText().toString();
        String pccoolst = namacooler10.getText().toString();
        String pctanggalst = namatangal11.getText().toString();
        String hargapsst = hargapsview.getText().toString();
        String hargamtst = hargamtview.getText().toString();
        String hargassdst = hargassdview.getText().toString();
        String hargahddst = hargahddview.getText().toString();
        String hargaramst = hargaramview.getText().toString();
        String hargavgast = hargavgaview.getText().toString();
        String hargapsust = hargapsuview.getText().toString();
        String hargacoolst = hargacoolview.getText().toString();
        String hargatotalst = hargatotalview.getText().toString();
        String ratingpcst = String.valueOf(ratingview.getRating());

        @Override
        public void onClick(View v) {
            Intent inte = new Intent(view_item.this,edit.class);
            inte.putExtra("idpos",idst);
            inte.putExtra("namapc",pcnamast);
            inte.putExtra("brandpc",pcbrandst);
            inte.putExtra("prosspc",pcprossst);
            inte.putExtra("mothpc",pcmothst);
            inte.putExtra("ssdpc",pcssdst);
            inte.putExtra("hddpc",pchddst);
            inte.putExtra("rampc",pcramst);
            inte.putExtra("vgapc",pcvgast);
            inte.putExtra("psupc",pcpsust);
            inte.putExtra("coolpc",pccoolst);
            inte.putExtra("tanggalpc",pctanggalst);
            inte.putExtra("hargapspc",hargapsst);
            inte.putExtra("hargamtpc",hargamtst);
            inte.putExtra("hargassdst",hargassdst);
            inte.putExtra("hargahddpc",hargahddst);
            inte.putExtra("hargarampc",hargaramst);
            inte.putExtra("hargavgapc",hargavgast);
            inte.putExtra("hargapsupc",hargapsust);
            inte.putExtra("hargacoolpc",hargacoolst);
            inte.putExtra("hargatotalpc",hargatotalst);
            inte.putExtra("ratingpcstpc",ratingpcst);
            startActivity(inte);
            finish();
        }
    });
    }

}
