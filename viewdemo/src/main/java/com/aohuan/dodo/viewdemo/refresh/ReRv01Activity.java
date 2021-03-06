package com.aohuan.dodo.viewdemo.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aohuan.dodo.viewdemo.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ReRv01Activity extends AppCompatActivity {

    @InjectView(R.id.id_recyclerview)
    RecyclerView mRecyclerView;
    @InjectView(R.id.swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshWidget;

    CommonAdapter mCommonAdapter;

    ArrayList<String> strArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_rv01);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        setRefresh();
        setData();
        setRv();
    }


    private void setRefresh() {
        mSwipeRefreshWidget.setRefreshing(false);
        mSwipeRefreshWidget.setSize(SwipeRefreshLayout.DEFAULT);
        mSwipeRefreshWidget.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshWidget.setProgressBackgroundColor(R.color.red);
        mSwipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                mSwipeRefreshWidget.setEnabled(false);
                mHandler.sendEmptyMessageDelayed(MSG_CODE_REFRESH, TIME_DELAY);
            }
        });
    }

    private void setRv() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mCommonAdapter = new CommonAdapter<String>(this, R.layout.item_rv_o1_1, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.teach_item_name, item);
            }
        });
    }

    int anInt = 3;
    private void setData() {
        strArray.clear();
        for (int i = 0; i < anInt; i++) {
            strArray.add("dodo " + i);
        }
        if(anInt < 10){
            anInt += 2;
        }else{
            anInt = 3;
        }
    }


    public static final int MSG_CODE_REFRESH = 0;
    private static final int TIME_DELAY = 1000;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_CODE_REFRESH) {
                setData();
                mSwipeRefreshWidget.setRefreshing(false);
                mCommonAdapter.notifyDataSetChanged();
            }
        }
    };

}
