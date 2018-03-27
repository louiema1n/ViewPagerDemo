package com.example.louiemain.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        // 设置适配器
        viewpager.setAdapter(new MyPagerAdapter());
        viewpager.setOffscreenPageLimit(0);


    }

    class MyPagerAdapter extends PagerAdapter {

        private TextView tv_name;
        private Button rb_a;
        private Button rb_b;
        private Button rb_c;
        private Button rb_d;
        private Button rb_e;
        private RadioGroup rg_option;
        private LinearLayout ly_result_analysis;

        /**
         * 显示多少个页面
         *
         * @return
         */
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 初始化显示的条目对象
         *
         * @param container
         * @param position
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
            View view = View.inflate(MainActivity.this, R.layout.layout_base_practice, null);
            // 准备数据
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText("题目" + position);
            rb_a = (Button) view.findViewById(R.id.rb_a);
            rb_b = (Button) view.findViewById(R.id.rb_b);
            rb_c = (Button) view.findViewById(R.id.rb_c);
            rb_d = (Button) view.findViewById(R.id.rb_d);
            rb_e = (Button) view.findViewById(R.id.rb_e);
            rg_option = (RadioGroup) view.findViewById(R.id.rg_option);
            ly_result_analysis = (LinearLayout) view.findViewById(R.id.ly_result_analysis);

            ly_result_analysis.setVisibility(View.GONE);

            viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    rb_a.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < rg_option.getChildCount(); i++) {
                                rg_option.getChildAt(i).setEnabled(false);
                            }
                            ly_result_analysis.setVisibility(View.VISIBLE);
                        }
                    });
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            // 添加到viewpager容器
            viewpager.addView(view);

            // 返回填充的view对象
            return view;
        }

        /**
         * 销毁条目对象
         *
         * @param container
         * @param position
         * @param object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }

}
