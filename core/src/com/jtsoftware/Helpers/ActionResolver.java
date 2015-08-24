package com.jtsoftware.Helpers;

/**
 * Created by Jonty on 23/08/2015.
 */
public interface ActionResolver {

    public void sendEmail();
    public boolean getSignedInGPGS();
    public void loginGPGS(); //Google Play Google Services
    public void submitScoreGPGS(int score);
    public void unlockAchievementsGPGS(String achievementsId);
    public void getLeaderboardGPGS();
    public void getAchievementsGPGS();
    public void showBannerAd();
    public void hideBannerAd();
    public void showAds(boolean show);
    public void loadInterstital();
    public void showInterstital();

}
