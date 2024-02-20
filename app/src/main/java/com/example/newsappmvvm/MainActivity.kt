package com.example.newsappmvvm

import android.R.drawable
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.newsappmvvm.adapter.NewsAdapter
import com.example.newsappmvvm.databinding.ActivityMainBinding
import com.example.newsappmvvm.fragments.BusinessFragment
import com.example.newsappmvvm.fragments.GeneralFragment
import com.example.newsappmvvm.fragments.HealthFragment
import com.example.newsappmvvm.fragments.ScienceFragment
import com.example.newsappmvvm.fragments.SportsFragment
import com.example.newsappmvvm.fragments.TechnologyFragment
import com.example.newsappmvvm.fragments.TopHeadlinesFragment
import com.example.newsappmvvm.fragments.entertainmentFragment
import com.example.newsappmvvm.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {


   lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
lateinit var adapter:NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(android.R.color.transparent)
            window.navigationBarColor = resources.getColor(android.R.color.transparent)
            window.setBackgroundDrawable((getResources().getDrawable(R.drawable.top_bar_backround)))
        }

//        adapter = NewsAdapter()
//        val newsApi = RetrofitHelper().getInstance().create(NewsApi::class.java)
//        val repository = NewsRepository(newsApi,"topHeadlines")
//        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
//        mainViewModel.news.observe(this, Observer {
//           Log.d("Hula",it.toString())
//         //   Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG).show()
//             adapter.submitList(it.articles)
//            binding.recView.layoutManager = LinearLayoutManager(this)
//            binding.recView.adapter = adapter
//        })


        getFragement(TopHeadlinesFragment())

        binding.txtTopHeadLines.background = getDrawable(R.drawable.category_text_button_click)
        categoryChange()




        

        }

    private fun categoryChange( ) {
        binding.txtTopHeadLines.setOnClickListener(){

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTechnology.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtBusiness.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtGeneral.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtHealth.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtScience.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtSports.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtEntertainment.background = getDrawable(R.drawable.category_bar_border_color)

            getFragement(TopHeadlinesFragment())

        }

        binding.txtTechnology.setOnClickListener(){

            binding.txtTechnology.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtBusiness.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtGeneral.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtHealth.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtScience.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtSports.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtEntertainment.background = getDrawable(R.drawable.category_bar_border_color)

            getFragement(TechnologyFragment())
        }


        binding.txtBusiness.setOnClickListener()
        {
            binding.txtBusiness.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtTechnology.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtGeneral.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtHealth.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtScience.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtSports.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtEntertainment.background = getDrawable(R.drawable.category_bar_border_color)


            getFragement(BusinessFragment())


        }
        binding.txtGeneral.setOnClickListener()
        {
            binding.txtGeneral.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtTechnology.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtBusiness.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtHealth.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtScience.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtSports.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtEntertainment.background = getDrawable(R.drawable.category_bar_border_color)

            getFragement(GeneralFragment())
        }
        binding.txtHealth.setOnClickListener()
        {
            binding.txtHealth.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtTechnology.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtGeneral.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtBusiness.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtScience.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtSports.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtEntertainment.background = getDrawable(R.drawable.category_bar_border_color)

            getFragement(HealthFragment())
        }
        binding.txtScience.setOnClickListener()
        {
            binding.txtScience.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtTechnology.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtGeneral.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtHealth.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtBusiness.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtSports.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtEntertainment.background = getDrawable(R.drawable.category_bar_border_color)

            getFragement(ScienceFragment())

        }
        binding.txtSports.setOnClickListener()
        {
            binding.txtSports.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtTechnology.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtGeneral.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtHealth.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtScience.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtBusiness.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtEntertainment.background = getDrawable(R.drawable.category_bar_border_color)


            getFragement(SportsFragment())






        }

        binding.txtEntertainment.setOnClickListener()
        {
            binding.txtEntertainment.background = getDrawable(R.drawable.category_text_button_click)

            binding.txtTopHeadLines.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtTechnology.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtGeneral.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtHealth.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtScience.background = getDrawable(R.drawable.category_bar_border_color)
            binding.txtBusiness.background = getDrawable(R.drawable.category_bar_border_color)

            getFragement(entertainmentFragment())
        }


    }

    fun getFragement(fragment:Fragment)
    {
      //  val fragment:Fragment = SportsFragment()
        val t:FragmentTransaction = supportFragmentManager.beginTransaction()
        t.replace(R.id.framelayout,fragment).commit()

    }
}