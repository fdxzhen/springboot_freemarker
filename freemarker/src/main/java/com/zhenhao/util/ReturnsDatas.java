package com.zhenhao.util;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Map;

@SuppressWarnings("serial")
public class ReturnsDatas implements Serializable {
    private static final  String SUCCESS = "success";
    private static final  String ERROR = "error";
    private static final  String WARNING = "warning";

    private String statusCode = "200";
    private String status;
    private String message;

    private transient Object data;
    private transient Object info;
    private transient Object total;
    private transient Object infoData;
    private transient Map map;
    private transient Object queryBean;

    public ReturnsDatas() {
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public ReturnsDatas(String status) {
        this.status = status;
    }

    public static ReturnsDatas getSUCCESSReturnsDatas() {
        return new ReturnsDatas(ReturnsDatas.SUCCESS);
    }

    public static ReturnsDatas getERRORReturnsDatas() {
        return new ReturnsDatas(ReturnsDatas.ERROR);
    }

    public static ReturnsDatas getWARNINGReturnsDatas() {
        return new ReturnsDatas(ReturnsDatas.WARNING);
    }

    public ReturnsDatas(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ReturnsDatas(String errCode, String status, String message) {
        this.status = status;
    }

    public String getErrorCodeMessage(String errCode){
        String _message = null;
       return _message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String errCode,String message) {

        String errmsg = getErrorCodeMessage(errCode);
        if(StringUtils.isEmpty(errmsg)){
            errmsg = message;
        }
        this.message = errmsg+"("+errCode+")";
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

    public Object getInfoData() {
        return infoData;
    }

    public void setInfoData(Object infoData) {
        this.infoData = infoData;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Object getQueryBean() {
        return queryBean;
    }

    public void setQueryBean(Object queryBean) {
        this.queryBean = queryBean;
    }
}
