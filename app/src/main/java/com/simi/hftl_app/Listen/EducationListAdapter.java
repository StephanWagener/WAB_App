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
 * Created by student on 12.02.2016.
 */
public class EducationListAdapter extends ArrayAdapter<EducationListItem>
{
    private final LayoutInflater inflater;
    private final ArrayList<EducationListItem> items;
    private final MainActivity activity;

    public EducationListAdapter(MainActivity activity, int resource, ArrayList<EducationListItem> items)
    {
        super(activity.getApplicationContext(), resource, items);
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.study_list_item, parent, false);

        EducationListItem listItem = items.get(position);

        TextView name = (TextView) view.findViewById(R.id.item_name);
        name.setText(listItem.getName());

        TextView text = (TextView) view.findViewById(R.id.item_more);
        text.setText(activity.getResources().getString(R.string.STUDY_LIST_MORE));

        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        return view;
    }

    @Override
    public EducationListItem getItem(int position) {
        return items.get(position);
    }
}
