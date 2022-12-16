package com.example.demo.dto;

import java.sql.Timestamp;

import com.example.demo.domain.payment.Payment;

import lombok.Getter;
import lombok.Setter;

public class PaymentReqDto {

  @Setter
  @Getter
  public static class PaymentSaveReqDto {
    private Long totalCount;
    private Long finalPrice;
    private Timestamp createdAt;

    public Payment toEntity() {
      return Payment.builder()
          .totalCount(totalCount)
          .finalPrice(finalPrice)
          .createdAt(createdAt)
          .build();
    }
  }
}
