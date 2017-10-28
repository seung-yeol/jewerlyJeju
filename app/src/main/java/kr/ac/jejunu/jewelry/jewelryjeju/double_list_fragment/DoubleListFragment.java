package kr.ac.jejunu.jewelry.jewelryjeju.double_list_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.ac.jejunu.jewelry.jewelryjeju.R;


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

        for ( int i = 0 ; i < 10; i++){
            ArrayList al = new ArrayList();

            al.add( "바다" + i);
            al.add( "바다다다다다다!!" + i);

            allData.add( al);
        }

    }

    class ImageClickLister implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //클릭하는 이미지버튼에 따라 뜨는 상품이 다르게.
        }
    }
}
