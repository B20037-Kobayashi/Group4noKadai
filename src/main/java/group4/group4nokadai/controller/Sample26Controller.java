package group4.group4nokadai.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @RequestMapping("/sample26")をクラスの前につけると，このクラスのすべてのメソッドは/sample26で呼び出されることを表す
 */

@Controller
public class Sample26Controller {

  @GetMapping("/sample26")
  public String sample26() {
    return "sample26.html";
  }

  @PostMapping("/sample27")
  public String sample27(@RequestParam Integer min, @RequestParam Integer max, ModelMap model) {
    int sum = 0;
    ArrayList<Integer> sumRange = new ArrayList<>();
    for (int i = min; i <= max; i++) {
      sum += i;
      sumRange.add(i);
    }
    model.addAttribute("sumRange", sumRange);
    model.addAttribute("sum", sum);

    return "sample26.html";
  }
}
