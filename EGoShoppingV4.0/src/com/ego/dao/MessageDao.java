package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.Message;

public class MessageDao {
	DbFactory dbf = new DbFactory();

	public boolean insert(Message msg) {
		boolean flag = false;
		String sql = "insert into Message values(?,'default',?,?,'','')";
		Object[] params = { msg.getMemUserName(), msg.getMsgTime(),
				msg.getMsgContent() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public ArrayList<Message> getAll(String memUserName) {
		ArrayList<Message> al = new ArrayList<Message>();
		String sql = "select * from Message where memUserName=? order by msgId desc";
		Object[] params = { memUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Message msg = new Message();
				msg.setMsgId(rs.getInt("msgId"));
				msg.setMemUserName(rs.getString("memUserName"));
				msg.setAdUserName(rs.getString("adUserName"));
				msg.setMsgTime(rs.getString("msgTime"));
				msg.setMsgContent(rs.getString("msgContent"));
				msg.setReTime(rs.getString("reTime"));
				msg.setReContent(rs.getString("reContent"));

				al.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public ArrayList<Message> getAll() {
		ArrayList<Message> al = new ArrayList<Message>();
		String sql = "select * from Message where reTime='' order by msgId ";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Message msg = new Message();
				msg.setMsgId(rs.getInt("msgId"));
				msg.setMemUserName(rs.getString("memUserName"));
				msg.setAdUserName(rs.getString("adUserName"));
				msg.setMsgTime(rs.getString("msgTime"));
				msg.setMsgContent(rs.getString("msgContent"));
				msg.setReTime(rs.getString("reTime"));
				msg.setReContent(rs.getString("reContent"));

				al.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public Message getById(int msgId) {
		Message msg = new Message();
		String sql = "select * from Message where msgId=?";
		Object[] params = { msgId };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				msg.setMsgId(rs.getInt("msgId"));
				msg.setMemUserName(rs.getString("memUserName"));
				msg.setMsgContent(rs.getString("msgContent"));
				msg.setMsgTime(rs.getString("msgTime"));
				msg.setAdUserName(rs.getString("adUserName"));
				msg.setReContent(rs.getString("reContent"));
				msg.setReTime(rs.getString("reTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public boolean reMessage(Message msg) {
		boolean flag = false;
		String sql = "update Message set adUserName=?,reTime=?,reContent=? where msgId=?";
		Object[] params = { msg.getAdUserName(), msg.getReTime(),
				msg.getReContent(), msg.getMsgId() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public boolean delete(int msgId) {
		boolean flag = false;
		String sql = "delete from Message where msgId=?";
		Object[] params = { msgId };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
}
