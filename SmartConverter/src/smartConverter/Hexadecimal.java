package smartConverter;

public class Hexadecimal extends Number {
	
	private String hexadecimal;
	
	public Hexadecimal() {
		
	}
	
	@Override
	public boolean check (String hexadecimal) {
		
		for(int i=0; i<hexadecimal.length(); i++) {
			
			char ch = hexadecimal.charAt(i);
			
			if((ch>='0' && ch<='9') || (ch>='a' && ch<='f') || (ch>='A' && ch<='F')) {
				temp = true;
			}
		}
		return temp;
	}

	public String getHexadecimal() {
		return hexadecimal;
	}

	public void setHexadecimal(String hexadecimal) {
		this.hexadecimal = hexadecimal;
	}

}
