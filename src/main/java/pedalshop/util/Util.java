/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.util;

import java.util.ResourceBundle;

/**
 *
 * @author User
 */
public final class Util {
    
    //RESULT CODES
    public static final int RESULT_CODE_OK;
    public static final int RESULT_CODE_WARNING;
    public static final int RESULT_CODE_ERROR;
    
    //STATE CODES
    public static final String DATABASE_NOT_FOUND_CODE;
    public static final String DATABASE_CONNECTION_REFUSED_CODE;
    //DDL OPERATIONS
    public static final String CONNECTING_TO_DATABASE;
    public static final String CREATING_SCHEMA;
    public static final String CONNECTION_SUCCESS;
    
    //DML OPERATIONS
    public static final String RESULT_INSERT_SUCCESS;
    public static final String RESULT_UPDATE_SUCCESS;
    public static final String RESULT_DELETE_SUCCESS;
    public static final String RESULT_SELECT_SUCCESS;
    
    //ERROR MESSAGES
    public static final String DATABASE_CONNECTION_ERROR;
    public static final String DATABASE_NOT_FOUND;
    public static final String DATABASE_ERROR;
    public static final String IO_ERROR;
    
    static {
        //THIS READS FROM THE MAVEN RESOURCES FOLDER SO, WE MUST NOT USE THE FILE EXTENSION OR ANY PATH PREFIX
        ResourceBundle properties = ResourceBundle.getBundle("config");
        RESULT_CODE_OK = Integer.parseInt(properties.getString("RESULT_CODE_OK"));
        RESULT_CODE_WARNING = Integer.parseInt(properties.getString("RESULT_CODE_WARNING"));
        RESULT_CODE_ERROR = Integer.parseInt(properties.getString("RESULT_CODE_ERROR"));
        
        DATABASE_NOT_FOUND_CODE = properties.getString("DATABASE_NOT_FOUND_CODE");
        DATABASE_CONNECTION_REFUSED_CODE = properties.getString("DATABASE_CONNECTION_REFUSED_CODE");
                
        CONNECTING_TO_DATABASE = properties.getString("CONNECTING_TO_DATABASE");
        CREATING_SCHEMA = properties.getString("CREATING_SCHEMA");
        CONNECTION_SUCCESS = properties.getString("CONNECTION_SUCCESS");
        
        RESULT_INSERT_SUCCESS = properties.getString("RESULT_INSERT_SUCCESS");
        RESULT_UPDATE_SUCCESS = properties.getString("RESULT_UPDATE_SUCCESS");
        RESULT_DELETE_SUCCESS = properties.getString("RESULT_DELETE_SUCCESS");
        RESULT_SELECT_SUCCESS = properties.getString("RESULT_SELECT_SUCCESS");
        
        DATABASE_CONNECTION_ERROR = properties.getString("DATABASE_CONNECTION_ERROR");
        DATABASE_ERROR = properties.getString("DATABASE_ERROR");
        DATABASE_NOT_FOUND = properties.getString("DATABASE_NOT_FOUND");
        
        IO_ERROR = properties.getString("IO_ERROR");
    }
    
    private Util(){
    }
}
