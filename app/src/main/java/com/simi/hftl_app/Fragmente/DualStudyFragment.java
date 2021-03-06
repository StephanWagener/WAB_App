package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.simi.hftl_app.Listen.StudyListAdapter;
import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 09.02.2016.
 */
public class DualStudyFragment extends MyRefreshFragment
{
    public DualStudyFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.dual_study_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.listViewStudyDual);
        final ArrayList<StudyListItem> items = new ArrayList<>();
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.DUAL_KMI_BACHELOR));
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.DUAL_WI_BACHELOR));
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.DUAL_AI_BACHELOR));
        items.add(new StudyListItem((MainActivity) getActivity(), StudyCourse.DUAL_WI_MASTER));
        StudyListAdapter adapter = new StudyListAdapter((MainActivity) getActivity(), R.layout.study_list_item, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ((MainActivity)getActivity()).setClickedElement(items.get(position));
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new StudyInfoFragment(), "StudyInfoFragment");
                ft.addToBackStack(StudyInfoFragment.class.getSimpleName());
                ft.commit();
            }
        });

        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.study_dual_color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }

        return view;
    }
}
