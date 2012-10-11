package com.ego.service;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.fileupload.FileItem;

import com.ego.dao.CommodityDao;
import com.ego.po.Commodity;

public class CommodityService {

	CommodityDao dao = new CommodityDao();

	public ArrayList<Commodity> getAll() {
		return dao.getAll();
	}
	
	public ArrayList<Commodity> getTopSix() {
		return dao.getTopSix();
	}

	public ArrayList<Commodity> getAllBySecCtyId(int secCtyId) {
		return dao.getAllBySecCtyId(secCtyId);	
	}

	public Commodity getById(int commId) {
		return dao.getById(commId);
	}

	public String saveFile(String svrPath, FileItem item, Commodity comm) {
		String message = "";
		if (saveFileToDisk(svrPath, item))
			message = "文件保存到磁盘成功！";
		else
			message = "文件保存到磁盘失败！";

		if (saveFileInfoToDB(comm))
			message += "文件信息保存到数据库成功！";
		else
			message += "文件信息保存到数据库失败！";

		return message;
	}

	public boolean saveFileInfoToDB(Commodity comm) {
		return dao.insert(comm);
	}

	public boolean saveFileToDisk(String path, FileItem item) {
		boolean flag = false;
		try {
			item.write(new File(path));
			item.delete();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public String deleteFile(String svrPath, int commId) {
		String message = "";
		try {
			String filePath = svrPath + dao.getById(commId).getCommImg();
			if (deleteFileFromDisk(filePath))
				message = "文件从磁盘删除成功！";
			else
				message = "文件从磁盘删除失败！";
			if (deleteFileInfoFromDB(commId))
				message += "文件信息从数据库删除成功！";
			else
				message += "文件信息从数据库删除失败！";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public boolean deleteFileFromDisk(String path) {
		boolean flag = false;
		try {
			File f = new File(path);
			if (f.delete())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteFileInfoFromDB(int commId) {
		return dao.delete(commId);
	}

	public String modifyFile(String svrPath, FileItem item, Commodity comm,
			String oldFileName, String newFileName) {
		String message = "";
		try {
			String filePath = svrPath + oldFileName;
			if (deleteFileFromDisk(filePath))
				message = "文件从磁盘删除成功！";
			else
				message = "文件从磁盘删除失败！";
			if (saveFileToDisk(svrPath + newFileName, item))
				message += "文件保存到磁盘成功！";
			else
				message += "文件保存到磁盘失败！";

			if (modifyCommodityInfo(comm))
				message += "修改数据库成功！";
			else
				message += "修改数据库失败！";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	public boolean modifyCommodityInfo(Commodity comm) {
		return dao.modify(comm);
	}
	
	public boolean addSaledAmount(int commId, int number) {
		return dao.addSaledAmount(commId, number);
	}
	
	public Commodity getTopOne() {
		return dao.getTopOne();
	}
	
	public boolean reduceCommAmount(int commId, int number) {
		return dao.reduceCommAmount(commId, number);
	}
	
	public int getCommAmount(int commId) {
		return dao.getCommAmount(commId);
	}

}
