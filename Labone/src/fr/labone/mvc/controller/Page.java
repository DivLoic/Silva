package fr.labone.mvc.controller;

import java.util.ArrayList;
import java.util.List;

public class Page {

		private List<String> css;
		
		public void page(){
			this.css = new ArrayList<String>();
		}
		
		public void set(String stylesheets){
			this.css.add(stylesheets);
		}
}
