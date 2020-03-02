package com.posbilling.posbillingapplication.activity.dashboard.ui.outstanding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.interfaceclick.OnOutstandingSummuryClick;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Android PC (Ankur) on 28,February,2020
 */
public class OutstandingSummuryAdapter extends RecyclerView.Adapter<OutstandingSummuryAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<String> customerArraylist;
    private OnOutstandingSummuryClick onOutstandingSummuryClick;

    public OutstandingSummuryAdapter(Context mContext, ArrayList<String> customerArraylist, OnOutstandingSummuryClick onOutstandingSummuryClick) {
        this.mContext=mContext;
        this.customerArraylist = customerArraylist;
        this.onOutstandingSummuryClick = onOutstandingSummuryClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OutstandingSummuryAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.outstanding_summury_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textviewName.setText(customerArraylist.get(position));
        holder.relativeParenOutstandingItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOutstandingSummuryClick.onOutstandingSummuryClick(v,holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return customerArraylist.size();
    }

    public void filterList(ArrayList<String> filterArraylist) {
        customerArraylist = filterArraylist;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageview_profile;
        TextView textviewCustomerOutstanding;
        TextView textviewName;
        RelativeLayout relativeParenOutstandingItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview_profile = itemView.findViewById(R.id.imageview_profile);
            textviewCustomerOutstanding = itemView.findViewById(R.id.textviewCustomerOutstanding);
            textviewName = itemView.findViewById(R.id.textviewName);
            relativeParenOutstandingItem = itemView.findViewById(R.id.relativeParenOutstandingItem);
        }
    }
}