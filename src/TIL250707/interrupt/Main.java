package TIL250707.interrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker: 작업 시작");
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Working...");
                    Thread.sleep(500);
                }

//                Thread.sleep(10_000);


            } catch(InterruptedException e) {
                System.out.println("Worker: 중단 신호 수신, 정리 작업 후 종료");
            }
        });

        worker.start();
        Thread.sleep(2000);
        System.out.println("메인에서 인터럽트 신호 전송");
        worker.interrupt();
        worker.join();
        System.out.println("Worker: 작업 완료");
    }
}