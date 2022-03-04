package com.example.btvnw5;

import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Adapter.FolderAdapter;
import Listener.RecyclerTouchListener;
import model.Folder;

public class Folder_Activity extends AppCompatActivity {

    private List<Folder> folderList;
    private RecyclerView recyclerView;
    private FolderAdapter folderAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folder_activity);
        init();
        setFolderToolbar();
        handleEvent();

    }

    public void setFolderToolbar() {
        Toolbar folderToolbar = findViewById(R.id.folder_toolbar);
        folderToolbar.inflateMenu(R.menu.menu_item_folder);
//        setSupportActionBar(folderToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void init() {
        folderList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            folderList.add(new Folder("Video"));
        }
        recyclerView = findViewById(R.id.rcv_folder);
        folderAdapter = new FolderAdapter(folderList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(folderAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
//                linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void handleEvent() {
        Toolbar folderToolbar = findViewById(R.id.folder_toolbar);
        folderToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.add_new_file) {
                    folderList.add(new Folder("Video"));
                    folderAdapter.notifyItemInserted(folderList.size() - 1);
                }
                return true;
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Toast.makeText(view.getContext(), "onClick phần tử " + position, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        Toast.makeText(view.getContext(), "onLongClick phần tử " + position, Toast.LENGTH_SHORT).show();

                    }
                }));


    }
}
