package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvnw5.R;

import java.util.List;

import model.Folder;

public class FolderAdapter extends RecyclerView.Adapter<FolderViewHolder> {
    private List<Folder> folderList;
    private Context context;

    public FolderAdapter(List<Folder> folderList, Context context) {
        this.folderList = folderList;
        this.context = context;
    }

    @NonNull
    @Override
    public FolderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View folderView = layoutInflater.inflate(R.layout.folder, parent, false);

        return new FolderViewHolder(folderView);
    }

    @Override
    public void onBindViewHolder(@NonNull FolderViewHolder holder, int position) {
        Folder folder = folderList.get(position);

        holder.getFolderName().setText(folder.getFolderName());

    }

    @Override
    public int getItemCount() {
        return folderList.size();
    }
}

class FolderViewHolder extends RecyclerView.ViewHolder {
    private TextView folderName;

    public FolderViewHolder(@NonNull View itemView) {
        super(itemView);
        folderName = itemView.findViewById(R.id.tv_folder_name);
    }

    public TextView getFolderName() {
        return folderName;
    }
}
