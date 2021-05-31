package myzhong.com.newsletter.controllers;

import myzhong.com.newsletter.models.Subscriber;
import myzhong.com.newsletter.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeSubscriberController {
    @Autowired
    private SubscriberRepository subsRepository;

    @GetMapping("/")
    public String showSubscriber(Model model) {
        model.addAttribute("subscriber", new Subscriber()); // New Subscriber to add
        model.addAttribute("subscribers", subsRepository.findAll());
        return "subscriber";
    }

    @PostMapping("/subscribe")
    public String addSubscriber(@ModelAttribute("subscriber") Subscriber subscriber){
        subsRepository.save(subscriber);
        return "subscribed";
    }

    @PostMapping("/unsubscribe")
    public String removeSubscriber(@ModelAttribute("subscriber") Subscriber subscriber){
        subsRepository.deleteSubscriber(subscriber.getEmail(), subscriber.getName());
        return "unsubscribed";
    }

}

