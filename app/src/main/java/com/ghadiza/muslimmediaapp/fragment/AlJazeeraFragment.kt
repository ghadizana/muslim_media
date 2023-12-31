package com.ghadiza.muslimmediaapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghadiza.muslimmediaapp.NewsViewModel
import com.ghadiza.muslimmediaapp.adapter.NewsAdapter
import com.ghadiza.muslimmediaapp.databinding.FragmentAlJazeeraBinding

class AlJazeeraFragment : Fragment() {
    private var _binding: FragmentAlJazeeraBinding? = null
    private val binding get() = _binding as FragmentAlJazeeraBinding

    private var _alJazeeraModel: NewsViewModel? = null
    private val alJazeeraModel get() = _alJazeeraModel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlJazeeraBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _alJazeeraModel = ViewModelProvider(this)[NewsViewModel::class.java]
        alJazeeraModel.alJazeeraNews()
        alJazeeraModel.alJazeeraNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i(
                "AlJazeeraFragment",
                "onViewCreated: ${it.articles}"
            )
            binding.rvAlJazeera.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}