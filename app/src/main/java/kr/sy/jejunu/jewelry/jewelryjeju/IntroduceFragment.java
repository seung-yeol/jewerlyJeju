package kr.sy.jejunu.jewelry.jewelryjeju;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentTransaction;

/**
 * Created by Osy on 2017-10-29.
 */

public class IntroduceFragment extends Fragment implements OnMapReadyCallback {
    private TextView content;
    private ArrayList dataList;
    private LinearLayout mapLinear;

    public static Fragment newInstance(){
        IntroduceFragment INSTANCE = new IntroduceFragment();
        INSTANCE.dataList = new ArrayList();

        return INSTANCE;
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(33.237148, 126.512971);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("올레안뜰");
        markerOptions.snippet("왕돈가스 뀰맛");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introduce, container, false);
        sampleData();

        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_NORMAL)
                .compassEnabled(false)
                .rotateGesturesEnabled(false)
                .tiltGesturesEnabled(false);
        MapFragment mapFragment = MapFragment.newInstance( options);
        mapFragment.getMapAsync(this);

        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map_linear, mapFragment);
        fragmentTransaction.commit();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        content = (TextView) view.findViewById(R.id.introdce_content) ;
        mapLinear = view.findViewById( R.id.map_linear );
    }

    public void contentsChange( int position){
        if ( position == 0){
            content.setBackgroundResource(R.drawable.intro);
            mapLinear.setVisibility(View.INVISIBLE);
        }
        else if( position < dataList.size()-1 ){
            content.setBackgroundColor( Color.argb(0,0,0,0));
            mapLinear.setVisibility(View.INVISIBLE);
        }
        else{
            mapLinear.setVisibility(View.VISIBLE);
        }
        content.setText( (String)dataList.get(position));
    }

    public void sampleData(){
        dataList.add("");
        dataList.add("법환포구는 서귀포시 법환동에 위치한 포구로 포구에서 남쪽을 바라보면" +
                "문섬이 보이고 북쪽을 바라보면 한라산이 보입니다. 일몰과 일출이 환상적이며 낚시하기에도 좋은 곳입니다");
        dataList.add("적절방문 시기/시간 : \n 2월 ~ 11월 07:00 ~ 19:00");
        dataList.add("교통정보 : 서귀시내버스 71번( 15분에 1대 ) / 넓은 주차장 겸비");
        dataList.add("주의사항 : 태풍이 불거나 바람이 많은 날에는 파도가 높으므로 주의가 필요합니다.");
        dataList.add("");
    }

}
