package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.simi.hftl_app.Listen.NewsListAdapter;
import com.simi.hftl_app.Listen.NewsListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 09.02.2016.
 */
public class ServicesRoomsFragment extends MyRefreshFragment
{
    public ServicesRoomsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_rooms_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.services_rooms_list);
        ArrayList<NewsListItem> news = new ArrayList<>();
        news.add(new NewsListItem(getResources().getString(R.string.ROOM_TITLE_ONE),
                getResources().getString(R.string.ROOM_TEXT_ONE),
                R.drawable.emv));
        news.add(new NewsListItem(getResources().getString(R.string.ROOM_TITLE_TWO),
                getResources().getString(R.string.ROOM_TEXT_TWO),
                R.drawable.elektro));
        news.add(new NewsListItem(getResources().getString(R.string.ROOM_TITLE_THREE),
                getResources().getString(R.string.ROOM_TEXT_THREE),
                R.drawable.uebertragungstechnik));
        news.add(new NewsListItem(getResources().getString(R.string.ROOM_TITLE_FOUR),
                getResources().getString(R.string.ROOM_TEXT_FOUR),
                R.drawable.vermittlungstechnik));
        news.add(new NewsListItem(getResources().getString(R.string.ROOM_TITLE_FIVE),
                getResources().getString(R.string.ROOM_TEXT_FIVE),
                R.drawable.werkstatt));
        NewsListAdapter adapter = new NewsListAdapter((MainActivity)getActivity(),R.layout.news_list_item,news);
        list.setAdapter(adapter);

        TextView title = (TextView) view.findViewById(R.id.title_services_rooms);
        title.setText(getActivity().getResources().getString(R.string.SERVICES_ROOMS_TITLE));

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }

        return view;
    }
}
