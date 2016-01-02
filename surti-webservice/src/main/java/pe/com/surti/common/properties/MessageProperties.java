package pe.com.surti.common.properties;

public class MessageProperties {

	private String M1001;
	private String M1002;
	private String M1003;

	public String getM1001() {
		return M1001;
	}

	public void setM1001(String m1001) {
		M1001 = m1001;
	}

	public String getM1002() {
		return M1002;
	}

	public void setM1002(String m1002) {
		M1002 = m1002;
	}

	public String getM1003() {
		return M1003;
	}

	public void setM1003(String m1003) {
		M1003 = m1003;
	}

	@Override
	public String toString() {
		return "MessageProperties [M1001=" + M1001 + ", M1002=" + M1002
				+ ", M1003=" + M1003 + "]";
	}

}
