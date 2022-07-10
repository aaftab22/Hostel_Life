package com.example.hostellife;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class staffAdapter extends RecyclerView.Adapter<staffAdapter.myviewholder> {

    List<StaffModel> staff;

    public staffAdapter(List<StaffModel> staff) {
        this.staff = staff;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_card,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.fullname.setText(staff.get(position).getFullname());
        holder.emailid.setText(staff.get(position).getEmail());
        holder.address.setText(staff.get(position).getAddress());
        holder.deleteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(holder.fullname.getContext(),
                        AppDatabase.class, "HostelDatabase").allowMainThreadQueries().build();
                studentDao studentDao = db.studentDao();
                studentDao.deleteById(staff.get(position).getStaffId());
                staff.remove(position);
                notifyDataSetChanged();
                Toast.makeText(v.getContext(), "Data Deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });

        

    }

    @Override
    public int getItemCount() {
        return staff.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView fullname, emailid, address;
        ImageView deleteBTN, updateBTN;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.staff_CVname_ID);
            emailid = itemView.findViewById(R.id.staff_CVemail_ID);
            address = itemView.findViewById(R.id.staff_CVaddress_ID);
            deleteBTN = itemView.findViewById(R.id.staff_delete_BTN_ID);
            updateBTN = itemView.findViewById(R.id.staff_update_icon_ID);
        }
    }// myviewholder close
} //  main class close


