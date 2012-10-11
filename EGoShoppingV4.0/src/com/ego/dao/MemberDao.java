package com.ego.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.Member;

public class MemberDao {

	DbFactory dbf = new DbFactory();

	// 获得所有用户
	public ArrayList<Member> getAll() {
		ArrayList<Member> al = new ArrayList<Member>();

		String sql = "select * from Member";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Member member = new Member();
				member.setMemUserName(rs.getString("memUserName"));
				member.setMemPassword(rs.getString("memPassword"));
				member.setMemName(rs.getString("memName"));
				member.setIdNumber(rs.getString("idNumber"));
				member.setTel(rs.getString("tel"));
				member.setEmail(rs.getString("email"));
				member.setConsumeTotal(rs.getBigDecimal("consumeTotal"));
				member.setBalance(rs.getBigDecimal("balance"));
				member.setState(rs.getString("state"));

				al.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}

	public BigDecimal getConsumeTotalByName(String memUserName) {
		BigDecimal consumeTotal = null;
		String sql = "select consumeTotal from Member where memUserName=?";
		Object[] params = { memUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				consumeTotal = rs.getBigDecimal("consumeTotal");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consumeTotal;
	}

	public Member getByUserName(String username) {
		Member mem = new Member();
		String sql = "select * from Member where memUserName=?";
		Object[] params = { username };
		ResultSet rs = dbf.execSqlWithRS(sql, params);

		try {
			while (rs.next()) {
				mem.setMemUserName(rs.getString("memUserName"));
				mem.setMemPassword(rs.getString("memPassword"));
				mem.setMemName(rs.getString("memName"));
				mem.setIdNumber(rs.getString("idNumber"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setConsumeTotal(rs.getBigDecimal("consumeTotal"));
				mem.setBalance(rs.getBigDecimal("balance"));
				mem.setState(rs.getString("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	// 用户注册，新增用户
	public void insert(Member member) {

		String sql = "insert into Member values(?,?,?,?,?,?,0,0,'1')";
		Object[] params = { member.getMemUserName(), member.getMemPassword(),
				member.getMemName(), member.getIdNumber(), member.getTel(),
				member.getEmail() };
		dbf.execSqlWithoutRS(sql, params);

	}

	// 删除用户
	public void delete(String memUserName) {

		String sql = "delete from Member where memUserName=?";
		Object[] params = { memUserName };
		dbf.execSqlWithoutRS(sql, params);
	}

	// 比较用户名，验证是否重复登录
	public boolean compareUsername(String username) {
		boolean flag = false;

		String sql = "select * from Member where memUserName=?";
		Object[] params = { username };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	// 按指定的页面和页面尺寸，查询出相应的数据集
	public ArrayList<Member> getByPage(int page, int pageSize) {
		ArrayList<Member> al = new ArrayList<Member>();
		try {
			// 分页显示SQL语句
			String sql = "select * from (SELECT * ,ROW_NUMBER() OVER (order by memUserName) as rowNum FROM Member) a "
					+ "where a.rowNum>? and a.rowNum<=?";
			Object[] params = { (page - 1) * pageSize, page * pageSize };
			ResultSet rs = dbf.execSqlWithRS(sql, params);
			while (rs.next()) {
				Member mem = new Member();
				mem.setMemUserName(rs.getString("memUserName"));
				mem.setMemPassword(rs.getString("memPassword"));
				mem.setMemName(rs.getString("memName"));
				mem.setIdNumber(rs.getString("idNumber"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setConsumeTotal(rs.getBigDecimal("consumeTotal"));
				mem.setBalance(rs.getBigDecimal("balance"));
				mem.setState(rs.getString("state"));

				al.add(mem);
			}
			dbf.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	// 计算当前数据库中的记录能够生成多少个页面
	public int getTotalPage(int pageSize) {
		int totalPage = 0;
		try {
			// 分页显示SQL语句
			String sql = "select count(*) from Member";
			Object[] params = {};
			ResultSet rs = dbf.execSqlWithRS(sql, params);
			rs.next();
			int count = rs.getInt(1);
			// 计算页面总数
			// 35 10 4
			// 30 10 3
			if (count % pageSize == 0) {
				totalPage = count / pageSize;
			} else {
				totalPage = count / pageSize + 1;
			}
			dbf.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalPage;
	}

	public boolean recharge(String memUserName, BigDecimal rechargeAmount) {
		boolean flag = false;
		String sql = "update Member set balance=balance+? where memUserName=?";
		Object[] params = { rechargeAmount, memUserName };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	// 冻结账户
	public void disableMember(String memUserName) {
		String sql = "update Member set state='0' where memUserName=?";
		Object[] params = { memUserName };
		dbf.execSqlWithoutRS(sql, params);
	}

	// 开放账户
	public void enableMember(String memUserName) {
		String sql = "update Member set state='1' where memUserName=?";
		Object[] params = { memUserName };
		dbf.execSqlWithoutRS(sql, params);
	}

	// 修改用户信息
	public void modifyMember(Member mem) {
		String sql = "update Member set memPassword=?,memName=?,idNumber=?,tel=?,email=? where memUserName=?";
		Object[] params = { mem.getMemPassword(), mem.getMemName(),
				mem.getIdNumber(), mem.getTel(), mem.getEmail(),
				mem.getMemUserName() };
		dbf.execSqlWithoutRS(sql, params);
	}

	public BigDecimal getBalanceByName(String memUserName) {
		BigDecimal bd = null;
		String sql = "select balance from Member where memUserName=?";
		Object[] params = { memUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				bd = rs.getBigDecimal("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bd;
	}
	
	public boolean reduceBalance(BigDecimal total, String memUserName) {
		boolean flag = false;
		String sql = "update Member set balance=balance-? where memUserName=?";
		Object[] params = {total,memUserName};
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
	
	public boolean addConsumeTotal(BigDecimal total, String memUserName) {
		boolean flag = false;
		String sql="update Member set consumeTotal=consumeTotal+? where memUserName=?";
		Object[] params={total,memUserName};
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

}
