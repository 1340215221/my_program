package com.rh.ui.model;

import lombok.Getter;

/**
 * 贪吃蛇的方向
 */
@Getter
public enum Direction {
    DOWN("down"){
        @Override
        public boolean checkIsOpposite(Direction direction) {
            return UP.equals(direction);
        }

        @Override
        public void moveForward(SnakerBody snakerBody) {
            int newY = snakerBody.getY() + SnakerBody.BODY_LENG;
            snakerBody.setY(newY);
        }

        @Override
        public void setNextBodyPlace(SnakerBody snakerBody, SnakerBody prevBody) {
            int newY = prevBody.getY() - SnakerBody.BODY_LENG;
            snakerBody.setX(prevBody.getX());
            snakerBody.setY(newY);
        }
    },
    UP("up"){
        @Override
        public boolean checkIsOpposite(Direction direction) {
            return DOWN.equals(direction);
        }

        @Override
        public void moveForward(SnakerBody snakerBody) {
            int newY = snakerBody.getY() - SnakerBody.BODY_LENG;
            snakerBody.setY(newY);
        }

        @Override
        public void setNextBodyPlace(SnakerBody snakerBody, SnakerBody prevBody) {
            int newY = prevBody.getY() + SnakerBody.BODY_LENG;
            snakerBody.setX(prevBody.getX());
            snakerBody.setY(newY);
        }
    },
    LEFT("left"){
        @Override
        public boolean checkIsOpposite(Direction direction) {
            return RIGHT.equals(direction);
        }

        @Override
        public void moveForward(SnakerBody snakerBody) {
            int newX = snakerBody.getX() - SnakerBody.BODY_LENG;
            snakerBody.setX(newX);
        }

        @Override
        public void setNextBodyPlace(SnakerBody snakerBody, SnakerBody prevBody) {
            int newX = prevBody.getX() + SnakerBody.BODY_LENG;
            snakerBody.setX(newX);
            snakerBody.setY(prevBody.getY());
        }
    },
    RIGHT("right"){
        @Override
        public boolean checkIsOpposite(Direction direction) {
            return LEFT.equals(direction);
        }

        @Override
        public void moveForward(SnakerBody snakerBody) {
            int newX = snakerBody.getX() + SnakerBody.BODY_LENG;
            snakerBody.setX(newX);
        }

        @Override
        public void setNextBodyPlace(SnakerBody snakerBody, SnakerBody prevBody) {
            int newX = prevBody.getX() - SnakerBody.BODY_LENG;
            snakerBody.setX(newX);
            snakerBody.setY(prevBody.getY());
        }
    },
    ;

    String value;

    Direction(String value) {
        this.value = value;
    }

    /**
     * 相反
     */
    public boolean checkIsOpposite(Direction direction) {
        return true;
    }

    /**
     * 改变方向
     */
    public void moveForward(SnakerBody snakerBody) {
    }

    /**
     * 设置新的尾巴的位置
     */
    public void setNextBodyPlace(SnakerBody snakerBody, SnakerBody prevBody) {
    }
}
