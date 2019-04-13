package com.example.usjul.mypc;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {
    DBHandler mydb;
    private LayoutInflater ly;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context, Cursor c, int flags){
        super(context,c,flags);
        ly = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = ly.inflate(R.layout.row_listpc,viewGroup,false);
        MyHolder holder = new MyHolder();
        holder.listID = (TextView)v.findViewById(R.id.listID);
        holder.listNama = (TextView)v.findViewById(R.id.listpcnama);
        holder.listProsessor = (TextView)v.findViewById(R.id.listpcprosessor);
        holder.listTanggal = (TextView)v.findViewById(R.id.listpctanggal);
        v.setTag(holder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MyHolder holder = (MyHolder)view.getTag();

        holder.listID.setText(cursor.getString(cursor.getColumnIndex(DBHandler.id_pc)));
        holder.listNama.setText(cursor.getString(cursor.getColumnIndex(DBHandler.nama_pc)));
        holder.listProsessor.setText(cursor.getString(cursor.getColumnIndex(DBHandler.prosessor_pc)));
        holder.listTanggal.setText(cursor.getString(cursor.getColumnIndex(DBHandler.tanggal_pc)));

    }
    class MyHolder{
        TextView listID;
        TextView listNama;
        TextView listProsessor;
        TextView listTanggal;
    }
}
