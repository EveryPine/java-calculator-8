# java-calculator-precourse

## 기능 구현 목록

1. 문자열을 입력받는다.
    - [Application] 사용자가 문자열을 입력한다.


2. 커스텀 구분자를 추출한다.
    - [DelimiterParser] 입력한 문자열에서 커스텀 구분자를 추출한다.


3. 입력한 문자열이 올바른 문자열인지 검증한다.
    - [inputValidator] 구분자 집합을 이용하여 올바른 문자열인지 검증한다.


4. 입력한 문자열에 대한 결과값을 계산한다.
    - [NumberParser] 입력한 문자열에서 숫자를 추출한다.
    - [CalculatorController] 각 숫자의 합(=결과값)을 계산한다.


5. 결과값을 출력한다.
    - [Application] 정해진 형식에 맞게 결과값을 출력한다.