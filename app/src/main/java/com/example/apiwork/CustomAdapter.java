package com.example.apiwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apiwork.APIResponse.CategoryResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Response;

import static com.example.apiwork.APIManager.APIConfig.BASE_URL;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    Response<CategoryResponse> response;
    Context context;
    RecyclerViewClickListener recyclerViewClickListener;

    public CustomAdapter(Response<CategoryResponse> response, Context context) {
        this.response = response;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.category_id.setText(response.body().getModelList().get(position).getCategoryId());
        holder.items_lists.setText(response.body().getModelList().get(position).getCategoryName());
        Picasso.with(context).load(BASE_URL + response.body().getModelList().get(position).getImage()).into(holder.image_lists);
//        Toast.makeText(context, response.body().getModelList().get(position).getImage(), Toast.LENGTH_SHORT).show();
        holder.items_lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return response.body().getModelList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView items_lists, category_id;
        ImageView image_lists;
        public ViewHolder(View itemView) {
            super(itemView);
            category_id = (TextView)itemView.findViewById(R.id.category_id);
            items_lists = (TextView)itemView.findViewById(R.id.category_name);
            image_lists = (ImageView)itemView.findViewById(R.id.image);
        }
    }
    public interface RecyclerViewClickListener{
        void onClick(int position);
    }
    public  void Click(RecyclerViewClickListener recyclerViewClickListener){
        this.recyclerViewClickListener = recyclerViewClickListener;
    }
}
