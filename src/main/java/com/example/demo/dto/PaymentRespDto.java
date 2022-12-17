package com.example.demo.dto;

import com.example.demo.domain.payment.Payment;

import lombok.Getter;
import lombok.Setter;

public class PaymentRespDto {

  @Setter
  @Getter
  public static class PaymentSaveRespDto {
    private Long id;
    private String impId;
    private Long totalCount;
    private Long finalPrice;
    private String createdAt;

    public PaymentSaveRespDto(Payment payment) {
      this.id = payment.getId();
      this.impId = payment.getImpId();
      this.totalCount = payment.getTotalCount();
      this.finalPrice = payment.getFinalPrice();
      this.createdAt = payment.getCreatedAt().toString();
    }

  }
}
