package org.jhotdraw.fontchooser;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

public class WhenTextFigureisCreated extends Stage<WhenTextFigureisCreated> {

    @ExpectedScenarioState
    protected SVGTextFigure figure;

    public WhenTextFigureisCreated description_inside_of_the_text(){
        figure.setText("Description");
        float newSize = 2f + figure.getFontSize();
        figure.setFontSize(newSize);
        return self();
    }


}
