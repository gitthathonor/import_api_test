package com.example.demo.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PaymentApiController {

  private final Logger log = LoggerFactory.getLogger(getClass());
  private final IamportClient iamportClient;

  public PaymentApiController() {
    this.iamportClient = new IamportClient("1318833130671340",
        "JrgzUN4r7a5fJOCz48LmnTSv30olkOQ6kLVaToiGoHxvfI82OAjjwjlOHRYmsCnOf7bZFWRJLe21tsw4");
  }

  /** 프론트에서 받은 PG사 결괏값을 통해 아임포트 토큰 발행 **/
  @PostMapping("/{imp_uid}")
  public IamportResponse<Payment> paymentByImpUid(@PathVariable String imp_uid)
      throws IamportResponseException, IOException {
    log.info("paymentByImpUid 진입");
    return iamportClient.paymentByImpUid(imp_uid);
  }

}
