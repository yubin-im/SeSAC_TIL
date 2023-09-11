package kr.co.mycom.board.model;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public interface EmpDAO {
	
	public void insert(EmpDTO dto);
	public int update(EmpDTO dto);
	public int delete(EmpDTO dto);
	public EmpDTO select(EmpDTO dto);
	public List<EmpDTO> selectAll();
}
