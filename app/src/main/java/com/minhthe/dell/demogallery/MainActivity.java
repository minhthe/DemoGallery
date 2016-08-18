package com.minhthe.dell.demogallery;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.minhthe.dell.demogallery.customAdapter.ListViewCustomAdapter;
import com.minhthe.dell.demogallery.customAdapter.MyViewPagerAdapter;
import com.minhthe.dell.demogallery.dto.ItemDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {


    String contentDrawer[] ={"Gallery", "Movie"};
    int iconDrawer[]={R.drawable.gallery, R.drawable.movie};
    ListView lvMenuDrawer;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle ;

    String[] itemTab = {"List Movie","List Gallery"};

    //variable of viewPager:

    ViewPager viewPage;
    PagerAdapter pagerAdapter;


    //varaible actionBar
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMenuDrawer =(ListView) findViewById(R.id.lvMenuDrawer);



        //relating with viewPager
        viewPage = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPage.setAdapter(pagerAdapter);

        //create a tab
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener =  new ActionBar.TabListener(){
//action1 : click in the tab

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };
        for(int j = 0; j< 2; j++){
            actionBar.addTab(actionBar.newTab().setText(itemTab[j]).setTabListener(tabListener));
        }

        //action2 : view page load and tab load
        viewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                getActionBar().setSelectedNavigationItem(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
                                         }
        );
//        actionBar.setNavigationMode();


// exercise : create tab
//        actionBar = getActionBar();
//
//        actionBar.setNavigationMode();

//        //đổ dữ liệu vào thông qua adapter, simple_list_item_1=dùng giao diện default của android
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contentDrawer);
//        //đổ data và thằng lvMenuDrawer
//        lvMenuDrawer.setAdapter(adapter);

                // create list of ItemDrawer
                List < ItemDrawer > itemDrawerList = new ArrayList<ItemDrawer>();
        ItemDrawer item1 = new ItemDrawer(iconDrawer[0],contentDrawer[0]);
        ItemDrawer item2 = new ItemDrawer(iconDrawer[1],contentDrawer[1]);
        itemDrawerList.add(item1);
        itemDrawerList.add(item2);

        ListViewCustomAdapter listViewCustomAdapter =
                new ListViewCustomAdapter
                        (this,R.layout.custom_layout_listview_drawer,itemDrawerList);
        lvMenuDrawer.setAdapter(listViewCustomAdapter);

        lvMenuDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(getApplicationContext()
                                ,"you choose Gallery",Toast.LENGTH_LONG).show();break;
                    case 1:
                        Toast.makeText(getApplicationContext()
                                ,"you choose Movie",Toast.LENGTH_LONG).show();break;
                }
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                getActionBar().setTitle(R.string.open);
                Toast.makeText(getApplicationContext()
                        ,"you open",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                getActionBar().setTitle(R.string.close);
                Toast.makeText(getApplicationContext()
                        ,"you close",Toast.LENGTH_SHORT).show();
            }

//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                super.onDrawerSlide(drawerView, slideOffset);
//                Toast.makeText(getApplicationContext()
//                        ,"you slide",Toast.LENGTH_SHORT).show();
//
//            }
        };
        drawerLayout.addDrawerListener(drawerToggle);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
