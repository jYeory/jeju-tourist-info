# 시작하기

### Guides

이 프로젝트는 제주데이터허브에서 두 프로젝트의 데이터를 가져오는 것이 목적입니다.

* [[관광, 여행] 관광지별 내국인 유입자 수](https://www.jejudatahub.net/data/view/data/591)
* [[관광, 여행] 관광지별 외국인 유입자 수](https://www.jejudatahub.net/data/view/data/592)

### 사전 준비사항

- mysql - schema/사용자 생성

```
CREATE SCHEMA `jeju_tourist` DEFAULT CHARACTER SET utf8mb4;

CREATE TABLE `domestic_tourist` (
  `idx` int auto_increment NOT NULL,
  `dtYearMonth` varchar(6) NOT NULL,
  `sightsName` varchar(100) NOT NULL,
  `payType` varchar(100) NOT NULL,
  `userCnt` int NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `foreign_tourist` (
  `idx` int auto_increment NOT NULL,
  `dtYearMonth` varchar(6) NOT NULL,
  `sightsName` varchar(100) NOT NULL,
  `payType` varchar(100) NOT NULL,
  `userCnt` int NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

```

### 실행법
```
java -jar jejuDataHub.jar D|F {your_project_key} {start_date} {end_date}
```

데이터 가지고 와서 지지고 볶아 본인만의 통계 데이터를 만드시면 됩니다.



