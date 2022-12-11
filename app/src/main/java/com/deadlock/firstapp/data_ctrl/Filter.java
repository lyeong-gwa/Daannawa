package com.deadlock.firstapp.data_ctrl;

import android.content.Context;


import androidx.fragment.app.ListFragment;

import com.deadlock.firstapp.part.Casepart;
import com.deadlock.firstapp.part.Coolerpart;
import com.deadlock.firstapp.part.Cpupart;
import com.deadlock.firstapp.part.Mainboardpart;
import com.deadlock.firstapp.part.Powerpart;
import com.deadlock.firstapp.part.Rampart;
import com.deadlock.firstapp.part.Selectpart;
import com.deadlock.firstapp.part.Storagepart;
import com.deadlock.firstapp.part.Vgapart;

import java.util.ArrayList;

public class Filter {
    DBReader dbreader;

    public ArrayList<Casepart> filter_case(Context context, Selectpart selectpart){
        dbreader=new DBReader(context);
        ArrayList<Casepart> temp = null;

        try {
            temp = dbreader.execute("case").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(selectpart.getMainboardpart()!=null);
        if(selectpart.getMainboardpart()!=null){

            for(int i=0;i<temp.size();i++){
                if(selectpart.getMainboardpart().getStandard().equals("ATX")&&temp.get(i).getStandard().equals("M-ATX")&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }
        }

        if(selectpart.getCoolerpart()!=null){
            for(int i=0;i<temp.size();i++){
                int height=0;
                if(selectpart.getCoolerpart().getMethod().equals("공냉"))
                    height=temp.get(i).getCooler_size();
                else
                    height=temp.get(i).getRadiator_size();
                if(selectpart.getCoolerpart().getHeight()>height&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }

            }

        }

        if(selectpart.getVgapart()!=null){
            for(int i=0;i<temp.size();i++){
                if(selectpart.getVgapart().getLength()>temp.get(i).getVga_size()&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }

        }

        return temp;
    }

    public ArrayList<Coolerpart> filter_cooler(Context context, Selectpart selectpart){
        dbreader=new DBReader(context);
        ArrayList<Coolerpart> temp = null;

        try {
            System.out.println("test 중입니다");
            temp = dbreader.execute("cooler").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(selectpart.getCasepart()!=null){
            for(int i=0;i<temp.size();i++){
                int height=temp.get(i).getHeight();
                if(temp.get(i).getMethod().equals("공냉")){
                    if(height>selectpart.getCasepart().getCooler_size()&&temp.get(i).getChoice_enable()){
                        temp.get(i).setChoice_enable(false);
                        temp.add(temp.get(i));
                        temp.remove(i);
                        i--;

                    }
                }
                else{
                    if(height>selectpart.getCasepart().getRadiator_size()&&temp.get(i).getChoice_enable()){
                        temp.get(i).setChoice_enable(false);
                        temp.add(temp.get(i));
                        temp.remove(i);
                        i--;

                    }
                }
            }
        }

        return temp;
    }

    public ArrayList<Cpupart> filter_cpu(Context context, Selectpart selectpart){
        dbreader = new DBReader(context);
        ArrayList<Cpupart> temp = null;

        try {
            temp = dbreader.execute("cpu").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(selectpart != null && selectpart.getMainboardpart()!=null){
            for(int i=0;i<temp.size();i++){
                if(!(temp.get(i).getSocket().equals(selectpart.getMainboardpart().getSocket()))&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }
        }

        return temp;
    }

    public ArrayList<Mainboardpart> filter_mb(Context context, Selectpart selectpart){
        dbreader = new DBReader(context);
        ArrayList<Mainboardpart> temp = null;

        try {
            temp = dbreader.execute("mb").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(selectpart.getCpupart()!=null){
            for(int i=0;i<temp.size();i++){
                if(!(temp.get(i).getSocket().equals(selectpart.getCpupart().getSocket()))&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }
        }

        if(selectpart.getCasepart()!=null){
            for(int i=0;i<temp.size();i++){
                if(selectpart.getCasepart().getStandard().equals("M-ATX")&&temp.get(i).getStandard().equals("ATX")&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }
        }
        return temp;
    }

    public ArrayList<Powerpart> filter_ps(Context context, Selectpart selectpart){
        dbreader=new DBReader(context);
        ArrayList<Powerpart> temp = null;

        try {
            temp = dbreader.execute("power").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(selectpart.getVgapart()!=null){
            for(int i=0;i<temp.size();i++){
                if((selectpart.getVgapart().getPower()*2)>temp.get(i).getPower()&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }
        }
        return temp;
    }

    public ArrayList<Rampart> filter_ram(Context context, Selectpart selectpart){
        dbreader = new DBReader(context);
        ArrayList<Rampart> temp = null;

        try {
            temp = dbreader.execute("ram").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return temp;
    }

    public ArrayList<Storagepart> filter_storage(Context context, Selectpart selectpart){
        dbreader = new DBReader(context);
        ArrayList<Storagepart> temp = null;

        try {
            temp = dbreader.execute("storage").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return temp;
    }

    public ArrayList<Vgapart> filter_vga(Context context, Selectpart selectpart){
        dbreader=new DBReader(context);
        ArrayList<Vgapart> temp = null;

        try {
            temp = dbreader.execute("vga").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(selectpart.getPowerpart()!=null){
            for(int i=0;i<temp.size();i++){
                if(selectpart.getPowerpart().getPower()<(temp.get(i).getPower()*2)&&temp.get(i).getChoice_enable()){
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }

        }

        if(selectpart.getCasepart()!=null){
            for(int i=0;i<temp.size();i++){
                if(selectpart.getCasepart().getVga_size()<temp.get(i).getLength()&&temp.get(i).getChoice_enable()){
                    System.out.println(selectpart.getCasepart().getVga_size()+"/"+temp.get(i).getLength());
                    temp.get(i).setChoice_enable(false);
                    temp.add(temp.get(i));
                    temp.remove(i);
                    i--;

                }
            }

        }
        return temp;
    }
}