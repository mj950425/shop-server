# 프로젝트 설명

## 구현 범위에 대한 설명
이 프로젝트는 에릭 에반스의 DDD(Domain Driven Design)의 전술적 및 전략적 설계 원칙을 일부 차용하여 설계되었습니다.

먼저, 상품, 카테고리, 파트너를 각각의 도메인으로 나누고, 이를 product, category, partner 패키지로 구분했습니다.

또한, 기능별로 ui, infra, domain, application 패키지로 구분했습니다.

- `ui 패키지`: HTTP 요청과 응답을 처리하는 컨트롤러를 구현했습니다.

- `infra 패키지`: ACL로써 외부 라이브러리(ex hibernate)나 타 도메인과의 연동을 실직적으로 처리하는 클래스를 구현함으로써, 도메인의 순수성을 유지했습니다.

- `application 패키지`: 흐름을 제어하거나 트랜잭션과 같은 기술적인 요소를 처리하는 클래스를 구현했습니다.

- `domain 패키지`: 도메인의 핵심 로직을 구현했습니다.

상품 도메인에서는 `고객 바운디드 컨택스트`와 `파트너 바운디드 컨택스트` 구분했습니다.

- `파트너 바운디드 컨텍스트에서`: 생성, 삭제, 변경과 같은 비즈니스 로직을 구현했습니다.

- `고객 바운디드 컨텍스트`: 고객에게 노출될 데이터의 쿼리 로직을 구현했습니다.

테스트는 두 가지 방법으로 구성되었습니다.
- 스프링의 복잡한 컴포넌트를 제외한 경우에는 Fake 객체를 활용하여 단위 테스트를 구성했습니다.
- 인수 테스트에서는 RestAssured를 활용했습니다.

## 코드 빌드, 테스트, 실행 방법

1. JDK 17을 설치합니다.
2. 터미널에서 `git clone https://github.com/mj950425/shop-server.git` 명령어를 입력해서 프로젝트를 클론합니다.
3. 설치한 디렉토리로 이동합니다.
4. `./gradlew clean build` 명령어를 입력해서 프로젝트를 빌드하고 필요한 의존성을 설치합니다.
5. `./gradlew bootRun` 명령어를 입력해서 애플리케이션을 실행합니다.
6. H2 콘솔(http://localhost:8080/h2-console)에 접속하여, tool/sql/init.sql 파일의 내용을 복사하여 붙여넣고 실행합니다.
7. tool/http 디렉토리에서 원하는 기능의 HTTP 파일을 실행합니다.
8. 단위 테스트또는 인수 테스트를 실행하려면, 터미널에서 `./gradlew clean test`를 입력합니다.

## 패키지 트리
```
shop
├─ src
│  ├─ main
│  │  ├─ kotlin
│  │  │  └─ com
│  │  │     └─ example
│  │  │        └─ shop
│  │  │           ├─ ShopApplication.kt
│  │  │           ├─ category
│  │  │           │  ├─ application
│  │  │           │  │  ├─ CategoriesResponse.kt
│  │  │           │  │  └─ CategoryService.kt
│  │  │           │  ├─ domain
│  │  │           │  │  ├─ Category.kt
│  │  │           │  │  ├─ CategoryCode.kt
│  │  │           │  │  └─ CategoryRepository.kt
│  │  │           │  ├─ infra
│  │  │           │  │  └─ JpaCategoryRepository.kt
│  │  │           │  └─ ui
│  │  │           │     ├─ CategoryController.kt
│  │  │           │     └─ CreateCategoryRequest.kt
│  │  │           ├─ partner
│  │  │           │  ├─ application
│  │  │           │  │  └─ PartnerService.kt
│  │  │           │  ├─ domain
│  │  │           │  │  ├─ BrandName.kt
│  │  │           │  │  ├─ Partner.kt
│  │  │           │  │  ├─ PartnerDeletedEvent.kt
│  │  │           │  │  └─ PartnerRepository.kt
│  │  │           │  ├─ infra
│  │  │           │  │  └─ JpaPartnerRepository.kt
│  │  │           │  └─ ui
│  │  │           │     ├─ CreatePartnerRequest.kt
│  │  │           │     └─ PartnerController.kt
│  │  │           ├─ product
│  │  │           │  ├─ customer
│  │  │           │  │  ├─ application
│  │  │           │  │  │  ├─ CheapestAndMostExpensiveProductsByCategoryResponse.kt
│  │  │           │  │  │  ├─ CheapestPartnerResponse.kt
│  │  │           │  │  │  ├─ CheapestProductPerCategoriesResponse.kt
│  │  │           │  │  │  └─ CustomerProductService.kt
│  │  │           │  │  ├─ domain
│  │  │           │  │  │  ├─ CustomerProduct.kt
│  │  │           │  │  │  └─ CustomerProductRepository.kt
│  │  │           │  │  ├─ infra
│  │  │           │  │  │  └─ JpaCustomerProductRepository.kt
│  │  │           │  │  └─ ui
│  │  │           │  │     └─ CustomerProductController.kt
│  │  │           │  └─ partner
│  │  │           │     ├─ application
│  │  │           │     │  ├─ ProductPartnerService.kt
│  │  │           │     │  └─ ProductResponse.kt
│  │  │           │     ├─ domain
│  │  │           │     │  ├─ PartnerProduct.kt
│  │  │           │     │  ├─ ProductBrandNameClient.kt
│  │  │           │     │  ├─ ProductCategoryNameClient.kt
│  │  │           │     │  ├─ ProductPrice.kt
│  │  │           │     │  └─ ProductRepository.kt
│  │  │           │     ├─ infra
│  │  │           │     │  ├─ JpaProductRepository.kt
│  │  │           │     │  ├─ PartnerDeleteEventHandler.kt
│  │  │           │     │  ├─ ProductBrandNameClientImpl.kt
│  │  │           │     │  └─ ProductCategoryNameClientImpl.kt
│  │  │           │     └─ ui
│  │  │           │        ├─ ProductPartnerController.kt
│  │  │           │        ├─ RegisterProductRequest.kt
│  │  │           │        └─ UpdateProductRequest.kt
│  │  │           └─ support
│  │  │              ├─ domain
│  │  │              │  └─ BaseEntity.kt
│  │  │              └─ ui
│  │  │                 ├─ ErrorResponse.kt
│  │  │                 ├─ ExceptionHandleAdvice.kt
│  │  │                 └─ WebConfig.kt
│  │  └─ resources
│  │     └─ application.yml
│  └─ test
│     └─ kotlin
│        └─ com
│           └─ example
│              └─ shop
│                 ├─ category
│                 │  ├─ application
│                 │  │  └─ CategoryServiceTest.kt
│                 │  └─ domain
│                 │     ├─ CategoryCodeTest.kt
│                 │     ├─ CategoryTest.kt
│                 │     └─ FakeCategoryRepository.kt
│                 ├─ partner
│                 │  ├─ application
│                 │  │  └─ PartnerServiceTest.kt
│                 │  └─ domain
│                 │     ├─ BrandNameTest.kt
│                 │     ├─ FakePartnerRepository.kt
│                 │     └─ PartnerTest.kt
│                 ├─ product
│                 │  ├─ customer
│                 │  │  ├─ application
│                 │  │  ├─ domain
│                 │  │  ├─ infra
│                 │  │  └─ ui
│                 │  │     └─ CustomerProductAcceptanceTest.kt
│                 │  └─ partner
│                 │     ├─ application
│                 │     │  └─ ProductPartnerServiceTest.kt
│                 │     ├─ domain
│                 │     │  ├─ FakeProductBrandNameClient.kt
│                 │     │  ├─ FakeProductCategoryNameClient.kt
│                 │     │  ├─ FakeProductRepository.kt
│                 │     │  ├─ PartnerProductTest.kt
│                 │     │  └─ ProductPriceTest.kt
│                 │     └─ ui
│                 │        └─ PartnerProductAcceptanceTest.kt
│                 └─ support
│                    ├─ CommonAcceptanceTest.kt
│                    ├─ CommonDataInserter.kt
│                    └─ CommonFakeRepository.kt
└─ tool
   ├─ http
   │  ├─ category
   │  │  └─ category.http
   │  ├─ http-client.private.env.json
   │  ├─ partner
   │  │  └─ partner.http
   │  └─ product
   │     ├─ partner
   │     │  └─ product-partner.http
   │     └─ traveler
   │        └─ product-traveler.http
   └─ sql
      └─ init.sql
```