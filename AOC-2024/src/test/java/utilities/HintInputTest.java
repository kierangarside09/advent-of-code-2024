package utilities;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HintInputTest {

    @Test
    public void testHintInputConstructor() {
        String hintInput = "Hello\nWorld";
        HintInput hint = new HintInput(hintInput);
        assertEquals(hintInput, hint.getHintInput());
    }

    @Test
    public void testGetHintLines() {
        String hintInput = "Hello\nWorld";
        HintInput hint = new HintInput(hintInput);
        String[] expected = new String[] {"Hello", "World"};
        assertArrayEquals(expected, hint.getHintLines());
    }

    @Test
    public void testGetHintLines_NoNewlines() {
        String hintInput = "Hello World";
        HintInput hint = new HintInput(hintInput);
        String[] expected = new String[] {"Hello World"};
        assertArrayEquals(expected, hint.getHintLines());
    }

    @Test
    public void testGetHintLines_MultipleNewlines() {
        String hintInput = "Hello\nWorld\n\n Foo";
        HintInput hint = new HintInput(hintInput);
        String[] expected = new String[] {"Hello", "World", "", " Foo"};
        assertArrayEquals(expected, hint.getHintLines());
    }

    @Test
    public void testGetHintInput() {
        String hintInput = "Hello\nWorld";
        HintInput hint = new HintInput(hintInput);
        assertEquals(hintInput, hint.getHintInput());
    }

    @Test
    public void testGetHintInput_EmptyString() {
        String hintInput = "";
        HintInput hint = new HintInput(hintInput);
        assertEquals(hintInput, hint.getHintInput());
    }
}