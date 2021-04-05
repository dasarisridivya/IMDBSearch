package com.example.test;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.screenshot;
import com.codeborne.selenide.junit.TextReport;

public class ImdbTest {


    @Test
    public void searchImdb() throws InterruptedException {

        open("https://www.imdb.com/");
        String searchWord = "game of thrones";
        $(By.name("q")).setValue(searchWord);
        $(By.id("suggestion-search-button")).click();
        $(By.linkText("Video Game")).click();

        $(By.className("findSearchTerm")).shouldHave(text(searchWord));
        String filename= searchWord+"_"+new Date().getTime();
        String pngFileName = screenshot(filename);

    }
}
