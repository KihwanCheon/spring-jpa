
# Solved: [c08.querydslquest](../c08.querydsl-quest/README.md)
```java
public class TeamRepoImpl extends QuerydslRepositorySupport implements TeamRepoCustom {

    public TeamRepoImpl() {
        super(Team.class);
    }

    @Override
    public List<Team> getTeamsWithAssociation() {
        QTeam team = QTeam.team;
        QTeamDetail detail = QTeamDetail.teamDetail;
        return from(team)
                .innerJoin(team.details, detail).fetchJoin()
                .fetch();
    }
}
```
