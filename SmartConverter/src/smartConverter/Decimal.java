package smartConverter;

public class Decimal extends Number {
	
	private String decimal;

	public Decimal() {

	}
	
	@Override
	public boolean check (String decimal) {
		
		for(int i = 0; i<decimal.length(); i++) {
			
			char ch = decimal.charAt(i);
			
			if(decimal.charAt(0) == '-' || (ch >= '0' && ch <= '9')) {
				temp= true;
			}
		}
		return temp;
	}

	public String getDecimal() {
		return decimal;
	}

	public void setDecimal(String decimal) {
		this.decimal = decimal;
	}
	
}