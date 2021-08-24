package com.example.practicafinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var info: TextView
    private lateinit var carList: Array<Car>
    private var index: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        info = findViewById(R.id.info)
        this.carList = arrayOf<Car>()

    }

    fun getPreviousCar(view: View) {
        if (index == 0) {
            if (carList.size != 1) {
                index = carList.size - 1
            }
        } else {
            index = index!! - 1
        }
        info.text = "nombre: ${carList[index!!].name}\n" +
                "model: ${carList[index!!].model}\n" +
                "color: ${carList[index!!].color}\n" +
                "tipo: ${carList[index!!].type}"
    }

    fun getNextCar(view: View) {
        if ( index == (carList.size-1) ) {
            index = 0
        } else {
            index = index!! +1
        }
        info.text = "nombre: ${carList[index!!].name}\n" +
                "modelo: ${carList[index!!].model}\n" +
                "color: ${carList[index!!].color}\n" +
                "tipo: ${carList[index!!].type}"

    }

    fun createNewCar(view: View) {
        var rNumber = (1965..2022).random()
        var car: Car
        when(rNumber) {
            in 1965..1974 -> car = Car("Ford Mustang GT500", rNumber, "Verde", "Deportivo")
            in 1975..1985 -> car = Car("Lamborghini Countach LP500S", rNumber, "Blanco", null)
            in 1986..1995 -> car = Car("McLaren F1", rNumber, "Naranja", "Superdeportivo")
            in 1996..2005 -> car = Car("Nissan GTR R34", rNumber, "Azul", null)
            in 2006..2010 -> car = Car("Bugatti Veyron", rNumber, "Negro", "Superdeportivo")
            in 2011..2022 -> car = Car("Porsche 918 Spyder", rNumber, "Negro", "Superdeportivo Hybrid")
            else -> car = Car("Subaru BRZ", rNumber, "Verde", "Deportivo")
        }

        var newArray = arrayOf<Car>(*carList, car)
        this.carList = newArray
        if ( index == null ) {
            index = 0
        } else {
            index = index!! +1
        }

        toast("Agregando el nuevo auto: ${car.name} ${car.model}")
        info.text = "nombre: ${car.name}\n" +
                "modelo: ${car.model}\n" +
                "color: ${car.color}\n" +
                "tipo: ${car.type}"
    }

    fun makeSound(view: View) {
        var rNumber = (0..2).random()

        if (rNumber == 0){
            toast("${carList[index!!].name} suena raro")
        }
        else if (rNumber == 1){
            toast("${carList[index!!].name} el motor se escucha bien")
        }
        else{
            toast("${carList[index!!].name} ruido raro en el escape")
        }
    }

    fun function(view: View) {
        var rNumber = (0..2).random()

        if (rNumber == 0){
            toast("${carList[index!!].name} arranca bien")
        }
        else if (rNumber == 1){
            toast("${carList[index!!].name} el freno se atora")
        }
        else{
            toast("${carList[index!!].name} la caja de cambios esta deteriorada")
        }
    }

    fun lights(view: View) {
        var rNumber = (0..2).random()

        if (rNumber == 0){
            toast("${carList[index!!].name} se muestra el testigo del aceite")
        }
        else if (rNumber == 1){
            toast("${carList[index!!].name} la presion de las llantas esta baja")
        }
        else{
            toast("${carList[index!!].name} alguno de los stop no funciona")
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message + carList, Toast.LENGTH_LONG).show()
    }
}