package com.oktacamerakit

import grails.gorm.services.Service

@Service(Camera)
interface CameraService {

    Camera get(Serializable id)

    List<Camera> list(Map args)

    Long count()

    void delete(Serializable id)

    Camera save(Camera camera)

}