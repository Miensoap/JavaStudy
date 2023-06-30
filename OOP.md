# 객체지향언어

### 특징
- 코드의 재사용성이 높다.
- 코드의 관리가 용이하다.
- 신뢰성이 높은 프로그래밍을 가능하게 한다.
  -제어자와 메서드를 이용해서 데이터를 보호하고 올바른 값을 유지
  -코드의 중복을 제거하여 오동작 방지

### 클래스 = 객체를 정의해 놓은 것. 설계도
- 객체를 생성하는데 사용

### 객체=실제로 존재하는 것. 사물 또는 개념
- 객체가 가지고 있는 기능과 속성에 따른 용도

### 객체 = 속성(변수) + 기능(메서드)
- 실제 하드웨어를 소프트웨어화 하기 위함

### 클래스 작성
```
class Tv{
	String color; //색깔
	boolean power; //전원상태
	int channel; //채널

	void power() {power= !power;}
	void channelUp() {channel++;}
	void channelDown() {channel--;}
}
```
- 하나의 소스파일에 둘 이상의 클래스를 작성할 수 있으나, 하나만 작성하는 것이 바람직하다.
- 소스파일에 public class가 있는 경우, 소스 파일의 이름은 pulic class의 이름과 일치해야한다.
- 없는 경우, 클래스의 이름 중 하나여야 한다.
- 하나의 소스파일에 둘 이상의 public class가 존재해선 안된다.

### 인스턴스 = 특정 크래스로부터 생성된 객체
- ex) TV 인스턴스

### 객체의 생성
```
	클래스명 변수명; // 클래스의 객체를 참조하기 위한 참조형 변수를 선언
	변수명 = new 클래스명(); // 클래스의 객체를 생성 후, 객체의 '주소'를 참조변수에 저장

	Tv t; // 객체를 다루러면 참조변수가 필요하다 : 리모컨
	t = new TV(); // 

	Tv t = new Tv();
```
### 객체의 사용 : 객체가 가진 변수와 메서드를 사용한다
```
	t.channel=7; // Tv인스턴스의 멤버변수 channel에 7을 저장
	t.channelDown(); // Tv인스턴스의 메서드 channelDown()을 호출
	System.out.println("현재 채널은 "+ t.channel +"입니다.");
```
```
	Tv t1 = new TV();
	Tv t2 = new TV();
	t1.chnnel = 7;
	
	t2=t1; // t2에 t1에 저장된 Tv인스턴스1의 주소 를 저장. 
	// 더이상 Tv인스턴스2는 사용불가. ->Garbage Collector가 메모리 정리
```

### 객체 배열 = 참조변수 배열
```
	Tv tv1, tv2, tv3;
	Tv tvArr = new Tv[3]; //길이가 3인 Tv타입의 참조변수 배열

	Tv[] tvArr = {new Tv(), new Tv(), new Tv()};
	// 객체를 채워 넣어야한다.
```

### 클래스 = 데이터 + 함수
- 변수 - 배열 - 구조체 - 클래스
- 사용자 정의 타입
```
class Time{
	int hour;
	int minute;
	int second;
}
```

### 선언 위치에 따른 변수의 종류
```
class Variables{
	int iv; // 인스턴스 변수 - 클래스영역
	static int cv; // 클래스 변수(static 변수, 공유변수)

	void method()
	{
		int lv=0; //지역변수 - 메서드영역
	}
}
```
- 클래스 영역 : iv, cv / 선언문만 가능
- 메서드 영역 : lv
- 클래스 변수 : 클래스가 메모리에 올라갈 때 자동 생성
- 인스턴스 변수 : 인스턴스가 생성되었을 때 생성 ->객체는 iv를 묶어놓은것.
- 지역 변수 : 범위(scope)내에서 유효, 변수 선언문이 수행되었을 때 생성, 메서드 종료시 자동 제거

### 클래스 변수와 인스턴스 변수
```
class Card{
	//iv
	String kind; //무늬
	int number; //숫자
	//cv : 공통
	static int width = 100; //폭
	static int height = 250; //높이
}

	Card c = new Card();
	c.kind ="heart";
	c.number = 5;

	Card.width = 200; // cv는 클래스 이름으로 사용.
	Card.height = 300; //참조변수로도 사용할 수 있지만 권장하지 않음.
```
- iv는 객체마다 만들어지나,  cv는 다른 공간에 하나만 존재.

### 메서드 = 선언부 + 구현부
- 문장들을 작업단위로 이름붙여 묶어놓은 것.
- 하나의 메서드는 하나의 기능만 수행하도록 작성하는 것이 좋다.
- 값(입력)을 받아 처리하고, 결과를 반환(출력)
```
//반환타입 메서드이름(매개변수선언) = 선언부
int add(int x, int y){  
	int result = x+y; // 구현부
	return result; // 결과반환
}

void : 반환할 것이 없다
```
- 코드의 중복 제거, 관리 용이, 재사용 가능
- 서로 다른 메서드 내 지역변수는 이름이 같아도 겹치지 않는다.

### 메서드 호출
```
메서드명(값1, 값2, ...);
print99danAll(); // void print99danAll()을 호출
int result = add(3,5); // int add(int x, int y)를 호출하고, 결과를 result에 저장

// 1. main 메서드에서 메서드 add를 호출, 인수가 매개변수에 저장(대입) 
// 2. 메서드 add의 {}안의 문장들이 순서대로 수행
// 3. 메서드 add의 모든 문장이 실행되거나 return문을 만나면, 호출한 메서드로 되돌아와 실행
```
- 인수(argument, 원본)
- 매개변수(parameter, 복사본)
- 반환타입이 있는 경우, 사용하기 위해 작업결과를 저장할 변수가 필요.


