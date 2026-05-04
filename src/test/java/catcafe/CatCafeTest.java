package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CatCafeTest {
  @Test
  void giveEmptyCafe_whenGetCatCount_thenReturnZero() {
    CatCafe cafe = new CatCafe();

    long count = cafe.getCatCount();

    assertEquals(0, count);
  }
}
