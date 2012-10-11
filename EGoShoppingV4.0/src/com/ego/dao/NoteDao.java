package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.Note;

public class NoteDao {
	DbFactory dbf = new DbFactory();

	public ArrayList<Note> getAll() {
		ArrayList<Note> al = new ArrayList<Note>();
		String sql = "select * from Note order by noteId desc";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Note noteInfo = new Note();
				noteInfo.setNoteId(rs.getInt("noteId"));
				noteInfo.setTitle(rs.getString("title"));
				noteInfo.setNoteContent(rs.getString("noteContent"));

				al.add(noteInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public Note getLatest() {
		Note noteInfo = new Note();
		String sql = "select top 1 * from Note order by noteId desc";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				noteInfo.setNoteId(rs.getInt("noteId"));
				noteInfo.setTitle(rs.getString("title"));
				noteInfo.setNoteContent(rs.getString("noteContent"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noteInfo;
	}

	public boolean insert(Note noteInfo) {
		boolean flag = false;
		String sql = "insert into Note values(?,?)";
		Object[] params = { noteInfo.getTitle(), noteInfo.getNoteContent() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public boolean modify(Note noteInfo) {
		boolean flag = false;
		String sql = "update Note set noteId=?,title=?,noteContent=?";
		Object[] params = { noteInfo.getNoteId(), noteInfo.getTitle(),
				noteInfo.getNoteContent() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public boolean delete(int noteId) {
		boolean flag = false;
		String sql = "delete from Note where noteId=?";
		Object[] params = { noteId };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
}
