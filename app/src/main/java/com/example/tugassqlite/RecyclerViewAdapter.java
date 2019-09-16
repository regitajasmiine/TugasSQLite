package com.example.tugassqlite;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder> {
    Context context;
    OnUserClickListener listener;
    List<Siswa> listPersonInfo;
    public RecyclerViewAdapter(Context context, List<Siswa>
            listPersonInfo, OnUserClickListener listener) {
        this.context=context;
        this.listPersonInfo=listPersonInfo;
        this.listener=listener;
    }
    public interface OnUserClickListener{
        void onUserClick(Siswa currentPerson, String action);
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view=
                LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_data,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final Siswa currentPerson=listPersonInfo.get(position);
        holder.ctxtName.setText(currentPerson.getName());
        holder.ctxtJenkel.setText(currentPerson.getJenkel()+"");
        holder.ctxtAlamat.setText(currentPerson.getAlamat()+"");
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        final View view = LayoutInflater.from(context).inflate(R.layout.activity_inputdata, null);
        dialog.setView(view);
        final TextView lihatData= view.findViewById(R.id.lihatData);
        final TextView updateData= view.findViewById(R.id.updateData);
        final TextView deleteData= view.findViewById(R.id.hapusData);


                final AlertDialog alertDialog = dialog.create();

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.onUserClick(currentPerson,"Menu");

                deleteData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onUserClick(currentPerson,"Delete");

                    }
                });
                lihatData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onUserClick(currentPerson,"Lihat");
                    }
                });
                updateData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onUserClick(currentPerson, "Update");
                    }
                });
                alertDialog.show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView ctxtJenkel,ctxtName,ctxtAlamat;
        ImageView imgMenu;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ctxtJenkel=itemView.findViewById(R.id.ctxtjenkel);
            cardView=itemView.findViewById(R.id.card);
            ctxtName=itemView.findViewById(R.id.ctxtName);
            ctxtAlamat=itemView.findViewById(R.id.ctxtalamat);
            imgMenu=itemView.findViewById(R.id.menu);
        }
    }
}
