package com.virtuasoft.rdu.test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author rdu
 * @since 13.10.2017
 */
@Getter
@RequiredArgsConstructor
public enum Rank {
    ACE(1),
    TOW(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int score;

}
