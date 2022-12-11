package com.deadlock.firstapp.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.deadlock.firstapp.DO.ListAdapter;
import com.deadlock.firstapp.DO.ListData;
import com.deadlock.firstapp.activity.MenuActivity;
import com.deadlock.firstapp.data_ctrl.DBReader;
import com.deadlock.firstapp.data_ctrl.Filter;
import com.deadlock.firstapp.part.Storagepart;

import java.util.ArrayList;

public class Storage extends ListFragment {
    private ListAdapter adapter;
    ArrayList<Storagepart> storagepart_list;
    Filter filter;
    DBReader dbreader;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        filter=new Filter();
        dbreader=new DBReader(getActivity());
        storagepart_list=filter.filter_storage(getActivity(),((MenuActivity)getActivity()).selectpart);
        adapter = new ListAdapter(((MenuActivity)getActivity()).selectpart,this);
        setListAdapter(adapter);

        if(storagepart_list != null) {
            for(Storagepart a:storagepart_list){
                adapter.addItem2(a.getName(),
                        "제조사: " + a.getManufacturer() + "\n" +
                        "형식: " + a.getType() + "\n" +
                        "용량: " + a.getCapacity(), a.getPrice(), a.getChoice_enable(), a);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick (l, v, position, id);
        ListData temp=((ListData)adapter.getItem(position));
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Storage");
        alertDialogBuilder.setMessage(temp.getDetail());
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
