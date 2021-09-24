class GameMenager() {
    companion object {
        fun VerificaGanhador(jogadaUsuario: Jogada, jogadaComputador: Jogada) {
            if (jogadaUsuario.listaDePerdedores.contains(jogadaComputador.jogada)){
                println("Usuário venceu!")
            }
            else if(jogadaUsuario == jogadaComputador){
                println("Empate")
            }
            else{
                println("A máquina venceu!")
            }
        }
    }
}