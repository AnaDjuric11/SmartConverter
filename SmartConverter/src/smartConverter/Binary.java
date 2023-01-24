package smartConverter;

public class Binary extends Number {
	
	private String binary;

	public Binary() {
		
	}
	
	@Override
	public boolean check (String binary) {
		
		for(int i = 0; i< binary.length(); i++) {
			
			char ch = binary.charAt(i);
			
			if(ch == '0' || ch == '1') {
				temp = true;
			}else {
				temp = false;
				break;
			}
		}
		return temp;
	}
	
	public String getBinary() {
		return binary;
	}

	public void setBinary(String binary) {
		this.binary = binary;
	}
	
}