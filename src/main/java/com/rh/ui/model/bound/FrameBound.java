package com.rh.ui.model.bound;

import com.rh.ui.util.IInit;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * 游戏窗口的边界
 */
public class FrameBound implements IInit {

    private ScreenBound screenBound;
    private GameDesktopBound gameDesktopBound;

    /**
     * x
     */
    public int getX() {
        return (screenBound.getW() - this.getW()) / 2;
    }
    /**
     * y
     */
    public int getY() {
        return (screenBound.getH() - this.getH()) / 2;
    }
    /**
     * w
     */
    public int getW() {
        return gameDesktopBound.getFullW();
    }
    /**
     * h
     */
    public int getH() {
        return gameDesktopBound.getFullH();
    }

    public void init(@NonNull ScreenBound screenBound, @NonNull GameDesktopBound gameDesktopBound) {
        this.screenBound = screenBound;
        this.gameDesktopBound = gameDesktopBound;
    }

    public List<Integer> getBound() {
        return Arrays.asList(getX(), getY(), getW(), getH());
    }
}
