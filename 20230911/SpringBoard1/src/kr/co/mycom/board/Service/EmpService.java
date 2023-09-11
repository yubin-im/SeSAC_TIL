package kr.co.mycom.board.Service;

import java.util.List;

import kr.co.mycom.board.model.EmpDTO;

public interface EmpService{
	public void insert(EmpDTO dto);
	public int update(EmpDTO dto);
	public int delete(EmpDTO dto);
	public EmpDTO select(EmpDTO dto);
	public List<EmpDTO> selectAll();
}
