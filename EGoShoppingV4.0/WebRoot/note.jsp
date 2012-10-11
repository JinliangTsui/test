<%@page import="com.ego.service.NoteService"%>
<%@page import="com.ego.po.Note"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoteService nService = new NoteService();
	Note note = nService.getLatest();
	if (note.getTitle() != null) {
%>
<div class="right_content">
	<div class="title_box">公告栏</div>
	<div class="border_box">
		<div class="product_title">
			<div><%=note.getTitle()%></div>
		</div>
		<div class="prod_price">
			<span class="price"><%=note.getNoteContent()%></span>
		</div>
	</div>
</div>
<%
	} else {
%>
<div class="right_content">
	<div class="title_box">公告栏</div>
	<div class="border_box">
		<div class="product_title">
			<div>暂无</div>
		</div>
	</div>
</div>
<%
	}
%>