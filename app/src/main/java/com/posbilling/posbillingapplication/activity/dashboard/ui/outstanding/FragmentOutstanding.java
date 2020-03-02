package com.posbilling.posbillingapplication.activity.dashboard.ui.outstanding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.activity.outstandinglist.ActivityOutstandingList;
import com.posbilling.posbillingapplication.interfaceclick.OnOutstandingSummuryClick;
import com.posbilling.posbillingapplication.lib.BaseFragment;
import com.posbilling.posbillingapplication.lib.BasePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class FragmentOutstanding extends BaseFragment implements OnOutstandingSummuryClick {

    private ArrayList<String> customerArraylist = new ArrayList<>();
    private OutstandingSummuryAdapter adapterOutstandingSummury;
    private Context mContext;
    private LinearLayoutManager linearLayoutManager;
    private OnOutstandingSummuryClick onOutstandingSummuryClick = this;
    private ArrayList<String> filterArraylist = new ArrayList<>();

    @BindView(R.id.recyclerviewOutstandingSummury)
    RecyclerView recyclerviewOutstandingSummury;
    @BindView(R.id.edittext_search)
    EditText edittext_search;

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_outstanding;
    }

    @Override
    public void onStart() {
        super.onStart();
        for (int i = 0; i<10;i++){
            customerArraylist.add("Shivaji Satham");
        }
        customerArraylist.add("Ankur Shinde");
        ((ActivityDashboard)getContext()).setTitleOfScreen(getString(R.string.outstanding_summary));
        setRecyclerView();
        setSearchFilter();
    }

    //setting recyclerview
    private void setRecyclerView() {
    linearLayoutManager = new LinearLayoutManager(mContext);
    filterArraylist.addAll(customerArraylist);
    adapterOutstandingSummury = new OutstandingSummuryAdapter(mContext , customerArraylist, onOutstandingSummuryClick);
    recyclerviewOutstandingSummury.setLayoutManager(linearLayoutManager);
    recyclerviewOutstandingSummury.setAdapter(adapterOutstandingSummury);
    }

    //textchangelistner on list
    private void setSearchFilter() {
        edittext_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }


    private void filter(String text) {
        filterArraylist.clear();
            for (String name : customerArraylist) {
                if (name.toLowerCase().contains(text.toLowerCase())) {
                    filterArraylist.add(name);
                }
            }
            adapterOutstandingSummury.filterList(filterArraylist);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mContext == null){
            mContext = ((ActivityDashboard)getContext());
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.mContext = context;
        super.onAttach(context);
    }



    @Override
    public void onOutstandingSummuryClick(View view, int position) {
        Intent intent = new Intent(mContext, ActivityOutstandingList.class);
        startActivity(intent);
    }
}