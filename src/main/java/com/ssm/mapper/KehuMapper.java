package com.ssm.mapper;

import com.ssm.model.Kehu;
import com.ssm.model.Teacher;

import java.util.List;

/**
 * Created by Li on 07/04/2017.
 */
public interface KehuMapper {

    public Kehu selectKehuByID(int id);
    public List<Kehu> selectKehus();

}