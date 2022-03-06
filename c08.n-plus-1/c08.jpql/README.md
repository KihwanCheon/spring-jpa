
# JPQL
* joining 3 entities

## Multiple relationship
* jpql make single join query.
```sql
-- from
select r 
from Reservation r
inner join fetch r.account as a 
left join fetch r.seats as rs
inner join fetch rs.seat as s 
-- to
select reservatio0_.id as id1_1_0_,
       account1_.id as id1_0_1_,
       seats2_.id as id1_2_2_,
       seat3_.no as no1_3_3_,
       reservatio0_.account_id as account_3_1_0_,
       reservatio0_.reserve_date as reserve_2_1_0_,
       account1_.name as name2_0_1_,
       seats2_.price as price2_2_2_,
       seats2_.seat_no as seat_no3_2_2_,
       seats2_.reservation_id as reservat4_2_0__,
       seats2_.id as id1_2_0__,
       seat3_.cols as cols2_3_3_,
       seat3_.rows as rows3_3_3_ 
from reservation reservatio0_
inner join account account1_
    on reservatio0_.account_id=account1_.id
left outer join reservation_seat seats2_
    on reservatio0_.id=seats2_.reservation_id
inner join seat seat3_
    on seats2_.seat_no=seat3_.no
```