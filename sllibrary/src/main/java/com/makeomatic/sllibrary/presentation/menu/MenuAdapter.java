package com.makeomatic.sllibrary.presentation.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.makeomatic.sllibrary.R;
import com.makeomatic.sllibrary.domain.menu.Menu;

import java.util.List;

/**
 * Created by OLEG on 10.11.2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final List<Menu> items;
    private View.OnClickListener onItemClickListener;
    private Context context;

    public MenuAdapter(Context context, List<Menu> items) {
        this.items = items;
        this.context = context;
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        View itemView;

        public MenuViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(onItemClickListener);
            imageView = itemView.findViewById(R.id.imageView);
            this.itemView = itemView;
        }

        public void bind(Menu item) {
            Resources res =  context.getResources();
            int resID = res.getIdentifier(item.getImage() , "drawable", context.getPackageName());
            imageView.setImageResource(resID);
            itemView.setTag(item);
        }
    }
}
