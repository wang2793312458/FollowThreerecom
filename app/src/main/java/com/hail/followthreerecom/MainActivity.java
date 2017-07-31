package com.hail.followthreerecom;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hail.followthreerecom.base.BaseActivity;
import com.hail.followthreerecom.utils.StatusBarSetting;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation)
    NavigationView mNavigation;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        StatusBarSetting.setColorForDrawerLayout(this, mDrawerLayout, getResources().getColor(R.color.colorPrimary), StatusBarSetting.DEFAULT_STATUS_BAR_ALPHA);
        setToolBar();
        setNavigationView();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.mn_home: {
                Toast.makeText(mContext, "home", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mn_movie: {
                Toast.makeText(mContext, "movie", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mn_music: {
                Toast.makeText(mContext, "music", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        item.setChecked(true);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setToolBar() {
        mToolbar.setTitle("首页");//设置标题
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        //菜单按钮可用
        actionBar.setHomeButtonEnabled(true);
        //回退按钮可用
        actionBar.setDisplayHomeAsUpEnabled(true);
        //将drawlayout与toolbar绑定在一起
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        abdt.syncState();//初始化状态
        //设置drawlayout的监听事件 打开/关闭
        mDrawerLayout.setDrawerListener(abdt);
        //actionbar中的内容进行初始化
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    private void setNavigationView() {
        //NavigationView初始化
        mNavigation.setItemIconTintList(null);
        View headerView = mNavigation.getHeaderView(0);
        mNavigation.setNavigationItemSelectedListener(this);
        setHomeItemState();
    }

    /**
     * 设置首页默认被选中的状态
     */
    private void setHomeItemState() {
        Menu menu = mNavigation.getMenu();
        MenuItem item = menu.getItem(0);
        //更多中  特殊情况  取消选中状态
        menu.getItem(5).getSubMenu().getItem(0).setChecked(false);
        menu.getItem(5).getSubMenu().getItem(1).setChecked(false);
        item.setChecked(true);
    }
}
