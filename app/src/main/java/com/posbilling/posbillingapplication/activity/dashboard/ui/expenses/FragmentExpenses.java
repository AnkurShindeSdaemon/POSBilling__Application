package com.posbilling.posbillingapplication.activity.dashboard.ui.expenses;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.utility.BaseFragment;
import com.posbilling.posbillingapplication.utility.BasePresenter;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

public class FragmentExpenses extends BaseFragment {

    private Context mContext;
    final Calendar dob_currentDate = Calendar.getInstance();

    @BindView(R.id.edittext_enterDate)
    EditText edittext_enterDate;
    @BindView(R.id.edittext_enterAmount)
    EditText edittext_enterAmount;
    @BindView(R.id.edittext_enterExpense)
    EditText edittext_enterExpense;

    @OnClick(R.id.imageview_mic_enter_expense)
    void imageview_mic_enter_expense() {
        speechToTextFunc(mContext,edittext_enterExpense,1);
    }

    @OnClick(R.id.imageview_mic_enter_amount)
    void imageview_mic_enter_amount(){
        speechToTextFunc(mContext,edittext_enterAmount,2);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_expenses;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mContext == null){
            mContext = ((ActivityDashboard)getContext());
        }
        ((ActivityDashboard)getContext()).setTitleOfScreen(getString(R.string.menu_expenses));
    }

    @Override
    public void onStart() {
        super.onStart();
        setCalendar();
    }

    private void setCalendar() {
        edittext_enterDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edittext_enterDate.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },dob_currentDate.get(dob_currentDate.YEAR), dob_currentDate.get(Calendar.MONTH), dob_currentDate.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.setTitle("Select Date");
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }


}