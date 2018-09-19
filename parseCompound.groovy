	def parseCompound(String comp){
		Pattern pattern = Pattern.compile(pattern_elements)
		List<String> listElementGroups = new ArrayList<String>()
		List<String> listElementGroups_withCount = new ArrayList<String>()
		Matcher m = pattern.matcher(comp)

		while (m.find()){
			def ele = m.group()			
			//println ("m.group():"+ ele)
			def ele_digit=0.0
			
			def ele_sym = ele.matches(".*\\d+.*") ? ele.replaceAll("([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)","").toString() : ele
			//println("ele_sym: "+ele_sym)
			
			if (ele.matches(".*[0-9]\\/[0-9].*")){ // fractions
				def ele_digit_temp = ele.replaceAll(ele_sym,"")
				def two_nums = ele_digit_temp.split("/")
				ele_digit = Float.parseFloat(two_nums[0]) / Float.parseFloat(two_nums[1])
				ele_digit = ele_digit.round(3)
			}
			else{ // integer, float or empty
				ele_digit = ele.matches(".*\\d+.*") ?  Float.parseFloat(ele.replaceAll(ele_sym,"")) : 1
			}
			ele_digit = ele_digit > 1.0 ? ele_digit.round() : ele_digit
			listElementGroups.add(ele)
			listElementGroups_withCount.add(ele_sym+":"+ele_digit)
		} 
		return listElementGroups_withCount
	}
