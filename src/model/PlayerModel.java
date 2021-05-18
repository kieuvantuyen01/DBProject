/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kieuvantuyen01
 */
public class PlayerModel {
    private String ssn;
    private String clubName;
    private String position;
    private int shirtNumber;
    private int weight;
    private int height;
    private String condition;
    private int goalNumbers;
    private int matchNumbers;
    private int penaltyCards;
    private int bidAmount;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getGoalNumbers() {
        return goalNumbers;
    }

    public void setGoalNumbers(int goalNumbers) {
        this.goalNumbers = goalNumbers;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public void setMatchNumbers(int matchNumbers) {
        this.matchNumbers = matchNumbers;
    }

    public int getPenaltyCards() {
        return penaltyCards;
    }

    public void setPenaltyCards(int penaltyCards) {
        this.penaltyCards = penaltyCards;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }
}
