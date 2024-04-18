package com.betelgeuse.corp.autosell.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betelgeuse.corp.autosell.Model.Car
import com.betelgeuse.corp.autosell.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var carAdapter: CarAdapter? = null
    private var carList = mutableListOf<Car>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val addCarBtn: FloatingActionButton = findViewById(R.id.addCarBtn)
        addCarBtn.setOnClickListener {
            val intent = Intent(this, CreateCarActivity::class.java)
            startActivity(intent)
        }

        carList = ArrayList()

        recyclerView = findViewById<View>(R.id.carView) as RecyclerView
        carAdapter = CarAdapter(carList, this@MainActivity)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = carAdapter

        carsList()
    }

    //Test Presentation
    private fun carsList(){
        var car = Car("Audi","2024","2000000", R.drawable.audi)
        carList.add(car)

        car = Car("Mercedes","2020","5000000", R.drawable.mercedes)
        carList.add(car)

        car = Car("Porsche","2021","9500000", R.drawable.porsche)
        carList.add(car)

        car = Car("Ferrari","2024","2000000", R.drawable.ferrari)
        carList.add(car)

        carAdapter!!.notifyDataSetChanged()
    }
}