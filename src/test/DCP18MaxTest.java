package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import kjmunz.DCP18Max;
import org.junit.Test;

public class DCP18MaxTest {
  @Test
  public void basicExample() {
    int[] a = {10, 5, 2, 7, 8, 7};
    int k = 3;
    int[] answer = DCP18Max.maxInKSubs(a, k);
    int[] expected = {10, 7, 8, 8};
    for(int i = 0; i < answer.length; i++) {
      assertEquals(expected[i], answer[i]);
    }
  }

  @Test
  public void doubleNum() {
    int[] a = {10, 5, 10, 2, 10, 7, 8, 7, 6, 3, 4, 1};
    int k = 5;
    int[] answer = DCP18Max.maxInKSubs(a, k);
    int[] expected = {10, 10, 10, 10, 10, 8, 8, 7};
    for(int i = 0; i < answer.length; i++) {
      assertEquals(expected[i], answer[i]);
    }
  }

  @Test
  public void kEqualsOne() {
    int[] a = {10, 5, 2, 7, 8, 7};
    int[] b = {2};
    int[] c = {};
    int k = 1;
    int[] answerA = DCP18Max.maxInKSubs(a, k);
    for(int i = 0; i < answerA.length; i++) {
      assertEquals(answerA[i], a[i]);
    }
    int[] answerB = DCP18Max.maxInKSubs(b, k);
    for(int i = 0; i < answerB.length; i++) {
      assertEquals(answerB[i], b[i]);
    }
    int[] answerC = DCP18Max.maxInKSubs(c, k);
    assertEquals(answerC.length, c.length);
  }

  @Test
  public void lengthLessEqlOne(){
    int[] b = {2};
    int[] c = {};
    int k = 3;
    int[] answerB = DCP18Max.maxInKSubs(b, k);
    for(int i = 0; i < answerB.length; i++) {
      assertEquals(answerB[i], b[i]);
    }
    int[] answerC = DCP18Max.maxInKSubs(c, k);
    assertEquals(answerC.length, c.length);
  }

  @Test
  public void testDescending(){
    int[] a = {10, 9, 8, 7, 6, 5, 4, 3};
    int k = 4;
    int[] answer = DCP18Max.maxInKSubs(a, k);
    int[] expected = {10, 9, 8, 7, 6};
    for(int i = 0; i < answer.length; i++) {
      assertEquals(expected[i], answer[i]);
    }
  }

  @Test
  public void testAscending(){
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
    int k = 4;
    int[] answer = DCP18Max.maxInKSubs(a, k);
    int[] expected = {4, 5, 6, 7, 8};
    for(int i = 0; i < answer.length; i++) {
      assertEquals(expected[i], answer[i]);
    }
  }

  @Test
  public void testResetOn4(){
    int[] a = {10, 9, 8, 7, 8, 5, 4, 3, 4, 2, 1};
    int k = 3;
    int[] answer = DCP18Max.maxInKSubs(a, k);
    int[] expected = {10, 9, 8, 8, 8, 5, 4, 4, 4};
    for(int i = 0; i < answer.length; i++) {
      assertEquals(expected[i], answer[i]);
    }
  }
}
