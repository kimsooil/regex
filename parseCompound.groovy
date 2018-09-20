String pattern_elements="A[cglmrstu]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|B[aehikr]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|C[adeflmnorsu]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|D[bsy]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|E[rsu]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|F[elmr]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|G[ade]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|H[efgos]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|I[nr]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|Kr?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|L[airuv]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|M[dgnot]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|N[abdeiop]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|Os?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|P[abdmortu]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|R[abefghnu]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|S[bcegimnr]?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|T[abcehilm]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|U(u[opst])?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|V([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|W([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|Xe([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|Yb?([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)|Z[nr]([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)"

def parseCompound(String comp){
		Pattern pattern = Pattern.compile(pattern_elements)
		List<String> listElementGroups = new ArrayList<String>()
		List<String> listElementGroups_withCount = new ArrayList<String>()
		Matcher m = pattern.matcher(comp)

		while (m.find()){
			def ele = m.group()			
			def ele_digit=0.0
			
			def ele_sym = ele.matches(".*\\d+.*") ? ele.replaceAll("([0-9]\\/[0-9]|[0-9]*\\.?[0-9]+|[0-9]*)","").toString() : ele
			
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
