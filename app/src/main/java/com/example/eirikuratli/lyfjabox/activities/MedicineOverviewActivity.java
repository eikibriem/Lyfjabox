package com.example.eirikuratli.lyfjabox.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eirikuratli.lyfjabox.R;
import com.example.eirikuratli.lyfjabox.models.Drug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MedicineOverviewActivity extends AppCompatActivity {
//Activity for viewing all registered medication along with the option of editing the registration (example: turn notifications on or off).
    private RecyclerView mRecyclerOverView;
    private OverviewAdapter mAdapter;
    private List<Drug> registeredDrugs = createDrugs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_overview);
        mRecyclerOverView = (RecyclerView) findViewById(R.id.recyclerview_overview);

        mRecyclerOverView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new OverviewAdapter(registeredDrugs);
        mRecyclerOverView.setAdapter(mAdapter);
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

    private static class OverviewAdapter extends RecyclerView.Adapter<MedicineOverviewActivity.OverviewViewHolder> {
        private List<Drug> drugList;

        public OverviewAdapter(List<Drug> drugs) {
            drugList = drugs;
        }
        public void updateList(List<Drug> drugs) {
            drugList = drugs;
            notifyDataSetChanged();
        }

        @Override
        public MedicineOverviewActivity.OverviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.overview_item, parent, false);
            return new MedicineOverviewActivity.OverviewViewHolder(linearLayout, parent.getContext());
        }

        @Override
        public void onBindViewHolder(MedicineOverviewActivity.OverviewViewHolder holder, final int position) {
            final Drug currentDrug = drugList.get(position);
            holder.setDrug(currentDrug);

            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), MedicineInfoActivity.class);
                    intent.putExtra("SelectedDrug", currentDrug);
                    view.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return drugList.size();
        }
    }

    private static class OverviewViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayout;
        public TextView drugNameText;
        private Context context;

        public OverviewViewHolder(LinearLayout linearLayout, Context context) {
            super(linearLayout);
            this.linearLayout = linearLayout;
            drugNameText = (TextView) linearLayout.findViewById(R.id.overview_drug_name);
            this.context = context;
        }

        public void setDrug(Drug currentDrug) {
            drugNameText.setText(currentDrug.getName());
        }
    }
}
