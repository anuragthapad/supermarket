package com.sapient.oms.entity;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerOrderMaster {
	
	private Integer orderId;
	@NotBlank
	private Long billNo;
	@NotBlank
	private LocalDate orderDate;
	private Double orderAmount;
	@Min(value = 0)
	private Integer tax;
	private Double specialDiscount;
	private Double billableAmount;
	private String paymentMode;
	private String currency;
	@NotBlank
	private Integer customerId;
	private String storeId;
}
