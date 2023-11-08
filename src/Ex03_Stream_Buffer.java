import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
컴퓨터에서 가장 느린 작업 : Disk read / write
File 처리 > DISK > 입출력의 단위가 한 byte
다인승 버스, Buffer의 크기(8kb)만큼 다 태워서 움직일 수 있음, 단 꽉 차야 출발
	=> 30인승짜리 10명만 타도 보내야 하는 상황 : flush() 
접근 횟수를 줄일 수 있고 Line단위로 읽음

버스 (Buffer) 한번에 여러 명을 태워서 가자
- I/O 성능 개선(접근 횟수 줄임)
- Line 단위 처리가 가능함
	-> 엔터를 기반으로 한 처리

버퍼는 보조 스트림으로서 독자적 실행 불가
BufferedOutputStream -> 보조스트림, 독자적으로 객체 생성 불가 >> helper >> File Stream들을 도와줌

 */
public class Ex03_Stream_Buffer {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			//경로를 적지 않음 -> FileOutputStream은 디폴트 경로를 만듦 -> 소스폴더
			fos = new FileOutputStream("data.txt");
			//버퍼 생성
			bos = new BufferedOutputStream(fos);
			for(int i=0; i<10; i++) {
				bos.write('A'); //data.txt create 파일에 10번
			}
			//bos.flush(); 조각조각 내서 보낼 때 사용
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bos.close();
				fos.close();
				//close는 flush를 내장함
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
	}

}
