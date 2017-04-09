package com.ssm.mapper;

import com.ssm.model.Kehu;
import com.ssm.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Li on 07/04/2017.
 */

public interface KehuMapper {
    @Autowired
    public Kehu selectKehuByID(String id);
    @Autowired
    public List<Kehu> selectKehus();
    @Autowired
    public void addKehu(Kehu kehu);
    @Autowired
    public void updateKehu(Kehu kehu);
    @Autowired
    public void deleteKehu(int id);
}