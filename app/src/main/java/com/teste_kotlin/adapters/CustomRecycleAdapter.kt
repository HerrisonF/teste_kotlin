package com.teste_kotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teste_kotlin.R
import com.teste_kotlin.model.Persona

class CustomRecycleAdapter : RecyclerView.Adapter<CustomRecycleAdapter.PersonaViewHolder>() {

    inner class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Persona>() {

        override fun areItemsTheSame(oldItem: Persona, newItem: Persona): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Persona, newItem: Persona): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder =
        PersonaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_char, parent, false)
        )

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val persona = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(persona.image).into(this.findViewById(R.id.ivCharImage))
            val tvName: TextView = this.findViewById(R.id.tvName)
            val tvType: TextView = this.findViewById(R.id.tvType)
            tvName.text = persona.name
            tvType.text = persona.type

            setOnClickListener{
                onItemClickListener?.let {
                    click -> click(persona)
                }
            }
        }
    }

    private var onItemClickListener: ((Persona) -> Unit)? = null

    fun setOnClickListener(listener: (Persona) -> Unit){
        onItemClickListener = listener
    }

}