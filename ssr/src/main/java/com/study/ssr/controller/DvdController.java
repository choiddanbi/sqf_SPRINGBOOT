package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DvdController {

    @GetMapping("/dvds") // 이거 해주면 HandlerMapping 도 생성
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사")
                .publisher("테스트 발행사")
                .build();

        Dvd dvd2 = Dvd.builder()
                .title("테스트2")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();

        Dvd dvd3 = Dvd.builder()
                .title("테스트3")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();

        // model'주소'에 넣는거야!
        model.addAttribute(dvd); //객체
        model.addAttribute("names", List.of("김준일", "김준이", "김준삼")); // 리스트-배열 에 값 넣기
        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3)); // 리스트에 객체넣기
        model.addAttribute("title", "테스트 제목"); // key, value - 리터럴


        return "views/dvd_list"; //return 은 view만
    }

   /* @GetMapping("/dvds")
    public ModelAndView dvdListPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/dvd_list");
        return mav;
    }*/

    @ResponseBody // 응답데이터가 바로 return
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list"; // views/dvd_list 문자열 자체로 return
    }


    @ResponseBody // 이걸 써야 dvd객체로 return 가능 // response + return 객체 => json으로 return
    @GetMapping("/dvd")
    public Object getDvd() { // Dvd getDvd() 도 가능
        Dvd dvd = Dvd.builder().title("테스트").producer("테스트 제작사").publisher("테스트 발행사").build();
        Dvd dvd2 = Dvd.builder().title("테스트2").producer("테스트 제작사2").publisher("테스트 발행사2").build();
        Dvd dvd3 = Dvd.builder().title("테스트3").producer("테스트 제작사3").publisher("테스트 발행사3").build();

        return List.of(dvd, dvd2, dvd3);

        //
        // return Dvd.builder().title("테스트").producer("테스트 제작사").publisher("테스트 발행사").build();
    }

}
