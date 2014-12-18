package org.xhome.ly.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.google.gson.Gson;

import org.xhome.ly.R;
import org.xhome.ly.bean.Case1Up;
import org.xhome.ly.bean.PatientUp;
import org.xhome.ly.ui.ShowCase1InformationActivity;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by liurongchan on 14/12/15.
 */
public class SearchResultAdapter extends BaseAdapter {

    private Context context;
    private List<Case1Up> case1ups;

    public SearchResultAdapter(Context context, List<Case1Up> case1ups) {
        this.context = context;
        this.case1ups = case1ups;
    }

    @Override
    public int getCount() {
        return case1ups.size();
    }

    @Override
    public Object getItem(int position) {
        return case1ups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void refresh(List<Case1Up> cs) {
        case1ups = cs;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        final Case1Up case1up = case1ups.get(position);
        PatientUp patientup = case1up.getPatient();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.search_result_item, null, false);
        }
        holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.date = (TextView) view.findViewById(R.id.date);
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        }
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        holder.date.setText(dateFormat.format(case1up.getOperationData()));
        holder.name.setText(patientup.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowCase1InformationActivity.class);
                intent.removeExtra("case1");
                intent.putExtra("case1", new Gson().toJson(case1up));
                context.startActivity(intent);
            }
        });
        return view;
    }


    private class ViewHolder {
        public TextView date;
        public TextView name;
    }

}
