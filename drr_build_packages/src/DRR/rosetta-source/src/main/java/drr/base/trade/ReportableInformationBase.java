package drr.base.trade;

import cdm.event.common.PositionIdentifier;
import cdm.observable.asset.PriceSchedule;
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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.basket.CustomBasket;
import drr.base.trade.meta.ReportableInformationBaseMeta;
import drr.enrichment.common.EnrichmentData;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies jurisdiction-agnostic attributes that provide relevant instruments, fields and flags for reporting.
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableInformationBase", builder=ReportableInformationBase.ReportableInformationBaseBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableInformationBase", model="drr", builder=ReportableInformationBase.ReportableInformationBaseBuilderImpl.class, version="7.7.0")
public interface ReportableInformationBase extends RosettaModelObject {

	ReportableInformationBaseMeta metaData = new ReportableInformationBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the jurisdiction-agnostic, party-specific data necessary for reporting.
	 */
	List<? extends PartyInformation> getGlobalPartyInformation();
	/**
	 * Specifies the regulatory lifecycle event action for the ReportableEvent.
	 */
	ReportableActionEnum getReportableAction();
	EnrichmentData getEnrichment();
	/**
	 * Specifies the method for confirmation of the transacion.
	 */
	ConfirmationMethodEnum getConfirmationMethod();
	/**
	 * Date and time a transaction was originally executed, resulting in the generation of a new UTI. This data element remains unchanged throughout the life of the UTI.
	 */
	ZonedDateTime getOriginalExecutionTimestamp();
	/**
	 * Date as per the contract, by which all transfer of cash or assets should take place and the counterparties should no longer have any outstanding obligations to each other under that contract.
	 */
	Date getFinalContractualSettlementDate();
	/**
	 * Indicator whether the derivative is based on crypto-assets.
	 */
	Boolean getCryptoBased();
	/**
	 * Information pertaining to Custom Basket.
	 */
	CustomBasket getCustomBasket();
	/**
	 * Specifies whether the contract was entered into as an intragroup transaction, defined in Article 3 of Regulation (EU) No 648/2012.
	 */
	Boolean getIntragroup();
	/**
	 * Indicates whether the transaction is between two affiliated entities. It is referred to as Inter-affiliate under the Canadian CSA reporting regime.
	 */
	Boolean getAffiliated();
	/**
	 * Last Available Spot Price of the underlying asset. This price is only needed for a regulatory purpose, that being the reporting of the notional amount for commodity basis products
	 */
	PriceSchedule getUnderlyingAssetLastAvailableSpotPrice();
	/**
	 * Underlying Asset Price Source is only needed for a regulatory purpose, that being the source of the price used to determine the value or level of the asset or benchmark.
	 */
	List<? extends ReportablePriceSource> getUnderlyingAssetPriceSource();
	/**
	 * The UTI of the position in which a derivative transaction is included.
	 */
	PositionIdentifier getSubsequentPositionUTI();
	/**
	 * The prior position UTI (e.g. in case of a corporate action of type StockIdentifierChange).
	 */
	PositionIdentifier getCounterpartyPositionPriorUTI();

	/*********************** Build Methods  ***********************/
	ReportableInformationBase build();
	
	ReportableInformationBase.ReportableInformationBaseBuilder toBuilder();
	
	static ReportableInformationBase.ReportableInformationBaseBuilder builder() {
		return new ReportableInformationBase.ReportableInformationBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableInformationBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableInformationBase> getType() {
		return ReportableInformationBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("globalPartyInformation"), processor, PartyInformation.class, getGlobalPartyInformation());
		processor.processBasic(path.newSubPath("reportableAction"), ReportableActionEnum.class, getReportableAction(), this);
		processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.class, getEnrichment());
		processor.processBasic(path.newSubPath("confirmationMethod"), ConfirmationMethodEnum.class, getConfirmationMethod(), this);
		processor.processBasic(path.newSubPath("originalExecutionTimestamp"), ZonedDateTime.class, getOriginalExecutionTimestamp(), this);
		processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
		processor.processBasic(path.newSubPath("cryptoBased"), Boolean.class, getCryptoBased(), this);
		processRosetta(path.newSubPath("customBasket"), processor, CustomBasket.class, getCustomBasket());
		processor.processBasic(path.newSubPath("intragroup"), Boolean.class, getIntragroup(), this);
		processor.processBasic(path.newSubPath("affiliated"), Boolean.class, getAffiliated(), this);
		processRosetta(path.newSubPath("underlyingAssetLastAvailableSpotPrice"), processor, PriceSchedule.class, getUnderlyingAssetLastAvailableSpotPrice());
		processRosetta(path.newSubPath("underlyingAssetPriceSource"), processor, ReportablePriceSource.class, getUnderlyingAssetPriceSource());
		processRosetta(path.newSubPath("subsequentPositionUTI"), processor, PositionIdentifier.class, getSubsequentPositionUTI());
		processRosetta(path.newSubPath("counterpartyPositionPriorUTI"), processor, PositionIdentifier.class, getCounterpartyPositionPriorUTI());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableInformationBaseBuilder extends ReportableInformationBase, RosettaModelObjectBuilder {
		PartyInformation.PartyInformationBuilder getOrCreateGlobalPartyInformation(int index);
		@Override
		List<? extends PartyInformation.PartyInformationBuilder> getGlobalPartyInformation();
		EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment();
		@Override
		EnrichmentData.EnrichmentDataBuilder getEnrichment();
		CustomBasket.CustomBasketBuilder getOrCreateCustomBasket();
		@Override
		CustomBasket.CustomBasketBuilder getCustomBasket();
		PriceSchedule.PriceScheduleBuilder getOrCreateUnderlyingAssetLastAvailableSpotPrice();
		@Override
		PriceSchedule.PriceScheduleBuilder getUnderlyingAssetLastAvailableSpotPrice();
		ReportablePriceSource.ReportablePriceSourceBuilder getOrCreateUnderlyingAssetPriceSource(int index);
		@Override
		List<? extends ReportablePriceSource.ReportablePriceSourceBuilder> getUnderlyingAssetPriceSource();
		PositionIdentifier.PositionIdentifierBuilder getOrCreateSubsequentPositionUTI();
		@Override
		PositionIdentifier.PositionIdentifierBuilder getSubsequentPositionUTI();
		PositionIdentifier.PositionIdentifierBuilder getOrCreateCounterpartyPositionPriorUTI();
		@Override
		PositionIdentifier.PositionIdentifierBuilder getCounterpartyPositionPriorUTI();
		ReportableInformationBase.ReportableInformationBaseBuilder addGlobalPartyInformation(PartyInformation globalPartyInformation);
		ReportableInformationBase.ReportableInformationBaseBuilder addGlobalPartyInformation(PartyInformation globalPartyInformation, int idx);
		ReportableInformationBase.ReportableInformationBaseBuilder addGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformation);
		ReportableInformationBase.ReportableInformationBaseBuilder setGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformation);
		ReportableInformationBase.ReportableInformationBaseBuilder setReportableAction(ReportableActionEnum reportableAction);
		ReportableInformationBase.ReportableInformationBaseBuilder setEnrichment(EnrichmentData enrichment);
		ReportableInformationBase.ReportableInformationBaseBuilder setConfirmationMethod(ConfirmationMethodEnum confirmationMethod);
		ReportableInformationBase.ReportableInformationBaseBuilder setOriginalExecutionTimestamp(ZonedDateTime originalExecutionTimestamp);
		ReportableInformationBase.ReportableInformationBaseBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		ReportableInformationBase.ReportableInformationBaseBuilder setCryptoBased(Boolean cryptoBased);
		ReportableInformationBase.ReportableInformationBaseBuilder setCustomBasket(CustomBasket customBasket);
		ReportableInformationBase.ReportableInformationBaseBuilder setIntragroup(Boolean intragroup);
		ReportableInformationBase.ReportableInformationBaseBuilder setAffiliated(Boolean affiliated);
		ReportableInformationBase.ReportableInformationBaseBuilder setUnderlyingAssetLastAvailableSpotPrice(PriceSchedule underlyingAssetLastAvailableSpotPrice);
		ReportableInformationBase.ReportableInformationBaseBuilder addUnderlyingAssetPriceSource(ReportablePriceSource underlyingAssetPriceSource);
		ReportableInformationBase.ReportableInformationBaseBuilder addUnderlyingAssetPriceSource(ReportablePriceSource underlyingAssetPriceSource, int idx);
		ReportableInformationBase.ReportableInformationBaseBuilder addUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSource);
		ReportableInformationBase.ReportableInformationBaseBuilder setUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSource);
		ReportableInformationBase.ReportableInformationBaseBuilder setSubsequentPositionUTI(PositionIdentifier subsequentPositionUTI);
		ReportableInformationBase.ReportableInformationBaseBuilder setCounterpartyPositionPriorUTI(PositionIdentifier counterpartyPositionPriorUTI);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("globalPartyInformation"), processor, PartyInformation.PartyInformationBuilder.class, getGlobalPartyInformation());
			processor.processBasic(path.newSubPath("reportableAction"), ReportableActionEnum.class, getReportableAction(), this);
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
			processor.processBasic(path.newSubPath("confirmationMethod"), ConfirmationMethodEnum.class, getConfirmationMethod(), this);
			processor.processBasic(path.newSubPath("originalExecutionTimestamp"), ZonedDateTime.class, getOriginalExecutionTimestamp(), this);
			processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
			processor.processBasic(path.newSubPath("cryptoBased"), Boolean.class, getCryptoBased(), this);
			processRosetta(path.newSubPath("customBasket"), processor, CustomBasket.CustomBasketBuilder.class, getCustomBasket());
			processor.processBasic(path.newSubPath("intragroup"), Boolean.class, getIntragroup(), this);
			processor.processBasic(path.newSubPath("affiliated"), Boolean.class, getAffiliated(), this);
			processRosetta(path.newSubPath("underlyingAssetLastAvailableSpotPrice"), processor, PriceSchedule.PriceScheduleBuilder.class, getUnderlyingAssetLastAvailableSpotPrice());
			processRosetta(path.newSubPath("underlyingAssetPriceSource"), processor, ReportablePriceSource.ReportablePriceSourceBuilder.class, getUnderlyingAssetPriceSource());
			processRosetta(path.newSubPath("subsequentPositionUTI"), processor, PositionIdentifier.PositionIdentifierBuilder.class, getSubsequentPositionUTI());
			processRosetta(path.newSubPath("counterpartyPositionPriorUTI"), processor, PositionIdentifier.PositionIdentifierBuilder.class, getCounterpartyPositionPriorUTI());
		}
		

		ReportableInformationBase.ReportableInformationBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableInformationBase  ***********************/
	class ReportableInformationBaseImpl implements ReportableInformationBase {
		private final List<? extends PartyInformation> globalPartyInformation;
		private final ReportableActionEnum reportableAction;
		private final EnrichmentData enrichment;
		private final ConfirmationMethodEnum confirmationMethod;
		private final ZonedDateTime originalExecutionTimestamp;
		private final Date finalContractualSettlementDate;
		private final Boolean cryptoBased;
		private final CustomBasket customBasket;
		private final Boolean intragroup;
		private final Boolean affiliated;
		private final PriceSchedule underlyingAssetLastAvailableSpotPrice;
		private final List<? extends ReportablePriceSource> underlyingAssetPriceSource;
		private final PositionIdentifier subsequentPositionUTI;
		private final PositionIdentifier counterpartyPositionPriorUTI;
		
		protected ReportableInformationBaseImpl(ReportableInformationBase.ReportableInformationBaseBuilder builder) {
			this.globalPartyInformation = ofNullable(builder.getGlobalPartyInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportableAction = builder.getReportableAction();
			this.enrichment = ofNullable(builder.getEnrichment()).map(f->f.build()).orElse(null);
			this.confirmationMethod = builder.getConfirmationMethod();
			this.originalExecutionTimestamp = builder.getOriginalExecutionTimestamp();
			this.finalContractualSettlementDate = builder.getFinalContractualSettlementDate();
			this.cryptoBased = builder.getCryptoBased();
			this.customBasket = ofNullable(builder.getCustomBasket()).map(f->f.build()).orElse(null);
			this.intragroup = builder.getIntragroup();
			this.affiliated = builder.getAffiliated();
			this.underlyingAssetLastAvailableSpotPrice = ofNullable(builder.getUnderlyingAssetLastAvailableSpotPrice()).map(f->f.build()).orElse(null);
			this.underlyingAssetPriceSource = ofNullable(builder.getUnderlyingAssetPriceSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.subsequentPositionUTI = ofNullable(builder.getSubsequentPositionUTI()).map(f->f.build()).orElse(null);
			this.counterpartyPositionPriorUTI = ofNullable(builder.getCounterpartyPositionPriorUTI()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("globalPartyInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("globalPartyInformation")
		public List<? extends PartyInformation> getGlobalPartyInformation() {
			return globalPartyInformation;
		}
		
		@Override
		@RosettaAttribute("reportableAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportableAction")
		public ReportableActionEnum getReportableAction() {
			return reportableAction;
		}
		
		@Override
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enrichment")
		public EnrichmentData getEnrichment() {
			return enrichment;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationMethod")
		public ConfirmationMethodEnum getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		@RosettaAttribute("originalExecutionTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalExecutionTimestamp")
		public ZonedDateTime getOriginalExecutionTimestamp() {
			return originalExecutionTimestamp;
		}
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalContractualSettlementDate")
		public Date getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		@RosettaAttribute("cryptoBased")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cryptoBased")
		public Boolean getCryptoBased() {
			return cryptoBased;
		}
		
		@Override
		@RosettaAttribute("customBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasket")
		public CustomBasket getCustomBasket() {
			return customBasket;
		}
		
		@Override
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intragroup")
		public Boolean getIntragroup() {
			return intragroup;
		}
		
		@Override
		@RosettaAttribute("affiliated")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("affiliated")
		public Boolean getAffiliated() {
			return affiliated;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetLastAvailableSpotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetLastAvailableSpotPrice")
		public PriceSchedule getUnderlyingAssetLastAvailableSpotPrice() {
			return underlyingAssetLastAvailableSpotPrice;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetPriceSource")
		public List<? extends ReportablePriceSource> getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@Override
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subsequentPositionUTI")
		public PositionIdentifier getSubsequentPositionUTI() {
			return subsequentPositionUTI;
		}
		
		@Override
		@RosettaAttribute("counterpartyPositionPriorUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterpartyPositionPriorUTI")
		public PositionIdentifier getCounterpartyPositionPriorUTI() {
			return counterpartyPositionPriorUTI;
		}
		
		@Override
		public ReportableInformationBase build() {
			return this;
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder toBuilder() {
			ReportableInformationBase.ReportableInformationBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableInformationBase.ReportableInformationBaseBuilder builder) {
			ofNullable(getGlobalPartyInformation()).ifPresent(builder::setGlobalPartyInformation);
			ofNullable(getReportableAction()).ifPresent(builder::setReportableAction);
			ofNullable(getEnrichment()).ifPresent(builder::setEnrichment);
			ofNullable(getConfirmationMethod()).ifPresent(builder::setConfirmationMethod);
			ofNullable(getOriginalExecutionTimestamp()).ifPresent(builder::setOriginalExecutionTimestamp);
			ofNullable(getFinalContractualSettlementDate()).ifPresent(builder::setFinalContractualSettlementDate);
			ofNullable(getCryptoBased()).ifPresent(builder::setCryptoBased);
			ofNullable(getCustomBasket()).ifPresent(builder::setCustomBasket);
			ofNullable(getIntragroup()).ifPresent(builder::setIntragroup);
			ofNullable(getAffiliated()).ifPresent(builder::setAffiliated);
			ofNullable(getUnderlyingAssetLastAvailableSpotPrice()).ifPresent(builder::setUnderlyingAssetLastAvailableSpotPrice);
			ofNullable(getUnderlyingAssetPriceSource()).ifPresent(builder::setUnderlyingAssetPriceSource);
			ofNullable(getSubsequentPositionUTI()).ifPresent(builder::setSubsequentPositionUTI);
			ofNullable(getCounterpartyPositionPriorUTI()).ifPresent(builder::setCounterpartyPositionPriorUTI);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableInformationBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(globalPartyInformation, _that.getGlobalPartyInformation())) return false;
			if (!Objects.equals(reportableAction, _that.getReportableAction())) return false;
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(originalExecutionTimestamp, _that.getOriginalExecutionTimestamp())) return false;
			if (!Objects.equals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			if (!Objects.equals(cryptoBased, _that.getCryptoBased())) return false;
			if (!Objects.equals(customBasket, _that.getCustomBasket())) return false;
			if (!Objects.equals(intragroup, _that.getIntragroup())) return false;
			if (!Objects.equals(affiliated, _that.getAffiliated())) return false;
			if (!Objects.equals(underlyingAssetLastAvailableSpotPrice, _that.getUnderlyingAssetLastAvailableSpotPrice())) return false;
			if (!ListEquals.listEquals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			if (!Objects.equals(subsequentPositionUTI, _that.getSubsequentPositionUTI())) return false;
			if (!Objects.equals(counterpartyPositionPriorUTI, _that.getCounterpartyPositionPriorUTI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (globalPartyInformation != null ? globalPartyInformation.hashCode() : 0);
			_result = 31 * _result + (reportableAction != null ? reportableAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (originalExecutionTimestamp != null ? originalExecutionTimestamp.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			_result = 31 * _result + (cryptoBased != null ? cryptoBased.hashCode() : 0);
			_result = 31 * _result + (customBasket != null ? customBasket.hashCode() : 0);
			_result = 31 * _result + (intragroup != null ? intragroup.hashCode() : 0);
			_result = 31 * _result + (affiliated != null ? affiliated.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetLastAvailableSpotPrice != null ? underlyingAssetLastAvailableSpotPrice.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			_result = 31 * _result + (subsequentPositionUTI != null ? subsequentPositionUTI.hashCode() : 0);
			_result = 31 * _result + (counterpartyPositionPriorUTI != null ? counterpartyPositionPriorUTI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableInformationBase {" +
				"globalPartyInformation=" + this.globalPartyInformation + ", " +
				"reportableAction=" + this.reportableAction + ", " +
				"enrichment=" + this.enrichment + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"originalExecutionTimestamp=" + this.originalExecutionTimestamp + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate + ", " +
				"cryptoBased=" + this.cryptoBased + ", " +
				"customBasket=" + this.customBasket + ", " +
				"intragroup=" + this.intragroup + ", " +
				"affiliated=" + this.affiliated + ", " +
				"underlyingAssetLastAvailableSpotPrice=" + this.underlyingAssetLastAvailableSpotPrice + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource + ", " +
				"subsequentPositionUTI=" + this.subsequentPositionUTI + ", " +
				"counterpartyPositionPriorUTI=" + this.counterpartyPositionPriorUTI +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportableInformationBase  ***********************/
	class ReportableInformationBaseBuilderImpl implements ReportableInformationBase.ReportableInformationBaseBuilder {
	
		protected List<PartyInformation.PartyInformationBuilder> globalPartyInformation = new ArrayList<>();
		protected ReportableActionEnum reportableAction;
		protected EnrichmentData.EnrichmentDataBuilder enrichment;
		protected ConfirmationMethodEnum confirmationMethod;
		protected ZonedDateTime originalExecutionTimestamp;
		protected Date finalContractualSettlementDate;
		protected Boolean cryptoBased;
		protected CustomBasket.CustomBasketBuilder customBasket;
		protected Boolean intragroup;
		protected Boolean affiliated;
		protected PriceSchedule.PriceScheduleBuilder underlyingAssetLastAvailableSpotPrice;
		protected List<ReportablePriceSource.ReportablePriceSourceBuilder> underlyingAssetPriceSource = new ArrayList<>();
		protected PositionIdentifier.PositionIdentifierBuilder subsequentPositionUTI;
		protected PositionIdentifier.PositionIdentifierBuilder counterpartyPositionPriorUTI;
		
		@Override
		@RosettaAttribute("globalPartyInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("globalPartyInformation")
		public List<? extends PartyInformation.PartyInformationBuilder> getGlobalPartyInformation() {
			return globalPartyInformation;
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder getOrCreateGlobalPartyInformation(int index) {
			if (globalPartyInformation==null) {
				this.globalPartyInformation = new ArrayList<>();
			}
			return getIndex(globalPartyInformation, index, () -> {
						PartyInformation.PartyInformationBuilder newGlobalPartyInformation = PartyInformation.builder();
						return newGlobalPartyInformation;
					});
		}
		
		@Override
		@RosettaAttribute("reportableAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportableAction")
		public ReportableActionEnum getReportableAction() {
			return reportableAction;
		}
		
		@Override
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enrichment")
		public EnrichmentData.EnrichmentDataBuilder getEnrichment() {
			return enrichment;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment() {
			EnrichmentData.EnrichmentDataBuilder result;
			if (enrichment!=null) {
				result = enrichment;
			}
			else {
				result = enrichment = EnrichmentData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmationMethod")
		public ConfirmationMethodEnum getConfirmationMethod() {
			return confirmationMethod;
		}
		
		@Override
		@RosettaAttribute("originalExecutionTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalExecutionTimestamp")
		public ZonedDateTime getOriginalExecutionTimestamp() {
			return originalExecutionTimestamp;
		}
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalContractualSettlementDate")
		public Date getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		@RosettaAttribute("cryptoBased")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cryptoBased")
		public Boolean getCryptoBased() {
			return cryptoBased;
		}
		
		@Override
		@RosettaAttribute("customBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasket")
		public CustomBasket.CustomBasketBuilder getCustomBasket() {
			return customBasket;
		}
		
		@Override
		public CustomBasket.CustomBasketBuilder getOrCreateCustomBasket() {
			CustomBasket.CustomBasketBuilder result;
			if (customBasket!=null) {
				result = customBasket;
			}
			else {
				result = customBasket = CustomBasket.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intragroup")
		public Boolean getIntragroup() {
			return intragroup;
		}
		
		@Override
		@RosettaAttribute("affiliated")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("affiliated")
		public Boolean getAffiliated() {
			return affiliated;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetLastAvailableSpotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetLastAvailableSpotPrice")
		public PriceSchedule.PriceScheduleBuilder getUnderlyingAssetLastAvailableSpotPrice() {
			return underlyingAssetLastAvailableSpotPrice;
		}
		
		@Override
		public PriceSchedule.PriceScheduleBuilder getOrCreateUnderlyingAssetLastAvailableSpotPrice() {
			PriceSchedule.PriceScheduleBuilder result;
			if (underlyingAssetLastAvailableSpotPrice!=null) {
				result = underlyingAssetLastAvailableSpotPrice;
			}
			else {
				result = underlyingAssetLastAvailableSpotPrice = PriceSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetPriceSource")
		public List<? extends ReportablePriceSource.ReportablePriceSourceBuilder> getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder getOrCreateUnderlyingAssetPriceSource(int index) {
			if (underlyingAssetPriceSource==null) {
				this.underlyingAssetPriceSource = new ArrayList<>();
			}
			return getIndex(underlyingAssetPriceSource, index, () -> {
						ReportablePriceSource.ReportablePriceSourceBuilder newUnderlyingAssetPriceSource = ReportablePriceSource.builder();
						return newUnderlyingAssetPriceSource;
					});
		}
		
		@Override
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subsequentPositionUTI")
		public PositionIdentifier.PositionIdentifierBuilder getSubsequentPositionUTI() {
			return subsequentPositionUTI;
		}
		
		@Override
		public PositionIdentifier.PositionIdentifierBuilder getOrCreateSubsequentPositionUTI() {
			PositionIdentifier.PositionIdentifierBuilder result;
			if (subsequentPositionUTI!=null) {
				result = subsequentPositionUTI;
			}
			else {
				result = subsequentPositionUTI = PositionIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterpartyPositionPriorUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterpartyPositionPriorUTI")
		public PositionIdentifier.PositionIdentifierBuilder getCounterpartyPositionPriorUTI() {
			return counterpartyPositionPriorUTI;
		}
		
		@Override
		public PositionIdentifier.PositionIdentifierBuilder getOrCreateCounterpartyPositionPriorUTI() {
			PositionIdentifier.PositionIdentifierBuilder result;
			if (counterpartyPositionPriorUTI!=null) {
				result = counterpartyPositionPriorUTI;
			}
			else {
				result = counterpartyPositionPriorUTI = PositionIdentifier.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("globalPartyInformation")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("globalPartyInformation")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder addGlobalPartyInformation(PartyInformation _globalPartyInformation) {
			if (_globalPartyInformation != null) {
				this.globalPartyInformation.add(_globalPartyInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder addGlobalPartyInformation(PartyInformation _globalPartyInformation, int idx) {
			getIndex(this.globalPartyInformation, idx, () -> _globalPartyInformation.toBuilder());
			return this;
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder addGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformations) {
			if (globalPartyInformations != null) {
				for (final PartyInformation toAdd : globalPartyInformations) {
					this.globalPartyInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("globalPartyInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("globalPartyInformation")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformations) {
			if (globalPartyInformations == null) {
				this.globalPartyInformation = new ArrayList<>();
			} else {
				this.globalPartyInformation = globalPartyInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportableAction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportableAction")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setReportableAction(ReportableActionEnum _reportableAction) {
			this.reportableAction = _reportableAction == null ? null : _reportableAction;
			return this;
		}
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationMethod")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setConfirmationMethod(ConfirmationMethodEnum _confirmationMethod) {
			this.confirmationMethod = _confirmationMethod == null ? null : _confirmationMethod;
			return this;
		}
		
		@RosettaAttribute("originalExecutionTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalExecutionTimestamp")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setOriginalExecutionTimestamp(ZonedDateTime _originalExecutionTimestamp) {
			this.originalExecutionTimestamp = _originalExecutionTimestamp == null ? null : _originalExecutionTimestamp;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("cryptoBased")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoBased")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setCryptoBased(Boolean _cryptoBased) {
			this.cryptoBased = _cryptoBased == null ? null : _cryptoBased;
			return this;
		}
		
		@RosettaAttribute("customBasket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasket")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setCustomBasket(CustomBasket _customBasket) {
			this.customBasket = _customBasket == null ? null : _customBasket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("affiliated")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("affiliated")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setAffiliated(Boolean _affiliated) {
			this.affiliated = _affiliated == null ? null : _affiliated;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetLastAvailableSpotPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetLastAvailableSpotPrice")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setUnderlyingAssetLastAvailableSpotPrice(PriceSchedule _underlyingAssetLastAvailableSpotPrice) {
			this.underlyingAssetLastAvailableSpotPrice = _underlyingAssetLastAvailableSpotPrice == null ? null : _underlyingAssetLastAvailableSpotPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder addUnderlyingAssetPriceSource(ReportablePriceSource _underlyingAssetPriceSource) {
			if (_underlyingAssetPriceSource != null) {
				this.underlyingAssetPriceSource.add(_underlyingAssetPriceSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder addUnderlyingAssetPriceSource(ReportablePriceSource _underlyingAssetPriceSource, int idx) {
			getIndex(this.underlyingAssetPriceSource, idx, () -> _underlyingAssetPriceSource.toBuilder());
			return this;
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder addUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSources) {
			if (underlyingAssetPriceSources != null) {
				for (final ReportablePriceSource toAdd : underlyingAssetPriceSources) {
					this.underlyingAssetPriceSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSources) {
			if (underlyingAssetPriceSources == null) {
				this.underlyingAssetPriceSource = new ArrayList<>();
			} else {
				this.underlyingAssetPriceSource = underlyingAssetPriceSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("subsequentPositionUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subsequentPositionUTI")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setSubsequentPositionUTI(PositionIdentifier _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterpartyPositionPriorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterpartyPositionPriorUTI")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder setCounterpartyPositionPriorUTI(PositionIdentifier _counterpartyPositionPriorUTI) {
			this.counterpartyPositionPriorUTI = _counterpartyPositionPriorUTI == null ? null : _counterpartyPositionPriorUTI.toBuilder();
			return this;
		}
		
		@Override
		public ReportableInformationBase build() {
			return new ReportableInformationBase.ReportableInformationBaseImpl(this);
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder prune() {
			globalPartyInformation = globalPartyInformation.stream().filter(b->b!=null).<PartyInformation.PartyInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (enrichment!=null && !enrichment.prune().hasData()) enrichment = null;
			if (customBasket!=null && !customBasket.prune().hasData()) customBasket = null;
			if (underlyingAssetLastAvailableSpotPrice!=null && !underlyingAssetLastAvailableSpotPrice.prune().hasData()) underlyingAssetLastAvailableSpotPrice = null;
			underlyingAssetPriceSource = underlyingAssetPriceSource.stream().filter(b->b!=null).<ReportablePriceSource.ReportablePriceSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (subsequentPositionUTI!=null && !subsequentPositionUTI.prune().hasData()) subsequentPositionUTI = null;
			if (counterpartyPositionPriorUTI!=null && !counterpartyPositionPriorUTI.prune().hasData()) counterpartyPositionPriorUTI = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGlobalPartyInformation()!=null && getGlobalPartyInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportableAction()!=null) return true;
			if (getEnrichment()!=null && getEnrichment().hasData()) return true;
			if (getConfirmationMethod()!=null) return true;
			if (getOriginalExecutionTimestamp()!=null) return true;
			if (getFinalContractualSettlementDate()!=null) return true;
			if (getCryptoBased()!=null) return true;
			if (getCustomBasket()!=null && getCustomBasket().hasData()) return true;
			if (getIntragroup()!=null) return true;
			if (getAffiliated()!=null) return true;
			if (getUnderlyingAssetLastAvailableSpotPrice()!=null && getUnderlyingAssetLastAvailableSpotPrice().hasData()) return true;
			if (getUnderlyingAssetPriceSource()!=null && getUnderlyingAssetPriceSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSubsequentPositionUTI()!=null && getSubsequentPositionUTI().hasData()) return true;
			if (getCounterpartyPositionPriorUTI()!=null && getCounterpartyPositionPriorUTI().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableInformationBase.ReportableInformationBaseBuilder o = (ReportableInformationBase.ReportableInformationBaseBuilder) other;
			
			merger.mergeRosetta(getGlobalPartyInformation(), o.getGlobalPartyInformation(), this::getOrCreateGlobalPartyInformation);
			merger.mergeRosetta(getEnrichment(), o.getEnrichment(), this::setEnrichment);
			merger.mergeRosetta(getCustomBasket(), o.getCustomBasket(), this::setCustomBasket);
			merger.mergeRosetta(getUnderlyingAssetLastAvailableSpotPrice(), o.getUnderlyingAssetLastAvailableSpotPrice(), this::setUnderlyingAssetLastAvailableSpotPrice);
			merger.mergeRosetta(getUnderlyingAssetPriceSource(), o.getUnderlyingAssetPriceSource(), this::getOrCreateUnderlyingAssetPriceSource);
			merger.mergeRosetta(getSubsequentPositionUTI(), o.getSubsequentPositionUTI(), this::setSubsequentPositionUTI);
			merger.mergeRosetta(getCounterpartyPositionPriorUTI(), o.getCounterpartyPositionPriorUTI(), this::setCounterpartyPositionPriorUTI);
			
			merger.mergeBasic(getReportableAction(), o.getReportableAction(), this::setReportableAction);
			merger.mergeBasic(getConfirmationMethod(), o.getConfirmationMethod(), this::setConfirmationMethod);
			merger.mergeBasic(getOriginalExecutionTimestamp(), o.getOriginalExecutionTimestamp(), this::setOriginalExecutionTimestamp);
			merger.mergeBasic(getFinalContractualSettlementDate(), o.getFinalContractualSettlementDate(), this::setFinalContractualSettlementDate);
			merger.mergeBasic(getCryptoBased(), o.getCryptoBased(), this::setCryptoBased);
			merger.mergeBasic(getIntragroup(), o.getIntragroup(), this::setIntragroup);
			merger.mergeBasic(getAffiliated(), o.getAffiliated(), this::setAffiliated);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableInformationBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(globalPartyInformation, _that.getGlobalPartyInformation())) return false;
			if (!Objects.equals(reportableAction, _that.getReportableAction())) return false;
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(confirmationMethod, _that.getConfirmationMethod())) return false;
			if (!Objects.equals(originalExecutionTimestamp, _that.getOriginalExecutionTimestamp())) return false;
			if (!Objects.equals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			if (!Objects.equals(cryptoBased, _that.getCryptoBased())) return false;
			if (!Objects.equals(customBasket, _that.getCustomBasket())) return false;
			if (!Objects.equals(intragroup, _that.getIntragroup())) return false;
			if (!Objects.equals(affiliated, _that.getAffiliated())) return false;
			if (!Objects.equals(underlyingAssetLastAvailableSpotPrice, _that.getUnderlyingAssetLastAvailableSpotPrice())) return false;
			if (!ListEquals.listEquals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			if (!Objects.equals(subsequentPositionUTI, _that.getSubsequentPositionUTI())) return false;
			if (!Objects.equals(counterpartyPositionPriorUTI, _that.getCounterpartyPositionPriorUTI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (globalPartyInformation != null ? globalPartyInformation.hashCode() : 0);
			_result = 31 * _result + (reportableAction != null ? reportableAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (confirmationMethod != null ? confirmationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (originalExecutionTimestamp != null ? originalExecutionTimestamp.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			_result = 31 * _result + (cryptoBased != null ? cryptoBased.hashCode() : 0);
			_result = 31 * _result + (customBasket != null ? customBasket.hashCode() : 0);
			_result = 31 * _result + (intragroup != null ? intragroup.hashCode() : 0);
			_result = 31 * _result + (affiliated != null ? affiliated.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetLastAvailableSpotPrice != null ? underlyingAssetLastAvailableSpotPrice.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			_result = 31 * _result + (subsequentPositionUTI != null ? subsequentPositionUTI.hashCode() : 0);
			_result = 31 * _result + (counterpartyPositionPriorUTI != null ? counterpartyPositionPriorUTI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableInformationBaseBuilder {" +
				"globalPartyInformation=" + this.globalPartyInformation + ", " +
				"reportableAction=" + this.reportableAction + ", " +
				"enrichment=" + this.enrichment + ", " +
				"confirmationMethod=" + this.confirmationMethod + ", " +
				"originalExecutionTimestamp=" + this.originalExecutionTimestamp + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate + ", " +
				"cryptoBased=" + this.cryptoBased + ", " +
				"customBasket=" + this.customBasket + ", " +
				"intragroup=" + this.intragroup + ", " +
				"affiliated=" + this.affiliated + ", " +
				"underlyingAssetLastAvailableSpotPrice=" + this.underlyingAssetLastAvailableSpotPrice + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource + ", " +
				"subsequentPositionUTI=" + this.subsequentPositionUTI + ", " +
				"counterpartyPositionPriorUTI=" + this.counterpartyPositionPriorUTI +
			'}';
		}
	}
}
