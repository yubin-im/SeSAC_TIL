package d230810_2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Media {
	protected String mediaID;
	protected String mediaTitle;
	protected String mediaTime;
	protected String contentID;
	
	Map<String, String> inMediaM;
	List<String> mediaList;
	
	OTTArchive oa = new OTTArchive();
	Contents c = new Contents();
	
	
	public Media() {

	}
	
	
	public void setMedia(String mediaID) {
		inMediaM = new LinkedHashMap<>();
		inMediaM = oa.mediaM.get(mediaID);
		
		this.mediaTitle = inMediaM.get("title");
		this.mediaTime = inMediaM.get("time");
		this.contentID = inMediaM.get("cId");
	}
	
	// 영화 영상 목록 출력
	public void movieMediaList(String contentID) {
		mediaList = c.getMedias(contentID);
		
		for (int i = 0; i < mediaList.size(); i++) {
			mediaID = mediaList.get(i);
			setMedia(mediaID);
			
			System.out.println((i+1) + ".--------------");
			System.out.println("제목: " + mediaTitle);
			System.out.println("영상 시간: " + mediaTime);
		}
		System.out.println("--------------");
		System.out.println();	
			
	}
	
	// 시리즈 회차에 따른 영상 목록 출력
	public void seriesMediaList(String contentID) {
		mediaList = c.getMedias(contentID);
		
		for (int i = 0; i < mediaList.size(); i++) {
			mediaID = mediaList.get(i);
			setMedia(mediaID);
			
			System.out.println((i+1) + ".--------------");
			System.out.println((i+1) + "회 영상");
			System.out.println("시리즈 제목: " + mediaTitle);
			System.out.println("영상 시간: " + mediaTime);
		}
		System.out.println("--------------");
		System.out.println();	
		
	}
		

}
