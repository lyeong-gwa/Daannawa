package com.deadlock.firstapp.activity;

import com.deadlock.firstapp.data_ctrl.JsonCtrl;
import com.deadlock.firstapp.fragment.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.deadlock.firstapp.R;
import com.deadlock.firstapp.part.Selectpart;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {
    public static final String PREF = "Save";
    public volatile Selectpart selectpart; //?

    private TextView text_name;
    private ImageView image_profile;

    private Fragment fragment_cpu;
    private Fragment fragment_cooler;
    private Fragment fragment_mb;
    private Fragment fragment_ram;
    private Fragment fragment_gpu;
    private Fragment fragment_ps;
    private Fragment fragment_case;
    private Fragment fragment_storage;

    private Fragment fragment_recommend;

    private Fragment fragment_cart;

    private Fragment fragment_map;

    private Toolbar toolbar;

    private String name;
    private String profile;
    private String email;
    private String token;

    public TabLayout tabLayout;

    private TabLayout.OnTabSelectedListener listener, listener2;

    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
    private static final int PERMISSIONS_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        text_name = (TextView)findViewById(R.id.text_name);
        image_profile = (ImageView)findViewById(R.id.image_profile);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        profile = intent.getStringExtra("profile");
        email = intent.getStringExtra("email");
        token = intent.getStringExtra("token");

        if(savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            profile = savedInstanceState.getString("profile");
            email = savedInstanceState.getString("email");
            token = intent.getStringExtra("token");
        }

        text_name.setText(name + " 님");
        Glide.with(this).load(profile).into(image_profile);

        int hasFineLocationPermission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
        );
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
        );

        if(hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {

        } else {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {
                Toast.makeText(this, "위치 권한 필요", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE);
            } else {
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE);
            }
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        selectpart = new Selectpart(); //?

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment_cpu = new CPU();
        fragment_cooler = new Cooler();
        fragment_mb = new MB();
        fragment_ram = new Ram();
        fragment_gpu = new GPU();
        fragment_ps = new PS();
        fragment_case = new Case();
        fragment_storage = new Storage();

        fragment_recommend = new RecommendFragment();

        fragment_cart = new CartFragment();

        fragment_map = new MapFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment_cpu).commit();

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("CPU"));
        tabLayout.addTab(tabLayout.newTab().setText("Cooler"));
        tabLayout.addTab(tabLayout.newTab().setText("M/B"));
        tabLayout.addTab(tabLayout.newTab().setText("RAM"));
        tabLayout.addTab(tabLayout.newTab().setText("GPU"));
        tabLayout.addTab(tabLayout.newTab().setText("P/S"));
        tabLayout.addTab(tabLayout.newTab().setText("Case"));
        tabLayout.addTab(tabLayout.newTab().setText("Storage"));

        listener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
//                Toast.makeText(getApplication(), "선택된 탭: " + position, Toast.LENGTH_SHORT).show();

                Fragment selected = null;
                switch(position) {
                    case 0:
                        selected = fragment_cpu;
                        break;

                    case 1:
                        selected = fragment_cooler;
                        break;

                    case 2:
                        selected = fragment_mb;
                        break;

                    case 3:
                        selected = fragment_ram;
                        break;

                    case 4:
                        selected = fragment_gpu;
                        break;

                    case 5:
                        selected = fragment_ps;
                        break;

                    case 6:
                        selected = fragment_case;
                        break;

                    case 7:
                        selected = fragment_storage;
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MenuActivity.this);
                alertDialogBuilder.setTitle("Info");

                switch(position) {
                    case 0:
                        alertDialogBuilder.setMessage(
                                "CPU: Central Processing Unit \n" +
                                "설명: 컴퓨터의 가장 중요 부품으로 프로그램의 명령(기억, 연산, 제어)을 해독하여 실행하는 장치로 중앙처리장치 입니다.\n" +
                                "쉬운설명: 사람의 뇌\n" +
                                "\t코어\n" +
                                "\t설명: CPU를 물리적으로 구별한 것으로, 코어 안에서 모든 컴퓨터의 연산을 할 수 있다. 코어가 많을수록 많은 일을 동시에 하는게 가능하다\n" +
                                "\t쉬운설명: 옥수수 공장 수  \n" +
                                "\t\n" +
                                "\t쓰레드\n" +
                                "\t설명: 코어와 마찬가지로, CPU를 여러 종류로 분리해준다. 차이점은 CPU를 논리적으로 구별한다. \n" +
                                "\t쉬운설명: 옥수수 공장의 인부의 수"
                        );
                        break;

                    case 1:
                        alertDialogBuilder.setMessage(
                                "쿨러(Cooler)\n" +
                                "설명: 컴퓨터 각 부품의 발열 온도를 낮추어주는 역할을 한다. CPU와 VGA에 사용한다.\n" +
                                "쉬운설명: 공장 안 선풍기, 에어컨\n" +
                                "\t수냉 \n" +
                                "\t설명: 물로 냉각하는 방식\n" +
                                "\t쉬운설명: 에어컨\n" +
                                "\t공냉 \n" +
                                "\t설명: 공기로 냉각하는 방식\n" +
                                "\t쉬운설명: 선풍기"
                        );
                        break;

                    case 2:
                        alertDialogBuilder.setMessage(
                                "메인보드(마더보드, Mainboard)\n" +
                                "설명: CPU, 메모리, 그래픽카드, 파워, 쿨러 등의 모든 컴퓨터 부품들이 장착되어 한 몸이 되는 기판이다.\n" +
                                "쉬운설명: 장기(부품)가 들어가는 사람의 몸"
                        );
                        break;

                    case 3:
                        alertDialogBuilder.setMessage(
                                "메모리(램, RAM): Random Access Memories\n" +
                                "설명: 주 기억장치로, 사용자가 자유롭게 내용을 읽고 쓰고 지울 수 있다. 컴퓨터가 켜지는 순간부터 CPU 동작에 필요한 모든 내용이 전원이 유지되는 내내 이 기억장치에 저장된다.\n" +
                                "쉬운설명: 인부들이 사용하는 리어카"
                        );
                        break;

                    case 4:
                        alertDialogBuilder.setMessage(
                                "그래픽카드(VGA) : Video Graphics Array\n" +
                                "설명: 비디오 해상도를 결정해주는 장치로, CPU의 명령하에 이루어지는 그래픽 작업을 전문적으로 빠르게 처리하고 디지털 신호를 영상 신호로 바꿔 모니터로 전송하는 장치다.\n" +
                                "쉬운설명: 옥수수 말고 다른거 시킬 인부, 옥수수 공장에서 일 잘 못함, 감자 공장일은 잘한다. "
                        );
                        break;

                    case 5:
                        alertDialogBuilder.setMessage(
                                "파워(Power supply)\n" +
                                "설명: 각 부품에 전력을 공급하는 장치로 해당 파워 처리능력보다 많은 전력을 사용하면 부하가 걸린다. 파워에 여유가 있어야 컴퓨터가 안정적으로 구동된다.\n" +
                                "쉬운설명: 인부들에게 주는 월급"
                        );
                        break;

                    case 6:
                        alertDialogBuilder.setMessage(
                                "케이스(Case)\n" +
                                "설명: 컴퓨터 부품을 안전하게 보호하고 각 부품들의 발열량으로 내부 온도가 높아지는데 쿨링시스템이 좋은 케이스는 내부 온도를 낮추는 역할의 중요한 장치이다.\n" +
                                "쉬운설명: 입는 옷"
                        );
                        break;

                    case 7:
                        alertDialogBuilder.setMessage(
                                "하드디스크(Hard Disk Drive, HDD)\n" +
                                "설명: 보조기억장치로 윈도우, 각종 프로그램을 설치하는 공간, 물리적으로 움직여서 속도의 한계가 있음\n" +
                                "쉬운설명: 옥수수 저장창고\n" +
                                "\n" +
                                "SSD(Solid State Drive) \n" +
                                "설명: 보조기억장치이며, 반도체 메모리로 데이터를 처리하므로 물리적인 접촉을 하는 HDD에 비해 속도가 매우빠름\n" +
                                "쉬운설명: 최신식 좋은 옥수수 저장창고"
                        );
                        break;
                }

                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        };

        listener2 = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch(position) {
                    case 1:
                        JsonCtrl jsonCtrl = new JsonCtrl();
                        jsonCtrl.select_jsonString(selectpart, token);
                        Toast.makeText(MenuActivity.this, "성공적으로 저장하였습니다.", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        selectpart = new Selectpart();
                        getSupportFragmentManager().beginTransaction()
                                .detach(fragment_cart).commit();
                        getSupportFragmentManager().beginTransaction()
                                .attach(fragment_cart).commit();
                        break;

                    case 2:
                        JsonCtrl jsonCtrl2 = new JsonCtrl();
                        if((selectpart = jsonCtrl2.json_selectpart(token)) != null) {
                            System.out.println(selectpart);

                            getSupportFragmentManager().beginTransaction()
                                    .detach(fragment_cart).commit();
                            getSupportFragmentManager().beginTransaction()
                                    .attach(fragment_cart).commit();
                        } else {
                            Toast.makeText(MenuActivity.this, "저장된 견적이 없습니다!", Toast.LENGTH_SHORT).show();
                        }

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };

        tabLayout.addOnTabSelectedListener(listener);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.my:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_cpu).commit();
                        tabLayout.removeAllTabs();
                        tabLayout.removeOnTabSelectedListener(listener);
                        tabLayout.removeOnTabSelectedListener(listener2);
                        tabLayout.addTab(tabLayout.newTab().setText("CPU"));
                        tabLayout.addTab(tabLayout.newTab().setText("Cooler"));
                        tabLayout.addTab(tabLayout.newTab().setText("M/B"));
                        tabLayout.addTab(tabLayout.newTab().setText("RAM"));
                        tabLayout.addTab(tabLayout.newTab().setText("GPU"));
                        tabLayout.addTab(tabLayout.newTab().setText("P/S"));
                        tabLayout.addTab(tabLayout.newTab().setText("Case"));
                        tabLayout.addTab(tabLayout.newTab().setText("Storage"));
                        tabLayout.addOnTabSelectedListener(listener);

                        return true;

                    case R.id.recommend:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_recommend).commit();
                        tabLayout.removeAllTabs();
                        tabLayout.removeOnTabSelectedListener(listener);
                        tabLayout.removeOnTabSelectedListener(listener2);
                        tabLayout.addTab(tabLayout.newTab().setText("조건"));
                        return true;

                    case R.id.save:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_cart).commit();
                        tabLayout.removeAllTabs();
                        tabLayout.removeOnTabSelectedListener(listener);
                        tabLayout.removeOnTabSelectedListener(listener2);
                        tabLayout.addTab(tabLayout.newTab().setText("장바구니"));
                        tabLayout.addTab(tabLayout.newTab().setText("견적 저장"));
                        tabLayout.addTab(tabLayout.newTab().setText("견적 불러오기"));
                        tabLayout.addTab(tabLayout.newTab().setText("견적 초기화"));
                        tabLayout.addTab(tabLayout.newTab().setText("합계: "));
                        tabLayout.addOnTabSelectedListener(listener2);
                        return true;

                    case R.id.map:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, fragment_map).commit();

                        tabLayout.removeOnTabSelectedListener(listener);
                        tabLayout.removeOnTabSelectedListener(listener2);
                        tabLayout.removeAllTabs();
                        tabLayout.addTab(tabLayout.newTab().setText("현위치"));
                        tabLayout.addTab(tabLayout.newTab().setText("찾기"));

                        return true;
                }

                return false;
            }
        });

        navigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause()");
        SharedPreferences preferences = getSharedPreferences(PREF, 0);
        SharedPreferences.Editor editor = preferences.edit();
        if(name != null && profile != null & email != null) {
            editor.putString("name", name);
            editor.putString("profile", profile);
            editor.putString("email", email);
            editor.putString("token", token);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(PREF, 0);
        if((preferences != null) && (preferences.contains("name"))) {
            name = preferences.getString("name", "");
            profile = preferences.getString("profile", "");
            email = preferences.getString("email", "");
            token = preferences.getString("token", "");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(name != null && profile != null & email != null) {
            outState.putString("name", name);
            outState.putString("profile", profile);
            outState.putString("email", email);
            outState.putString("token", token);
        }
    }
}