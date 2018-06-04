package footstats.model;

import javax.persistence.*;

@Entity
@Table(name = "matchstats")
public class MatchStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ball_possession_hometeam;

    private Integer ball_possession_awayteam;

    private Integer goal_attempts_hometeam;

    private Integer goal_attempts_awayteam;

    private Integer shots_on_goal_hometeam;

    private Integer shots_on_goal_awayteam;

    private Integer shots_off_goal_hometeam;

    private Integer shots_off_goal_awayteam;

    private Integer blocked_shots_hometeam;

    private Integer blocked_shots_awayteam;

    private Integer free_kicks_hometeam;

    private Integer free_kicks_awayteam;

    private Integer corner_kicks_hometeam;

    private Integer corner_kicks_awayteam;

    private Integer offsides_hometeam;

    private Integer offsides_awayteam;

    private Integer goalkeeper_saves_hometeam;

    private Integer goalkeeper_saves_awayteam;

    private Integer fouls_hometeam;

    private Integer fouls_awayteam;

    private Integer red_cards_hometeam;

    private Integer red_cards_awayteam;

    private Integer yellow_cards_hometeam;

    private Integer yellow_cards_awayteam;

    private Integer total_passes_hometeam;

    private Integer total_passes_awayteam;

    private Integer tackles_hometeam;

    private Integer tackles_awayteam;

    private Integer goals_homeclub;

    private Integer goals_awayclub;

    private Integer half_time_goals_homeclub;

    private Integer half_time_goals_awayclub;


    public MatchStats() {
    }

    public MatchStats(Integer id, Integer ball_possession_hometeam, Integer ball_possession_awayteam, Integer goal_attempts_hometeam, Integer goal_attempts_awayteam, Integer shots_on_goal_hometeam, Integer shots_on_goal_awayteam, Integer shots_off_goal_hometeam, Integer shots_off_goal_awayteam, Integer blocked_shots_hometeam, Integer blocked_shots_awayteam, Integer free_kicks_hometeam, Integer free_kicks_awayteam, Integer corner_kicks_hometeam, Integer corner_kicks_awayteam, Integer offsides_hometeam, Integer offsides_awayteam, Integer goalkeeper_saves_hometeam, Integer goalkeeper_saves_awayteam, Integer fouls_hometeam, Integer fouls_awayteam, Integer red_cards_hometeam, Integer red_cards_awayteam, Integer yellow_cards_hometeam, Integer yellow_cards_awayteam, Integer total_passes_hometeam, Integer total_passes_awayteam, Integer tackles_hometeam, Integer tackles_awayteam, Integer goals_homeclub, Integer goals_awayclub, Integer half_time_goals_homeclub, Integer half_time_goals_awayclub) {
        this.id = id;
        this.ball_possession_hometeam = ball_possession_hometeam;
        this.ball_possession_awayteam = ball_possession_awayteam;
        this.goal_attempts_hometeam = goal_attempts_hometeam;
        this.goal_attempts_awayteam = goal_attempts_awayteam;
        this.shots_on_goal_hometeam = shots_on_goal_hometeam;
        this.shots_on_goal_awayteam = shots_on_goal_awayteam;
        this.shots_off_goal_hometeam = shots_off_goal_hometeam;
        this.shots_off_goal_awayteam = shots_off_goal_awayteam;
        this.blocked_shots_hometeam = blocked_shots_hometeam;
        this.blocked_shots_awayteam = blocked_shots_awayteam;
        this.free_kicks_hometeam = free_kicks_hometeam;
        this.free_kicks_awayteam = free_kicks_awayteam;
        this.corner_kicks_hometeam = corner_kicks_hometeam;
        this.corner_kicks_awayteam = corner_kicks_awayteam;
        this.offsides_hometeam = offsides_hometeam;
        this.offsides_awayteam = offsides_awayteam;
        this.goalkeeper_saves_hometeam = goalkeeper_saves_hometeam;
        this.goalkeeper_saves_awayteam = goalkeeper_saves_awayteam;
        this.fouls_hometeam = fouls_hometeam;
        this.fouls_awayteam = fouls_awayteam;
        this.red_cards_hometeam = red_cards_hometeam;
        this.red_cards_awayteam = red_cards_awayteam;
        this.yellow_cards_hometeam = yellow_cards_hometeam;
        this.yellow_cards_awayteam = yellow_cards_awayteam;
        this.total_passes_hometeam = total_passes_hometeam;
        this.total_passes_awayteam = total_passes_awayteam;
        this.tackles_hometeam = tackles_hometeam;
        this.tackles_awayteam = tackles_awayteam;
        this.goals_homeclub = goals_homeclub;
        this.goals_awayclub = goals_awayclub;
        this.half_time_goals_homeclub = half_time_goals_homeclub;
        this.half_time_goals_awayclub = half_time_goals_awayclub;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBall_possession_hometeam() {
        return ball_possession_hometeam;
    }

    public void setBall_possession_hometeam(Integer ball_possession_hometeam) {
        this.ball_possession_hometeam = ball_possession_hometeam;
    }

    public Integer getBall_possession_awayteam() {
        return ball_possession_awayteam;
    }

    public void setBall_possession_awayteam(Integer ball_possession_awayteam) {
        this.ball_possession_awayteam = ball_possession_awayteam;
    }

    public Integer getGoal_attempts_hometeam() {
        return goal_attempts_hometeam;
    }

    public void setGoal_attempts_hometeam(Integer goal_attempts_hometeam) {
        this.goal_attempts_hometeam = goal_attempts_hometeam;
    }

    public Integer getGoal_attempts_awayteam() {
        return goal_attempts_awayteam;
    }

    public void setGoal_attempts_awayteam(Integer goal_attempts_awayteam) {
        this.goal_attempts_awayteam = goal_attempts_awayteam;
    }

    public Integer getShots_on_goal_hometeam() {
        return shots_on_goal_hometeam;
    }

    public void setShots_on_goal_hometeam(Integer shots_on_goal_hometeam) {
        this.shots_on_goal_hometeam = shots_on_goal_hometeam;
    }

    public Integer getShots_on_goal_awayteam() {
        return shots_on_goal_awayteam;
    }

    public void setShots_on_goal_awayteam(Integer shots_on_goal_awayteam) {
        this.shots_on_goal_awayteam = shots_on_goal_awayteam;
    }

    public Integer getShots_off_goal_hometeam() {
        return shots_off_goal_hometeam;
    }

    public void setShots_off_goal_hometeam(Integer shots_off_goal_hometeam) {
        this.shots_off_goal_hometeam = shots_off_goal_hometeam;
    }

    public Integer getShots_off_goal_awayteam() {
        return shots_off_goal_awayteam;
    }

    public void setShots_off_goal_awayteam(Integer shots_off_goal_awayteam) {
        this.shots_off_goal_awayteam = shots_off_goal_awayteam;
    }

    public Integer getBlocked_shots_hometeam() {
        return blocked_shots_hometeam;
    }

    public void setBlocked_shots_hometeam(Integer blocked_shots_hometeam) {
        this.blocked_shots_hometeam = blocked_shots_hometeam;
    }

    public Integer getBlocked_shots_awayteam() {
        return blocked_shots_awayteam;
    }

    public void setBlocked_shots_awayteam(Integer blocked_shots_awayteam) {
        this.blocked_shots_awayteam = blocked_shots_awayteam;
    }

    public Integer getFree_kicks_hometeam() {
        return free_kicks_hometeam;
    }

    public void setFree_kicks_hometeam(Integer free_kicks_hometeam) {
        this.free_kicks_hometeam = free_kicks_hometeam;
    }

    public Integer getFree_kicks_awayteam() {
        return free_kicks_awayteam;
    }

    public void setFree_kicks_awayteam(Integer free_kicks_awayteam) {
        this.free_kicks_awayteam = free_kicks_awayteam;
    }

    public Integer getCorner_kicks_hometeam() {
        return corner_kicks_hometeam;
    }

    public void setCorner_kicks_hometeam(Integer corner_kicks_hometeam) {
        this.corner_kicks_hometeam = corner_kicks_hometeam;
    }

    public Integer getCorner_kicks_awayteam() {
        return corner_kicks_awayteam;
    }

    public void setCorner_kicks_awayteam(Integer corner_kicks_awayteam) {
        this.corner_kicks_awayteam = corner_kicks_awayteam;
    }

    public Integer getOffsides_hometeam() {
        return offsides_hometeam;
    }

    public void setOffsides_hometeam(Integer offsides_hometeam) {
        this.offsides_hometeam = offsides_hometeam;
    }

    public Integer getOffsides_awayteam() {
        return offsides_awayteam;
    }

    public void setOffsides_awayteam(Integer offsides_awayteam) {
        this.offsides_awayteam = offsides_awayteam;
    }

    public Integer getGoalkeeper_saves_hometeam() {
        return goalkeeper_saves_hometeam;
    }

    public void setGoalkeeper_saves_hometeam(Integer goalkeeper_saves_hometeam) {
        this.goalkeeper_saves_hometeam = goalkeeper_saves_hometeam;
    }

    public Integer getGoalkeeper_saves_awayteam() {
        return goalkeeper_saves_awayteam;
    }

    public void setGoalkeeper_saves_awayteam(Integer goalkeeper_saves_awayteam) {
        this.goalkeeper_saves_awayteam = goalkeeper_saves_awayteam;
    }

    public Integer getFouls_hometeam() {
        return fouls_hometeam;
    }

    public void setFouls_hometeam(Integer fouls_hometeam) {
        this.fouls_hometeam = fouls_hometeam;
    }

    public Integer getFouls_awayteam() {
        return fouls_awayteam;
    }

    public void setFouls_awayteam(Integer fouls_awayteam) {
        this.fouls_awayteam = fouls_awayteam;
    }

    public Integer getRed_cards_hometeam() {
        return red_cards_hometeam;
    }

    public void setRed_cards_hometeam(Integer red_cards_hometeam) {
        this.red_cards_hometeam = red_cards_hometeam;
    }

    public Integer getRed_cards_awayteam() {
        return red_cards_awayteam;
    }

    public void setRed_cards_awayteam(Integer red_cards_awayteam) {
        this.red_cards_awayteam = red_cards_awayteam;
    }

    public Integer getYellow_cards_hometeam() {
        return yellow_cards_hometeam;
    }

    public void setYellow_cards_hometeam(Integer yellow_cards_hometeam) {
        this.yellow_cards_hometeam = yellow_cards_hometeam;
    }

    public Integer getYellow_cards_awayteam() {
        return yellow_cards_awayteam;
    }

    public void setYellow_cards_awayteam(Integer yellow_cards_awayteam) {
        this.yellow_cards_awayteam = yellow_cards_awayteam;
    }

    public Integer getTotal_passes_hometeam() {
        return total_passes_hometeam;
    }

    public void setTotal_passes_hometeam(Integer total_passes_hometeam) {
        this.total_passes_hometeam = total_passes_hometeam;
    }

    public Integer getTotal_passes_awayteam() {
        return total_passes_awayteam;
    }

    public void setTotal_passes_awayteam(Integer total_passes_awayteam) {
        this.total_passes_awayteam = total_passes_awayteam;
    }

    public Integer getTackles_hometeam() {
        return tackles_hometeam;
    }

    public void setTackles_hometeam(Integer tackles_hometeam) {
        this.tackles_hometeam = tackles_hometeam;
    }

    public Integer getTackles_awayteam() {
        return tackles_awayteam;
    }

    public void setTackles_awayteam(Integer tackles_awayteam) {
        this.tackles_awayteam = tackles_awayteam;
    }

    public Integer getGoals_homeclub() {
        return goals_homeclub;
    }

    public void setGoals_homeclub(Integer goals_homeclub) {
        this.goals_homeclub = goals_homeclub;
    }

    public Integer getGoals_awayclub() {
        return goals_awayclub;
    }

    public void setGoals_awayclub(Integer goals_awayclub) {
        this.goals_awayclub = goals_awayclub;
    }

    public Integer getHalf_time_goals_homeclub() {
        return half_time_goals_homeclub;
    }

    public void setHalf_time_goals_homeclub(Integer half_time_goals_homeclub) {
        this.half_time_goals_homeclub = half_time_goals_homeclub;
    }

    public Integer getHalf_time_goals_awayclub() {
        return half_time_goals_awayclub;
    }

    public void setHalf_time_goals_awayclub(Integer half_time_goals_awayclub) {
        this.half_time_goals_awayclub = half_time_goals_awayclub;
    }
}
