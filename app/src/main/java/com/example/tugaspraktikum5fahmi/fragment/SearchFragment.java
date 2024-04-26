package com.example.tugaspraktikum5fahmi.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import com.example.tugaspraktikum5fahmi.DataSource;
import com.example.tugaspraktikum5fahmi.MamaliaPurba;
import com.example.tugaspraktikum5fahmi.R;
import com.example.tugaspraktikum5fahmi.SeacrhAdapter;
import  com.example.tugaspraktikum5fahmi.fragment.HomeFragment;
import  com.example.tugaspraktikum5fahmi.fragment.HomeFragment;
import  com.example.tugaspraktikum5fahmi.fragment.HomeFragment;
import  com.example.tugaspraktikum5fahmi.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private ArrayList<MamaliaPurba> mamaliaPurbas;
    private RecyclerView recyclerView;
    private SeacrhAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        int numberOfColumns  = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));

        adapter = new SeacrhAdapter(mamaliaPurbas);
        recyclerView.setAdapter(adapter);

        ImageView iv_home = view.findViewById(R.id.IV_Home);
        ImageView iv_profile = view.findViewById(R.id.IV_Profile);
        ImageView iv_posting = view.findViewById(R.id.IV_Post);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);


        SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            public boolean onQueryTextSubmit(String query) {
                searchItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

            private void searchItems(String newText) {
                progressBar.setVisibility(View.VISIBLE);
                ExecutorService executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());
                executor.execute(()->{
                    ArrayList<MamaliaPurba> filteredList = new ArrayList<>();
                    if (!newText.isEmpty()) {
                        for (MamaliaPurba item : DataSource.mamaliaPurba) {
                            if (item.getUsername().toLowerCase().contains(newText.toLowerCase()) ||
                                    item.getName().toLowerCase().contains(newText.toLowerCase())) {
                                filteredList.add(item);
                            }
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(() -> {
                        progressBar.setVisibility(View.GONE);
                        mamaliaPurbas.clear();
                        if (!newText.isEmpty()) {
                            mamaliaPurbas.addAll(filteredList);
                        }
                        adapter.notifyDataSetChanged();
                    });
                });      
                
            }

        });
        iv_home.setOnClickListener(v -> {
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_posting.setOnClickListener(v -> {
            PostinganFragment postinganFragment = new PostinganFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postinganFragment)
                    .addToBackStack(null)
                    .commit();
        });
        iv_profile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });

    }
}