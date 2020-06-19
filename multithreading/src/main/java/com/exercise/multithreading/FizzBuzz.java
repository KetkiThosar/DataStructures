package com.exercise.multithreading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
	private int n;
	private Semaphore fizz, buzz, fizzbuzz, number;

	public FizzBuzz(int n) {
		this.n = n;
		fizz = new Semaphore(0);
		buzz = new Semaphore(0);
		fizzbuzz = new Semaphore(0);
		number = new Semaphore(1);
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		fizz.acquire();
		printFizz.run();
		number.release();
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		buzz.acquire();
		printBuzz.run();
		number.release();
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		fizzbuzz.acquire();
		printFizzBuzz.run();
		number.release();
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			number.acquire();
			if (n % 15 == 0) {
				fizzbuzz.release();
			} else if (i % 5 == 0) {
				buzz.release();
			} else if (i % 3 == 0) {
				fizz.release();
			} else {
				printNumber.accept(i);
				number.release();
			}
		}
	}

	public static void main(String[] args) {
		final FizzBuzz fizzBuzz = new FizzBuzz(20);
		final IntConsumer printNumber = new IntConsumer() {

			public void accept(int value) {
				System.out.print(value+",");
			}
		};
		try {
			fizzBuzz.number(printNumber);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			final Thread f = new Thread(new Runnable() {
				
				public void run() {
					fizzBuzz.fizz(f);
					System.out.print("fizz");

				}
			});

			final Thread b = new Thread(new Runnable() {

				public void run() {
					fizzBuzz.buzz(b);
					System.out.print("buzz");
				}
			});

			final Thread fb = new Thread(new Runnable() {

				public void run() {
					fizzBuzz.fizzbuzz(fb);
					System.out.print("fizzbuzz");

				}
			});
			
			Thread number  = new Thread(new Runnable() {
				
				public void run() {
					f.start();
					b.start();
					fb.start();
					
				}
			}); 
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
