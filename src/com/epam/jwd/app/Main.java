package com.epam.jwd.app;

import com.epam.jwd.model.Town;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {


    public static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Town town1 = new Town("Minsk", 348.84, 1067, 2018281, "Belarus");
        Town town2 = new Town("Hrodno", 142.11, 1128, 356900, "Belarus");
        Town town3 = new Town("Brest", 146.12, 1017, 339700, "Belarus");

        Town[] arrayOfTowns = new Town[]{town1, town2, town3};

        logger.info("array");
        for (int i = 0; i < arrayOfTowns.length; i++) {

            System.out.println(arrayOfTowns[i]);
        }
    }
}
