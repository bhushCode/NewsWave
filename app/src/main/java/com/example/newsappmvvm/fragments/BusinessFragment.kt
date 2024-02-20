package com.example.newsappmvvm.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappmvvm.R
import com.example.newsappmvvm.adapter.NewsAdapter
import com.example.newsappmvvm.repository.NewsRepository
import com.example.newsappmvvm.retrofit.NewsApi
import com.example.newsappmvvm.retrofit.RetrofitHelper
import com.example.newsappmvvm.viewmodel.MainViewModel
import com.example.newsappmvvm.viewmodel.MainViewModelFactory
import com.facebook.shimmer.ShimmerFrameLayout

class BusinessFragment : Fragment() {
    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: NewsAdapter
    lateinit var BusinesssReView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var shimmer: ShimmerFrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


     val view =    inflater.inflate(R.layout.fragment_business, container, false)
        BusinesssReView = view.findViewById(R.id.business_recView)
        shimmer = view.findViewById(R.id.shimmer_layout_buissness)
        shimmer.startShimmer()
        progressBar = view.findViewById(R.id.buiness_progressBar)
     //   progressBar.visibility =View.VISIBLE
        adapter = NewsAdapter()

        val newsApi = RetrofitHelper().getInstance().create(NewsApi::class.java)
        val repository = NewsRepository(newsApi,"business", requireContext())
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.news.observe(viewLifecycleOwner, Observer {
            Log.d("Hula",it.toString())
            shimmer.stopShimmer()
            shimmer.visibility=View.GONE
            BusinesssReView.visibility=View.VISIBLE
          //  progressBar.visibility=View.INVISIBLE
            //   Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG).show()
            adapter.submitList(it.articles)
            BusinesssReView.layoutManager = LinearLayoutManager(context)
            BusinesssReView.adapter = adapter
        })

        return  view
    }


    }
