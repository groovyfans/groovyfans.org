modules = {
    application {
        resource url:'js/application.js'
    }
	groovyfans {
		dependsOn 'bootstrap,font-awesome'
		resource url:'css/main.css'
	}
}
