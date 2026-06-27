package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    // ① フォーム表示
	@GetMapping("/form")
	public String form(Model model) {

	    if (!model.containsAttribute("contactForm")) {
	        model.addAttribute("contactForm", new ContactForm());
	    }

	    return "contactFormView";
	}
    // ② 確認画面
    @PostMapping("/confirm")
    public String confirm(
            @Validated  ContactForm contactForm,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {

        System.out.println(result.hasErrors());
        System.out.println(result.getAllErrors());    	
    	
        // NG → /formへリダイレクト（エラー表示）
        if (result.hasErrors()) {

            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.contactForm",
                    result
            );
            redirectAttributes.addFlashAttribute("contactForm", contactForm);

            return "redirect:/form";
        }

        // OK → 確認画面表示（/confirmのまま）
        return "confirmView";
    }
}