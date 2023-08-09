<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" %>
<c:url var="mainUrl" value="/" />
<c:url var="loginUrl" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<c:url var="workListUrl" value="/works" />

<layout:common title="${title}">
    <jsp:attribute name="header">
        <section id="site_top" class="layout_width">
            <div class="left">
                <a href="${mainUrl}">
                    <i class="xi-home"></i>
                    메인페이지
                </a>
            </div>
            <div class="right">
                <a href="${loginUrl}">
                    <i class="xi-log-in"></i>
                    로그인
                </a>
                <a href="${joinUrl}">
                    <i class="xi-user-plus"></i>
                    회원가입
                </a>
                <a href="${workListUrl}">
                    <i class="xi-list"></i>
                    작업목록
                </a>
            </div>
        </section>
    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>
    <jsp:body>
       <jsp:doBody />
    </jsp:body>
</layout:common>