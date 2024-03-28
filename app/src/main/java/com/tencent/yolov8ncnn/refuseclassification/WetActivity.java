package com.tencent.yolov8ncnn.refuseclassification;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.tencent.yolov8ncnn.R;
import com.tencent.yolov8ncnn.refuseclassification.Database.Knowledge;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class WetActivity extends BaseActivity {
    private Toolbar toolbar;
    RecyclerView recyclerView;
    List<Knowledge> knowledges = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wet);
        toolbar =  findViewById(R.id.wet_toolbar);
        toolbar.setTitle("湿垃圾");
        new setTitleCenter().setTitleCenter(toolbar);
        // 编写列表内容
        recyclerView = findViewById(R.id.wet_recyclerView);
        knowledges = LitePal.where("kind = ?", "湿垃圾").find(Knowledge.class);
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(WetActivity.this);
        recyclerView.setLayoutManager(manager);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @NonNull
        @Override
        public WetActivity.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(WetActivity.this, R.layout.item_recyclerview, null);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull WetActivity.MyViewHolder holder, int position) {
            Knowledge knowledge = knowledges.get(position);
            holder.name.setText(knowledge.getName());
            //holder.kind.setText((knowledge.getKind()));
        }

        @Override
        public int getItemCount() {
            return knowledges.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView kind;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            kind = (TextView) itemView.findViewById(R.id.kind);
        }
    }
}
