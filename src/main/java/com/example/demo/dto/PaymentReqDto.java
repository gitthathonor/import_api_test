package com.example.demo.dto;

import java.sql.Timestamp;

import com.example.demo.domain.payment.Payment;

import lombok.Getter;
import lombok.Setter;

public class PaymentReqDto {

  @Setter
  @Getter
  public static class PaymentSaveReqDto {
    private String impId;
    private Long totalCount;
    private Long finalPrice;
    private Timestamp createdAt;

    public Payment toEntity() {
      return Payment.builder()
          .impId(impId)
          .totalCount(totalCount)
          .finalPrice(finalPrice)
          .createdAt(createdAt)
          .build();
    }
  }

  @Setter
  @Getter
  public static class PaymentCancelReqDto {
    private String impId;

    public Payment toEntity() {
      return Payment.builder()
          .impId(impId)
          .build();
    }
  }
}
