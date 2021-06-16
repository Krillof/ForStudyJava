package com.study.Lesson16_06;

import junit.framework.TestCase;
import org.junit.*;

import java.util.ArrayList;

public class CalculatorTest extends TestCase {

    @Test
    public void testGetSumOfFractions() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(2.0f, calc.getSumOfFractions(1.0f, 1.0f));
    }
    @Test
    public void testGetMinusOfFractions() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(1.0f, calc.getMinusOfFractions(2.0f, 1.0f));
    }
    @Test
    public void testGetMultiplyOfFractions() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(6.0f, calc.getMultiplyOfFractions(2.0f, 3.0f));
    }
    @Test
    public void testGetDivisionOfFractions() throws Exception{
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(2.0f, calc.getDivisionOfFractions(6.0f, 3.0f));
    }
    @Test
    public void testGetSum() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(2, calc.getSum(1, 1));
    }
    @Test
    public void testGetMinus() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(1, calc.getMinus(2, 1));
    }
    @Test
    public void testGetMultiply() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(4, calc.getMultiply(2, 2));
    }
    @Test
    public void testGetDivision() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(2, calc.getDivision(4, 2));
    }
    @Test
    public void testGetMax() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(4, calc.getMax(4, 2));
    }
    @Test
    public void testGetMin() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(2, calc.getMin(4, 2));
    }
    @Test
    public void testGetPercentOf() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(1, calc.getPercentOf(50, 2));
    }
    @Test
    public void testGetDegreeOfNumber() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        assertEquals(32.0f, calc.getDegreeOfNumber(2, 5));
        assertEquals(8.0f, calc.getDegreeOfNumber(0.5f, -3));
    }
    @Test
    public void testGetArrSum() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        Calculator calc = new Calculator(1, arr);
        assertEquals(15, calc.getArrSum());
    }
    @Test
    public void testGetArrAverage() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        Calculator calc = new Calculator(1, arr);
        assertEquals(3, calc.getArrAverage());
    }
    @Test
    public void testGetArrMax() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        Calculator calc = new Calculator(1, arr);
        assertEquals(5, calc.getArrMax());
    }
    @Test
    public void testGetArrMin() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        Calculator calc = new Calculator(1, arr);
        assertEquals(1, calc.getArrMin());
    }
    @Test
    public void testSetNumber() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        calc.setNumber(1);
        assertEquals(1, calc.getNumber());
    }
    @Test
    public void testGetNumber() {
        Calculator calc = new Calculator(1, new ArrayList<Integer>(1));
        calc.setNumber(1);
        assertEquals(1, calc.getNumber());
    }
    @Test
    public void testGetNumberInEight() {
        Calculator calc = new Calculator(4, new ArrayList<Integer>(1));
        assertEquals(Integer.toOctalString(4), calc.getNumberInEight());
    }
    @Test
    public void testGetNumberInBinary() {
        Calculator calc = new Calculator(4, new ArrayList<Integer>(1));
        assertEquals(Integer.toBinaryString(4), calc.getNumberInBinary());
    }
    @Test
    public void testGetNumberInHex() {
        Calculator calc = new Calculator(4, new ArrayList<Integer>(1));
        assertEquals(Integer.toHexString(4), calc.getNumberInHex());
    }
}