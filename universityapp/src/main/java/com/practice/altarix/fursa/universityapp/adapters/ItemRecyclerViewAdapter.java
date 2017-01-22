package com.practice.altarix.fursa.universityapp.adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practice.altarix.fursa.universityapp.DTO.ItemDTO;
import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.database.DatabaseManager;
import com.practice.altarix.fursa.universityapp.database.LessonModel;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.FavouriteViewHolder> {
    private List<ItemDTO> itemList;
    public ItemRecyclerViewAdapter() {

    }
    @Override
    public FavouriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item, parent, false);
        return new FavouriteViewHolder(view);
    }
    @Override
    public void onBindViewHolder(FavouriteViewHolder holder, int position) {
        ItemDTO itemDTO = itemList.get(position);

        holder.tvDay.setText(itemDTO.day);
        holder.tvAuditory.setText(String.valueOf(itemDTO.auditory));
        holder.tvLesson.setText(itemDTO.lesson);
        holder.tvType.setText(itemDTO.type);
        holder.tvTime.setText(itemDTO.time);
        holder.tvTeacher.setText(itemDTO.teacher);
    }
    public void add(List<ItemDTO> itemDTOList) {
        this.itemList = itemDTOList;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class FavouriteViewHolder extends RecyclerView.ViewHolder {
        CardView itemCard;
        TextView tvDay, tvTime, tvTeacher, tvType, tvLesson, tvAuditory;
        public FavouriteViewHolder(final View itemView) {
            super(itemView);
            itemCard = (CardView) itemView.findViewById(R.id.favCard);
            tvDay = (TextView) itemView.findViewById(R.id.tv_fav_day);
            tvTime = (TextView) itemView.findViewById(R.id.tv_fav_time);
            tvTeacher = (TextView) itemView.findViewById(R.id.tv_fav_teacher);
            tvType = (TextView) itemView.findViewById(R.id.tv_fav_type);
            tvLesson = (TextView) itemView.findViewById(R.id.tv_fav_lesson);
            tvAuditory = (TextView) itemView.findViewById(R.id.tv_fav_auditory);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Snackbar.make(view, "Удалить из списка?", Snackbar.LENGTH_LONG).setAction("Да", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            LessonModel lm = new LessonModel();

                            lm.setTeacher(tvTeacher.getText().toString());
                            lm.setType(tvType.getText().toString());
                            lm.setTime(tvTime.getText().toString());
                            lm.setAuditory(Integer.parseInt(tvAuditory.getText().toString()));
                            lm.setDay(tvDay.getText().toString());
                            lm.setLection(tvLesson.getText().toString());
                            itemList.remove(getAdapterPosition());
                            new DatabaseManager().deleteItem(view.getContext(), lm);
                            notifyDataSetChanged();
                        }
                    }).show();
                    return false;
                }
            });
        }
    }
}
