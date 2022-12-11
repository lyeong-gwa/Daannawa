package com.deadlock.firstapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deadlock.firstapp.DO.ListAdapter;
import com.deadlock.firstapp.R;
import com.deadlock.firstapp.activity.MenuActivity;
import com.deadlock.firstapp.data_ctrl.DBReader;
import com.deadlock.firstapp.data_ctrl.Filter;
import com.deadlock.firstapp.part.Casepart;
import com.deadlock.firstapp.part.Coolerpart;
import com.deadlock.firstapp.part.Cpupart;
import com.deadlock.firstapp.part.Mainboardpart;
import com.deadlock.firstapp.part.Powerpart;
import com.deadlock.firstapp.part.Rampart;
import com.deadlock.firstapp.part.Selectpart;
import com.deadlock.firstapp.part.Storagepart;
import com.deadlock.firstapp.part.Vgapart;
import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartFragment extends ListFragment {
    private ListAdapter adapter;
    private ArrayList<Object> list;
    private Selectpart selectpart;
    private TabLayout tabLayout;
    private int sum = 0;
    private DecimalFormat formatter = new DecimalFormat("###,###");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        selectpart = ((MenuActivity)getActivity()).selectpart;
        adapter = new ListAdapter(((MenuActivity)getActivity()).selectpart,this);
        setListAdapter(adapter);

        if(selectpart != null) {
            Cpupart cpupart = selectpart.getCpupart();
            Coolerpart coolerpart = selectpart.getCoolerpart();
            Mainboardpart mainboardpart = selectpart.getMainboardpart();
            Rampart rampart = selectpart.getRampart();
            Vgapart vgapart = selectpart.getVgapart();
            Powerpart powerpart = selectpart.getPowerpart();
            Casepart casepart = selectpart.getCasepart();
            Storagepart storagepart = selectpart.getStoragepart();

            if(cpupart != null) {
                adapter.addItem2(cpupart.getName(),
                        "제조사: " + cpupart.getManufacturer() + "\n" +
                        "소켓: " + cpupart.getSocket() + "\n" +
                        "코어: " + cpupart.getCore() + "\n" +
                        "쓰레드: " + cpupart.getThread() + "\n" +
                        "클럭: " +cpupart.getClock() + "GHz\n" +
                        "내장그래픽 유무: " + cpupart.getGraphic(), cpupart.getPrice(), cpupart.getChoice_enable(), cpupart);
                sum += cpupart.getPrice();
            }

            if(coolerpart != null) {
                adapter.addItem2(coolerpart.getName(),
                        "제조사: " + coolerpart.getManufacturer() + "\n" +
                        "방식: " + coolerpart.getMethod() + "\n" +
                        "높이(팬 규격): " + coolerpart.getHeight(), coolerpart.getPrice(), coolerpart.getChoice_enable(), coolerpart);
                sum += coolerpart.getPrice();
            } else if(cpupart != null) {
                adapter.addItem2("기본 쿨러",
                        " ", 0, false, null);
            }

            if(mainboardpart != null) {
                adapter.addItem2(mainboardpart.getName(),
                        "제조사: " + mainboardpart.getManufacturer() + "\n" +
                        "규격: " + mainboardpart.getStandard() + "\n" +
                        "지원 소켓: " + mainboardpart.getSocket() + "\n" +
                        "칩셋: " + mainboardpart.getChipset(), mainboardpart.getPrice(), mainboardpart.getChoice_enable(), mainboardpart);
                sum += mainboardpart.getPrice();
            }

            if(rampart != null) {
                adapter.addItem2(rampart.getName(),
                        "제조사: " + rampart.getManufacturer() + "\n" +
                        "용량: " + rampart.getCapacity() + "GB\n" +
                        "클럭: " + rampart.getClock() + "MHz", rampart.getPrice(), rampart.getChoice_enable(), rampart);
                sum += rampart.getPrice() * rampart.getSet();
            }

            if(vgapart != null) {
                adapter.addItem2(vgapart.getName(),
                        "제조사: " + vgapart.getManufacturer() + "\n" +
                        "정격 출력: " + vgapart.getPower() + "W", vgapart.getPrice(), vgapart.getChoice_enable(), vgapart);
                sum += vgapart.getPrice();
            } else if(cpupart != null) {
                adapter.addItem2("내장 그래픽",
                        " ", 0, false, null);
            }

            if(powerpart != null) {
                adapter.addItem2(powerpart.getName(),
                        "제조사: " + powerpart.getManufacturer() + "\n" +
                        "정격 출력: " + powerpart.getPower() + "W", powerpart.getPrice(), powerpart.getChoice_enable(), powerpart);
                sum += powerpart.getPrice();
            }

            if(casepart != null) {
                adapter.addItem2(casepart.getName(),
                        "제조사: " + casepart.getManufacturer() + "\n" +
                        "크기: " + casepart.getSize() + "\n" +
                        "지원 보드 규격: " + casepart.getStandard() + "\n" +
                        "쿨러 높이: " + casepart.getCooler_size() + "\n" +
                        "그래픽 카드 길이: " + casepart.getVga_size() + "\n" +
                        "라디에이터 길이: " + casepart.getRadiator_size(), casepart.getPrice(), casepart.getChoice_enable(), casepart);
                sum += casepart.getPrice();
            }

            if(storagepart != null) {
                adapter.addItem2(storagepart.getName(),
                        "제조사: " + storagepart.getManufacturer() + "\n" +
                        "형식: " + storagepart.getType() + "\n" +
                        "용량: " + storagepart.getCapacity(), storagepart.getPrice(), storagepart.getChoice_enable(), storagepart);
                sum += storagepart.getPrice();
            }
        }

        this.tabLayout = ((MenuActivity)getActivity()).tabLayout;
        tabLayout.removeTabAt(4);
        tabLayout.addTab(tabLayout.newTab().setText("합계: " + formatter.format(sum) + " 원"));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        sum = 0;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}