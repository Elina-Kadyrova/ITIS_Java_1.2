import org.junit.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MySortedSetTests{
    IntegerComparator comp;
    MySortedSet<Integer> set1;

    @Before
    public void initTest() {
        comp = new IntegerComparator();
        set1 = new MySortedSet(comp);
    }

    @Test
    public void addTestTrue(){
        Assert.assertTrue(set1.add(78));
    }

//    @Test
//    public void classtest(){
//        Class c = new Class<>();
//
//    }

    @Test
    public void addTestFalse(){
        set1.add(56);
        set1.add(6);
        Assert.assertFalse(set1.add(6));
    }

    @Test(expected = NullPointerException.class)
    public void addTest(){
        Integer a = null;
        set1.add(a);
    }

    @Test
    public void testSizeWith4Element() {
        set1.add(2);
        set1.add(5);
        set1.add(896);
        set1.add(67);
        Assert.assertEquals(4,set1.size());
    }

    @Test
    public void testIsEmptyForEmpty(){
        Assert.assertTrue(set1.isEmpty());
    }

    @Test
    public void testIsEmptyForNotEmpty(){
        set1.add(56);
        Assert.assertFalse(set1.isEmpty());
    }

    @Test
    public void testContainsTrue(){
        set1.add(45);
        set1.add(784);
        Assert.assertTrue(set1.contains(784));
    }

    @Test
    public void testContainsFalse(){
        set1.add(45);
        set1.add(88);
        Assert.assertFalse(set1.contains(784));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsFailed(){
        set1.add(45);
        set1.add(88);
        Integer a = null;
        Assert.assertFalse(set1.contains(a));
    }

    @Test
    public void testToArrayObject(){
        Object[] arr = new Object[]{3, 7, 46};
        set1.add(3);
        set1.add(7);
        set1.add(46);
        Assert.assertArrayEquals(arr, set1.toArray());
    }

    @Test
    public void testToArrayAr1(){
        Integer[] arr = new Integer[]{7, 46};
        set1.add(3);
        set1.add(7);
        set1.add(46);
        Assert.assertArrayEquals(arr, set1.toArray(arr));
    }

    @Test
    public void testToArrayAr2(){
        Integer[] arr = new Integer[]{7, 55, 46};
        Integer[] arr2 = new Integer[] {7, 46};
        set1.add(3);
        set1.add(7);
        set1.add(46);
        Assert.assertArrayEquals(arr2, set1.toArray(arr));
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayArFailed(){
        Integer[] arr = null;
        Integer[] arr2 = new Integer[] {7, 46};
        set1.add(3);
        set1.add(7);
        set1.add(46);
        Assert.assertArrayEquals(arr2, set1.toArray(arr));
    }

    @Test
    public void testRemove(){
        set1.add(78);
        set1.add(45);
        set1.remove(78);
        Integer[] ar = new Integer[]{45};
        Assert.assertEquals(1, set1.size());
        Assert.assertArrayEquals(ar, set1.toArray());
    }

    @Test
    public void testRemoveTrue(){
        set1.add(78);
        Assert.assertTrue(set1.remove(78));
        Assert.assertTrue(set1.isEmpty());
    }

    @Test
    public void testRemoveFalse(){
        set1.add(67);
        Assert.assertFalse(set1.remove(3));
    }

    @Test
    public void testIncrease(){
        set1.addAll(Arrays.asList(4, 89, 67, 345, 86, 14, 35, 3567, 795, 45, 23));
        Assert.assertEquals(20, set1.getCapacity());
    }

    @Test
    public void testAddAllTrue(){
        set1.add(45);
        set1.add(893);
        set1.add(677);
        MySortedSet<Integer> set2 = new MySortedSet<Integer>(comp);
        set2.addAll(Arrays.asList(45, 893, 677));
        Assert.assertArrayEquals(set1.toArray(), set2.toArray());
    }

    @Test
    public void testAddAllFalse(){
        set1.add(45);
        set1.add(893);
        set1.add(677);
        Assert.assertFalse(set1.addAll(Arrays.asList(93, 677)));
    }

    @Test
    public void testContainsAllTrue(){
        set1.add(785);
        set1.add(890);
        set1.add(345);
        MySortedSet<Integer> set2 = new MySortedSet<Integer>(comp);
        set2.addAll(Arrays.asList(785, 345, 890));
        Assert.assertTrue(set1.containsAll(set2));
    }

    @Test
    public void testContainsAllFalse(){
        set1.add(785);
        set1.add(890);
        set1.add(345);
        MySortedSet<Integer> set2 = new MySortedSet<Integer>(comp);
        set2.addAll(Arrays.asList(345, 785));
        Assert.assertFalse(set1.containsAll(set2));
    }

    @Test
    public void testRemoveAll(){
        set1.add(785);
        set1.add(89);
        set1.add(34556);
        set1.add(56);
        set1.add(124);
        MySortedSet<Integer> set2 = new MySortedSet<>(comp);
        set2.addAll(Arrays.asList(56, 785, 34556));
        MySortedSet<Integer> set3 = new MySortedSet<>(comp);
        set3.addAll(Arrays.asList(89, 124));
        Assert.assertTrue(set1.removeAll(set2));
        Assert.assertArrayEquals(set3.toArray(), set1.toArray());
    }

    @Test
    public void testClear(){
        set1.add(87);
        set1.add(45);
        set1.add(67);
        set1.clear();
        Assert.assertTrue(set1.isEmpty());
        Assert.assertEquals(0, set1.size());
    }

    @Test
    public void testSubSet(){
        set1.add(678);
        set1.add(78);
        set1.add(2356);
        set1.add(4778);
        set1.add(56);
        MySortedSet<Integer> set2 = new MySortedSet<Integer>(comp);
        set2.add(78);
        set2.add(678);
        set2.add(2356);
        Assert.assertArrayEquals(set2.toArray(),set1.subSet(78, 4778).toArray());
    }

    @Test(expected = NullPointerException.class)
    public void testSubSetFailed(){
        Integer a = null;
        set1.add(8);
        set1.add(78);
        set1.add(80);
        set1.subSet(a, 1);
    }

    @Test
    public void testHeadSet(){
        set1.add(678);
        set1.add(78);
        set1.add(2356);
        set1.add(4778);
        set1.add(56);
        MySortedSet<Integer> set2 = new MySortedSet<Integer>(comp);
        set2.add(56);
        set2.add(78);
        Assert.assertArrayEquals(set2.toArray(),set1.headSet(678).toArray());
    }

    @Test(expected = NullPointerException.class)
    public void testHeadSetFailed(){
        Integer a = null;
        set1.headSet(a);
    }

    @Test
    public void testTailSet(){
        set1.add(678);
        set1.add(78);
        set1.add(2356);
        set1.add(4778);
        set1.add(56);
        MySortedSet<Integer> set2 = new MySortedSet<Integer>(comp);
        set2.add(4778);
        set2.add(2356);
        Assert.assertArrayEquals(set2.toArray(),set1.tailSet(2356).toArray());
    }

    @Test(expected = NullPointerException.class)
    public void testTailSetFailed(){
        Integer a = null;
        set1.tailSet(a);
    }

    @Test
    public void testFirst(){
        set1.add(56);
        set1.add(674);
        Assert.assertEquals(56, (Object)set1.first());
    }

    @Test(expected = NoSuchElementException.class)
    public void testFirstForEmpty(){
        set1.first();
    }

    @Test
    public void testLast(){
        set1.add(56);
        set1.add(674);
        set1.add(9);
        Assert.assertEquals(674, (Object)set1.last());
    }

    @Test(expected = NoSuchElementException.class)
    public void testLastForEmpty(){
        set1.last();
    }

    @After
    public void afterTest(){
        comp = null;
        set1 = null;
    }
}

