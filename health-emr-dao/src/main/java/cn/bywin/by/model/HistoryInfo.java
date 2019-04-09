package cn.bywin.by.model;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2019/04/09
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryInfo implements Serializable {
    private Long id;

    private String pidencrypt;

    private String historyinfo;

    private String dataversion;

    private Date dataupdatetime;

    private static final long serialVersionUID = 1L;
}