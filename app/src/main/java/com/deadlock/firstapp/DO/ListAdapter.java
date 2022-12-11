package com.deadlock.firstapp.DO;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.deadlock.firstapp.R;
import com.deadlock.firstapp.activity.MenuActivity;
import com.deadlock.firstapp.data_ctrl.DBReader;
import com.deadlock.firstapp.part.Casepart;
import com.deadlock.firstapp.part.Coolerpart;
import com.deadlock.firstapp.part.Cpupart;
import com.deadlock.firstapp.part.Mainboardpart;
import com.deadlock.firstapp.part.Powerpart;
import com.deadlock.firstapp.part.Rampart;
import com.deadlock.firstapp.part.Selectpart;
import com.deadlock.firstapp.part.Storagepart;
import com.deadlock.firstapp.part.Vgapart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.LogRecord;


public class ListAdapter extends BaseAdapter {
    private ArrayList<ListData> data = new ArrayList<>();
    DBReader dbReader;
    Selectpart selectpart;
    ListFragment fragment;

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            throw new RuntimeException();
        }
    };

    private int set = 0;

    public synchronized int getSet() {
        return set;
    }

    public synchronized void setSet(int set) {
        this.set = set;
    }

    public ListAdapter(Selectpart selectpart, ListFragment fragment) {
        this.selectpart = selectpart;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int position = i;
        final Context context = viewGroup.getContext();
        dbReader=new DBReader(context);
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        }

        TextView textName = view.findViewById(R.id.textView_name);
        textName.setSelected(true);
        TextView detail = view.findViewById(R.id.textView_detail);
        detail.setSelected(true);
        ImageButton button=view.findViewById(R.id.imageButton_cart);
        final ListData listData = data.get(position);
        textName.setText(listData.getName());

        button.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View view) {
                int check=data.get(position).getWhat_part();
                String name=data.get(position).getName();
                CharSequence[] items = {"1", "2", "4"};

                //textName.setTextColor(Color.rgb(255, 102, 102));
                notifyDataSetChanged();

                if(listData.getChoice_enable()){


                    if(check == 0) {
                        Casepart temp = null;

                        try {
                            temp = (Casepart) dbReader.execute("case", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        selectpart.setCasepart(temp);
                    }

                    if(check == 1) {
                        Coolerpart temp = null;

                        try {
                            temp = (Coolerpart) dbReader.execute("cooler", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        selectpart.setCoolerpart(temp);
                    }

                    if(check == 2) {
                        Cpupart temp = null;

                        try {
                            temp = (Cpupart) dbReader.execute("cpu", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        selectpart.setCpupart(temp);
                    }

                    if(check == 3) {
                        Mainboardpart temp = null;

                        try {
                            temp = (Mainboardpart) dbReader.execute("mb", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        selectpart.setMainboardpart(temp);
                    }

                    if(check == 4) {
                        Powerpart temp = null;

                        try {
                            temp = (Powerpart) dbReader.execute("power", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        selectpart.setPowerpart(temp);
                    }

                    if(check == 5) {
                        Rampart temp = null;
                        try {
                            temp = (Rampart) dbReader.execute("ram", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        AlertDialog.Builder selectDialog = new AlertDialog.Builder(fragment.getActivity());
                        selectDialog.setTitle("Ram 개수");
                        selectDialog.setCancelable(false);
                        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch(i) {
                                    case 0:
                                        setSet(1);
                                        break;

                                    case 1:
                                        setSet(2);
                                        break;

                                    case 2:
                                        setSet(4);
                                        break;
                                }

                                handler.sendMessage(handler.obtainMessage());
                                notifyDataSetChanged();
                            }
                        };
                        selectDialog.setItems(items, listener);
                        selectDialog.show();

                        try {
                            Looper.loop();
                        } catch(RuntimeException e) {
                        }

                        temp.setSet(getSet());
                        System.out.println(getSet());
                        selectpart.setRampart(temp);
                    }

                    if(check == 6) {
                        Storagepart temp = null;

                        try {
                            temp = (Storagepart) dbReader.execute("storage", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        selectpart.setStoragepart(temp);
                    }

                    if(check == 7) {
                        Vgapart temp = null;

                        try {
                            temp = (Vgapart) dbReader.execute("vga", name).get().get(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        selectpart.setVgapart(temp);
                    }

                    dbReader.reset(selectpart,check);
                }
                else if(!listData.getChoice_enable()){
                    final ArrayList<Integer> delete_part=new ArrayList<Integer>();
                    String not_select_enable=check_not_select_enable(selectpart,check,name,delete_part);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("주의");
                    alertDialogBuilder.setMessage("선택한 부품이 초기화됩니다.\n"+not_select_enable);

                    alertDialogBuilder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    for(int delete :delete_part){
                                        if(delete==0){ selectpart.setCasepart(null);}
                                        else if(delete==1){ selectpart.setCoolerpart(null);}
                                        else if(delete==2){ selectpart.setCpupart(null);}
                                        else if(delete==3){ selectpart.setMainboardpart(null);}
                                        else if(delete==4){ selectpart.setPowerpart(null);}
                                        else if(delete==7){ selectpart.setVgapart(null);}
                                    }
                                    int check=data.get(position).getWhat_part();
                                    String name=data.get(position).getName();

                                    if(check == 0) {
                                        Casepart temp = null;

                                        try {
                                            temp = (Casepart) dbReader.execute("case", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setCasepart(temp);
                                    }

                                    if(check == 1) {
                                        Coolerpart temp = null;

                                        try {
                                            temp = (Coolerpart) dbReader.execute("cooler", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setCoolerpart(temp);
                                    }

                                    if(check == 2) {
                                        Cpupart temp = null;

                                        try {
                                            temp = (Cpupart) dbReader.execute("cpu", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setCpupart(temp);
                                    }

                                    if(check == 3) {
                                        Mainboardpart temp = null;

                                        try {
                                            temp = (Mainboardpart) dbReader.execute("mb", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setMainboardpart(temp);
                                    }

                                    if(check == 4) {
                                        Powerpart temp = null;

                                        try {
                                            temp = (Powerpart) dbReader.execute("power", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setPowerpart(temp);
                                    }

                                    if(check == 5) {
                                        Rampart temp = null;

                                        try {
                                            temp = (Rampart) dbReader.execute("ram", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setRampart(temp);
                                    }

                                    if(check == 6) {
                                        Storagepart temp = null;

                                        try {
                                            temp = (Storagepart) dbReader.execute("storage", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setStoragepart(temp);
                                    }

                                    if(check == 7) {
                                        Vgapart temp = null;

                                        try {
                                            temp = (Vgapart) dbReader.execute("vga", name).get().get(0);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                        selectpart.setVgapart(temp);
                                    }

                                    dbReader.reset(selectpart,check);

                                    FragmentTransaction ft = fragment.getFragmentManager().beginTransaction();
                                    ft.detach(fragment).attach(fragment).commit();
                                }
                            });
                    alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {//
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }

            }
        });

        int temp = listData.getPrice();
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println(formatter.format(temp));
        detail.setText(formatter.format(temp) + " 원");
        if(listData.getChoice_enable()){
            textName.setTextColor(Color.BLACK);
            detail.setTextColor(Color.BLACK);
        }
        else {
            textName.setTextColor(Color.LTGRAY);
            detail.setTextColor(Color.LTGRAY);
        }

        if((selectpart.getCpupart() != null) && ((listData.getName()).equals(selectpart.getCpupart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
        }

        if((selectpart.getCoolerpart() != null) && ((listData.getName()).equals(selectpart.getCoolerpart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
        }

        if((selectpart.getVgapart() != null) && ((listData.getName()).equals(selectpart.getVgapart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
        }

        if((selectpart.getMainboardpart() != null) && ((listData.getName()).equals(selectpart.getMainboardpart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
        }

        if((selectpart.getCasepart() != null) && ((listData.getName()).equals(selectpart.getCasepart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
        }

        if((selectpart.getStoragepart() != null) && ((listData.getName()).equals(selectpart.getStoragepart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
        }

        if((selectpart.getRampart() != null) && ((listData.getName()).equals(selectpart.getRampart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
            detail.setText(formatter.format(temp) + " 원 *" + selectpart.getRampart().getSet());
        }

        if((selectpart.getPowerpart() != null) && ((listData.getName()).equals(selectpart.getPowerpart().getName()))) {
            textName.setTextColor(Color.rgb(255, 102, 102));
        }

        return view;
    }

    public void addItem2(String name, String detail, int price, boolean choice_enable, Object type) {
        ListData listData = new ListData();
        listData.setName(name);
        listData.setDetail(detail);
        listData.setPrice(price);
        listData.setChoice_enable(choice_enable);
        listData.setWhat_part(check_part(type));
        data.add(listData);
    }

    int check_part(Object part){
        int temp=0;
        if(part instanceof Casepart)temp=0;
        if(part instanceof Coolerpart)temp=1;
        if(part instanceof Cpupart)temp=2;
        if(part instanceof Mainboardpart)temp=3;
        if(part instanceof Powerpart)temp=4;
        if(part instanceof Rampart)temp=5;
        if(part instanceof Storagepart)temp=6;
        if(part instanceof Vgapart)temp=7;
        return temp;
    }
    String check_not_select_enable(Selectpart selectpart,int select_part,String name,ArrayList<Integer> delete_part){
        int height=0;
        String info_delete_enable="";
        if(select_part==0){
            Casepart casepart = null;
            try {
                casepart = (Casepart) dbReader.execute("case", name).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            };

            if(selectpart.getMainboardpart()!=null&&selectpart.getMainboardpart().getStandard().equals("ATX")&&casepart.getStandard().equals("M-ATX")){
                info_delete_enable+=selectpart.getMainboardpart().getName()+"\n";
                delete_part.add(3);
            }
            if(selectpart.getCoolerpart()!=null){
                height=0;
                if(selectpart.getCoolerpart().getMethod().equals("공냉"))
                    height=casepart.getCooler_size();
                else
                    height=casepart.getRadiator_size();
                if(selectpart.getCoolerpart().getHeight()>height){
                    info_delete_enable+=selectpart.getCoolerpart().getName()+"\n";
                    delete_part.add(1);
                }
            }
            if(selectpart.getVgapart()!=null&&selectpart.getVgapart().getLength()>casepart.getVga_size()){
                info_delete_enable+=selectpart.getVgapart().getName()+"\n";
                delete_part.add(7);
            }
        }
        else if(select_part==1){
            Coolerpart coolerpart = null;

            try {
                coolerpart = (Coolerpart) dbReader.execute("cooler", name).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(selectpart.getCasepart()!=null){
                height=coolerpart.getHeight();
                if(coolerpart.getMethod().equals("공냉")){
                    if(height>selectpart.getCasepart().getCooler_size()){
                        info_delete_enable+=selectpart.getCasepart().getName()+"\n";
                        delete_part.add(0);
                    }
                }
                else{
                    if(height>selectpart.getCasepart().getRadiator_size()){
                        info_delete_enable+=selectpart.getCasepart().getName()+"\n";
                        delete_part.add(0);
                    }
                }
            }
        }
        else if(select_part==2){
            Cpupart cpupart = null;

            try {
                cpupart = (Cpupart) dbReader.execute("cpu", name).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(selectpart.getMainboardpart()!=null&&!(cpupart.getSocket().equals(selectpart.getMainboardpart().getSocket()))){
                info_delete_enable+=selectpart.getMainboardpart().getName()+"\n";
                delete_part.add(3);
            }
        }
        else if(select_part==3){
            Mainboardpart mainboardpart = null;

            try {
                mainboardpart = (Mainboardpart) dbReader.execute("mb", name).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(selectpart.getCpupart()!=null&&!(mainboardpart.getSocket().equals(selectpart.getCpupart().getSocket()))){
                info_delete_enable+=selectpart.getCpupart().getName()+"\n";
                delete_part.add(2);
            }
            if(selectpart.getCasepart()!=null&&(selectpart.getCasepart().getStandard().equals("M-ATX")&&mainboardpart.getStandard().equals("ATX"))){
                info_delete_enable+=selectpart.getCasepart().getName()+"\n";
                delete_part.add(0);
            }
        }
        else if(select_part==4){
            Powerpart powerpart = null;

            try {
                powerpart = (Powerpart) dbReader.execute("power", name).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(selectpart.getVgapart()!=null&&(selectpart.getVgapart().getPower()*2)>powerpart.getPower()){
                info_delete_enable+=selectpart.getVgapart().getName()+"\n";
                delete_part.add(7);
            }
        }
        else if(select_part==7){
            Vgapart vgapart = null;

            try {
                vgapart = (Vgapart) dbReader.execute("vga", name).get().get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(selectpart.getPowerpart()!=null&&selectpart.getPowerpart().getPower()<(vgapart.getPower()*2)){
                info_delete_enable+=selectpart.getPowerpart().getName()+"\n";
                delete_part.add(4);
            }
            if(selectpart.getCasepart()!=null&&selectpart.getCasepart().getVga_size()<vgapart.getLength()){
                info_delete_enable+=selectpart.getCasepart().getName()+"\n";
                delete_part.add(0);
            }
        }


        return info_delete_enable;
    }
}
