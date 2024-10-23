public class EsperaOcupada {
    private static volatile boolean flag = false; // variable bandera
    private static int sharedResourse = 0; // recurso compartido

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Process(1));
        Thread thread2 = new Thread(new Process(2));

        thread1.start();
        thread2.start();
    }

    static class Process implements Runnable {
        private int id;

        public Process(int id) {
            this.id = id;
        }

        @Override

        public void run() {
            for (int i = 0; i < 10; i++) {// Cafs hilo intentara acceder al recurso
                // Inteantar entrar en la seccion critica
                while (flag) {// Espera ocupada si el otro hilo esta en la seccion critica
                    // No hace nada solo espera

                }
                flag = true;
                System.out.println("Hilo" + id + "esta en la seccion critica");
                sharedResourse++;
                System.out.println("Recurso compartido" + sharedResourse);

                // Salida de la seccion critica
                flag = false;
            }
        }
    }
}