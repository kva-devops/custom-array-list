package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CustomArrayListImplTest {

    @Test
    public void whenAddOneElementThenSizeIsOne() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        String element = "string";
        elements.add(element);
        Assert.assertEquals(1, elements.getSize());
    }

    @Test
    public void whenAddOneElementThenGetThisElement() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        String element = "string";
        elements.add(element);
        Assert.assertEquals(element, elements.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetElementWithIncorrectIndex() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        String element = "string";
        elements.add(element);
        Assert.assertEquals(element, elements.get(1));
    }

    @Test
    public void whenAddElementWithIndex() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        String elementOne = "string1";
        String elementTwo = "string2";
        String elementCheck = "check";
        elements.add(elementOne);
        elements.add(elementTwo);

        elements.add(elementCheck, 1);

        Assert.assertEquals(3, elements.getSize());
        Assert.assertEquals("check", elements.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddElementWithIndexAndGetElementWithIncorrectIndex() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        String elementCheck = "check";
        elements.add(elementCheck, 1);

    }

    @Test
    public void whenAddElementAndDeleteHimThenReturnTrue() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        String elementCheck = "check";
        elements.add(elementCheck);
        Assert.assertEquals(1, elements.getSize());

        boolean result = elements.delete(elementCheck);
        Assert.assertEquals(0, elements.getSize());
        Assert.assertTrue(result);
    }

    @Test
    public void whenDeleteNotExistingElementThenReturnFalse() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        String elementCheck = "check";

        boolean result = elements.delete(elementCheck);
        Assert.assertFalse(result);
    }

    @Test
    public void whenSortingArray() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        elements.add(9);
        elements.add(8);
        elements.add(7);
        elements.add(6);
        elements.add(5);
        elements.add(4);
        elements.add(3);
        elements.add(2);
        elements.add(1);
        elements.add(0);

        elements.sort();

        Assert.assertEquals(1, elements.get(1));
    }

    @Test
    public void whenAdd11elementThenGrowSize() {
        CustomArrayListInterface elements = new CustomArrayListImpl();
        elements.add(9);
        elements.add(8);
        elements.add(7);
        elements.add(6);
        elements.add(5);
        elements.add(4);
        elements.add(3);
        elements.add(2);
        elements.add(1);
        elements.add(0);
        elements.add(10);

        Assert.assertEquals(10, elements.get(10));
    }
}