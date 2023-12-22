package com.kh.common;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

//인터페이스를 구현해야함
public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		// 기존의 파일을 매개변수로 전달받아서(originFile) 파일명 수정작업 후에 수정된 파일을 반환해주는 메소드
		
		// 원본파일명(aaa.jpg)
		String originName = originFile.getName();
		
		//수정파일명 : 파일업로드된 시간(년월일시분초)+5자리 랜덤값 => 최대한 안겹치게 함
		//확장자 : 원본파일의 확장자 그대로 사용
		
		//aaa.jpg ----> 2023121114374512345.jpg
		//1.파일업로드된 시간(년월일시분초)
		String currentTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		
		// 2. 5wkfl fosejarkqt => int ranNum;
		int ranNum = (int)((Math.random()*90000)+10000); //10000~99999
		
		// 3. 원본파일 확장자 알아오기 (String ext)
		String ext = originName.substring(originName.lastIndexOf("."));//.jpg
		
		String changeName = currentTime + ranNum +ext;
		
		//원본파일을 수정된 파일명으로 적용시켜서 파일객체로 변환
		return new File(originFile.getParent(), changeName);
	}
	
}
