package org.launchcode.hellospring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by JLH
 */
@Controller
public class HelloController<pass> {
        // Create a HashMap country to greeting
    public HashMap<String, String> getGreeting() {
        HashMap<String, String> greetMapping = new HashMap<String, String>();

        // Add key-value pairs to HashMap
        greetMapping.put("english","Hello");
        greetMapping.put("spanish","Hola");
        greetMapping.put("french","Salut");
        greetMapping.put("german","Hallo");
        greetMapping.put("italian","Ciao");

        return greetMapping;
        }

   /* @RequestMapping(value="hello")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    } */

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<p>Please your name and select a language</p>" +
                "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<br><br>" +
                "<select name='choices'>" +
                    "<option value='english'>English</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='german'>German</option>" +
                    "<option value='italian'>Italian</option>" +
                "</select>" +
                "<br><br>" +

        //"<input type='text' name='language' />" +
                "<input type='submit' value='Greet Me' />" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(HttpServletRequest request) {

        // Get parameters from form
        String name = request.getParameter("name");
        String language = request.getParameter("choices");
        String var = getGreeting().get(language);

        return var + " " + name;
    }

   /* @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");

        return name;
        } */



   /* @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloURL(@PathVariable String name) {
        return  "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    public String goodbye() {
        return "redirect:/";
    } */
}
