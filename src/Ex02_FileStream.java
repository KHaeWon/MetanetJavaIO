import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//중요!
/*
Point

Byte 데이터를 read / write 할건데, 그 대상이 File(예를 들면 a.txt)

FileInputStream
FileOutputStream

언제 쓰일까? 자료실 만들 때.(이미지, 엑셀) read, write

File > 1.txt, log.png, 1.data

I/O 자원은 개발자가 직접적으로 자원 해제
(워드 파일이 작업중이라면, 즉 열려있으면 다른 사람이 그 파일을 read 또는 write 할 수 있게 하겠다
=> 기존의 것을 닫아야 한다. 그게 close 함수)
close() : 자원 해제

I/O는 예외처리가 강제되어 있다 (try ~ catch)

 */

public class Ex02_FileStream {

	public static void main(String[] args) {

		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		String path = "C:\\Temp\\a.txt";
		
		try {
			
			fs = new FileInputStream(path);
			//fos = new FileOutputStream("C:\\Temp\\new.txt");
			fos = new FileOutputStream("C:\\Temp\\new.txt",true);
			// 현재 new.txt 파일은 없음
			
			/*
			File 클래스 -> 파일 생성 후 write 하는 것이 맞음
			
			FileOutputStream
			1. write할 파일이 존재하지 않으면 File create
			
			2. fos = new FileOutputStream("C:\\Temp\\new.txt", fasle);
				fasle >> overwrite, 덮어쓰기
				
			3. fos = new FileOutputStream("C:\\Temp\\new.txt", true);
				true >> append, 기존 파일이 있다면 밑에 덧붙이기
			
			 */
			
			int data = 0;
			while((data = fs.read()) != -1) {
				fos.write(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//정상, 비정상 모두 무조건 강제 실행
			//함수 return 종료해도 finally 실행
			
			try {
				fs.close();
				fos.close();
				//닫는 순서는 연 순서대로
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
