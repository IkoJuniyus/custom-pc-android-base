package com.example.usjul.mypc;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    FloatingActionButton nextadd;
    private String[] daftar;
    private String[] idDaftar;
    public ListView listData;
    protected Cursor cursor;
    private DBHandler mydb;
    public static MainActivity wik;
    public ListView lv;
    public ArrayAdapter<String> adapter;
    ArrayList<getSet> list;
    public EditText tSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBHandler(this);
        nextadd = (FloatingActionButton) findViewById(R.id.btnadd);
        wik = this;
        list = new ArrayList<>();
        lv = (ListView) findViewById(R.id.Listmypc);
        tSearch = (EditText) findViewById(R.id.txtSearch);

        nextadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextadd = new Intent(MainActivity.this,add.class);
                startActivity(nextadd);
                finish();
            }
        });

        cursor = mydb.getAllData();
        daftar = new String[cursor.getCount()];
        idDaftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(0).toString();
            idDaftar[cc] = cursor.getString(1).toString();
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, idDaftar);
        lv.setAdapter(adapter);
        lv.setSelected(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem ={"lihat","Hapus"};
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0:
                                Intent i = new Intent(getApplicationContext(), view_item.class);
                                i.putExtra("id", selection);
                                startActivity(i);
                                finish();
                                break;
                            case 1:
                                AlertDialog.Builder dialogDelete = new AlertDialog.Builder(MainActivity.this);
                                dialogDelete.setTitle("Peringantan!!");
                                dialogDelete.setMessage("Anda yakin ingin menghapus list ini?");
                                dialogDelete.setPositiveButton("YA!", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        try {
                                            SQLiteDatabase db = mydb.getWritableDatabase();
                                            db.execSQL("DELETE FROM pc_table WHERE id_pc = '" + selection + "'");
                                            db.close();
                                            Toast.makeText(MainActivity.this, "Delete Successfully!",Toast.LENGTH_SHORT).show();

                                        }catch (Exception e){
                                            Log.e("Error", e.getMessage());
                                        }
                                        RefreshList();
                                    }
                                });
                                dialogDelete.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                dialogDelete.show();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) lv.getAdapter()).notifyDataSetInvalidated();
        RefreshList();



        tSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String key = tSearch.getText().toString();
                String msg = "Data Not Found";
                SQLiteDatabase db = mydb.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM pc_table WHERE nama_pc like '%"+key+"%'", null);
                if(cursor.getCount()>0) {
                    daftar = new String[cursor.getCount()];
                    idDaftar = new String[cursor.getCount()];
                    cursor.moveToFirst();
                    for (int cc = 0; cc < cursor.getCount(); cc++) {
                        cursor.moveToPosition(cc);
                        daftar[cc] = cursor.getString(0).toString();
                        idDaftar[cc] = cursor.getString(1).toString();
                    }

                    adapter = new ArrayAdapter<String>(wik, android.R.layout.simple_list_item_1, idDaftar);
                    lv.setAdapter(adapter);
                    lv.setSelected(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    public void RefreshList() {
        SQLiteDatabase db = mydb.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pc_table", null);
        daftar = new String[cursor.getCount()];
        idDaftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(0).toString();
            idDaftar[cc] = cursor.getString(1).toString();
        }
        listData = (ListView) findViewById(R.id.Listmypc);
        listData.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,idDaftar));
        listData.setSelected(true);
        ((ArrayAdapter) listData.getAdapter()).notifyDataSetInvalidated();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder closeapp = new AlertDialog.Builder(MainActivity.this);
        closeapp.setMessage("anda yakin ingin keluar");
        closeapp.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                System.exit(1);
                finish();

            }
        });
        closeapp.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        closeapp.show();
    }

    @Override
    public boolean onQueryTextSubmit(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
