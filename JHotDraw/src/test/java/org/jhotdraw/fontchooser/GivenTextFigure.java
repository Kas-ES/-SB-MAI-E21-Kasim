/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jhotdraw.fontchooser;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.TextAreaCreationTool;
import org.jhotdraw.draw.TextHolderFigure;
import org.jhotdraw.gui.fontchooser.FontFaceNode;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

import java.awt.*;


/**
 *
 * @author K.E.S
 */
public class GivenTextFigure extends Stage<GivenTextFigure> {
    @ProvidedScenarioState
    protected SVGTextFigure textFigure;

    public GivenTextFigure arrea_withText(){
        textFigure = new SVGTextFigure();
        return self();
    }

}
