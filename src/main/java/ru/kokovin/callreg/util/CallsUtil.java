package ru.kokovin.callreg.util;

import ru.kokovin.callreg.model.Call;
import ru.kokovin.callreg.model.Direction;
import ru.kokovin.callreg.to.CallTo;
import java.util.*;
public class CallsUtil {

    private CallsUtil() {
    }

    public static List<CallTo> getTos(Collection<Call> calls) {
        List<CallTo> list = new ArrayList<>();
        Map<String, List<Call>> operatorsCallMap = new HashMap<>();
        for (Call call : calls) {
            operatorsCallMap.computeIfAbsent(call.getOperator().getcName(), k -> new ArrayList<>());
            operatorsCallMap.get(call.getOperator().getcName()).add(call);
        }
        for (Map.Entry<String, List<Call>> entry : operatorsCallMap.entrySet()) {
            List<Call> operatorCalls = entry.getValue();
            String operatorName = operatorCalls.get(0).getOperator().getFullName();
            CallTo callTo = new CallTo(operatorName, 0, 0);
            for (Call call : operatorCalls) {
                if (call.getDirection() == Direction.IN) {
                    callTo.setInbound(callTo.getInbound()+1);
                } else {
                    callTo.setOutbound(callTo.getOutbound()+1);
                }
            }
            list.add(callTo);
        }
        return list;
    }
}
