package br.com.felipecesar.tests_junit_mockito.Generics;

import java.util.List;

public interface IService<DTO, ID> {
    DTO save(DTO dto);
    DTO update(ID id, DTO dto);
    void delete(ID id);
    DTO findById(ID id);
    List<DTO> findAll();
}