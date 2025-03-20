package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	private final String must_input ="�ʼ� �Է� �����Դϴ�.";
	
	private int num;
	@NotEmpty(message = "�̸���"+must_input)
	private String name;
	
	@Range(min = 10, max = 100, message = "10��~100��� �ۼ��ؾ� �մϴ�.")
	private int age;
	
	@NotNull(message = "���������� 1�� �̻� �����ؾ� �մϴ�.")
	private String area;
	
	@NotNull(message = "���ϴ� ���� Ÿ���� ������ �ּ���.")
	private String style;
	
	@NotBlank(message = "���ϴ� ���ݴ븦 �����ϼ���.")
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
