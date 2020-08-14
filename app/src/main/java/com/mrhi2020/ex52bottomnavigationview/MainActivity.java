package com.mrhi2020.ex52bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    FragmentManager fragmentManager;

    Fragment[] fragments= new Fragment[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트의 동적 추가/삭제/제거를 위해 관리자 객체 소환
        fragmentManager= getSupportFragmentManager();

        //각 탭 화면 프레그먼트 객체 생성
        fragments[0]= new Tab1Fragment();
        fragments[1]= new Tab2Fragment();
        fragments[2]= new Tab3Fragment();
        fragments[3]= new Tab4Fragment();

        //첫번재 탭 화면 붙이는 작업
        FragmentTransaction tran= fragmentManager.beginTransaction();
        tran.add(R.id.container, fragments[0]);
        tran.commit();



        bnv= findViewById(R.id.bottom_nav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //프레그먼트 작업 트랜잭션 시작
                FragmentTransaction tran= fragmentManager.beginTransaction();

                switch ( menuItem.getItemId() ){
                    case R.id.menu_aa:
                        tran.replace(R.id.container, fragments[0]);
                        break;

                    case R.id.menu_bb:
                        tran.replace(R.id.container, fragments[1]);
                        break;

                    case R.id.menu_cc:
                        tran.replace(R.id.container, fragments[2]);
                        break;

                    case R.id.menu_dd:
                        tran.replace(R.id.container, fragments[3]);
                        break;
                }

                //트랙잭션 작업 완료 명령
                tran.commit();

                //return true가 아니면 선택은 되지만 선택효과가 이동하지 않음
                return true;
            }
        });
    }
}
