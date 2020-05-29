package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.User;

import com.cos.blog.db.DBConn;
import com.cos.blog.model.Users;
//DAO라고 칭하던 클래스
public class UsersRepository {
    
	private static final String TAG = "UsersRepository : ";
	private static UsersRepository instance = new UsersRepository();
	public UsersRepository() {}
	public static UsersRepository getInstance() { 
		return instance;
	}
	
	
	private Connection conn = null; 
	private PreparedStatement psmt = null; 
	private ResultSet rs = null; 
	
	public int save(Users user) {
		final String SQL ="INSERT INTO users (id,username,password,email,address,userrole,createdate)VALUES(users_seq.nextval,?,?,?,?,?,sysdate)";
	     try {
	    		conn = DBConn.getConnection();
	    		psmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	    		psmt.setString(1, user.getUsername());
	    		psmt.setString(2, user.getPassword());
	    		psmt.setString(3, user.getEmail());
	    		psmt.setString(4, user.getAddress());
	    		psmt.setString(5, user.getUserRole());
	    		return psmt.executeUpdate();
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"save : "+e.getMessage());
		}finally {
			 DBConn.close(conn,psmt);
		   	 
		}
		return -1;
	}
   
	public int update(Users user) {
		final String SQL ="";
	     try {
	    		conn = DBConn.getConnection();
	    		psmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	    		
	    		return psmt.executeUpdate();
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"update : "+e.getMessage());
		}finally {
			 DBConn.close(conn,psmt);
		   	 
		}
		return -1;
	}
  
	public int deleteById(int id) {
		final String SQL ="";
	     try {
	    		conn = DBConn.getConnection();
	    		psmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	         
	    		return psmt.executeUpdate();
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"deleteById : "+e.getMessage());
		}finally {
			 DBConn.close(conn,psmt);
		   	 
		}
		return -1;
	}	
	public List<Users> findAll() {
		final String SQL ="";
	    List<Users> users = new ArrayList<>();
		try {
	    		conn = DBConn.getConnection();
	    		psmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	           
	    	   //while 돌려서 rs -> java 오브젝트 집어 넣기	
	    		
	    		return users;
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"findAll : "+e.getMessage());
		}finally {
			 DBConn.close(conn,psmt,rs);
		   	 
		}
		return null;
	}	
	public Users findById(int id) {
		final String SQL ="";
	    Users user = new Users();
		try {
	    		conn = DBConn.getConnection();
	    		psmt = conn.prepareStatement(SQL);
		       //물음표 완성하기
	           
	    	   // if 돌려서 rs -> java 오브젝트 집어 넣기
	    		
	    		return user;
	     } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(TAG+"findAll : "+e.getMessage());
		}finally {
			 DBConn.close(conn,psmt,rs);
		   	 
		}
		return null;
	}		
}
