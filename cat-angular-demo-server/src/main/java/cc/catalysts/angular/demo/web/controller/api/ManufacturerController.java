package cc.catalysts.angular.demo.web.controller.api;

import cc.catalysts.angular.demo.dto.ManufacturerDto;
import cc.catalysts.angular.demo.service.ManufacturerService;
import cc.catalysts.angular.spring.api.AbstractCrudlRestApi;
import cc.catalysts.angular.spring.dto.NamedDto;
import cc.catalysts.angular.spring.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by thomas.scheinecker on 31.07.2015.
 */
@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController extends AbstractCrudlRestApi<ManufacturerDto, ManufacturerDto, ManufacturerSearchRequest> {


    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @Override
    public ManufacturerDto create(@RequestBody @Valid ManufacturerDto dto) {
        return manufacturerService.create(dto);
    }

    @Override
    public void delete(@PathVariable("id") Long id) {
        manufacturerService.delete(id);
    }

    public ManufacturerDto get(@PathVariable("id") Long id) {
        return manufacturerService.get(id);
    }

    @Override
    public PageDto<ManufacturerDto> list(ManufacturerSearchRequest searchRequest) {
        return manufacturerService.list(searchRequest);
    }

    @Override
    public ManufacturerDto update(@PathVariable("id") Long id, @RequestBody ManufacturerDto dto) {
        return manufacturerService.update(id, dto);
    }

    @Override
    public NamedDto<Long> info(@PathVariable("id") Long id) {
        NamedDto<Long> namedDto = new NamedDto<>();
        ManufacturerDto manufacturerDto = manufacturerService.get(id);
        namedDto.setId(manufacturerDto.getId());
        namedDto.setName(manufacturerDto.getName());
        return namedDto;
    }

    @Override
    public List<NamedDto<Long>> infos(Iterable<Long> longs) {
        throw new NotImplementedException();
    }

}
