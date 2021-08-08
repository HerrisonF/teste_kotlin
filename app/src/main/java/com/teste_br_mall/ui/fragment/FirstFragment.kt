package com.teste_br_mall.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teste_br_mall.R
import com.teste_br_mall.adapters.CustomRecycleAdapter
import com.teste_br_mall.model.Persona
import com.teste_br_mall.model.data.PersonaDataSource
import com.teste_br_mall.presenter.ViewHome
import com.teste_br_mall.presenter.persona.PersonaPresenter

class FirstFragment : Fragment(), ViewHome.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: PersonaPresenter
    private lateinit var vieww: View

    private val customAdapter  by lazy {
        CustomRecycleAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vieww = inflater.inflate(R.layout.fragment_first, container, false)

        recyclerView = vieww.findViewById(R.id.rvChar)

        recyclerView.adapter = customAdapter

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    presenter.requestAll()
                }
            }
        })

        val dataSource = PersonaDataSource()
        presenter = PersonaPresenter(this, dataSource)
        presenter.requestAll()

        return vieww
    }

    override fun showProgressBar() {
        val t = vieww.findViewById<ProgressBar>(R.id.rvProgressBar)
        t.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(vieww.context, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        val t = vieww.findViewById<ProgressBar>(R.id.rvProgressBar)
        t.visibility = View.INVISIBLE
    }

    override fun showPersona(persona: MutableList<Persona>) {
        customAdapter.differ.submitList(persona.toList())
    }

}