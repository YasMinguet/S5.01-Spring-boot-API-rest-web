package cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.dto.SucursalDTO;

public interface SucursalService {

		public void add(SucursalDTO sucursal);
		public void delete(Integer id);
		public SucursalDTO getOne(Integer id);
		public List<SucursalDTO> getAll();


}
