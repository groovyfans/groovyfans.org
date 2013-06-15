package org.groovyfans.plugin

import org.groovyfans.grails.resolve.GrailsRepoResolver
import groovy.xml.dom.DOMCategory
import grails.converters.JSON

class PluginController {
    def init() { 
        def success = false
        def resolver = new GrailsRepoResolver("grailsCentral", "http://grails.org/plugins/".toURL())

        def pluginsList = resolver.getPluginList(new File(request.getRealPath("/.cache/plugins-list-grailsCentral.xml")))
        if (pluginsList != null) {
            use(DOMCategory) {
				pluginsList?.'plugin'.each {plugin ->
					def version
					def author
					def authorEmail
					def description
					def pluginName = plugin.'@name'.toString()
					def pluginVersion = "<no releases>"
					def pluginTitle = "No description available"
					if (plugin.'@latest-release') {
						version = plugin.'@latest-release'
						pluginVersion = "${version}"
					}
					else if (plugin.'release'.size() > 0) {
						// determine latest release by comparing version names in lexicografic order
						version = plugin.'release'[0].'@version'
						plugin.'release'.each {
							if (!"${it.'@version'}".endsWith("SNAPSHOT") && "${it.'@version'}" > version) {
								version = "${it.'@version'}"
							}
						}
						pluginVersion = "${version}"
					}
					def release = plugin.'release'.find {rel -> rel.'@version' == version}
					if (release?.'title') {
						pluginTitle = release?.'title'.text()
						author = release?.'author'.text()
						authorEmail = release?.'authorEmail'.text()
						description = release?.'description'.text()
					}
					def p = Plugin.findByName(pluginName)
					if (!p) {
						p = new Plugin(name: pluginName, latestVersion: pluginVersion, title: pluginTitle, author: author, authorEmail: authorEmail, description: description)
						if (p.save()) success = true
					}
					else if (p.latestVersion < pluginVersion) {
						p.latestVersion = pluginVersion
						if (p.save()) success = true
					}
				}
            }

        } else {
            log.error "An error occurred resolving plugin list from resolver [${resolver.name} - ${resolver.repositoryRoot}]."
        }
        [result: success]
    }

	def list() {
        params.max = Math.min(params.max ? params.max.toInteger() : 20,  100)
        [plugins: Plugin.list(params), pluginsTotal: Plugin.count()]
	}

	def vote() {
		def plugin = Plugin.get(params.id)
		if (plugin) {
			plugin.votes = plugin.votes + 1
			plugin.save()
		}
		render plugin as JSON
	}

	def top() {
		params.max = Math.min(params.max ? params.max.toInteger() : 30,  100)
		params.sort = 'votes'
		params.order = 'desc'
        [plugins: Plugin.list(params)]
	}

	def recent() {
        Map args = [max: 20, cache: true, sort: "dateCreated", order: "desc" ] 
        [plugins: Plugin.list(args), pluginsTotal: Plugin.count()]
	}

}
