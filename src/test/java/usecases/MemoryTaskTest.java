package usecases;

import org.junit.jupiter.api.Test;

/**
 * Class representing test cases for the memory task.
 */

public class MemoryTaskTest {
    /**
     * Tests if correct is updated correctly when matching inputs are provided.
     */
    @Test
    void testCorrectPassword(){
        String actualPassword = "1a2b3c";
        String typedPassword = "1a2b3c";
        MemoryTask.checkCorrectness(actualPassword, typedPassword);
        assert(MemoryTask.correct);
        assert(MemoryTask.getCompletionStatus("MemoryTask"));
    }

    /**
     * Tests that correct is updated correctly when different inputs are provided.
     */

    @Test
    void testIncorrectPassword(){
        MemoryTask.checkCorrectness("q5t72x", "u7df31");
        assert(!MemoryTask.correct);
    }

    /**
     * Tests that it is case sensitive and correct is updated correctly when inputs with only case differences are provided.
     */

    @Test
    void testCaseSensitivity(){
        String actualPassword = "h0h0hO";
        String typedPassword = "H0h0ho";
        MemoryTask.checkCorrectness(actualPassword, typedPassword);
        assert(!MemoryTask.correct);
    }

}
