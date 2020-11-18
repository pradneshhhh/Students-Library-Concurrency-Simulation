package com.concurrency.simulation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	private int id;
	private Lock lock;
	
	public Book(int id) {
		this.id = id;
		this.lock = new ReentrantLock();
	}
	
	public void read(Student student) throws InterruptedException {
		if(lock.tryLock(1, TimeUnit.MINUTES)) {
			System.out.println(student.toString()+" started reading "+this.toString());
			Thread.sleep(2000);
			lock.unlock();
			System.out.println(student.toString()+" finished reading "+this.toString());
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + "]";
	}
	
}
