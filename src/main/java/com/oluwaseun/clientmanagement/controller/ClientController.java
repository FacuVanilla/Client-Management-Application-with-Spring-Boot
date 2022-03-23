package com.oluwaseun.clientmanagement.controller;


import com.oluwaseun.clientmanagement.entity.Client;
import com.oluwaseun.clientmanagement.service.impl.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/clients/new")
    public String createClientForm(Model model) {

        // create client object to hold client form data
        Client client = new Client();
        model.addAttribute("client", client);
        return "create_client";

    }

    @PostMapping("/clients")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "edit_client";
    }

    @PostMapping("/clients/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("client") Client client,
                                Model model) {

        // get client from database by id
        Client existingClient = clientService.getClientById(id);
        existingClient.setId(id);
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setEmail(client.getEmail());

        // save updated client object
        clientService.updateClient(existingClient);
        return "redirect:/clients";
    }

    // handler method to handle delete client request

    @GetMapping("/clients/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return "redirect:/clients";
    }

}

