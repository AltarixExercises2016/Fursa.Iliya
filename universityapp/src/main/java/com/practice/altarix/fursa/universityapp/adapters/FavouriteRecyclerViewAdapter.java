package com.practice.altarix.fursa.universityapp.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.data.FavouriteDTO;

import java.util.List;

public class FavouriteRecyclerViewAdapter extends RecyclerView.Adapter<FavouriteRecyclerViewAdapter.FavouriteViewHolder> {
    private List<FavouriteDTO> favList;
    public FavouriteRecyclerViewAdapter() {

    }
    @Override
    public FavouriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item, parent, false);
        return new FavouriteViewHolder(view);
    }
    @Override
    public void onBindViewHolder(FavouriteViewHolder holder, int position) {
        FavouriteDTO favouriteDTO = favList.get(position);

        holder.tvFavDay.setText(favouriteDTO.favDay);
        holder.tvFavAuditory.setText(String.valueOf(favouriteDTO.favAuditory));
        holder.tvFavLesson.setText(favouriteDTO.favLesson);
        holder.tvFavType.setText(favouriteDTO.favType);
        holder.tvFavTime.setText(favouriteDTO.favTime);
        holder.tvFavTeacher.setText(favouriteDTO.favTeacher);
    }
    public void add(List<FavouriteDTO> favouriteDTOList) {
        this.favList = favouriteDTOList;
    }

    @Override
    public int getItemCount() {
        return favList.size();
    }

    public class FavouriteViewHolder extends RecyclerView.ViewHolder {
        CardView favCard;
        TextView tvFavDay, tvFavTime, tvFavTeacher, tvFavType, tvFavLesson, tvFavAuditory;
        public FavouriteViewHolder(final View itemView) {
            super(itemView);
            favCard = (CardView) itemView.findViewById(R.id.favCard);
            tvFavDay = (TextView) itemView.findViewById(R.id.tv_fav_day);
            tvFavTime = (TextView) itemView.findViewById(R.id.tv_fav_time);
            tvFavTeacher = (TextView) itemView.findViewById(R.id.tv_fav_teacher);
            tvFavType = (TextView) itemView.findViewById(R.id.tv_fav_type);
            tvFavLesson = (TextView) itemView.findViewById(R.id.tv_fav_lesson);
            tvFavAuditory = (TextView) itemView.findViewById(R.id.tv_fav_auditory);

        }
    }
}
