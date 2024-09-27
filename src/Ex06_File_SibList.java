import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex06_File_SibList {

	static int totalfiles = 0;
	static int totaldir = 0;
	
	static void printFileList(File dir) {
		
		System.out.println("Full Path : "+dir.getAbsolutePath());
		//방번호만 저장해서 하위-> 하위 -> 하위 들어가려고
		List<Integer> subdir = new ArrayList<>();
		
		File[] files = dir.listFiles(); //하위 폴더와 파일 포함
		for(int i=0; i<files.length; i++) {
			String filename = files[i].getName();//getname : 폴더명, 파일명 모두 포함
			if(files[i].isDirectory()) {
				filename = "[DIR]" + filename;
				subdir.add(i);
			}else {
				filename = filename + "/" + files[i].length() + "byte";
			}
		}
		
		//폴더개수
		//파일개수
		int dirnum = subdir.size(); //size는 데이터의 개수만 조사하므로 length와는 다름, 주의!
		//현재 주어진 C:\Temp 하위에 있는 폴더 개수
		
		//files가 전체 개수
		int filenum = files.length - dirnum;
		//C:\Temp 하위에 있는 파일의 개수(경로는 내가 임의로 준 거니까 이렇게 설명 썼음. 정해진거 아님)
		
		//누적개수
		totaldir += dirnum;
		totalfiles += filenum;
		
		System.out.println("[Current Dirnum] : "+dirnum);
		System.out.println("[Current Filernum] : "+filenum);
		
		/*
		 point)) 내가 제시한 폴더가 다시 하위 폴더를 가지고 거기에 정보를 가지고 있지 않겠나
		 [0] > a.txt
		 [1] > aaa 폴더 > a-1 폴더 > a-2 폴더
		 [2] > bbb 폴더 > b-1 폴더, b.txt
		 */
		
		System.out.println("**************************");
		//List<Integer> subdir = new ArrayList<>();
		//[0] > 1
		//[1] > 2
		for(int i=0; i<subdir.size(); i++) {
			int index = subdir.get(i);
			printFileList(files[index]);
		}
		
	}
	
	public static void main(String[] args) {
		File f = new File("C:\\Temp");
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효한 디렉토리가 아닙니다.");
			System.exit(0);
		}
		//정상적인 경로이고 폴더임을 인정
		printFileList(f);
		
		System.out.println("누적 총 파일 수 : "+totalfiles);
		System.out.println("누적 총 폴더 수 : "+totaldir);
		
	}

}
