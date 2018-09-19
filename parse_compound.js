		console.log("compositon-before-matching:"+composition);
    
		// treat compound search(LiCoO2) like element search(Li-Co-O2)
		
    if (composition){
			if (composition.includes("-")==false){
				var re = /[A-Z][^A-Z]*/g;
				var allMatches = composition.match(re);
				console.log("allMatches-reactionpage1:"+allMatches);
				var composition_parsed="";
				for (var i=0;i<allMatches.length;i++)
				{
					composition_parsed += allMatches[i]+"-"
				}
				console.log("composition_parsed:"+composition_parsed);
				composition=composition_parsed;
			}else{
				var re = /[A-Z][^A-Z]*/g;
				var s = composition.replace(/-/g,"")
				var allMatches = s.match(re);
				console.log("allMatches-reactionpage2:"+allMatches);
				var composition_parsed="";
				for (var i=0;i<allMatches.length;i++)
				{
					composition_parsed += allMatches[i]+"-"
				}
				console.log("composition_parsed:"+composition_parsed);
				composition=composition_parsed;			
			}
		}
