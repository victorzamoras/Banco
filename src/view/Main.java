package view;

import java.util.concurrent.Semaphore;

import controller.Banco;

public class Main {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(1);
		Semaphore s1 = new Semaphore(1);
		for (int id = 1; id <= 14; id++) {
			Thread t = new Banco(id, s, s1);
			t.start();

		}
	}
}