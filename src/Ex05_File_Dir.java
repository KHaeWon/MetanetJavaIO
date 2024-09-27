import java.io.File;

/*

 */
public class Ex05_File_Dir {

	public static void main(String[] args) {

		File f = new File("C:\\Temp");
		//File 클래스를 쓰는 이유 -> 다양한 정보를 얻기 위해서
		if(!f.exists() || !f.isDirectory()) {
			//존재하지 않거나 디렉토리가 아니면
			System.out.println("유효하지 않은 경로");
			
			//프로세스 강제 종료
			System.exit(0);
			
		}
		
		//실제 존재하는 경로이고 폴더라면
		//중요!!
		
		//[1.jpg][2.txt][file.txt][기러기][aa] >>각 배열의 타입은 File >> File[] list = new~
		File[] files = f.listFiles();//File타입의 배열형태로 받음
		for(int i=0;i<files.length;i++) {
			String name = files[i].getName(); //이 이름이 파일명일 수도, 폴더명일 수도 있음
			System.out.println(files[i].isDirectory() ? "[DIR]" + name : name);
			//디렉토리면 앞에 [DIR] 붙이고 아니면 이름만
		}
		
	}

}
