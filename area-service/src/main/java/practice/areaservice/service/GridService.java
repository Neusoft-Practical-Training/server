package practice.areaservice.service;

import practice.entity.Grid;

import java.util.List;

public interface GridService {
    List<Grid> getGrids();

    Grid getGrid(Integer id);

    Integer addGrid(Grid grid);

    Integer updateGrid(Grid grid);

    Integer deleteGrid(Integer id);
}
