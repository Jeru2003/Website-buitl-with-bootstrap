class Contador {
    private int cuenta = 0;

    public void incrementar() {
        cuenta++;
    }

    public void obtenerCuenta() {
        return cuenta;
    }
}

class HiloContador extends Thread {
    private Contador contador;

    public HiloContador(Contador contaador) {
        this.contador = contador;
    }
}

@Override

public void run() {
    for (int i = 0; i < 1000; i++) {
        contador.incrementar();
    }
}

public class CondicionCompetencia {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        HiloContador hilo1 = new HiloContador(contador);
        HiloContador hilo2 = new HiloContador(contador);

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Valor final del contador" + contador.obtenerCuenta());
    }
}