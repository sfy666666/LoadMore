# LoadMore
BaseRecyclerViewAdapterHelper实现下拉刷新上拉加载

##### app中的build.gradle文件中添加依赖
```
implementation 'androidx.legacy:legacy-support-v4:1.0.0'
implementation 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.47'
```
##### build.gradle添加配置
```
allprojects {
    repositories {
        ......
        maven { url "https://jitpack.io" }
        
    }
}
```


##### MainActivity中代码
```
package net.te.loadmore;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.RequestLoadMoreListener {


    private int mCurrentItem;//当前条目位置
    private static final int TOTAL_COUNTER = 40;//数据总数
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private QuickAdapter mQuickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRefresh();
        initList();

    }


    private void initRefresh() {
        //设置正在刷新进度条颜色
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {
        mQuickAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {

                //刷新时使用setNewData方法
                mQuickAdapter.setNewData(DataServer.getNewSampleData(20));
                //正在刷新时不可下拉刷新
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                //下拉刷新结束后可以上拉加载
                mQuickAdapter.setEnableLoadMore(true);
                //检查数据是否占满屏幕
                mQuickAdapter.disableLoadMoreIfNotFullPage();
                //上拉加载记录重置
                mCurrentItem = 0;
            }
        }, 2000);
    }


    private void initList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mQuickAdapter = new QuickAdapter();
        recyclerView.setAdapter(mQuickAdapter);
        //开启动画效果 从左边滑出
        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        //设置上拉加载更多监听
        mQuickAdapter.setOnLoadMoreListener(this, recyclerView);
        //首次进入列表不自动加载更多
        mQuickAdapter.disableLoadMoreIfNotFullPage();
    }


    @Override
    public void onLoadMoreRequested() {
        //模拟加载
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadMore();
            }
        }, 1000);

    }

    private void loadMore() {
        if (mCurrentItem >= TOTAL_COUNTER) {
            //当前条目等于总条目数时下拉加载更多结束
            mQuickAdapter.loadMoreEnd();
        } else {
            //加载更多条目使用 addData方法
            mQuickAdapter.addData(DataServer.getSampleData(10));
            mQuickAdapter.loadMoreComplete();
            mCurrentItem = mQuickAdapter.getItemCount();

        }


    }


}

```
ButterKnife的用法
[ButterKnife](https://github.com/JakeWharton/butterknife)
