package purnima

class Factorial {

    fun fact(n : Int) : Int {
        return if(n <= 1) {
            1
        } else {
            n * fact(n-1)
        }
    }
}