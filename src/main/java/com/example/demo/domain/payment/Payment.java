package com.example.demo.domain.payment;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "payment")
@Entity
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String impId; // 아임포트 고유 결제 ID -> 결제 취소 시에 사용할 예정
  @Column(nullable = true)
  private Long totalCount;
  @Column(nullable = true)
  private Long finalPrice;
  private Timestamp createdAt;

  @Builder
  public Payment(Long id, String impId, Long totalCount, Long finalPrice, Timestamp createdAt) {
    this.id = id;
    this.impId = impId;
    this.totalCount = totalCount;
    this.finalPrice = finalPrice;
    this.createdAt = createdAt;
  }

}
