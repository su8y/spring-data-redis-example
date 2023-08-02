## Redis

## String
* get
* set 
* del

## set
* `NX & XX`  
NX 는 키가 없을때
XX 는 키가 있을때만 업데이트한다. 
* `EX second`   
EX 는 초단위로 expire시간을 설정 
* `INCR, DECR`  
해당하는 키 값의 Value를 1씩 증감한다.
* `INCRBY, DECRBY, INCRBYFLOAT`   
해당하는 키 값의 value를 *원하는값*만큼 증감한다.
* `APPEND`    
value 뒤에 값을 추가한다.
* `GETRANGE, SETRANGE`    
String 연산의 `substring`, `replace`와 똑같다.
* 