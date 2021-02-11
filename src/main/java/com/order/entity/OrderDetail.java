package com.order.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderDetail.
 */
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document

public class OrderDetail implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The order id. */
	@Id
	private String orderId;

	/** The customer id. */
	private String customerId;

	/** The item id. */
	private String itemId;

	/** The note. */
	private String note;

	/** The order total. */
	private double orderTotal;

	/** The quantity. */
	private int quantity;

	/** The shipping cost. */
	private double shippingCost;

	/** The status. */
	private int status;

	/** The timestamp. */
	private Date timestamp;

	/**
	 * Instantiates a new order detail.
	 */
	public OrderDetail() {
	}

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public String getOrderId() {
		return this.orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the new order id
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return this.customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public String getItemId() {
		return this.itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * Sets the note.
	 *
	 * @param note the new note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Gets the order total.
	 *
	 * @return the order total
	 */
	public double getOrderTotal() {
		return this.orderTotal;
	}

	/**
	 * Sets the order total.
	 *
	 * @param orderTotal the new order total
	 */
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the shipping cost.
	 *
	 * @return the shipping cost
	 */
	public double getShippingCost() {
		return this.shippingCost;
	}

	/**
	 * Sets the shipping cost.
	 *
	 * @param shippingCost the new shipping cost
	 */
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return this.timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}