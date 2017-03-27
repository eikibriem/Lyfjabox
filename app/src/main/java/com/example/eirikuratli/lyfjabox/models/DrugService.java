package com.example.eirikuratli.lyfjabox.models;

import java.util.Collections;
import java.util.List;

/**
 * Created by thorunn on 26/03/17.
 */

public class DrugService {
    DrugRepository repository = new DrugRepository();

    /**
     * Insert a {@link Drug}
     * @param drug {@link Drug} to be inserted
     * @return {@link Drug} that was inserted
     */
    public Drug insert(Drug drug) {
        return repository.insert(drug);
    }

    /**
     * Delete {@link Drug}
     * @param drug {@link Drug} to be deleted
     */
    public void delete(Drug drug) {
        repository.delete(drug);
    }

    /**
     * Get all {@link Drug}s
     * @return A list of {@link Drug}s
     */
    public List<Drug> findAll() {
        return repository.findAll();
    }

    /**
     * Get all {@link Drug}s in a reverse order
     * @return A reverse list of {@link Drug}s
     */
    public List<Drug> findAllReverseOrder() {
       return repository.findAllReverseOrder();
    }

    /**
     * Find all {@link Drug}s with {@link String name}
     * @param name {@link String}
     * @return All {@link Drug}s with the {@link String name} passed
     */
    public List<Drug> findByName(String name) {
        System.out.println(name);
        return repository.findByName(name);
    }

    /**
     * Find all {@link Drug}s with {@link String activeIngr}
     * @param activeIngr {@link String}
     * @return All {@link Drug}s with the {@link String activeIngr} passed
     */
    public List<Drug> findByActiveIngr(String activeIngr) {
        return repository.findByActiveIngr(activeIngr);
    }

}
