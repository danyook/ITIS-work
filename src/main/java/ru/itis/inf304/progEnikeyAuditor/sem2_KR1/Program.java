package ru.itis.inf304.progEnikeyAuditor.sem2_KR1;

public class Program {
    String channel;
    BroadcastsTime time;
    String name;

    BroadcastsTime broadcastsTime;

    public Program(String channel, BroadcastsTime time, String name) {
        this.channel = channel;
        this.time = time;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Program{" +
                "channel='" + channel + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
