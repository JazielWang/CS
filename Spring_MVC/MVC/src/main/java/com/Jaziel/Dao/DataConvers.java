package com.Jaziel.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王杰
 * @time 2020/10/14 16:23
 */
public class DataConvers {
    public Date conversion(String datastr){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = dateFormat.parse(datastr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
