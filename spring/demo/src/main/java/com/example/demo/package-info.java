package com.example.demo;

// 초기 프로젝트를 생성하면 `resources/application.properties` 가 존재합니다.
// 이것의 이름을 `resources/application.yaml` 로 변경하였습니다.
// 변경한 이유는 작성할 사항이 적어지기 때문입니다.

// `*.properties` 상황
// a.b.c.d=adfjladlajdlf
// a.b.c.test=sdfjsldfjla
// a.b.c.d.e.good=good

// 아래와 같이 계층 구조 형태로 볼 수 있고 작성할 분량도 줄어듬
// `*.yaml` 상황
// a:
//   b:
//     c:
//       d: adfjladlajdlf
//         e:
//           good: good
//       test: sdfjsldfjla
