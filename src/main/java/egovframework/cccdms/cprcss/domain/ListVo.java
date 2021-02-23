/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * ListVo : 연간보육계획안 리스트용 Vo
 * Created by ryusi   on 2021-02-23.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Getter
@Setter
public class ListVo {

    //게시판 번호
    private int num;
    //제목 타이틀
    private String title;
    //부제 서브타이틀
    private String subTitle;
    //작성자
    private String user;
    //최초작성일
    private LocalDateTime c_date;
}
