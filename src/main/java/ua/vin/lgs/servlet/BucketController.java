package ua.vin.lgs.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.vin.lgs.domain.Bucket;
import ua.vin.lgs.service.BucketService;
import ua.vin.lgs.service.impl.BucketServiceImpl;


@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private BucketService bucketService = BucketServiceImpl.getBucketServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
		bucketService.create(bucket);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");		
	}
}
