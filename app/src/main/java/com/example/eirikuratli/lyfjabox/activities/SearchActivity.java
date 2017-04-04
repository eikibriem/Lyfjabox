package com.example.eirikuratli.lyfjabox.activities;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eirikuratli.lyfjabox.R;
import com.example.eirikuratli.lyfjabox.models.Drug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
//TODO: create search that displays result in a list below, to be implemented and designed

    private RecyclerView mRecyclerView;
    private SearchAdapter sAdapter;
    List<Drug> allDrugs = createDrugs();


    //Replaces the search that was intended in the HomeActivity. Uses recycler view. Here users can
    //search for medication that is available in the database. A click on a list item will open
    //MedicineInfoActivity.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sAdapter = new SearchAdapter(allDrugs);
        mRecyclerView.setAdapter(sAdapter);
    }

    private List<Drug> filterList(List<Drug> drugs, String name) {
        ArrayList<Drug> filteredDrugs = new ArrayList<>();
        for (Drug drug : drugs) {
            if (drug.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredDrugs.add(drug);
            }
        }
        return filteredDrugs;
    }

    private List<Drug> createDrugs() {
        ArrayList<Drug> drugs = new ArrayList<>();

        Drug ibuprofen = new Drug();
        ibuprofen.setName("Ibuprofen");

        Drug paracetamol = new Drug();
        paracetamol.setName("Paracetamol");

        Drug aspirin = new Drug();
        aspirin.setName("Aspirin");

        Drug microgyn = new Drug();
        microgyn.setName("Microgyn");

        Drug venlafaxin = new Drug();
        venlafaxin.setName("Venlafaxin");

        Drug wellbutrin = new Drug();
        wellbutrin.setName("Wellbutrin");

        Drug yasminelle = new Drug();
        yasminelle.setName("Yasminelle");

        Drug amfetamin = new Drug();
        amfetamin.setName("Amfetamín");

        Drug morphine = new Drug();
        morphine.setName("Morphine");

        drugs.add(morphine);
        drugs.add(amfetamin);
        drugs.add(yasminelle);
        drugs.add(wellbutrin);
        drugs.add(venlafaxin);
        drugs.add(microgyn);
        drugs.add(aspirin);
        drugs.add(paracetamol);
        drugs.add(ibuprofen);
        Collections.sort(drugs);
        return drugs;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        sAdapter.updateList(filterList(allDrugs, newText));
        return false;
    }

    private static class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
        private List<Drug> drugList;

        public SearchAdapter(List<Drug> drugs) {
            drugList = drugs;
        }

        public void updateList(List<Drug> drugs) {
            drugList = drugs;
            notifyDataSetChanged();
        }

        @Override
        public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.search_item, parent, false);
            return new SearchViewHolder(linearLayout, parent.getContext());
        }

        @Override
        public void onBindViewHolder(SearchViewHolder holder, final int position) {
            final Drug currentDrug = drugList.get(position);
            holder.setDrug(currentDrug);

            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), MedicineInfoActivity.class);
                    view.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return drugList.size();
        }
    }

    private static class SearchViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayout;
        public TextView drugNameText;
        private Context context;

        public SearchViewHolder(LinearLayout linearLayout, Context context) {
            super(linearLayout);
            this.linearLayout = linearLayout;
            drugNameText = (TextView) linearLayout.findViewById(R.id.drug_name);
            this.context = context;
        }

        public void setDrug(Drug currentDrug) {
            drugNameText.setText(currentDrug.getName());
        }
    }
}

