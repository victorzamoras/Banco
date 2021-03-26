package controller;

import java.util.concurrent.Semaphore;

public class Banco extends Thread {
	private Semaphore s, s1;
	private int id;

	public Banco(int id, Semaphore s, Semaphore s1) {
		this.id = id;
		this.s = s;
		this.s1 = s1;
	}

	@Override
	public void run() {
		int num = (int) ((Math.random() * 2) + 1);
		if (num % 2 == 0) {
			try {
				s.acquire();
				saque();
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s.release();
			}
		} else {
			try {
				s1.acquire();
				deposito();
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s1.release();
			}
		}

	}

	private void saque() {
		System.out.println("Pessoa " + id + " está sacando");
	}

	private void deposito() {
		System.out.println("Pessoa " + id + " está depositando");
	}

}
