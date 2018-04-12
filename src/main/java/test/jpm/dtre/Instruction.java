package test.jpm.dtre;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.DayOfWeek.*;

@Getter
@ToString
class Instruction {
    static final char OUTGOING = 'B';
    static final char INCOMING = 'S';

    @Getter(AccessLevel.PACKAGE)
    private final String entity;
    @Getter(AccessLevel.NONE)
    private final char buySellFlag;
    @Getter(AccessLevel.PACKAGE)
    private final BigDecimal agreedFx;
    @Getter(AccessLevel.PACKAGE)
    private final String currency;
    @Getter(AccessLevel.PACKAGE)
    private final LocalDate instructionDate;
    @Getter(AccessLevel.PACKAGE)
    private final LocalDate settlementDate;
    @Getter(AccessLevel.PACKAGE)
    private final int units;
    @Getter(AccessLevel.PACKAGE)
    private final BigDecimal unitPrice;
    @Getter(AccessLevel.PACKAGE)
    private final BigDecimal usdAmount;

    Instruction(String entity, char buySellFlag, BigDecimal agreedFx, String currency, LocalDate instructionDate, LocalDate settlementDate, int units, BigDecimal unitPrice) {
        this.entity = entity;
        this.buySellFlag = buySellFlag;
        this.agreedFx = agreedFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = calculateSettlementDate(currency, settlementDate);
        this.units = units;
        this.unitPrice = unitPrice;
        this.usdAmount = calculateUsdAmount(agreedFx, units, unitPrice);
    }

    boolean isOutgoing() {
        return OUTGOING == buySellFlag;
    }

    boolean isIncoming() {
        return INCOMING == buySellFlag;
    }

    private BigDecimal calculateUsdAmount(BigDecimal agreedFx, int units, BigDecimal unitPrice) {
        if (unitPrice != null && agreedFx != null) {
            return unitPrice.multiply(BigDecimal.valueOf(units)).multiply(agreedFx);
        }
        return BigDecimal.ZERO;
    }

    private LocalDate calculateSettlementDate(String currency, LocalDate settlementDate) {
        if (settlementDate == null) {
            return null;
        }
        if ("AED".equals(currency) || "SAR".equals(currency)) {
            if (settlementDate.getDayOfWeek().equals(FRIDAY)) {
                return settlementDate.plusDays(2);
            }
            if (settlementDate.getDayOfWeek().equals(SATURDAY)) {
                return settlementDate.plusDays(1);
            }
        } else {
            if (settlementDate.getDayOfWeek().equals(SATURDAY)) {
                return settlementDate.plusDays(2);
            }
            if (settlementDate.getDayOfWeek().equals(SUNDAY)) {
                return settlementDate.plusDays(1);
            }
        }
        return settlementDate;
    }
}