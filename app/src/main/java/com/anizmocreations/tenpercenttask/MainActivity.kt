package com.anizmocreations.tenpercenttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anizmocreations.tenpercenttask.adapter.TopicsAdapter
import com.anizmocreations.tenpercenttask.adapter.callback.TopicsListCallback
import com.anizmocreations.tenpercenttask.model.Topic
import com.anizmocreations.tenpercenttask.viewmodel.MyViewModelFactory
import com.anizmocreations.tenpercenttask.viewmodel.TopicViewModel
import com.anizmocreations.tenpercenttask.viewmodel.repository.MainRepository
import com.anizmocreations.tenpercenttask.viewmodel.repository.remote.APIService
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Detect Mobile network
 *
 * Offline caching ** with warning "Showing older data because internet is not available"
 *
 * App Icon - adaptable icon
 *
 * ProgressBar
 */
class MainActivity : AppCompatActivity(), TopicsListCallback {

    private var topicsAdapter : TopicsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this,
            MyViewModelFactory(MainRepository(APIService.getInstance())))
            .get(TopicViewModel::class.java)

        topics_list.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.margin))
        )

        pull_to_refresh.setOnRefreshListener {
            viewModel.getTopics()
        }

        viewModel.getFeaturedTopicsLiveData().observe(this, {
            topicsAdapter?.setFeaturedTopicsList(it)
            pull_to_refresh.isRefreshing = false
        })

        viewModel.getTopics()
        topicsAdapter = TopicsAdapter(this, this)
        topics_list.layoutManager = LinearLayoutManager(this)
        topics_list.adapter = topicsAdapter

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