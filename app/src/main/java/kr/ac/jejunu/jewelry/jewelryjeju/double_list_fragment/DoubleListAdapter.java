package kr.ac.jejunu.jewelry.jewelryjeju.double_list_fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.jejunu.jewelry.jewelryjeju.R;


/**
 * Created by Osy on 2017-10-09.
 */

public class DoubleListAdapter extends RecyclerView.Adapter<DoubleListAdapter.GridViewHolder> {
    private ArrayList<ArrayList> data;
    private Context context;

    public DoubleListAdapter(Context context, ArrayList data ){
        this.context = context;
        this.data = data;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.double_recycler_view, parent, false);

        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        //마지막은 추가하는 탭으로다가.

        String title = (String)data.get(position).get(0);
        String subtitle = (String)data.get(position).get(1);

        /*Log.e(this.toString(), "position: " + position );
        Log.e(this.toString(), "url: " + url );*/

//        File file = new File(url);
//        Bitmap bitmap = BitmapFactory.decodeFile( file.getAbsolutePath());
        holder.mainTitle.setText( title);
        holder.subTitle.setText( subtitle);

    }

    //마지막 추가하는 칸.
    @Override
    public int getItemCount() {
        Log.e(this.toString(), "getItemCount: " + data.size() );
        return data.size();
    }

    public void changeData(ArrayList<ArrayList> data){
        this.data = data;
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
