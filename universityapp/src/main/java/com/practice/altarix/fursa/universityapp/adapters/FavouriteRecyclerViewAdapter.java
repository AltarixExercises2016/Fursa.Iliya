package com.practice.altarix.fursa.universityapp.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.data.Favourite;
import com.practice.altarix.fursa.universityapp.dto.DatabaseManager;

import java.util.List;

public class FavouriteRecyclerViewAdapter extends RecyclerView.Adapter<FavouriteRecyclerViewAdapter.FavouriteViewHolder>{
    private List<Favourite> favouriteList;
    public FavouriteRecyclerViewAdapter() {

    }
    @Override
    public FavouriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item, parent, false);
        return new FavouriteViewHolder(view);
    }
    @Override
    public void onBindViewHolder(FavouriteViewHolder holder, int position) {
        Favourite favourite = favouriteList.get(position);

        holder.tvFavDay.setText(favourite.favDay);
        holder.tvFavAuditory.setText(String.valueOf(favourite.favAuditory));
        holder.tvFavLesson.setText(favourite.favLesson);
        holder.tvFavType.setText(favourite.favType);
        holder.tvFavTime.setText(favourite.favTime);
        holder.tvFavTeacher.setText(favourite.favTeacher);
    }
    public void add(List<Favourite> favouriteList) {
        this.favouriteList = favouriteList;
    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }
    public class FavouriteViewHolder extends RecyclerView.ViewHolder {
        CardView favCard;
        TextView tvFavDay, tvFavTime, tvFavTeacher, tvFavType, tvFavLesson, tvFavAuditory;
        ImageButton btnDelete;
        DatabaseManager databaseManager;
        public FavouriteViewHolder(final View itemView) {
            super(itemView);
            favCard = (CardView) itemView.findViewById(R.id.favCard);
            tvFavDay = (TextView) itemView.findViewById(R.id.tv_fav_day);
            tvFavTime = (TextView) itemView.findViewById(R.id.tv_fav_time);
            tvFavTeacher = (TextView) itemView.findViewById(R.id.tv_fav_teacher);
            tvFavType = (TextView) itemView.findViewById(R.id.tv_fav_type);
            tvFavLesson = (TextView) itemView.findViewById(R.id.tv_fav_lesson);
            tvFavAuditory = (TextView) itemView.findViewById(R.id.tv_fav_auditory);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);
            databaseManager = new DatabaseManager();
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
                    String day = String.valueOf(tvFavDay.getText());
                    String teacher = String.valueOf(tvFavTeacher.getText());
                    int auditory = Integer.parseInt(tvFavAuditory.getText().toString());
                    String type = String.valueOf(tvFavType.getText());
                    String time = String.valueOf(tvFavTime.getText());
                    String lesson = String.valueOf(tvFavLesson.getText());
                    databaseManager.deleteFavItem(view.getContext(), day, teacher, auditory, type, time, lesson);
                    notifyDataSetChanged();
                }
            });

        }
    }
}
