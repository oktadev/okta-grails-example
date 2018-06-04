package com.oktacamerakit

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
class CameraController {

    CameraService cameraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cameraService.list(params), model:[cameraCount: cameraService.count()]
    }

    def show(Long id) {
        respond cameraService.get(id)
    }

    def create() {
        respond new Camera(params)
    }

    def save(Camera camera) {
        if (camera == null) {
            notFound()
            return
        }

        try {
            cameraService.save(camera)
        } catch (ValidationException e) {
            respond camera.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'camera.label', default: 'Camera'), camera.id])
                redirect camera
            }
            '*' { respond camera, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond cameraService.get(id)
    }

    def update(Camera camera) {
        if (camera == null) {
            notFound()
            return
        }

        try {
            cameraService.save(camera)
        } catch (ValidationException e) {
            respond camera.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'camera.label', default: 'Camera'), camera.id])
                redirect camera
            }
            '*'{ respond camera, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        cameraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'camera.label', default: 'Camera'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'camera.label', default: 'Camera'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
