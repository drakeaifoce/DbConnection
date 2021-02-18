package com.company.repositories.interfaces;

import com.company.entities.Train;
import com.company.entities.Locomotive;

import java.util.List;

public interface ILocomotiveRepository
{
    boolean createLocomotive(Locomotive locomotive);
    Locomotive getLocomotive(int id);
    List<Locomotive> getAllLocomotives();
}
