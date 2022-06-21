package cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.services.SucursalService;

@Controller
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listSucursals", sucursalService.getAll());
		return "index";
	}

	@GetMapping("/showNewSucursalDTOForm")
	public String showNewSucursalDTOForm(Model model) {
		// create model attribute to bind form data
		SucursalDTO dto = new SucursalDTO();
		model.addAttribute("sucursalDTO", dto);
		return "new_sucursalDTO";
	}

	@PostMapping("/saveSucursalDTO")
	public String saveSucursalDTO(@ModelAttribute("sucursalDTO") SucursalDTO dto) {
		// save sucursaldto to database
		sucursalService.add(dto);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {

		// get sucursaldto from the service
		SucursalDTO dto = sucursalService.getOne(id);

		// set sucursal as a model attribute to pre-populate the form
		model.addAttribute("sucursalDTO", dto);
		return "update_sucursalDTO";
	}

	@GetMapping("/deleteSucursalDTO/{id}")
	public String deleteSucursalDTO(@PathVariable(value = "id") Integer id) {

		// call delete sucursal method
		this.sucursalService.delete(id);

		return "redirect:/";
	}

}