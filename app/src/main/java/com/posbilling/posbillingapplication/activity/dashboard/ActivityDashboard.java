package com.posbilling.posbillingapplication.activity.dashboard;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.lib.BaseActivity;
import com.posbilling.posbillingapplication.lib.BasePresenter;

import butterknife.BindView;

public class ActivityDashboard extends BaseActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private NavController navControllerChange;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;


    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_outStanding, R.id.nav_payment_received, R.id.nav_sale,
                R.id.nav_expenses, R.id.nav_reports, R.id.nav_other,R.id.nav_setting,R.id.nav_add_customer,R.id.nav_help)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navControllerChange = navController;
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(ActivityDashboard.this, DividerItemDecoration.VERTICAL));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setTitleOfScreen(String title){
        if(title!=null && !title.matches("")){
            if(toolbar_title!=null) {
                toolbar_title.setText(title);
            }else{
                Toast.makeText(this, "Binding fail", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*public void onNavigationChange(){
        *//*NavHostFragment host = NavHostFragment.create(R.navigation.mobile_navigation);
        fragmentTransaction.replace(R.id.nav_host_fragment,host).setPrimaryNavigationFragment(host).commit();*//*
        navControllerChange.navigate(R.id.nav_outStanding);
    }*/

    public void closeApplication(){
        finishAffinity();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}