
# Simple insert & select
* H2 database setup
* spring boot, jpa
* select with method expression
* ManyToOne
* last getMember: select separately
```sql
select member0_.id as id1_0_,
 member0_.name as name2_0_,
  member0_.team_id as team_id3_0_ 
from member member0_ 
left outer join team team1_ 
    on member0_.team_id=team1_.id 
where team1_.id=?;

select team0_.id as id1_1_0_, team0_.name as name2_1_0_ 
from team team0_ where team0_.id=?;
```