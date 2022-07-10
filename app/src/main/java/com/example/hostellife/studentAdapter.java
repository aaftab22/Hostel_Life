package com.example.hostellife;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class studentAdapter extends RecyclerView.Adapter<studentAdapter.myviewholder>{

    List<StudentModel> students;
    public studentAdapter(List<StudentModel> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public studentAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_card,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull studentAdapter.myviewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.fullname.setText(students.get(position).getFullname());
        holder.emailid.setText(students.get(position).getEmail());
        holder.address.setText(students.get(position).getAddress());
        holder.deleteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = Room.databaseBuilder(holder.fullname.getContext(),
                        AppDatabase.class, "hostelDatabase").allowMainThreadQueries().build();
                studentDao studentDao = db.studentDao();
                studentDao.deleteById(students.get(position).getStudentId());
                students.remove(position);
                notifyDataSetChanged();
                Toast.makeText(v.getContext(), "Data Deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });


        holder.updateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.emailid.getContext(),updateData.class);
                intent.putExtra("sID",String.valueOf(students.get(position).getStudentId()));
                intent.putExtra("fullname",students.get(position).getFullname());
                intent.putExtra("address",students.get(position).getAddress());
                intent.putExtra("email",students.get(position).getEmail());
                intent.putExtra("contact",students.get(position).getContactno());
                holder.updateBTN.getContext().startActivity(intent);
            }
        });


    }
    @Override
    public int getItemCount() {
        return students.size();
    }


    //view holder
    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView fullname, emailid, address;
        ImageView deleteBTN,updateBTN;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            fullname= itemView.findViewById(R.id.student_CVname_ID);
            emailid= itemView.findViewById(R.id.student_CVemail_ID);
            address = itemView.findViewById(R.id.student_CVaddress_ID);
            deleteBTN = itemView.findViewById(R.id.student_delete_BTN_ID);
            updateBTN = itemView.findViewById(R.id.student_update_icon_ID);
        }
    }

}
