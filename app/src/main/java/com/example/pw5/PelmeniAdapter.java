package com.example.pw5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PelmeniAdapter extends RecyclerView.Adapter<PelmeniAdapter.PelmeniViewHolder> {

    private List<String> pelmeniList;
    private Context context;

    public PelmeniAdapter(List<String> pelmeniList, Context context) {
        this.pelmeniList = pelmeniList;
        this.context = context;
    }

    @Override
    public PelmeniViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pelmeni, parent, false);
        return new PelmeniViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PelmeniViewHolder holder, int position) {
        String pelmeni = pelmeniList.get(position);
        holder.pelmeniTextView.setText(pelmeni);
    }

    @Override
    public int getItemCount() {
        return pelmeniList.size();
    }

    public static class PelmeniViewHolder extends RecyclerView.ViewHolder {

        TextView pelmeniTextView;

        public PelmeniViewHolder(@NonNull View itemView) {
            super(itemView);
            pelmeniTextView = itemView.findViewById(R.id.pelmeniTextView);
        }
    }
}
