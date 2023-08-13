package d230810_2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Contents {
	protected String contentID;
	protected String title;
	protected String direc;
	protected String summary;
	protected String cast;
	protected String year;
	protected int views;
	protected String type;
	protected List<String> medias;
	
	Map<String, Object> inContentM;
	List<String> movieTypeList;
	List<String> seriesTypeList;
	
	OTTArchive oa = new OTTArchive();
	
	
	public Contents() {

	}
	
	
	public void setDetailContents(String contentID) {
		inContentM = new LinkedHashMap<>();
		inContentM = oa.contentM.get(contentID);
		
		this.title = (String) inContentM.get("title");
		this.direc = (String) inContentM.get("direc");
		this.year = (String) inContentM.get("year");
		this.summary = (String) inContentM.get("summary");
		this.cast = (String) inContentM.get("cast");
		this.views = (int) inContentM.get("views");
		this.type = (String) inContentM.get("type");
		this.medias = (List<String>) inContentM.get("medias");	
	}
	
	
	// 영화, 시리즈 타입의 컨텐츠 ID 리스트 받기
	public void setTypeList() {
		movieTypeList = new ArrayList<String>();
		seriesTypeList = new ArrayList<String>();
		
		for (String id: oa.contentM.keySet()) {
			inContentM = oa.contentM.get(id);
			String type = (String) inContentM.get("type");
			
			if (type.equals("영화")) {
				movieTypeList.add(id);
			} else if (type.equals("시리즈")) {
				seriesTypeList.add(id);
			}
		}
	}

	
	// 영상 아이디 리스트 반환
	public List<String> getMedias(String contentID) {
		setDetailContents(contentID);
		return medias;
	}
	
}




