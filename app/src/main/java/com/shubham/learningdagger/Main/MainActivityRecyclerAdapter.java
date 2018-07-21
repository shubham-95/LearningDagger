package com.shubham.learningdagger.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.shubham.learningdagger.R;
import com.shubham.learningdagger.Response.Article;

import java.util.List;

public class MainActivityRecyclerAdapter  extends RecyclerView.Adapter<MainActivityRecyclerAdapter.MainViewHolder>{

    private Context context;
    private List<Article> articleList;

    public MainActivityRecyclerAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_recyclerview,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.BindPosition();
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
    class MainViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        View lineseperator;
        public MainViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.image_icon);
            textView=(TextView)itemView.findViewById(R.id.heading);
            lineseperator=(View)itemView.findViewById(R.id.view_seperator);
        }
        void BindPosition(){
            int position=getAdapterPosition();
            if(position==articleList.size()-1)
                lineseperator.setVisibility(View.GONE);
            textView.setText(articleList.get(position).getTitle());
            if(articleList.get(position).getUrlToImage()!=null){
                ProcessImage(articleList.get(position).getUrlToImage());
            }
            else{
                imageView.setImageResource(R.drawable.newsapi);
            }
        }
        private void ProcessImage(String url){
            Glide.with(context).load(url).asBitmap().format(DecodeFormat.PREFER_ARGB_8888).dontTransform().into(imageView);
        }
    }
}
