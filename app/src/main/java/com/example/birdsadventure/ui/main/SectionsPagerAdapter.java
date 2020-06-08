package com.example.birdsadventure.ui.main;

import android.content.Context;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.birdsadventure.BirdDescriptionFragment;
import com.example.birdsadventure.BirdLocationFragment;
import com.example.birdsadventure.BirdMediaFragment;
import com.example.birdsadventure.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super (fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch(position)
        {
            case 0:
                fragment=new BirdDescriptionFragment () ;
                break;

            case 1:
                fragment=new BirdMediaFragment () ;
                break;

            case 2:
                fragment=new BirdLocationFragment () ;
                break;

        }
        return  fragment;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources ().getString (TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}