package pt.tiago.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.tiago.constant.Constant;
import pt.tiago.mapper.dto.CompanyDto;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */

@RestController
@RequestMapping(value = Constant.CONTEXT_PATH_PREFIX + "company")
public class CompanyController extends AbstractController<CompanyDto,Long> implements CrudController<CompanyDto,Long>  {

}
