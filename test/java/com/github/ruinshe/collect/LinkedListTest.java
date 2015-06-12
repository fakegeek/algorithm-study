package com.github.ruinshe.collect;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test cases for {@link LinkedList}.
 */
@RunWith(JUnit4.class)
public class LinkedListTest {

  private List<Integer> list;

  @Before
  public void setUp() {
    list = new LinkedList<>();
  }

  @Test
  public void testIsEmpty() {
    assertThat(list.isEmpty()).isTrue();
    list.append(1);
    assertThat(list.isEmpty()).isFalse();
    list.pollBack();
    assertThat(list.isEmpty()).isTrue();
    list.push(1);
    assertThat(list.isEmpty()).isFalse();
  }

  public void testSize() {
    for (int i = 0; i < 1024; i++) {
      assertThat(list.size()).isEqualTo(i);
      if (i % 2 == 0) {
        assertThat(list.append(i)).isTrue();
      } else {
        assertThat(list.push(i)).isTrue();
      }
    }
    assertThat(list.size()).isEqualTo(1024);
    for (int i = 1023; i >= 0; i--) {
      if (i % 2 == 0) {
        assertThat(list.peekBack()).isEqualTo(i);
        assertThat(list.pollBack()).isEqualTo(i);
      } else {
        assertThat(list.peekFront()).isEqualTo(i);
        assertThat(list.pollFront()).isEqualTo(i);
      }
    }
    assertThat(list.isEmpty()).isTrue();
  }
}
