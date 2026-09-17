package fpml.consolidated.recordkeeping.processes;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
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
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.AmountRef;
import fpml.consolidated.business.events.EventId;
import fpml.consolidated.business.events.EventTaxonomy;
import fpml.consolidated.business.events.MoneyRef;
import fpml.consolidated.business.events.UnitQuantityRef;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
import fpml.consolidated.msg.AddressedMessage;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryDisclosureMeta;
import fpml.consolidated.reg.fpmlreporting.shared.ApplicableRegulations;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingCollateralization;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.time.LocalTime;
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
 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). A type that defines a message to be used for reporting non-public information to a regulator, typically via a trade repository or other reporting service. CAVEAT: This new regulatory reporting message set is supported by the FpML Standards Committee, and will be present in future versions of the standard. However, there is no absolute guarantee of backward compatibility with future versions of the standard, until such time as the Standards Committee deems that the message set has been extensively adopted in production. The Standards Committee will attempt to maintain full backward compatibility with this version while adjusting as required to take into account implementation experience with the message set. The Standards Committee advises that the areas where there is more likely to be change include the applicableRegulatiorns section, the regulatorionSpecificInformation section, and the regulatoryProductInformation [DEPRECATED] product, which is developed as part of this reporting framework. Feedback or questions can be addressed to ISDA at rptwgchair@fpml.org.
 *
 */
@RosettaDataType(value="RegulatoryDisclosure", builder=RegulatoryDisclosure.RegulatoryDisclosureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryDisclosure", model="fpml", builder=RegulatoryDisclosure.RegulatoryDisclosureBuilderImpl.class, version="2.1.1")
public interface RegulatoryDisclosure extends AddressedMessage {

	RegulatoryDisclosureMeta metaData = new RegulatoryDisclosureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicates if this message corrects an earlier submission. If true, the recipient is directed to record information about the most recent lifecycle event affecting the trade as a correction of the previous submission, rather than as a new lifecycle event.
	 *
	 */
	Boolean getIsCorrection();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicates which party (or parties) (and accounts) a trade or event is being processed for. Normally there will only be a maximum of 2 parties, but in the case of a novation there could be a transferor, transferee, remaining party, and other remaining party. Also, in the context of a trade package there could be several parties for which limit check is requested, necessitating multiple onBehalfOf elements. Except for these cases, there should be no more than two onBehalfOf references in a message.
	 *
	 */
	List<? extends OnBehalfOf> getOnBehalfOf();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). The date for which this document reports positions and valuations.
	 *
	 */
	IdentifiedDate getAsOfDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). The time for which this report was generated (i.e., the cut-off time of the report).
	 *
	 */
	LocalTime getAsOfTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). A unique event identifier.
	 *
	 */
	EventId getEventId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). A structured code indicating the event type.
	 *
	 */
	EventTaxonomy getEventType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Various timestamps related to the event.
	 *
	 */
	EventTimestamps getEventTimestamps();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the reporting party.
	 *
	 */
	PartyReference getReportingPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the reporting party.
	 *
	 */
	PartyReference getCounterPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indication as to whether the transaction is an increase or decrease of notional of a derivative contract. Only applies when there is change in notional for a derivative contract
	 *
	 */
	NotionalChangeEnum getNotionalChange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The change in notional amount for a prior report as a result of this event. The current notional will be reported in the trade itself. This corresponds to MiFIR Nominal or Monetary amount values; these can be distinguished by the esmaNotionalType indicator.
	 *
	 */
	List<? extends MoneyRef> getChangeInNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The change in nominal amount from a prior report as a result of this event. The current number of options will be reported in the trade itself. This corresponds to the MiFIR "units" value.
	 *
	 */
	List<? extends AmountRef> getChangeInNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The change in quantity(s) from a prior report as a result of this event. The current quantity will be reported in the trade itself. This corresponds to the MiFIR "units" value.
	 *
	 */
	List<? extends UnitQuantityRef> getChangeInQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Payments in settlement of the event
	 *
	 */
	List<? extends NonNegativePayment> getPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). All the regulators to which this trade should be reported. Optional, can be infeerred from the list of regulations to which the trade is submitted.
	 *
	 */
	ApplicableRegulations getApplicableRegulations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). All the regulations that this trade should be reported under.
	 *
	 */
	RegulationDetails getRegulationSpecificInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). The revised state of the trade or its final state for a lifecycle ending event
	 *
	 */
	RegReportingCDE getCpmiIoscoCDE();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). The revised state of the trade or its final state for a lifecycle ending event
	 *
	 */
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Pricing information for the trade.
	 *
	 */
	List<? extends BasicQuotation> getQuote();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<? extends RegulatoryReportingCollateralization> getCollateralization();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). The supporting party definitions.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	RegulatoryDisclosure build();
	
	RegulatoryDisclosure.RegulatoryDisclosureBuilder toBuilder();
	
	static RegulatoryDisclosure.RegulatoryDisclosureBuilder builder() {
		return new RegulatoryDisclosure.RegulatoryDisclosureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryDisclosure> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryDisclosure> getType() {
		return RegulatoryDisclosure.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.class, getAsOfDate());
		processor.processBasic(path.newSubPath("asOfTime"), LocalTime.class, getAsOfTime(), this);
		processRosetta(path.newSubPath("eventId"), processor, EventId.class, getEventId());
		processRosetta(path.newSubPath("eventType"), processor, EventTaxonomy.class, getEventType());
		processRosetta(path.newSubPath("eventTimestamps"), processor, EventTimestamps.class, getEventTimestamps());
		processRosetta(path.newSubPath("reportingPartyReference"), processor, PartyReference.class, getReportingPartyReference());
		processRosetta(path.newSubPath("counterPartyReference"), processor, PartyReference.class, getCounterPartyReference());
		processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
		processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.class, getChangeInNotional());
		processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.class, getChangeInNumberOfOptions());
		processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.class, getChangeInQuantity());
		processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.class, getPayment());
		processRosetta(path.newSubPath("applicableRegulations"), processor, ApplicableRegulations.class, getApplicableRegulations());
		processRosetta(path.newSubPath("regulationSpecificInformation"), processor, RegulationDetails.class, getRegulationSpecificInformation());
		processRosetta(path.newSubPath("cpmiIoscoCDE"), processor, RegReportingCDE.class, getCpmiIoscoCDE());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
		processRosetta(path.newSubPath("collateralization"), processor, RegulatoryReportingCollateralization.class, getCollateralization());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryDisclosureBuilder extends RegulatoryDisclosure, AddressedMessage.AddressedMessageBuilder {
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf(int index);
		@Override
		List<? extends OnBehalfOf.OnBehalfOfBuilder> getOnBehalfOf();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAsOfDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getAsOfDate();
		EventId.EventIdBuilder getOrCreateEventId();
		@Override
		EventId.EventIdBuilder getEventId();
		EventTaxonomy.EventTaxonomyBuilder getOrCreateEventType();
		@Override
		EventTaxonomy.EventTaxonomyBuilder getEventType();
		EventTimestamps.EventTimestampsBuilder getOrCreateEventTimestamps();
		@Override
		EventTimestamps.EventTimestampsBuilder getEventTimestamps();
		PartyReference.PartyReferenceBuilder getOrCreateReportingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getReportingPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateCounterPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getCounterPartyReference();
		MoneyRef.MoneyRefBuilder getOrCreateChangeInNotional(int index);
		@Override
		List<? extends MoneyRef.MoneyRefBuilder> getChangeInNotional();
		AmountRef.AmountRefBuilder getOrCreateChangeInNumberOfOptions(int index);
		@Override
		List<? extends AmountRef.AmountRefBuilder> getChangeInNumberOfOptions();
		UnitQuantityRef.UnitQuantityRefBuilder getOrCreateChangeInQuantity(int index);
		@Override
		List<? extends UnitQuantityRef.UnitQuantityRefBuilder> getChangeInQuantity();
		NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment(int index);
		@Override
		List<? extends NonNegativePayment.NonNegativePaymentBuilder> getPayment();
		ApplicableRegulations.ApplicableRegulationsBuilder getOrCreateApplicableRegulations();
		@Override
		ApplicableRegulations.ApplicableRegulationsBuilder getApplicableRegulations();
		RegulationDetails.RegulationDetailsBuilder getOrCreateRegulationSpecificInformation();
		@Override
		RegulationDetails.RegulationDetailsBuilder getRegulationSpecificInformation();
		RegReportingCDE.RegReportingCDEBuilder getOrCreateCpmiIoscoCDE();
		@Override
		RegReportingCDE.RegReportingCDEBuilder getCpmiIoscoCDE();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder getOrCreateCollateralization(int index);
		@Override
		List<? extends RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder> getCollateralization();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setActualBuild(Integer actualBuild);
		@Override
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setHeader(NotificationMessageHeader header);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setIsCorrection(Boolean isCorrection);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setAsOfDate(IdentifiedDate asOfDate);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setAsOfTime(LocalTime asOfTime);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setEventId(EventId eventId);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setEventType(EventTaxonomy eventType);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setEventTimestamps(EventTimestamps eventTimestamps);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setReportingPartyReference(PartyReference reportingPartyReference);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setCounterPartyReference(PartyReference counterPartyReference);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setNotionalChange(NotionalChangeEnum notionalChange);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNotional(MoneyRef changeInNotional);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNotional(MoneyRef changeInNotional, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotional);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotional);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNumberOfOptions(AmountRef changeInNumberOfOptions, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptions);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInQuantity(UnitQuantityRef changeInQuantity, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantity);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addPayment(NonNegativePayment payment);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addPayment(NonNegativePayment payment, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addPayment(List<? extends NonNegativePayment> payment);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setPayment(List<? extends NonNegativePayment> payment);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setApplicableRegulations(ApplicableRegulations applicableRegulations);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setRegulationSpecificInformation(RegulationDetails regulationSpecificInformation);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setCpmiIoscoCDE(RegReportingCDE cpmiIoscoCDE);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setTrade(Trade trade);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addQuote(BasicQuotation quote);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addQuote(BasicQuotation quote, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addQuote(List<? extends BasicQuotation> quote);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setQuote(List<? extends BasicQuotation> quote);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addCollateralization(RegulatoryReportingCollateralization collateralization);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addCollateralization(RegulatoryReportingCollateralization collateralization, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addCollateralization(List<? extends RegulatoryReportingCollateralization> collateralization);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setCollateralization(List<? extends RegulatoryReportingCollateralization> collateralization);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addParty(Party party);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addParty(Party party, int idx);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder addParty(List<? extends Party> party);
		RegulatoryDisclosure.RegulatoryDisclosureBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAsOfDate());
			processor.processBasic(path.newSubPath("asOfTime"), LocalTime.class, getAsOfTime(), this);
			processRosetta(path.newSubPath("eventId"), processor, EventId.EventIdBuilder.class, getEventId());
			processRosetta(path.newSubPath("eventType"), processor, EventTaxonomy.EventTaxonomyBuilder.class, getEventType());
			processRosetta(path.newSubPath("eventTimestamps"), processor, EventTimestamps.EventTimestampsBuilder.class, getEventTimestamps());
			processRosetta(path.newSubPath("reportingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReportingPartyReference());
			processRosetta(path.newSubPath("counterPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCounterPartyReference());
			processor.processBasic(path.newSubPath("notionalChange"), NotionalChangeEnum.class, getNotionalChange(), this);
			processRosetta(path.newSubPath("changeInNotional"), processor, MoneyRef.MoneyRefBuilder.class, getChangeInNotional());
			processRosetta(path.newSubPath("changeInNumberOfOptions"), processor, AmountRef.AmountRefBuilder.class, getChangeInNumberOfOptions());
			processRosetta(path.newSubPath("changeInQuantity"), processor, UnitQuantityRef.UnitQuantityRefBuilder.class, getChangeInQuantity());
			processRosetta(path.newSubPath("payment"), processor, NonNegativePayment.NonNegativePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("applicableRegulations"), processor, ApplicableRegulations.ApplicableRegulationsBuilder.class, getApplicableRegulations());
			processRosetta(path.newSubPath("regulationSpecificInformation"), processor, RegulationDetails.RegulationDetailsBuilder.class, getRegulationSpecificInformation());
			processRosetta(path.newSubPath("cpmiIoscoCDE"), processor, RegReportingCDE.RegReportingCDEBuilder.class, getCpmiIoscoCDE());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
			processRosetta(path.newSubPath("collateralization"), processor, RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder.class, getCollateralization());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		RegulatoryDisclosure.RegulatoryDisclosureBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryDisclosure  ***********************/
	class RegulatoryDisclosureImpl extends AddressedMessage.AddressedMessageImpl implements RegulatoryDisclosure {
		private final Boolean isCorrection;
		private final List<? extends OnBehalfOf> onBehalfOf;
		private final IdentifiedDate asOfDate;
		private final LocalTime asOfTime;
		private final EventId eventId;
		private final EventTaxonomy eventType;
		private final EventTimestamps eventTimestamps;
		private final PartyReference reportingPartyReference;
		private final PartyReference counterPartyReference;
		private final NotionalChangeEnum notionalChange;
		private final List<? extends MoneyRef> changeInNotional;
		private final List<? extends AmountRef> changeInNumberOfOptions;
		private final List<? extends UnitQuantityRef> changeInQuantity;
		private final List<? extends NonNegativePayment> payment;
		private final ApplicableRegulations applicableRegulations;
		private final RegulationDetails regulationSpecificInformation;
		private final RegReportingCDE cpmiIoscoCDE;
		private final Trade trade;
		private final List<? extends BasicQuotation> quote;
		private final List<? extends RegulatoryReportingCollateralization> collateralization;
		private final List<? extends Party> party;
		
		protected RegulatoryDisclosureImpl(RegulatoryDisclosure.RegulatoryDisclosureBuilder builder) {
			super(builder);
			this.isCorrection = builder.getIsCorrection();
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.asOfDate = ofNullable(builder.getAsOfDate()).map(f->f.build()).orElse(null);
			this.asOfTime = builder.getAsOfTime();
			this.eventId = ofNullable(builder.getEventId()).map(f->f.build()).orElse(null);
			this.eventType = ofNullable(builder.getEventType()).map(f->f.build()).orElse(null);
			this.eventTimestamps = ofNullable(builder.getEventTimestamps()).map(f->f.build()).orElse(null);
			this.reportingPartyReference = ofNullable(builder.getReportingPartyReference()).map(f->f.build()).orElse(null);
			this.counterPartyReference = ofNullable(builder.getCounterPartyReference()).map(f->f.build()).orElse(null);
			this.notionalChange = builder.getNotionalChange();
			this.changeInNotional = ofNullable(builder.getChangeInNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInNumberOfOptions = ofNullable(builder.getChangeInNumberOfOptions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.changeInQuantity = ofNullable(builder.getChangeInQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.payment = ofNullable(builder.getPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.applicableRegulations = ofNullable(builder.getApplicableRegulations()).map(f->f.build()).orElse(null);
			this.regulationSpecificInformation = ofNullable(builder.getRegulationSpecificInformation()).map(f->f.build()).orElse(null);
			this.cpmiIoscoCDE = ofNullable(builder.getCpmiIoscoCDE()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.collateralization = ofNullable(builder.getCollateralization()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCorrection")
		public Boolean getIsCorrection() {
			return isCorrection;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		public List<? extends OnBehalfOf> getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfDate")
		public IdentifiedDate getAsOfDate() {
			return asOfDate;
		}
		
		@Override
		@RosettaAttribute("asOfTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfTime")
		public LocalTime getAsOfTime() {
			return asOfTime;
		}
		
		@Override
		@RosettaAttribute("eventId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventId")
		public EventId getEventId() {
			return eventId;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventType")
		public EventTaxonomy getEventType() {
			return eventType;
		}
		
		@Override
		@RosettaAttribute("eventTimestamps")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamps")
		public EventTimestamps getEventTimestamps() {
			return eventTimestamps;
		}
		
		@Override
		@RosettaAttribute("reportingPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingPartyReference")
		public PartyReference getReportingPartyReference() {
			return reportingPartyReference;
		}
		
		@Override
		@RosettaAttribute("counterPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterPartyReference")
		public PartyReference getCounterPartyReference() {
			return counterPartyReference;
		}
		
		@Override
		@RosettaAttribute("notionalChange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalChange")
		public NotionalChangeEnum getNotionalChange() {
			return notionalChange;
		}
		
		@Override
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNotional")
		public List<? extends MoneyRef> getChangeInNotional() {
			return changeInNotional;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		public List<? extends AmountRef> getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInQuantity")
		public List<? extends UnitQuantityRef> getChangeInQuantity() {
			return changeInQuantity;
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends NonNegativePayment> getPayment() {
			return payment;
		}
		
		@Override
		@RosettaAttribute("applicableRegulations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableRegulations")
		public ApplicableRegulations getApplicableRegulations() {
			return applicableRegulations;
		}
		
		@Override
		@RosettaAttribute("regulationSpecificInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regulationSpecificInformation")
		public RegulationDetails getRegulationSpecificInformation() {
			return regulationSpecificInformation;
		}
		
		@Override
		@RosettaAttribute("cpmiIoscoCDE")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cpmiIoscoCDE")
		public RegReportingCDE getCpmiIoscoCDE() {
			return cpmiIoscoCDE;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralization")
		public List<? extends RegulatoryReportingCollateralization> getCollateralization() {
			return collateralization;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public RegulatoryDisclosure build() {
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder toBuilder() {
			RegulatoryDisclosure.RegulatoryDisclosureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryDisclosure.RegulatoryDisclosureBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIsCorrection()).ifPresent(builder::setIsCorrection);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
			ofNullable(getAsOfDate()).ifPresent(builder::setAsOfDate);
			ofNullable(getAsOfTime()).ifPresent(builder::setAsOfTime);
			ofNullable(getEventId()).ifPresent(builder::setEventId);
			ofNullable(getEventType()).ifPresent(builder::setEventType);
			ofNullable(getEventTimestamps()).ifPresent(builder::setEventTimestamps);
			ofNullable(getReportingPartyReference()).ifPresent(builder::setReportingPartyReference);
			ofNullable(getCounterPartyReference()).ifPresent(builder::setCounterPartyReference);
			ofNullable(getNotionalChange()).ifPresent(builder::setNotionalChange);
			ofNullable(getChangeInNotional()).ifPresent(builder::setChangeInNotional);
			ofNullable(getChangeInNumberOfOptions()).ifPresent(builder::setChangeInNumberOfOptions);
			ofNullable(getChangeInQuantity()).ifPresent(builder::setChangeInQuantity);
			ofNullable(getPayment()).ifPresent(builder::setPayment);
			ofNullable(getApplicableRegulations()).ifPresent(builder::setApplicableRegulations);
			ofNullable(getRegulationSpecificInformation()).ifPresent(builder::setRegulationSpecificInformation);
			ofNullable(getCpmiIoscoCDE()).ifPresent(builder::setCpmiIoscoCDE);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getCollateralization()).ifPresent(builder::setCollateralization);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryDisclosure _that = getType().cast(o);
		
			if (!Objects.equals(isCorrection, _that.getIsCorrection())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!Objects.equals(asOfTime, _that.getAsOfTime())) return false;
			if (!Objects.equals(eventId, _that.getEventId())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(eventTimestamps, _that.getEventTimestamps())) return false;
			if (!Objects.equals(reportingPartyReference, _that.getReportingPartyReference())) return false;
			if (!Objects.equals(counterPartyReference, _that.getCounterPartyReference())) return false;
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			if (!Objects.equals(applicableRegulations, _that.getApplicableRegulations())) return false;
			if (!Objects.equals(regulationSpecificInformation, _that.getRegulationSpecificInformation())) return false;
			if (!Objects.equals(cpmiIoscoCDE, _that.getCpmiIoscoCDE())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(collateralization, _that.getCollateralization())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCorrection != null ? isCorrection.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (asOfTime != null ? asOfTime.hashCode() : 0);
			_result = 31 * _result + (eventId != null ? eventId.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			_result = 31 * _result + (eventTimestamps != null ? eventTimestamps.hashCode() : 0);
			_result = 31 * _result + (reportingPartyReference != null ? reportingPartyReference.hashCode() : 0);
			_result = 31 * _result + (counterPartyReference != null ? counterPartyReference.hashCode() : 0);
			_result = 31 * _result + (notionalChange != null ? notionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (changeInNotional != null ? changeInNotional.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInQuantity != null ? changeInQuantity.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (applicableRegulations != null ? applicableRegulations.hashCode() : 0);
			_result = 31 * _result + (regulationSpecificInformation != null ? regulationSpecificInformation.hashCode() : 0);
			_result = 31 * _result + (cpmiIoscoCDE != null ? cpmiIoscoCDE.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (collateralization != null ? collateralization.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryDisclosure {" +
				"isCorrection=" + this.isCorrection + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"asOfTime=" + this.asOfTime + ", " +
				"eventId=" + this.eventId + ", " +
				"eventType=" + this.eventType + ", " +
				"eventTimestamps=" + this.eventTimestamps + ", " +
				"reportingPartyReference=" + this.reportingPartyReference + ", " +
				"counterPartyReference=" + this.counterPartyReference + ", " +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity + ", " +
				"payment=" + this.payment + ", " +
				"applicableRegulations=" + this.applicableRegulations + ", " +
				"regulationSpecificInformation=" + this.regulationSpecificInformation + ", " +
				"cpmiIoscoCDE=" + this.cpmiIoscoCDE + ", " +
				"trade=" + this.trade + ", " +
				"quote=" + this.quote + ", " +
				"collateralization=" + this.collateralization + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryDisclosure  ***********************/
	class RegulatoryDisclosureBuilderImpl extends AddressedMessage.AddressedMessageBuilderImpl implements RegulatoryDisclosure.RegulatoryDisclosureBuilder {
	
		protected Boolean isCorrection;
		protected List<OnBehalfOf.OnBehalfOfBuilder> onBehalfOf = new ArrayList<>();
		protected IdentifiedDate.IdentifiedDateBuilder asOfDate;
		protected LocalTime asOfTime;
		protected EventId.EventIdBuilder eventId;
		protected EventTaxonomy.EventTaxonomyBuilder eventType;
		protected EventTimestamps.EventTimestampsBuilder eventTimestamps;
		protected PartyReference.PartyReferenceBuilder reportingPartyReference;
		protected PartyReference.PartyReferenceBuilder counterPartyReference;
		protected NotionalChangeEnum notionalChange;
		protected List<MoneyRef.MoneyRefBuilder> changeInNotional = new ArrayList<>();
		protected List<AmountRef.AmountRefBuilder> changeInNumberOfOptions = new ArrayList<>();
		protected List<UnitQuantityRef.UnitQuantityRefBuilder> changeInQuantity = new ArrayList<>();
		protected List<NonNegativePayment.NonNegativePaymentBuilder> payment = new ArrayList<>();
		protected ApplicableRegulations.ApplicableRegulationsBuilder applicableRegulations;
		protected RegulationDetails.RegulationDetailsBuilder regulationSpecificInformation;
		protected RegReportingCDE.RegReportingCDEBuilder cpmiIoscoCDE;
		protected Trade.TradeBuilder trade;
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		protected List<RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder> collateralization = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCorrection")
		public Boolean getIsCorrection() {
			return isCorrection;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		public List<? extends OnBehalfOf.OnBehalfOfBuilder> getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf(int index) {
			if (onBehalfOf==null) {
				this.onBehalfOf = new ArrayList<>();
			}
			return getIndex(onBehalfOf, index, () -> {
						OnBehalfOf.OnBehalfOfBuilder newOnBehalfOf = OnBehalfOf.builder();
						return newOnBehalfOf;
					});
		}
		
		@Override
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfDate")
		public IdentifiedDate.IdentifiedDateBuilder getAsOfDate() {
			return asOfDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAsOfDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (asOfDate!=null) {
				result = asOfDate;
			}
			else {
				result = asOfDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("asOfTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfTime")
		public LocalTime getAsOfTime() {
			return asOfTime;
		}
		
		@Override
		@RosettaAttribute("eventId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventId")
		public EventId.EventIdBuilder getEventId() {
			return eventId;
		}
		
		@Override
		public EventId.EventIdBuilder getOrCreateEventId() {
			EventId.EventIdBuilder result;
			if (eventId!=null) {
				result = eventId;
			}
			else {
				result = eventId = EventId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventType")
		public EventTaxonomy.EventTaxonomyBuilder getEventType() {
			return eventType;
		}
		
		@Override
		public EventTaxonomy.EventTaxonomyBuilder getOrCreateEventType() {
			EventTaxonomy.EventTaxonomyBuilder result;
			if (eventType!=null) {
				result = eventType;
			}
			else {
				result = eventType = EventTaxonomy.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventTimestamps")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eventTimestamps")
		public EventTimestamps.EventTimestampsBuilder getEventTimestamps() {
			return eventTimestamps;
		}
		
		@Override
		public EventTimestamps.EventTimestampsBuilder getOrCreateEventTimestamps() {
			EventTimestamps.EventTimestampsBuilder result;
			if (eventTimestamps!=null) {
				result = eventTimestamps;
			}
			else {
				result = eventTimestamps = EventTimestamps.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingPartyReference")
		public PartyReference.PartyReferenceBuilder getReportingPartyReference() {
			return reportingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateReportingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (reportingPartyReference!=null) {
				result = reportingPartyReference;
			}
			else {
				result = reportingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterPartyReference")
		public PartyReference.PartyReferenceBuilder getCounterPartyReference() {
			return counterPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCounterPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (counterPartyReference!=null) {
				result = counterPartyReference;
			}
			else {
				result = counterPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalChange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalChange")
		public NotionalChangeEnum getNotionalChange() {
			return notionalChange;
		}
		
		@Override
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNotional")
		public List<? extends MoneyRef.MoneyRefBuilder> getChangeInNotional() {
			return changeInNotional;
		}
		
		@Override
		public MoneyRef.MoneyRefBuilder getOrCreateChangeInNotional(int index) {
			if (changeInNotional==null) {
				this.changeInNotional = new ArrayList<>();
			}
			return getIndex(changeInNotional, index, () -> {
						MoneyRef.MoneyRefBuilder newChangeInNotional = MoneyRef.builder();
						return newChangeInNotional;
					});
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		public List<? extends AmountRef.AmountRefBuilder> getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		public AmountRef.AmountRefBuilder getOrCreateChangeInNumberOfOptions(int index) {
			if (changeInNumberOfOptions==null) {
				this.changeInNumberOfOptions = new ArrayList<>();
			}
			return getIndex(changeInNumberOfOptions, index, () -> {
						AmountRef.AmountRefBuilder newChangeInNumberOfOptions = AmountRef.builder();
						return newChangeInNumberOfOptions;
					});
		}
		
		@Override
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("changeInQuantity")
		public List<? extends UnitQuantityRef.UnitQuantityRefBuilder> getChangeInQuantity() {
			return changeInQuantity;
		}
		
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder getOrCreateChangeInQuantity(int index) {
			if (changeInQuantity==null) {
				this.changeInQuantity = new ArrayList<>();
			}
			return getIndex(changeInQuantity, index, () -> {
						UnitQuantityRef.UnitQuantityRefBuilder newChangeInQuantity = UnitQuantityRef.builder();
						return newChangeInQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payment")
		public List<? extends NonNegativePayment.NonNegativePaymentBuilder> getPayment() {
			return payment;
		}
		
		@Override
		public NonNegativePayment.NonNegativePaymentBuilder getOrCreatePayment(int index) {
			if (payment==null) {
				this.payment = new ArrayList<>();
			}
			return getIndex(payment, index, () -> {
						NonNegativePayment.NonNegativePaymentBuilder newPayment = NonNegativePayment.builder();
						return newPayment;
					});
		}
		
		@Override
		@RosettaAttribute("applicableRegulations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableRegulations")
		public ApplicableRegulations.ApplicableRegulationsBuilder getApplicableRegulations() {
			return applicableRegulations;
		}
		
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder getOrCreateApplicableRegulations() {
			ApplicableRegulations.ApplicableRegulationsBuilder result;
			if (applicableRegulations!=null) {
				result = applicableRegulations;
			}
			else {
				result = applicableRegulations = ApplicableRegulations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("regulationSpecificInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regulationSpecificInformation")
		public RegulationDetails.RegulationDetailsBuilder getRegulationSpecificInformation() {
			return regulationSpecificInformation;
		}
		
		@Override
		public RegulationDetails.RegulationDetailsBuilder getOrCreateRegulationSpecificInformation() {
			RegulationDetails.RegulationDetailsBuilder result;
			if (regulationSpecificInformation!=null) {
				result = regulationSpecificInformation;
			}
			else {
				result = regulationSpecificInformation = RegulationDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cpmiIoscoCDE")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cpmiIoscoCDE")
		public RegReportingCDE.RegReportingCDEBuilder getCpmiIoscoCDE() {
			return cpmiIoscoCDE;
		}
		
		@Override
		public RegReportingCDE.RegReportingCDEBuilder getOrCreateCpmiIoscoCDE() {
			RegReportingCDE.RegReportingCDEBuilder result;
			if (cpmiIoscoCDE!=null) {
				result = cpmiIoscoCDE;
			}
			else {
				result = cpmiIoscoCDE = RegReportingCDE.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index) {
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			return getIndex(quote, index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralization")
		public List<? extends RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder> getCollateralization() {
			return collateralization;
		}
		
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder getOrCreateCollateralization(int index) {
			if (collateralization==null) {
				this.collateralization = new ArrayList<>();
			}
			return getIndex(collateralization, index, () -> {
						RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder newCollateralization = RegulatoryReportingCollateralization.builder();
						return newCollateralization;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asOfDate")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setAsOfDate(IdentifiedDate _asOfDate) {
			this.asOfDate = _asOfDate == null ? null : _asOfDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asOfTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asOfTime")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setAsOfTime(LocalTime _asOfTime) {
			this.asOfTime = _asOfTime == null ? null : _asOfTime;
			return this;
		}
		
		@RosettaAttribute("eventId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventId")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setEventId(EventId _eventId) {
			this.eventId = _eventId == null ? null : _eventId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventType")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setEventType(EventTaxonomy _eventType) {
			this.eventType = _eventType == null ? null : _eventType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventTimestamps")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventTimestamps")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setEventTimestamps(EventTimestamps _eventTimestamps) {
			this.eventTimestamps = _eventTimestamps == null ? null : _eventTimestamps.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingPartyReference")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setReportingPartyReference(PartyReference _reportingPartyReference) {
			this.reportingPartyReference = _reportingPartyReference == null ? null : _reportingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterPartyReference")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setCounterPartyReference(PartyReference _counterPartyReference) {
			this.counterPartyReference = _counterPartyReference == null ? null : _counterPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalChange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalChange")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setNotionalChange(NotionalChangeEnum _notionalChange) {
			this.notionalChange = _notionalChange == null ? null : _notionalChange;
			return this;
		}
		
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInNotional")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNotional(MoneyRef _changeInNotional) {
			if (_changeInNotional != null) {
				this.changeInNotional.add(_changeInNotional.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNotional(MoneyRef _changeInNotional, int idx) {
			getIndex(this.changeInNotional, idx, () -> _changeInNotional.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
			if (changeInNotionals != null) {
				for (final MoneyRef toAdd : changeInNotionals) {
					this.changeInNotional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("changeInNotional")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("changeInNotional")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setChangeInNotional(List<? extends MoneyRef> changeInNotionals) {
			if (changeInNotionals == null) {
				this.changeInNotional = new ArrayList<>();
			} else {
				this.changeInNotional = changeInNotionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNumberOfOptions(AmountRef _changeInNumberOfOptions) {
			if (_changeInNumberOfOptions != null) {
				this.changeInNumberOfOptions.add(_changeInNumberOfOptions.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNumberOfOptions(AmountRef _changeInNumberOfOptions, int idx) {
			getIndex(this.changeInNumberOfOptions, idx, () -> _changeInNumberOfOptions.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
			if (changeInNumberOfOptionss != null) {
				for (final AmountRef toAdd : changeInNumberOfOptionss) {
					this.changeInNumberOfOptions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("changeInNumberOfOptions")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setChangeInNumberOfOptions(List<? extends AmountRef> changeInNumberOfOptionss) {
			if (changeInNumberOfOptionss == null) {
				this.changeInNumberOfOptions = new ArrayList<>();
			} else {
				this.changeInNumberOfOptions = changeInNumberOfOptionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("changeInQuantity")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInQuantity(UnitQuantityRef _changeInQuantity) {
			if (_changeInQuantity != null) {
				this.changeInQuantity.add(_changeInQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInQuantity(UnitQuantityRef _changeInQuantity, int idx) {
			getIndex(this.changeInQuantity, idx, () -> _changeInQuantity.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
			if (changeInQuantitys != null) {
				for (final UnitQuantityRef toAdd : changeInQuantitys) {
					this.changeInQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("changeInQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("changeInQuantity")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setChangeInQuantity(List<? extends UnitQuantityRef> changeInQuantitys) {
			if (changeInQuantitys == null) {
				this.changeInQuantity = new ArrayList<>();
			} else {
				this.changeInQuantity = changeInQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addPayment(NonNegativePayment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addPayment(NonNegativePayment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addPayment(List<? extends NonNegativePayment> payments) {
			if (payments != null) {
				for (final NonNegativePayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setPayment(List<? extends NonNegativePayment> payments) {
			if (payments == null) {
				this.payment = new ArrayList<>();
			} else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("applicableRegulations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicableRegulations")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setApplicableRegulations(ApplicableRegulations _applicableRegulations) {
			this.applicableRegulations = _applicableRegulations == null ? null : _applicableRegulations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("regulationSpecificInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regulationSpecificInformation")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setRegulationSpecificInformation(RegulationDetails _regulationSpecificInformation) {
			this.regulationSpecificInformation = _regulationSpecificInformation == null ? null : _regulationSpecificInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cpmiIoscoCDE")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cpmiIoscoCDE")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setCpmiIoscoCDE(RegReportingCDE _cpmiIoscoCDE) {
			this.cpmiIoscoCDE = _cpmiIoscoCDE == null ? null : _cpmiIoscoCDE.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("trade")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (final BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("collateralization")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addCollateralization(RegulatoryReportingCollateralization _collateralization) {
			if (_collateralization != null) {
				this.collateralization.add(_collateralization.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addCollateralization(RegulatoryReportingCollateralization _collateralization, int idx) {
			getIndex(this.collateralization, idx, () -> _collateralization.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addCollateralization(List<? extends RegulatoryReportingCollateralization> collateralizations) {
			if (collateralizations != null) {
				for (final RegulatoryReportingCollateralization toAdd : collateralizations) {
					this.collateralization.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("collateralization")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("collateralization")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setCollateralization(List<? extends RegulatoryReportingCollateralization> collateralizations) {
			if (collateralizations == null) {
				this.collateralization = new ArrayList<>();
			} else {
				this.collateralization = collateralizations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulatoryDisclosure build() {
			return new RegulatoryDisclosure.RegulatoryDisclosureImpl(this);
		}
		
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder prune() {
			super.prune();
			onBehalfOf = onBehalfOf.stream().filter(b->b!=null).<OnBehalfOf.OnBehalfOfBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (asOfDate!=null && !asOfDate.prune().hasData()) asOfDate = null;
			if (eventId!=null && !eventId.prune().hasData()) eventId = null;
			if (eventType!=null && !eventType.prune().hasData()) eventType = null;
			if (eventTimestamps!=null && !eventTimestamps.prune().hasData()) eventTimestamps = null;
			if (reportingPartyReference!=null && !reportingPartyReference.prune().hasData()) reportingPartyReference = null;
			if (counterPartyReference!=null && !counterPartyReference.prune().hasData()) counterPartyReference = null;
			changeInNotional = changeInNotional.stream().filter(b->b!=null).<MoneyRef.MoneyRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInNumberOfOptions = changeInNumberOfOptions.stream().filter(b->b!=null).<AmountRef.AmountRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			changeInQuantity = changeInQuantity.stream().filter(b->b!=null).<UnitQuantityRef.UnitQuantityRefBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			payment = payment.stream().filter(b->b!=null).<NonNegativePayment.NonNegativePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (applicableRegulations!=null && !applicableRegulations.prune().hasData()) applicableRegulations = null;
			if (regulationSpecificInformation!=null && !regulationSpecificInformation.prune().hasData()) regulationSpecificInformation = null;
			if (cpmiIoscoCDE!=null && !cpmiIoscoCDE.prune().hasData()) cpmiIoscoCDE = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			collateralization = collateralization.stream().filter(b->b!=null).<RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIsCorrection()!=null) return true;
			if (getOnBehalfOf()!=null && getOnBehalfOf().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAsOfDate()!=null && getAsOfDate().hasData()) return true;
			if (getAsOfTime()!=null) return true;
			if (getEventId()!=null && getEventId().hasData()) return true;
			if (getEventType()!=null && getEventType().hasData()) return true;
			if (getEventTimestamps()!=null && getEventTimestamps().hasData()) return true;
			if (getReportingPartyReference()!=null && getReportingPartyReference().hasData()) return true;
			if (getCounterPartyReference()!=null && getCounterPartyReference().hasData()) return true;
			if (getNotionalChange()!=null) return true;
			if (getChangeInNotional()!=null && getChangeInNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInNumberOfOptions()!=null && getChangeInNumberOfOptions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getChangeInQuantity()!=null && getChangeInQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPayment()!=null && getPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getApplicableRegulations()!=null && getApplicableRegulations().hasData()) return true;
			if (getRegulationSpecificInformation()!=null && getRegulationSpecificInformation().hasData()) return true;
			if (getCpmiIoscoCDE()!=null && getCpmiIoscoCDE().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCollateralization()!=null && getCollateralization().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryDisclosure.RegulatoryDisclosureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryDisclosure.RegulatoryDisclosureBuilder o = (RegulatoryDisclosure.RegulatoryDisclosureBuilder) other;
			
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::getOrCreateOnBehalfOf);
			merger.mergeRosetta(getAsOfDate(), o.getAsOfDate(), this::setAsOfDate);
			merger.mergeRosetta(getEventId(), o.getEventId(), this::setEventId);
			merger.mergeRosetta(getEventType(), o.getEventType(), this::setEventType);
			merger.mergeRosetta(getEventTimestamps(), o.getEventTimestamps(), this::setEventTimestamps);
			merger.mergeRosetta(getReportingPartyReference(), o.getReportingPartyReference(), this::setReportingPartyReference);
			merger.mergeRosetta(getCounterPartyReference(), o.getCounterPartyReference(), this::setCounterPartyReference);
			merger.mergeRosetta(getChangeInNotional(), o.getChangeInNotional(), this::getOrCreateChangeInNotional);
			merger.mergeRosetta(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::getOrCreateChangeInNumberOfOptions);
			merger.mergeRosetta(getChangeInQuantity(), o.getChangeInQuantity(), this::getOrCreateChangeInQuantity);
			merger.mergeRosetta(getPayment(), o.getPayment(), this::getOrCreatePayment);
			merger.mergeRosetta(getApplicableRegulations(), o.getApplicableRegulations(), this::setApplicableRegulations);
			merger.mergeRosetta(getRegulationSpecificInformation(), o.getRegulationSpecificInformation(), this::setRegulationSpecificInformation);
			merger.mergeRosetta(getCpmiIoscoCDE(), o.getCpmiIoscoCDE(), this::setCpmiIoscoCDE);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			merger.mergeRosetta(getCollateralization(), o.getCollateralization(), this::getOrCreateCollateralization);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			merger.mergeBasic(getIsCorrection(), o.getIsCorrection(), this::setIsCorrection);
			merger.mergeBasic(getAsOfTime(), o.getAsOfTime(), this::setAsOfTime);
			merger.mergeBasic(getNotionalChange(), o.getNotionalChange(), this::setNotionalChange);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryDisclosure _that = getType().cast(o);
		
			if (!Objects.equals(isCorrection, _that.getIsCorrection())) return false;
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!Objects.equals(asOfTime, _that.getAsOfTime())) return false;
			if (!Objects.equals(eventId, _that.getEventId())) return false;
			if (!Objects.equals(eventType, _that.getEventType())) return false;
			if (!Objects.equals(eventTimestamps, _that.getEventTimestamps())) return false;
			if (!Objects.equals(reportingPartyReference, _that.getReportingPartyReference())) return false;
			if (!Objects.equals(counterPartyReference, _that.getCounterPartyReference())) return false;
			if (!Objects.equals(notionalChange, _that.getNotionalChange())) return false;
			if (!ListEquals.listEquals(changeInNotional, _that.getChangeInNotional())) return false;
			if (!ListEquals.listEquals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!ListEquals.listEquals(changeInQuantity, _that.getChangeInQuantity())) return false;
			if (!ListEquals.listEquals(payment, _that.getPayment())) return false;
			if (!Objects.equals(applicableRegulations, _that.getApplicableRegulations())) return false;
			if (!Objects.equals(regulationSpecificInformation, _that.getRegulationSpecificInformation())) return false;
			if (!Objects.equals(cpmiIoscoCDE, _that.getCpmiIoscoCDE())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(collateralization, _that.getCollateralization())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (isCorrection != null ? isCorrection.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (asOfTime != null ? asOfTime.hashCode() : 0);
			_result = 31 * _result + (eventId != null ? eventId.hashCode() : 0);
			_result = 31 * _result + (eventType != null ? eventType.hashCode() : 0);
			_result = 31 * _result + (eventTimestamps != null ? eventTimestamps.hashCode() : 0);
			_result = 31 * _result + (reportingPartyReference != null ? reportingPartyReference.hashCode() : 0);
			_result = 31 * _result + (counterPartyReference != null ? counterPartyReference.hashCode() : 0);
			_result = 31 * _result + (notionalChange != null ? notionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (changeInNotional != null ? changeInNotional.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (changeInQuantity != null ? changeInQuantity.hashCode() : 0);
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (applicableRegulations != null ? applicableRegulations.hashCode() : 0);
			_result = 31 * _result + (regulationSpecificInformation != null ? regulationSpecificInformation.hashCode() : 0);
			_result = 31 * _result + (cpmiIoscoCDE != null ? cpmiIoscoCDE.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (collateralization != null ? collateralization.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryDisclosureBuilder {" +
				"isCorrection=" + this.isCorrection + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"asOfTime=" + this.asOfTime + ", " +
				"eventId=" + this.eventId + ", " +
				"eventType=" + this.eventType + ", " +
				"eventTimestamps=" + this.eventTimestamps + ", " +
				"reportingPartyReference=" + this.reportingPartyReference + ", " +
				"counterPartyReference=" + this.counterPartyReference + ", " +
				"notionalChange=" + this.notionalChange + ", " +
				"changeInNotional=" + this.changeInNotional + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"changeInQuantity=" + this.changeInQuantity + ", " +
				"payment=" + this.payment + ", " +
				"applicableRegulations=" + this.applicableRegulations + ", " +
				"regulationSpecificInformation=" + this.regulationSpecificInformation + ", " +
				"cpmiIoscoCDE=" + this.cpmiIoscoCDE + ", " +
				"trade=" + this.trade + ", " +
				"quote=" + this.quote + ", " +
				"collateralization=" + this.collateralization + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
