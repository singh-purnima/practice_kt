package purnima

import org.testng.Assert.*
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
class MyLinkedListTest {

    private lateinit var list: MyLinkedList<Char>

    @BeforeMethod
    fun setup() {
        list = MyLinkedList()
    }

    @Test
    fun testAppend() {
        assertTrue(list.isEmpty)
        assertEquals(list.length, 0)

        list.append('a')
        assertFalse(list.isEmpty)
        assertEquals(list.length, 1)

        list.append('b')
        assertFalse(list.isEmpty)
        assertEquals(list.length, 2)

        list.append('c')
        assertFalse(list.isEmpty)
        assertEquals(list.length, 3)

        assertEquals(list.first, 'a')
        assertEquals(list.last, 'c')

        assertEquals(list.toList(), listOf('a', 'b', 'c'))
    }

    @Test
    fun testPrepend() {
        assertTrue(list.isEmpty)
        assertEquals(list.length, 0)

        list.prepend('a')
        assertFalse(list.isEmpty)
        assertEquals(list.length, 1)

        list.prepend('b')
        assertFalse(list.isEmpty)
        assertEquals(list.length, 2)

        list.prepend('c')
        assertFalse(list.isEmpty)
        assertEquals(list.length, 3)

        assertEquals(list.first, 'c')
        assertEquals(list.last, 'a')

        assertEquals(list.toList(), listOf('c', 'b', 'a'))
    }

    @Test
    fun testGetAt() {
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')
        list.append('e')
        list.append('f')

        assertEquals(list.getAt(0), 'a')
        assertEquals(list.getAt(3), 'd')
        assertEquals(list.getAt(5), 'f')
        assertEquals(list.getAt(6), null)
    }

    @Test
    fun testIndexOf() {
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')
        list.append('e')
        list.append('f')

        assertEquals(list.indexOf('a'), 0)
        assertEquals(list.indexOf('d'), 3)
        assertEquals(list.indexOf('f'), 5)
        assertEquals(list.indexOf('z'), null)
    }

    @Test
    fun testRemoveAtIndex() {
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')
        list.append('e')
        list.append('f')

        // at first position
        list.removeAt(0)
        assertEquals(list.length, 5)
        assertEquals(list.first, 'b')

        assertEquals(list.toList(), listOf('b', 'c', 'd', 'e', 'f'))

        list.removeAt(2)
        assertEquals(list.length, 4)
        assertEquals(list.toList(), listOf('b', 'c', 'e', 'f'))

        // at last position
        list.removeAt(3)
        assertEquals(list.length, 3)
        assertEquals(list.toList(), listOf('b', 'c', 'e'))
        assertEquals(list.last, 'e')
    }

    @Test
    fun `test remove from single element`() {
        list.append('a')

        list.removeAt(0)

        assertTrue(list.isEmpty)
        assertEquals(list.length, 0)
        assertEquals(list.toList(), listOf<Int>())
        assertEquals(list.first, null)
        assertEquals(list.last, null)
    }

    @DataProvider
    fun invalidRemoveIndexesFromEmpty(): Array<Array<Any>> {
        return arrayOf(
            arrayOf(0),
            arrayOf(-1),
            arrayOf(3),
        )
    }

    @DataProvider
    fun invalidRemoveIndexes(): Array<Array<Any>> {
        return arrayOf(
            arrayOf(-1),
            arrayOf(2),
        )
    }

    @Test(dataProvider = "invalidRemoveIndexesFromEmpty", expectedExceptions = [IndexOutOfBoundsException::class])
    fun `test remove invalid from empty list`(n: Int) {
        list.removeAt(n)
    }

    @Test(dataProvider = "invalidRemoveIndexes", expectedExceptions = [IndexOutOfBoundsException::class])
    fun `test remove invalid from list`(n: Int) {
        list.append('a')
        list.append('b')

        list.removeAt(n)
    }

    @Test
    fun `test insert in empty list`() {
        list.insertAt(0, 'a')

        assertEquals(list.toList(), listOf('a'))
        assertEquals(list.first, 'a')
        assertEquals(list.last, 'b')
        assertEquals(list.length, 1)
    }

    @Test
    fun `test insert in single list - in front`() {
        list.append('a')

        list.insertAt(0, 'z')

        assertEquals(list.toList(), listOf('z', 'a'))
        assertEquals(list.first, 'z')
        assertEquals(list.last, 'a')
        assertEquals(list.length, 2)
    }

    @Test
    fun `test insert in single list - in back`() {
        list.append('a')

        list.insertAt(1, 'z')

        assertEquals(list.toList(), listOf('a', 'z'))
        assertEquals(list.first, 'a')
        assertEquals(list.last, 'z')
        assertEquals(list.length, 2)
    }

    @Test
    fun `test insert - before`  () {
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')

        list.insertAt(0, 'R')
        assertEquals(list.toList(), listOf('R', 'a', 'b', 'c', 'd'))
        assertEquals(list.first, 'R')
        assertEquals(list.last, 'd')
        assertEquals(list.length, 5)

    }

    @Test
    fun `test insert - after first` () {
        list.insertAt(1, 'I')
        assertEquals(list.toList(), listOf('R', 'I', 'a', 'b', 'c', 'd'))
        assertEquals(list.first, 'R')
        assertEquals(list.last, 'd')
        assertEquals(list.length, 6)
    }

    @Test
    fun `test insert - in somewhere middle`() {

        list.insertAt(3, 'T')
        assertEquals(list.toList(), listOf('R', 'I', 'a', 'T', 'b', 'c', 'd', 'T'))
        assertEquals(list.first, 'R')
        assertEquals(list.last, 'T')
        assertEquals(list.length, 7)

    }
    @Test
    fun `test insert -`() {
        list.insertAt(7, 'U')
        assertEquals(list.toList(), listOf('R', 'I', 'a', 'T', 'b', 'c', 'd', 'U'))
        assertEquals(list.first, 'R')
        assertEquals(list.last, 'U')
        assertEquals(list.length, 8)

    }
}