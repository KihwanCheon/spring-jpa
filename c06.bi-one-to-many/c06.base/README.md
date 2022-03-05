# Based [c05.compositekey](../../c05.uni-one-to-many/c05.compositekey/README.md)
* Add Cascade option.
* But failed
```
org.hibernate.MappingException: 
    Repeated column in mapping for entity: 
        example.c06.base.entity.TeamDetail column: 
            team_id (should be mapped with insert="false" update="false")
```