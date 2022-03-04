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

import model.PDF;

public class PDFAdapter extends RecyclerView.Adapter<PDfViewHolder> {
    private List<PDF> PDFList;
    private Context context;

    public PDFAdapter(List<PDF> PDFList, Context context) {
        this.PDFList = PDFList;
        this.context = context;
    }

    @NonNull
    @Override
    public PDfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View PDFView = layoutInflater.inflate(R.layout.pdffile,parent,false);

        return new PDfViewHolder(PDFView);
    }

    @Override
    public void onBindViewHolder(@NonNull PDfViewHolder holder, int position) {
        PDF pdf = PDFList.get(position);

        holder.getPdf_name().setText(pdf.getName());

    }

    @Override
    public int getItemCount() {
        return PDFList.size();
    }
}

class PDfViewHolder extends RecyclerView.ViewHolder {
    private TextView pdf_name;


    public PDfViewHolder(@NonNull View itemView) {
        super(itemView);
        this.pdf_name = itemView.findViewById(R.id.tv_filename);
    }

    public TextView getPdf_name() {
        return pdf_name;
    }

    public void setPdf_name(TextView pdf_name) {
        this.pdf_name = pdf_name;
    }
}
