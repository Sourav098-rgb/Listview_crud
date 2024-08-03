package com.example.listview_crud

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listview_crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var list = arrayListOf<Data>()
    lateinit var recycleAdapter: Recycle_Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        list.add(Data("sourav",51,"CCNA"))
        list.add(Data("harsh",30,"CNS"))
        list.add(Data("joshi",49,"Java"))
        recycleAdapter= Recycle_Adapter(list,this)
        binding.RecycleViewItem.layoutManager= LinearLayoutManager(
            this,LinearLayoutManager.HORIZONTAL,false
        )
        binding.RecycleViewItem.adapter=recycleAdapter

        binding.ADDBtn.setOnClickListener {
            val dialog=Dialog(this)
            dialog.setContentView(R.layout.activity_add_list)
            val name=dialog.findViewById<TextView>(R.id.InputStudentName)
            val rollno=dialog.findViewById<TextView>(R.id.Input_rollno)
            val subject=dialog.findViewById<TextView>(R.id.InputSubject)
            val button=dialog.findViewById<Button>(R.id.ADD_btn)
            dialog.show()
            button.setOnClickListener {
                val name=name.text.toString()
                val rollno=rollno.text.toString()
                val subject=subject.text.toString()
                if (rollno.isNullOrEmpty()||name.isNullOrEmpty()||subject.isNullOrEmpty()){
                    Toast.makeText(this, "Enter Valid Details", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }else{
                    list.add(Data(name,rollno.toInt(),subject))
                    recycleAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
        }
    }
}