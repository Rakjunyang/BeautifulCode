# BeautifulCode
22년 8차 B조 팀프로젝트

#팀명 : Beautiful Code 

#의미 : 아름다운 코드를 만들자.

팀장 : 양락준
팀원 : 정병훈, 방지윤, 신승관

그라운드룰

	1. 서로 편하게 질문 할 수 있는 분위기 조성
	
	2. 의견 충돌시 다수결로 결정하되 2:2 인 경우 팀장에게 결정권 부여
	
	3. 출퇴근 시간 준수
	
	4. 서로 메신저로 출 퇴근 인사하기
	
	5. 코드리뷰는 최대한 빠르게 하기
	
	6. 변경된 코드 관련해서 참고할 만한 자료가 있을 경우 댓글로 적어주기
	
	7. 커밋은 코드 이해하기 쉽도록 짧게(100LOC 이내로)
	
	8. 팀원의 기분을 상하지 않게 긍정적인 단어로 리뷰하기
	
	9. 피드백은 빠르고 상세하고 친절하게.
	
	10. 다양한 의견 존중하기
	
	
코딩 스타일 
	
	1. Google Style 적용하여 활용한다. (intellij-javaj-google-style.xml)
	
		ctrl + alt + L 누르면 자동 반영
	
	2. Intent는 공백 4개로 한다.
	
	3. Naming Rule 은 아래와 같이 한다.
	
		- Class 명 : UpperCamelCase
		
		- TestClass 명 : Test 중인 Class 이름으로 시작하여 끝에 Test 를 붙여준다.
		
		- Interface 명 : UpperCamelCase
		
		- 함수 명 : lowerCamelCase
		
		- 상수 명 : 모두 대문자로 하며 밑줄 _ 로 각 단어를 구분한다.
		
		- 변수 명 : lowerCamelCase
		
		- 파라미터 명 : lowerCamelCase


리뷰 정책 

	1. 코드리뷰는 최대한 빠르게 하기 (3시간 이내)

	2. 변경된 코드 관련해서 참고할 만한 자료가 있을 경우 댓글로 적어주기

	3. 커밋은 코드 이해하기 쉽도록 짧게 (100LOC 이내로)

	4. 팀원의 기분을 상하지 않게 긍정적인 단어로 리뷰하기

	5. 피드백은 빠르고 상세하고 친절하게.

	6. PR은 3명 모두 승인 후 Merge 진행한다.

	7. PR 제목 앞에 어떤 종류의 수정인지 표시하기

		feature : 새로운 기능 추가

		fix : 버그 수정

		docs : 문서 수정

		test : 테스트 코드 추가

		refactor : 코드 리팩토링

		style : 코드 의미에 영향을 주지 않는 변경사항

		chore : 빌드 부분 혹은 패키지 매니저 수정사항

		예시 [fix] ~~ 버그 수정

branch 정책

	Main branch를 두고 개인별로 development branch 를 따서 수정을 진행하고 PR 을 통해 Main branch 에 merge 진행
	
	최종 제출시에는 Main branch 에서 Release branch 를 따서 제출 한다.
	
