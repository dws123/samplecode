package com.foo.prodcon;

import java.util.LinkedList;




class WorkQueue {

	public static class Worker extends Thread {
		WorkQueue q;

		Worker(WorkQueue q) {
			this.q = q;
		}

		public void run() {
			try {
				while (true) {
					Object x = q.getWork();

					if (x == null) {
						break;
					}
					System.out.println(x);
				}
			} catch (InterruptedException e) {
			}
		}
	}
	LinkedList<Object> queue = new LinkedList<Object>();

	public synchronized void addWork(Object o) {
		queue.addLast(o);
		notify();
	}

	public synchronized Object getWork() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		return queue.removeFirst();
	}

	public static void main(String[] argv) {
		WorkQueue queue = new WorkQueue();

		int numWorkers = 2;
		Worker[] workers = new Worker[numWorkers];
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new Worker(queue);
			workers[i].start();
		}

		try {
			Thread.sleep( 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 100; i++) {
			queue.addWork(i);
		}
	}

}

