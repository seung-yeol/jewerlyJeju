package kr.sy.jejunu.jewelry.jewelryjeju.double_list_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.sy.jejunu.jewelry.jewelryjeju.R;


/**
 * Created by Osy on 2017-09-16.
 */

public class DoubleListFragment extends Fragment {
    private RecyclerView recyclerView;
    private DoubleListAdapter adapter;
    private ArrayList<ArrayList> allData;

    private View v;
    public static DoubleListFragment newInstance(){
        DoubleListFragment Instance = new DoubleListFragment();
        return Instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        sampleData();

        v = inflater.inflate( R.layout.fragment_double_list, container, false );
        super.onCreateView(inflater, container, savedInstanceState);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*DBUtil dbUtil = DBUtil.getInstance( getActivity(), "TOUR", null, 1);
        allData = dbUtil.getAllData( DBUtil.TABLE_DIARY);*/

        adapter = new DoubleListAdapter( getActivity() , allData );

        recyclerView = view.findViewById(R.id.grid_recycler);
        recyclerView.setLayoutManager( new GridLayoutManager( getActivity(), 2 ));
        recyclerView.setAdapter( adapter);
    }

    //다이어리 추가하고 다시 돌아오면 데이터 추가된거 바뀐거 반영
    /*@Override
    public void onStart() {
        super.onStart();

        *//*allData = DBUtil.getInstance().getAllData( DBUtil.TABLE_DIARY);*//*
        adapter.changeData( allData);
        adapter.notifyDataSetChanged();
    }*/

    public void sampleData(){
        allData = new ArrayList<>();

        allData.add( sampleCreator(R.drawable.kokeun_mountain, "고근산", "외로운 오름 고근산", "산"));
        allData.add( sampleCreator(R.drawable.bulbitnuri_park, "별빛누리공원", " 별을 찾아 떠나는 여행","여행"));
        allData.add( sampleCreator(R.drawable.sonammuri, "소남머리", "소머리모양의 절벽","바다"));
        allData.add( sampleCreator(R.drawable.surkurn_do, "서건도", "바다가 갈라지는 섬","바다"));
        allData.add( sampleCreator(R.drawable.kkuyri, "kkuyri1", "귀여운 캐릭터 뀨리", "여행"));
        allData.add( sampleCreator(R.drawable.kkuyri, "kkuyri2", "귀여운 캐릭터 뀨리", "여행"));
        allData.add( sampleCreator(R.drawable.kkuyri, "kkuyri3", "귀여운 캐릭터 뀨리", "여행"));
        allData.add( sampleCreator(R.drawable.kkuyri, "kkuyri4", "귀여운 캐릭터 뀨리", "여행"));
        allData.add( sampleCreator(R.drawable.kkuyri, "kkuyri5", "귀여운 캐릭터 뀨리", "여행"));
        allData.add( sampleCreator(R.drawable.kkuyri, "kkuyri6", "귀여운 캐릭터 뀨리", "여행"));
    }

    public ArrayList sampleCreator( int resource, String title, String subtitle, String tag){
        ArrayList al = new ArrayList();
        al.add( resource );
        al.add( title);
        al.add( subtitle);
        al.add( tag);

        return al;
    }

    class ImageClickLister implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //클릭하는 이미지버튼에 따라 뜨는 상품이 다르게.
        }
    }
}
