package com.example.clase_8__lunes_15092020

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clase_8__lunes_15092020.model.Terrain
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlinx.android.synthetic.main.item_list_view.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), MarsAdapter.Mars {

    lateinit var mViewModel: MarsViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)

    }
     override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // aqui la vista ya se ha creado
        super.onViewCreated(view, savedInstanceState)

        val mRecyclerView = recyclerView
        val mAdapter = MarsAdapter(this)
            mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = GridLayoutManager(context,2)
       mViewModel.exposeLiveDataFromServer().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
           Log.d("VIEW",it.toString())
           mAdapter.updateListMars(it)
       })


        }

    override fun passMars(mTerrain: Terrain) {
        TODO("Not yet implemented")

    }

    }
