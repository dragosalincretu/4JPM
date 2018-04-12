package test.jpm.dtre;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static test.jpm.dtre.InstructionBuilder.aInstruction;

public class InstructionBuySellFlagTest {
    @Test
    public void WhenBuySellFlagIsNotProvidedThenIsOutgoingReturnsFalse() {
        Instruction instruction = aInstruction().build();
        assertThat(instruction.isOutgoing()).isFalse();
    }

    @Test
    public void WhenBuySellFlagIsNotProvidedThenIsIncomingReturnsFalse() {
        Instruction instruction = aInstruction().build();
        assertThat(instruction.isIncoming()).isFalse();
    }

    @Test
    public void WhenBuySellFlagIsSetToBThenIsOutgoingReturnsTrue() {
        Instruction instruction = aInstruction().outgoing().build();
        assertThat(instruction.isOutgoing()).isTrue();
    }

    @Test
    public void WhenBuySellFlagIsSetToSThenIsIncomingReturnsTrue() {
        Instruction instruction = aInstruction().incoming().build();
        assertThat(instruction.isIncoming()).isTrue();
    }

    @Test
    public void WhenBuySellFlagIsSetToSThenIsOutgoingReturnsFalse() {
        Instruction instruction = aInstruction().incoming().build();
        assertThat(instruction.isOutgoing()).isFalse();
    }

    @Test
    public void WhenBuySellFlagIsSetToBThenIsIncomingReturnsFalse() {
        Instruction instruction = aInstruction().outgoing().build();
        assertThat(instruction.isIncoming()).isFalse();
    }
}