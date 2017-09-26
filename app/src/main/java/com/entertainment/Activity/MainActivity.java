package com.entertainment.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.entertainment.Adapter.CustomPagerAdapter;
import com.entertainment.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private TextView mTabOne;
    private TextView mTabTwo;
    private TextView mTabThree;

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.left_drawer)
    ListView mDrawerList;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.image_view_pager)
    ViewPager image_view_pager;
    private String TAB = "Main Activity";
    @BindView(R.id.indicator)
    CircleIndicator mPage_indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViewPager(viewPager);
        setSupportActionBar(toolbar);
        /*Get device height and width to set view pager*/
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Log.e(TAB, "*******" + displayMetrics.heightPixels);
        int height = displayMetrics.heightPixels / 2;
        int width = displayMetrics.widthPixels;
        Log.e(TAB, "*******" + height);
        image_view_pager.getLayoutParams().height = height;
        image_view_pager.setAdapter(new CustomPagerAdapter(this));
        mPage_indicator.setViewPager(image_view_pager);

        toolbar.setTitle("Home");

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }


        }; // Drawer Toggle Object Made
        mDrawerLayout.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();


        tabLayout.setupWithViewPager(viewPager);

        mTabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        mTabOne.setText(R.string.videos);

        mTabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_select_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(mTabOne);


        mTabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        mTabTwo.setText(R.string.images);
        mTabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(mTabTwo);

        mTabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        mTabThree.setText(R.string.milestone);
        mTabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_navi_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(mTabThree);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:


                        mTabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_select_video, 0, 0);
                        mTabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_image, 0, 0);
                        mTabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_navi_milestone, 0, 0);


                        break;
                    case 1:

                        mTabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_video, 0, 0);
                        mTabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_select_image, 0, 0);
                        mTabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_navi_milestone, 0, 0);


                        break;
                    case 2:

                        mTabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_video, 0, 0);
                        mTabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_image, 0, 0);
                        mTabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_select_navi_milestone, 0, 0);

                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    /**
     * Initializing Fragment to View pager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BlankFragment(), "VIDEOS");
        adapter.addFragment(new BlankFragment(), "IMAGES");
        adapter.addFragment(new BlankFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);

    }


    /**
     * Add three fragment in View pager class
     * assign name and fragment
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
