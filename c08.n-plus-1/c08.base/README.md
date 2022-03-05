
# Base of N+1 problem
* joining 3 entities

## Multiple relationship
* multiple select queries.
* complex cardinality of multiple joins.
* get all reserved seat with all reservation
```sql
-- reservation
select reservatio0_.id as id1_1_,
    reservatio0_.account_id as account_3_1_,
    reservatio0_.reserve_date as reserve_2_1_ 
from reservation reservatio0_

-- who?
select account0_.id as id1_0_0_,
    account0_.name as name2_0_0_ 
from account account0_ 
where account0_.id=?

select account0_.id as id1_0_0_,
    account0_.name as name2_0_0_ 
from account account0_ 
where account0_.id=?

-- seats?
select seats0_.reservation_id as reservat4_2_0_,
    seats0_.id as id1_2_0_,
    seats0_.id as id1_2_1_,
    seats0_.price as price2_2_1_,
    seats0_.seat_no as seat_no3_2_1_,
    seat1_.no as no1_3_2_,
    seat1_.cols as cols2_3_2_,
    seat1_.rows as rows3_3_2_ 
from reservation_seat seats0_ 
left outer join seat seat1_ 
on seats0_.seat_no=seat1_.no 
where seats0_.reservation_id=?

select seats0_.reservation_id as reservat4_2_0_,
    seats0_.id as id1_2_0_,
    seats0_.id as id1_2_1_,
    seats0_.price as price2_2_1_,
    seats0_.seat_no as seat_no3_2_1_,
    seat1_.no as no1_3_2_,
    seat1_.cols as cols2_3_2_,
    seat1_.rows as rows3_3_2_ 
from reservation_seat seats0_ 
left outer join seat seat1_ 
on seats0_.seat_no=seat1_.no 
where seats0_.reservation_id=?
```