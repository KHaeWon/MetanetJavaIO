import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.kosa.UserInfo;

//역직렬화
public class Ex09_ObjectDataInputStream {

	public static void main(String[] args) {

		String filename = "UserData.txt";
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		
		try {
			//복원
			//파일에 쓰여진 직렬화된 자원을 다시 복원 : 역직렬화
			
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis); //한줄의 코드가 역직렬화
			
			//UserInfo r1 = in.readObject(); //에러 -> Object타입으로 리턴하므로 다운캐스팅
			//무식한 방법이래요
//			UserInfo r1 = (UserInfo)in.readObject();
//			System.out.println(r1.toString());
//			
//			UserInfo r2 = (UserInfo)in.readObject();
//			System.out.println(r2.toString());
			
			//몇 개의 객체가 있는지 모르겠다.
			Object users = null;
			while((users = in.readObject()) != null) {
				System.out.println(((UserInfo)users).toString());
			}
			
		}
		//정형화된 코드
		catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않아요");
		}catch (EOFException e) {
			System.out.println("끝 " + e.getMessage());
		}catch (IOException e) {
			System.out.println("파일을 읽을 수 없어요");
		}catch (ClassNotFoundException e) {
			System.out.println("해당 객체가 존재하지 않아요");
		}catch (Exception e) {
			System.out.println("나머지 예외");
		} finally {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
