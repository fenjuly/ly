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
import org.xhome.ly.bean.Case;
import org.xhome.ly.bean.Case1Up;
import org.xhome.ly.bean.Case2Up;
import org.xhome.ly.bean.PatientUp;
import org.xhome.ly.ui.ShowCase1InformationActivity;
import org.xhome.ly.ui.ShowCase2InformationActivity;
import org.xhome.ly.ui.ShowCase3InformationActivity;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by liurongchan on 14/12/15.
 */
public class SearchResultAdapter extends BaseAdapter {

    private Context context;
    private List<Case> cases;

    public SearchResultAdapter(Context context, List<Case> cases) {
        this.context = context;
        this.cases = cases;
    }

    @Override
    public int getCount() {
        return cases.size();
    }

    @Override
    public Object getItem(int position) {
        return cases.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void refresh(List<Case> cs) {
        cases = cs;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        final Case c = cases.get(position);
        PatientUp patientup = c.getPatient();
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
        holder.date.setText(dateFormat.format(c.getOperationData()));
        holder.name.setText(patientup.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c instanceof Case1Up) {
                    Intent intent = new Intent(context, ShowCase1InformationActivity.class);
                    intent.removeExtra("case1");
                    intent.putExtra("case1", new Gson().toJson(c));
                    context.startActivity(intent);
                } else if (c instanceof Case2Up) {
                    Intent intent = new Intent(context, ShowCase2InformationActivity.class);
                    intent.removeExtra("case2");
                    intent.putExtra("case2", new Gson().toJson(c));
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, ShowCase3InformationActivity.class);
                    intent.removeExtra("case3");
                    intent.putExtra("case3", new Gson().toJson(c));
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }


    private class ViewHolder {
        public TextView date;
        public TextView name;
    }

}
