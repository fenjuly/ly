package org.xhome.ly.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.gson.Gson;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case1Up;
import org.xhome.ly.ui.fragment.vt.ShowAblationResultFragment;
import org.xhome.ly.ui.fragment.vt.ShowAppendixFragment;
import org.xhome.ly.ui.fragment.vt.ShowBaseFragment;
import org.xhome.ly.ui.fragment.vt.ShowBeforeOperationMessageFragment;
import org.xhome.ly.ui.fragment.vt.ShowDiagnosticMessageFragment;
import org.xhome.ly.ui.fragment.vt.ShowTranscatheterAblationFragment;
import org.xhome.ly.ui.fragment.vt.ShowUnderOperationMessageFragment;



/**
 * Created by liurongchan on 14/12/15.
 */
public class ShowCase1InformationActivity extends BaseActivity implements ShowBaseFragment.NextStepListner{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private ArrayAdapter<String> mDrawerAapter;
    private static final String[] ITEMS = {
            "诊断信息", "术前信息", "经导管消融",
            "消融结果", "术中信息", "附录"
    };

    FragmentManager fragmentManager;

    public Case1Up case1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1_information);
        Intent intent = getIntent();
        case1 = new Gson().fromJson(intent.getStringExtra("case1"), Case1Up.class);
        fragmentManager = getSupportFragmentManager();
        mDrawerAapter = new ArrayAdapter<String>(this,
                R.layout.drawer_item
        );
        for (int i = 0; i < ITEMS.length; i++) {
            mDrawerAapter.add(ITEMS[i]);
        }
        mDrawerList = (ListView) findViewById(R.id.drawer_listview);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        mDrawerList.setAdapter(mDrawerAapter);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setTitle("诊断信息");
        setFragment(ShowDiagnosticMessageFragment.newInstance(case1));

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0 :
                        setTitle("诊断信息");
                        setFragment(ShowDiagnosticMessageFragment.newInstance(case1));
                        break;
                    case 1:
                        setTitle("术前信息");
                        setFragment(ShowBeforeOperationMessageFragment.newInstance(case1));
                        break;
                    case 2:
                        setTitle("经导管消融");
                        setFragment(ShowTranscatheterAblationFragment.newInstance(case1));
                        break;
                    case 3:
                        setTitle("消融结果");
                        setFragment(ShowAblationResultFragment.newInstance(case1));
                        break;
                    case 4:
                        setTitle("术中信息");
                        setFragment(ShowUnderOperationMessageFragment.newInstance(case1));
                        break;
                    case 5:
                        setTitle("附录");
                        setFragment(ShowAppendixFragment.newInstance(case1));
                        break;
                }
            }
        });
    }


    private void setFragment(ShowBaseFragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_case1_information, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawer_icon:
                if(mDrawerLayout.isDrawerOpen(mDrawerLayout.getChildAt(1)))
                    mDrawerLayout.closeDrawers();
                else{
                    mDrawerLayout.openDrawer(mDrawerLayout.getChildAt(1));
                }
            default:
                break;
        }
        return true;
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        case1 = new Gson().fromJson(getIntent().getStringExtra("case1"), Case1Up.class);
    }

    @Override
    public void OnNextStepClicked(int position) {
        switch (position) {
            case 0 :
                setTitle("诊断信息");
                setFragment(ShowDiagnosticMessageFragment.newInstance(case1));
                break;
            case 1:
                setTitle("术前信息");
                setFragment(ShowBeforeOperationMessageFragment.newInstance(case1));
                break;
            case 2:
                setTitle("经导管消融");
                setFragment(ShowTranscatheterAblationFragment.newInstance(case1));
                break;
            case 3:
                setTitle("消融结果");
                setFragment(ShowAblationResultFragment.newInstance(case1));
                break;
            case 4:
                setTitle("术中信息");
                setFragment(ShowUnderOperationMessageFragment.newInstance(case1));
                break;
            case 5:
                setTitle("附录");
                setFragment(ShowAppendixFragment.newInstance(case1));
                break;
        }
    }

}
