class ImpostoBrasil:IImposto {
    override fun CalcularImposto(valor:Double):Double{
        return if(valor<= 100) (valor*0.2) else (valor*0.15)
    }
}