package egovframework.cccdms.cprcss.domain;

import lombok.Data;

/**
 * CplanMnDtlVo : 월간보육계획안 상세 Vo
 * Created by ryusi   on 2021-03-19.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Data
public class CplanMnDtlVo extends CplanMnVo {

    //승인상태
    private String appStat;
    //승인상태 한글명
    private String appStatNm;
    //사용유무
    private String usYn;
    //최초등록일
    private String regDt;
    //최초등록인 아이디
    private String regId;
    //최초등록인명
    private String regNm;
    //최종수정일
    private String modDt;
    //최종수정인 아이디
    private String modId;
    //최종수정인명
    private String modNm;
}
