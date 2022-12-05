<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
    </head>
    <body>
        <button onclick="requestPay()">결제하기</button>
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
        <script>
            var IMP = window.IMP; // 생략 가능
            IMP.init("imp85183768"); // 예: imp00000000
        </script>
    </body>
</html>
