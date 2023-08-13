package d230810_2;

public class MovieContents extends Contents{
	protected String mainID;
	protected String trailerID;
	
	Media md = new Media();
	
	
	public MovieContents() {
		super();
		super.setTypeList();
	}
	
	
	public void setMovieContents(String contentID) {
		setDetailContents(contentID);
		System.out.println("제목: " + title);
		System.out.println("줄거리: " + summary);
		System.out.println("감독: " + direc);
		System.out.println("연도: " + year);
		System.out.println("출연: " + cast);
		System.out.println(type);
		System.out.println("0. 찜하기");
	}
	
	// 영화 컨텐츠 목록 전체 출력
	public void movieContentsList() {
		System.out.println("영화 컨텐츠 목록!\n----------------------------------------");
		for (int i = 0; i < movieTypeList.size(); i++) {
			String contentID = movieTypeList.get(i);
			setMovieContents(contentID);
			System.out.println();
			
			md.movieMediaList(contentID);
			System.out.println("----------------------------------------");
		}
		
	}
	

}
