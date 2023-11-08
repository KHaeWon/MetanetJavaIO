import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex04_Reader_Writer_Buffer {

	public static void main(String[] args) {
		
		//큰빨대
		FileReader fr = null;
		BufferedReader br = null;
		try {
			
			fr = new FileReader("C:\\Temp\\Ex01_Stream.java"); //이걸 라인 단위로 읽을 것이다
			br = new BufferedReader(fr);
			//buffer는 line 단위의 처리가 가능 -> 장점
			String line = "";
			for(int i=0; (line = br.readLine()) !=null; i++) {
				//System.out.println(line);
				if(line.indexOf(";") != -1) {
					//indexOf -> 그 문자가 몇번째 인덱스에 있는지
					//line.indexOf(";") != -1 : 있으면!
					//;이 붙은 애들만 뽑음
					System.out.println(line);
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
