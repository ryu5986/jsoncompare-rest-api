# jsoncompare-rest-api
---

### 프로젝트 소개
---
JSON 데이터를 비교하여 서로 다른점의 내용과 수를 표기하고 그중에서도 원하는 형식만 볼 수 있게 만든 프로젝트입니다.
(Front-end 내용은 <https://github.com/ryu5986/vue-jsoncompare> 의 README 확인 부탁드리겠습니다. ^^)

### 개발 기간
---
* 2023.01.30 ~ 2024.02.20
* 1주차 ~ 2주차: front-end 및 back-end 작업
* 3주차: 최종 점검 및 AWS 배포

### 개발 배경
---
저는 SI 회사에서 약 3년 정도 근무를 하면서 항상 똑같은 언어와 작업으로 인해 제 개인의 역량이
발전보다는 반복에 가까워 지는 느낌을 받아 매너리즘이 오기전에 그만두고 미래진로에 대해 생각할 시간이 필요했습니다.
그 과정에서 주변 선후배 및 동료분들께 자문을 구하며 앞으로 어떻게 해야할지 고심 끝에 작업을 하는데 있어 저와 더 잘맞을 거 같은
front-end 쪽으로 진로를 결정하게 되었습니다.
이과정에서 저는 기존에 늘 사용하던 JQuery, JavaScript, JSP, Thymeleaf 보다는 좀 더 Modern 한 개발언어나 방식이 필요하다고 느껴 미니 프로젝트를 만들어야 겠다고 생각했습니다.
어떤 프로젝트를 할 지 고민 하던 중 평소 자주 이용하던 JSON 비교 사이트 <https://www.jsondiff.com/> 가 떠오르기도 하고 비슷하게 만들면서 추가적으로 DB 연결도 해보면 좋을 것 같아 진행 하게 되었습니다.

### 기술 스텍(Back-end)
---
* IDE: Intellij, DBeaver
* Framework: SpringBoot
* Lang: JAVA 17
* DB: MariaDB
* ORM: Hibernate

### 프로젝트 주요 기능
---
1. 왼쪽과 오른쪽에 각각 JSON 형식을 입력하거나 JSON 파일을 받아 서로 다른점을 비교 하여 결과를 표시합니다.
2. 표시된 결과에서 다른점을 분류별로 나뉘어 원하는 분류만 눈에 띄게 볼 수 있습니다.
3. 다른점을 색상을 주어 표기하였고 색상이 있는 줄을 클릭했을 시 해당 다른점에 대한 내용만도 볼 수 있습니다.

### 프로젝트 개발 구성과 이유
---
- Back-end 부분은 Rest-API 구성으로 진행하였으며 기능적으로는 Compare 한 정보를 저장 및 가져오는 기능만 생성하였습니다.
- SpringBoot 는 익숙하여 사용하였고 구성 패키지는 config, controller, dto, entity, repository, service 로 구성하였습니다. config 에서 CORS 설정 관련 클래스를 만들었으며, dto 와 entity 를 따로 분리하여 관리할 수 있게 구성하였습니다.
- 기존에 작업을 할 때는 항상 Mybatis 를 사용하여 쿼리를 직접 작성하여 진행했었으나 이번에는 개발의 속도 향상을 위해 Hibernate 를 이용하여 작업하였습니다.

### URL
- <http://vue-jsoncompare.s3-website.ap-northeast-2.amazonaws.com>

  