package com.doumiaotech.chapter3;

import java.util.Random;

import static net.mindview.util.Print.print;

public class E07_CoinFlipping {
    public static void main(String[] args) {
        E07_CoinFlipping.coinFlipping();
    }

    private static void coinFlipping() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            boolean flip = random.nextBoolean();
            print("仍硬币结果:" + (flip ? "正面" : "反面"));
        }

    }
}

/* output:
 * 仍硬币结果:正面
 * 仍硬币结果:反面
 * 仍硬币结果:正面
 * 仍硬币结果:反面
 * 仍硬币结果:正面
 * 仍硬币结果:正面
 * 仍硬币结果:正面
 * 仍硬币结果:正面
 * 仍硬币结果:反面
 * 仍硬币结果:反面
 */
