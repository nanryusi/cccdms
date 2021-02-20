package egovframework.cccdms.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * CCCDMS 메인 화면 컨드롤러
 * Created by ryusi    on 2021-02-06
 */
@Controller
public class cccdmsMainController {

  //메인페이지 호출
  @RequestMapping(value = "/cccdms/main/mainPage.do")
  public String getMainPage(HttpServletRequest request, ModelMap model)
      throws Exception{

    return "main/CccdmsMainView";
  }

//메인페이지 호출
  @RequestMapping(value = "/cccdms/main/samplePage.do")
  public String getSamplePage(HttpServletRequest request, ModelMap model)
      throws Exception{

    return "main/main_sample";
  }
}