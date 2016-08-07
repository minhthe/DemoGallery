package com.minhthe.dell.demogallery.customAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhthe.dell.demogallery.R;
import com.minhthe.dell.demogallery.dto.ItemDrawer;

import java.util.List;

/**
 * Created by ttran230 on 8/7/2016.
 */
public class ListViewCustomAdapter extends ArrayAdapter<ItemDrawer> {
    Context context;
    int resource;
    List<ItemDrawer> itemDrawerList;

    public ListViewCustomAdapter(Context context, int resource, List<ItemDrawer> itemDrawerList) {
        super(context, resource, itemDrawerList);
        this.context = context;
        this.resource = resource;
        this.itemDrawerList = itemDrawerList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        View view = View.inflate(context,resource,null);
        ImageView image = (ImageView) view.findViewById(R.id.iconDrawer);
        TextView text = (TextView) view.findViewById(R.id.contentDrawer);

        ItemDrawer item = itemDrawerList.get(position);
        image.setImageResource(item.getImageItem());
        text.setText(item.getTextItem());

        return view;
    }
}
