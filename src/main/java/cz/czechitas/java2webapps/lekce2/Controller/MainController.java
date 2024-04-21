package cz.czechitas.java2webapps.lekce2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

//timto krokem jsem vytvorila controller - udelala jsem adresar a v nem klasickou Java tridu a @ je anotace
@Controller
public class MainController {

    //pridavame generovani nahodnych cisel
    private final Random random = new Random();

    //v nasledujicim kroku volam url - "posli mi soubor na adrese xyz"
    //misto index.html se zavola dana adresa
    //springu je jedno jak se to jmenuje, zalezi hlavne na anotaci, ale nazvy jsou pro prehlednost
    @GetMapping("/")
    public ModelAndView hodKostkou() {
        //generovani nahodneho cisla od 1-7
        int nahodneCislo = random.nextInt(1, 7);

        //navratova hodnota je pro spring dulezita, tady vracime sablonu a generujeme z toho html kod
        //sablonu si musime vytvorit, ukladaji se do resources
        //pro sablony pouzivame freemarker (jina moznost je timeleaf)
        //v templates vytvorim file s priponou .ftlh (muzu upravit i klasickej html soubor v podstate jen pridam [#ftl])
        //do hodnot, ktery chci upravovat jsem dala zastupky #{} - sablona jen zobrazuje, logika ma byt v jave, proto pridavame random sem
        ModelAndView result = new ModelAndView("kostka");
        //do sablony muzu poslat vic dat, budeme pracovat s hodnotou a, dosadime za a hodnotu b
        return result.addObject("hozeneCislo", nahodneCislo);
    }
}
