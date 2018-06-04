package com.oktacamerakit

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Ignore
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
@Ignore
class CameraServiceSpec extends Specification {

    CameraService cameraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Camera(...).save(flush: true, failOnError: true)
        //new Camera(...).save(flush: true, failOnError: true)
        //Camera camera = new Camera(...).save(flush: true, failOnError: true)
        //new Camera(...).save(flush: true, failOnError: true)
        //new Camera(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //camera.id
    }

    void "test get"() {
        setupData()

        expect:
        cameraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Camera> cameraList = cameraService.list(max: 2, offset: 2)

        then:
        cameraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cameraService.count() == 5
    }

    void "test delete"() {
        Long cameraId = setupData()

        expect:
        cameraService.count() == 5

        when:
        cameraService.delete(cameraId)
        sessionFactory.currentSession.flush()

        then:
        cameraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Camera camera = new Camera()
        cameraService.save(camera)

        then:
        camera.id != null
    }
}
