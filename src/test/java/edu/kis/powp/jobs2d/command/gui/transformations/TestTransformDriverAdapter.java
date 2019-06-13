package edu.kis.powp.jobs2d.command.gui.transformations;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.features.TransformFeature;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTransformDriverAdapter {
    TransformDriverAdapter transformDriverAdapter;
    @BeforeEach
    public void init(){
        TransformFeature.setupTransformManager();
        TransformManager transformManager = TransformFeature.getTransformManager();
        transformManager.UpdateTransform(20,0,90);
        transformDriverAdapter = new TransformDriverAdapter(new DrawPanelController(), LineFactory.getBasicLine(), "smth");
    }
    @Test
    void testCalculateAngleStartX(){
        transformDriverAdapter.setPosition(0, 0);
        transformDriverAdapter.operateTo(100, 0);
        assertEquals(20,transformDriverAdapter.line.getStartCoordinateX());
    }
    @Test
    void testCalculateAngleEndX(){
        transformDriverAdapter.setPosition(0, 0);
        transformDriverAdapter.operateTo(100, 0);
        assertEquals(20,transformDriverAdapter.line.getEndCoordinateX());
    }
    @Test
    void testCalculateAngleStartY(){
        transformDriverAdapter.setPosition(0, 0);
        transformDriverAdapter.operateTo(100, 0);
        assertEquals(0,transformDriverAdapter.line.getStartCoordinateY());
    }
    @Test
    void testCalculateAngleEndY(){
        transformDriverAdapter.setPosition(0, 0);
        transformDriverAdapter.operateTo(100, 0);
        assertEquals(100,transformDriverAdapter.line.getEndCoordinateY());
    }
}
