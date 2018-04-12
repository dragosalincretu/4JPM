package test.jpm.dtre;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

class Engine {
    void processTradeReport(List<Instruction> instructions) {
        System.out.println("Daily trade report - Amount in USD settled incoming everyday");
        getDailySettledAmountPerOperationType(instructions, Instruction::isIncoming)
                .forEach((key, value) -> System.out.println(key + " incoming " + value));
        System.out.println("\nDaily trade report - Amount in USD settled outgoing everyday");
        getDailySettledAmountPerOperationType(instructions, Instruction::isOutgoing)
                .forEach((key, value) -> System.out.println(key + " outgoing " + value));
        System.out.println("\nDaily trade report - Ranking of entities based on incoming");
        List<String> incomingRanking = getEntitiesSortedByAmountPerOperationType(instructions, Instruction::isIncoming);
        for (int i = 0; i < incomingRanking.size(); i++) {
            System.out.println((i + 1) + " " + incomingRanking.get(i));
        }
        System.out.println("\nDaily trade report - Ranking of entities based on outgoing");
        List<String> outgoingRanking = getEntitiesSortedByAmountPerOperationType(instructions, Instruction::isOutgoing);
        for (int i = 0; i < outgoingRanking.size(); i++) {
            System.out.println((i + 1) + " " + outgoingRanking.get(i));
        }
    }

    Map<LocalDate, BigDecimal> getDailySettledAmountPerOperationType(List<Instruction> instructions, Predicate<Instruction> instructionType) {
        return getGroupedUsdAmountPerOperationType(instructions, instructionType, Instruction::getSettlementDate);
    }

    List<String> getEntitiesSortedByAmountPerOperationType(List<Instruction> instructions, Predicate<Instruction> instructionType) {
        return getGroupedUsdAmountPerOperationType(instructions, instructionType, Instruction::getEntity)
                .entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, BigDecimal>, BigDecimal>comparing(Map.Entry::getValue).reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private <T> Map<T, BigDecimal> getGroupedUsdAmountPerOperationType(List<Instruction> instructions, Predicate<Instruction> instructionType, Function<Instruction, T> toGroupKey) {
        return instructions.stream()
                .filter(instructionType)
                .collect(groupingBy(toGroupKey, reducing(BigDecimal.ZERO, Instruction::getUsdAmount, (a, b) -> a.add(b, MathContext.UNLIMITED))));
    }
}
