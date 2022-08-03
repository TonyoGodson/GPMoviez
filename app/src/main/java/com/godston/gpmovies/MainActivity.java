package com.godston.gpmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.godston.gpmovies.adapter.BannerMoviesPagerAdapter;
import com.godston.gpmovies.adapter.MainRecyclerAdapter;
import com.godston.gpmovies.model.AllCategories;
import com.godston.gpmovies.model.BannerMovies;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesviewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> moviesBannerList;
    List<BannerMovies> kidsBannerList;
    Timer sliderTimer;
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategories> allCategoriesList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "test1", "https://demonuts.com/Demonuts/SampleImages/W-21.JPG", ""));
        homeBannerList.add(new BannerMovies(2, "test2", "https://demonuts.com/Demonuts/SampleImages/W-10.JPG", ""));
        homeBannerList.add(new BannerMovies(3, "test3", "https://demonuts.com/Demonuts/SampleImages/W-17.JPG", ""));
        homeBannerList.add(new BannerMovies(4, "test4", "https://demonuts.com/Demonuts/SampleImages/W-08.JPG", ""));
        homeBannerList.add(new BannerMovies(5, "test5", "https://demonuts.com/Demonuts/SampleImages/W-13.JPG", ""));
        homeBannerList.add(new BannerMovies(6, "test6", "https://demonuts.com/Demonuts/SampleImages/W-03.JPG", ""));

        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1, "test1", "https://demonuts.com/Demonuts/SampleImages/W-21.JPG", ""));
        tvShowBannerList.add(new BannerMovies(2, "test1", "https://demonuts.com/Demonuts/SampleImages/W-10.JPG", ""));
        tvShowBannerList.add(new BannerMovies(3, "test1", "https://demonuts.com/Demonuts/SampleImages/W-17.JPG", ""));
        tvShowBannerList.add(new BannerMovies(4, "test1", "https://demonuts.com/Demonuts/SampleImages/W-08.JPG", ""));
        tvShowBannerList.add(new BannerMovies(5, "test1", "https://demonuts.com/Demonuts/SampleImages/W-13.JPG", ""));
        tvShowBannerList.add(new BannerMovies(4, "test1", "https://demonuts.com/Demonuts/SampleImages/W-03.JPG", ""));

        moviesBannerList = new ArrayList<>();
        moviesBannerList.add(new BannerMovies(1, "test1", "https://demonuts.com/Demonuts/SampleImages/W-21.JPG", ""));
        moviesBannerList.add(new BannerMovies(2, "test1", "https://demonuts.com/Demonuts/SampleImages/W-10.JPG", ""));
        moviesBannerList.add(new BannerMovies(3, "test1", "https://demonuts.com/Demonuts/SampleImages/W-17.JPG", ""));
        moviesBannerList.add(new BannerMovies(4, "test1", "https://demonuts.com/Demonuts/SampleImages/W-08.JPG", ""));
        moviesBannerList.add(new BannerMovies(5, "test1", "https://demonuts.com/Demonuts/SampleImages/W-13.JPG", ""));
        moviesBannerList.add(new BannerMovies(6, "test1", "https://demonuts.com/Demonuts/SampleImages/W-03.JPG", ""));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1, "test1", "https://demonuts.com/Demonuts/SampleImages/W-21.JPG", ""));
        kidsBannerList.add(new BannerMovies(2, "test1", "https://demonuts.com/Demonuts/SampleImages/W-10.JPG", ""));
        kidsBannerList.add(new BannerMovies(3, "test1", "https://demonuts.com/Demonuts/SampleImages/W-17.JPG", ""));
        kidsBannerList.add(new BannerMovies(4, "test1", "https://demonuts.com/Demonuts/SampleImages/W-08.JPG", ""));
        kidsBannerList.add(new BannerMovies(5, "test1", "https://demonuts.com/Demonuts/SampleImages/W-13.JPG", ""));
        kidsBannerList.add(new BannerMovies(6, "test1", "https://demonuts.com/Demonuts/SampleImages/W-03.JPG", ""));

        setBannerMoviesPagerAdapter(homeBannerList);

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter(moviesBannerList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default :
                        setBannerMoviesPagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        allCategoriesList = new ArrayList<>();
        allCategoriesList.add(new AllCategories(1, "BollyWood"));
        allCategoriesList.add(new AllCategories(2, "HollyWood"));
        allCategoriesList.add(new AllCategories(2, "Kids"));

        setMainRecycler(allCategoriesList);
    }
    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesviewPager = findViewById(R.id.banner_view_pager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesviewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesviewPager);

        sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 3000);
        indicatorTab.setupWithViewPager(bannerMoviesviewPager, true);
    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMoviesviewPager.getCurrentItem() < homeBannerList.size() - 1) {
                        bannerMoviesviewPager.setCurrentItem(bannerMoviesviewPager.getCurrentItem() + 1);
                    }
                    else {
                        bannerMoviesviewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
    public void setMainRecycler(List<AllCategories> allCategoriesList) {
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoriesList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

}