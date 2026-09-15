package drr.regulation.common.processor;

import com.google.inject.Guice;
import com.regnosys.drr.DrrRuntimeModule;
import com.regnosys.rosetta.common.translation.Mapping;
import com.regnosys.rosetta.common.translation.MappingContext;
import com.regnosys.rosetta.common.translation.MappingProcessor;
import com.regnosys.rosetta.common.translation.Path;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.path.RosettaPath;
import drr.ingest.fpml.recordkeeping.reportableinfo.functions.MapPartyTradeInformationListToReportableJurisdictionInformation;
import fpml.consolidated.doc.*;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.regnosys.rosetta.common.translation.MappingProcessorUtils.filterListMappings;
import static com.regnosys.rosetta.common.translation.MappingProcessorUtils.getNonNullMappedValue;
import static drr.regulation.common.ReportableInformation.ReportableInformationBuilder;
import static fpml.consolidated.doc.PartyTradeInformation.PartyTradeInformationBuilder;
import static fpml.consolidated.doc.ReportingRegime.ReportingRegimeBuilder;

/**
 * FpML mapping processor.
 */
@SuppressWarnings("unused")
public class RegimeInformationMappingProcessor extends MappingProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegimeInformationMappingProcessor.class);

    @Inject
    private MapPartyTradeInformationListToReportableJurisdictionInformation func;

    public RegimeInformationMappingProcessor(RosettaPath modelPath, List<Path> synonymPaths, MappingContext context) {
        super(modelPath, synonymPaths, context);
        Guice.createInjector(new DrrRuntimeModule()).injectMembers(this);
    }

    @Override
    public void map(Path synonymPath, List<? extends RosettaModelObjectBuilder> builders, RosettaModelObjectBuilder parent) {
        List<PartyTradeInformation> fpmlPartyTradeInformationList = getFpmlPartyTradeInformationList(synonymPath);
        List<Party> fpmlPartyList = getRootSynonymPath(synonymPath).map(this::getFpmlPartyList).orElse(List.of());
        RequestMessageHeader fpmlRequestMessageHeader = getRootSynonymPath(synonymPath).map(this::getFpmlRequestMessageHeader).orElse(null);

        ReportableInformationBuilder reportableInformationBuilder = (ReportableInformationBuilder) parent;
        reportableInformationBuilder
                .setJurisdictionInformation(func
                        .evaluate(fpmlPartyTradeInformationList,
                                fpmlPartyList,
                                fpmlRequestMessageHeader));
    }

    private List<PartyTradeInformation> getFpmlPartyTradeInformationList(Path synonymPath) {
        List<PartyTradeInformation> partyTradeInformationList = new ArrayList<>();
        int index = 0;
        while (true) {
            Optional<PartyTradeInformation> partyTradeInformation = getFpmlPartyTradeInformation(getSynonymPathWithIndex(synonymPath, index++));
            if (partyTradeInformation.isPresent()) {
                partyTradeInformationList.add(partyTradeInformation.get());
            } else {
                break;
            }
        }
        return partyTradeInformationList;
    }

    private Optional<PartyTradeInformation> getFpmlPartyTradeInformation(Path synonymPath) {
        PartyTradeInformationBuilder partyTradeInformationBuilder = PartyTradeInformation.builder();

        getNonNullMappedValue(synonymPath.addElement("partyReference").addElement("href"), getMappings())
                .ifPresent(xmlValue -> partyTradeInformationBuilder.setPartyReference(PartyReference.builder().setHref(xmlValue)));

        partyTradeInformationBuilder.setReportingRegime(getFpmlReportingRegimeList(synonymPath.addElement("reportingRegime")));

        getNonNullMappedValue(synonymPath.addElement("largeSizeTrade"), getMappings())
                .ifPresent(xmlValue -> partyTradeInformationBuilder.setLargeSizeTrade(Boolean.valueOf(xmlValue)));

        Path executionVenueTypeSynonymPath = synonymPath.addElement("executionVenueType");
        getNonNullMappedValue(executionVenueTypeSynonymPath, getMappings())
                .ifPresent(xmlValue -> {
                    // value
                    ExecutionVenueType.ExecutionVenueTypeBuilder executionVenueType = ExecutionVenueType.builder().setValue(xmlValue);
                    // scheme
                    getNonNullMappedValue(executionVenueTypeSynonymPath.addElement("executionVenueTypeScheme"), getMappings())
                            .ifPresent(executionVenueType::setExecutionVenueTypeScheme);

                    partyTradeInformationBuilder.setExecutionVenueType(executionVenueType);
                });

        return partyTradeInformationBuilder.hasData() ? Optional.of(partyTradeInformationBuilder) : Optional.empty();
    }

    private List<ReportingRegime> getFpmlReportingRegimeList(Path synonymPath) {
        List<ReportingRegime> reportingRegimeList = new ArrayList<>();
        int index = 0;
        while (true) {
            Optional<ReportingRegime> reportingRegime = getFpmlReportingRegime(getSynonymPathWithIndex(synonymPath, index++));
            if (reportingRegime.isPresent()) {
                reportingRegimeList.add(reportingRegime.get());
            } else {
                break;
            }
        }
        return reportingRegimeList;
    }

    private Optional<ReportingRegime> getFpmlReportingRegime(Path synonymPath) {
        ReportingRegimeBuilder reportingRegimeBuilder = ReportingRegime.builder();

        getNonNullMappedValue(synonymPath.addElement("name"), getMappings())
                .ifPresent(xmlValue -> reportingRegimeBuilder
                        .setName(ReportingRegimeName.builder()
                                .setValue(xmlValue)));

        getNonNullMappedValue(synonymPath.addElement("supervisorRegistration").addElement("supervisoryBody"), getMappings())
                .ifPresent(xmlValue -> reportingRegimeBuilder
                        .addSupervisorRegistration(SupervisorRegistration.builder()
                                .setSupervisoryBody(SupervisoryBody.builder()
                                        .setValue(xmlValue))));

        getNonNullMappedValue(synonymPath.addElement("reportingRole"), getMappings())
                .ifPresent(xmlValue -> reportingRegimeBuilder
                        .setReportingRole(ReportingRole.builder()
                                .setValue(xmlValue)));

        getNonNullMappedValue(synonymPath.addElement("reportingPurpose"), getMappings())
                .ifPresent(xmlValue -> reportingRegimeBuilder
                        .addReportingPurpose(ReportingPurpose.builder()
                                .setValue(xmlValue)));

        getNonNullMappedValue(synonymPath.addElement("mandatorilyClearable"), getMappings())
                .ifPresent(xmlValue -> reportingRegimeBuilder
                        .setMandatorilyClearable(ReportingBoolean.builder()
                                .setValue(xmlValue)));

        getNonNullMappedValue(synonymPath.addElement("exceedsClearingThreshold"), getMappings())
                .ifPresent(xmlValue -> reportingRegimeBuilder
                        .setExceedsClearingThreshold(Boolean.valueOf(xmlValue)));

        Path entityClassificationPath = synonymPath.addElement("entityClassification");
        getNonNullMappedValue(entityClassificationPath, getMappings())
                .ifPresent(xmlValue -> {
                    EntityClassification.EntityClassificationBuilder entityClassification = EntityClassification.builder().setValue(xmlValue);

                    getNonNullMappedValue(entityClassificationPath.addElement("entityClassificationScheme"), getMappings())
                            .ifPresent(entityClassification::setEntityClassificationScheme);

                    reportingRegimeBuilder
                            .setEntityClassification(entityClassification);
                });

        getNonNullMappedValue(synonymPath.addElement("directlyLinkedActivity"), getMappings())
                .ifPresent(xmlValue -> reportingRegimeBuilder
                        .setDirectlyLinkedActivity(Boolean.valueOf(xmlValue)));

        return reportingRegimeBuilder.hasData() ? Optional.of(reportingRegimeBuilder) : Optional.empty();
    }

    private List<Party> getFpmlPartyList(Path rootSynonymPath) {
        List<Party> partyList = new ArrayList<>();
        int index = 0;
        while (true) {
            Optional<Party> party = getFpmlParty(getSynonymPathWithIndex(rootSynonymPath.addElement("party"), index++));
            if (party.isPresent()) {
                partyList.add(party.get());
            } else {
                break;
            }
        }
        return partyList;
    }

    private Optional<Party> getFpmlParty(Path synonymPath) {
        Party.PartyBuilder partyBuilder = Party.builder();

        getNonNullMappedValue(synonymPath.addElement("id"), getMappings())
                .ifPresent(partyBuilder::setId);

        List<Mapping> classificationMappings =
                filterListMappings(getMappings(), synonymPath.addElement("classification"))
                        .stream().filter(m -> m.getXmlValue() != null)
                        .collect(Collectors.toList());

        for (Mapping mapping : classificationMappings) {
            // value
            IndustryClassification.IndustryClassificationBuilder classificationBuilder =
                    IndustryClassification.builder().setValue(String.valueOf(mapping.getXmlValue()));
            // scheme
            getNonNullMappedValue(mapping.getXmlPath().addElement("industryClassificationScheme"), getMappings())
                    .ifPresent(classificationBuilder::setIndustryClassificationScheme);

            partyBuilder.addClassification(classificationBuilder);
        }
        return partyBuilder.hasData() ? Optional.of(partyBuilder) : Optional.empty();
    }

    private RequestMessageHeader getFpmlRequestMessageHeader(Path rootSynonymPath) {
        MessageId.MessageIdBuilder messageIdBuilder = MessageId.builder();

        Path messageIdSynonymPath = rootSynonymPath.addElement("header").addElement("messageId");

        // value
        getNonNullMappedValue(messageIdSynonymPath, getMappings())
                .ifPresent(messageIdBuilder::setValue);
        // scheme
        getNonNullMappedValue(messageIdSynonymPath.addElement("messageIdScheme"), getMappings())
                .ifPresent(messageIdBuilder::setMessageIdScheme);

        return RequestMessageHeader.builder().setMessageId(messageIdBuilder);
    }

    private static Optional<Path> getRootSynonymPath(Path synonymPath) {
        return synonymPath.getPathNames().length > 0 ? Optional.of(Path.valueOf(synonymPath.getPathNames()[0])) : Optional.empty();
    }

    private static Path getSynonymPathWithIndex(Path synonymPath, int index) {
        String attrName = synonymPath.getLastElement().getPathName();
        return synonymPath.getParent().addElement(attrName, index);
    }
}
