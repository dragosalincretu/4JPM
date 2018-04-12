package test.jpm.dtre;

import java.math.BigDecimal;
import java.time.LocalDate;

class InstructionBuilder {
    private String entity;
    private char buySellFlag;
    private BigDecimal agreedFx;
    private String currency;
    private LocalDate instructionDate;
    private LocalDate settlementDate;
    private int units;
    private BigDecimal unitPrice;

    static InstructionBuilder aInstruction() {
        return new InstructionBuilder();
    }

    Instruction build() {
        return new Instruction(entity, buySellFlag, agreedFx, currency, instructionDate, settlementDate, units, unitPrice);
    }

    InstructionBuilder withEntity(String entity) {
        this.entity = entity;
        return this;
    }

    InstructionBuilder outgoing() {
        this.buySellFlag = Instruction.OUTGOING;
        return this;
    }

    InstructionBuilder buy() {
        this.buySellFlag = Instruction.OUTGOING;
        return this;
    }

    InstructionBuilder incoming() {
        this.buySellFlag = Instruction.INCOMING;
        return this;
    }

    InstructionBuilder sell() {
        this.buySellFlag = Instruction.INCOMING;
        return this;
    }

    InstructionBuilder withAgreedFx(String agreedFx) {
        this.agreedFx = new BigDecimal(agreedFx);
        return this;
    }

    InstructionBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    InstructionBuilder withInstructionDate(LocalDate instructionDate) {
        this.instructionDate = instructionDate;
        return this;
    }

    InstructionBuilder withSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
        return this;
    }

    InstructionBuilder withUnits(int units) {
        this.units = units;
        return this;
    }

    InstructionBuilder withUnitPrice(String unitPrice) {
        this.unitPrice = new BigDecimal(unitPrice);
        return this;
    }
}
