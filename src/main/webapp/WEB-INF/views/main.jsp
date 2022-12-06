<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <!-- jQuery -->
        <script
            type="text/javascript"
            src="https://code.jquery.com/jquery-1.12.4.min.js"
        ></script>
        <!-- iamport.payment.js -->
        <script
            type="text/javascript"
            src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"
        ></script>
    </head>
    <body>
        <button onclick="requestPay()">결제하기</button>

        <script>
            var IMP = window.IMP; // 생략 가능
            IMP.init("imp85183768"); // 예: imp00000000

            function requestPay() {
                // IMP.request_pay(param, callback) 결제창 호출
                IMP.request_pay(
                    {
                        // param
                        pg: "html5_inicis",
                        pay_method: "card",
                        merchant_uid: "ORD20180131-135",
                        name: "결제정보 저장 전 마지막 테스트",
                        amount: 100,
                        buyer_email: "test@gmail.com",
                        buyer_name: "홍길동",
                        buyer_tel: "010-3333-7777",
                        buyer_addr: "서울특별시 강남구",
                        buyer_postcode: "12345",
                    },
                    function (rsp) {
                        // callback
                        if (rsp.success) {
                            alert("결제에 성공했습니다.");
                            console.log(rsp.imp_uid);
                            console.log(rsp.merchant_uid);
                            console.log(rsp.paid_amount);
                            console.log(rsp.pay_method);
                            console.log(rsp.paid_at);
                        } else {
                            alert(
                                "결제에 실패하였습니다. 에러 내용: " +
                                    rsp.error_msg
                            );
                        }
                    }
                );
            }
        </script>
    </body>
</html>
