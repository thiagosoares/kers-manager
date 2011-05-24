package br.com.capanema.kers;

public interface RichSeleniumTest {

    public void startSelenium(String browser);

    public void stopSelenium();

    public String getTestUrl();

}
