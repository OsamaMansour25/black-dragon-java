package dk.acto.blackdragon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
public class Stats {
    private BigInteger evenIds;
    private BigInteger oddIds;
    private BigDecimal meanCost;
    private BigDecimal weightedInventory;
    private BigInteger totalInventory;

    @Builder(builderMethodName = "statsBuilder")
    public Stats(BigInteger evenIds, BigInteger oddIds, BigDecimal meanCost, BigDecimal weightedInventory, BigInteger totalInventory) {
        this.evenIds = evenIds;
        this.oddIds = oddIds;
        this.meanCost = meanCost;
        this.weightedInventory = weightedInventory;
        this.totalInventory = totalInventory;
    }
}

