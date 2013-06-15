package org.groovyfans.plugin

class Plugin {
	String name
	String latestVersion
	String title
	String author
	String authorEmail
	String description
	long votes = 0
	Date dateCreated = new Date()
	Date dateUpdated = new Date()

    static beforeInsert = {
        dateCreated = new Date()
        dateUpdated = new Date()
    }

    static beforeUpdate = {
        dateUpdated = new Date()
    }

    static mapping = {
        table "plugins"
        description type:"text"
    }

    static constraints = {
    }
}
