<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>삼성생명</title>
    <!-- 컨텍스트 패스 적용 -->
    <link href="${pageContext.request.contextPath}/CSS/index.css" rel="stylesheet">
</head>
<body>
<jsp:include page="WEB-INF/jsp/include/menu.jsp"></jsp:include>
    <!-- 메인 비주얼 -->
    <div class="section1">
        <b>고객과 함께하는 인생금융</b>
        <p>어떠한 인생을 살아가든 필요할 때 힘이 되도록 책임지는 인생금융</p>
        <div class="container">
            <div class="quick">
                <h3>비전</h3>
                <p>삼성생명이 하는 일은 고객의 소중한 사랑을 더 큰 사랑으로 키워 주는 것입니다.</p>
            </div>
            <div class="quick">
                <h3>사회공헌</h3>
                <p>'사람,사랑'의 가치를 바탕으로 생명존중과 청소년교육을 테마로한 사회공헌을 이행하고 있습니다.</p>
            </div>
            <div class="quick">
                <h3>경영정보</h3>
                <p>삼성생명은 주주와 고객, 사회와 국가에게 변함없는 믿음을 전하겠습니다.</p>
            </div>
            <div class="quick last">
                <h3>채용안내</h3>
                <p>앞으로 더 빛날 당신과 함께 삼성생명의 내일이 시작됩니다.</p>
            </div>
        </div>
    </div>

    <!-- 섹션2 -->
    <div class="section2">
        <div class="intro1">
            <h3>지속가능경영</h3>
            <p>기업시민의 역할을 적극적으로 실천하는 존경받는 금융회사로 더욱 굳건히 서겠습니다.</p>
        </div>
        <div class="intro2">
            <h3>CEO인사말</h3>
            <p>성과에 안주하지 않고 부단한 혁신을 통해 글로벌 일류로 도약하겠습니다.</p>
        </div>
    </div>
</body>
</html>
