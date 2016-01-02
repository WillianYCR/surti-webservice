package pe.com.surti.entity;

public class EntityBase {

	private String fechaRegistro;
	private String userRegistro;
	private String fechaModificado;
	private String userModificado;

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUserRegistro() {
		return userRegistro;
	}

	public void setUserRegistro(String userRegistro) {
		this.userRegistro = userRegistro;
	}

	public String getFechaModificado() {
		return fechaModificado;
	}

	public void setFechaModificado(String fechaModificado) {
		this.fechaModificado = fechaModificado;
	}

	public String getUserModificado() {
		return userModificado;
	}

	public void setUserModificado(String userModificado) {
		this.userModificado = userModificado;
	}

	@Override
	public String toString() {
		return "EntityBase [fechaRegistro=" + fechaRegistro + ", userRegistro="
				+ userRegistro + ", fechaModificado=" + fechaModificado
				+ ", userModificado=" + userModificado + "]";
	}

}
