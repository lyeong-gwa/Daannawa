# Daannawa
컴퓨터를 전혀 알지 못하는 사람들도 손쉽게 자신이 원하는 컴퓨터를 맞출 수 있게 도와주는 앱

---
‼ private repository에서 작업한 후 완성된 최종본입니다. API Key 관리를 따로 하지 않아 부득이하게 따로 repository를 생성하게 되었습니다. 
팀원 repository에서 새롭게 불러왔습니다.😥
---

![image](https://user-images.githubusercontent.com/77712564/158940200-27275bf6-8c80-4698-9af5-2294adbcbe08.png)
![image](https://user-images.githubusercontent.com/77712564/158940240-9714f779-3a04-41bc-ae33-58208162d16d.png)
![image](https://user-images.githubusercontent.com/77712564/158940257-c27213d3-ec04-4ef2-b87b-a37311ffa9c2.png)


### 📄 상세 소개

<aside>
💡 “분산정보모바일시스템및실험” 과목을 수강하며 진행한 프로젝트입니다. 최근 개인의 조립 컴퓨터에 대한 관심이 증가하고 있으나 충분한 정보를 얻지 못해 구매에 어려움이 있습니다. 개인이 부품을 맞출 경우 부품의 호환 여부를 고려하지 않고 구매하는 문제가 있고, 신제품이 출시됐음에도 재고품을 구매하는 경우, 부품별 특성을 고려하지 않아 활용도가 낮은 사례 등이 있습니다. 이 문제들을 해결하기 위해 조립 컴퓨터 구매에 도움을 주는 “다안나와” 앱을 제작하였습니다. 각 부품별로 부품의 역할을 설명해주고, 부품과 부품 사이에 영향을 주는 부분을 고려하여 사용자가 부품을 선택시에 잘못된 부분이 있으면 바로 수정할 사항을 알려주도록 하였습니다. 개인이 자신이 원하는 부품으로 견적을 맞출 수도 있고, 용도와 금액별 추천 견적도 제공하여 편의성을 높였습니다.

</aside>

### 🛠 사용 기술 및 라이브러리

- Java, Android
- Google Firebase, Firebase Auth, Google Auth
- MySQL, MongoDB
- AWS EC2, RDS
- Python, Flask
- Google API - Places API, Maps SDK for Android

### ✏ 담당 기능

- 앱 기본 레이아웃 및 디자인
    - 액티비티와 프래그먼트 설계, 구현
- Firebase를 이용한 로그인 기능 구현
- AWS EC2, RDS 생성 및 설정
- EC2에 Ubuntu를 설치하고, Flask를 실행할 환경 구축
- Flask를 활용하여 주요 로직 처리
    - MySQL DB에 저장된 부품 데이터를 조건에 맞게 쿼리하여 json 파일 생성 후 앱에 전달
    - 사용자가 만든 견적 목록을 json 파일로 변환하여 MongoDB에 저장
    - 요청시 MongoDB에 저장된 사용자 견적 파일을 불러와 앱에 표시

### 🤔 회고

- Restful한 API 설계를 하지 않아 서비스를 요청하는 방식이 제각각이었습니다. Rest API에 대한 학습과 이에 따른 요청 방식 설계, URL 설계가 필요함을 느꼈습니다.
- Python과 Flask가 서툴러 기본적인 내용 위주로 사용하였는데, 자세한 공부를 통해 더 많은 기능을 추가하였으면 하는 아쉬움이 있습니다.
- Google Firebase에서 제공하는 토큰을 사용하여 기본적인 보안성만 가지고 있습니다. Java JWT와 같은 보안 관련 기술을 학습해보고 싶습니다.
