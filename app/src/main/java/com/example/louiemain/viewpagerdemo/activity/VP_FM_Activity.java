package com.example.louiemain.viewpagerdemo.activity;/**
 * @description
 * @author&date Created by louiemain on 2018/3/27 22:51
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import com.example.louiemain.viewpagerdemo.R;
import com.example.louiemain.viewpagerdemo.view.FragmentView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Pragram: ViewPagerDemo
 * @Type: Class
 * @Description: viewPager&fragment
 * @Author: louiemain
 * @Created: 2018/3/27 22:51
 **/
public class VP_FM_Activity extends FragmentActivity {
    private ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vp_fm_activity);
        initView();
        initData();
    }

    private void initData() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Bundle bundle = new Bundle();
            bundle.putInt("pager_num", i);
            bundle.putString("title", "这是第" + i + "个pager.");
            FragmentView fv = FragmentView.newInstance(bundle);
            fragments.add(fv);
        }

        viewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
        viewpager.setOffscreenPageLimit(2);
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    private class MyFragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList;

        public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    private class MyFragmentStateAdapter extends FragmentStatePagerAdapter {

        List<Fragment> fragmentList;

        public MyFragmentStateAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
