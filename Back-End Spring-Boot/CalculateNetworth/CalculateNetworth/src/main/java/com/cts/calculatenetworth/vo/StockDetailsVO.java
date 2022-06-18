package com.cts.calculatenetworth.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockDetailsVO {
	private Integer stockId;
	private String stockName;
	private double stockValue;
}
