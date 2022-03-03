
# Simple insert & select
* base [c10.dto](../c01.dto/README.md)
* select with querydsl
  * apt-maven-plugin: mvn apt:process
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