package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class ServicesHFTLFragment extends MyRefreshFragment
{
    public ServicesHFTLFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_hftl_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.services_main_title);
        title.setText("Services");

        LinearLayout itemOne = (LinearLayout) view.findViewById(R.id.item_services_one);
        LinearLayout itemTwo = (LinearLayout) view.findViewById(R.id.item_services_two);
        LinearLayout itemThree = (LinearLayout) view.findViewById(R.id.item_services_three);
        LinearLayout itemFour = (LinearLayout) view.findViewById(R.id.item_services_four);
        LinearLayout itemFive = (LinearLayout) view.findViewById(R.id.item_services_five);

        TextView textOne = (TextView) view.findViewById(R.id.item_one_name);
        TextView textTwo = (TextView) view.findViewById(R.id.item_two_name);
        TextView textThree = (TextView) view.findViewById(R.id.item_three_name);
        TextView textFour = (TextView) view.findViewById(R.id.item_four_name);
        TextView textFive = (TextView) view.findViewById(R.id.item_five_name);

        ImageView imageOne = (ImageView) view.findViewById(R.id.item_image_one);
        ImageView imageTwo = (ImageView) view.findViewById(R.id.item_image_two);
        ImageView imageThree = (ImageView) view.findViewById(R.id.item_image_three);
        ImageView imageFour = (ImageView) view.findViewById(R.id.item_image_four);
        ImageView imageFive = (ImageView) view.findViewById(R.id.item_image_five);

        itemOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ServicesLibraryFragment(), "ServicesLibaryFragment");
                ft.addToBackStack(ServicesLibraryFragment.class.getSimpleName());
                ft.commit();
            }
        });

        itemTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ServicesSportFragment(), "ServicesSportFragment");
                ft.addToBackStack(ServicesSportFragment.class.getSimpleName());
                ft.commit();
            }
        });

        itemThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ServicesWayToFragment(), "ServicesWayToFragment");
                ft.addToBackStack(ServicesWayToFragment.class.getSimpleName());
                ft.commit();
            }
        });

        itemFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ServicesLinksFragment(), "ServicesLinksFragment");
                ft.addToBackStack(ServicesLinksFragment.class.getSimpleName());
                ft.commit();
            }
        });

        itemFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.add(R.id.activityLayout, new ServicesRoomsFragment(), "ServicesRoomsFragment");
                ft.addToBackStack(ServicesRoomsFragment.class.getSimpleName());
                ft.commit();
            }
        });

        textOne.setText("Bibliothek");
        textTwo.setText("Sport");
        textThree.setText("Anfahrt");
        textFour.setText("Links");
        textFive.setText("Labore");

        imageOne.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.libary));
        imageTwo.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.sport));
        imageThree.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.maps));
        imageFour.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.link));
        imageFive.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.lab));

        LinearLayout goToWebsiteRooms = (LinearLayout) view.findViewById(R.id.services_website_link);
        goToWebsiteRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).goToWebsite("https://www.hft-leipzig.de/de/hochschule/service-an-der-hftl.html");
            }
        });

        TextView allServices = (TextView) view.findViewById(R.id.all_services_text);
        allServices.setText("Alle Infomationen ansehen");

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
        }

        return view;
    }
}
