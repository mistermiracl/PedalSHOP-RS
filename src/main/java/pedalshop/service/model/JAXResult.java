/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.service.model;

/**
 * Standard result of service call
 * @author User
 */
public class JAXResult {
    private int resultCode;
    private String resultMessage;
    private Object returnValue;

    public JAXResult(int resultCode, String resultMessage, Object returnValue) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.returnValue = returnValue;
    }

    public JAXResult() {
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }
}
