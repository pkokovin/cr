package ru.kokovin.callreg.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kokovin.callreg.exception.ResourceNotFoundException;
import ru.kokovin.callreg.model.Call;
import ru.kokovin.callreg.model.Operator;
import ru.kokovin.callreg.service.CallService;
import ru.kokovin.callreg.service.OperatorService;
import ru.kokovin.callreg.to.CallTo;
import ru.kokovin.callreg.util.CallsUtil;
import ru.kokovin.callreg.web.SecurityUtil;

import static ru.kokovin.callreg.util.DateTimeUtil.*;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("call")
public class CallController {
    private static final Logger LOG = LoggerFactory.getLogger(CallController.class);

    @Autowired
    private CallService callService;

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/list")
    public String listCalls(Model model) {
        List<Call> calls = callService.listAll();
        model.addAttribute("calls", calls);
        return "listCalls";
    }

    @GetMapping("/updateform")
    public String showFormForUpdate(@RequestParam("callId") int id, Model model) throws ResourceNotFoundException {
        Call call = callService.getById(id);
        model.addAttribute("call", call);
        return "callForm";
    }

    @GetMapping("/showform")
    public String showFormForAdd(Model model) {
        LOG.debug("inside showform callForm handler method");
        Call call = new Call();
        model.addAttribute("call", call);
        return "callForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("call") Call call) {
        LOG.debug("inside save operatorForm handler method");
        if (call.isNew()) {
            Operator operator = operatorService.get(SecurityUtil.authUserId());
            LocalDateTime register = LocalDateTime.now();
            call.setRegistered(register);
            call.setOperator(operator);
            callService.save(call);
        } else {
            Call original = callService.getById(call.getId());
            original.setCustomer(call.getCustomer());
            original.setComment(call.getComment());
            callService.save(original);
        }
        return "redirect:/call/list";
    }

    @GetMapping("/listcomputed")
    public String listComputed(HttpServletRequest request, Model model) {
        LocalDateTime start = parseLocalDateTime(request.getParameter("start"));
        LocalDateTime end = parseLocalDateTime(request.getParameter("end"));
        List<CallTo> callTos = CallsUtil.getTos(callService.getBetween(start, end));
        model.addAttribute("callTos", callTos);
        return "statCalls";
    }

}
