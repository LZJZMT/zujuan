package com.zujuan.vo;

import com.zujuan.pojo.Examination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/15 17:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationVO extends Examination {
    private String zsdname;
    private String typeString;
    private String degreeString;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

}
