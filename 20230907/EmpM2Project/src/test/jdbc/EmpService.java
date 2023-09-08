package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Web Service 객체
 * -. Controller에서 요청한 서비스를 실제 구현하는 것.
 * -. 요청에 따라 DAO를 통해 DB의 결과를 받아오는 것.
 * -. 결과값에 따라 view에 보여줄 실제 문자열 데이터를 구현하는 것.
 * @author gaiasun
 *
 */
public class EmpService {
	private String result;
	private EmpDAO db;
	public String getResult() {
		return result;
	}
	public void setDb(EmpDAO db) {
		this.db = db;
	}
	public EmpService() {
		super();
		db = new EmpDAO();
	}
	public EmpService(EmpDAO db) {
		super();
		this.db = db;
	}
	public String insert(EmpDTO emp) throws SQLException, ClassNotFoundException {
		int result = db.insert(emp);
		//int 결과값에 따라 view에 보여줄 실제 문자열 데이터를 만들어 return.
		if(result >= 1){
			this.result = emp.getName() +" 직원등록이 완료되었습니다.";
		}else{
			this.result = emp.getName() + " 직원등록이 실패하였습니다.";
		}
		return this.result;
	}
	public int update(EmpDTO emp) throws SQLException {
		int result = db.update(emp);
		//int 결과값에 따라 view에 보여줄 실제 문자열 데이터를 만들어 return.
		return result;
	}
	public int delete(EmpDTO emp) throws SQLException {
		int result = db.delete(emp);
		//int 결과값에 따라 view에 보여줄 실제 문자열 데이터를 만들어 return.
		return result;
	}

	public EmpDTO select(EmpDTO emp) throws SQLException {
		EmpDTO result = db.select(emp);
		return result;
	}
	public ArrayList<EmpDTO> selectAll() throws SQLException {
		ArrayList<EmpDTO> result = db.selectAll();
		return result;
	}	
}
