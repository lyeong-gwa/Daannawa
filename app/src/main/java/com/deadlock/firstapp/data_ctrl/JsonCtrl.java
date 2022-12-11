package com.deadlock.firstapp.data_ctrl;

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
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.connection.Server;
import com.mongodb.util.JSON;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JsonCtrl {
    private String url = BuildConfig.URL;
    private Selectpart temp = new Selectpart();

    public String select_jsonString(Selectpart selectpart, String token){
        JSONObject select = new JSONObject();

        try {
            if(selectpart.getCasepart()!=null)
                select.put("casepart",make_CASE_json(selectpart.getCasepart()));
            if(selectpart.getCoolerpart()!=null)
                select.put("coolerpart",make_COOLER_json(selectpart.getCoolerpart()));//////????
            if(selectpart.getCpupart()!=null)
                select.put("cpupart",make_CPU_json(selectpart.getCpupart()));
            if(selectpart.getMainboardpart()!=null)
                select.put("mainboardpart",make_MB_json(selectpart.getMainboardpart()));
            if(selectpart.getPowerpart()!=null)
                select.put("powerpart",make_POWER_json(selectpart.getPowerpart()));
            if(selectpart.getRampart()!=null)
                select.put("rampart",make_RAM_json(selectpart.getRampart()));
            if(selectpart.getStoragepart()!=null)
                select.put("storagepart",make_STORAGE_json(selectpart.getStoragepart()));
            if(selectpart.getVgapart()!=null)
                select.put("vgapart",make_GPU_json(selectpart.getVgapart()));

            select.put("user_token", token);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("server start");
                try {
                    OkHttpClient httpClient = new OkHttpClient();
                    RequestBody body = null;
                    Request request = null;
                    Response response = null;

                    body = RequestBody.create(
                            MediaType.parse("application/json; charset=utf-8"),
                            select.toString()
                    );

                    request = new Request.Builder().url(url + "user_list").post(body).build();

                    try {
                        response = httpClient.newCall(request).execute();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                    String jsonData = response.body().string();
//                    JSONObject object = new JSONObject(jsonData);
//                    JSONArray array = object.getJSONArray("result");

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return select.toString();
    }

    public Selectpart json_selectpart(String token) {


        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("server start");
                try {
                    OkHttpClient httpClient = new OkHttpClient();
                    RequestBody body = null;
                    Request request = null;
                    Response response = null;

                    body = new FormBody.Builder().add("token", token).build();

                    request = new Request.Builder().url(url + "user_list_get").post(body).build();

                    try {
                        response = httpClient.newCall(request).execute();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                    String jsonData = response.body().string();
                    if(!jsonData.equals("Failed")) {
                        System.out.println("Not Failed!!");
                        JSONObject jsonObject = new JSONObject(jsonData);
                        //System.out.println(jsonObject);
                        try {
                            if(jsonObject.has("casepart"))
                                temp.setCasepart(make_CASE_part(jsonObject.getJSONObject("casepart")));
                            if(jsonObject.has("coolerpart"))
                                temp.setCoolerpart(make_COOLER_part(jsonObject.getJSONObject("coolerpart")));
                            if(jsonObject.has("cpupart"))
                                temp.setCpupart(make_CPU_part(jsonObject.getJSONObject("cpupart")));
                            if(jsonObject.has("mainboardpart"))
                                temp.setMainboardpart(make_MB_part(jsonObject.getJSONObject("mainboardpart")));
                            if(jsonObject.has("powerpart"))
                                temp.setPowerpart(make_POWER_part(jsonObject.getJSONObject("powerpart")));
                            if(jsonObject.has("rampart"))
                                temp.setRampart(make_RAM_part(jsonObject.getJSONObject("rampart")));
                            if(jsonObject.has("storagepart"))
                                temp.setStoragepart(make_STORAGE_part(jsonObject.getJSONObject("storagepart")));
                            if(jsonObject.has("vgapart"))
                                temp.setVgapart(make_GPU_part(jsonObject.getJSONObject("vgapart")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(temp.getCpupart());
        return temp;
    }

    JSONObject make_CASE_json(Casepart casepart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("name",casepart.getName());
            temp.put("manufacturer",casepart.getManufacturer());
            temp.put("price",casepart.getPrice());
            temp.put("size",casepart.getSize());
            temp.put("standard",casepart.getStandard());
            temp.put("cooler_size",casepart.getCooler_size());
            temp.put("vga_size",casepart.getVga_size());
            temp.put("radiator_size",casepart.getRadiator_size());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
    JSONObject make_COOLER_json(Coolerpart coolerpart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("manufacturer",coolerpart.getManufacturer());
            temp.put("name",coolerpart.getName());
            temp.put("price",coolerpart.getPrice());
            temp.put("height",coolerpart.getHeight());
            temp.put("method",coolerpart.getMethod());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
    JSONObject make_CPU_json(Cpupart cpupart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("manufacturer",cpupart.getManufacturer());
            temp.put("name",cpupart.getName());
            temp.put("price",cpupart.getPrice());
            temp.put("socket",cpupart.getSocket());
            temp.put("core",cpupart.getCore());
            temp.put("thread",cpupart.getThread());
            temp.put("clock",String.valueOf(cpupart.getClock()));
            temp.put("graphic",cpupart.getGraphic());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
    JSONObject make_GPU_json(Vgapart vgapart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("manufacturer",vgapart.getManufacturer());
            temp.put("name",vgapart.getName());
            temp.put("price",vgapart.getPrice());
            temp.put("chipset",vgapart.getChipset());
            temp.put("gddr",vgapart.getGddr());
            temp.put("length",vgapart.getLength());
            temp.put("power",vgapart.getPower());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
    JSONObject make_MB_json(Mainboardpart mainboardpart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("manufacturer",mainboardpart.getManufacturer());
            temp.put("name",mainboardpart.getName());
            temp.put("price",mainboardpart.getPrice());
            temp.put("standard",mainboardpart.getStandard());
            temp.put("socket",mainboardpart.getSocket());
            temp.put("chipset",mainboardpart.getChipset());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
    JSONObject make_POWER_json(Powerpart powerpart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("manufacturer",powerpart.getManufacturer());
            temp.put("powercol",powerpart.getPowercol());
            temp.put("name",powerpart.getName());
            temp.put("price",powerpart.getPrice());
            temp.put("power",powerpart.getPower());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
    JSONObject make_RAM_json(Rampart rampart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("manufacturer",rampart.getManufacturer());
            temp.put("name",rampart.getName());
            temp.put("price",rampart.getPrice());
            temp.put("capacity",rampart.getCapacity());
            temp.put("clock",rampart.getClock());
            temp.put("set",rampart.getSet());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }
    JSONObject make_STORAGE_json(Storagepart storagepart){
        JSONObject temp=new JSONObject();
        try {
            temp.put("manufacturer",storagepart.getManufacturer());
            temp.put("name",storagepart.getName());
            temp.put("price",storagepart.getPrice());
            temp.put("type",storagepart.getType());
            temp.put("capacity",storagepart.getCapacity());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return temp;
    }

    Casepart make_CASE_part(JSONObject jsonObject){
        Casepart temp=new Casepart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setSize(jsonObject.getString("size"));
            temp.setStandard(jsonObject.getString("standard"));
            temp.setCooler_size(jsonObject.getInt("cooler_size"));
            temp.setVga_size(jsonObject.getInt("vga_size"));
            temp.setRadiator_size(jsonObject.getInt("radiator_size"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
    Coolerpart make_COOLER_part(JSONObject jsonObject){
        Coolerpart temp=new Coolerpart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setHeight(jsonObject.getInt("height"));
            temp.setMethod(jsonObject.getString("method"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
    Cpupart make_CPU_part(JSONObject jsonObject){
        Cpupart temp=new Cpupart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setSocket(jsonObject.getString("socket"));
            temp.setCore(jsonObject.getInt("core"));
            temp.setThread(jsonObject.getInt("thread"));
            temp.setClock(Float.parseFloat(jsonObject.getString("clock")));
            temp.setGraphic(jsonObject.getBoolean("graphic"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return temp;
    }
    Vgapart make_GPU_part(JSONObject jsonObject){
        Vgapart temp=new Vgapart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setChipset(jsonObject.getString("chipset"));
            temp.setGddr(jsonObject.getInt("gddr"));
            temp.setLength(jsonObject.getInt("length"));
            temp.setPower(jsonObject.getInt("power"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
    Mainboardpart make_MB_part(JSONObject jsonObject){
        Mainboardpart temp=new Mainboardpart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setStandard(jsonObject.getString("standard"));
            temp.setSocket(jsonObject.getString("socket"));
            temp.setChipset(jsonObject.getString("chipset"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
    Powerpart make_POWER_part(JSONObject jsonObject){
        Powerpart temp=new Powerpart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPowercol(jsonObject.getString("powercol"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setPower(jsonObject.getInt("power"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
    Rampart make_RAM_part(JSONObject jsonObject){
        Rampart temp=new Rampart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setCapacity(jsonObject.getInt("capacity"));
            temp.setClock(jsonObject.getInt("clock"));
            temp.setSet(jsonObject.getInt("set"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
    Storagepart make_STORAGE_part(JSONObject jsonObject){
        Storagepart temp=new Storagepart();
        try {
            temp.setManufacturer(jsonObject.getString("manufacturer"));
            temp.setName(jsonObject.getString("name"));
            temp.setPrice(jsonObject.getInt("price"));
            temp.setType(jsonObject.getString("type"));
            temp.setCapacity(jsonObject.getString("capacity"));
            temp.setChoice_enable(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
