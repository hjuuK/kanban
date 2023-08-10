<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="action" value="/member/join" />

<layout:main title="회원가입">

<section class="layout_width contents">
    <h1>회원가입</h1>
    <form name="frmJoin" method="POST" action="${action}" autocomplete="off" target="ifrmProcess">
        <jsp:include page="_form.jsp" />
        <div class="ac mt20">
            <input type="checkbox" name="agree" value="true" id="agree">
            <label for="agree">회원가입 약관에 동의합니다.</label>
        </div>
        <div class="btns">
            <button type="reset">다시입력</button>
            <button type="submit">가입하기</button>
        </div>
    </form>
</section>
</layout:main>