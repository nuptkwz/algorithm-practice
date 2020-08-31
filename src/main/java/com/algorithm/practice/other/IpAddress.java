package com.algorithm.practice.other;

import lombok.extern.slf4j.Slf4j;

/**
 * Description
 * Date 2020/8/30 21:30
 * Created by kwz
 */
@Slf4j
public class IpAddress {

    public static void main(String[] args) {
        String ipSubnetMask = "192.168.1.53/27";
        String[] split = ipSubnetMask.split("/");
        String ip = split[0];
        String subnetMask = split[1];

        Integer subNetMaskInt = Integer.valueOf(subnetMask);
        int net = subNetMaskInt / 8;
        int i1 = subNetMaskInt % 8;
    }
}
