package com.simi.hftl_app.Listen;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by student on 16.02.2016.
 */
public class ServicesLinkListAdapter extends ArrayAdapter<ServicesLinksListItem>
{
    private final LayoutInflater inflater;
    private final ArrayList<ServicesLinksListItem> items;
    private final MainActivity activity;

    public ServicesLinkListAdapter (MainActivity activity, int resource, ArrayList<ServicesLinksListItem> items)
    {
        super(activity.getApplicationContext(), resource, items);
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.services_links_list_item, parent, false);
        ServicesLinksListItem listItem = items.get(position);

        TextView name = (TextView) view.findViewById(R.id.item_services_link_name);
        name.setText(listItem.getName());

        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        return view;
    }
}
