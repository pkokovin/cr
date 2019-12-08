package ru.kokovin.callreg.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kokovin.callreg.exception.ResourceNotFoundException;
import ru.kokovin.callreg.model.Operator;
import ru.kokovin.callreg.service.OperatorService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("operator")
public class OperatorController {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorController.class);
    @Autowired
    private OperatorService operatorService;

    @GetMapping("/list")
    public String listOperators(Model model) {
        List<Operator> operators = operatorService.list();
        model.addAttribute("operators", operators);
        return "listOperators";
    }

    @GetMapping("/updateform")
    public String showFormForUpdate(@RequestParam("operatorId") int id, Model model) throws ResourceNotFoundException {
        Operator operator = operatorService.get(id);
        model.addAttribute("operator", operator);
        return "operatorForm";
    }

    @GetMapping("/delete")
    public String deleteOperator(@RequestParam("operatorId")int id) throws ResourceNotFoundException {
        operatorService.delete(id);
        return "redirect:/operator/list";
    }

    @GetMapping("/showform")
    public String showFormForAdd(Model model) {
        LOG.debug("inside show operatorForm handler method");
        Operator operator = new Operator();
        model.addAttribute("operator", operator);
        return "operatorForm";
    }

    @PostMapping("/save")
    public String saveOperator(@ModelAttribute("operator") Operator operator) {
        operatorService.save(operator);
        return "redirect:/operator/list";
    }

    @PostMapping("")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        SecurityUtil.setAuthUserId(userId);
        return "redirect:/call/list";
    }
}
