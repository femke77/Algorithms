package studythis;

//polymorphism : greek-many forms. Supertype variables can refer to subtype objects. 

public class Square extends Shape{
	
	int side;
	
	Square(){
		//keep a no-arg constructor for construcor chaining up the inheritence heirarchy
	}
	
	Square(int side){           //compiler is auto calling super()
		this.side = side;
		this.filled = true;       //you are supposed to have set methods no access directly
		this.color = 2;
	}
	
	@Override
	int color(Shape x){
		if (x.color == 1){
			return 1;
		} else {
			return 10;
		}
	}
	
	
	public static void main(String[] args){
		
		Square s = new Square(2);
		System.out.println(s.color);
	}
	
	
	
	
	
	
	
}
