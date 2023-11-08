import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
/*
IO(input / output)

Stream(통로)
데이터 종류 : 이미지 , 파일  <> 문자

JAVA API >> 클래스 제공 받아요
I/O 기본 단위는 Byte

추상 클래스 
InputStream , OutPutStream (추상함수 .... 재정의)

당신이 Byte 데이터 작업 
입력 InputStream 상속 구현하는 클래스 사용해라 

대상이
1. Memory : ByteArrayInputStream
2. File   : FileInputStream   (**)

당신이 Byte 데이터 작업 
출력 OutputStream 상속 구현하는 클래스 사용해라 

대상이
1. Memory : ByteArrayOutPutStream
2. File   : FileOutPutStream  (**)

사실 지금까지 memory  Array , Collection 통해서 메모리기반 작업 ....
*/
public class Ex01_Stream {

	public static void main(String[] args) {

		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		//byte는 -128~127까지의 정수를 저장할 수 있는 타입
		byte[] outSrc = null; //현재 메모리를 가지고 있지 않음
		
		//중간 매개체(stream)을 통해서 memory에 있는 데이터를 read 또는 write를 할 수 있다.
		
		//입력
		ByteArrayInputStream input = null; 	 //입력 전용 빨대 만들기
		//출력
		ByteArrayOutputStream output = null; //출력 전용 빨대 만들기
		
		input = new ByteArrayInputStream(inSrc); //빨대를 꽂은 대상 : inSrc -> read할 준비
		output = new ByteArrayOutputStream(); //아직 대상을 잡지 않음
		
		System.out.println("outSrc before : "+Arrays.toString(outSrc));
		
		// 공식같은 로직(암기)
		int data = 0;
		while((data = input.read()) != -1) {
			//System.out.println(data); //0 1 2 3 4 5 6 7 8 9
			
			//read한 데이터를 출력(다른 stream)
			output.write(data);//읽은 데이터를 write
			//내가 write를 하는 대상이 data가 아니고 ByteArrayOutputStream 자신의 통로에 write함, 내부적으로 배열을 가지고 있음
			//data를 output에 write, 자기 빨대에 담고 있다
			
		}
		
		outSrc = output.toByteArray();
		//자기가 담고 있는 데이터를 배열로 만들어서 리턴
		//toByteArray -> heap에 생성된 주소값을 리턴
		System.out.println("outSrc after : "+Arrays.toString(outSrc));
		//outSrc after : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		
		//이렇게 하면?
//		while((input.read()) != -1) {
//			System.out.println(input.read());
//		} 
		//1 3 5 7 9
		//read()가 내부적으로 옆으로 이동시킴 -> next기능을 가지고 있다
		//input.read() >> next
		//read를 쓸 때마다 옆으로 가서 1번만 써야 됨
		
		
	}

}
