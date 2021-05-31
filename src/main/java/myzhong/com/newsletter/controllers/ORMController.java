package myzhong.com.newsletter.controllers;

import myzhong.com.newsletter.models.Subscriber;
import myzhong.com.newsletter.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class ORMController {
    @Autowired
    private SubscriberRepository subsRepository;

    @GetMapping(path="/subscribe")
    public @ResponseBody String addNewSubscriber(@RequestParam String email
            , @RequestParam String name) {

        Subscriber n = new Subscriber(email, name);
        subsRepository.save(n);
        return name + " (" + email + "), you have subscribed.";
    }

    @GetMapping(path="/unsubscribe")
    public @ResponseBody String removeSubscriber(@RequestParam String email
            , @RequestParam String name) {

        subsRepository.deleteSubscriber(email, name);
        return name + " (" + email + "), you have unsubscribed.";
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Subscriber> getAllSubscriber() {
        return subsRepository.findAll();
    }

}
