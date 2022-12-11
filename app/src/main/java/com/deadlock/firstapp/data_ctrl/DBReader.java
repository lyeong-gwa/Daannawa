package com.deadlock.firstapp.data_ctrl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.deadlock.firstapp.BuildConfig;
import com.deadlock.firstapp.part.Casepart;
import com.deadlock.firstapp.part.Coolerpart;
import com.deadlock.firstapp.part.Cpupart;
import com.deadlock.firstapp.part.Mainboardpart;
import com.deadlock.firstapp.part.Powerpart;
import com.deadlock.firstapp.part.Rampart;
import com.deadlock.firstapp.part.Selectpart;
import com.deadlock.firstapp.part.Storagepart;
import com.deadlock.firstapp.part.Vgapart;
import com.google.android.gms.common.util.Strings;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DBReader extends AsyncTask<String, Void, ArrayList> {
    SQLiteDatabase db;
    private String url = BuildConfig.URL;

    Object temporary = null;

    @Override
    protected ArrayList doInBackground(String... strings) {
        if(strings[0].equals("cpu")) {
            ArrayList<Cpupart> temp = new ArrayList<>();
            url += "cpu";
            System.out.println(url);
            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if(strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if(body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                try {
                    response = httpClient.newCall(request).execute();
                } catch(Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for(int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Cpupart cpupart = new Cpupart();
                    cpupart.setManufacturer(jsonObject.getString("manufacturer"));
                    cpupart.setName(jsonObject.getString("name"));
                    cpupart.setPrice(jsonObject.getInt("price"));
                    cpupart.setSocket(jsonObject.getString("socket"));
                    cpupart.setCore(jsonObject.getInt("core"));
                    cpupart.setThread(jsonObject.getInt("thread"));
                    cpupart.setClock((float) jsonObject.getDouble("clock"));
                    cpupart.setGraphic((jsonObject.getInt("graphic") == 1));
                    temp.add(cpupart);
                }

                temporary = temp;

                return temp;

            } catch(Exception e) {
                e.printStackTrace();
            }

        } else if(strings[0].equals("mb")) {
            ArrayList<Mainboardpart> temp = new ArrayList<>();
            url += "mb";

            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if(strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if(body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                try {
                    response = httpClient.newCall(request).execute();
                } catch(Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for(int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Mainboardpart mainboardpart = new Mainboardpart();
                    mainboardpart.setManufacturer(jsonObject.getString("manufacturer"));
                    mainboardpart.setName(jsonObject.getString("name"));
                    mainboardpart.setPrice(jsonObject.getInt("price"));
                    mainboardpart.setStandard(jsonObject.getString("standard"));
                    mainboardpart.setSocket(jsonObject.getString("socket"));
                    mainboardpart.setChipset(jsonObject.getString("chipset"));
                    temp.add(mainboardpart);
                }

                temporary = temp;
                return temp;

            } catch(Exception e) {
                e.printStackTrace();
            }

        } else if(strings[0].equals("cooler")) {
            ArrayList<Coolerpart> temp = new ArrayList<>();
            url += "cooler";

            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if(strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if(body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                System.out.println(request);

                try {
                    response = httpClient.newCall(request).execute();
                } catch(Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for(int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Coolerpart coolerpart=new Coolerpart();
                    coolerpart.setManufacturer(jsonObject.getString("manufacturer"));
                    coolerpart.setName(jsonObject.getString("name"));
                    coolerpart.setPrice(jsonObject.getInt("price"));
                    coolerpart.setHeight(jsonObject.getInt("height"));
                    coolerpart.setMethod(jsonObject.getString("method"));
                    temp.add(coolerpart);
                }

                return temp;

            } catch(Exception e) {
                e.printStackTrace();
            }

        } else if(strings[0].equals("case")) {
            ArrayList<Casepart> temp = new ArrayList<>();
            url += "case";

            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if (strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if (body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                try {
                    response = httpClient.newCall(request).execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Casepart casepart=new Casepart();
                    casepart.setManufacturer(jsonObject.getString("manufacturer"));
                    casepart.setName(jsonObject.getString("name"));
                    casepart.setPrice(jsonObject.getInt("price"));
                    casepart.setSize(jsonObject.getString("size"));
                    casepart.setStandard(jsonObject.getString("standard"));
                    casepart.setCooler_size(jsonObject.getInt("cooler_size"));
                    casepart.setVga_size(jsonObject.getInt("vga_size"));
                    casepart.setRadiator_size(jsonObject.getInt("radiator_size"));
                    temp.add(casepart);
                }

                System.out.println("test");

                return temp;

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(strings[0].equals("power")) {
            ArrayList<Powerpart> temp = new ArrayList<>();
            url += "power";

            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if (strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if (body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                try {
                    response = httpClient.newCall(request).execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Powerpart powerpart=new Powerpart();
                    powerpart.setPowercol(jsonObject.getString("powercol"));
                    powerpart.setManufacturer(jsonObject.getString("manufacturer"));
                    powerpart.setName(jsonObject.getString("name"));
                    powerpart.setPrice(jsonObject.getInt("price"));
                    powerpart.setPower(jsonObject.getInt("power"));
                    temp.add(powerpart);
                }

                return temp;

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(strings[0].equals("vga")) {
            ArrayList<Vgapart> temp = new ArrayList<>();
            url += "vga";

            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if (strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if (body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                try {
                    response = httpClient.newCall(request).execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Vgapart vgapart=new Vgapart();
                    vgapart.setManufacturer(jsonObject.getString("manufacturer"));
                    vgapart.setName(jsonObject.getString("name"));
                    vgapart.setPrice(jsonObject.getInt("price"));
                    vgapart.setChipset(jsonObject.getString("chipset"));
                    vgapart.setGddr(jsonObject.getInt("gddr"));
                    vgapart.setLength(jsonObject.getInt("length"));
                    vgapart.setPower(jsonObject.getInt("power"));
                    temp.add(vgapart);
                }

                return temp;

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(strings[0].equals("ram")) {
            ArrayList<Rampart> temp = new ArrayList<>();
            url += "ram";

            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if (strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if (body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                try {
                    response = httpClient.newCall(request).execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Rampart rampart=new Rampart();
                    rampart.setManufacturer(jsonObject.getString("manufacturer"));
                    rampart.setName(jsonObject.getString("name"));
                    rampart.setPrice(jsonObject.getInt("price"));
                    rampart.setCapacity(jsonObject.getInt("capacity"));
                    rampart.setClock(jsonObject.getInt("clock"));
                    temp.add(rampart);
                }

                return temp;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }  else if(strings[0].equals("storage")) {
            ArrayList<Storagepart> temp = new ArrayList<>();
            url += "storage";

            try {
                OkHttpClient httpClient = new OkHttpClient();
                RequestBody body = null;
                Request request = null;
                Response response = null;

                if (strings.length > 1) {
                    body = new FormBody.Builder().add("name", strings[1]).build();
                }

                if (body == null) {
                    request = new Request.Builder().url(url).build();
                } else {
                    request = new Request.Builder().url(url).post(body).build();
                }

                try {
                    response = httpClient.newCall(request).execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String jsonData = response.body().string();
                JSONObject object = new JSONObject(jsonData);
                JSONArray array = object.getJSONArray("result");

                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Storagepart storagepart=new Storagepart();
                    storagepart.setManufacturer(jsonObject.getString("manufacturer"));
                    storagepart.setName(jsonObject.getString("name"));
                    storagepart.setPrice(jsonObject.getInt("price"));
                    storagepart.setType(jsonObject.getString("type"));
                    storagepart.setCapacity(jsonObject.getString("capacity"));
                    temp.add(storagepart);
                }

                return temp;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return (ArrayList) temporary;
    }

    public DBReader(Context context){
    }

    public DBReader() {
    }

    public void reset(Selectpart selectpart, int i){
        if(i==0) {

            if(selectpart.getMainboardpart()!=null&&selectpart.getMainboardpart().getStandard().equals("ATX")&&selectpart.getCasepart().getStandard().equals("M-ATX")){
                selectpart.setMainboardpart(null);
            }
            if(selectpart.getCoolerpart()!=null){
                int height=0;
                if(selectpart.getCoolerpart().getMethod().equals("공냉"))
                    height=selectpart.getCasepart().getCooler_size();
                else
                    height=selectpart.getCasepart().getRadiator_size();
                if(selectpart.getCoolerpart().getHeight()>height){
                    selectpart.setCoolerpart(null);
                }
            }
            if(selectpart.getVgapart()!=null){
                if(selectpart.getVgapart().getLength()>selectpart.getCasepart().getVga_size()){
                    selectpart.setVgapart(null);
                }
            }

        }
        if(i==1){
            if(selectpart.getCasepart()!=null) {
                int height = selectpart.getCoolerpart().getHeight();
                if (selectpart.getCoolerpart().getMethod().equals("공냉")) {
                    if (height > selectpart.getCasepart().getCooler_size()) {
                        selectpart.setCasepart(null);
                    }
                } else {
                    if (height > selectpart.getCasepart().getRadiator_size()) {
                        selectpart.setCasepart(null);
                    }
                }
            }
        }
        if(i==2){
            if(selectpart.getMainboardpart()!=null){
                if(!(selectpart.getCpupart().getSocket().equals(selectpart.getMainboardpart().getSocket()))){
                    selectpart.setMainboardpart(null);
                }
            }
        }
        if(i==3){
            if(selectpart.getCpupart()!=null){
                if(!(selectpart.getMainboardpart().getSocket().equals(selectpart.getCpupart().getSocket()))){
                    selectpart.setCpupart(null);
                }
            }
            if(selectpart.getCasepart()!=null){
                if(selectpart.getCasepart().getStandard().equals("M-ATX")&&selectpart.getMainboardpart().getStandard().equals("ATX")){
                    selectpart.setCasepart(null);
                }
            }
        }
        if(i==4){
            if(selectpart.getVgapart()!=null){
                if((selectpart.getVgapart().getPower()*2)>selectpart.getPowerpart().getPower()){
                    selectpart.setVgapart(null);
                }
            }
        }
        if(i==7){
            if(selectpart.getPowerpart()!=null){
                if(selectpart.getPowerpart().getPower()<(selectpart.getVgapart().getPower()*2)){
                    selectpart.setPowerpart(null);
                }
            }
            if(selectpart.getCasepart()!=null){
                if(selectpart.getCasepart().getVga_size()<selectpart.getVgapart().getLength()){
                    selectpart.setCasepart(null);
                }
            }
        }
    }
}

