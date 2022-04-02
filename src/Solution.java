import multiThread.SearchArray;
import test.CharacterThread;
import test.DigitThread;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        new Thread(new CharacterThread()).start();
        new Thread(new DigitThread()).start();
    }



}






