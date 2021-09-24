import kotlin.random.Random

fun main() {
    val jogouPedra = Jogada(EJogadasPossiveis.PEDRA, setOf(EJogadasPossiveis.TESOURA, EJogadasPossiveis.LAGARTO))
    val jogouPapel = Jogada(EJogadasPossiveis.PAPEL, setOf(EJogadasPossiveis.SPOCK, EJogadasPossiveis.PEDRA))
    val jogouTesoura = Jogada(EJogadasPossiveis.TESOURA, setOf(EJogadasPossiveis.PAPEL, EJogadasPossiveis.LAGARTO))
    val jogouLagarto = Jogada(EJogadasPossiveis.LAGARTO, setOf(EJogadasPossiveis.PAPEL, EJogadasPossiveis.SPOCK))
    val jogouSpock = Jogada(EJogadasPossiveis.SPOCK, setOf(EJogadasPossiveis.PEDRA, EJogadasPossiveis.TESOURA))

    val listaJogadasPossiveis = arrayOf(jogouLagarto, jogouSpock, jogouPapel, jogouPedra, jogouTesoura)

    var jogadaUsuario:Jogada
    var jogadaComputador:Jogada

    while (true)
        {
            try {
                print("Insira sua jogada: Lagarto(1), Spock(2), Papel(3), Pedra(4), Tesoura(5): ")
                val inputUsuario = readLine()!!.toInt()

                jogadaUsuario = listaJogadasPossiveis[inputUsuario - 1]

                jogadaComputador = listaJogadasPossiveis[Random.nextInt(listaJogadasPossiveis.size)]
                println("Computador jogou ${jogadaComputador.jogada}")

                break

            } catch (excessao: NumberFormatException) {
                println("Tu digitaste uma jogada inválida!")
                println("-----------------------------------")
            }
            catch (excessao: ArrayIndexOutOfBoundsException){
                println("Digitou uma jogada que não está na lista!")
                println("-----------------------------------")
            }
        }



    GameMenager.VerificaGanhador(jogadaUsuario, jogadaComputador)

}

