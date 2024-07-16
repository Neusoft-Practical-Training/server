package practice.areaservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.areaservice.mapper.GridMapper;
import practice.areaservice.service.GridService;

@Service
public class GridServiceImpl implements GridService {
    @Autowired
    private GridMapper gridMapper;
}
