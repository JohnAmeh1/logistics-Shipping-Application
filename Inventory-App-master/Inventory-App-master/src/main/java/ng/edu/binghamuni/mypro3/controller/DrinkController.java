package ng.edu.binghamuni.mypro3.controller;


import ng.edu.binghamuni.mypro3.domain.Drink;
import ng.edu.binghamuni.mypro3.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DrinkController {
    @Autowired
    DrinkService drinkService;
    @GetMapping("/order")
    public String homepage(Model model){
        model.addAttribute("drinks",drinkService.getAllDrinks());
        return "orders";
    }
    @GetMapping("/showNewDrinkForm")
    public String showNewDrinkForm(Model model){
        Drink drink =new Drink();
        model.addAttribute("drink", drink);
        model.addAttribute("nextPage","Place Order");
        return "new_drink";

    }
    @PostMapping("/saveDrink")
    public String saveDrink(@ModelAttribute("drink") Drink drink, RedirectAttributes redirectAttributes){
        drinkService.saveDrink(drink);
        redirectAttributes.addFlashAttribute("message", "Order Is Been Processed");
        redirectAttributes.addFlashAttribute("color", "success");

        return "redirect:/showNewDrinkForm";
    }

    @GetMapping("deleteDrink/{id}")
    public String deleteDrink(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            drinkService.deleteDrink(id);
            redirectAttributes.addFlashAttribute("message", "Order Deleted Successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");
        }

        return "redirect:/order";
    }
}



