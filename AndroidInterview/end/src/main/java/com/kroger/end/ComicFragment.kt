package com.kroger.end

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicFragment : Fragment() {

    private val comicViewModel: ComicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicViewModel.comic.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.title).text = it.title
            view.findViewById<TextView>(R.id.alt).text = it.alt
            view.findViewById<ImageView>(R.id.image).loadImageWithGlideApp(it.img)
        }
        comicViewModel.start()
    }
}