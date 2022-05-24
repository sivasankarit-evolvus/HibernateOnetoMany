package com.demo;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="stock_daily_record",catalog="demo")
public class StockDailyRecord implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer recordId;
	private Stock stock;
	private Float priceOpen;
	private Float priceClose;
	private Float priceChange;
	private Long volume;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", unique = true)
	private Date date;
	public StockDailyRecord() {
		
	}
	public StockDailyRecord(Stock stock, Date date) {
		this.stock = stock;
		this.date = date;
	}

	public StockDailyRecord(Stock stock, Float priceOpen, Float priceClose,
			Float priceChange, Long volume, Date date) {
		this.stock = stock;
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceChange = priceChange;
		this.volume = volume;
		this.date = date;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RECORD_ID", unique = true, nullable = false)
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCK_ID", nullable = false)
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	@Column(name = "PRICE_OPEN")
	public Float getPriceOpen() {
		return priceOpen;
	}
	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}
	@Column(name = "PRICE_CLOSE")
	public Float getPriceClose() {
		return priceClose;
	}
	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}
	@Column(name = "PRICE_CHANGE")
	public Float getPriceChange() {
		return priceChange;
	}
	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}
	@Column(name = "VOLUME")
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
