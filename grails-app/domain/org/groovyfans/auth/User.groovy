package org.groovyfans.auth

class User {
	String username
	String password
	String name
	String email
	Date dateCreated
	Date dateUpdated

    static hasMany = [ roles: Role, permissions: String ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
}
