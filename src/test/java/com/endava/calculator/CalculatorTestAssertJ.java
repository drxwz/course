//package com.endava.calculator;
//
//import com.endava.calculator.basic.Basic;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class CalculatorTestAssertJ {
//
//    private Basic basicCalculator = new Basic();
//
//    @Test
//    public void shouldAddOneOperand() {
//
//        //GIVEN
//
//        //WHEN
//        Long result = basicCalculator.add(167);
//
//        //THEN
//        System.out.println(result);
//        assertThat(result).isBetween(100L,200L)
//                .isGreaterThan(150L)
//                .isEqualTo(167L)
//                .isNotNegative()
//                .isNotNull();
//    }
//}
