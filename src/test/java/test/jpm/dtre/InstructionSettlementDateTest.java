package test.jpm.dtre;

import org.junit.Test;

import java.time.LocalDate;

import static java.time.DayOfWeek.*;
import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static org.fest.assertions.Assertions.assertThat;
import static test.jpm.dtre.InstructionBuilder.aInstruction;

public class InstructionSettlementDateTest {
    @Test
    public void calculateSettlementDateWhenTheCurrencyIsNotSetForWednesday() {
        LocalDate friday = of(2018, APRIL, 4);
        Instruction instruction = aInstruction()
                .withSettlementDate(friday)
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(WEDNESDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 4));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(WEDNESDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsNotSetForThursday() {
        LocalDate friday = of(2018, APRIL, 5);
        Instruction instruction = aInstruction()
                .withSettlementDate(friday)
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(THURSDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 5));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(THURSDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsNotSetForFriday() {
        LocalDate friday = of(2018, APRIL, 6);
        Instruction instruction = aInstruction()
                .withSettlementDate(friday)
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(FRIDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 6));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(FRIDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsNotSetForSaturday() {
        LocalDate saturday = of(2018, APRIL, 7);
        Instruction instruction = aInstruction()
                .withSettlementDate(saturday)
                .build();
        assertThat(saturday.getDayOfWeek()).isEqualTo(SATURDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 9));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(MONDAY);
    }


    @Test
    public void calculateSettlementDateWhenTheCurrencyIsEurForWednesday() {
        LocalDate friday = of(2018, APRIL, 4);
        Instruction instruction = aInstruction()
                .withCurrency("EUR")
                .withSettlementDate(friday)
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(WEDNESDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 4));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(WEDNESDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsEurForThursday() {
        LocalDate friday = of(2018, APRIL, 5);
        Instruction instruction = aInstruction()
                .withSettlementDate(friday)
                .withCurrency("EUR")
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(THURSDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 5));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(THURSDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsEurForFriday() {
        LocalDate friday = of(2018, APRIL, 6);
        Instruction instruction = aInstruction()
                .withSettlementDate(friday)
                .withCurrency("EUR")
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(FRIDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 6));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(FRIDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsEurForSaturday() {
        LocalDate saturday = of(2018, APRIL, 7);
        Instruction instruction = aInstruction()
                .withSettlementDate(saturday)
                .withCurrency("EUR")
                .build();
        assertThat(saturday.getDayOfWeek()).isEqualTo(SATURDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 9));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(MONDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsEurForSunday() {
        LocalDate saturday = of(2018, APRIL, 8);
        Instruction instruction = aInstruction()
                .withSettlementDate(saturday)
                .withCurrency("EUR")
                .build();
        assertThat(saturday.getDayOfWeek()).isEqualTo(SUNDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 9));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(MONDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsEurForMonday() {
        LocalDate saturday = of(2018, APRIL, 9);
        Instruction instruction = aInstruction()
                .withSettlementDate(saturday)
                .withCurrency("EUR")
                .build();
        assertThat(saturday.getDayOfWeek()).isEqualTo(MONDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 9));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(MONDAY);
    }




    @Test
    public void calculateSettlementDateWhenTheCurrencyIsAedForWednesday() {
        LocalDate friday = of(2018, APRIL, 4);
        Instruction instruction = aInstruction()
                .withCurrency("AED")
                .withSettlementDate(friday)
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(WEDNESDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 4));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(WEDNESDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsAEDForThursday() {
        LocalDate friday = of(2018, APRIL, 5);
        Instruction instruction = aInstruction()
                .withSettlementDate(friday)
                .withCurrency("AED")
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(THURSDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 5));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(THURSDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsAedForFriday() {
        LocalDate friday = of(2018, APRIL, 6);
        Instruction instruction = aInstruction()
                .withSettlementDate(friday)
                .withCurrency("AED")
                .build();
        assertThat(friday.getDayOfWeek()).isEqualTo(FRIDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 8));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(SUNDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsSarForSaturday() {
        LocalDate saturday = of(2018, APRIL, 7);
        Instruction instruction = aInstruction()
                .withSettlementDate(saturday)
                .withCurrency("SAR")
                .build();
        assertThat(saturday.getDayOfWeek()).isEqualTo(SATURDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 8));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(SUNDAY);
    }

    @Test
    public void calculateSettlementDateWhenTheCurrencyIsSarForSunday() {
        LocalDate saturday = of(2018, APRIL, 8);
        Instruction instruction = aInstruction()
                .withSettlementDate(saturday)
                .withCurrency("SAR")
                .build();
        assertThat(saturday.getDayOfWeek()).isEqualTo(SUNDAY);
        assertThat(instruction.getSettlementDate()).isEqualTo(of(2018, APRIL, 8));
        assertThat(instruction.getSettlementDate().getDayOfWeek()).isEqualTo(SUNDAY);
    }
}