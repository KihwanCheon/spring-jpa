# N+1 problem.
* multi-way relationship.
* select each entity by entity on loop or method chaining.

## Solutions
* fetch at once.
* Beware of complex cardinality!!

### 1. QueryDsl
* http://querydsl.com/static/querydsl/4.0.1/reference/ko-KR/html_single/

### 2. EntityGraph
* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-graph

### 3. Jpql
* https://docs.oracle.com/cd/E11035_01/kodo41/full/html/ejb3_langref.html
* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
