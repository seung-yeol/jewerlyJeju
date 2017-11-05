package kr.sy.jejunu.jewelry.jewelryjeju.double_list_fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.sy.jejunu.jewelry.jewelryjeju.R;


/**
 * Created by Osy on 2017-10-09.
 */

public class DoubleListAdapter extends RecyclerView.Adapter<DoubleListAdapter.GridViewHolder> {
    private ArrayList<ArrayList> provider;
    private Context context;

    public DoubleListAdapter(Context context, ArrayList provider){
        this.context = context;
        this.provider = provider;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.double_recycler_view, parent, false);

        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        //마지막은 추가하는 탭으로다가.

        int imgId = (int) provider.get(position).get(0);
        String title = (String) provider.get(position).get(1);
        String subtitle = (String) provider.get(position).get(2);
        String tag = (String) provider.get(position).get(3);

//        File file = new File(url);
//        Bitmap bitmap = BitmapFactory.decodeFile( file.getAbsolutePath());
        holder.diaryImg.setImageResource( imgId);
        holder.mainTitle.setText( title);
        holder.subTitle.setText( subtitle);

    }

    //마지막 추가하는 칸.
    @Override
    public int getItemCount() {
        Log.e(this.toString(), "getItemCount: " + provider.size() );
        return provider.size();
    }

    public void changeData(ArrayList<ArrayList> data){
        this.provider = data;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView diaryImg;
        TextView mainTitle;
        TextView subTitle;

        public GridViewHolder(View itemView) {
            super(itemView);

            diaryImg = itemView.findViewById(R.id.list_img);
            mainTitle = itemView.findViewById(R.id.list_title);
            subTitle = itemView.findViewById(R.id.list_subtitle);
        }
    }
}
