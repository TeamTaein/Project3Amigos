<%@ tag body-content="scriptless" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ tag trimDirectiveWhitespaces="true" %>
 
<c:if test="${empty sessionScope.authUser }" >
<jsp:doBody />
</c:if>
