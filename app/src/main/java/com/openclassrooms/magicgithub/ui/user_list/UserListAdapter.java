package com.openclassrooms.magicgithub.ui.user_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.utils.UserDiffCallback;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<ListUserViewHolder> {

    // FOR CALLBACK ---
    private final Listener callback;
    // FOR DATA ---
    private List<User> users = new ArrayList<>();

    public UserListAdapter(Listener callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public ListUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list_user, parent, false);
        return new ListUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserViewHolder holder, int position) {
        holder.bind(users.get(position), callback);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void updateList(List<User> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new UserDiffCallback(newList, this.users));
        this.users = new ArrayList<>(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    // PUBLIC API ---

    public interface Listener {
        void onClickDelete(User user);
    }
}
