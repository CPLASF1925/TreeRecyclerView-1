package com.baozi.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baozi.demo.R;
import com.baozi.demo.item.news.NewsItemBean;
import com.baozi.treerecyclerview.adpater.TreeRecyclerAdapter;
import com.baozi.treerecyclerview.adpater.TreeRecyclerType;
import com.baozi.treerecyclerview.factory.ItemHelperFactory;
import com.baozi.treerecyclerview.item.TreeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author jlanglang  2017/7/5 10:22
 * @版本 2017-8-19;有点勉强,不建议这样使用- -
 */

public class NewsAt extends AppCompatActivity {
    TreeRecyclerAdapter treeRecyclerAdapter = new TreeRecyclerAdapter(TreeRecyclerType.SHOW_ALL);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rv_content);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        recyclerView.setAdapter(treeRecyclerAdapter);

        ArrayList<NewsItemBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsItemBean newsItemBean = new NewsItemBean();
            newsItemBean.title="123";
            newsItemBean.images=new Random().nextInt(10);
            list.add(newsItemBean);
        }

        List<TreeItem> itemList = ItemHelperFactory.createItems(list);
        treeRecyclerAdapter.getItemManager().replaceAllItem(itemList);
    }
}
