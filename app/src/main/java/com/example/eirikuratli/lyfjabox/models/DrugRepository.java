package com.example.eirikuratli.lyfjabox.models;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thorunn on 26/03/17.
 */

public class DrugRepository {

    private List<Drug> drugs = new ArrayList<>();

    public Drug insert(Drug drug) {
        drugs.add(drug);

        return drug;
    }

    void delete(Drug drug) {
        drugs.remove(drug);
    }

    List<Drug> findAll() {
        return drugs;
    }

    List<Drug> findAllReverseOrder() {
        List<Drug> reversedDrugs = new ArrayList<>();

        reversedDrugs.addAll(drugs);
        Collections.reverse(reversedDrugs);

        return reversedDrugs;
    }

    List<Drug> findByName(String name) {
        List<Drug> similarDrugs = new ArrayList<>();

        for (Drug drug : drugs) {
            if (drug.getName().contains(name)) {
                 similarDrugs.add(drug);
            }
        }

        return similarDrugs;
    }

    List<Drug> findByActiveIngr(String activeIngr) {
        List<Drug> matchingIngr = new ArrayList<>();

        for (Drug drug : drugs) {
            if (drug.getActiveIngr().contains(activeIngr)) {
                matchingIngr.add(drug);
            }
        }
        return matchingIngr;
    }

}
