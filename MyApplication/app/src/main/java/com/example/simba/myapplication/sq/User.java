package com.example.simba.myapplication.sq;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class User  
{  
    // 主键 id 自增长  
    @DatabaseField(generatedId = true)
    private int id;  
    // 映射  
    @DatabaseField(canBeNull = false)  
    private String username;  
    // 不为空  
    @DatabaseField(canBeNull = false)  
    private String password;  
      
    @DatabaseField(defaultValue = "")  
    private String nickname ;  
      
    public User()  
    {  
        // ORMLite 需要一个无参构造  
    }  
  
    /** 
     * @return the id 
     */  
    public int getId()  
    {  
        return this.id;  
    }  
  
    /** 
     * @param id the id to set 
     */  
    public void setId(int id)  
    {  
        this.id = id;  
    }  
  
    /** 
     * @return the username 
     */  
    public String getUsername()  
    {  
        return this.username;  
    }  
  
    /** 
     * @param username the username to set 
     */  
    public void setUsername(String username)  
    {  
        this.username = username;  
    }  
  
    /** 
     * @return the password 
     */  
    public String getPassword()  
    {  
        return this.password;  
    }  
  
    /** 
     * @param password the password to set 
     */  
    public void setPassword(String password)  
    {  
        this.password = password;  
    }  
  
    
    @Override  
    public String toString()  
    {  
        String text = "";  
  
        text += "\nid = " + id;  
        text += "\nusername = " + username;  
        text += "\npassword = " + password;  
        return text;  
    }  
  
}  