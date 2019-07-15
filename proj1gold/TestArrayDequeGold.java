import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

public class TestArrayDequeGold {

  @Test
  public void gradeStudentSolution() {
    // Randomly call StudentArrayDeque and ArrayDequeSolution methods
    // until they disagree on an output.
    //
    // You can generate random numbers using the StdRandom library.
    // http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdRandom.html

    // Use StudentArrayDequeLauncher as a guide, and if you copy and paste code from
    // StudentArrayDequeLauncher, make sure to cite your source using an @source tag.
    // For this project, you must use Integer as your type for the Deque, i.e.
    // StudentArrayDeque<Integer>.
    StudentArrayDeque<Integer>  studentSolution = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> expectedAnswer = new ArrayDequeSolution<>();

    Integer expected = 0, got = 0;
    String message = "";

    Random random = new Random();
    while (expected.equals(got))
    {
      // There are four possible operations that a test can decide to pick
      //    addFirst,
      //    addLast,
      //    removeFirst,
      //    removeLast
      int randOps = StdRandom.uniform(1, 5);

      // Generate a random number from MIN_INT to MAX_INT
      int randVal = random.nextInt(Integer.MAX_VALUE) - Integer.MIN_VALUE + 1;

      switch (randOps) {
        case 1:
          studentSolution.addFirst(randVal);
          expectedAnswer.addFirst(randVal);
          message += "addFirst(" + randVal + ")\n";
          break;

        case 2:
          studentSolution.addLast(randVal);
          expectedAnswer.addLast(randVal);
          message += "addLast(" + randVal + ")\n";
          break;

        case 3:
          if (studentSolution.isEmpty() || expectedAnswer.isEmpty())
            break;
          expected = studentSolution.removeFirst();
          got = expectedAnswer.removeFirst();
          message += "removeFirst()\n";
          break;

        case 4:
          if (studentSolution.isEmpty() || expectedAnswer.isEmpty())
            break;
          expected = studentSolution.removeLast();
          got = expectedAnswer.removeLast();
          message += "removeLast()\n";
          break;
      }

      assertEquals(message, expected, got);
    }

    // Your test should NOT cause a NullPointerException.
    // Make sure that you never try to remove from an empty ArrayDeque, since Integer x =
    // ad.removeFirst() will cause a NullPointerException.
    //
    // Additionally, for this project always use Integer instead of int when you are retrieving
    // values from the deques, i.e. do not do int x = ad.removeFirst().
    //
    // For an explanation of why this causes problems, please read the “FAQs” below.
  }

  public void main(String[] args) {
    jh61b.junit.TestRunner.runTests(TestArrayDequeGold.class);
  }
}
