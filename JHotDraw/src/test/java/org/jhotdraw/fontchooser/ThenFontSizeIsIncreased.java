package org.jhotdraw.fontchooser;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Assert;

public class ThenFontSizeIsIncreased extends Stage<ThenFontSizeIsIncreased> {

    @ExpectedScenarioState
    protected SVGTextFigure figure;

    public ThenFontSizeIsIncreased font_size_is_increased(){
        Assert.assertTrue(figure.getFontSize() == 14f);
        return this;
    }

}
