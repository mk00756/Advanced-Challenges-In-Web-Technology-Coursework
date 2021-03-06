package com3014.league.service.impl;

import com3014.league.model.Fixture;
import com3014.league.model.League;
import com3014.league.model.Player;
import com3014.league.model.Team;
import org.springframework.stereotype.Service;
import com3014.league.service.leagueService;
import com3014.league.dao.leagueDAO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class leagueServiceImpl implements leagueService {
    
    @Autowired
    leagueDAO leagueDAO;

    @Override
    public void deleteTeam(int teamId, int leagueId) {
        leagueDAO.deleteTeam(teamId, leagueId);
    }

    @Override
    public void addTeam(Team team, int leagueId) {
        leagueDAO.getAllLeagues().get(leagueId).setTeam(team);
    }

    @Override
    public void updateName(String name, int leagueId) {
        leagueDAO.getAllLeagues().get(leagueId).setName(name);
    }

    @Override
    public void updateMaxTeam(int maxTeam, int leagueId) {
        leagueDAO.getAllLeagues().get(leagueId).setMaxTeams(maxTeam);
    }

    @Override
    public List<League> getAllLeagues() {
        return leagueDAO.getAllLeagues();
    }

    @Override
    public List<Team> getAllTeams(int leagueId) {
        List<Team> teams = leagueDAO.getAllTeams(leagueId);
        Collections.sort(teams);
        return teams;
    }
    
    @Override
    public Team getTeamByID(int leagueId,int teamId) {
        return leagueDAO.getTeamByID(leagueId, teamId);
    }

    @Override
    public League getLeagueByID(int leagueId) {
        return leagueDAO.getLeague(leagueId);
    }


    @Override
    public void addLeague(League league) {
        leagueDAO.addLeague(league);
    }

    @Override
    public Fixture getFixtureByID(int fixtureId, int leagueId) {
        return leagueDAO.getFixtureByID(fixtureId, leagueId);
    }

    @Override
    public void addFixture(Fixture fixture, int leagueId) {
        leagueDAO.addFixture(fixture, leagueId);
    }

    @Override
    public void deleteFixture(int fixtureId, int leagueId) {
        leagueDAO.deleteFixture(fixtureId, leagueId);
    }

    @Override
    public List<Fixture> getAllFixtures(int leagueId) {
        return leagueDAO.getAllFixtures(leagueId);
    }

    @Override
    public Player getPlayerByNumber(int playerNum, int teamId, int leagueId) {
        return leagueDAO.getPlayerByNumber(playerNum, teamId, leagueId);
    }

    @Override
    public void addPlayer(Player player, int teamId, int leagueId) {
        leagueDAO.addPlayer(player, teamId, leagueId);
    }


    @Override
    public List<Player> getAllPlayers(int teamId, int leagueId) {
        return leagueDAO.getAllPlayers(teamId, leagueId);
    }

    @Override
    public boolean containsLeague(int leagueId) {
        List<League> leagues = leagueDAO.getAllLeagues();
        for (League l : leagues ) {
            if (l.getId() == leagueId) {
                return true;
            }
        }
        return false;
    }

}
