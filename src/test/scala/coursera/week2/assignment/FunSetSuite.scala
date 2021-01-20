package coursera.week2.assignment

import org.junit._

/**
 * To run: start "sbt" then run the "test" command.
 */
class FunSetSuite {

  import coursera.week2.assignment.FunSets._

  @Test def `contains is implemented`: Unit = {
    assert(contains(x => true, 100))
  }

  /**
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   * val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s12 = union(s1, s2)
    val s23 = union(s2, s3)
    val s123 = union(s12, s3)
  }

  @Test def `singleton set one contains one`: Unit = {
    new TestSets {
      assert(contains(s1, 1), "Singleton")
    }
  }

  @Test def `union contains all elements of each set`: Unit = {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  @Test def `intersect contains elements, which are in both sets`: Unit = {
    new TestSets {
      val s = intersect(s12, s23)
      assert(!contains(s, 1), "Intersect 1")
      assert(contains(s, 2), "Intersect 2")
      assert(!contains(s, 3), "Intersect 3")
    }
  }

  @Test def `diff contains all elements of s that are not in t`: Unit = {
    new TestSets {
      val s = diff(s12, s23)
      assert(contains(s, 1), "Diff 1")
      assert(!contains(s, 2), "Diff 2")
      assert(!contains(s, 3), "Diff 3")
    }
  }

  @Test def `filter contains elements, which satisty filter condition`: Unit = {
    new TestSets {
      val s = filter(s123, _ % 2 == 1)
      assert(contains(s, 1), "Filter 1")
      assert(!contains(s, 2), "Filter 2")
      assert(contains(s, 3), "Filter 3")
    }
  }

  @Test def `forall - all elements satisfy filter condition`: Unit = {
    new TestSets {
      assert(forall(s123, _ > 0), "Forall 1")
      assert(!forall(s123, _ < 0), "Forall 2")
      assert(!forall(s123, _ > 2), "Forall 3")
      assert(forall(s123, x => x > 0 && x < 4), "Forall 4")
    }
  }

  @Test def `exists - at least one element satisfy filter condition`: Unit = {
    new TestSets {
      assert(exists(s123, _ > 0), "Exists 1")
      assert(exists(s123, _ == 2), "Exists 2")
      assert(exists(s123, _ > 2), "Exists 3")
      assert(!exists(s123, _ > 4), "Exists 4")
      assert(!exists(s123, _ < 0), "Exists 5")
    }
  }

  @Test def `map - apply function to each element`: Unit = {
    new TestSets {
      val mapSet123 = map(s123, _ * 2)
      assert(!contains(mapSet123, 1))
      assert(contains(mapSet123, 2))
      assert(contains(mapSet123, 6))
    }
  }


  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
