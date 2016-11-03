package com.core.java.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerImpl {

	public static void main(String[] args) {

		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		QueueProducer producer = new QueueProducer(queue);
		QueueConsumer consumer = new QueueConsumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		System.out
				.println("Let's get started. Producer / Consumer Test Started.\n");
	}

	static class QueueProducer implements Runnable {

		private BlockingQueue<Message> queue;

		public QueueProducer(BlockingQueue<Message> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				Message msg = new Message("i'm msg " + i);
				try {
					Thread.sleep(10);
					queue.put(msg);
					System.out.println("QueueProducer: Message - "
							+ msg.getMsg() + " produced.");
				} catch (Exception e) {
					System.out.println("Exception:" + e);
				}
			}

			Message msg = new Message(
					"All done from Producer side. Produced 5 Messages");
			try {
				queue.put(msg);
				System.out.println("QueueProducer: Exit Message - "
						+ msg.getMsg());
			} catch (Exception e) {
				System.out.println("Exception:" + e);
			}
		}
	}

	static class QueueConsumer implements Runnable {

		private BlockingQueue<Message> queue;

		public QueueConsumer(BlockingQueue<Message> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				Message msg;

				while ((msg = queue.take()).getMsg() != "exit") {
					Thread.sleep(10);
					System.out.println("QueueConsumer: Message - "
							+ msg.getMsg() + " consumed.");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
