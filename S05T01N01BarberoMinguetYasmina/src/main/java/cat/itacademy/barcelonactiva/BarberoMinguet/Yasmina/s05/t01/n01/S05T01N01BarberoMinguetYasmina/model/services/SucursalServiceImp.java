package cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.repository.SucursalRepo;

@Service
public class SucursalServiceImp implements SucursalService{
	
	@Autowired 
	private SucursalRepo sucursalRepo;
	
	@Override
	@Transactional
	public void add(SucursalDTO sucursal) {
		Sucursal s= this.mapDtotoEntity(sucursal);
		s = sucursalRepo.save(s);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		sucursalRepo.deleteById(id);
	}
	
	@Override
	@Transactional
	public SucursalDTO getOne(Integer id) {
		Optional<Sucursal> op = sucursalRepo.findById(id);
		if(op.isPresent()) {
			return this.mapEntitytoDto(op.get());
		}else {
			return new SucursalDTO();
		}
	}
	
	@Override
	@Transactional
	public List<SucursalDTO> getAll() {
		List<SucursalDTO>list=null;
		List<Sucursal>sucursals=sucursalRepo.findAll();
		if (sucursals != null && sucursals.size() > 0) {
			list=new ArrayList<SucursalDTO>();
			for (Sucursal sucursal : sucursals) {
				list.add(this.mapEntitytoDto(sucursal));
			}

		}
		return list;
	}
	
	private Sucursal mapDtotoEntity(SucursalDTO dto) {
		Sucursal s= new Sucursal();
		if (dto.getPk_SucursalID() != null) {
			s.setPk_SucursalID(dto.getPk_SucursalID());
		}
		s.setNomSucursal(dto.getNomSucursal());
		s.setPaisSucursal(dto.getPaisSucursal());

		return s;

	}

	private SucursalDTO mapEntitytoDto(Sucursal s) {
		SucursalDTO dto = new SucursalDTO();
		dto.setPk_SucursalID(s.getPk_SucursalID());
		dto.setNomSucursal(s.getNomSucursal());
		dto.setPaisSucursal(s.getPaisSucursal());

		String ue = "#Alemanya#Austria#Bèlgica#Bulgaria#Xipre#Croàcia#Dinamarca#Espanya#Eslovaquia#Eslovenia#Estonia#Finlandia#França#Grècia#Hongría#Irlanda#Itàlia#Letonia#Lituania#Luxemburg#Malta#Paisos Baixos#Polonia#Portugal#República Txeca#Romania#Suècia#";

		if (dto.getPaisSucursal() != null && ue.toLowerCase().contains("#" + dto.getPaisSucursal().toLowerCase() + "#")) {
			dto.setTipusSucursal("UE");
		} else {
			dto.setTipusSucursal("Fora UE");
		}

		return dto;

	}

}
