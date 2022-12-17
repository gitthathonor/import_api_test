package com.example.demo.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.payment.PaymentRepository;
import com.example.demo.dto.PaymentReqDto.PaymentCancelReqDto;
import com.example.demo.dto.PaymentReqDto.PaymentSaveReqDto;
import com.example.demo.dto.PaymentRespDto.PaymentSaveRespDto;
import com.example.demo.dto.ResponseDto;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PaymentApiController {

  private final Logger log = LoggerFactory.getLogger(getClass());
  private final IamportClient iamportClient = new IamportClient("1318833130671340",
      "JrgzUN4r7a5fJOCz48LmnTSv30olkOQ6kLVaToiGoHxvfI82OAjjwjlOHRYmsCnOf7bZFWRJLe21tsw4");
  private final PaymentRepository paymentRepository;

  /** 프론트에서 받은 PG사 결괏값을 통해 아임포트 토큰 발행 **/
  @PostMapping("/verifyIamport/{imp_uid}")
  public IamportResponse<Payment> paymentByImpUid(@PathVariable String imp_uid)
      throws IamportResponseException, IOException {
    log.info("paymentByImpUid 진입");
    log.debug("디버그 : 토큰 정보 : " + iamportClient.paymentByImpUid(imp_uid));
    return iamportClient.paymentByImpUid(imp_uid);
  }

  @PostMapping("/api/payment")
  public ResponseDto<?> savePayment(@RequestBody PaymentSaveReqDto paymentSaveReqDto) {
    com.example.demo.domain.payment.Payment payment = paymentRepository.save(paymentSaveReqDto.toEntity());
    PaymentSaveRespDto paymentSaveRespDto = new PaymentSaveRespDto(payment);
    return new ResponseDto<>("결제정보 입력 성공", paymentSaveRespDto);
  }

  @PostMapping("/payments/cancel")
  public ResponseDto<?> cancelPayments(@RequestBody PaymentCancelReqDto paymentCancelReqDto) {
    return new ResponseDto<>("결제취소 성공", null);
  }

}
