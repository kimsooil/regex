	ele_data=[]
	sym=""
	elements_joined=[]
	#if total > 0:
	for ele in re.findall('[A-Z][^A-Z]*', compositionName):
		sym=ele.replace("-","")
		#sym=c=re.sub(r'[0-9]+', '', sym)
		sym=c=re.sub(r'[0-9]*[\.?[0-9]+]?', '', sym) // floating points are allowed in formula: Li0.5, O0.33
		elements_joined.append(sym)
		eledata = Element.objects.filter(symbol=sym)[0] // find Element object from qmpy with filtering
		ele_data.append(sym+":"+str(eledata.group)+":"+str(eledata.mass))
		#print sym, eledata.mass, eledata.group
	elements_joined = "-".join(elements_joined)	
