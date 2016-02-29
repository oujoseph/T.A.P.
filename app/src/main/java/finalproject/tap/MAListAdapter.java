package finalproject.tap;

import android.util.Log;
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JOO-DESKTOP on 2/27/2016.
 */
public class MAListAdapter extends ArrayAdapter<MAList>{
    Context context;
    int layoutResourceId;
    MAList data[] = null;
    private static final String TAG = MAListAdapter.class.getSimpleName();

    public MAListAdapter(Context context, int layoutResourceId, MAList[] data){
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListElement holder;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            Log.d(TAG, "get string!!!!!!!!!!!!\\\\\\\\\\\\\\\\\\");
            holder = new ListElement();
            holder.imgIcon1 = (ImageView)row.findViewById(R.id.play_button);
            row.setTag(holder);
        }
        else
        {
            holder = (ListElement)row.getTag();
        }

        MAList list = data[position];
        if (position == 0) holder.imgIcon1.setImageResource(R.drawable.touchtoplayy);
        if (position == 1) holder.imgIcon1.setImageResource(R.drawable.instructionss);
        if (position == 2) holder.imgIcon1.setImageResource(R.drawable.creditss);
        if (position == 3) holder.imgIcon1.setImageResource(R.drawable.settings);

        return row;
    }

    static class ListElement
    {
        ImageView imgIcon1;
    }




}