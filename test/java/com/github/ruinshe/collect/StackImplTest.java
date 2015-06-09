package com.github.ruinshe.collect;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test cases for {@link StackImpl}.
 */
@RunWith(JUnit4.class)
public class StackImplTest {

  private static final int TEST_MAX_SIZE = 128;

  private Stack<Integer> stack;

  @Before
  public void setUp() {
    stack = new StackImpl<>(TEST_MAX_SIZE);
  }

  @Test
  public void testIsEmpty() {
    assertThat(stack.isEmpty()).isTrue();
    stack.push(1);
    assertThat(stack.isEmpty()).isFalse();
  }

  @Test
  public void testPush() {
    // use 100 because it's larger enough than INIT_SIZE.
    assertThat(stack.size()).isEqualTo(0);
    for (int i = 1; i <= 100; i++) {
      stack.push(i);
      assertThat(stack.size()).isEqualTo(i);
    }
  }

  @Test
  public void testPeek() {
    assertThat(stack.peek()).isEqualTo(null);
    assertThat(stack.peek()).isEqualTo(null);
    stack.push(1);
    stack.push(2);
    for (int i = 0; i < 100; i++) {
      assertThat(stack.peek()).isEqualTo(2);
    }
  }

  @Test
  public void testPoll() {
    assertThat(stack.poll()).isNull();
    assertThat(stack.poll()).isNull();
    stack.push(1);
    stack.push(2);
    assertThat(stack.poll()).isEqualTo(2);
    assertThat(stack.poll()).isEqualTo(1);
    assertThat(stack.poll()).isNull();
  }

  @Test
  public void testAdjustSize() {
    int run_times = TEST_MAX_SIZE << 1;
    for (int i = 0; i < run_times; i++) {
      assertThat(stack.size()).isEqualTo(Math.min(i, TEST_MAX_SIZE));
      assertThat(stack.push(i)).isEqualTo(i < TEST_MAX_SIZE);
    }
    assertThat(stack.size()).isEqualTo(TEST_MAX_SIZE);
    int size = stack.size();
    while (!stack.isEmpty()) {
      assertThat(stack.poll()).isEqualTo(--size);
      assertThat(stack.size()).isEqualTo(size);
    }
    assertThat(stack.size()).isEqualTo(0);
    assertThat(stack.isEmpty()).isTrue();
  }
}
