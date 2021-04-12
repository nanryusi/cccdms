/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.hltSft.domain;

import egovframework.cccdms.common.model.CommonVO;
import lombok.Data;

/**
 * ListVo : 연간보육계획안 리스트용 Vo
 * Created by ryusi   on 2021-02-23.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Data
public class SftRptListVo extends CommonVO {

    //검색조건 : 년도
    private String searchYr;

    //학교코드
    private String schoolCode;
    //순번
    private String idx;
    //타이틀
    private String title;
    //컨텐츠
    private String contents;
    //수정일
    private String regDt;
    //수정자 아이디
    private String regId;
    //최종변경일
    private String modDt;
    //최종변경자 아이디
    private String modId;
}
