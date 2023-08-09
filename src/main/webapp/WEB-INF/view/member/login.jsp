<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="action" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<c:url var="findIdUrl" value="/member/find_id" />
<c:url var="findPwUrl" value="/member/find_pw" />
<layout:main title="로그인">
    <form name="frmLogin" method="POST" action="${action}" autocomplete="off">
        <dl>
            <dt>아이디</dt>
            <dd>
                <input type="text" name="userId">
            </dd>
        <dl>
            <dt>비밀번호</dt>
            <dd>
                <input type="password" name="userPw">
            </dd>
        </dl>
        <div>
            <input type="checkbox" name="saveId" value="true" id="saveId">
            <label for="saveId">아이디 저장</label>
        </div>
        <div>
            <a href="${findIdUrl}">아이디 찾기</a> /
            <a href="${findPwUrl}">비밀번호 찾기</a> /
            <a href="${joinUrl}">회원가입</a>
        </div>
        <button type="submit">로그인</button>
        </dl>
    </form>
</layout:main>