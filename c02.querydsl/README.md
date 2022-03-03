
# Simple insert & select
* base [c10.simple](../c01.simple/README.md)
* select with querydsl for **fetch join**
  * http://querydsl.com/static/querydsl/4.1.3/reference/html_single/
  * apt-maven-plugin: mvn apt:process
  * add custom repository interface with @NoRepositoryBean
  * main jpa repo interface extend custom repository
  * impl custom repository
  * use main jpa repo interface
```java
class Entity {
    @Id Long id;
}
@NoRepositoryBean
interface EntityRepoCustom {
    List<Entity> listSome();
}

interface EntityRepo extends EntityCustmRepo, JpaRepository<Entity, Long> {
}

class EntityRepoImp extends QuerydslRepositorySupport implements EntityRepoCustom {
  public List<Entity> listSome() {
      return ...;
  }
}
```
* last getMember: select at once
```sql
select member0_.id as id1_0_0_,
       team1_.id as id1_1_1_,
       member0_.name as name2_0_0_,
       member0_.team_id as team_id3_0_0_,
       team1_.name as name2_1_1_
from member member0_ 
inner join team team1_ 
on member0_.team_id=team1_.id 
where member0_.team_id=?;
```