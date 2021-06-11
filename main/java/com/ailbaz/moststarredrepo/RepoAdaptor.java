package com.ailbaz.moststarredrepo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RepoAdaptor extends RecyclerView.Adapter<RepoAdaptor.RepoHolder> {

    private Context mContext;
    private ArrayList<RepoViewModel> mRepoList;

    public RepoAdaptor(Context mContext, ArrayList<RepoViewModel> mRepoList) {
        this.mContext = mContext;
        this.mRepoList = mRepoList;
    }

    @NonNull
    @Override
    public RepoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.repo_item_layout,
                parent,false);
        return new RepoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoHolder holder, int position) {

        RepoViewModel mCurrentRepo=mRepoList.get(position);

        String nameOfRepo=mCurrentRepo.getNameOfRepo();
        String discOfRepo=mCurrentRepo.getDiscOfRepo();
        int starsOfRepo=mCurrentRepo.getStarsOfRepo();
        String ownerOfRepo=mCurrentRepo.getOwnerOfRepo();

        holder.nameOfRepoView.setText(nameOfRepo);
        holder.discOfRepoView.setText(discOfRepo);
        holder.starsOfRepoView.setText(""+starsOfRepo);
        holder.ownerOfRepoView.setText(ownerOfRepo);


    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }

    public class RepoHolder extends RecyclerView.ViewHolder {

        public TextView nameOfRepoView;
        public TextView discOfRepoView;
        public TextView ownerOfRepoView;
        public TextView starsOfRepoView;

        public RepoHolder(@NonNull View itemView) {
            super(itemView);

            nameOfRepoView = itemView.findViewById(R.id.nameOfRepo);
            discOfRepoView = itemView.findViewById(R.id.descripionOfRepo);
            ownerOfRepoView = itemView.findViewById(R.id.ownerOfRepo);
            starsOfRepoView = itemView.findViewById(R.id.starsOfRepo);



        }
    }
}
