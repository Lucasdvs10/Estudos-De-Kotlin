import java.lang.NumberFormatException
import java.text.SimpleDateFormat

import java.util.*

fun main() {
    val diaInicio:Date
    val diaDevolucao:Date

    try {
        println("Dia de inicio:  DD/MM/YYYY HH:MM")
        diaInicio = Date(readLine())
        println("Dia da devolução:  DD/MM/YYYY HH:MM")
        diaDevolucao = Date(readLine())

        if(diaDevolucao.before(diaInicio)){
            throw ExcessaoDataImpossivel("Wow, você consegue voltar no tempo. Que maneiro!")
        }

        val pairDias = Pair<Date, Date>(diaInicio, diaDevolucao)

        print("Preço por hora: ")
        var precoPorHora = readLine()!!.toDouble()
        precoPorHora = if(precoPorHora >= 0)precoPorHora else 0.0

        print("Preço por dia: ")
        var precoPorDia = readLine()!!.toDouble()
        precoPorDia = if(precoPorDia >= 0) precoPorDia else 0.0

        val pairPrecoEImposto = CalculadoraPreco.CalcularPrecoTotal(ImpostoBrasil(), precoPorDia, precoPorHora, pairDias)

        println("----------------------------------------------------")
        println("Preço antes do imposto: ${pairPrecoEImposto.first}")
        println("Imposto: ${pairPrecoEImposto.second}")
        println("Preço total: ${pairPrecoEImposto.first + pairPrecoEImposto.second}")


    }catch (excessao: ExcessaoDataImpossivel){
        println(excessao.message)
    }
    catch (excessao:Exception){
        println("Valor inválido!")
    }
}