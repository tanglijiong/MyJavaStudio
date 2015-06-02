package com.xjj.constants;

public enum Color {
	RED("红色"){
		public String getHint() {return "我是红色！";}
	},
	GREEN("绿色"){
		public String getHint() {return "我是绿色！";}
	},
	BLUE("蓝色"){
		public String getHint() {return "我是蓝色！";}
	};
	
	private String name;
	
	private Color(String name){
		this.setName(name);
	}

	public abstract String getHint(); 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		System.out.println("RED: " + Color.RED.getHint());
	}
}
