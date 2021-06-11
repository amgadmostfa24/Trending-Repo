package com.ailbaz.moststarredrepo;

public class RepoViewModel {

    private String nameOfRepo;
    private String discOfRepo;
    private String ownerOfRepo;
    private int starsOfRepo;

    public RepoViewModel(String nameOfRepo, String discOfRepo,int starsOfRepo ,String ownerOfRepo ) {
        this.nameOfRepo = nameOfRepo;
        this.discOfRepo = discOfRepo;
        this.ownerOfRepo = ownerOfRepo;
        this.starsOfRepo = starsOfRepo;
    }

    public String getNameOfRepo() {
        return nameOfRepo;
    }

    public void setNameOfRepo(String nameOfRepo) {
        this.nameOfRepo = nameOfRepo;
    }

    public String getDiscOfRepo() {
        return discOfRepo;
    }

    public void setDiscOfRepo(String discOfRepo) {
        this.discOfRepo = discOfRepo;
    }

    public String getOwnerOfRepo() {
        return ownerOfRepo;
    }

    public void setOwnerOfRepo(String ownerOfRepo) {
        this.ownerOfRepo = ownerOfRepo;
    }

    public int getStarsOfRepo() {
        return starsOfRepo;
    }

    public void setStarsOfRepo(int starsOfRepo) {
        this.starsOfRepo = starsOfRepo;
    }
}
