import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class test {

    @Test
    void test1() {
        assertEquals(-1.2, main.method(-4.2));
    }

    @Test
    void test2() {
        assertEquals(16, main.member(main.member((2))));
    }

    @Test
    void test3() {
        assertEquals(13.170068027210883, main.method(main.member(main.method((-11)))));
    }

}
