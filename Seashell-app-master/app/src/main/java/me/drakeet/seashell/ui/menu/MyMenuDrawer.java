package me.drakeet.seashell.ui.menu;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.seashell.R;
import me.drakeet.seashell.utils.MySharedpreference;

public abstract class MyMenuDrawer extends FragmentActivity implements MenuAdapter.MenuListener {

    private static final String STATE_ACTIVE_POSITION =
            "me.drakeet.seashell.activePosition";

    protected MenuDrawer mMenuDrawer;

    protected MenuAdapter mAdapter;
    protected ListView    mList;

    private int mActivePosition = 0;
    private int width;

    @Override
    protected void onCreate(Bundle inState) {
        super.onCreate(inState);
        if (inState != null) {
            mActivePosition = inState.getInt(STATE_ACTIVE_POSITION);
        }
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = (int) (metric.widthPixels / 10 * 4.62); // 获取屏幕宽度（像素），并且侧滑菜单占6/10比例，接近黄金比例~

        //initMenuDrawer();
    }

    protected void initMenuDrawer() {
        mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, getDrawerPosition(), getDragMode());
        List<Object> items = new ArrayList<Object>();
        MySharedpreference mySharedpreference = new MySharedpreference(this);
        String username = mySharedpreference.getString("username");
        if (username != null) {
            items.add(new Item(username, R.drawable.ic_notification));
        } else {
            items.add(new Item("注册/登录", R.drawable.ic_notification));
        }
        items.add(new Category("Cat 1"));
        items.add(new Item("我的收藏", R.drawable.toolbar_fav_icon_res));
        items.add(new Item("已背单词", R.drawable.navigationbar_check));
        items.add(new Category("Cat 2"));
        items.add(new Item("词库选择", R.drawable.icon_search_pressed));
        items.add(new Item("分享", R.drawable.memu_share));
        items.add(new Item("设置", R.drawable.menu_icon_setting));
        items.add(new Item("关于", R.drawable.menu_about));
        items.add(new Category(" "));
        items.add(new Item("退出", R.drawable.menu_exit));

        mList = new ListView(this);
        mAdapter = new MenuAdapter(this, items);
        mAdapter.setListener(this);
        mAdapter.setActivePosition(mActivePosition);
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(mItemClickListener);
        mMenuDrawer.setupUpIndicator(this);
        mMenuDrawer.setDrawerIndicatorEnabled(true);
        mMenuDrawer.setMenuView(mList);
        mMenuDrawer.setMenuSize(width);
    }

    public ListView getListView() {
        return mList;
    }

    @Override
    protected void onStart() {
        super.onStart();
        initMenuDrawer();
    }

    protected abstract void onMenuItemClicked(int position, Item item);

    protected abstract int getDragMode();

    protected abstract Position getDrawerPosition();

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mActivePosition = position;
            mMenuDrawer.setActiveView(view, position);
            mAdapter.setActivePosition(position);
            onMenuItemClicked(position, (Item) mAdapter.getItem(position));
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_ACTIVE_POSITION, mActivePosition);
    }

    @Override
    public void onActiveViewChanged(View v) {
        mMenuDrawer.setActiveView(v, mActivePosition);
    }
}
