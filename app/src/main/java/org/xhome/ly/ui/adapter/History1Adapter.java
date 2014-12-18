package org.xhome.ly.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.xhome.ly.R;
import org.xhome.ly.bean.MedicalHistory;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by liurongchan on 14/12/14.
 */
public class History1Adapter extends BaseAdapter {

    private Context context;
    private List<MedicalHistory> medicalHistories;

    public History1Adapter(Context context, List<MedicalHistory> medicalhistories) {
        this.context = context;
        this.medicalHistories = medicalhistories;
    }

    @Override
    public int getCount() {
        return medicalHistories.size();
    }

    @Override
    public Object getItem(int position) {
        return medicalHistories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void refresh(List<MedicalHistory> ms) {
        medicalHistories = ms;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        MedicalHistory medicalHistory = medicalHistories.get(position);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.history1, null, false);
        }
        holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.date = (TextView) view.findViewById(R.id.date);
            holder.detail = (TextView) view.findViewById(R.id.detail);
            view.setTag(holder);
        }
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        holder.date.setText(dateFormat.format(medicalHistory.getOprateTime()));
        holder.detail.setText(medicalHistory.getDetail());
        return view;
    }


    private class ViewHolder {
        public TextView date;
        public TextView detail;
    }

}
