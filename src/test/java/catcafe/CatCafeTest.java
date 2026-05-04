package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// 1
public class CatCafeTest {
  @Test
  void givenEmptyCafe_whenGetCatCount_thenReturnsZero() {
    // given
    CatCafe cafe = new CatCafe();
    // when
    long count = cafe.getCatCount();
    // then
    assertEquals(0, count);
  }

  // 2
  @Test
  void givenCafeWithOneCat_whenGetCatCount_thenReturnsOne() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Milo", 4));

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(1, count);
  }

  @Test
  void givenCafeWithMultipleCats_whenGetCatCount_thenReturnsCorrectCount() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("A", 1));
    cafe.addCat(new FelineOverLord("B", 2));
    cafe.addCat(new FelineOverLord("C", 3));

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(3, count);
  }

  @Test
  void givenCafe_whenAddNullCat_thenThrowsException() {
    CatCafe cafe = new CatCafe();

    assertThrows(NullPointerException.class, () -> cafe.addCat(null));
  }

  @Test
  void givenCafeWithCat_whenGetCatByName_thenReturnsCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Milo", 4);
    cafe.addCat(cat);

    // when
    FelineOverLord result = cafe.getCatByName("Milo");

    // then
    assertSame(cat, result);
  }

  @Test
  void givenCafeWithCat_whenGetCatByUnknownName_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Milo", 4));

    // when
    FelineOverLord result = cafe.getCatByName("Luna");

    // then
    assertNull(result);
  }

  @Test
  void givenCafeWithCat_whenGetCatByNullName_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Milo", 4));

    // when
    FelineOverLord result = cafe.getCatByName(null);

    // then
    assertNull(result);
  }

  @Test
  void givenCafeWithCat_whenGetCatByWeightInRange_thenReturnsCat() {
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Milo", 4);
    cafe.addCat(cat);

    // when
    FelineOverLord result = cafe.getCatByWeight(3, 5);

    // then
    assertSame(cat, result);
  }

  @Test
  void givenCafeWithCat_whenGetCatByWeightAtUpperBoundary_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Milo", 5));

    // when
    FelineOverLord result = cafe.getCatByWeight(3, 5);

    // then
    assertNull(result);
  }

  @Test
  void givenCafeWithCat_whenGetCatByNegativeMinWeight_thenReturnsNull() {
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Milo", 4));

    // when
    FelineOverLord result = cafe.getCatByWeight(-1, 5);

    // then
    assertNull(result);
  }
}
