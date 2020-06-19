package com.exercise.multithreading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;


public class ZeroEvenOdd {
	private int n;
	private Semaphore semaphoreZero, semaphoreEven, semaphoreOdd;

	public ZeroEvenOdd(int n) {
		this.n = n;
		semaphoreZero = new Semaphore(1);
		semaphoreEven = new Semaphore(0);
		semaphoreOdd = new Semaphore(0);
	}

	public void zero(IntConsumer printNumber) throws InterruptedException {
		boolean isEven = false;
		for (int i = 0; i < n; i++) {
			semaphoreZero.acquire();
			printNumber.accept(0);
			if (isEven) {
				semaphoreEven.release();
			} else {
				semaphoreOdd.release();
			}
			isEven = !isEven;
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i=i+2) {
			semaphoreEven.acquire();
			printNumber.accept(i);
			semaphoreZero.release();
		}

	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i = i + 2) {
			semaphoreOdd.acquire();
			printNumber.accept(i);
			semaphoreZero.release();
		}

	}

	public static void main(String[] args) {
		final ZeroEvenOdd obj = new ZeroEvenOdd(5);
		final IntConsumer printNumber = new IntConsumer() {

			public void accept(int value) {
				System.out.print(value);
			}
		};
		Thread a = new Thread(new Runnable() {

			public void run() {
				try {
					obj.zero(printNumber);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread b = new Thread(new Runnable() {

			public void run() {
				try {
					obj.even(printNumber);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread c = new Thread(new Runnable() {

			public void run() {
				try {
					obj.odd(printNumber);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		b.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.start();
	}

}
