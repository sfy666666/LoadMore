package net.te.loadmore;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author : sfy
 * time   : 2019/12/2
 * desc   :
 */
public class QuickAdapter extends BaseQuickAdapter<User,BaseViewHolder> {
    public  QuickAdapter(){
        super(android.R.layout.simple_list_item_1,DataServer.getNewSampleData(20));
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, User item) {

        helper.setText(android.R.id.text1,item.getName());

    }
}
