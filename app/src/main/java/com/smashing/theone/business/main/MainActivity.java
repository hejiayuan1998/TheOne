package com.smashing.theone.business.main;

import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.smashing.theone.R;
import com.smashing.theone.business.home.view.HomeFragment;
import com.smashing.theone.business.movie.view.MovieFragment;
import com.smashing.theone.business.music.view.MusicFragment;
import com.smashing.theone.business.read.view.ReadFragment;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.base.BasePresenter;
import com.smashing.theone.common.utils.FragmentController;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.fl_content)
    FrameLayout flContent;

    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    FragmentController fragmentController;
    ArrayList<Fragment> listFragment;



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


        listFragment = new ArrayList<>();
        listFragment.add(new HomeFragment());
        listFragment.add(new ReadFragment());
        listFragment.add(new MusicFragment());
        listFragment.add(new MovieFragment());

        fragmentController = new FragmentController(R.id.fl_content, getSupportFragmentManager(), listFragment);
        fragmentController.initFragment();

        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home_active, getResources().getString(R.string.nav_home))
                        .setInactiveIconResource(R.drawable.home)
                )
                .addItem(new BottomNavigationItem(R.drawable.reading_active, getResources().getString(R.string.nav_reading))
                        .setInactiveIconResource(R.drawable.reading))
                .addItem(new BottomNavigationItem(R.drawable.music_active, getResources().getString(R.string.nav_music))
                        .setInactiveIconResource(R.drawable.music))
                .addItem(new BottomNavigationItem(R.drawable.movie_active, getResources().getString(R.string.nav_movie))
                        .setInactiveIconResource(R.drawable.movie))
                .setActiveColor(R.color.tv_main_nav)
                .setInActiveColor(R.color.tv_main_nav)
                .initialise();
        bottomNavigationBar.selectTab(0);
        fragmentController.showFragment(0);
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                fragmentController.showFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });


    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

}
