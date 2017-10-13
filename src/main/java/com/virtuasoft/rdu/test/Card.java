package com.virtuasoft.rdu.test;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author rdu
 * @since 13.10.2017
 */
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Card {

    private final Suit suit;
    private final Rank rank;

}
