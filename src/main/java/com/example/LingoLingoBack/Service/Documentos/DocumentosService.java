package com.example.LingoLingoBack.Service.Documentos;

import com.example.LingoLingoBack.Model.Documentos.RelContrato;
import com.example.LingoLingoBack.Repository.DogRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class DocumentosService {

    private static final String REPORT_CONTRATOS = "/reports/contrato_dogs.jrxml";

    @Autowired
    DogRepository dogRepository;

    private JasperPrint genReportWord(List<?> objs, Map<String, Object> params, String filePath) throws FileNotFoundException, JRException {
        InputStream reportInputStream = getClass().getResourceAsStream(filePath);
        JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        params.put("REPORT_LOCALE", new Locale("pt", "BR"));

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(objs);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, params, dataSource);

        return print;
    }

    public JasperPrint genContratos(Long id) throws JRException, FileNotFoundException {
        List<RelContrato> relContratoList = dogRepository.getRelContratos(id);

        Map<String, Object> params = new HashMap<>(0);
        params.put("REPORT_LOCALE", new Locale("pt", "BR"));
        return genReportWord(relContratoList, params, REPORT_CONTRATOS);
    }
}
