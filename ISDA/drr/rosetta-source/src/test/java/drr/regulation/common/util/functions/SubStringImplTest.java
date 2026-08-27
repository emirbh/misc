package drr.regulation.common.util.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubStringImplTest {

    @Test
    void shouldReturnShortenedString() {
        SubStringImpl func = new SubStringImpl();
        String text = "This is a very long string";
        int desiredLength = 10;

        String result = func.doEvaluate(text, 1, desiredLength);

        assertEquals("This is a ", result);
    }

    @Test
    void shouldReturnShortenedStringWithNullStartIndex() {
        SubStringImpl func = new SubStringImpl();
        String text = "This is a very long string";
        int desiredLength = 10;

        String result = func.doEvaluate(text, null, desiredLength);

        assertEquals("This is a ", result);
    }

    @Test
    void shouldReturnShortenedStringWithStartIndex() {
        SubStringImpl func = new SubStringImpl();
        String text = "This is a very long string";
        int desiredLength = 14;

        String result = func.doEvaluate(text, 6, desiredLength);

        assertEquals("is a very long", result);
        assertEquals(desiredLength, result.length());
    }

    @Test
    void shouldReturnSameStringIfLengthLessThanStartIndex() {
        SubStringImpl func = new SubStringImpl();
        String text = "basket1";
        int desiredLength = 72;

        String result = func.doEvaluate(text, 20, desiredLength);

        assertEquals("basket1", result);
        assertEquals(7, result.length());
    }


    @Test
    void shouldReturnSameStringIfLengthNotExceeded() {
        SubStringImpl func = new SubStringImpl();
        String text = "Short";
        int desiredLength = 10;

        String result = func.doEvaluate(text, 1, desiredLength);

        assertEquals("Short", result);
        assertEquals(5, result.length());
    }

    @Test
    void shouldReturnEmptyStringIfInputIsNull() {
        SubStringImpl func = new SubStringImpl();
        int desiredLength = 5;

        String result = func.doEvaluate(null, 1, desiredLength);

        assertNull(result);
    }

    @Test
    void shouldReturnUnchangedStringForInvalidStartIndex() {
        SubStringImpl func = new SubStringImpl();
        String text = "This is a very long string";
        int desiredLength = 5;

        String result = func.doEvaluate(text, 0, desiredLength);

        assertEquals(text, result);
    }
}
