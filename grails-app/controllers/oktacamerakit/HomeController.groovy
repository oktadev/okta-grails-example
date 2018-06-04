package oktacamerakit

import grails.plugin.springsecurity.annotation.Secured

class HomeController {  
    @Secured('ROLE_USER')  
    def index() {  
        render "Success!!!"
    }  
}  