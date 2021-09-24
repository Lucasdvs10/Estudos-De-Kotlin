import java.util.*
import kotlin.math.ceil

class CalculadoraPreco {
    companion object{
        fun CalcularPrecoTotal(imposto:IImposto, precoPorDia:Double, precoPorHora:Double, pairDiaInicioERetorno:Pair<Date, Date>):Pair<Double, Double>{

            val diaInicial = pairDiaInicioERetorno.first
            val diaRetorno = pairDiaInicioERetorno.second


            val tempoEmHoras = (diaRetorno.time - diaInicial.time).toDouble() /(1000 * 60 * 60)

            val tempoEmHorasArredondadoPraCima = ceil(tempoEmHoras)

            val precoSemTaxa = if(tempoEmHorasArredondadoPraCima <= 12){
                precoPorHora * tempoEmHorasArredondadoPraCima
            }
            else{
                precoPorDia * ceil(tempoEmHoras/24)
            }

            var taxa = imposto.CalcularImposto(precoSemTaxa)

            return Pair(precoSemTaxa, taxa)
        }
    }
}