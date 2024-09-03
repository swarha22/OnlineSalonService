package com.app.dto;

import com.app.entity.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
	private Long id;
	private Double price;
	private BookingStatus status;
	private Long userId;
	private Long staffId;
	private Long serviceId;
}