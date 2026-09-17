package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.meta.ReportingRegimeMeta;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.ReportingRegimeName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Provides information about how the information in this message is applicable to a regulatory reporting process.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Provides information about how the information in this message is applicable to a regulatory reporting process.
 *
 */
@RosettaDataType(value="ReportingRegime", builder=ReportingRegime.ReportingRegimeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReportingRegime", model="fpml", builder=ReportingRegime.ReportingRegimeBuilderImpl.class, version="2.1.1")
public interface ReportingRegime extends RosettaModelObject {

	ReportingRegimeMeta metaData = new ReportingRegimeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, MiFID, HongKongOTCDRepository, ODRF
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, MiFID, HongKongOTCDRepository, ODRF
	 *
	 */
	ReportingRegimeName getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 *
	 */
	List<? extends SupervisorRegistration> getSupervisorRegistration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
	 *
	 */
	ReportingRole getReportingRole();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The reason this message is being sent, for example Snapshot, PET, Confirmation, RealTimePublic.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The reason this message is being sent, for example Snapshot, PET, Confirmation, RealTimePublic.
	 *
	 */
	List<? extends ReportingPurpose> getReportingPurpose();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the particular trade type in question is required by this regulator to be cleared.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the particular trade type in question is required by this regulator to be cleared.
	 *
	 */
	ReportingBoolean getMandatorilyClearable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the particular product must be executed on a SEF or DCM. See to Dodd-Frank section 723(a)(8).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the particular product must be executed on a SEF or DCM. See to Dodd-Frank section 723(a)(8).
	 *
	 */
	Boolean getMandatoryFacilityExecution();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 *
	 */
	Boolean getMandatoryFacilityExecutionException();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides supporting evidence when a party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides supporting evidence when a party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 *
	 */
	FacilityExecutionExceptionDeclaration getMandatoryFacilityExecutionExceptionDeclaration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether the counterparty exceeds the volume threshold above which trades are required to be cleared.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether the counterparty exceeds the volume threshold above which trades are required to be cleared.
	 *
	 */
	Boolean getExceedsClearingThreshold();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 *
	 */
	EntityClassification getEntityClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the category or classification or business role of a trade party with respect to this reporting regime, for example Financial, NonFinancial, Dealer, Non-Dealer, LocalParty, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the category or classification or business role of a trade party with respect to this reporting regime, for example Financial, NonFinancial, Dealer, Non-Dealer, LocalParty, etc.
	 *
	 */
	List<? extends PartyEntityClassification> getPartyEntityClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates how the parties to the trade (the counterparties) are related to each other with respect to this reporting regime, e.g. Affiliated, Intragroup, etc..
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates how the parties to the trade (the counterparties) are related to each other with respect to this reporting regime, e.g. Affiliated, Intragroup, etc..
	 *
	 */
	PartyRelationshipType getTradePartyRelationshipType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type.
	 *
	 */
	ActionType getActionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reports that this trade was executed prior to the enactment of the relevant reporting regulation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reports that this trade was executed prior to the enactment of the relevant reporting regulation.
	 *
	 */
	Boolean getPreEnactmentTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision How the notional amount should be reported for the reporting regime. For example, for ESMA MiFIR it would be Nominal or MonetaryAmount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision How the notional amount should be reported for the reporting regime. For example, for ESMA MiFIR it would be Nominal or MonetaryAmount.
	 *
	 */
	NotionalReportingType getNotionalType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reports a regulator-specific code classifying the currency pair in the trade into risk categories such as Major Currencies or Emerging Markets.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reports a regulator-specific code classifying the currency pair in the trade into risk categories such as Major Currencies or Emerging Markets.
	 *
	 */
	CurrencyPairClassification getCurrencyPairClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Boolean getTransmissionOfOrder();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Boolean getPostPricedIndicator();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Directly linked to commercial activity or treasury financing. Information on whether the contract is objectively measurable as directly linked to the counterparty's commercial or treasury financing activity, as referred to in Article 10(3) of Regulation (EU) No 648/2012.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Directly linked to commercial activity or treasury financing. Information on whether the contract is objectively measurable as directly linked to the counterparty's commercial or treasury financing activity, as referred to in Article 10(3) of Regulation (EU) No 648/2012.
	 *
	 */
	Boolean getDirectlyLinkedActivity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade is not obligated to be cleared via a derivative clearing organization, i.e. whether there is an exemption from clearing. For historical reasons this is called "end-user exception", but this may be used to indication any exception from normal clearing mandates caused by the type of the partiees or their relationship, such as inter-affiliate trades. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is not obligated to be cleared via a derivative clearing organization, i.e. whether there is an exemption from clearing. For historical reasons this is called "end-user exception", but this may be used to indication any exception from normal clearing mandates caused by the type of the partiees or their relationship, such as inter-affiliate trades. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 */
	Boolean getEndUserException();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a reason that the trade is exempted from a clearing requirement. This exemption may be an end-user exception, or another type such as in inter-affiliate trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a reason that the trade is exempted from a clearing requirement. This exemption may be an end-user exception, or another type such as in inter-affiliate trade.
	 *
	 */
	List<? extends ClearingExceptionReason> getEndUserExceptionReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Claims an end user exception and provides supporting evidence. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Claims an end user exception and provides supporting evidence. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception.
	 *
	 */
	EndUserExceptionDeclaration getEndUserExceptionDeclaration();

	/*********************** Build Methods  ***********************/
	ReportingRegime build();
	
	ReportingRegime.ReportingRegimeBuilder toBuilder();
	
	static ReportingRegime.ReportingRegimeBuilder builder() {
		return new ReportingRegime.ReportingRegimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRegime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportingRegime> getType() {
		return ReportingRegime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("name"), processor, ReportingRegimeName.class, getName());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processRosetta(path.newSubPath("mandatorilyClearable"), processor, ReportingBoolean.class, getMandatorilyClearable());
		processor.processBasic(path.newSubPath("mandatoryFacilityExecution"), Boolean.class, getMandatoryFacilityExecution(), this);
		processor.processBasic(path.newSubPath("mandatoryFacilityExecutionException"), Boolean.class, getMandatoryFacilityExecutionException(), this);
		processRosetta(path.newSubPath("mandatoryFacilityExecutionExceptionDeclaration"), processor, FacilityExecutionExceptionDeclaration.class, getMandatoryFacilityExecutionExceptionDeclaration());
		processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.class, getEntityClassification());
		processRosetta(path.newSubPath("partyEntityClassification"), processor, PartyEntityClassification.class, getPartyEntityClassification());
		processRosetta(path.newSubPath("tradePartyRelationshipType"), processor, PartyRelationshipType.class, getTradePartyRelationshipType());
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
		processor.processBasic(path.newSubPath("preEnactmentTrade"), Boolean.class, getPreEnactmentTrade(), this);
		processRosetta(path.newSubPath("notionalType"), processor, NotionalReportingType.class, getNotionalType());
		processRosetta(path.newSubPath("currencyPairClassification"), processor, CurrencyPairClassification.class, getCurrencyPairClassification());
		processor.processBasic(path.newSubPath("transmissionOfOrder"), Boolean.class, getTransmissionOfOrder(), this);
		processor.processBasic(path.newSubPath("postPricedIndicator"), Boolean.class, getPostPricedIndicator(), this);
		processor.processBasic(path.newSubPath("directlyLinkedActivity"), Boolean.class, getDirectlyLinkedActivity(), this);
		processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
		processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.class, getEndUserExceptionReason());
		processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.class, getEndUserExceptionDeclaration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRegimeBuilder extends ReportingRegime, RosettaModelObjectBuilder {
		ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateName();
		@Override
		ReportingRegimeName.ReportingRegimeNameBuilder getName();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int index);
		@Override
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		ReportingBoolean.ReportingBooleanBuilder getOrCreateMandatorilyClearable();
		@Override
		ReportingBoolean.ReportingBooleanBuilder getMandatorilyClearable();
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getOrCreateMandatoryFacilityExecutionExceptionDeclaration();
		@Override
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getMandatoryFacilityExecutionExceptionDeclaration();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification();
		@Override
		EntityClassification.EntityClassificationBuilder getEntityClassification();
		PartyEntityClassification.PartyEntityClassificationBuilder getOrCreatePartyEntityClassification(int index);
		@Override
		List<? extends PartyEntityClassification.PartyEntityClassificationBuilder> getPartyEntityClassification();
		PartyRelationshipType.PartyRelationshipTypeBuilder getOrCreateTradePartyRelationshipType();
		@Override
		PartyRelationshipType.PartyRelationshipTypeBuilder getTradePartyRelationshipType();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		@Override
		ActionType.ActionTypeBuilder getActionType();
		NotionalReportingType.NotionalReportingTypeBuilder getOrCreateNotionalType();
		@Override
		NotionalReportingType.NotionalReportingTypeBuilder getNotionalType();
		CurrencyPairClassification.CurrencyPairClassificationBuilder getOrCreateCurrencyPairClassification();
		@Override
		CurrencyPairClassification.CurrencyPairClassificationBuilder getCurrencyPairClassification();
		ClearingExceptionReason.ClearingExceptionReasonBuilder getOrCreateEndUserExceptionReason(int index);
		@Override
		List<? extends ClearingExceptionReason.ClearingExceptionReasonBuilder> getEndUserExceptionReason();
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getOrCreateEndUserExceptionDeclaration();
		@Override
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getEndUserExceptionDeclaration();
		ReportingRegime.ReportingRegimeBuilder setName(ReportingRegimeName name);
		ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration);
		ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int idx);
		ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration);
		ReportingRegime.ReportingRegimeBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration);
		ReportingRegime.ReportingRegimeBuilder setReportingRole(ReportingRole reportingRole);
		ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose reportingPurpose);
		ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		ReportingRegime.ReportingRegimeBuilder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		ReportingRegime.ReportingRegimeBuilder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		ReportingRegime.ReportingRegimeBuilder setMandatorilyClearable(ReportingBoolean mandatorilyClearable);
		ReportingRegime.ReportingRegimeBuilder setMandatoryFacilityExecution(Boolean mandatoryFacilityExecution);
		ReportingRegime.ReportingRegimeBuilder setMandatoryFacilityExecutionException(Boolean mandatoryFacilityExecutionException);
		ReportingRegime.ReportingRegimeBuilder setMandatoryFacilityExecutionExceptionDeclaration(FacilityExecutionExceptionDeclaration mandatoryFacilityExecutionExceptionDeclaration);
		ReportingRegime.ReportingRegimeBuilder setExceedsClearingThreshold(Boolean exceedsClearingThreshold);
		ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty relatedParty);
		ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		ReportingRegime.ReportingRegimeBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		ReportingRegime.ReportingRegimeBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		ReportingRegime.ReportingRegimeBuilder setEntityClassification(EntityClassification entityClassification);
		ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification partyEntityClassification);
		ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification partyEntityClassification, int idx);
		ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassification);
		ReportingRegime.ReportingRegimeBuilder setPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassification);
		ReportingRegime.ReportingRegimeBuilder setTradePartyRelationshipType(PartyRelationshipType tradePartyRelationshipType);
		ReportingRegime.ReportingRegimeBuilder setActionType(ActionType actionType);
		ReportingRegime.ReportingRegimeBuilder setPreEnactmentTrade(Boolean preEnactmentTrade);
		ReportingRegime.ReportingRegimeBuilder setNotionalType(NotionalReportingType notionalType);
		ReportingRegime.ReportingRegimeBuilder setCurrencyPairClassification(CurrencyPairClassification currencyPairClassification);
		ReportingRegime.ReportingRegimeBuilder setTransmissionOfOrder(Boolean transmissionOfOrder);
		ReportingRegime.ReportingRegimeBuilder setPostPricedIndicator(Boolean postPricedIndicator);
		ReportingRegime.ReportingRegimeBuilder setDirectlyLinkedActivity(Boolean directlyLinkedActivity);
		ReportingRegime.ReportingRegimeBuilder setEndUserException(Boolean endUserException);
		ReportingRegime.ReportingRegimeBuilder addEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason);
		ReportingRegime.ReportingRegimeBuilder addEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason, int idx);
		ReportingRegime.ReportingRegimeBuilder addEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReason);
		ReportingRegime.ReportingRegimeBuilder setEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReason);
		ReportingRegime.ReportingRegimeBuilder setEndUserExceptionDeclaration(EndUserExceptionDeclaration endUserExceptionDeclaration);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("name"), processor, ReportingRegimeName.ReportingRegimeNameBuilder.class, getName());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processRosetta(path.newSubPath("mandatorilyClearable"), processor, ReportingBoolean.ReportingBooleanBuilder.class, getMandatorilyClearable());
			processor.processBasic(path.newSubPath("mandatoryFacilityExecution"), Boolean.class, getMandatoryFacilityExecution(), this);
			processor.processBasic(path.newSubPath("mandatoryFacilityExecutionException"), Boolean.class, getMandatoryFacilityExecutionException(), this);
			processRosetta(path.newSubPath("mandatoryFacilityExecutionExceptionDeclaration"), processor, FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder.class, getMandatoryFacilityExecutionExceptionDeclaration());
			processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("entityClassification"), processor, EntityClassification.EntityClassificationBuilder.class, getEntityClassification());
			processRosetta(path.newSubPath("partyEntityClassification"), processor, PartyEntityClassification.PartyEntityClassificationBuilder.class, getPartyEntityClassification());
			processRosetta(path.newSubPath("tradePartyRelationshipType"), processor, PartyRelationshipType.PartyRelationshipTypeBuilder.class, getTradePartyRelationshipType());
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
			processor.processBasic(path.newSubPath("preEnactmentTrade"), Boolean.class, getPreEnactmentTrade(), this);
			processRosetta(path.newSubPath("notionalType"), processor, NotionalReportingType.NotionalReportingTypeBuilder.class, getNotionalType());
			processRosetta(path.newSubPath("currencyPairClassification"), processor, CurrencyPairClassification.CurrencyPairClassificationBuilder.class, getCurrencyPairClassification());
			processor.processBasic(path.newSubPath("transmissionOfOrder"), Boolean.class, getTransmissionOfOrder(), this);
			processor.processBasic(path.newSubPath("postPricedIndicator"), Boolean.class, getPostPricedIndicator(), this);
			processor.processBasic(path.newSubPath("directlyLinkedActivity"), Boolean.class, getDirectlyLinkedActivity(), this);
			processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
			processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.ClearingExceptionReasonBuilder.class, getEndUserExceptionReason());
			processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder.class, getEndUserExceptionDeclaration());
		}
		

		ReportingRegime.ReportingRegimeBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingRegime  ***********************/
	class ReportingRegimeImpl implements ReportingRegime {
		private final ReportingRegimeName name;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final ReportingBoolean mandatorilyClearable;
		private final Boolean mandatoryFacilityExecution;
		private final Boolean mandatoryFacilityExecutionException;
		private final FacilityExecutionExceptionDeclaration mandatoryFacilityExecutionExceptionDeclaration;
		private final Boolean exceedsClearingThreshold;
		private final List<? extends RelatedParty> relatedParty;
		private final EntityClassification entityClassification;
		private final List<? extends PartyEntityClassification> partyEntityClassification;
		private final PartyRelationshipType tradePartyRelationshipType;
		private final ActionType actionType;
		private final Boolean preEnactmentTrade;
		private final NotionalReportingType notionalType;
		private final CurrencyPairClassification currencyPairClassification;
		private final Boolean transmissionOfOrder;
		private final Boolean postPricedIndicator;
		private final Boolean directlyLinkedActivity;
		private final Boolean endUserException;
		private final List<? extends ClearingExceptionReason> endUserExceptionReason;
		private final EndUserExceptionDeclaration endUserExceptionDeclaration;
		
		protected ReportingRegimeImpl(ReportingRegime.ReportingRegimeBuilder builder) {
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.mandatorilyClearable = ofNullable(builder.getMandatorilyClearable()).map(f->f.build()).orElse(null);
			this.mandatoryFacilityExecution = builder.getMandatoryFacilityExecution();
			this.mandatoryFacilityExecutionException = builder.getMandatoryFacilityExecutionException();
			this.mandatoryFacilityExecutionExceptionDeclaration = ofNullable(builder.getMandatoryFacilityExecutionExceptionDeclaration()).map(f->f.build()).orElse(null);
			this.exceedsClearingThreshold = builder.getExceedsClearingThreshold();
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.entityClassification = ofNullable(builder.getEntityClassification()).map(f->f.build()).orElse(null);
			this.partyEntityClassification = ofNullable(builder.getPartyEntityClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradePartyRelationshipType = ofNullable(builder.getTradePartyRelationshipType()).map(f->f.build()).orElse(null);
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
			this.preEnactmentTrade = builder.getPreEnactmentTrade();
			this.notionalType = ofNullable(builder.getNotionalType()).map(f->f.build()).orElse(null);
			this.currencyPairClassification = ofNullable(builder.getCurrencyPairClassification()).map(f->f.build()).orElse(null);
			this.transmissionOfOrder = builder.getTransmissionOfOrder();
			this.postPricedIndicator = builder.getPostPricedIndicator();
			this.directlyLinkedActivity = builder.getDirectlyLinkedActivity();
			this.endUserException = builder.getEndUserException();
			this.endUserExceptionReason = ofNullable(builder.getEndUserExceptionReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.endUserExceptionDeclaration = ofNullable(builder.getEndUserExceptionDeclaration()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public ReportingRegimeName getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		public List<? extends ReportingPurpose> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatorilyClearable")
		public ReportingBoolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryFacilityExecution")
		public Boolean getMandatoryFacilityExecution() {
			return mandatoryFacilityExecution;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryFacilityExecutionException")
		public Boolean getMandatoryFacilityExecutionException() {
			return mandatoryFacilityExecutionException;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		public FacilityExecutionExceptionDeclaration getMandatoryFacilityExecutionExceptionDeclaration() {
			return mandatoryFacilityExecutionExceptionDeclaration;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityClassification")
		public EntityClassification getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		@RosettaAttribute("partyEntityClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyEntityClassification")
		public List<? extends PartyEntityClassification> getPartyEntityClassification() {
			return partyEntityClassification;
		}
		
		@Override
		@RosettaAttribute("tradePartyRelationshipType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePartyRelationshipType")
		public PartyRelationshipType getTradePartyRelationshipType() {
			return tradePartyRelationshipType;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("preEnactmentTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("preEnactmentTrade")
		public Boolean getPreEnactmentTrade() {
			return preEnactmentTrade;
		}
		
		@Override
		@RosettaAttribute("notionalType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalType")
		public NotionalReportingType getNotionalType() {
			return notionalType;
		}
		
		@Override
		@RosettaAttribute("currencyPairClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyPairClassification")
		public CurrencyPairClassification getCurrencyPairClassification() {
			return currencyPairClassification;
		}
		
		@Override
		@RosettaAttribute("transmissionOfOrder")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transmissionOfOrder")
		public Boolean getTransmissionOfOrder() {
			return transmissionOfOrder;
		}
		
		@Override
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postPricedIndicator")
		public Boolean getPostPricedIndicator() {
			return postPricedIndicator;
		}
		
		@Override
		@RosettaAttribute("directlyLinkedActivity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("directlyLinkedActivity")
		public Boolean getDirectlyLinkedActivity() {
			return directlyLinkedActivity;
		}
		
		@Override
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		public List<? extends ClearingExceptionReason> getEndUserExceptionReason() {
			return endUserExceptionReason;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserExceptionDeclaration")
		public EndUserExceptionDeclaration getEndUserExceptionDeclaration() {
			return endUserExceptionDeclaration;
		}
		
		@Override
		public ReportingRegime build() {
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder toBuilder() {
			ReportingRegime.ReportingRegimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRegime.ReportingRegimeBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getMandatorilyClearable()).ifPresent(builder::setMandatorilyClearable);
			ofNullable(getMandatoryFacilityExecution()).ifPresent(builder::setMandatoryFacilityExecution);
			ofNullable(getMandatoryFacilityExecutionException()).ifPresent(builder::setMandatoryFacilityExecutionException);
			ofNullable(getMandatoryFacilityExecutionExceptionDeclaration()).ifPresent(builder::setMandatoryFacilityExecutionExceptionDeclaration);
			ofNullable(getExceedsClearingThreshold()).ifPresent(builder::setExceedsClearingThreshold);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getEntityClassification()).ifPresent(builder::setEntityClassification);
			ofNullable(getPartyEntityClassification()).ifPresent(builder::setPartyEntityClassification);
			ofNullable(getTradePartyRelationshipType()).ifPresent(builder::setTradePartyRelationshipType);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getPreEnactmentTrade()).ifPresent(builder::setPreEnactmentTrade);
			ofNullable(getNotionalType()).ifPresent(builder::setNotionalType);
			ofNullable(getCurrencyPairClassification()).ifPresent(builder::setCurrencyPairClassification);
			ofNullable(getTransmissionOfOrder()).ifPresent(builder::setTransmissionOfOrder);
			ofNullable(getPostPricedIndicator()).ifPresent(builder::setPostPricedIndicator);
			ofNullable(getDirectlyLinkedActivity()).ifPresent(builder::setDirectlyLinkedActivity);
			ofNullable(getEndUserException()).ifPresent(builder::setEndUserException);
			ofNullable(getEndUserExceptionReason()).ifPresent(builder::setEndUserExceptionReason);
			ofNullable(getEndUserExceptionDeclaration()).ifPresent(builder::setEndUserExceptionDeclaration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegime _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(mandatoryFacilityExecution, _that.getMandatoryFacilityExecution())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionException, _that.getMandatoryFacilityExecutionException())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionExceptionDeclaration, _that.getMandatoryFacilityExecutionExceptionDeclaration())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			if (!ListEquals.listEquals(partyEntityClassification, _that.getPartyEntityClassification())) return false;
			if (!Objects.equals(tradePartyRelationshipType, _that.getTradePartyRelationshipType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(preEnactmentTrade, _that.getPreEnactmentTrade())) return false;
			if (!Objects.equals(notionalType, _that.getNotionalType())) return false;
			if (!Objects.equals(currencyPairClassification, _that.getCurrencyPairClassification())) return false;
			if (!Objects.equals(transmissionOfOrder, _that.getTransmissionOfOrder())) return false;
			if (!Objects.equals(postPricedIndicator, _that.getPostPricedIndicator())) return false;
			if (!Objects.equals(directlyLinkedActivity, _that.getDirectlyLinkedActivity())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!ListEquals.listEquals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecution != null ? mandatoryFacilityExecution.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionException != null ? mandatoryFacilityExecutionException.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionExceptionDeclaration != null ? mandatoryFacilityExecutionExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			_result = 31 * _result + (partyEntityClassification != null ? partyEntityClassification.hashCode() : 0);
			_result = 31 * _result + (tradePartyRelationshipType != null ? tradePartyRelationshipType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (preEnactmentTrade != null ? preEnactmentTrade.hashCode() : 0);
			_result = 31 * _result + (notionalType != null ? notionalType.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassification != null ? currencyPairClassification.hashCode() : 0);
			_result = 31 * _result + (transmissionOfOrder != null ? transmissionOfOrder.hashCode() : 0);
			_result = 31 * _result + (postPricedIndicator != null ? postPricedIndicator.hashCode() : 0);
			_result = 31 * _result + (directlyLinkedActivity != null ? directlyLinkedActivity.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegime {" +
				"name=" + this.name + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"mandatoryFacilityExecution=" + this.mandatoryFacilityExecution + ", " +
				"mandatoryFacilityExecutionException=" + this.mandatoryFacilityExecutionException + ", " +
				"mandatoryFacilityExecutionExceptionDeclaration=" + this.mandatoryFacilityExecutionExceptionDeclaration + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"entityClassification=" + this.entityClassification + ", " +
				"partyEntityClassification=" + this.partyEntityClassification + ", " +
				"tradePartyRelationshipType=" + this.tradePartyRelationshipType + ", " +
				"actionType=" + this.actionType + ", " +
				"preEnactmentTrade=" + this.preEnactmentTrade + ", " +
				"notionalType=" + this.notionalType + ", " +
				"currencyPairClassification=" + this.currencyPairClassification + ", " +
				"transmissionOfOrder=" + this.transmissionOfOrder + ", " +
				"postPricedIndicator=" + this.postPricedIndicator + ", " +
				"directlyLinkedActivity=" + this.directlyLinkedActivity + ", " +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRegime  ***********************/
	class ReportingRegimeBuilderImpl implements ReportingRegime.ReportingRegimeBuilder {
	
		protected ReportingRegimeName.ReportingRegimeNameBuilder name;
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected ReportingBoolean.ReportingBooleanBuilder mandatorilyClearable;
		protected Boolean mandatoryFacilityExecution;
		protected Boolean mandatoryFacilityExecutionException;
		protected FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder mandatoryFacilityExecutionExceptionDeclaration;
		protected Boolean exceedsClearingThreshold;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected EntityClassification.EntityClassificationBuilder entityClassification;
		protected List<PartyEntityClassification.PartyEntityClassificationBuilder> partyEntityClassification = new ArrayList<>();
		protected PartyRelationshipType.PartyRelationshipTypeBuilder tradePartyRelationshipType;
		protected ActionType.ActionTypeBuilder actionType;
		protected Boolean preEnactmentTrade;
		protected NotionalReportingType.NotionalReportingTypeBuilder notionalType;
		protected CurrencyPairClassification.CurrencyPairClassificationBuilder currencyPairClassification;
		protected Boolean transmissionOfOrder;
		protected Boolean postPricedIndicator;
		protected Boolean directlyLinkedActivity;
		protected Boolean endUserException;
		protected List<ClearingExceptionReason.ClearingExceptionReasonBuilder> endUserExceptionReason = new ArrayList<>();
		protected EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder endUserExceptionDeclaration;
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public ReportingRegimeName.ReportingRegimeNameBuilder getName() {
			return name;
		}
		
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateName() {
			ReportingRegimeName.ReportingRegimeNameBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = ReportingRegimeName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int index) {
			if (supervisorRegistration==null) {
				this.supervisorRegistration = new ArrayList<>();
			}
			return getIndex(supervisorRegistration, index, () -> {
						SupervisorRegistration.SupervisorRegistrationBuilder newSupervisorRegistration = SupervisorRegistration.builder();
						return newSupervisorRegistration;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole.ReportingRoleBuilder getReportingRole() {
			return reportingRole;
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder getOrCreateReportingRole() {
			ReportingRole.ReportingRoleBuilder result;
			if (reportingRole!=null) {
				result = reportingRole;
			}
			else {
				result = reportingRole = ReportingRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		public List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		public ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index) {
			if (reportingPurpose==null) {
				this.reportingPurpose = new ArrayList<>();
			}
			return getIndex(reportingPurpose, index, () -> {
						ReportingPurpose.ReportingPurposeBuilder newReportingPurpose = ReportingPurpose.builder();
						return newReportingPurpose;
					});
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatorilyClearable")
		public ReportingBoolean.ReportingBooleanBuilder getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		public ReportingBoolean.ReportingBooleanBuilder getOrCreateMandatorilyClearable() {
			ReportingBoolean.ReportingBooleanBuilder result;
			if (mandatorilyClearable!=null) {
				result = mandatorilyClearable;
			}
			else {
				result = mandatorilyClearable = ReportingBoolean.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryFacilityExecution")
		public Boolean getMandatoryFacilityExecution() {
			return mandatoryFacilityExecution;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryFacilityExecutionException")
		public Boolean getMandatoryFacilityExecutionException() {
			return mandatoryFacilityExecutionException;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getMandatoryFacilityExecutionExceptionDeclaration() {
			return mandatoryFacilityExecutionExceptionDeclaration;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getOrCreateMandatoryFacilityExecutionExceptionDeclaration() {
			FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder result;
			if (mandatoryFacilityExecutionExceptionDeclaration!=null) {
				result = mandatoryFacilityExecutionExceptionDeclaration;
			}
			else {
				result = mandatoryFacilityExecutionExceptionDeclaration = FacilityExecutionExceptionDeclaration.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("entityClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityClassification")
		public EntityClassification.EntityClassificationBuilder getEntityClassification() {
			return entityClassification;
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder getOrCreateEntityClassification() {
			EntityClassification.EntityClassificationBuilder result;
			if (entityClassification!=null) {
				result = entityClassification;
			}
			else {
				result = entityClassification = EntityClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyEntityClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyEntityClassification")
		public List<? extends PartyEntityClassification.PartyEntityClassificationBuilder> getPartyEntityClassification() {
			return partyEntityClassification;
		}
		
		@Override
		public PartyEntityClassification.PartyEntityClassificationBuilder getOrCreatePartyEntityClassification(int index) {
			if (partyEntityClassification==null) {
				this.partyEntityClassification = new ArrayList<>();
			}
			return getIndex(partyEntityClassification, index, () -> {
						PartyEntityClassification.PartyEntityClassificationBuilder newPartyEntityClassification = PartyEntityClassification.builder();
						return newPartyEntityClassification;
					});
		}
		
		@Override
		@RosettaAttribute("tradePartyRelationshipType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePartyRelationshipType")
		public PartyRelationshipType.PartyRelationshipTypeBuilder getTradePartyRelationshipType() {
			return tradePartyRelationshipType;
		}
		
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder getOrCreateTradePartyRelationshipType() {
			PartyRelationshipType.PartyRelationshipTypeBuilder result;
			if (tradePartyRelationshipType!=null) {
				result = tradePartyRelationshipType;
			}
			else {
				result = tradePartyRelationshipType = PartyRelationshipType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType.ActionTypeBuilder getActionType() {
			return actionType;
		}
		
		@Override
		public ActionType.ActionTypeBuilder getOrCreateActionType() {
			ActionType.ActionTypeBuilder result;
			if (actionType!=null) {
				result = actionType;
			}
			else {
				result = actionType = ActionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("preEnactmentTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("preEnactmentTrade")
		public Boolean getPreEnactmentTrade() {
			return preEnactmentTrade;
		}
		
		@Override
		@RosettaAttribute("notionalType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalType")
		public NotionalReportingType.NotionalReportingTypeBuilder getNotionalType() {
			return notionalType;
		}
		
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder getOrCreateNotionalType() {
			NotionalReportingType.NotionalReportingTypeBuilder result;
			if (notionalType!=null) {
				result = notionalType;
			}
			else {
				result = notionalType = NotionalReportingType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyPairClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyPairClassification")
		public CurrencyPairClassification.CurrencyPairClassificationBuilder getCurrencyPairClassification() {
			return currencyPairClassification;
		}
		
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder getOrCreateCurrencyPairClassification() {
			CurrencyPairClassification.CurrencyPairClassificationBuilder result;
			if (currencyPairClassification!=null) {
				result = currencyPairClassification;
			}
			else {
				result = currencyPairClassification = CurrencyPairClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transmissionOfOrder")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transmissionOfOrder")
		public Boolean getTransmissionOfOrder() {
			return transmissionOfOrder;
		}
		
		@Override
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postPricedIndicator")
		public Boolean getPostPricedIndicator() {
			return postPricedIndicator;
		}
		
		@Override
		@RosettaAttribute("directlyLinkedActivity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("directlyLinkedActivity")
		public Boolean getDirectlyLinkedActivity() {
			return directlyLinkedActivity;
		}
		
		@Override
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserException")
		public Boolean getEndUserException() {
			return endUserException;
		}
		
		@Override
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		public List<? extends ClearingExceptionReason.ClearingExceptionReasonBuilder> getEndUserExceptionReason() {
			return endUserExceptionReason;
		}
		
		@Override
		public ClearingExceptionReason.ClearingExceptionReasonBuilder getOrCreateEndUserExceptionReason(int index) {
			if (endUserExceptionReason==null) {
				this.endUserExceptionReason = new ArrayList<>();
			}
			return getIndex(endUserExceptionReason, index, () -> {
						ClearingExceptionReason.ClearingExceptionReasonBuilder newEndUserExceptionReason = ClearingExceptionReason.builder();
						return newEndUserExceptionReason;
					});
		}
		
		@Override
		@RosettaAttribute("endUserExceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endUserExceptionDeclaration")
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getEndUserExceptionDeclaration() {
			return endUserExceptionDeclaration;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getOrCreateEndUserExceptionDeclaration() {
			EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder result;
			if (endUserExceptionDeclaration!=null) {
				result = endUserExceptionDeclaration;
			}
			else {
				result = endUserExceptionDeclaration = EndUserExceptionDeclaration.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setName(ReportingRegimeName _name) {
			this.name = _name == null ? null : _name.toBuilder();
			return this;
		}
		
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		@Override
		public ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration _supervisorRegistration) {
			if (_supervisorRegistration != null) {
				this.supervisorRegistration.add(_supervisorRegistration.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(SupervisorRegistration _supervisorRegistration, int idx) {
			getIndex(this.supervisorRegistration, idx, () -> _supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (final SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations == null) {
				this.supervisorRegistration = new ArrayList<>();
			} else {
				this.supervisorRegistration = supervisorRegistrations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes != null) {
				for (final ReportingPurpose toAdd : reportingPurposes) {
					this.reportingPurpose.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatorilyClearable")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setMandatorilyClearable(ReportingBoolean _mandatorilyClearable) {
			this.mandatorilyClearable = _mandatorilyClearable == null ? null : _mandatorilyClearable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryFacilityExecution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryFacilityExecution")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setMandatoryFacilityExecution(Boolean _mandatoryFacilityExecution) {
			this.mandatoryFacilityExecution = _mandatoryFacilityExecution == null ? null : _mandatoryFacilityExecution;
			return this;
		}
		
		@RosettaAttribute("mandatoryFacilityExecutionException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryFacilityExecutionException")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setMandatoryFacilityExecutionException(Boolean _mandatoryFacilityExecutionException) {
			this.mandatoryFacilityExecutionException = _mandatoryFacilityExecutionException == null ? null : _mandatoryFacilityExecutionException;
			return this;
		}
		
		@RosettaAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setMandatoryFacilityExecutionExceptionDeclaration(FacilityExecutionExceptionDeclaration _mandatoryFacilityExecutionExceptionDeclaration) {
			this.mandatoryFacilityExecutionExceptionDeclaration = _mandatoryFacilityExecutionExceptionDeclaration == null ? null : _mandatoryFacilityExecutionExceptionDeclaration.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exceedsClearingThreshold")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setExceedsClearingThreshold(Boolean _exceedsClearingThreshold) {
			this.exceedsClearingThreshold = _exceedsClearingThreshold == null ? null : _exceedsClearingThreshold;
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("entityClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityClassification")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setEntityClassification(EntityClassification _entityClassification) {
			this.entityClassification = _entityClassification == null ? null : _entityClassification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyEntityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyEntityClassification")
		@Override
		public ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification _partyEntityClassification) {
			if (_partyEntityClassification != null) {
				this.partyEntityClassification.add(_partyEntityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(PartyEntityClassification _partyEntityClassification, int idx) {
			getIndex(this.partyEntityClassification, idx, () -> _partyEntityClassification.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassifications) {
			if (partyEntityClassifications != null) {
				for (final PartyEntityClassification toAdd : partyEntityClassifications) {
					this.partyEntityClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyEntityClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyEntityClassification")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setPartyEntityClassification(List<? extends PartyEntityClassification> partyEntityClassifications) {
			if (partyEntityClassifications == null) {
				this.partyEntityClassification = new ArrayList<>();
			} else {
				this.partyEntityClassification = partyEntityClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradePartyRelationshipType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePartyRelationshipType")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setTradePartyRelationshipType(PartyRelationshipType _tradePartyRelationshipType) {
			this.tradePartyRelationshipType = _tradePartyRelationshipType == null ? null : _tradePartyRelationshipType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setActionType(ActionType _actionType) {
			this.actionType = _actionType == null ? null : _actionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("preEnactmentTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("preEnactmentTrade")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setPreEnactmentTrade(Boolean _preEnactmentTrade) {
			this.preEnactmentTrade = _preEnactmentTrade == null ? null : _preEnactmentTrade;
			return this;
		}
		
		@RosettaAttribute("notionalType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalType")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setNotionalType(NotionalReportingType _notionalType) {
			this.notionalType = _notionalType == null ? null : _notionalType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currencyPairClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyPairClassification")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setCurrencyPairClassification(CurrencyPairClassification _currencyPairClassification) {
			this.currencyPairClassification = _currencyPairClassification == null ? null : _currencyPairClassification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transmissionOfOrder")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transmissionOfOrder")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setTransmissionOfOrder(Boolean _transmissionOfOrder) {
			this.transmissionOfOrder = _transmissionOfOrder == null ? null : _transmissionOfOrder;
			return this;
		}
		
		@RosettaAttribute("postPricedIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postPricedIndicator")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setPostPricedIndicator(Boolean _postPricedIndicator) {
			this.postPricedIndicator = _postPricedIndicator == null ? null : _postPricedIndicator;
			return this;
		}
		
		@RosettaAttribute("directlyLinkedActivity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("directlyLinkedActivity")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setDirectlyLinkedActivity(Boolean _directlyLinkedActivity) {
			this.directlyLinkedActivity = _directlyLinkedActivity == null ? null : _directlyLinkedActivity;
			return this;
		}
		
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endUserException")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setEndUserException(Boolean _endUserException) {
			this.endUserException = _endUserException == null ? null : _endUserException;
			return this;
		}
		
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		@Override
		public ReportingRegime.ReportingRegimeBuilder addEndUserExceptionReason(ClearingExceptionReason _endUserExceptionReason) {
			if (_endUserExceptionReason != null) {
				this.endUserExceptionReason.add(_endUserExceptionReason.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addEndUserExceptionReason(ClearingExceptionReason _endUserExceptionReason, int idx) {
			getIndex(this.endUserExceptionReason, idx, () -> _endUserExceptionReason.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder addEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReasons) {
			if (endUserExceptionReasons != null) {
				for (final ClearingExceptionReason toAdd : endUserExceptionReasons) {
					this.endUserExceptionReason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReasons) {
			if (endUserExceptionReasons == null) {
				this.endUserExceptionReason = new ArrayList<>();
			} else {
				this.endUserExceptionReason = endUserExceptionReasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("endUserExceptionDeclaration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endUserExceptionDeclaration")
		@Override
		public ReportingRegime.ReportingRegimeBuilder setEndUserExceptionDeclaration(EndUserExceptionDeclaration _endUserExceptionDeclaration) {
			this.endUserExceptionDeclaration = _endUserExceptionDeclaration == null ? null : _endUserExceptionDeclaration.toBuilder();
			return this;
		}
		
		@Override
		public ReportingRegime build() {
			return new ReportingRegime.ReportingRegimeImpl(this);
		}
		
		@Override
		public ReportingRegime.ReportingRegimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegime.ReportingRegimeBuilder prune() {
			if (name!=null && !name.prune().hasData()) name = null;
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (mandatorilyClearable!=null && !mandatorilyClearable.prune().hasData()) mandatorilyClearable = null;
			if (mandatoryFacilityExecutionExceptionDeclaration!=null && !mandatoryFacilityExecutionExceptionDeclaration.prune().hasData()) mandatoryFacilityExecutionExceptionDeclaration = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (entityClassification!=null && !entityClassification.prune().hasData()) entityClassification = null;
			partyEntityClassification = partyEntityClassification.stream().filter(b->b!=null).<PartyEntityClassification.PartyEntityClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradePartyRelationshipType!=null && !tradePartyRelationshipType.prune().hasData()) tradePartyRelationshipType = null;
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			if (notionalType!=null && !notionalType.prune().hasData()) notionalType = null;
			if (currencyPairClassification!=null && !currencyPairClassification.prune().hasData()) currencyPairClassification = null;
			endUserExceptionReason = endUserExceptionReason.stream().filter(b->b!=null).<ClearingExceptionReason.ClearingExceptionReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (endUserExceptionDeclaration!=null && !endUserExceptionDeclaration.prune().hasData()) endUserExceptionDeclaration = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null && getName().hasData()) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMandatorilyClearable()!=null && getMandatorilyClearable().hasData()) return true;
			if (getMandatoryFacilityExecution()!=null) return true;
			if (getMandatoryFacilityExecutionException()!=null) return true;
			if (getMandatoryFacilityExecutionExceptionDeclaration()!=null && getMandatoryFacilityExecutionExceptionDeclaration().hasData()) return true;
			if (getExceedsClearingThreshold()!=null) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEntityClassification()!=null && getEntityClassification().hasData()) return true;
			if (getPartyEntityClassification()!=null && getPartyEntityClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradePartyRelationshipType()!=null && getTradePartyRelationshipType().hasData()) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			if (getPreEnactmentTrade()!=null) return true;
			if (getNotionalType()!=null && getNotionalType().hasData()) return true;
			if (getCurrencyPairClassification()!=null && getCurrencyPairClassification().hasData()) return true;
			if (getTransmissionOfOrder()!=null) return true;
			if (getPostPricedIndicator()!=null) return true;
			if (getDirectlyLinkedActivity()!=null) return true;
			if (getEndUserException()!=null) return true;
			if (getEndUserExceptionReason()!=null && getEndUserExceptionReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEndUserExceptionDeclaration()!=null && getEndUserExceptionDeclaration().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegime.ReportingRegimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRegime.ReportingRegimeBuilder o = (ReportingRegime.ReportingRegimeBuilder) other;
			
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getMandatorilyClearable(), o.getMandatorilyClearable(), this::setMandatorilyClearable);
			merger.mergeRosetta(getMandatoryFacilityExecutionExceptionDeclaration(), o.getMandatoryFacilityExecutionExceptionDeclaration(), this::setMandatoryFacilityExecutionExceptionDeclaration);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getEntityClassification(), o.getEntityClassification(), this::setEntityClassification);
			merger.mergeRosetta(getPartyEntityClassification(), o.getPartyEntityClassification(), this::getOrCreatePartyEntityClassification);
			merger.mergeRosetta(getTradePartyRelationshipType(), o.getTradePartyRelationshipType(), this::setTradePartyRelationshipType);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			merger.mergeRosetta(getNotionalType(), o.getNotionalType(), this::setNotionalType);
			merger.mergeRosetta(getCurrencyPairClassification(), o.getCurrencyPairClassification(), this::setCurrencyPairClassification);
			merger.mergeRosetta(getEndUserExceptionReason(), o.getEndUserExceptionReason(), this::getOrCreateEndUserExceptionReason);
			merger.mergeRosetta(getEndUserExceptionDeclaration(), o.getEndUserExceptionDeclaration(), this::setEndUserExceptionDeclaration);
			
			merger.mergeBasic(getMandatoryFacilityExecution(), o.getMandatoryFacilityExecution(), this::setMandatoryFacilityExecution);
			merger.mergeBasic(getMandatoryFacilityExecutionException(), o.getMandatoryFacilityExecutionException(), this::setMandatoryFacilityExecutionException);
			merger.mergeBasic(getExceedsClearingThreshold(), o.getExceedsClearingThreshold(), this::setExceedsClearingThreshold);
			merger.mergeBasic(getPreEnactmentTrade(), o.getPreEnactmentTrade(), this::setPreEnactmentTrade);
			merger.mergeBasic(getTransmissionOfOrder(), o.getTransmissionOfOrder(), this::setTransmissionOfOrder);
			merger.mergeBasic(getPostPricedIndicator(), o.getPostPricedIndicator(), this::setPostPricedIndicator);
			merger.mergeBasic(getDirectlyLinkedActivity(), o.getDirectlyLinkedActivity(), this::setDirectlyLinkedActivity);
			merger.mergeBasic(getEndUserException(), o.getEndUserException(), this::setEndUserException);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegime _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(mandatoryFacilityExecution, _that.getMandatoryFacilityExecution())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionException, _that.getMandatoryFacilityExecutionException())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionExceptionDeclaration, _that.getMandatoryFacilityExecutionExceptionDeclaration())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(entityClassification, _that.getEntityClassification())) return false;
			if (!ListEquals.listEquals(partyEntityClassification, _that.getPartyEntityClassification())) return false;
			if (!Objects.equals(tradePartyRelationshipType, _that.getTradePartyRelationshipType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(preEnactmentTrade, _that.getPreEnactmentTrade())) return false;
			if (!Objects.equals(notionalType, _that.getNotionalType())) return false;
			if (!Objects.equals(currencyPairClassification, _that.getCurrencyPairClassification())) return false;
			if (!Objects.equals(transmissionOfOrder, _that.getTransmissionOfOrder())) return false;
			if (!Objects.equals(postPricedIndicator, _that.getPostPricedIndicator())) return false;
			if (!Objects.equals(directlyLinkedActivity, _that.getDirectlyLinkedActivity())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!ListEquals.listEquals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecution != null ? mandatoryFacilityExecution.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionException != null ? mandatoryFacilityExecutionException.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionExceptionDeclaration != null ? mandatoryFacilityExecutionExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (entityClassification != null ? entityClassification.hashCode() : 0);
			_result = 31 * _result + (partyEntityClassification != null ? partyEntityClassification.hashCode() : 0);
			_result = 31 * _result + (tradePartyRelationshipType != null ? tradePartyRelationshipType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (preEnactmentTrade != null ? preEnactmentTrade.hashCode() : 0);
			_result = 31 * _result + (notionalType != null ? notionalType.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassification != null ? currencyPairClassification.hashCode() : 0);
			_result = 31 * _result + (transmissionOfOrder != null ? transmissionOfOrder.hashCode() : 0);
			_result = 31 * _result + (postPricedIndicator != null ? postPricedIndicator.hashCode() : 0);
			_result = 31 * _result + (directlyLinkedActivity != null ? directlyLinkedActivity.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeBuilder {" +
				"name=" + this.name + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"mandatoryFacilityExecution=" + this.mandatoryFacilityExecution + ", " +
				"mandatoryFacilityExecutionException=" + this.mandatoryFacilityExecutionException + ", " +
				"mandatoryFacilityExecutionExceptionDeclaration=" + this.mandatoryFacilityExecutionExceptionDeclaration + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"entityClassification=" + this.entityClassification + ", " +
				"partyEntityClassification=" + this.partyEntityClassification + ", " +
				"tradePartyRelationshipType=" + this.tradePartyRelationshipType + ", " +
				"actionType=" + this.actionType + ", " +
				"preEnactmentTrade=" + this.preEnactmentTrade + ", " +
				"notionalType=" + this.notionalType + ", " +
				"currencyPairClassification=" + this.currencyPairClassification + ", " +
				"transmissionOfOrder=" + this.transmissionOfOrder + ", " +
				"postPricedIndicator=" + this.postPricedIndicator + ", " +
				"directlyLinkedActivity=" + this.directlyLinkedActivity + ", " +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration +
			'}';
		}
	}
}
