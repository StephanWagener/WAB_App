package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.EducationListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Education;
import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class EducationInfoFragment extends MyRefreshFragment
{
    public EducationInfoFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.education_info_fragment, container, false);

        EducationListItem element = ((MainActivity) getActivity()).getClickedEductaion();
        TextView title = (TextView) view.findViewById(R.id.infoEducationTitle);
        title.setText(element.getName());

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.eductaionTitleUndeline);
        TextView beginning = (TextView) view.findViewById(R.id.eductaionBeginningText);
        TextView titleOne = (TextView) view.findViewById(R.id.TOEIC_title_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.TOEIC_title_two);
        TextView titleThree = (TextView) view.findViewById(R.id.TOEIC_title_three);
        TextView textOne = (TextView) view.findViewById(R.id.TOEIC_text_one);
        TextView textTwo = (TextView) view.findViewById(R.id.TOEIC_text_two);
        TextView textThree = (TextView) view.findViewById(R.id.TOEIC_text_three);

        layout.setBackgroundColor(getActivity().getResources().getColor(R.color.education_color));

        if (element.getEducation().equals(Education.TOEIC))
        {
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            beginning.setText(getActivity().getResources().getString(R.string.TOEIC_BEGINNING_TEXT));

            titleOne.setTextColor(getActivity().getResources().getColor(R.color.education_color));
            titleOne.setText(getActivity().getResources().getString(R.string.TOEIC_COMPLETE_PACKAGE_TEXT));
            titleOne.setVisibility(View.VISIBLE);
            titleTwo.setTextColor(getActivity().getResources().getColor(R.color.education_color));
            titleTwo.setText(getActivity().getResources().getString(R.string.TOEIC_LISTENING_AND_READING_TEXT));
            titleTwo.setVisibility(View.VISIBLE);
            titleThree.setTextColor(getActivity().getResources().getColor(R.color.education_color));
            titleThree.setText(getActivity().getResources().getString(R.string.TOEIC_CLASSES_TEXT));
            titleThree.setVisibility(View.VISIBLE);

            textOne.setText(getActivity().getResources().getString(R.string.TOEIC_TITLE_ONE));
            textOne.setVisibility(View.VISIBLE);
            textTwo.setText(getActivity().getResources().getString(R.string.TOEIC_TITLE_TWO));
            textTwo.setVisibility(View.VISIBLE);
            textThree.setText(getActivity().getResources().getString(R.string.TOEIC_TITLE_THREE));
            textThree.setVisibility(View.VISIBLE);
        }
        if (element.getEducation().equals(Education.BEC))
        {
            beginning.setText(getActivity().getResources().getString(R.string.BEC));
        }
        if (element.getEducation().equals(Education.CAE))
        {
            beginning.setText(getActivity().getResources().getString(R.string.CAE));
        }
        if (element.getEducation().equals(Education.IT))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IT));
        }
        if (element.getEducation().equals(Education.ID))
        {
            beginning.setText(getActivity().getResources().getString(R.string.ID));
        }

        return view;
    }
}
