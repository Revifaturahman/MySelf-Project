package com.example.a10122001_pa3.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10122001_pa3.Adapter.GalleryAdapter
import com.example.a10122001_pa3.Model.GalleryItem
import com.example.a10122001_pa3.R

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        recyclerView = view.findViewById(R.id.galleryRecyclerView)

        val imageList = listOf(
            GalleryItem(R.drawable.fadil),
            GalleryItem(R.drawable.hilmy),
            GalleryItem(R.drawable.danu),
            GalleryItem(R.drawable.zaidan),
            GalleryItem(R.drawable.umam),
            GalleryItem(R.drawable.barol),
            GalleryItem(R.drawable.abil),
            GalleryItem(R.drawable.tijar),
            GalleryItem(R.drawable.dhafin),
            GalleryItem(R.drawable.revi)
        )

        galleryAdapter = GalleryAdapter(imageList)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = galleryAdapter

        return view
    }
}
