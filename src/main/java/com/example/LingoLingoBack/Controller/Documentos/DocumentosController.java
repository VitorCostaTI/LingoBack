package com.example.LingoLingoBack.Controller.Documentos;

import com.example.LingoLingoBack.Model.Dog;
import com.example.LingoLingoBack.Service.Documentos.DocumentosService;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@RestController
@RequestMapping(value = "/documentos")
public class DocumentosController {

    @Autowired
    DocumentosService documentosService;

    @GetMapping(value = "/contratos/{id}")
    public void genContratos(@PathVariable Long id, HttpServletResponse response) throws Exception {
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment; filename=\"contrato_dog.docx\"");

        OutputStream out = response.getOutputStream();
        out.flush();

        JasperPrint jasperPrint = documentosService.genContratos(id);

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));

        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

        exporter.exportReport();
    }
}
