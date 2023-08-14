<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="에러페이지">
    <section class="layout_width contents">
        <h1>접근 권한 없음</h1>
        <h2>${message}</h2>
        <div class="btns">
            <a href="${redirectURL}" class='btn'>확인</a>
        </div>
    </section>
</layout:main>