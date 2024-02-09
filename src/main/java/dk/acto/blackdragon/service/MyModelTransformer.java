package dk.acto.blackdragon.service;


import dk.acto.blackdragon.model.Model;

import dk.acto.blackdragon.model.Stats;

import io.vavr.collection.List;

import java.math.BigDecimal;
import java.math.BigInteger;



public class MyModelTransformer implements ModelTransformer<Model, Stats> {

    @Override
    public Stats transform(List<Model> models) {
        long totalInventory = 0;
        int totalCost = 0;
        long evenIdsCount = 0;
        long oddIdsCount = 0;
        BigDecimal totalWeightedInventory = BigDecimal.ZERO;

        for (Model model : models) {

            totalInventory += model.getInventory();


            totalCost += model.getCost();


            if (model.getId() % 2 == 0) {
                evenIdsCount++;
            } else {
                oddIdsCount++;
            }

            // Calculating weighted inventory
            BigDecimal weight = BigDecimal.valueOf(model.getWeight());
            BigDecimal inventory = BigDecimal.valueOf(model.getInventory());
            totalWeightedInventory = totalWeightedInventory.add(weight.multiply(inventory));
        }


        int meanCost = totalCost / models.size();

        return Stats.builder()
                .evenIds(BigInteger.valueOf(evenIdsCount))
                .oddIds(BigInteger.valueOf(oddIdsCount))
                .meanCost(BigDecimal.valueOf(meanCost))
                .totalInventory(BigInteger.valueOf(totalInventory))
                .weightedInventory(totalWeightedInventory)
                .build();
    }
}
