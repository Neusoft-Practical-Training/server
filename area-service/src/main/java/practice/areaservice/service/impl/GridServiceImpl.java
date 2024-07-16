package practice.areaservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.areaservice.mapper.GridMapper;
import practice.areaservice.service.GridService;
import practice.entity.Grid;

import java.util.List;

@Service
public class GridServiceImpl implements GridService {
    @Autowired
    private GridMapper gridMapper;

    @Override
    public List<Grid> getGrids() {
        return gridMapper.selectList(null);
    }

    @Override
    public Grid getGrid(Integer id) {
        return gridMapper.selectById(id);
    }

    @Override
    public Integer addGrid(Grid grid) {
        return gridMapper.insert(grid);
    }

    @Override
    public Integer updateGrid(Grid grid) {
        return gridMapper.updateById(grid);
    }

    @Override
    public Integer deleteGrid(Integer id) {
        return gridMapper.deleteById(id);
    }
}
