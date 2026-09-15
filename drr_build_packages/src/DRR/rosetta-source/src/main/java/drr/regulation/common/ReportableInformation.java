package drr.regulation.common;

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
import drr.base.trade.ConfirmationMethodEnum;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportablePriceSource;
import drr.base.trade.basket.CustomBasket;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.meta.ReportableInformationMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the relevant regulators or other supervisory bodies the transaction is relevant for, and regime specific information required relating to the transaction and the parties.
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableInformation", builder=ReportableInformation.ReportableInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableInformation", model="drr", builder=ReportableInformation.ReportableInformationBuilderImpl.class, version="7.7.0")
public interface ReportableInformation extends ReportableInformationBase {

	ReportableInformationMeta metaData = new ReportableInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the jurisdictions-specific data necessary for reporting.
	 */
	List<? extends ReportableJurisdictionInformation> getJurisdictionInformation();

	/*********************** Build Methods  ***********************/
	ReportableInformation build();
	
	ReportableInformation.ReportableInformationBuilder toBuilder();
	
	static ReportableInformation.ReportableInformationBuilder builder() {
		return new ReportableInformation.ReportableInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableInformation> getType() {
		return ReportableInformation.class;
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
		processRosetta(path.newSubPath("jurisdictionInformation"), processor, ReportableJurisdictionInformation.class, getJurisdictionInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableInformationBuilder extends ReportableInformation, ReportableInformationBase.ReportableInformationBaseBuilder {
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder getOrCreateJurisdictionInformation(int index);
		@Override
		List<? extends ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> getJurisdictionInformation();
		@Override
		ReportableInformation.ReportableInformationBuilder addGlobalPartyInformation(PartyInformation globalPartyInformation);
		@Override
		ReportableInformation.ReportableInformationBuilder addGlobalPartyInformation(PartyInformation globalPartyInformation, int idx);
		@Override
		ReportableInformation.ReportableInformationBuilder addGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformation);
		@Override
		ReportableInformation.ReportableInformationBuilder setGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformation);
		@Override
		ReportableInformation.ReportableInformationBuilder setReportableAction(ReportableActionEnum reportableAction);
		@Override
		ReportableInformation.ReportableInformationBuilder setEnrichment(EnrichmentData enrichment);
		@Override
		ReportableInformation.ReportableInformationBuilder setConfirmationMethod(ConfirmationMethodEnum confirmationMethod);
		@Override
		ReportableInformation.ReportableInformationBuilder setOriginalExecutionTimestamp(ZonedDateTime originalExecutionTimestamp);
		@Override
		ReportableInformation.ReportableInformationBuilder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		ReportableInformation.ReportableInformationBuilder setCryptoBased(Boolean cryptoBased);
		@Override
		ReportableInformation.ReportableInformationBuilder setCustomBasket(CustomBasket customBasket);
		@Override
		ReportableInformation.ReportableInformationBuilder setIntragroup(Boolean intragroup);
		@Override
		ReportableInformation.ReportableInformationBuilder setAffiliated(Boolean affiliated);
		@Override
		ReportableInformation.ReportableInformationBuilder setUnderlyingAssetLastAvailableSpotPrice(PriceSchedule underlyingAssetLastAvailableSpotPrice);
		@Override
		ReportableInformation.ReportableInformationBuilder addUnderlyingAssetPriceSource(ReportablePriceSource underlyingAssetPriceSource);
		@Override
		ReportableInformation.ReportableInformationBuilder addUnderlyingAssetPriceSource(ReportablePriceSource underlyingAssetPriceSource, int idx);
		@Override
		ReportableInformation.ReportableInformationBuilder addUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSource);
		@Override
		ReportableInformation.ReportableInformationBuilder setUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSource);
		@Override
		ReportableInformation.ReportableInformationBuilder setSubsequentPositionUTI(PositionIdentifier subsequentPositionUTI);
		@Override
		ReportableInformation.ReportableInformationBuilder setCounterpartyPositionPriorUTI(PositionIdentifier counterpartyPositionPriorUTI);
		ReportableInformation.ReportableInformationBuilder addJurisdictionInformation(ReportableJurisdictionInformation jurisdictionInformation);
		ReportableInformation.ReportableInformationBuilder addJurisdictionInformation(ReportableJurisdictionInformation jurisdictionInformation, int idx);
		ReportableInformation.ReportableInformationBuilder addJurisdictionInformation(List<? extends ReportableJurisdictionInformation> jurisdictionInformation);
		ReportableInformation.ReportableInformationBuilder setJurisdictionInformation(List<? extends ReportableJurisdictionInformation> jurisdictionInformation);

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
			processRosetta(path.newSubPath("jurisdictionInformation"), processor, ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder.class, getJurisdictionInformation());
		}
		

		ReportableInformation.ReportableInformationBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableInformation  ***********************/
	class ReportableInformationImpl extends ReportableInformationBase.ReportableInformationBaseImpl implements ReportableInformation {
		private final List<? extends ReportableJurisdictionInformation> jurisdictionInformation;
		
		protected ReportableInformationImpl(ReportableInformation.ReportableInformationBuilder builder) {
			super(builder);
			this.jurisdictionInformation = ofNullable(builder.getJurisdictionInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("jurisdictionInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("jurisdictionInformation")
		public List<? extends ReportableJurisdictionInformation> getJurisdictionInformation() {
			return jurisdictionInformation;
		}
		
		@Override
		public ReportableInformation build() {
			return this;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder toBuilder() {
			ReportableInformation.ReportableInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableInformation.ReportableInformationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getJurisdictionInformation()).ifPresent(builder::setJurisdictionInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReportableInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(jurisdictionInformation, _that.getJurisdictionInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (jurisdictionInformation != null ? jurisdictionInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableInformation {" +
				"jurisdictionInformation=" + this.jurisdictionInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReportableInformation  ***********************/
	class ReportableInformationBuilderImpl extends ReportableInformationBase.ReportableInformationBaseBuilderImpl implements ReportableInformation.ReportableInformationBuilder {
	
		protected List<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> jurisdictionInformation = new ArrayList<>();
		
		@Override
		@RosettaAttribute("jurisdictionInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("jurisdictionInformation")
		public List<? extends ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder> getJurisdictionInformation() {
			return jurisdictionInformation;
		}
		
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder getOrCreateJurisdictionInformation(int index) {
			if (jurisdictionInformation==null) {
				this.jurisdictionInformation = new ArrayList<>();
			}
			return getIndex(jurisdictionInformation, index, () -> {
						ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder newJurisdictionInformation = ReportableJurisdictionInformation.builder();
						return newJurisdictionInformation;
					});
		}
		
		@RosettaAttribute("globalPartyInformation")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("globalPartyInformation")
		@Override
		public ReportableInformation.ReportableInformationBuilder addGlobalPartyInformation(PartyInformation _globalPartyInformation) {
			if (_globalPartyInformation != null) {
				this.globalPartyInformation.add(_globalPartyInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder addGlobalPartyInformation(PartyInformation _globalPartyInformation, int idx) {
			getIndex(this.globalPartyInformation, idx, () -> _globalPartyInformation.toBuilder());
			return this;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder addGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformations) {
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
		public ReportableInformation.ReportableInformationBuilder setGlobalPartyInformation(List<? extends PartyInformation> globalPartyInformations) {
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
		public ReportableInformation.ReportableInformationBuilder setReportableAction(ReportableActionEnum _reportableAction) {
			this.reportableAction = _reportableAction == null ? null : _reportableAction;
			return this;
		}
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public ReportableInformation.ReportableInformationBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("confirmationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmationMethod")
		@Override
		public ReportableInformation.ReportableInformationBuilder setConfirmationMethod(ConfirmationMethodEnum _confirmationMethod) {
			this.confirmationMethod = _confirmationMethod == null ? null : _confirmationMethod;
			return this;
		}
		
		@RosettaAttribute("originalExecutionTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalExecutionTimestamp")
		@Override
		public ReportableInformation.ReportableInformationBuilder setOriginalExecutionTimestamp(ZonedDateTime _originalExecutionTimestamp) {
			this.originalExecutionTimestamp = _originalExecutionTimestamp == null ? null : _originalExecutionTimestamp;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public ReportableInformation.ReportableInformationBuilder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("cryptoBased")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cryptoBased")
		@Override
		public ReportableInformation.ReportableInformationBuilder setCryptoBased(Boolean _cryptoBased) {
			this.cryptoBased = _cryptoBased == null ? null : _cryptoBased;
			return this;
		}
		
		@RosettaAttribute("customBasket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasket")
		@Override
		public ReportableInformation.ReportableInformationBuilder setCustomBasket(CustomBasket _customBasket) {
			this.customBasket = _customBasket == null ? null : _customBasket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intragroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intragroup")
		@Override
		public ReportableInformation.ReportableInformationBuilder setIntragroup(Boolean _intragroup) {
			this.intragroup = _intragroup == null ? null : _intragroup;
			return this;
		}
		
		@RosettaAttribute("affiliated")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("affiliated")
		@Override
		public ReportableInformation.ReportableInformationBuilder setAffiliated(Boolean _affiliated) {
			this.affiliated = _affiliated == null ? null : _affiliated;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetLastAvailableSpotPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetLastAvailableSpotPrice")
		@Override
		public ReportableInformation.ReportableInformationBuilder setUnderlyingAssetLastAvailableSpotPrice(PriceSchedule _underlyingAssetLastAvailableSpotPrice) {
			this.underlyingAssetLastAvailableSpotPrice = _underlyingAssetLastAvailableSpotPrice == null ? null : _underlyingAssetLastAvailableSpotPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public ReportableInformation.ReportableInformationBuilder addUnderlyingAssetPriceSource(ReportablePriceSource _underlyingAssetPriceSource) {
			if (_underlyingAssetPriceSource != null) {
				this.underlyingAssetPriceSource.add(_underlyingAssetPriceSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder addUnderlyingAssetPriceSource(ReportablePriceSource _underlyingAssetPriceSource, int idx) {
			getIndex(this.underlyingAssetPriceSource, idx, () -> _underlyingAssetPriceSource.toBuilder());
			return this;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder addUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSources) {
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
		public ReportableInformation.ReportableInformationBuilder setUnderlyingAssetPriceSource(List<? extends ReportablePriceSource> underlyingAssetPriceSources) {
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
		public ReportableInformation.ReportableInformationBuilder setSubsequentPositionUTI(PositionIdentifier _subsequentPositionUTI) {
			this.subsequentPositionUTI = _subsequentPositionUTI == null ? null : _subsequentPositionUTI.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterpartyPositionPriorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterpartyPositionPriorUTI")
		@Override
		public ReportableInformation.ReportableInformationBuilder setCounterpartyPositionPriorUTI(PositionIdentifier _counterpartyPositionPriorUTI) {
			this.counterpartyPositionPriorUTI = _counterpartyPositionPriorUTI == null ? null : _counterpartyPositionPriorUTI.toBuilder();
			return this;
		}
		
		@RosettaAttribute("jurisdictionInformation")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("jurisdictionInformation")
		@Override
		public ReportableInformation.ReportableInformationBuilder addJurisdictionInformation(ReportableJurisdictionInformation _jurisdictionInformation) {
			if (_jurisdictionInformation != null) {
				this.jurisdictionInformation.add(_jurisdictionInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder addJurisdictionInformation(ReportableJurisdictionInformation _jurisdictionInformation, int idx) {
			getIndex(this.jurisdictionInformation, idx, () -> _jurisdictionInformation.toBuilder());
			return this;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder addJurisdictionInformation(List<? extends ReportableJurisdictionInformation> jurisdictionInformations) {
			if (jurisdictionInformations != null) {
				for (final ReportableJurisdictionInformation toAdd : jurisdictionInformations) {
					this.jurisdictionInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("jurisdictionInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("jurisdictionInformation")
		@Override
		public ReportableInformation.ReportableInformationBuilder setJurisdictionInformation(List<? extends ReportableJurisdictionInformation> jurisdictionInformations) {
			if (jurisdictionInformations == null) {
				this.jurisdictionInformation = new ArrayList<>();
			} else {
				this.jurisdictionInformation = jurisdictionInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReportableInformation build() {
			return new ReportableInformation.ReportableInformationImpl(this);
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableInformation.ReportableInformationBuilder prune() {
			super.prune();
			jurisdictionInformation = jurisdictionInformation.stream().filter(b->b!=null).<ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getJurisdictionInformation()!=null && getJurisdictionInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableInformation.ReportableInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReportableInformation.ReportableInformationBuilder o = (ReportableInformation.ReportableInformationBuilder) other;
			
			merger.mergeRosetta(getJurisdictionInformation(), o.getJurisdictionInformation(), this::getOrCreateJurisdictionInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReportableInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(jurisdictionInformation, _that.getJurisdictionInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (jurisdictionInformation != null ? jurisdictionInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableInformationBuilder {" +
				"jurisdictionInformation=" + this.jurisdictionInformation +
			'}' + " " + super.toString();
		}
	}
}
