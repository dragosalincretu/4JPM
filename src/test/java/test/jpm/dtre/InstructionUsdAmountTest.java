package test.jpm.dtre;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.fest.assertions.Assertions.assertThat;
import static test.jpm.dtre.InstructionBuilder.aInstruction;

public class InstructionUsdAmountTest {
    @Test
    public void calculateUsdAmountWhenUnitPriceIsNullThenUsdAmountIsZero() {
        Instruction instruction = aInstruction().build();
        assertThat(instruction.getUsdAmount()).isEqualTo(ZERO);
    }

    @Test
    public void calculateUsdAmountWhenAgreedFxIsNullThenUsdAmountIsZero() {
        Instruction instruction = aInstruction().withUnitPrice("1").build();
        assertThat(instruction.getUsdAmount()).isEqualTo(ZERO);
    }

    @Test
    public void calculateUsdAmountWhenUnitsNotProvidedThenUsdAmountIsZero() {
        Instruction instruction = aInstruction()
                .withUnitPrice("1")
                .withAgreedFx("1")
                .build();
        assertThat(instruction.getUsdAmount()).isEqualTo(ZERO);
    }

    @Test
    public void calculateUsdAmountWhen0_25AgreedFx10UnitsAnd57UnitPriceThenUsdAmountIs142_50() {
        Instruction instruction = aInstruction()
                .withUnitPrice("57")
                .withAgreedFx("0.25")
                .withUnits(10)
                .build();
        assertThat(instruction.getUsdAmount()).isEqualTo(new BigDecimal("142.50"));
    }

    @Test
    public void calculateUsdAmountWhen0_57AgreedFx74UnitsAnd209_72UnitPriceThenUsdAmountIs8845_9896() {
        Instruction instruction = aInstruction()
                .withUnitPrice("209.72")
                .withAgreedFx("0.57")
                .withUnits(74)
                .build();
        assertThat(instruction.getUsdAmount()).isEqualTo(new BigDecimal("8845.9896"));
    }
}