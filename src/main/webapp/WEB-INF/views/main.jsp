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
        <input type="text" id="totalCount" value="3" />
        <button onclick="requestPay(totalCount.value)">결제하기</button>

        <script>
            var IMP = window.IMP; // 생략 가능
            IMP.init("imp85183768"); // 예: imp00000000

            function requestPay(totalCount) {
                console.log(totalCount);
                // IMP.request_pay(param, callback) 결제창 호출
                IMP.request_pay(
                    {
                        // param
                        pg: "html5_inicis",
                        pay_method: "card",
                        merchant_uid: "ORD555555",
                        name: "DB에 저장하는 테스트",
                        amount: 100 * totalCount,
                        buyer_email: "test@gmail.com",
                        buyer_name: "홍길동",
                        buyer_tel: "010-3333-5555",
                        buyer_addr: "서울특별시 강남구",
                        buyer_postcode: "12345",
                    },
                    function (rsp) {
                        console.log(rsp.imp_uid);
                        // 결제 검증 코드
                        $.ajax({
                            type: "POST",
                            url: "/verifyIamport/" + rsp.imp_uid,
                        }).done(function (result) {
                            console.log(result);
                            if (rsp.paid_amount === result.response.amount) {
                                console.log(result.response.amount);
                                console.log(result.response.paidAt);
                                alert("결제에 성공했습니다.");
                                console.log(rsp.imp_uid);
                                console.log(rsp.merchant_uid);
                                console.log(rsp.paid_amount);
                                console.log(rsp.pay_method);
                                console.log(rsp.paid_at);

                                let data = {
                                    finalPrice: rsp.paid_amount,
                                    totalCount: totalCount,
                                    createdAt: result.response.paidAt,
                                };

                                $.ajax("/api/payment", {
                                    type: "POST",
                                    dataType: "json",
                                    data: JSON.stringify(data),
                                    headers: {
                                        "Content-Type": "application/json",
                                    },
                                }).done((response) => {
                                    alert(response.msg);
                                    console.log(response.data);
                                });
                            } else {
                                alert(
                                    "결제에 실패하였습니다. 에러 내용: " +
                                        rsp.error_msg
                                );
                            }
                        });
                        // callback
                    }
                );
            }
        </script>
    </body>
</html>
