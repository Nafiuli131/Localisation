package com.example.localisation;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
public class LocalizationController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/page")
    public String index() {
        return "index";
    }

    @GetMapping("/updateLocale")
    @ResponseBody
    public Map<String, String> updateLocale(@RequestParam String lang) {
        Locale newLocale = new Locale(lang);
        LocaleContextHolder.setLocale(newLocale);
        Map<String, String> response = new HashMap<>();
        response.put("greeting", messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale()));
        return response;
    }

}
