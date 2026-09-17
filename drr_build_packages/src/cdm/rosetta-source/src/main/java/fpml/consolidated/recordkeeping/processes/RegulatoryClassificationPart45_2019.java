package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.ClearingExceptionReason;
import fpml.consolidated.doc.ConfirmationMethod;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.ExecutionType;
import fpml.consolidated.doc.ExecutionVenueType;
import fpml.consolidated.doc.ReportingBoolean;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.TradeCategory;
import fpml.consolidated.doc.VerificationMethod;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationPart45_2019Meta;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="RegulatoryClassificationPart45_2019", builder=RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationPart45_2019", model="fpml", builder=RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationPart45_2019 extends RegulatoryClassification {

	RegulatoryClassificationPart45_2019Meta metaData = new RegulatoryClassificationPart45_2019Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<String> getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	List<? extends ReportingPurpose> getReportingPurpose();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the buyer
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the seller.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the particular trade type in question is required by this regulator to be cleared. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ReportingBoolean getMandatorilyClearable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade is not obligated to be cleared via a derivative clearing organization, i.e. wehter there is an exemption from clearing. For historical reasons this is called "end-user exception", but this may be used to indication any exception from normal clearing mandates caused by the type of the partiees or their relationship, such as inter-affiliate trades. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getEndUserException();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a reason that the trade is exempted from a clearing requirement. This exemption may be an end-user exception, or another type such as in inter-affiliate trade. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<? extends ClearingExceptionReason> getEndUserExceptionReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Claims an end user exception and provides supporting evidence. If a relatedParty block with a role of ClearingExceptionParty is present, that related party indicates which party is claiming the end user exception. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	EndUserExceptionDeclaration getEndUserExceptionDeclaration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the sender of this trade considers it to be a large notional trade or block trade for reporting purposes, and thus eligible for delayed public reporting. Normally this will only be applicable for off-facility trades. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getLargeSizeTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe how the trade was executed, e.g. via voice or electronically. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ExecutionType getExecutionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe the type of venue where trade was executed, e.g via an execution facility or privately. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ExecutionVenueType getExecutionVenueType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe how the trade was or will be verified, e.g via a confirmation facility, via private electronic service, or via written documentation. This affect the timing of real-time reporting requirements. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	VerificationMethod getVerificationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to describe how the trade was confirmed, e.g via a confirmation facility, via private electronic service, or via written documentation. This affects the process flow for confirmation messages. This field is provisional pending detailed confirmation of the data requirements, and may not be included in subsequent working drafts. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ConfirmationMethod getConfirmationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	CollateralizationType getCollateralizationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision E.g. SD, MSP, etc. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	String getReportingPartyOrganizationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision E.g. SD, MSP, etc. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	String getCounterPartyOrganizationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision whether the counterparty is a US person DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getCounterPartyIsUsPerson();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be allocated, has been allocated, or will not be allocated. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	AllocationReportingStatus getAllocationStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the reporting party takes a Principal or an Agent role in this trade. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	TradeCategory getClientAccountType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies which party is electing the inter-affiliate exmption to the clearing requirement pursuant to section 50.52 DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	PartyReference getInterAffiliateClearingExemptionParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the type of clearing exemption that the Counterparty 1 has elected (if not indicated previously). All applicable exceptions and exemption must be selected. The values may be repeacted as applicable. TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<String> getReportingPartyClearingExemption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the type of clearing exemption that the Counterparty 2 has elected (if not indicated previously). All applicable exceptions and exemption must be selected. The values may be repeacted as applicable. TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<String> getCounterPartyClearingExemption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the types of collateral that may be posted according to the CSA. TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<String> getCollateralTypeAllowed();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicator of whether the collateral portfolio includes transactions exempt from reporting. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getCollateralPortfolioContainsNonReportableComponents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicator of whether the package in which this trade was traded includes transactions exempt from reporting. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getPackageContainsNonReportableComponents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of Special entity/utility special entity that is reported by the reporting counterparty as per Section 23.401(c) and Section 1.3 (ggg)(4)(i)(B)(2), respectively. Note that "utility special entity" is a subset of "special entity." TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	String getSpecialEntityType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type. TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ActionType getActionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Explanation for the action being take on the transaction. TBD: FpML doesn’t currently define a coding scheme for this value. We anticipate that one will be developed in a future release. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	String getEventType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The data element will indicate if the swap is subject to the trade execution requirement under CEA section 2(h)(8). If the swap is subject to an exemption from CEA section 2(h)(8)(a), this data element shall be populated with the value "False". DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getTradeExecutionRequirementIndicator();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date of the most recent sampling of the floating reference for the purposes of determining cashflow. Ties to "Last Floating Reference Value" field. DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ZonedDateTime getLastFloatingReferenceResetDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The nearest date in the future that the floating reference resets on DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	ZonedDateTime getNextFloatingReferenceResetDate();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationPart45_2019 build();
	
	RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder toBuilder();
	
	static RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder builder() {
		return new RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationPart45_2019> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationPart45_2019> getType() {
		return RegulatoryClassificationPart45_2019.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("mandatorilyClearable"), processor, ReportingBoolean.class, getMandatorilyClearable());
		processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
		processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.class, getEndUserExceptionReason());
		processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.class, getEndUserExceptionDeclaration());
		processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
		processRosetta(path.newSubPath("executionType"), processor, ExecutionType.class, getExecutionType());
		processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.class, getExecutionVenueType());
		processRosetta(path.newSubPath("verificationMethod"), processor, VerificationMethod.class, getVerificationMethod());
		processRosetta(path.newSubPath("confirmationMethod"), processor, ConfirmationMethod.class, getConfirmationMethod());
		processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.class, getCollateralizationType());
		processor.processBasic(path.newSubPath("reportingPartyOrganizationType"), String.class, getReportingPartyOrganizationType(), this);
		processor.processBasic(path.newSubPath("counterPartyOrganizationType"), String.class, getCounterPartyOrganizationType(), this);
		processor.processBasic(path.newSubPath("counterPartyIsUsPerson"), Boolean.class, getCounterPartyIsUsPerson(), this);
		processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.class, getAllocationStatus());
		processRosetta(path.newSubPath("clientAccountType"), processor, TradeCategory.class, getClientAccountType());
		processRosetta(path.newSubPath("interAffiliateClearingExemptionParty"), processor, PartyReference.class, getInterAffiliateClearingExemptionParty());
		processor.processBasic(path.newSubPath("reportingPartyClearingExemption"), String.class, getReportingPartyClearingExemption(), this);
		processor.processBasic(path.newSubPath("counterPartyClearingExemption"), String.class, getCounterPartyClearingExemption(), this);
		processor.processBasic(path.newSubPath("collateralTypeAllowed"), String.class, getCollateralTypeAllowed(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioContainsNonReportableComponents"), Boolean.class, getCollateralPortfolioContainsNonReportableComponents(), this);
		processor.processBasic(path.newSubPath("packageContainsNonReportableComponents"), Boolean.class, getPackageContainsNonReportableComponents(), this);
		processor.processBasic(path.newSubPath("specialEntityType"), String.class, getSpecialEntityType(), this);
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
		processor.processBasic(path.newSubPath("eventType"), String.class, getEventType(), this);
		processor.processBasic(path.newSubPath("tradeExecutionRequirementIndicator"), Boolean.class, getTradeExecutionRequirementIndicator(), this);
		processor.processBasic(path.newSubPath("lastFloatingReferenceResetDate"), ZonedDateTime.class, getLastFloatingReferenceResetDate(), this);
		processor.processBasic(path.newSubPath("nextFloatingReferenceResetDate"), ZonedDateTime.class, getNextFloatingReferenceResetDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationPart45_2019Builder extends RegulatoryClassificationPart45_2019, RegulatoryClassification.RegulatoryClassificationBuilder {
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		ReportingBoolean.ReportingBooleanBuilder getOrCreateMandatorilyClearable();
		@Override
		ReportingBoolean.ReportingBooleanBuilder getMandatorilyClearable();
		ClearingExceptionReason.ClearingExceptionReasonBuilder getOrCreateEndUserExceptionReason(int index);
		@Override
		List<? extends ClearingExceptionReason.ClearingExceptionReasonBuilder> getEndUserExceptionReason();
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getOrCreateEndUserExceptionDeclaration();
		@Override
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder getEndUserExceptionDeclaration();
		ExecutionType.ExecutionTypeBuilder getOrCreateExecutionType();
		@Override
		ExecutionType.ExecutionTypeBuilder getExecutionType();
		ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType();
		@Override
		ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType();
		VerificationMethod.VerificationMethodBuilder getOrCreateVerificationMethod();
		@Override
		VerificationMethod.VerificationMethodBuilder getVerificationMethod();
		ConfirmationMethod.ConfirmationMethodBuilder getOrCreateConfirmationMethod();
		@Override
		ConfirmationMethod.ConfirmationMethodBuilder getConfirmationMethod();
		CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType();
		@Override
		CollateralizationType.CollateralizationTypeBuilder getCollateralizationType();
		AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus();
		@Override
		AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus();
		TradeCategory.TradeCategoryBuilder getOrCreateClientAccountType();
		@Override
		TradeCategory.TradeCategoryBuilder getClientAccountType();
		PartyReference.PartyReferenceBuilder getOrCreateInterAffiliateClearingExemptionParty();
		@Override
		PartyReference.PartyReferenceBuilder getInterAffiliateClearingExemptionParty();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		@Override
		ActionType.ActionTypeBuilder getActionType();
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setBuyerPartyReference(PartyReference buyerPartyReference);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setSellerPartyReference(PartyReference sellerPartyReference);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setMandatorilyClearable(ReportingBoolean mandatorilyClearable);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEndUserException(Boolean endUserException);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addEndUserExceptionReason(ClearingExceptionReason endUserExceptionReason, int idx);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReason);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReason);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEndUserExceptionDeclaration(EndUserExceptionDeclaration endUserExceptionDeclaration);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setLargeSizeTrade(Boolean largeSizeTrade);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setExecutionType(ExecutionType executionType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setExecutionVenueType(ExecutionVenueType executionVenueType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setVerificationMethod(VerificationMethod verificationMethod);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setConfirmationMethod(ConfirmationMethod confirmationMethod);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCollateralizationType(CollateralizationType collateralizationType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingPartyOrganizationType(String reportingPartyOrganizationType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCounterPartyOrganizationType(String counterPartyOrganizationType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCounterPartyIsUsPerson(Boolean counterPartyIsUsPerson);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setAllocationStatus(AllocationReportingStatus allocationStatus);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setClientAccountType(TradeCategory clientAccountType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setInterAffiliateClearingExemptionParty(PartyReference interAffiliateClearingExemptionParty);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPartyClearingExemption(String reportingPartyClearingExemption);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPartyClearingExemption(String reportingPartyClearingExemption, int idx);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPartyClearingExemption(List<String> reportingPartyClearingExemption);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingPartyClearingExemption(List<String> reportingPartyClearingExemption);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCounterPartyClearingExemption(String counterPartyClearingExemption);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCounterPartyClearingExemption(String counterPartyClearingExemption, int idx);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCounterPartyClearingExemption(List<String> counterPartyClearingExemption);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCounterPartyClearingExemption(List<String> counterPartyClearingExemption);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCollateralTypeAllowed(String collateralTypeAllowed);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCollateralTypeAllowed(String collateralTypeAllowed, int idx);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCollateralTypeAllowed(List<String> collateralTypeAllowed);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCollateralTypeAllowed(List<String> collateralTypeAllowed);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCollateralPortfolioContainsNonReportableComponents(Boolean collateralPortfolioContainsNonReportableComponents);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setPackageContainsNonReportableComponents(Boolean packageContainsNonReportableComponents);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setSpecialEntityType(String specialEntityType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setActionType(ActionType actionType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEventType(String eventType);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setTradeExecutionRequirementIndicator(Boolean tradeExecutionRequirementIndicator);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setLastFloatingReferenceResetDate(ZonedDateTime lastFloatingReferenceResetDate);
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setNextFloatingReferenceResetDate(ZonedDateTime nextFloatingReferenceResetDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("mandatorilyClearable"), processor, ReportingBoolean.ReportingBooleanBuilder.class, getMandatorilyClearable());
			processor.processBasic(path.newSubPath("endUserException"), Boolean.class, getEndUserException(), this);
			processRosetta(path.newSubPath("endUserExceptionReason"), processor, ClearingExceptionReason.ClearingExceptionReasonBuilder.class, getEndUserExceptionReason());
			processRosetta(path.newSubPath("endUserExceptionDeclaration"), processor, EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder.class, getEndUserExceptionDeclaration());
			processor.processBasic(path.newSubPath("largeSizeTrade"), Boolean.class, getLargeSizeTrade(), this);
			processRosetta(path.newSubPath("executionType"), processor, ExecutionType.ExecutionTypeBuilder.class, getExecutionType());
			processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.ExecutionVenueTypeBuilder.class, getExecutionVenueType());
			processRosetta(path.newSubPath("verificationMethod"), processor, VerificationMethod.VerificationMethodBuilder.class, getVerificationMethod());
			processRosetta(path.newSubPath("confirmationMethod"), processor, ConfirmationMethod.ConfirmationMethodBuilder.class, getConfirmationMethod());
			processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.CollateralizationTypeBuilder.class, getCollateralizationType());
			processor.processBasic(path.newSubPath("reportingPartyOrganizationType"), String.class, getReportingPartyOrganizationType(), this);
			processor.processBasic(path.newSubPath("counterPartyOrganizationType"), String.class, getCounterPartyOrganizationType(), this);
			processor.processBasic(path.newSubPath("counterPartyIsUsPerson"), Boolean.class, getCounterPartyIsUsPerson(), this);
			processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.AllocationReportingStatusBuilder.class, getAllocationStatus());
			processRosetta(path.newSubPath("clientAccountType"), processor, TradeCategory.TradeCategoryBuilder.class, getClientAccountType());
			processRosetta(path.newSubPath("interAffiliateClearingExemptionParty"), processor, PartyReference.PartyReferenceBuilder.class, getInterAffiliateClearingExemptionParty());
			processor.processBasic(path.newSubPath("reportingPartyClearingExemption"), String.class, getReportingPartyClearingExemption(), this);
			processor.processBasic(path.newSubPath("counterPartyClearingExemption"), String.class, getCounterPartyClearingExemption(), this);
			processor.processBasic(path.newSubPath("collateralTypeAllowed"), String.class, getCollateralTypeAllowed(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioContainsNonReportableComponents"), Boolean.class, getCollateralPortfolioContainsNonReportableComponents(), this);
			processor.processBasic(path.newSubPath("packageContainsNonReportableComponents"), Boolean.class, getPackageContainsNonReportableComponents(), this);
			processor.processBasic(path.newSubPath("specialEntityType"), String.class, getSpecialEntityType(), this);
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
			processor.processBasic(path.newSubPath("eventType"), String.class, getEventType(), this);
			processor.processBasic(path.newSubPath("tradeExecutionRequirementIndicator"), Boolean.class, getTradeExecutionRequirementIndicator(), this);
			processor.processBasic(path.newSubPath("lastFloatingReferenceResetDate"), ZonedDateTime.class, getLastFloatingReferenceResetDate(), this);
			processor.processBasic(path.newSubPath("nextFloatingReferenceResetDate"), ZonedDateTime.class, getNextFloatingReferenceResetDate(), this);
		}
		

		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationPart45_2019  ***********************/
	class RegulatoryClassificationPart45_2019Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationPart45_2019 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		private final ReportingBoolean mandatorilyClearable;
		private final Boolean endUserException;
		private final List<? extends ClearingExceptionReason> endUserExceptionReason;
		private final EndUserExceptionDeclaration endUserExceptionDeclaration;
		private final Boolean largeSizeTrade;
		private final ExecutionType executionType;
		private final ExecutionVenueType executionVenueType;
		private final VerificationMethod verificationMethod;
		private final ConfirmationMethod confirmationMethod;
		private final CollateralizationType collateralizationType;
		private final String reportingPartyOrganizationType;
		private final String counterPartyOrganizationType;
		private final Boolean counterPartyIsUsPerson;
		private final AllocationReportingStatus allocationStatus;
		private final TradeCategory clientAccountType;
		private final PartyReference interAffiliateClearingExemptionParty;
		private final List<String> reportingPartyClearingExemption;
		private final List<String> counterPartyClearingExemption;
		private final List<String> collateralTypeAllowed;
		private final Boolean collateralPortfolioContainsNonReportableComponents;
		private final Boolean packageContainsNonReportableComponents;
		private final String specialEntityType;
		private final ActionType actionType;
		private final String eventType;
		private final Boolean tradeExecutionRequirementIndicator;
		private final ZonedDateTime lastFloatingReferenceResetDate;
		private final ZonedDateTime nextFloatingReferenceResetDate;
		
		protected RegulatoryClassificationPart45_2019Impl(RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.mandatorilyClearable = ofNullable(builder.getMandatorilyClearable()).map(f->f.build()).orElse(null);
			this.endUserException = builder.getEndUserException();
			this.endUserExceptionReason = ofNullable(builder.getEndUserExceptionReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.endUserExceptionDeclaration = ofNullable(builder.getEndUserExceptionDeclaration()).map(f->f.build()).orElse(null);
			this.largeSizeTrade = builder.getLargeSizeTrade();
			this.executionType = ofNullable(builder.getExecutionType()).map(f->f.build()).orElse(null);
			this.executionVenueType = ofNullable(builder.getExecutionVenueType()).map(f->f.build()).orElse(null);
			this.verificationMethod = ofNullable(builder.getVerificationMethod()).map(f->f.build()).orElse(null);
			this.confirmationMethod = ofNullable(builder.getConfirmationMethod()).map(f->f.build()).orElse(null);
			this.collateralizationType = ofNullable(builder.getCollateralizationType()).map(f->f.build()).orElse(null);
			this.reportingPartyOrganizationType = builder.getReportingPartyOrganizationType();
			this.counterPartyOrganizationType = builder.getCounterPartyOrganizationType();
			this.counterPartyIsUsPerson = builder.getCounterPartyIsUsPerson();
			this.allocationStatus = ofNullable(builder.getAllocationStatus()).map(f->f.build()).orElse(null);
			this.clientAccountType = ofNullable(builder.getClientAccountType()).map(f->f.build()).orElse(null);
			this.interAffiliateClearingExemptionParty = ofNullable(builder.getInterAffiliateClearingExemptionParty()).map(f->f.build()).orElse(null);
			this.reportingPartyClearingExemption = ofNullable(builder.getReportingPartyClearingExemption()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.counterPartyClearingExemption = ofNullable(builder.getCounterPartyClearingExemption()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.collateralTypeAllowed = ofNullable(builder.getCollateralTypeAllowed()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.collateralPortfolioContainsNonReportableComponents = builder.getCollateralPortfolioContainsNonReportableComponents();
			this.packageContainsNonReportableComponents = builder.getPackageContainsNonReportableComponents();
			this.specialEntityType = builder.getSpecialEntityType();
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
			this.eventType = builder.getEventType();
			this.tradeExecutionRequirementIndicator = builder.getTradeExecutionRequirementIndicator();
			this.lastFloatingReferenceResetDate = builder.getLastFloatingReferenceResetDate();
			this.nextFloatingReferenceResetDate = builder.getNextFloatingReferenceResetDate();
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<String> getSupervisoryBody() {
			return supervisoryBody;
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
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatorilyClearable")
		public ReportingBoolean getMandatorilyClearable() {
			return mandatorilyClearable;
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
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("executionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionType")
		public ExecutionType getExecutionType() {
			return executionType;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueType getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		@RosettaAttribute("verificationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationMethod")
		public VerificationMethod getVerificationMethod() {
			return verificationMethod;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationMethod")
		public ConfirmationMethod getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizationType")
		public CollateralizationType getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		@RosettaAttribute("reportingPartyOrganizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingPartyOrganizationType")
		public String getReportingPartyOrganizationType() {
			return reportingPartyOrganizationType;
		}
		
		@Override
		@RosettaAttribute("counterPartyOrganizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyOrganizationType")
		public String getCounterPartyOrganizationType() {
			return counterPartyOrganizationType;
		}
		
		@Override
		@RosettaAttribute("counterPartyIsUsPerson")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyIsUsPerson")
		public Boolean getCounterPartyIsUsPerson() {
			return counterPartyIsUsPerson;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationStatus")
		public AllocationReportingStatus getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		@RosettaAttribute("clientAccountType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clientAccountType")
		public TradeCategory getClientAccountType() {
			return clientAccountType;
		}
		
		@Override
		@RosettaAttribute("interAffiliateClearingExemptionParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interAffiliateClearingExemptionParty")
		public PartyReference getInterAffiliateClearingExemptionParty() {
			return interAffiliateClearingExemptionParty;
		}
		
		@Override
		@RosettaAttribute("reportingPartyClearingExemption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPartyClearingExemption")
		public List<String> getReportingPartyClearingExemption() {
			return reportingPartyClearingExemption;
		}
		
		@Override
		@RosettaAttribute("counterPartyClearingExemption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("counterPartyClearingExemption")
		public List<String> getCounterPartyClearingExemption() {
			return counterPartyClearingExemption;
		}
		
		@Override
		@RosettaAttribute("collateralTypeAllowed")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralTypeAllowed")
		public List<String> getCollateralTypeAllowed() {
			return collateralTypeAllowed;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioContainsNonReportableComponents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioContainsNonReportableComponents")
		public Boolean getCollateralPortfolioContainsNonReportableComponents() {
			return collateralPortfolioContainsNonReportableComponents;
		}
		
		@Override
		@RosettaAttribute("packageContainsNonReportableComponents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageContainsNonReportableComponents")
		public Boolean getPackageContainsNonReportableComponents() {
			return packageContainsNonReportableComponents;
		}
		
		@Override
		@RosettaAttribute("specialEntityType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specialEntityType")
		public String getSpecialEntityType() {
			return specialEntityType;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventType")
		public String getEventType() {
			return eventType;
		}
		
		@Override
		@RosettaAttribute("tradeExecutionRequirementIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeExecutionRequirementIndicator")
		public Boolean getTradeExecutionRequirementIndicator() {
			return tradeExecutionRequirementIndicator;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDate")
		public ZonedDateTime getLastFloatingReferenceResetDate() {
			return lastFloatingReferenceResetDate;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		public ZonedDateTime getNextFloatingReferenceResetDate() {
			return nextFloatingReferenceResetDate;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder toBuilder() {
			RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getMandatorilyClearable()).ifPresent(builder::setMandatorilyClearable);
			ofNullable(getEndUserException()).ifPresent(builder::setEndUserException);
			ofNullable(getEndUserExceptionReason()).ifPresent(builder::setEndUserExceptionReason);
			ofNullable(getEndUserExceptionDeclaration()).ifPresent(builder::setEndUserExceptionDeclaration);
			ofNullable(getLargeSizeTrade()).ifPresent(builder::setLargeSizeTrade);
			ofNullable(getExecutionType()).ifPresent(builder::setExecutionType);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
			ofNullable(getVerificationMethod()).ifPresent(builder::setVerificationMethod);
			ofNullable(getConfirmationMethod()).ifPresent(builder::setConfirmationMethod);
			ofNullable(getCollateralizationType()).ifPresent(builder::setCollateralizationType);
			ofNullable(getReportingPartyOrganizationType()).ifPresent(builder::setReportingPartyOrganizationType);
			ofNullable(getCounterPartyOrganizationType()).ifPresent(builder::setCounterPartyOrganizationType);
			ofNullable(getCounterPartyIsUsPerson()).ifPresent(builder::setCounterPartyIsUsPerson);
			ofNullable(getAllocationStatus()).ifPresent(builder::setAllocationStatus);
			ofNullable(getClientAccountType()).ifPresent(builder::setClientAccountType);
			ofNullable(getInterAffiliateClearingExemptionParty()).ifPresent(builder::setInterAffiliateClearingExemptionParty);
			ofNullable(getReportingPartyClearingExemption()).ifPresent(builder::setReportingPartyClearingExemption);
			ofNullable(getCounterPartyClearingExemption()).ifPresent(builder::setCounterPartyClearingExemption);
			ofNullable(getCollateralTypeAllowed()).ifPresent(builder::setCollateralTypeAllowed);
			ofNullable(getCollateralPortfolioContainsNonReportableComponents()).ifPresent(builder::setCollateralPortfolioContainsNonReportableComponents);
			ofNullable(getPackageContainsNonReportableComponents()).ifPresent(builder::setPackageContainsNonReportableComponents);
			ofNullable(getSpecialEntityType()).ifPresent(builder::setSpecialEntityType);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getEventType()).ifPresent(builder::setEventType);
			ofNullable(getTradeExecutionRequirementIndicator()).ifPresent(builder::setTradeExecutionRequirementIndicator);
			ofNullable(getLastFloatingReferenceResetDate()).ifPresent(builder::setLastFloatingReferenceResetDate);
			ofNullable(getNextFloatingReferenceResetDate()).ifPresent(builder::setNextFloatingReferenceResetDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationPart45_2019 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!ListEquals.listEquals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(verificationMethod, _that.getVerificationMethod())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(reportingPartyOrganizationType, _that.getReportingPartyOrganizationType())) return false;
			if (!Objects.equals(counterPartyOrganizationType, _that.getCounterPartyOrganizationType())) return false;
			if (!Objects.equals(counterPartyIsUsPerson, _that.getCounterPartyIsUsPerson())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(clientAccountType, _that.getClientAccountType())) return false;
			if (!Objects.equals(interAffiliateClearingExemptionParty, _that.getInterAffiliateClearingExemptionParty())) return false;
			if (!ListEquals.listEquals(reportingPartyClearingExemption, _that.getReportingPartyClearingExemption())) return false;
			if (!ListEquals.listEquals(counterPartyClearingExemption, _that.getCounterPartyClearingExemption())) return false;
			if (!ListEquals.listEquals(collateralTypeAllowed, _that.getCollateralTypeAllowed())) return false;
			if (!Objects.equals(collateralPortfolioContainsNonReportableComponents, _that.getCollateralPortfolioContainsNonReportableComponents())) return false;
			if (!Objects.equals(packageContainsNonReportableComponents, _that.getPackageContainsNonReportableComponents())) return false;
			if (!Objects.equals(specialEntityType, _that.getSpecialEntityType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(tradeExecutionRequirementIndicator, _that.getTradeExecutionRequirementIndicator())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDate, _that.getLastFloatingReferenceResetDate())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDate, _that.getNextFloatingReferenceResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (executionType != null ? executionType.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (verificationMethod != null ? verificationMethod.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (reportingPartyOrganizationType != null ? reportingPartyOrganizationType.hashCode() : 0);
			_result = 31 * _result + (counterPartyOrganizationType != null ? counterPartyOrganizationType.hashCode() : 0);
			_result = 31 * _result + (counterPartyIsUsPerson != null ? counterPartyIsUsPerson.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (clientAccountType != null ? clientAccountType.hashCode() : 0);
			_result = 31 * _result + (interAffiliateClearingExemptionParty != null ? interAffiliateClearingExemptionParty.hashCode() : 0);
			_result = 31 * _result + (reportingPartyClearingExemption != null ? reportingPartyClearingExemption.hashCode() : 0);
			_result = 31 * _result + (counterPartyClearingExemption != null ? counterPartyClearingExemption.hashCode() : 0);
			_result = 31 * _result + (collateralTypeAllowed != null ? collateralTypeAllowed.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioContainsNonReportableComponents != null ? collateralPortfolioContainsNonReportableComponents.hashCode() : 0);
			_result = 31 * _result + (packageContainsNonReportableComponents != null ? packageContainsNonReportableComponents.hashCode() : 0);
			_result = 31 * _result + (specialEntityType != null ? specialEntityType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			_result = 31 * _result + (tradeExecutionRequirementIndicator != null ? tradeExecutionRequirementIndicator.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDate != null ? lastFloatingReferenceResetDate.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDate != null ? nextFloatingReferenceResetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationPart45_2019 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"executionType=" + this.executionType + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"verificationMethod=" + this.verificationMethod + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"reportingPartyOrganizationType=" + this.reportingPartyOrganizationType + ", " +
				"counterPartyOrganizationType=" + this.counterPartyOrganizationType + ", " +
				"counterPartyIsUsPerson=" + this.counterPartyIsUsPerson + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"clientAccountType=" + this.clientAccountType + ", " +
				"interAffiliateClearingExemptionParty=" + this.interAffiliateClearingExemptionParty + ", " +
				"reportingPartyClearingExemption=" + this.reportingPartyClearingExemption + ", " +
				"counterPartyClearingExemption=" + this.counterPartyClearingExemption + ", " +
				"collateralTypeAllowed=" + this.collateralTypeAllowed + ", " +
				"collateralPortfolioContainsNonReportableComponents=" + this.collateralPortfolioContainsNonReportableComponents + ", " +
				"packageContainsNonReportableComponents=" + this.packageContainsNonReportableComponents + ", " +
				"specialEntityType=" + this.specialEntityType + ", " +
				"actionType=" + this.actionType + ", " +
				"eventType=" + this.eventType + ", " +
				"tradeExecutionRequirementIndicator=" + this.tradeExecutionRequirementIndicator + ", " +
				"lastFloatingReferenceResetDate=" + this.lastFloatingReferenceResetDate + ", " +
				"nextFloatingReferenceResetDate=" + this.nextFloatingReferenceResetDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationPart45_2019  ***********************/
	class RegulatoryClassificationPart45_2019BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected ReportingBoolean.ReportingBooleanBuilder mandatorilyClearable;
		protected Boolean endUserException;
		protected List<ClearingExceptionReason.ClearingExceptionReasonBuilder> endUserExceptionReason = new ArrayList<>();
		protected EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder endUserExceptionDeclaration;
		protected Boolean largeSizeTrade;
		protected ExecutionType.ExecutionTypeBuilder executionType;
		protected ExecutionVenueType.ExecutionVenueTypeBuilder executionVenueType;
		protected VerificationMethod.VerificationMethodBuilder verificationMethod;
		protected ConfirmationMethod.ConfirmationMethodBuilder confirmationMethod;
		protected CollateralizationType.CollateralizationTypeBuilder collateralizationType;
		protected String reportingPartyOrganizationType;
		protected String counterPartyOrganizationType;
		protected Boolean counterPartyIsUsPerson;
		protected AllocationReportingStatus.AllocationReportingStatusBuilder allocationStatus;
		protected TradeCategory.TradeCategoryBuilder clientAccountType;
		protected PartyReference.PartyReferenceBuilder interAffiliateClearingExemptionParty;
		protected List<String> reportingPartyClearingExemption = new ArrayList<>();
		protected List<String> counterPartyClearingExemption = new ArrayList<>();
		protected List<String> collateralTypeAllowed = new ArrayList<>();
		protected Boolean collateralPortfolioContainsNonReportableComponents;
		protected Boolean packageContainsNonReportableComponents;
		protected String specialEntityType;
		protected ActionType.ActionTypeBuilder actionType;
		protected String eventType;
		protected Boolean tradeExecutionRequirementIndicator;
		protected ZonedDateTime lastFloatingReferenceResetDate;
		protected ZonedDateTime nextFloatingReferenceResetDate;
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<String> getSupervisoryBody() {
			return supervisoryBody;
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
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
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
		
		@Override
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeSizeTrade")
		public Boolean getLargeSizeTrade() {
			return largeSizeTrade;
		}
		
		@Override
		@RosettaAttribute("executionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionType")
		public ExecutionType.ExecutionTypeBuilder getExecutionType() {
			return executionType;
		}
		
		@Override
		public ExecutionType.ExecutionTypeBuilder getOrCreateExecutionType() {
			ExecutionType.ExecutionTypeBuilder result;
			if (executionType!=null) {
				result = executionType;
			}
			else {
				result = executionType = ExecutionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType() {
			ExecutionVenueType.ExecutionVenueTypeBuilder result;
			if (executionVenueType!=null) {
				result = executionVenueType;
			}
			else {
				result = executionVenueType = ExecutionVenueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("verificationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationMethod")
		public VerificationMethod.VerificationMethodBuilder getVerificationMethod() {
			return verificationMethod;
		}
		
		@Override
		public VerificationMethod.VerificationMethodBuilder getOrCreateVerificationMethod() {
			VerificationMethod.VerificationMethodBuilder result;
			if (verificationMethod!=null) {
				result = verificationMethod;
			}
			else {
				result = verificationMethod = VerificationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationMethod")
		public ConfirmationMethod.ConfirmationMethodBuilder getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		public ConfirmationMethod.ConfirmationMethodBuilder getOrCreateConfirmationMethod() {
			ConfirmationMethod.ConfirmationMethodBuilder result;
			if (confirmationMethod!=null) {
				result = confirmationMethod;
			}
			else {
				result = confirmationMethod = ConfirmationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizationType")
		public CollateralizationType.CollateralizationTypeBuilder getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		public CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType() {
			CollateralizationType.CollateralizationTypeBuilder result;
			if (collateralizationType!=null) {
				result = collateralizationType;
			}
			else {
				result = collateralizationType = CollateralizationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingPartyOrganizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingPartyOrganizationType")
		public String getReportingPartyOrganizationType() {
			return reportingPartyOrganizationType;
		}
		
		@Override
		@RosettaAttribute("counterPartyOrganizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyOrganizationType")
		public String getCounterPartyOrganizationType() {
			return counterPartyOrganizationType;
		}
		
		@Override
		@RosettaAttribute("counterPartyIsUsPerson")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyIsUsPerson")
		public Boolean getCounterPartyIsUsPerson() {
			return counterPartyIsUsPerson;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationStatus")
		public AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus() {
			AllocationReportingStatus.AllocationReportingStatusBuilder result;
			if (allocationStatus!=null) {
				result = allocationStatus;
			}
			else {
				result = allocationStatus = AllocationReportingStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clientAccountType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clientAccountType")
		public TradeCategory.TradeCategoryBuilder getClientAccountType() {
			return clientAccountType;
		}
		
		@Override
		public TradeCategory.TradeCategoryBuilder getOrCreateClientAccountType() {
			TradeCategory.TradeCategoryBuilder result;
			if (clientAccountType!=null) {
				result = clientAccountType;
			}
			else {
				result = clientAccountType = TradeCategory.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interAffiliateClearingExemptionParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interAffiliateClearingExemptionParty")
		public PartyReference.PartyReferenceBuilder getInterAffiliateClearingExemptionParty() {
			return interAffiliateClearingExemptionParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateInterAffiliateClearingExemptionParty() {
			PartyReference.PartyReferenceBuilder result;
			if (interAffiliateClearingExemptionParty!=null) {
				result = interAffiliateClearingExemptionParty;
			}
			else {
				result = interAffiliateClearingExemptionParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingPartyClearingExemption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPartyClearingExemption")
		public List<String> getReportingPartyClearingExemption() {
			return reportingPartyClearingExemption;
		}
		
		@Override
		@RosettaAttribute("counterPartyClearingExemption")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("counterPartyClearingExemption")
		public List<String> getCounterPartyClearingExemption() {
			return counterPartyClearingExemption;
		}
		
		@Override
		@RosettaAttribute("collateralTypeAllowed")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralTypeAllowed")
		public List<String> getCollateralTypeAllowed() {
			return collateralTypeAllowed;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioContainsNonReportableComponents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioContainsNonReportableComponents")
		public Boolean getCollateralPortfolioContainsNonReportableComponents() {
			return collateralPortfolioContainsNonReportableComponents;
		}
		
		@Override
		@RosettaAttribute("packageContainsNonReportableComponents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageContainsNonReportableComponents")
		public Boolean getPackageContainsNonReportableComponents() {
			return packageContainsNonReportableComponents;
		}
		
		@Override
		@RosettaAttribute("specialEntityType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specialEntityType")
		public String getSpecialEntityType() {
			return specialEntityType;
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
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventType")
		public String getEventType() {
			return eventType;
		}
		
		@Override
		@RosettaAttribute("tradeExecutionRequirementIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeExecutionRequirementIndicator")
		public Boolean getTradeExecutionRequirementIndicator() {
			return tradeExecutionRequirementIndicator;
		}
		
		@Override
		@RosettaAttribute("lastFloatingReferenceResetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastFloatingReferenceResetDate")
		public ZonedDateTime getLastFloatingReferenceResetDate() {
			return lastFloatingReferenceResetDate;
		}
		
		@Override
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		public ZonedDateTime getNextFloatingReferenceResetDate() {
			return nextFloatingReferenceResetDate;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addSupervisoryBody(List<String> supervisoryBodys) {
			if (supervisoryBodys != null) {
				for (final String toAdd : supervisoryBodys) {
					this.supervisoryBody.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setSupervisoryBody(List<String> supervisoryBodys) {
			if (supervisoryBodys == null) {
				this.supervisoryBody = new ArrayList<>();
			} else {
				this.supervisoryBody = supervisoryBodys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatorilyClearable")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setMandatorilyClearable(ReportingBoolean _mandatorilyClearable) {
			this.mandatorilyClearable = _mandatorilyClearable == null ? null : _mandatorilyClearable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endUserException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endUserException")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEndUserException(Boolean _endUserException) {
			this.endUserException = _endUserException == null ? null : _endUserException;
			return this;
		}
		
		@RosettaAttribute("endUserExceptionReason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("endUserExceptionReason")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addEndUserExceptionReason(ClearingExceptionReason _endUserExceptionReason) {
			if (_endUserExceptionReason != null) {
				this.endUserExceptionReason.add(_endUserExceptionReason.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addEndUserExceptionReason(ClearingExceptionReason _endUserExceptionReason, int idx) {
			getIndex(this.endUserExceptionReason, idx, () -> _endUserExceptionReason.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReasons) {
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
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEndUserExceptionReason(List<? extends ClearingExceptionReason> endUserExceptionReasons) {
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
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEndUserExceptionDeclaration(EndUserExceptionDeclaration _endUserExceptionDeclaration) {
			this.endUserExceptionDeclaration = _endUserExceptionDeclaration == null ? null : _endUserExceptionDeclaration.toBuilder();
			return this;
		}
		
		@RosettaAttribute("largeSizeTrade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("largeSizeTrade")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setLargeSizeTrade(Boolean _largeSizeTrade) {
			this.largeSizeTrade = _largeSizeTrade == null ? null : _largeSizeTrade;
			return this;
		}
		
		@RosettaAttribute("executionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setExecutionType(ExecutionType _executionType) {
			this.executionType = _executionType == null ? null : _executionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setExecutionVenueType(ExecutionVenueType _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("verificationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("verificationMethod")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setVerificationMethod(VerificationMethod _verificationMethod) {
			this.verificationMethod = _verificationMethod == null ? null : _verificationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationMethod")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setConfirmationMethod(ConfirmationMethod _confirmationMethod) {
			this.confirmationMethod = _confirmationMethod == null ? null : _confirmationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizationType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCollateralizationType(CollateralizationType _collateralizationType) {
			this.collateralizationType = _collateralizationType == null ? null : _collateralizationType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPartyOrganizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingPartyOrganizationType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingPartyOrganizationType(String _reportingPartyOrganizationType) {
			this.reportingPartyOrganizationType = _reportingPartyOrganizationType == null ? null : _reportingPartyOrganizationType;
			return this;
		}
		
		@RosettaAttribute("counterPartyOrganizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterPartyOrganizationType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCounterPartyOrganizationType(String _counterPartyOrganizationType) {
			this.counterPartyOrganizationType = _counterPartyOrganizationType == null ? null : _counterPartyOrganizationType;
			return this;
		}
		
		@RosettaAttribute("counterPartyIsUsPerson")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterPartyIsUsPerson")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCounterPartyIsUsPerson(Boolean _counterPartyIsUsPerson) {
			this.counterPartyIsUsPerson = _counterPartyIsUsPerson == null ? null : _counterPartyIsUsPerson;
			return this;
		}
		
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationStatus")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setAllocationStatus(AllocationReportingStatus _allocationStatus) {
			this.allocationStatus = _allocationStatus == null ? null : _allocationStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clientAccountType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clientAccountType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setClientAccountType(TradeCategory _clientAccountType) {
			this.clientAccountType = _clientAccountType == null ? null : _clientAccountType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interAffiliateClearingExemptionParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interAffiliateClearingExemptionParty")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setInterAffiliateClearingExemptionParty(PartyReference _interAffiliateClearingExemptionParty) {
			this.interAffiliateClearingExemptionParty = _interAffiliateClearingExemptionParty == null ? null : _interAffiliateClearingExemptionParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPartyClearingExemption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPartyClearingExemption")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPartyClearingExemption(String _reportingPartyClearingExemption) {
			if (_reportingPartyClearingExemption != null) {
				this.reportingPartyClearingExemption.add(_reportingPartyClearingExemption);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPartyClearingExemption(String _reportingPartyClearingExemption, int idx) {
			getIndex(this.reportingPartyClearingExemption, idx, () -> _reportingPartyClearingExemption);
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addReportingPartyClearingExemption(List<String> reportingPartyClearingExemptions) {
			if (reportingPartyClearingExemptions != null) {
				for (final String toAdd : reportingPartyClearingExemptions) {
					this.reportingPartyClearingExemption.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingPartyClearingExemption")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingPartyClearingExemption")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setReportingPartyClearingExemption(List<String> reportingPartyClearingExemptions) {
			if (reportingPartyClearingExemptions == null) {
				this.reportingPartyClearingExemption = new ArrayList<>();
			} else {
				this.reportingPartyClearingExemption = reportingPartyClearingExemptions.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("counterPartyClearingExemption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("counterPartyClearingExemption")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCounterPartyClearingExemption(String _counterPartyClearingExemption) {
			if (_counterPartyClearingExemption != null) {
				this.counterPartyClearingExemption.add(_counterPartyClearingExemption);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCounterPartyClearingExemption(String _counterPartyClearingExemption, int idx) {
			getIndex(this.counterPartyClearingExemption, idx, () -> _counterPartyClearingExemption);
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCounterPartyClearingExemption(List<String> counterPartyClearingExemptions) {
			if (counterPartyClearingExemptions != null) {
				for (final String toAdd : counterPartyClearingExemptions) {
					this.counterPartyClearingExemption.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("counterPartyClearingExemption")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("counterPartyClearingExemption")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCounterPartyClearingExemption(List<String> counterPartyClearingExemptions) {
			if (counterPartyClearingExemptions == null) {
				this.counterPartyClearingExemption = new ArrayList<>();
			} else {
				this.counterPartyClearingExemption = counterPartyClearingExemptions.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("collateralTypeAllowed")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("collateralTypeAllowed")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCollateralTypeAllowed(String _collateralTypeAllowed) {
			if (_collateralTypeAllowed != null) {
				this.collateralTypeAllowed.add(_collateralTypeAllowed);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCollateralTypeAllowed(String _collateralTypeAllowed, int idx) {
			getIndex(this.collateralTypeAllowed, idx, () -> _collateralTypeAllowed);
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder addCollateralTypeAllowed(List<String> collateralTypeAlloweds) {
			if (collateralTypeAlloweds != null) {
				for (final String toAdd : collateralTypeAlloweds) {
					this.collateralTypeAllowed.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("collateralTypeAllowed")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("collateralTypeAllowed")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCollateralTypeAllowed(List<String> collateralTypeAlloweds) {
			if (collateralTypeAlloweds == null) {
				this.collateralTypeAllowed = new ArrayList<>();
			} else {
				this.collateralTypeAllowed = collateralTypeAlloweds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioContainsNonReportableComponents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioContainsNonReportableComponents")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setCollateralPortfolioContainsNonReportableComponents(Boolean _collateralPortfolioContainsNonReportableComponents) {
			this.collateralPortfolioContainsNonReportableComponents = _collateralPortfolioContainsNonReportableComponents == null ? null : _collateralPortfolioContainsNonReportableComponents;
			return this;
		}
		
		@RosettaAttribute("packageContainsNonReportableComponents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageContainsNonReportableComponents")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setPackageContainsNonReportableComponents(Boolean _packageContainsNonReportableComponents) {
			this.packageContainsNonReportableComponents = _packageContainsNonReportableComponents == null ? null : _packageContainsNonReportableComponents;
			return this;
		}
		
		@RosettaAttribute("specialEntityType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specialEntityType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setSpecialEntityType(String _specialEntityType) {
			this.specialEntityType = _specialEntityType == null ? null : _specialEntityType;
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setActionType(ActionType _actionType) {
			this.actionType = _actionType == null ? null : _actionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventType")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setEventType(String _eventType) {
			this.eventType = _eventType == null ? null : _eventType;
			return this;
		}
		
		@RosettaAttribute("tradeExecutionRequirementIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeExecutionRequirementIndicator")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setTradeExecutionRequirementIndicator(Boolean _tradeExecutionRequirementIndicator) {
			this.tradeExecutionRequirementIndicator = _tradeExecutionRequirementIndicator == null ? null : _tradeExecutionRequirementIndicator;
			return this;
		}
		
		@RosettaAttribute("lastFloatingReferenceResetDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastFloatingReferenceResetDate")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setLastFloatingReferenceResetDate(ZonedDateTime _lastFloatingReferenceResetDate) {
			this.lastFloatingReferenceResetDate = _lastFloatingReferenceResetDate == null ? null : _lastFloatingReferenceResetDate;
			return this;
		}
		
		@RosettaAttribute("nextFloatingReferenceResetDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nextFloatingReferenceResetDate")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder setNextFloatingReferenceResetDate(ZonedDateTime _nextFloatingReferenceResetDate) {
			this.nextFloatingReferenceResetDate = _nextFloatingReferenceResetDate == null ? null : _nextFloatingReferenceResetDate;
			return this;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019 build() {
			return new RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Impl(this);
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (mandatorilyClearable!=null && !mandatorilyClearable.prune().hasData()) mandatorilyClearable = null;
			endUserExceptionReason = endUserExceptionReason.stream().filter(b->b!=null).<ClearingExceptionReason.ClearingExceptionReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (endUserExceptionDeclaration!=null && !endUserExceptionDeclaration.prune().hasData()) endUserExceptionDeclaration = null;
			if (executionType!=null && !executionType.prune().hasData()) executionType = null;
			if (executionVenueType!=null && !executionVenueType.prune().hasData()) executionVenueType = null;
			if (verificationMethod!=null && !verificationMethod.prune().hasData()) verificationMethod = null;
			if (confirmationMethod!=null && !confirmationMethod.prune().hasData()) confirmationMethod = null;
			if (collateralizationType!=null && !collateralizationType.prune().hasData()) collateralizationType = null;
			if (allocationStatus!=null && !allocationStatus.prune().hasData()) allocationStatus = null;
			if (clientAccountType!=null && !clientAccountType.prune().hasData()) clientAccountType = null;
			if (interAffiliateClearingExemptionParty!=null && !interAffiliateClearingExemptionParty.prune().hasData()) interAffiliateClearingExemptionParty = null;
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSupervisoryBody()!=null && !getSupervisoryBody().isEmpty()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getMandatorilyClearable()!=null && getMandatorilyClearable().hasData()) return true;
			if (getEndUserException()!=null) return true;
			if (getEndUserExceptionReason()!=null && getEndUserExceptionReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEndUserExceptionDeclaration()!=null && getEndUserExceptionDeclaration().hasData()) return true;
			if (getLargeSizeTrade()!=null) return true;
			if (getExecutionType()!=null && getExecutionType().hasData()) return true;
			if (getExecutionVenueType()!=null && getExecutionVenueType().hasData()) return true;
			if (getVerificationMethod()!=null && getVerificationMethod().hasData()) return true;
			if (getConfirmationMethod()!=null && getConfirmationMethod().hasData()) return true;
			if (getCollateralizationType()!=null && getCollateralizationType().hasData()) return true;
			if (getReportingPartyOrganizationType()!=null) return true;
			if (getCounterPartyOrganizationType()!=null) return true;
			if (getCounterPartyIsUsPerson()!=null) return true;
			if (getAllocationStatus()!=null && getAllocationStatus().hasData()) return true;
			if (getClientAccountType()!=null && getClientAccountType().hasData()) return true;
			if (getInterAffiliateClearingExemptionParty()!=null && getInterAffiliateClearingExemptionParty().hasData()) return true;
			if (getReportingPartyClearingExemption()!=null && !getReportingPartyClearingExemption().isEmpty()) return true;
			if (getCounterPartyClearingExemption()!=null && !getCounterPartyClearingExemption().isEmpty()) return true;
			if (getCollateralTypeAllowed()!=null && !getCollateralTypeAllowed().isEmpty()) return true;
			if (getCollateralPortfolioContainsNonReportableComponents()!=null) return true;
			if (getPackageContainsNonReportableComponents()!=null) return true;
			if (getSpecialEntityType()!=null) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			if (getEventType()!=null) return true;
			if (getTradeExecutionRequirementIndicator()!=null) return true;
			if (getLastFloatingReferenceResetDate()!=null) return true;
			if (getNextFloatingReferenceResetDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder o = (RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getMandatorilyClearable(), o.getMandatorilyClearable(), this::setMandatorilyClearable);
			merger.mergeRosetta(getEndUserExceptionReason(), o.getEndUserExceptionReason(), this::getOrCreateEndUserExceptionReason);
			merger.mergeRosetta(getEndUserExceptionDeclaration(), o.getEndUserExceptionDeclaration(), this::setEndUserExceptionDeclaration);
			merger.mergeRosetta(getExecutionType(), o.getExecutionType(), this::setExecutionType);
			merger.mergeRosetta(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			merger.mergeRosetta(getVerificationMethod(), o.getVerificationMethod(), this::setVerificationMethod);
			merger.mergeRosetta(getConfirmationMethod(), o.getConfirmationMethod(), this::setConfirmationMethod);
			merger.mergeRosetta(getCollateralizationType(), o.getCollateralizationType(), this::setCollateralizationType);
			merger.mergeRosetta(getAllocationStatus(), o.getAllocationStatus(), this::setAllocationStatus);
			merger.mergeRosetta(getClientAccountType(), o.getClientAccountType(), this::setClientAccountType);
			merger.mergeRosetta(getInterAffiliateClearingExemptionParty(), o.getInterAffiliateClearingExemptionParty(), this::setInterAffiliateClearingExemptionParty);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getEndUserException(), o.getEndUserException(), this::setEndUserException);
			merger.mergeBasic(getLargeSizeTrade(), o.getLargeSizeTrade(), this::setLargeSizeTrade);
			merger.mergeBasic(getReportingPartyOrganizationType(), o.getReportingPartyOrganizationType(), this::setReportingPartyOrganizationType);
			merger.mergeBasic(getCounterPartyOrganizationType(), o.getCounterPartyOrganizationType(), this::setCounterPartyOrganizationType);
			merger.mergeBasic(getCounterPartyIsUsPerson(), o.getCounterPartyIsUsPerson(), this::setCounterPartyIsUsPerson);
			merger.mergeBasic(getReportingPartyClearingExemption(), o.getReportingPartyClearingExemption(), (Consumer<String>) this::addReportingPartyClearingExemption);
			merger.mergeBasic(getCounterPartyClearingExemption(), o.getCounterPartyClearingExemption(), (Consumer<String>) this::addCounterPartyClearingExemption);
			merger.mergeBasic(getCollateralTypeAllowed(), o.getCollateralTypeAllowed(), (Consumer<String>) this::addCollateralTypeAllowed);
			merger.mergeBasic(getCollateralPortfolioContainsNonReportableComponents(), o.getCollateralPortfolioContainsNonReportableComponents(), this::setCollateralPortfolioContainsNonReportableComponents);
			merger.mergeBasic(getPackageContainsNonReportableComponents(), o.getPackageContainsNonReportableComponents(), this::setPackageContainsNonReportableComponents);
			merger.mergeBasic(getSpecialEntityType(), o.getSpecialEntityType(), this::setSpecialEntityType);
			merger.mergeBasic(getEventType(), o.getEventType(), this::setEventType);
			merger.mergeBasic(getTradeExecutionRequirementIndicator(), o.getTradeExecutionRequirementIndicator(), this::setTradeExecutionRequirementIndicator);
			merger.mergeBasic(getLastFloatingReferenceResetDate(), o.getLastFloatingReferenceResetDate(), this::setLastFloatingReferenceResetDate);
			merger.mergeBasic(getNextFloatingReferenceResetDate(), o.getNextFloatingReferenceResetDate(), this::setNextFloatingReferenceResetDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationPart45_2019 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(endUserException, _that.getEndUserException())) return false;
			if (!ListEquals.listEquals(endUserExceptionReason, _that.getEndUserExceptionReason())) return false;
			if (!Objects.equals(endUserExceptionDeclaration, _that.getEndUserExceptionDeclaration())) return false;
			if (!Objects.equals(largeSizeTrade, _that.getLargeSizeTrade())) return false;
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(verificationMethod, _that.getVerificationMethod())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(reportingPartyOrganizationType, _that.getReportingPartyOrganizationType())) return false;
			if (!Objects.equals(counterPartyOrganizationType, _that.getCounterPartyOrganizationType())) return false;
			if (!Objects.equals(counterPartyIsUsPerson, _that.getCounterPartyIsUsPerson())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(clientAccountType, _that.getClientAccountType())) return false;
			if (!Objects.equals(interAffiliateClearingExemptionParty, _that.getInterAffiliateClearingExemptionParty())) return false;
			if (!ListEquals.listEquals(reportingPartyClearingExemption, _that.getReportingPartyClearingExemption())) return false;
			if (!ListEquals.listEquals(counterPartyClearingExemption, _that.getCounterPartyClearingExemption())) return false;
			if (!ListEquals.listEquals(collateralTypeAllowed, _that.getCollateralTypeAllowed())) return false;
			if (!Objects.equals(collateralPortfolioContainsNonReportableComponents, _that.getCollateralPortfolioContainsNonReportableComponents())) return false;
			if (!Objects.equals(packageContainsNonReportableComponents, _that.getPackageContainsNonReportableComponents())) return false;
			if (!Objects.equals(specialEntityType, _that.getSpecialEntityType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(tradeExecutionRequirementIndicator, _that.getTradeExecutionRequirementIndicator())) return false;
			if (!Objects.equals(lastFloatingReferenceResetDate, _that.getLastFloatingReferenceResetDate())) return false;
			if (!Objects.equals(nextFloatingReferenceResetDate, _that.getNextFloatingReferenceResetDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (endUserException != null ? endUserException.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionReason != null ? endUserExceptionReason.hashCode() : 0);
			_result = 31 * _result + (endUserExceptionDeclaration != null ? endUserExceptionDeclaration.hashCode() : 0);
			_result = 31 * _result + (largeSizeTrade != null ? largeSizeTrade.hashCode() : 0);
			_result = 31 * _result + (executionType != null ? executionType.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			_result = 31 * _result + (verificationMethod != null ? verificationMethod.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (reportingPartyOrganizationType != null ? reportingPartyOrganizationType.hashCode() : 0);
			_result = 31 * _result + (counterPartyOrganizationType != null ? counterPartyOrganizationType.hashCode() : 0);
			_result = 31 * _result + (counterPartyIsUsPerson != null ? counterPartyIsUsPerson.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (clientAccountType != null ? clientAccountType.hashCode() : 0);
			_result = 31 * _result + (interAffiliateClearingExemptionParty != null ? interAffiliateClearingExemptionParty.hashCode() : 0);
			_result = 31 * _result + (reportingPartyClearingExemption != null ? reportingPartyClearingExemption.hashCode() : 0);
			_result = 31 * _result + (counterPartyClearingExemption != null ? counterPartyClearingExemption.hashCode() : 0);
			_result = 31 * _result + (collateralTypeAllowed != null ? collateralTypeAllowed.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioContainsNonReportableComponents != null ? collateralPortfolioContainsNonReportableComponents.hashCode() : 0);
			_result = 31 * _result + (packageContainsNonReportableComponents != null ? packageContainsNonReportableComponents.hashCode() : 0);
			_result = 31 * _result + (specialEntityType != null ? specialEntityType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			_result = 31 * _result + (tradeExecutionRequirementIndicator != null ? tradeExecutionRequirementIndicator.hashCode() : 0);
			_result = 31 * _result + (lastFloatingReferenceResetDate != null ? lastFloatingReferenceResetDate.hashCode() : 0);
			_result = 31 * _result + (nextFloatingReferenceResetDate != null ? nextFloatingReferenceResetDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationPart45_2019Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"endUserException=" + this.endUserException + ", " +
				"endUserExceptionReason=" + this.endUserExceptionReason + ", " +
				"endUserExceptionDeclaration=" + this.endUserExceptionDeclaration + ", " +
				"largeSizeTrade=" + this.largeSizeTrade + ", " +
				"executionType=" + this.executionType + ", " +
				"executionVenueType=" + this.executionVenueType + ", " +
				"verificationMethod=" + this.verificationMethod + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"reportingPartyOrganizationType=" + this.reportingPartyOrganizationType + ", " +
				"counterPartyOrganizationType=" + this.counterPartyOrganizationType + ", " +
				"counterPartyIsUsPerson=" + this.counterPartyIsUsPerson + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"clientAccountType=" + this.clientAccountType + ", " +
				"interAffiliateClearingExemptionParty=" + this.interAffiliateClearingExemptionParty + ", " +
				"reportingPartyClearingExemption=" + this.reportingPartyClearingExemption + ", " +
				"counterPartyClearingExemption=" + this.counterPartyClearingExemption + ", " +
				"collateralTypeAllowed=" + this.collateralTypeAllowed + ", " +
				"collateralPortfolioContainsNonReportableComponents=" + this.collateralPortfolioContainsNonReportableComponents + ", " +
				"packageContainsNonReportableComponents=" + this.packageContainsNonReportableComponents + ", " +
				"specialEntityType=" + this.specialEntityType + ", " +
				"actionType=" + this.actionType + ", " +
				"eventType=" + this.eventType + ", " +
				"tradeExecutionRequirementIndicator=" + this.tradeExecutionRequirementIndicator + ", " +
				"lastFloatingReferenceResetDate=" + this.lastFloatingReferenceResetDate + ", " +
				"nextFloatingReferenceResetDate=" + this.nextFloatingReferenceResetDate +
			'}' + " " + super.toString();
		}
	}
}
