package com.rh.ui.model;

import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SnakerBodyList {

    private final List<SnakerBody> bodyList = new ArrayList<>(10);
    private final Map<String, Integer> placeMap = new HashMap();
    private SnakerBody endBody;

    public void add(SnakerBody body) {
        if (body == null) {
            return;
        }

        body.setPrevBody(this.getEndBody());
        body.setInitPlace();

        bodyList.add(body);
        Integer value = placeMap.put(body.getX() + "_" + body.getY(), bodyList.size() - 1);
        this.checkIsFormingARing(value);
        this.endBody = body;
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

    /**
     * 改变方向<br>
     * 不能反向移动
     */
    public void changeDirection() {
        SnakerHead headBody = this.getSnakerHead();
        if (headBody == null || headBody.checkIsReverseMove()) {
            return;
        }

        headBody.changeDirection();
    }

    /**
     * 得到蛇头
     */
    public SnakerHead getSnakerHead() {
        if (CollectionUtils.isEmpty(bodyList)) {
            return null;
        }

        SnakerBody snakerBody = bodyList.get(0);

        return snakerBody instanceof SnakerHead ? (SnakerHead) snakerBody : null;
    }

    /**
     * 设置下一个移动方向
     */
    public void setNextDirection(Direction direction) {
        SnakerHead snakerHead = this.getSnakerHead();
        if (snakerHead != null && direction != null) {
            snakerHead.setNextDirection(direction);
        }
    }

    /**
     * 是否变成了一个环<br>
     * 不能吃到自己
     */
    public void checkIsFormingARing(Integer value) {
        if (value == null) {
            System.out.println("value is null");
            return;
        }

        for (int i = bodyList.size() - 1; i < value; i--) {
            SnakerBody snakerBody = bodyList.get(i);
            if (snakerBody == null) {
                System.out.println("body is null");
                break;
            }

            SnakerBody remove = bodyList.remove(i);
            System.out.println("remove body" + remove);
            placeMap.remove(snakerBody.getX() + "_" + snakerBody.getY());
        }
    }
}
