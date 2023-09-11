package kr.co.mycom.board.model;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class EmpDAOImpl implements EmpDAO {
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	public void insert(EmpDTO dto){
		sqlMapClientTemplate.insert("insertEmp", dto);
	}
	public int update(EmpDTO dto){
		return sqlMapClientTemplate.update("updateEmp",dto);
	}
	public int delete(EmpDTO dto){
		return sqlMapClientTemplate.delete("deleteEmp",dto);
	}

	public EmpDTO select(EmpDTO dto){
		try {
			dto = (EmpDTO)sqlMapClientTemplate.queryForObject("getEmp", dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(dto);
		return dto;
	}
	public List<EmpDTO> selectAll(){
		return sqlMapClientTemplate.queryForList("getEmpList");
	}
	
}
