package com.example.louiemain.viewpagerdemo.view;/**
 * @description
 * @author&date Created by louiemain on 2018/3/27 22:40
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.example.louiemain.viewpagerdemo.R;

/**
 * @Pragram: ViewPagerDemo
 * @Type: Class
 * @Description:
 * @Author: louiemain
 * @Created: 2018/3/27 22:40
 **/
public class FragmentView extends Fragment {

    private Bundle bundle;
    private TextView tv;
    private RadioButton rb_a;
    private LinearLayout ly_result_analysis;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);

        initView(view);

        int pagerNum = bundle.getInt("pager_num");
        switch (pagerNum) {
            case 1:
                view.setBackgroundResource(R.color.colorAccent);
                break;
            case 2:
                view.setBackgroundResource(R.color.colorGray);
                break;
            case 3:
                view.setBackgroundResource(R.color.colorPrimary);
                break;
        }
        tv.setText(bundle.getString("title"));
        rb_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setVisibility(View.GONE);
                ly_result_analysis.setVisibility(View.VISIBLE);
                rb_a.setEnabled(false);
            }
        });
        return view;
    }

    public static FragmentView newInstance(Bundle bundle) {
        FragmentView fragmentView = new FragmentView();
        fragmentView.setArguments(bundle);
        return fragmentView;
    }

    private void initView(View view) {
        tv = (TextView) view.findViewById(R.id.tv);
        rb_a = (RadioButton) view.findViewById(R.id.rb_a);
        ly_result_analysis = (LinearLayout) view.findViewById(R.id.ly_result_analysis);
        ly_result_analysis.setVisibility(View.GONE);
    }
}
