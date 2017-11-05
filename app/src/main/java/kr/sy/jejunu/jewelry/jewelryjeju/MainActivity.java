package kr.sy.jejunu.jewelry.jewelryjeju;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import kr.sy.jejunu.jewelry.jewelryjeju.double_list_fragment.DoubleListFragment;
import kr.sy.jejunu.jewelry.jewelryjeju.viewpager.LoopViewPagerFragment;

/**
 * Created by Osy on 2017-10-28.
 */

public class MainActivity extends AppCompatActivity {
    private int position;
    private Fragment introduceFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentInit();
        spinnerInit();

        final TextView feedWater = (TextView) findViewById(R.id.feed_water);
        final TextView dance = (TextView) findViewById(R.id.dance);
        final TextView explain = (TextView) findViewById(R.id.explain);
        final LinearLayout explainLayout = (LinearLayout) findViewById(R.id.explain_layout);

        final ImageView kkuri = (ImageView)findViewById(R.id.kkuri_button);
        Button introduceClear = (Button)findViewById(R.id.introduce_clear);

        kkuri.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( feedWater.getVisibility() == View.INVISIBLE){
                    feedWater.setVisibility(View.VISIBLE);
                    dance.setVisibility(View.VISIBLE);
                    explain.setVisibility(View.VISIBLE);
                }
                else {
                    feedWater.setVisibility(View.INVISIBLE);
                    dance.setVisibility(View.INVISIBLE);
                    explain.setVisibility(View.INVISIBLE);
                }
            }
        });

        final ArrayList<Integer> danceImgList = new ArrayList();
        danceImgList.add( R.drawable.kkury1);
        danceImgList.add( R.drawable.kkury2);
        danceImgList.add( R.drawable.kkury3);
        danceImgList.add( R.drawable.kkury4);

        final ArrayList<Integer> flowerImgList = new ArrayList();
        flowerImgList.add( R.drawable.kkury_flower2);
        flowerImgList.add( R.drawable.kkury_flower3);
        flowerImgList.add( R.drawable.kkury_flower4);
        flowerImgList.add( R.drawable.kkury_flower5);
        flowerImgList.add( R.drawable.kkury_flower6);
        flowerImgList.add( R.drawable.kkury_flower7);
        flowerImgList.add( R.drawable.kkury_flower8);

        dance.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0 ; i < danceImgList.size() ; i++){
                    kkuri.setBackgroundResource( danceImgList.get(i));
                }
                feedWater.setVisibility(View.INVISIBLE);
                dance.setVisibility(View.INVISIBLE);
                explain.setVisibility(View.INVISIBLE);
            }
        });
        feedWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0 ; i < flowerImgList.size() ; i++){
                    kkuri.setBackgroundResource( flowerImgList.get(i));
                }
                feedWater.setVisibility(View.INVISIBLE);
                dance.setVisibility(View.INVISIBLE);
                explain.setVisibility(View.INVISIBLE);
            }
        });
        explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kkuri.setBackgroundResource( R.drawable.teacher_kkury);
                explainLayout.setVisibility(View.VISIBLE);

                feedWater.setVisibility(View.INVISIBLE);
                dance.setVisibility(View.INVISIBLE);
                explain.setVisibility(View.INVISIBLE);
            }
        });

        introduceClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explainLayout.setVisibility(View.GONE);
                kkuri.setBackgroundResource( R.drawable.kkury_flower1);
            }
        });
    }

    public void fragmentInit(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        Fragment doubleListFragment = DoubleListFragment.newInstance();
        transaction1.replace(R.id.fragment_list, doubleListFragment);
        transaction1.commit();

        Fragment demoFragment = new LoopViewPagerFragment();
        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        transaction2.replace(R.id.fragment_container, demoFragment);
        transaction2.commit();

        introduceFragment = new IntroduceFragment().newInstance();
        FragmentTransaction transaction3 = fragmentManager.beginTransaction();
        transaction3.replace(R.id.explain_fragment, introduceFragment);
        transaction3.commit();
    }

    public void spinnerInit(){
        Spinner spinner = (Spinner)findViewById(R.id.planets_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.custom_actionbar, null);

        actionBar.setCustomView(actionbar);

        //액션바 양쪽 공백 없애기
        Toolbar parent = (Toolbar)actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);

        return true;
    }

    //viewPager의 현 포지션
    public void getPosition(int position){
        this.position = position;

        ((IntroduceFragment)introduceFragment).contentsChange(position);


    }
}