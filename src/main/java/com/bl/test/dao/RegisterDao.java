package com.bl.test.dao;
import com.bl.test.service.Connector;
import com.bl.test.interfaces.RegisterDaoInterface;
import com.bl.test.model.Registration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao implements RegisterDaoInterface {
    @Override
    public int dataSave(Registration registration) {
        int Status=0;
        try {
            PreparedStatement ps= Connector.getConnection().prepareStatement
                    ("insert into register (username,password,email)values(?,?,?)");
            ps.setString(1,registration.getUsername());
            ps.setString(2,registration.getPassword());
            ps.setString(3,registration.getEmail());
            int i = ps.executeUpdate();
            if (i > 0) {
               Status=1;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Status;
    }
}
