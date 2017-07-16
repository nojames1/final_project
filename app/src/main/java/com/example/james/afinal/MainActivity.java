package com.example.james.afinal;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.james.afinal.adapter.ViewFragmentStateAdapter;
import com.example.james.afinal.dialog.CustomDialog;
import com.example.james.afinal.fragment.ListFragment;
import com.example.james.afinal.fragment.RadioFragment;
import com.example.james.afinal.fragment.SimulateFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private ArrayList<Pair<String, Fragment>> list = new ArrayList<Pair<String, Fragment>>();


    @BindView(R.id.activity_advance_view_pager_tablayout)
    TabLayout tabLayout;

    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Bundle bundle = getIntent().getBundleExtra("Bundle");
        String s = bundle.getString("msg");
        shortToast(s);

        list.add(new Pair<String, Fragment>("Radio", new RadioFragment()));
        list.add(new Pair<String, Fragment>("List", new ListFragment()));
        list.add(new Pair<String, Fragment>("Simulate", new SimulateFragment()));

        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
