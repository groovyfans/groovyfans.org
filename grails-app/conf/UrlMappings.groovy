class UrlMappings {

	static mappings = {
		"/plugins/$action?/$id?"(controller:'plugin')
		"/projects/$action?/$id?"(controller:'project')
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
