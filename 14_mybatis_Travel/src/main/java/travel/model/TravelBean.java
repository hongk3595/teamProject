package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	private final String must_input ="필수 입력 사항입니다.";
	
	private int num;
	@NotEmpty(message = "이름은"+must_input)
	private String name;
	
	@Range(min = 10, max = 100, message = "10살~100살로 작성해야 합니다.")
	private int age;
	
	@NotNull(message = "관심지역은 1개 이상 선택해야 합니다.")
	private String area;
	
	@NotNull(message = "원하는 여행 타입을 선택해 주세요.")
	private String style;
	
	@NotBlank(message = "원하는 가격대를 선택하세요.")
	private String price;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

}
