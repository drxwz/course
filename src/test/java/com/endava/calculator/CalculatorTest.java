package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

    private BasicOperations basicCalculator;
    private ExpertOperations expertCalculator;


    @BeforeAll
    public static void setUpAllTests() {

        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {

        System.out.println("\nAfter all");
    }

    @BeforeEach
    public void setupEachTest() {

        basicCalculator = new Basic();
        expertCalculator = new Expert();
//        System.out.println("\nBefore Each");
    }

    @AfterEach
    public void tearDownEachTest() {
//        System.out.println("After Each");
    }

    @Tags({@Tag("smoke"), @Tag(("ui"))})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b, long expected) {

        //GIVEN

        //WHEN
        Long result = basicCalculator.add(a, b);

        //THEN
        assertThat(result, is(expected));
        Assertions.assertThat(result).isEqualTo(expected);
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentList = new ArrayList<>();
        argumentList.add(Arguments.of(0, 2, 2));
        argumentList.add(Arguments.of(2, 0, 2));
        return argumentList;

    }

    @Tag(" smoke ")
    @Test
    public void shouldAddNegativeNumbers() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.add(-2, -4);

        //THEN
        assertEquals(-6L, result);
        assertEquals(-6L, (long) result); //junit asserts
    }


    //BUG Found: JIRA-TICKET

//    @Tags({@Tag("smoke"), @Tag(("api"))})
//    @Test
//    @DisplayName(" Test that adds a big number as MAX INT")
//    public void shouldAddBigNumbers() {
//
//        //GIVEN
//        assertThrows(AssertionError.class, () -> {
//
//            //WHEN
//            Long result = basicCalculator.add(Integer.MAX_VALUE, 1);
//
//            //THEN
//            assertThat(result, is(Integer.MAX_VALUE + 1L));
//            assertThat(result, greaterThan(0L));
//            assertThat(result, notNullValue());
//
//        });
//    }

    @Test
    public void shouldAddNoOperands() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.add();

        //THEN
        assertThat(result, is(0L));
        Assertions.assertThat(result).isEqualTo(0L);
    }

    @Test
    public void shouldAddOneOperand() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.add(167);

        //THEN
        assertEquals(167, result);
        Assertions.assertThat(result).isEqualTo(167);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,6", "2,4,5,11"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a1, int a2, int a3, Long expected) {

        //GIVEN

        //WHEN
        Long result = basicCalculator.add(a1, a2, a3);

        //THEN
        assertThat(result, is(expected));
        Assertions.assertThat(result).isEqualTo(expected);
    }


    @Test
    public void shouldMultiply2Numbers() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.multiply(2, 3);

        //THEN
        assertEquals(6, result);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldMultiplyWith0() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.multiply(2, 0);

        //THEN
        assertEquals(0, result);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldMultiplyMoreNumbers() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.multiply(2, 3, 4);

        //THEN
        assertEquals(24, result);
        Assertions.assertThat(result).isEqualTo(24);
    }

    @Test
    public void shouldMultiplyNegativeNumbers() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.multiply(-2, 3);

        //THEN
        assertEquals(-6, result);
        Assertions.assertThat(result).isEqualTo(-6);
    }

    @Test
    public void shouldMultiply1Number() {

        //GIVEN

        //WHEN
        Long result = basicCalculator.multiply(2);

        //THEN
        assertEquals(2, result);
        Assertions.assertThat(result).isEqualTo(2);
    }


    @Test
    public void shouldRaiseExponent() {

        //GIVEN

        //WHEN
        Double result = expertCalculator.pow(2, 3);

        //THEN
        assertEquals(8, result);
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    public void shouldRaiseNegativeExponent() {

        //GIVEN

        //WHEN
        Double result = expertCalculator.pow(2, -3);

        //THEN
        assertEquals(0.125, result);
        Assertions.assertThat(result).isEqualTo(0.125);
    }

    @Test
    public void shouldRaiseBaseWith0() {

        //GIVEN

        //WHEN
        Double result = expertCalculator.pow(2, 0);

        //THEN
        assertEquals(1, result);
        Assertions.assertThat(result).isEqualTo(1);
    }


    @Test
    public void shouldRaise0BaseWith0Exponent() {

        //GIVEN

        //WHEN
        Double result = expertCalculator.pow(0, 0);

        //THEN
        assertEquals(1, result);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldGiveFactorial() {

        //GIVEN

        //WHEN
        Long result = expertCalculator.fact(5);

        //THEN
        assertEquals(120, result);
        Assertions.assertThat(result).isEqualTo(120);
    }


}

