package com.workintech.models.library;

import com.workintech.enums.Status;
import com.workintech.models.member.Member;

import java.util.Objects;

public class StudyRoom {
    private int roomNo;
    private Status status;
    private boolean hasBoard;
    private int numberOfElectricSockets;
    private Member reserver;

    public StudyRoom(int roomNo, boolean hasBoard, int numberOfElectricSockets) {
        this.roomNo = roomNo;
        this.status = Status.AVAILABLE;
        this.hasBoard = hasBoard;
        this.numberOfElectricSockets = numberOfElectricSockets;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isHasBoard() {
        return hasBoard;
    }

    public void setHasBoard(boolean hasBoard) {
        this.hasBoard = hasBoard;
    }

    public int getNumberOfElectricSockets() {
        return numberOfElectricSockets;
    }

    public void setNumberOfElectricSockets(int numberOfElectricSockets) {
        this.numberOfElectricSockets = numberOfElectricSockets;
    }

    public Member getReserver() {
        return reserver;
    }

    public void setReserver(Member reserver) {
        this.reserver = reserver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudyRoom studyRoom)) return false;
        return roomNo == studyRoom.roomNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNo);
    }

    @Override
    public String toString() {
        String reserverName = reserver == null ? "No reserver" : reserver.getName();
        return "StudyRoom{" +
                "roomNo=" + roomNo +
                ", status=" + status +
                ", reserver=" + reserverName +
                ", hasBoard=" + hasBoard +
                ", numberOfElectricSockets=" + numberOfElectricSockets +
                '}';
    }
}
