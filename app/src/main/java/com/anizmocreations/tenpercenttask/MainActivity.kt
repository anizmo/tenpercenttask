package com.anizmocreations.tenpercenttask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anizmocreations.tenpercenttask.adapter.TopicsAdapter
import com.anizmocreations.tenpercenttask.adapter.callback.TopicsListCallback
import com.anizmocreations.tenpercenttask.model.Topic
import com.anizmocreations.tenpercenttask.repository.MainRepository
import com.anizmocreations.tenpercenttask.repository.remote.APIService
import com.anizmocreations.tenpercenttask.viewmodel.MyViewModelFactory
import com.anizmocreations.tenpercenttask.viewmodel.TopicViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This Activity calls the TenPercent get topics API and renders the featured topics on the
 * landing page of the app. The call is made using Retrofit and it is delivered through LiveData
 * from a ViewModel. As it is using Android Architectural Components, the application is lifecycle
 * aware and the data delivery is also lifecycle aware.
 */
class MainActivity : AppCompatActivity(), TopicsListCallback {

    private var topicViewModel: TopicViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Comment the line below to enable the light and dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(R.layout.activity_main)

        setupTopicsRecyclerView()
        setupTopicLiveData()

        topicViewModel?.fetchTopics()
    }

    private fun setupTopicLiveData() {

        topicViewModel = ViewModelProvider(
            this,
            MyViewModelFactory(MainRepository(APIService.getInstance()))
        )
            .get(TopicViewModel::class.java)

        topicViewModel?.getFeaturedTopicsLiveData()?.observe(this, {
            progress_circular.visibility = View.GONE
            topics_list.adapter = TopicsAdapter(this, this, it)
        })

        topicViewModel?.getErrorMessageLiveData()?.observe(this, {
            progress_circular.visibility = View.GONE
            error_text.visibility = View.VISIBLE
            Snackbar.make(
                activity_main_constraint, getString(R.string.snackbar_call_failed),
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction(getString(R.string.retry)) {
                    error_text.visibility = View.GONE
                    progress_circular.visibility = View.VISIBLE
                    topicViewModel?.fetchTopics()
                }.show()
        })

    }

    private fun setupTopicsRecyclerView() {

        topics_list.layoutManager = LinearLayoutManager(this)

        topics_list.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.margin))
        )

    }

    override fun onTopicClicked(topic: Topic) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(topic.title)
        builder.setMessage(topic.description_short)

        builder.setPositiveButton(android.R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()

    }

}