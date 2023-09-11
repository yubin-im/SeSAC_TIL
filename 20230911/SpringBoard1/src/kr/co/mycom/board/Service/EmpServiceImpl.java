package kr.co.mycom.board.Service;

import java.util.List;

import kr.co.mycom.board.model.EmpDAO;
import kr.co.mycom.board.model.EmpDTO;

public class EmpServiceImpl implements EmpService{
	private EmpDAO dao;
	public void setEmpDAO(EmpDAO dao) {
		this.dao = dao;
	}
	public void insert(EmpDTO dto){
		dao.insert(dto);
	}
	public int update(EmpDTO dto){
		return dao.update(dto);
	}
	public int delete(EmpDTO dto){
		int result = dao.delete(dto);
		return result;
	}

	public EmpDTO select(EmpDTO dto){
		return dao.select(dto);
	}
	public List<EmpDTO> selectAll(){
		List<EmpDTO> result = dao.selectAll();
		return result;
	}	
}
