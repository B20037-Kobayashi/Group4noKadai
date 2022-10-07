package group4.group4nokadai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sample21Controller {

  @GetMapping("/sample21")
  public String sample21() {
    return "sample21.html";
  }

  @GetMapping("/sample22/{param1}/{param2}")
  public String sample22(@PathVariable String param1, @PathVariable String param2, ModelMap model) {
    int tasu = Integer.parseInt(param1);// param1が文字列なので，parseIntでint型の数値に変換する
    int tasareru = Integer.parseInt(param2);
    int tasuResult = tasu + tasareru;

    // ModelMap型変数のmodelにtasuResult1という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    model.addAttribute("tasuResult1", tasuResult);
    return "sample21.html";

  }

  /**
   * クエリパラメータの引数2つを受け付ける URLでの?のあとのパラメータ名とjavaメソッドの引数名は同じであることが望ましい(別にする方法は一応ある)
   * 引数をStringとして受け取ってparseIntする以外にもInteger(intのラッパークラス)クラスの変数として受け取ってそのまま加算する方法もある
   *
   * @param tasu1
   * @param tasu2
   * @param model
   * @return
   *
   *         RequestParamアノテーションを指定すると、URLに含まれるクエリパラメータや、メッセージボディーに含まれるポストパラメータを受け取ることができます
   */

  @GetMapping("/sample23")
  public String sample23(@RequestParam Integer tasu1, @RequestParam Integer tasu2, ModelMap model) {
    int tasuResult = tasu1 + tasu2;
    model.addAttribute("tasuResult2", tasuResult);
    // ModelMap型変数のmodelにtasuResult2という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    return "sample21.html";

  }

  @GetMapping("/sample24")
  public String sample24() {
    return "sample24.html";
  }

  /**
   * POSTを受け付ける場合は@PostMappingを利用する /sample25へのPOSTを受け付けて，FormParamで指定された変数(input
   * name)をsample25()メソッドの引数として受け取ることができる
   *
   * @param kakeru1
   * @param kakeru2
   * @param model
   * @return
   */

  @PostMapping("/sample25")
  public String sample25(@RequestParam Integer kakeru1, @RequestParam Integer kakeru2, ModelMap model) {
    int kakeruResult = kakeru1 * kakeru2;
    model.addAttribute("kakeruResult", kakeruResult);
    return "sample24.html";
  }

}
