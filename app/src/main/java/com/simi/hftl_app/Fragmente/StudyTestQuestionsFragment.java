package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.simi.hftl_app.Listen.ScreenSliderPagerAdapter;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Rating;
import com.simi.hftl_app.Model.RatingCategory;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by student on 16.02.2016.
 */
public class StudyTestQuestionsFragment extends MyRefreshFragment
{
    private Toast toast;

    public StudyTestQuestionsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_test_questions_fragment,container,false);

        final ImageView backButton = (ImageView) view.findViewById(R.id.back_button_questions);
        final ImageView forwardButton = (ImageView) view.findViewById(R.id.forward_button_questions);
        final Button result = (Button) view.findViewById(R.id.calculate_answers);
        final TextView title = (TextView) view.findViewById(R.id.test_question_title);

        final ViewPager pager = (ViewPager) view.findViewById(R.id.question_slider);
        ScreenSliderPagerAdapter adapter = new ScreenSliderPagerAdapter(getChildFragmentManager(), (MainActivity) getActivity());
        pager.setAdapter(adapter);
        MainActivity activity = ((MainActivity)getActivity());
        pager.setCurrentItem(activity.getCurrentViewPagerItem());
        title.setText(getTitleText());

        int position = activity.getCurrentViewPagerItem();
        if (position > 0) {
            backButton.setVisibility(View.VISIBLE);
        }
        if (position == 0) {
            backButton.setVisibility(View.GONE);
        }
        if (position == activity.getQuestions().size() - 1) {
            forwardButton.setVisibility(View.GONE);
        }
        if (position < activity.getQuestions().size() - 1) {
            forwardButton.setVisibility(View.VISIBLE);
        }
        if (position == activity.getQuestions().size() - 1)
        {
            result.setVisibility(View.VISIBLE);
            result.setText(getActivity().getResources().getString(R.string.TEST_QUESTION_RESULT_TITLE));
        }

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                MainActivity activity = ((MainActivity) getActivity());
                activity.setCurrentPage(position);
                if (position > 0) {
                    backButton.setVisibility(View.VISIBLE);
                }
                if (position == 0) {
                    backButton.setVisibility(View.GONE);
                }
                if (position == activity.getQuestions().size() - 1) {
                    forwardButton.setVisibility(View.GONE);
                }
                if (position < activity.getQuestions().size() - 1) {
                    forwardButton.setVisibility(View.VISIBLE);
                }
                if (position == activity.getQuestions().size() - 1 || activity.getNotAnsweredQuestions().size() == 0)
                {
                    result.setVisibility(View.VISIBLE);
                    result.setText(getActivity().getResources().getString(R.string.TEST_QUESTION_RESULT_TITLE));
                }
                title.setText(getTitleText());
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> questions = ((MainActivity) getActivity()).getNotAnsweredQuestions();
                if (questions.size() == 0)
                {
                    calculateResult();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.add(R.id.activityLayout, new ResultTestDataFragment(), "ResultTestDataFragment");
                    ft.addToBackStack(ResultTestDataFragment.class.getSimpleName());
                    ft.commit();
                }
                else if (result.getText().toString().equals(getActivity().getResources().getString(R.string.TEST_QUESTION_RESULT_TITLE)))
                {
                    StringBuilder string = new StringBuilder();
                    if (questions.size() == 1)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.TEST_QUESTION_THE_QUESTION) +" "+ questions.get(0) +" "+ getActivity().getResources().getString(R.string.TEST_QUESTION_THE_QUESTION_NOT_ANSWERED), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        string.append(getActivity().getResources().getString(R.string.TEST_QUESTION_THE_QUESTIONS)).append(" ");
                        for (int i = 0; i < questions.size(); i++)
                        {
                            string.append(questions.get(i));
                            if (i == questions.size() - 2)
                            {
                                string.append(" ").append(getActivity().getResources().getString(R.string.TEST_QUESTION_AND)).append(" ");
                            }
                            else if (i != questions.size() - 1)
                            {
                                string.append(", ");
                            }
                        }
                        string.append(" ").append(getActivity().getResources().getString(R.string.TEST_QUESTION_THE_QUESTIONS_NOT_ANSWERED));
                        showAToast(string.toString());
                    }

                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem()-1, true);
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem() + 1, true);
            }
        });

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            GradientDrawable shape =  new GradientDrawable();
            float scale = getContext().getResources().getDisplayMetrics().density;
            int pixels = (int) (10 * scale + 0.5f);
            shape.setCornerRadius(pixels);
            shape.setColor(color);
            result.setBackgroundDrawable(shape);;
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.study_test_color);
            layout.setBackgroundColor(color);
            result.setBackgroundResource(R.drawable.round_button_test);
        }

        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            result.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            result.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            result.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        return view;
    }

    private void calculateResult()
    {
        Rating rating = new Rating();
        MainActivity activity = ((MainActivity) getActivity());
        for (int i = 0; i < activity.getQuestions().size(); i++)
        {
            for (int j = 0; j < activity.getQuestions().get(i).getAnswers().size(); j++)
            {
                if (activity.getQuestions().get(i).getAnswers().get(j).isSet())
                {
                    HashMap map = activity.getQuestions().get(i).getAnswers().get(j).getRatingMap();
                    rating.setAIPoints(rating.getAIPoints() + ((Integer)map.get(RatingCategory.AI)).intValue());
                    rating.setBachelorPoints(rating.getBachelorPoints() + ((Integer) map.get(RatingCategory.BACHELOR)).intValue());
                    rating.setMasterPoints(rating.getMasterPoints() + ((Integer) map.get(RatingCategory.MASTER)).intValue());
                    rating.setKMIPoints(rating.getKMIPoints() + ((Integer) map.get(RatingCategory.KMI)).intValue());
                    rating.setWIPoints(rating.getWIPoints() + ((Integer) map.get(RatingCategory.WI)).intValue());
                    rating.setIKTPoints(rating.getIKTPoints() + ((Integer) map.get(RatingCategory.IKT)).intValue());
                    rating.setDirectPoints(rating.getDirectPoints() + ((Integer) map.get(RatingCategory.DIRECT)).intValue());
                    rating.setDualPoints(rating.getDualPoints() + ((Integer) map.get(RatingCategory.DUAL)).intValue());
                    rating.setJobPoints(rating.getJobPoints() + ((Integer) map.get(RatingCategory.JOB)).intValue());

                }
            }
        }
        activity.setRating(rating);
        ArrayList<StudyCourse> winner = rating.getWinner();
        if (winner != null && !winner.isEmpty())
        {
            activity.setWinner(winner);
        }
        else if (rating.getAlternative() != null)
        {
            activity.setAlternative(rating.getAlternative());
        }
        else
        {
            activity.setWinner(null);
            activity.setAlternative(null);
        }
    }

    public String getTitleText()
    {
        MainActivity activity = ((MainActivity)getActivity());
        return activity.getResources().getString(R.string.TEST_QUESTION) +" "+ (activity.getCurrentViewPagerItem()+1) +" "+ activity.getResources().getString(R.string.TEST_QUESTION_OF) +" "+ activity.getQuestions().size();
    }

    public void showAToast (String st)
    {
        try
        {
            toast.getView().isShown();
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(st);
        }
        catch (Exception ex)
        {
            toast = Toast.makeText(getActivity().getApplicationContext(), st, Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
