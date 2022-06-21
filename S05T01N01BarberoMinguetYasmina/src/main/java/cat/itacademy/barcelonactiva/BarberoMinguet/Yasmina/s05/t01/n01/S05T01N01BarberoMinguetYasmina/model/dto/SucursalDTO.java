package cat.itacademy.barcelonactiva.BarberoMinguet.Yasmina.s05.t01.n01.S05T01N01BarberoMinguetYasmina.model.dto;

import java.io.Serializable;

public class SucursalDTO implements Serializable{
	
	private static final long serialVersionUID = -6400291936797158926L;
	private Integer pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;

	
	public SucursalDTO() {}

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}

	
}
