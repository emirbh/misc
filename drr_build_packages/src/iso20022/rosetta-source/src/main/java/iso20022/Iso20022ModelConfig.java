package iso20022;

import com.google.common.collect.ImmutableMap;

import static com.regnosys.rosetta.common.transform.PipelineModel.Serialisation;

public class Iso20022ModelConfig {

    public static final ImmutableMap<Class<?>, String> TYPE_TO_SCHEMA_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    // trade
                    .put(iso20022.auth030.asic.Document.class, Auth030AsicModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth030.esma.Document.class, Auth030EsmaModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth030.fca.Document.class, Auth030FcaModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth030.jfsa.Document.class, Auth030JfsaModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth030.mas.Document.class, Auth030MasModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth030.hkma.dtcc.Document.class, Auth030HkmaDtccModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth030.hkma.tr.Document.class, Auth030HkmaTrModelConfig.SCHEMA_PATH)
                    .put(iso20022.dtcc.rds.harmonized.Document.class, DtccRdsHarmonizedModelConfig.SCHEMA_PATH)
                    // margin
                    .put(iso20022.auth108.asic.Document.class, Auth108AsicModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth108.esma.Document.class, Auth108EsmaModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth108.fca.Document.class, Auth108FcaModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth108.jfsa.Document.class, Auth108JfsaModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth108.mas.Document.class, Auth108MasModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth108.hkma.dtcc.Document.class, Auth108HkmaDtccModelConfig.SCHEMA_PATH)
                    .put(iso20022.auth108.hkma.tr.Document.class, Auth108HkmaTrModelConfig.SCHEMA_PATH)
                    .build();

    public static final ImmutableMap<Class<?>, String> TYPE_TO_XML_CONFIG_MAP =
            ImmutableMap.<Class<?>, String>builder()
                    // trade
                    .put(iso20022.auth030.asic.Document.class, Auth030AsicModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth030.esma.Document.class, Auth030EsmaModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth030.fca.Document.class, Auth030FcaModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth030.jfsa.Document.class, Auth030JfsaModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth030.mas.Document.class, Auth030MasModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.dtcc.rds.harmonized.Document.class, DtccRdsHarmonizedModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth030.hkma.dtcc.Document.class, Auth030HkmaDtccModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth030.hkma.tr.Document.class, Auth030HkmaTrModelConfig.XML_CONFIG_PATH)
                    // margin
                    .put(iso20022.auth108.asic.Document.class, Auth108AsicModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth108.esma.Document.class, Auth108EsmaModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth108.fca.Document.class, Auth108FcaModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth108.jfsa.Document.class, Auth108JfsaModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth108.mas.Document.class, Auth108MasModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth108.hkma.dtcc.Document.class, Auth108HkmaDtccModelConfig.XML_CONFIG_PATH)
                    .put(iso20022.auth108.hkma.tr.Document.class, Auth108HkmaTrModelConfig.XML_CONFIG_PATH)
                    .build();

    public static final ImmutableMap<Class<?>, Serialisation.Format> TYPE_TO_FORMAT_MAP =
            ImmutableMap.<Class<?>, Serialisation.Format>builder()
                    // trade
                    .put(iso20022.auth030.asic.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth030.esma.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth030.fca.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth030.jfsa.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth030.mas.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth030.hkma.dtcc.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth030.hkma.tr.Document.class, Serialisation.Format.XML)
                    .put(iso20022.dtcc.rds.harmonized.Document.class, Serialisation.Format.XML)
                    // margin
                    .put(iso20022.auth108.asic.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth108.esma.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth108.fca.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth108.jfsa.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth108.mas.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth108.hkma.dtcc.Document.class, Serialisation.Format.XML)
                    .put(iso20022.auth108.hkma.tr.Document.class, Serialisation.Format.XML)
                    .build();
}
