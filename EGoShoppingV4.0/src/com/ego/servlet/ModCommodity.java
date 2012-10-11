package com.ego.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ego.po.Commodity;
import com.ego.service.CommodityService;
import com.ego.util.GenerateRandom;

public class ModCommodity extends HttpServlet {

	private CommodityService service = new CommodityService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = null;
		String msg = "";
		int commId = -1;
		String oldFileName = "";
		String destFileSavePath = "";
		FileItem item = null;
		Commodity comm = new Commodity();
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory dfiFactory = new DiskFileItemFactory();
				// 设置最多只允许在内存中存储的数据
				dfiFactory.setSizeThreshold(100 * 1024);
				// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
				dfiFactory.setRepository(new File("D:\\temp"));
				ServletFileUpload sfu = new ServletFileUpload(dfiFactory);

				String strRd = new GenerateRandom().generate();

				List<FileItem> list = sfu.parseRequest(request);
				for (FileItem fi : list) {
					if (!fi.isFormField()) {
						if (fi.getSize() != 0) {
							if (fi.getSize() > (4 * 1024 * 1024)) {
								msg = "文件大小不能超过4MB";
							} else {
								item = fi;
								// comm.setCommImg(new File(fi.getName())
								// .getName()); // 设置文件名称

								comm.setCommImg(strRd
										+ new File(fi.getName()).getName());
							}
						}
					} else {
						if (fi.getFieldName().equals("oldCommImg")) {
							oldFileName = fi.getString("utf-8");
						}
						if (fi.getFieldName().equals("commId")) {
							commId = Integer.parseInt(fi.getString("utf-8"));
							comm.setCommId(commId);
						}
						if (fi.getFieldName().equals("commName")) {
							comm.setCommName(fi.getString("utf-8"));
						}
						if (fi.getFieldName().equals("secCategoryId")) {
							comm.setSecCategoryId(Integer.parseInt(fi
									.getString("utf-8")));
						}
						if (fi.getFieldName().equals("price")) {
							comm.setPrice(new BigDecimal(fi.getString("utf-8")));
						}
						if (fi.getFieldName().equals("commDesc")) {
							comm.setCommDesc(fi.getString("utf-8"));
						}
						if (fi.getFieldName().equals("commAmount")) {
							comm.setCommAmount(Integer.parseInt(fi
									.getString("utf-8")));
						}
					}
				}

				// 将文件信息保存至数据库
				if (item != null) {
					// 将文件信息保存至数据库，并将文件写入服务器磁盘
					// 设置上传文件的目录
					destFileSavePath = getServletContext().getRealPath(
							getServletInfo())// 自动获取images目录在磁盘上的相对位置
							+ "\\images\\";
					String newFileName = strRd
							+ new File(item.getName()).getName();
					msg = service.modifyFile(destFileSavePath, item, comm,
							oldFileName, newFileName);
				} else {
					comm.setCommImg(oldFileName);
					if (service.modifyCommodityInfo(comm)) {
						msg = "修改成功";
					} else {
						msg = "修改失败";
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		request.setAttribute("message", msg);
		request.getRequestDispatcher(
				"modCommodity.jsp?commId=" + commId + "").forward(
				request, response);
	}
}
