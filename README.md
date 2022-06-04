# kotlin-blackjack

## 코틀린 DSL

### 구현 예시

```text
introduce {
  name("이요한")
  company("카카오")
  skills {
    soft("A passion for problem solving")
    soft("Good communication skills")
    hard("Kotlin")
  }
  languages {
    "Korean" level 5
    "English" level 3
  }
}
```

### 구현 목록

- 최상위 함수
  - [X] introduce 함수 구현
  
- `이력서(Resume)`
  - 이름, 회사, 스킬 목록, 언어 목록을 상태로 가진다

- `이력서 빌더(ResumeBuilder)`
  - [X] name 함수 구현
  - [X] company 함수 구현
  - [X] skills 함수 구현
  - [X] languages 함수 구현

- `스킬(Skill)`
  - 스킬 타입과 이름을 상태로 가진다

- `스킬 빌더(SkillBuilder)`
  - [X] soft 함수 구현
  - [X] hard 함수 구현 

- `언어(Language)`
  - 이름과 단계를 상태로 가진다

- `언어 빌더(LanguageBuilder)`
  - [X] 중위 표기 구현

## 블랙잭

### 기능 요구사항
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

### 실행 결과
```text
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi, jason에게 2장의 나누었습니다.
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
```

### 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 모든 엔티티를 작게 유지한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 도메인 모델

- `카드(Card)`
  - 카드 문양과 카드 타입을 상태로 가진다.
  - [ ] 카드가 동일한지 비교할 수 있다
  - 점수를 반환한다
    - [ ] 카드 숫자는 숫자 그대로 반환한다
    - [ ] Ace는 1 또는 11로 반환한다
    - [ ] King, Queen, Jack은 각각 10으로 반환한다

- `카드 문양(CardPattern)`
  - 네 가지 문양을 가진다. (다이아몬드, 스페이드, 클로버, 하트) 

- `카드 유형(CardType)`
  - 카드 이름과 점수를 가진다.

- `점수(Score)`
  - [ ] 점수를 더할 수 있다
  - [ ] 점수를 비교할 수 있다
