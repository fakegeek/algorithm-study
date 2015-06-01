package com.github.ruinshe.collect;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test cases for {@code StackImpl}.
 */
@RunWith(JUnit4.class)
public class StackImplTest {

  private Stack<Integer> stack;

  @Before
  public void setUp() {
    stack = new StackImpl<>();
  }

  @Test
  public void testIsEmpty() {
    assertThat(stack.isEmpty()).isTrue();
    stack.push(1);
    assertThat(stack.isEmpty()).isFalse();
  }
}
