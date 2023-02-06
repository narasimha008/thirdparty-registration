package com.syncronys.registration.tpr.controller;

import com.syncronys.registration.tpr.dto.ClientDto;
import com.syncronys.registration.tpr.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    // handler method to handle user registration request
    @GetMapping("client-register")
    public String showRegistrationForm(Model model) {
        ClientDto client = new ClientDto();
        model.addAttribute("client", client);
        return "client-register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/client/save")
    public String registration(@Valid @ModelAttribute("client") ClientDto client,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("client", client);
            return "client-register";
        }
        try {
            clientService.saveClient(client);
        } catch (IllegalArgumentException e) {
            return "redirect:/client-register?error=" + e.getMessage();
        } catch (Exception e) {
            return "redirect:/client-register?error=" + e.getMessage();
        }
        return "redirect:/client-register?success";
    }

    @GetMapping("/clients")
    public String listRegisteredUsers(Model model) {
        List<ClientDto> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/client-info")
    public String clientInfo(Model model, @RequestParam("clientId") String clientId) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(Long.valueOf(clientId));
        ClientDto client = clientService.findByClient(clientDto);
        client.setBtnName("Approved".equals(client.getStatus()) ? "Deny" : "Approve");
        client.setStatus("Approved".equals(client.getStatus()) ? "Deny" : "Approved");
        model.addAttribute("client", client);
        return "client-info";
    }

    @PostMapping("/client/update")
    public String update(@ModelAttribute("client") ClientDto client, Model model) {
        try {
            clientService.updateClient(client);
            model.addAttribute("client", client);
        } catch (Exception e) {
            return "redirect:/client-info?error=" + e.getMessage() + "&clientId=" + client.getId();
        }
        return "redirect:/client-info?success" + "&clientId=" + client.getId();
    }
}
