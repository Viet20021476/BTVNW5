package com.example.btvnw5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.PDFAdapter;
import model.PDF;

public class PDF_Activity extends AppCompatActivity {
    private List<PDF> PDFList;
    private RecyclerView recyclerView;
    private PDFAdapter pdfAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_activity);
        init();
        setToolBar();
        handleEvent();
    }

    public void setToolBar() {
        Toolbar toolbar = findViewById(R.id.pdf_toolbar);
        toolbar.inflateMenu(R.menu.menu_item_pdf);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.search) {
                    Toast.makeText(getApplicationContext(), "Đây là nút search", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.option) {
                    Toast.makeText(getApplicationContext(), "Đây là nút option", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    public List<PDF> setPDFList() {
        List<PDF> pdfList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            pdfList.add(new PDF("To skill a Mockingbird"));
        }
        return pdfList;
    }

    public void init() {
        this.PDFList = setPDFList();
        this.pdfAdapter = new PDFAdapter(PDFList, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.recyclerView = findViewById(R.id.rcv_pdf);
        this.recyclerView.setAdapter(pdfAdapter);
        this.recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void handleEvent() {
        ImageView iv_add = findViewById(R.id.iv_add);
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PDFList.add(new PDF("To skill a Mockingbird"));
                pdfAdapter.notifyItemInserted(PDFList.size() - 1);
                Toast toast = Toast.makeText(getApplicationContext(), "You added a new file", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.START,90,0);
                toast.show();

            }
        });
    }
}