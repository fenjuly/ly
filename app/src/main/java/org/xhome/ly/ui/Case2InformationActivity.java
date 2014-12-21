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

import com.kbeanie.imagechooser.api.ChooserType;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case2;
import org.xhome.ly.ui.fragment.af.AblationResultFragment;
import org.xhome.ly.ui.fragment.af.AppendixFragment;
import org.xhome.ly.ui.fragment.af.BeforeOperationMessageFragment;
import org.xhome.ly.ui.fragment.af.DiagnosticMessageFragment;
import org.xhome.ly.ui.fragment.af.TranscatheterAblationFragment;
import org.xhome.ly.ui.fragment.af.UnderOperationMessageFragment;
import org.xhome.ly.ui.fragment.af.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liurongchan on 14/12/21.
 */
public class Case2InformationActivity extends BaseActivity implements BaseFragment.Case2DataChangedListener, BaseFragment.NextStepListner {

private DrawerLayout mDrawerLayout;
private ActionBarDrawerToggle mDrawerToggle;
private ListView mDrawerList;
private ArrayAdapter<String> mDrawerAapter;
private static final String[] ITEMS = {
        "诊断信息", "术前信息", "经导管消融",
        "消融结果", "术中信息", "附录"
        };

        FragmentManager fragmentManager;

public Case2 case2 = new Case2();

private List<BaseFragment> fragments = new ArrayList<BaseFragment>();

private BaseFragment currentFragment;
private AppendixFragment appendixFragment;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1_information);
        case2.setName("房速");
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
        setFragment(DiagnosticMessageFragment.newInstance(case2));

        fragments.add(DiagnosticMessageFragment.newInstance(case2));
        fragments.add(BeforeOperationMessageFragment.newInstance(case2));
        fragments.add(TranscatheterAblationFragment.newInstance(case2));
        fragments.add(AblationResultFragment.newInstance(case2));
        fragments.add(UnderOperationMessageFragment.newInstance(case2));
        fragments.add(AppendixFragment.newInstance(case2));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        currentFragment.saveCase2();
        switch (position) {
        case 0 :
        setTitle("诊断信息");
        setFragment(DiagnosticMessageFragment.newInstance(case2));
        break;
        case 1:
        setTitle("术前信息");
        setFragment(BeforeOperationMessageFragment.newInstance(case2));
        break;
        case 2:
        setTitle("经导管消融");
        setFragment(TranscatheterAblationFragment.newInstance(case2));
        break;
        case 3:
        setTitle("消融结果");
        setFragment(AblationResultFragment.newInstance(case2));
        break;
        case 4:
        setTitle("术中信息");
        setFragment(UnderOperationMessageFragment.newInstance(case2));
        break;
        case 5:
        setTitle("附录");
        setFragment(AppendixFragment.newInstance(case2));
        break;
        }
        }
        });
        }


private void setFragment(BaseFragment fragment) {
        currentFragment = fragment;
        if (currentFragment instanceof AppendixFragment) {
        appendixFragment = (AppendixFragment)currentFragment;
        }
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
public void OnCase2DataChanged(Case2 case2) {
        this.case2 = case2;
        }

@Override
public void onDestroy() {
        super.onDestroy();
        for (BaseFragment fragment : fragments) {
        fragment.isInActivity = false;
        }
        fragments = null;
        }



@Override
public void OnNextStepClicked(int position) {
        currentFragment.saveCase2();
        switch (position) {
        case 0 :
        setTitle("诊断信息");
        setFragment(DiagnosticMessageFragment.newInstance(case2));
        break;
        case 1:
        setTitle("术前信息");
        setFragment(BeforeOperationMessageFragment.newInstance(case2));
        break;
        case 2:
        setTitle("经导管消融");
        setFragment(TranscatheterAblationFragment.newInstance(case2));
        break;
        case 3:
        setTitle("消融结果");
        setFragment(AblationResultFragment.newInstance(case2));
        break;
        case 4:
        setTitle("术中信息");
        setFragment(UnderOperationMessageFragment.newInstance(case2));
        break;
        case 5:
        setTitle("附录");
        setFragment(AppendixFragment.newInstance(case2));
        break;
        }
        }

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK
        && (requestCode == ChooserType.REQUEST_PICK_PICTURE
        || requestCode == ChooserType.REQUEST_CAPTURE_PICTURE)) {
        if (appendixFragment.imageChooserManager == null) {
        appendixFragment.reinitializeImageChooser();
        }
        appendixFragment.imageChooserManager.submit(requestCode, data);
        } else {
        appendixFragment.progressDialog.dismiss();
        }
        }
        }
