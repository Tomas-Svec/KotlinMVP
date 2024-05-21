import kotlin.test.Test
import kotlin.test.assertEquals

class ExampleTest {
    @Test
    fun myFirstTest() {

        //Given //Dado cierto objeto
        val x = 5
        val y = 10

        //When  //Cuanto se realice cierta tarea
        val result = x+y

        //Then //Quiero obtener un resultado
        assertEquals(15, result)

    }

    @Test
    fun mySecondTest() {

        //Given //Dado cierto objeto
        val x = 5
        val y = 10

        //When  //Cuanto se realice cierta tarea
        val result = x+y

        //Then //Quiero obtener un resultado
        assertEquals(15, result)

    }
}