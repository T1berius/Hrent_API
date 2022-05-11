package com.example.controllers;

import com.example.model.DocumentType;
import com.example.services.DocumentTypeService;
import com.example.services.dto.DocumentTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @RequestMapping(value = "/api/document-types/", method = RequestMethod.GET)
    public List<DocumentTypeDTO> getAllDocumentTypes() {
        return documentTypeService.findAll();
    }
}
