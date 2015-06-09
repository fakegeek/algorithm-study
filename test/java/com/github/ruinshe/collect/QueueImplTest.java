package com.github.ruinshe.collect;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test cases for {@link QueueImpl}.
 */
@RunWith(JUnit4.class)
public class QueueImplTest {

  private static final int TEST_MAX_SIZE = 128;

  private Queue<Integer> queue;

  @Before
  public void setUp() {
    queue = new QueueImpl<>(TEST_MAX_SIZE);
  }

  @Test
  public void testIsEmpty() {
    assertThat(queue.isEmpty()).isTrue();
    queue.push(1);
    assertThat(queue.isEmpty()).isFalse();
  }

  @Test
  public void testPush() {
    assertThat(queue.size()).isEqualTo(0);
    for (int i = 1; i <= TEST_MAX_SIZE; i++) {
      queue.push(i);
      assertThat(queue.size()).isEqualTo(i);
    }
  }

  @Test
  public void testTake() {
    assertThat(queue.take()).isNull();
    assertThat(queue.take()).isNull();
    queue.push(1);
    queue.push(2);
    assertThat(queue.take()).isEqualTo(1);
    assertThat(queue.take()).isEqualTo(2);
    assertThat(queue.take()).isNull();
  }
  
  @Test
  public void testAdjustSize() {
    int run_times = TEST_MAX_SIZE << 1;
    for (int i = 0; i < run_times; i++) {
      assertThat(queue.size()).isEqualTo(Math.min(i, TEST_MAX_SIZE));
      assertThat(queue.push(i)).isEqualTo(i < TEST_MAX_SIZE);
    }
    assertThat(queue.size()).isEqualTo(TEST_MAX_SIZE);
    int size = queue.size();
    for (int i = 0; i < size; i++) {
      assertThat(queue.take()).isEqualTo(i);
      assertThat(queue.size()).isEqualTo(TEST_MAX_SIZE - 1 - i);
    }
    assertThat(queue.size()).isEqualTo(0);
    assertThat(queue.isEmpty()).isTrue();
  }
}

