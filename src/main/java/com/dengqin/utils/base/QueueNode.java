package com.dengqin.utils.base;

import java.util.LinkedList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * LinkedList实现的队列，线程安全
 *
 * Created by dq on 2017/9/22.
 */
public class QueueNode<T> {

	private ReadWriteLock lock = new ReentrantReadWriteLock();

	private LinkedList<T> queue = new LinkedList<T>();

	/**
	 * 如果超过2个节点，则删除队列最后的一个节点；否则不删除
	 */
	public void leaveFirstNode() {
		try {
			lock.writeLock().lock();
			while (queue.size() > 2) {
				queue.removeLast();
			}
		} finally {
			lock.writeLock().unlock();
		}
	}

	/**
	 * 往队列的头部插入一个节点
	 * 
	 * @param list
	 */
	public void addToQueue(T list) {
		try {
			lock.writeLock().lock();
			queue.addFirst(list);
		} finally {
			lock.writeLock().unlock();
		}
	}

	/**
	 * 获取队列头部的第一个元素
	 * 
	 * @return
	 */
	public T getFirstNode() {
		try {
			lock.readLock().lock();
			if (queue.size() > 0) {
				return queue.getFirst();
			}
		} finally {
			lock.readLock().unlock();
		}
		return null;
	}

}
