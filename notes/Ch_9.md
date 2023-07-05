## Object 클래스
-  모든 클래스의 최고 조상. 11개의 메서드를 가지고있다.

### protected Object clone()
- 객체 자신의 복사본 반환
### boolean equals(Object obj)
- 객체 자신과 obj가 같은 객체인지 반환
- 객체의 주소를 비교 -> 값을 비교하도록 오버라이딩

### protected void finalize
- 거의 사용 x
### Class getClass()
- 객체 자신의 클래스정보를 담고 있는 Class 인스턴스를 반환

### int hashCode()
- 객체 자신의 해시코드 반환
- 객체의 주소를 int로 변환해서 반환
- equals()의 결과가  true인 두 객체의 해시코드는 같아야함 -> 오버라이딩

### String toString()
- 객체 자신의 정보를 문자열로 반환
- getClass().getName()+"@"+Integer.toHexString(hashCode()); 반환
- iv 값을 반환하도록 오버라이딩

### void notifiy()
- 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다
### void nofiryAll()
- 모두 깨운다
### void wait()
- notify 호출시까지 무한히 또는 지정된 시간동안 기다리게한다
-  wait(long timeout)
- wait(long timeout, int nanos)

---

## String 클래스
- String클래스 = 데이터(char[ ])+메서드

- 내용을 변경할 수 없는 immutable 클래스
- 덧셈 연산자를 이용한 문자열 결합은 새 객체 생성. 성능이 떨어짐.
- 변경가능한 StringBuffer 클래스 사용

### 문자열의 비교
- 등가비교연산자 : 주소비교
- str.equals : 내용비교 (오버라이딩)

### 문자열 리터럴
- 프로그램 실행 시 자동으로 생성되어 constant pool 에 저장
- 같은 내용의 문자열 리터럴은 하나만 생성. 여러 참조변수가 공유.
- 코드 작성시 같은 내용이면 새 객체 생성 x 리터럴로 작성

### 빈 문자열("")
- 크기가 0인 char형 배열을 저장.

### String 생성자
- String(String S)
- String(char[] value)
- String(StringBuffer buf) : StringBuffer 인스턴스와 같은 내용의 String 인스턴스 생성

### String 메서드

- char charAt(int index) : 지정된 위치에 있는 문자 반환
- int compareTo(Stirng str) : str와 사전순서비교. 같으면 0, 이전이면 음수, 이후면 양수반환
- String concat(String str) : str을 뒤에 덧붙인다

- boolean contains(CharSequence s) : 문자열 s가 포함되었는지 검사
    - CharSequence : 인터페이스. 문자열을 다루는 클래스들을 관계맺어줌.

- boolean startsWith(String prefix) : 지정된 문자열로 시작하는지 검사
- boolean endsWith(String suffix) : 지정된 문자열로 끝나는지 검사

- boolean equals(Object obj) : 매개변수로 받은 문자열과 비교.
- boolean equalsIgnoreCase : 대소문자 구분없이 비교.

- int indexOf(int ch) : 주어진 문자의 위치 반환. 없으면 -1반환. 0부터찾음.
    - (int ch, int pos) : 지정된 위치부터 확인
    - (String str)
- int lastIndexOf(int ch) : 뒤에서부터찾음
    - (String str)
- int length() : 문자열의 길이 반환

- String[] split(String regex) : 지정된 분리자로 나누어 배열에 담아 반환
    - (String regex, int limit) : 분리자로 나누되, 지정된 수로 자름.

- String substring(int begin) : 시작위치부터 끝위치의 문자열 반환. (끝위치는 포함x)
    - (int begin, int end)
- String trim() : 양끝의 공백을 없앤 결과 반환

- String toLowerCase() : 소문자로
- String toUpperCase() : 대문자로

- static String valueOf(boolean b) : 지정된 값을 문자열로 변환하여 반환.
    - (char), (int), (long), ...
    - 참조변수의 경우, toString()을 호출

### join( )
- 여러 문자열 사이에 구분자를 넣어 결합
```
String animals= "dog,cat,bear";
String[] arr = animals.split(",");
String str = String.join("-",arr);
System.out.println(str); // dog-cat-bear
```

### 문자열과 기본형 간의 변환



