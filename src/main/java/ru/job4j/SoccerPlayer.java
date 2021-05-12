package ru.job4j;

public class SoccerPlayer {
    public static void main(String[] args) {
        SoccerPlayer soccerPlayer = new Builder().getAge(33)
                .getFirstName("Artem")
                .getLastName("Derevo")
                .getPosition("A")
                .getInjury(false)
                .getTransferCost(11.0)
                .build();
    }

    private String firstName;

    private String lastName;

    private int age;

    private String position;

    private String strikingLeg;

    private boolean injury;

    private double transferCost;


    static class Builder {
         String firstName;

         String lastName;

         int age;

         String position;

         String strikingLeg;

         boolean injury;

         double transferCost;

         Builder getFirstName(String firstName) {
             this.firstName = firstName;
             return this;
         }

         Builder getLastName(String lastName) {
             this.lastName = lastName;
             return this;
         }

         Builder getAge(int age) {
             this.age = age;
             return this;
         }

         Builder getPosition(String position) {
             this.position = position;
             return this;
         }

         Builder getStrikingLeg(String strikingLeg) {
             this.strikingLeg = strikingLeg;
             return this;
         }

         Builder getInjury(boolean injury) {
             this.injury = injury;
             return this;
         }

         Builder getTransferCost(double transferCost) {
             this.transferCost = transferCost;
             return this;
         }

         SoccerPlayer build() {
             SoccerPlayer sp = new SoccerPlayer();
             sp.age = age;
             sp.firstName = firstName;
             sp.lastName = lastName;
             sp.injury = injury;
             sp.position = position;
             sp.strikingLeg = strikingLeg;
             sp.transferCost = transferCost;
             return sp;
         }

    }

}
