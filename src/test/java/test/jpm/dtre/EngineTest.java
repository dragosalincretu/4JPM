package test.jpm.dtre;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static test.jpm.dtre.InstructionBuilder.aInstruction;

public class EngineTest {
    private Engine engine = new Engine();
    private List<Instruction> instructions1;
    private List<Instruction> instructions2;
    private List<Instruction> instructions3;

    @Before
    public void setUp() {
        instructions1 = asList(aInstruction().withSettlementDate(of(2018, APRIL, 6))
                        .outgoing()
                        .withEntity("abc")
                        .withCurrency("EUR")
                        .withAgreedFx("0.80848")
                        .withUnits(10)
                        .withUnitPrice("78.95").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .outgoing()
                        .withEntity("abc")
                        .withCurrency("EUR")
                        .withAgreedFx("0.80838")
                        .withUnits(50)
                        .withUnitPrice("78.82").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .outgoing()
                        .withEntity("cda")
                        .withCurrency("EUR")
                        .withAgreedFx("0.80848")
                        .withUnits(20)
                        .withUnitPrice("12.59").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .incoming()
                        .withEntity("abc")
                        .withCurrency("EUR")
                        .withAgreedFx("0.80833")
                        .withUnits(200)
                        .withUnitPrice("78.79").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .incoming()
                        .withEntity("cda")
                        .withCurrency("EUR")
                        .withAgreedFx("0.80857")
                        .withUnits(80)
                        .withUnitPrice("12.62").build());

        instructions2 = asList(aInstruction().withSettlementDate(of(2018, APRIL, 6))
                        .outgoing()
                        .withEntity("yxz")
                        .withCurrency("AED")
                        .withAgreedFx("0.5859")
                        .withUnits(10)
                        .withUnitPrice("78.45").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .outgoing()
                        .withEntity("yxz")
                        .withCurrency("EUR")
                        .withAgreedFx("0.80938")
                        .withUnits(50)
                        .withUnitPrice("78.82").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .outgoing()
                        .withEntity("cda")
                        .withCurrency("SAR")
                        .withAgreedFx("0.80848")
                        .withUnits(20)
                        .withUnitPrice("12.47").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 8))
                        .incoming()
                        .withEntity("gdg")
                        .withCurrency("EUR")
                        .withAgreedFx("0.80854")
                        .withUnits(80)
                        .withUnitPrice("83.07").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .incoming()
                        .withEntity("abc")
                        .withCurrency("AED")
                        .withAgreedFx("0.40853")
                        .withUnits(40)
                        .withUnitPrice("78.77").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .incoming()
                        .withEntity("cda")
                        .withCurrency("SAR")
                        .withAgreedFx("0.80847")
                        .withUnits(80)
                        .withUnitPrice("12.63").build());


        instructions3 = asList(aInstruction().withSettlementDate(of(2018, APRIL, 6))
                        .outgoing()
                        .withEntity("a")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(10)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .outgoing()
                        .withEntity("b")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(20)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 8))
                        .outgoing()
                        .withEntity("c")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(30)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 9))
                        .outgoing()
                        .withEntity("d")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(40)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 10))
                        .outgoing()
                        .withEntity("e")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(50)
                        .withUnitPrice("1").build(),

                aInstruction().withSettlementDate(of(2018, APRIL, 6))
                        .incoming()
                        .withEntity("a")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(10)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 7))
                        .incoming()
                        .withEntity("b")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(20)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 8))
                        .incoming()
                        .withEntity("c")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(30)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 9))
                        .incoming()
                        .withEntity("d")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(40)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 10))
                        .incoming()
                        .withEntity("e")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(50)
                        .withUnitPrice("1").build(),
                aInstruction().withSettlementDate(of(2018, APRIL, 11))
                        .incoming()
                        .withEntity("a")
                        .withCurrency("RON")
                        .withAgreedFx("0.2")
                        .withUnits(50)
                        .withUnitPrice("1").build());
    }

    @Test
    public void getDailySettledAmountForIncomingOperation() {
        Map<LocalDate, BigDecimal> dailySettledAmountForIncoming = engine.getDailySettledAmountPerOperationType(instructions1, Instruction::isIncoming);
        assertThat(dailySettledAmountForIncoming).hasSize(1);
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 7))).isNull();
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 9))).isEqualTo(new BigDecimal("13553.9964120"));

        dailySettledAmountForIncoming = engine.getDailySettledAmountPerOperationType(instructions2, Instruction::isIncoming);
        assertThat(dailySettledAmountForIncoming).hasSize(2);
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 7))).isNull();
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 8))).isEqualTo(new BigDecimal("2104.0744120"));
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 9))).isEqualTo(new BigDecimal("5373.2334240"));

        dailySettledAmountForIncoming = engine.getDailySettledAmountPerOperationType(instructions3, Instruction::isIncoming);
        assertThat(dailySettledAmountForIncoming).hasSize(4);
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 7))).isNull();
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 8))).isNull();
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 9))).isEqualTo(new BigDecimal("18.0"));
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 10))).isEqualTo(new BigDecimal("10.0"));
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 11))).isEqualTo(new BigDecimal("10.0"));
        assertThat(dailySettledAmountForIncoming.get(of(2018, APRIL, 12))).isNull();
    }

    @Test
    public void getDailySettledAmountForOutgoingOperation() {
        Map<LocalDate, BigDecimal> dailySettledAmountForOutgoing = engine.getDailySettledAmountPerOperationType(instructions1, Instruction::isOutgoing);
        assertThat(dailySettledAmountForOutgoing).hasSize(2);
        assertThat(dailySettledAmountForOutgoing.get(of(2018, APRIL, 7))).isNull();
        assertThat(dailySettledAmountForOutgoing.get(of(2018, APRIL, 9))).isEqualTo(new BigDecimal("3389.4008440"));

        dailySettledAmountForOutgoing = engine.getDailySettledAmountPerOperationType(instructions2, Instruction::isOutgoing);
        assertThat(dailySettledAmountForOutgoing).hasSize(2);
        assertThat(dailySettledAmountForOutgoing.get(of(2018, APRIL, 7))).isNull();
        assertThat(dailySettledAmountForOutgoing.get(of(2018, APRIL, 9))).isEqualTo(new BigDecimal("3189.7665800"));
    }

    @Test
    public void getEntitiesSortedByAmountForIncomingOperation() {
        List<String> entitiesSortedByAmountForIncomingOperation = engine.getEntitiesSortedByAmountPerOperationType(instructions1, Instruction::isIncoming);
        assertThat(entitiesSortedByAmountForIncomingOperation)
                .hasSize(2)
                .isEqualTo(asList("abc", "cda"));

        entitiesSortedByAmountForIncomingOperation = engine.getEntitiesSortedByAmountPerOperationType(instructions2, Instruction::isIncoming);
        assertThat(entitiesSortedByAmountForIncomingOperation)
                .hasSize(3)
                .isEqualTo(asList("gdg", "abc", "cda"));

        entitiesSortedByAmountForIncomingOperation = engine.getEntitiesSortedByAmountPerOperationType(instructions3, Instruction::isIncoming);
        assertThat(entitiesSortedByAmountForIncomingOperation)
                .hasSize(5)
                .isEqualTo(asList("a", "e", "d", "c", "b"));
    }

    @Test
    public void getEntitiesSortedByAmountForOutgoingOperation() {
        List<String> entitiesSortedByAmountForOutgoingOperation = engine.getEntitiesSortedByAmountPerOperationType(instructions1, Instruction::isOutgoing);
        assertThat(entitiesSortedByAmountForOutgoingOperation)
                .hasSize(2)
                .isEqualTo(asList("abc", "cda"));

        entitiesSortedByAmountForOutgoingOperation = engine.getEntitiesSortedByAmountPerOperationType(instructions2, Instruction::isOutgoing);
        assertThat(entitiesSortedByAmountForOutgoingOperation)
                .hasSize(2)
                .isEqualTo(asList("yxz", "cda"));


        entitiesSortedByAmountForOutgoingOperation = engine.getEntitiesSortedByAmountPerOperationType(instructions3, Instruction::isOutgoing);
        assertThat(entitiesSortedByAmountForOutgoingOperation)
                .hasSize(5)
                .isEqualTo(asList("e", "d", "c", "b", "a"));

    }

    @Test
    public void testProcessTradeReport(){
        System.out.println("Daily trade report - for the first set of instructions ");
        engine.processTradeReport(instructions1);
        System.out.println("\n\nDaily trade report - for the second set of instructions ");
        engine.processTradeReport(instructions2);
        System.out.println("\n\nDaily trade report - for the third set of instructions ");
        engine.processTradeReport(instructions3);
    }
}