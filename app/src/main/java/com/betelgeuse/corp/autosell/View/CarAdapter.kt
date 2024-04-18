package com.betelgeuse.corp.autosell.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.betelgeuse.corp.autosell.Model.Car
import com.betelgeuse.corp.autosell.R
import com.bumptech.glide.Glide

class CarAdapter(
    private var cars: List<Car>,
    private val getActivity: MainActivity
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameCar)
        val ageTextView: TextView = itemView.findViewById(R.id.ageCar)
        val priceTextView: TextView = itemView.findViewById(R.id.priceCar)
        val photoImageView: ImageView = itemView.findViewById(R.id.carPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentCar = cars[position]
        holder.nameTextView.text = currentCar.name
        holder.ageTextView.text = currentCar.age
        holder.priceTextView.text = currentCar.price

        Glide.with(holder.itemView.context)
            .load(currentCar.photoUri)
            .into(holder.photoImageView)
    }

    override fun getItemCount(): Int {
        return cars.size
    }
}
