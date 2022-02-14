package com.example.mythirdproject;

import com.example.mythirdproject.models.Hobby;
import com.example.mythirdproject.models.Pet;
import com.example.mythirdproject.models.PetType;
import com.example.mythirdproject.models.Language;
import com.example.mythirdproject.models.Education;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CVController {

  @GetMapping("/contact")
  public String handleContactSubmission(
      Model model,
      @RequestParam(name = "userName", required = false) String userName,
      @RequestParam(name = "emailAddress", required = true) String email,
      @RequestParam(name = "messageType", required = false) String messageType,
      @RequestParam(name = "message", required = false) String message
  ){
    System.out.println("new message from " + userName + email + " " + messageType + " " + message);

    model.addAttribute("name", userName);
    model.addAttribute("email", email);
    model.addAttribute("messageType", messageType);

    return "success";
  }

  @GetMapping("/examples")
  public String showExamplePage(){
    System.out.println("user is visiting example page");
    return "examples";
  }

  @GetMapping("/profile")
  public String showProfile(Model model){
    model.addAttribute("userName", "Kristina");
    model.addAttribute("location", "Riga");
    model.addAttribute("age", 24);

    Pet myPet = new Pet("Biskis",1, PetType.CAT);
    model.addAttribute("myPet", myPet);

    List<Hobby> hobbies = new ArrayList<>();
    hobbies.add(new Hobby("running"));
    hobbies.add(new Hobby("sleeping"));
    hobbies.add(new Hobby("staring at computer"));
    hobbies.add(new Hobby("fixing bugs"));
    model.addAttribute("myHobbies", hobbies);

    return "profile";
  }

  @GetMapping("/superPowers")
  public String showSuperPower(Model model){
    List<String> superPowers = new ArrayList<>();
    superPowers.add("Walking");
    superPowers.add("Sleeping");
    superPowers.add("Eating");
    superPowers.add("Talking");
    model.addAttribute("superPowers", superPowers);
    return "superpowers";
  }

  @GetMapping("/education")
  public String showEducation(Model model){
    System.out.println("A user is visiting an education page.");
    return "education";
  }

  @GetMapping("/work related skills")
  public String showWorkRelatedSkills(){
    System.out.println("A user is visiting the work related skills page.");
    return "work related skills";
  }

  @GetMapping("/languages")
  public String showLanguages(Model model){
    List<String> languages = new ArrayList<>();
    languages.add("Russian");
    languages.add("Latvian");
    languages.add("English");
   model.addAttribute("languages",languages);
    return "languages";
  }
}
