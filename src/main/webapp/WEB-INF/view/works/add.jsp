<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="action" value="/works/add" />
<layout:main title="작업 등록">
    <section class="layout_width contents">
    <h1>작업 등록</h1>
    <form name="frmSave" method="POST" action="${action}" autocomplete="off" target="ifrmProcess">
        <jsp:include page="_form.jsp" />
        <div class="btns">
            <button type="reset">다시입력</button>
            <button type="submit">등록하기</button>
        </div>
    </form>
    </section>
</layout:main>