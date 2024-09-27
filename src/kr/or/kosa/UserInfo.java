package kr.or.kosa;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
직렬화 : 객체를 분해해서 보내는 과정
역직렬화 : 객체를 다시 조립하는 과정

모든 자원이 직렬화 가능하진 않음
직렬화 가능한 제품 설계

UserInfo implements Serializable

파일에 객체를 직렬화 write...
파일을 다시 read해서 역직렬화 
 */

@Data
@AllArgsConstructor
public class UserInfo implements Serializable{

	private String name;
	private String pwd;
	private int age;
	
}
