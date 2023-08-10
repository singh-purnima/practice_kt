package purnima

import org.testng.Assert.assertEquals
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class FactorialTest {

    private lateinit var factorial: Factorial

    @BeforeMethod
    fun setUp() {
        factorial = Factorial()
    }


    @Test
    fun testEdgeCase() {
        val result = factorial.fact(0)
        assertEquals(result, 1)
    }


    @Test(dataProvider = "numbers")
    fun testNormal(n: Int, expected: Int) {
        val result = factorial.fact(n)
        assertEquals(result, expected)
    }

    @DataProvider
    fun numbers(): Array<Array<Any>> {
        return arrayOf(
            arrayOf(2, 2),
            arrayOf(3, 6),
            arrayOf(4, 24),
            arrayOf(10, 3628800),
        )
    }
}