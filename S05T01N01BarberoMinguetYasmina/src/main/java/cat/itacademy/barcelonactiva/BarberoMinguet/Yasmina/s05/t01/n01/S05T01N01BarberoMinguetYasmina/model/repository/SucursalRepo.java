package cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.domain.Sucursal;

@Repository
public interface SucursalRepo extends JpaRepository<Sucursal, Integer> {


}
