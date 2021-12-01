package org.jhotdraw.fontchooser;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class FontSizeIncrease extends
        ScenarioTest<GivenTextFigure, WhenTextFigureisCreated, ThenFontSizeIsIncreased> {

    @Test
    public  void font_has_been_increased() {
        given().arrea_withText();
        when().description_inside_of_the_text();
        then().font_size_is_increased();
    }
}
