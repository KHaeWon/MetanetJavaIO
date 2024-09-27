import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import kr.or.kosa.UserInfo;

//파일을 대상으로 객체를 write
//스트림의 통로가 한정되어 있어서 객체를 write하는 것은 사실 불가능함


//직렬화된 코드는 역직렬화 하지 않으면 읽을 수 없음. 바이트코드이기 때문 >> UserData.txt 참조
public class Ex08_ObjectDataOutPutStream {
 
	public static void main(String[] args) {
		
		String filename = "UserData.txt";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null; //직렬화를 제공하는 객체 //ObjectOutputStream : 객체 저장 //ObjectInputStream : 저장해놓은 객체 읽기
		
		try {
			
			fos = new FileOutputStream(filename);//outputstream -> 파일 create 기능 내장
			bos = new BufferedOutputStream(fos);
			//직렬화
			out = new ObjectOutputStream(bos);
			
			//객체 생성(광수의 탱크)
			UserInfo u1 = new UserInfo("홍길동", "super", 100); //완제품
			UserInfo u2 = new UserInfo("scott", "tiger", 50); //완제품
			
			//탱크 밀어넣기
			out.writeObject(u1);//u1객체를 줄을 세워서 write >>  "UserData.txt"에다가
			out.writeObject(u2);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {//닫는 순서는 거꾸로
				out.close();
				bos.close();
				fos.close();
				System.out.println("파일 생성 -> buffer -> 직렬화 -> 파일 write");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
