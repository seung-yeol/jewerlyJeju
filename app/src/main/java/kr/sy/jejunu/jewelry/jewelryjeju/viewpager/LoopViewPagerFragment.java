package kr.sy.jejunu.jewelry.jewelryjeju.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imbryk.viewPager.LoopViewPager;

import java.util.ArrayList;

import kr.sy.jejunu.jewelry.jewelryjeju.MainActivity;
import kr.sy.jejunu.jewelry.jewelryjeju.R;
import me.relex.circleindicator.CircleIndicator;

public class LoopViewPagerFragment extends Fragment {
    private ArrayList sampleData;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        sampleData();

        return inflater.inflate(R.layout.fragment_sample_loop_viewpager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        LoopViewPager viewpager = (LoopViewPager) view.findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);

        viewpager.setAdapter(new SamplePagerAdapter(sampleData));
        indicator.setViewPager(viewpager);

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ( (MainActivity)getActivity()).getPosition( position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void sampleData(){
        sampleData = new ArrayList();
        sampleData.add(R.drawable.introduce2);
        sampleData.add(R.drawable.pogu1);
        sampleData.add(R.drawable.pogu2);
        sampleData.add(R.drawable.pogu3);
        sampleData.add(R.drawable.power_wind);
        sampleData.add(R.drawable.piggas);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
