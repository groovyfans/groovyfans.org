package org.groovyfans.auth

class Role {
    static final ADMINISTRATOR = "Administrator"
    static final EDITOR = "Editor"
    static final AUTHOR = "Author"
    static final CONTRIBUTOR  = "Contributor"
    static final SUBSCRIBER = "Subscriber"

    String name

    static hasMany = [ users: User, permissions: String ]
    static belongsTo = User

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
}
