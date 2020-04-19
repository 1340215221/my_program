package com.rh.ui.model;

import com.rh.ui.exception.SnakerException;
import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.rh.ui.model.SnakerBody.Direction.DOWN;
import static com.rh.ui.model.SnakerBody.Direction.LEFT;
import static com.rh.ui.model.SnakerBody.Direction.RIGHT;
import static com.rh.ui.model.SnakerBody.Direction.UP;

public class SnakerBodyList {

    private static final Integer BODY_W = 30;
    private static final Integer BODY_H = 30;

    private final List<SnakerBody> bodyList = new ArrayList<>(3);
    private SnakerBody endBody;

    public void add(SnakerBody body) {
        if (body == null) {
            return;
        }

        this.bodyPlace((x, y) -> {
            body.setX(x);
            body.setY(y);
        });

        bodyList.add(body);
        body.setNextBody(endBody);
        this.endBody = body;
    }

    private void bodyPlace(@NonNull PlaceConsumer placeConsumer) {
        SnakerBody endBody = this.getEndBody();

        if (endBody == null) {
            placeConsumer.set(Snaker.SNAKER_BODY_INIT_PLACE_X, Snaker.SNAKER_BODY_INIT_PLACE_Y);
            return;
        }

        String direction = endBody.getDirection();
        if (UP.equals(direction)) {
            placeConsumer.set(endBody.getX(), endBody.getY() + BODY_H);
            return;
        }
        if (DOWN.equals(direction)) {
            placeConsumer.set(endBody.getX(), endBody.getY() - BODY_H);
            return;
        }
        if (LEFT.equals(direction)) {
            placeConsumer.set(endBody.getX() + BODY_W, endBody.getY());
            return;
        }
        if (RIGHT.equals(direction)) {
            placeConsumer.set(endBody.getX() - BODY_W, endBody.getY());
            return;
        }

        throw new SnakerException("增加尾巴时, 没有找到位置");
    }

    public SnakerBody getEndBody() {
        if (endBody != null) {
            return endBody;
        }

        if (CollectionUtils.isEmpty(bodyList)) {
            return null;
        }

        endBody = bodyList.get(bodyList.size() - 1);
        return endBody;
    }

    public void forEach(@NonNull Consumer<SnakerBody> bodyConsumer) {
        bodyList.forEach(bodyConsumer);
    }

    public void changeDirection(String direction) {
        SnakerHead headBody = this.getSnakerHead();
        if (headBody == null || StringUtils.isBlank(direction)) {
            return;
        }

        headBody.setDirection(direction);
    }

    /**
     * 得到蛇头
     */
    private SnakerHead getSnakerHead() {
        if (CollectionUtils.isEmpty(bodyList)) {
            return null;
        }

        SnakerBody snakerBody = bodyList.get(0);

        return snakerBody instanceof SnakerHead ? (SnakerHead) snakerBody : null;
    }

    private interface PlaceConsumer { void set(Integer x, Integer y); }
}
