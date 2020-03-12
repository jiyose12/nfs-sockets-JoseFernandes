package sockets;

import java.util.Collection;

public class Utils { public static String print(Collection<? extends Object> collection) {
    StringBuilder sb = new StringBuilder(); for (Object obj : collection) {
    sb.append(obj.toString()).append(" ");
    } return sb.toString();
}
}

