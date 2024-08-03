package com.example.listview_crud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Recycle_Adapter(val list: ArrayList<Data>, val OnclickListner: MainActivity):
        RecyclerView.Adapter<Recycle_Adapter.ViewHolder>() {
            class ViewHolder(var view:View):RecyclerView.ViewHolder(view){
                val name=view.findViewById<TextView>(R.id.Name)
                val rollno = view.findViewById<TextView>(R.id.RollNo)
                val subject = view.findViewById<TextView>(R.id.Subject)
                val btn = view.findViewById<Button>(R.id.Update)
                val btn2 = view.findViewById<Button>(R.id.Delete)
            }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Recycle_Adapter.ViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.activity_input,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            name.setText(list[position].Name)
            rollno.setText(list[position].RollNo.toString())
            subject.setText(list[position].Subject)
            btn.setOnClickListener {
                OnclickListener.update(position)
            }
            btn2.setOnClickListener {
                OnclickListener.delete(position)
            }

    }
}
    interface Onclick{
        fun update(position: Int)
        fun delete(position: Int)

    }    }

class OnclickListener {
    companion object {
        fun update(position: Int) {

        }

        fun delete(position: Int) {

        }
    }

}
