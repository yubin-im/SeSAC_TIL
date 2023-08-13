package d230810_2;

import java.util.List;

public class SeriesContents extends Contents{
	protected List<String> episodesID;
	
	Media md = new Media();
	
	public SeriesContents() {
		super();
		super.setTypeList();
	}

	
	public void setSeriesContents(String contentID) {
		setDetailContents(contentID);
		System.out.println("제목: " + title);
		System.out.println("줄거리: " + summary);
		System.out.println("감독: " + direc);
		System.out.println("연도: " + year);
		System.out.println("출연: " + cast);
		System.out.println(type);
		System.out.println("0. 찜하기");
	}
	
	// 시리즈 컨텐츠 전체 목록 출력
	public void seriesContentsList() {
		System.out.println("시리즈 컨텐츠 목록!\n----------------------------------------");
		for (int i = 0; i < seriesTypeList.size(); i++) {
			String contentID = seriesTypeList.get(i);
			setSeriesContents(contentID);
			System.out.println();
			
			md.seriesMediaList(contentID);
			System.out.println("----------------------------------------");
		}

	}

	
}
