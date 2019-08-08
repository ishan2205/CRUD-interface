package com.anuj.crud_interface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder> {

    private Context mCtx;
    private List<Table> tableList;

    public TableAdapter(Context mCtx, List<Table> tableList)
    {
        this.mCtx = mCtx;
        this.tableList = tableList;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.listlayout, null);
        TableViewHolder holder = new TableViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        Table table=tableList.get(position);
        holder.textViewTitle.setText(table.getTitle());
        holder.textViewDesc.setText(table.getDesc());

    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    class TableViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle,textViewDesc;
        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDesc=itemView.findViewById(R.id.textViewShortDesc);
        }
    }
}
