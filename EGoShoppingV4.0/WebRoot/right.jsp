<%@page import="com.ego.vo.SecondCategoryVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.service.SecondCategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	SecondCategoryService right_scService = new SecondCategoryService();
	ArrayList<SecondCategoryVO> right_al = right_scService.getAll();
%>
<div class="right_content">

	<div class="title_box">品牌</div>

	<ul class="left_menu">
		<%
			for (int right_i = 0; right_i < right_al.size(); right_i++) {
				SecondCategoryVO right_scVO = right_al.get(right_i);
				if (right_i % 2 == 0) {
		%>
		<li class="odd"><a href="searchByCategory?secCtyId=<%=right_scVO.getSecCategoryId()%>&isSec=1"><%=right_scVO.getSecCategoryDesc()%></a></li>
		<%
			} else {
		%>
		<li class="even"><a href="searchByCategory?secCtyId=<%=right_scVO.getSecCategoryId()%>&isSec=1"><%=right_scVO.getSecCategoryDesc()%></a></li>
		<%
			}
			}
		%>
	</ul>

</div>