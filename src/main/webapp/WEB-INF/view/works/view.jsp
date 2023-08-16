<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="listUrl" value="/works" />
<c:url var="editUrl" value="/works/edit/${work.workNo}" />
<c:url var="addUrl" value="/works/add" />
<c:url var="deleteUrl" value="/works/delete/${work.workNo}" />

<layout:main title="작업 보기">
    <section class="work_view layout_width contents">
    <h1>작업 상세 내용</h1>
    <div class="user_nm">
        작업자 : ${work.userNm}
    </div>
        <div class="subject">
            <span class="status">${work.status.status}</span>
            ${work.subject}
        </div>
        <div class="content">
            ${work.content}
        </div>
        <div class="links">
            <a href="${listUrl}">목록</a>
            <a href="${editUrl}">수정</a>
            <a href="${addUrl}">등록</a>
            <a href="${deleteUrl}" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
        </div>
    </section>
</layout:main>