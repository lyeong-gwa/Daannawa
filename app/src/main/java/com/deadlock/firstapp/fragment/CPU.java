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
import com.deadlock.firstapp.part.Cpupart;

import java.util.ArrayList;


public class CPU extends ListFragment {
    private ListAdapter adapter;
    ArrayList<Cpupart> cpupart_list;
    Filter filter;
    DBReader dbreader;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        filter=new Filter();
        dbreader = new DBReader(getActivity());
        cpupart_list = filter.filter_cpu(getActivity(),((MenuActivity)getActivity()).selectpart);
        adapter = new ListAdapter(((MenuActivity)getActivity()).selectpart,this);
        setListAdapter(adapter);
        if(cpupart_list!=null) {
            for (Cpupart a : cpupart_list) {
                adapter.addItem2(a.getName(),
                        "제조사: " + a.getManufacturer() + "\n" +
                        "소켓: " + a.getSocket() + "\n" +
                        "코어: " + a.getCore() + "\n" +
                        "쓰레드: " + a.getThread() + "\n" +
                        "클럭: " +a.getClock() + "GHz\n" +
                        "내장그래픽 유무: " + a.getGraphic(), a.getPrice(), a.getChoice_enable(), a);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick (l, v, position, id);
        ListData temp=((ListData)adapter.getItem(position));
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("CPU");
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
