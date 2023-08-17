<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<input type="file" id="file" class="dn" multiple>
<dl>
    <dt>작업 상태</dt>
    <dd>
        <c:if test="${statusList != null}">
            <c:forEach var="status" items="${statusList}" varStatus="s">
                <input type="radio" name="status" value="${status[0]}" id="status_${s.index}"
                    ${work.status.name() == status[0] ? "checked" : ""} class="rdo_tab">
                <label for="status_${s.index}">${status[1]}</label>
            </c:forEach>
        </c:if>
    </dd>
</dl>
<dl>
    <dt>작업 제목</dt>
    <dd>
        <input type="text" name="subject" value="${work.subject}">
    </dd>
</dl>
<dl>
    <dt>작업 내용</dt>
    <dd>
        <textarea name="content" id="content">${work.content}</textarea>
        <button type="button" class="fileUpload image">이미지 추가</button>
    </dd>
</dl>
<dl>
    <dt>파일첨부</dt>
    <dd>
        <button type="button" class="fileUpload">업로드</button>
    </dd>
</dl>