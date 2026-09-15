package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.FxAccrualKnockoutBarrierRetentionEnum;
import fpml.consolidated.fpmlenum.FxBarrierScopeEnum;
import fpml.consolidated.fpmlenum.FxBarrierStyleEnum;
import fpml.consolidated.fpmlenum.FxBarrierTypeSimpleEnum;
import fpml.consolidated.fx.accruals.meta.FxAccrualBarrierMeta;
import fpml.consolidated.fx.targets.FxComplexBarrierBase;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.Schedule;
import java.time.ZonedDateTime;
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
@RosettaDataType(value="FxAccrualBarrier", builder=FxAccrualBarrier.FxAccrualBarrierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualBarrier", model="fpml", builder=FxAccrualBarrier.FxAccrualBarrierBuilderImpl.class, version="2.1.1")
public interface FxAccrualBarrier extends FxComplexBarrierBase {

	FxAccrualBarrierMeta metaData = new FxAccrualBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the behavior with respect to settlement rights for the accrual period in which a global knockout event occurs (the "knockout period"). "Keep" means that the parties retain settlement rights at the end of the knckout period, fixed at the prevailing accrued notional, and settlement rights for all future accrual periods are extinguished. "Lose" means that settlement rights for the knockout period and all future accrual periods are extinguished, and the product is effectively extinguished. This element should be produced in case of a global knockout barrier (barrierType= "Knockout", scope="Global"), and omitted otherwise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the behavior with respect to settlement rights for the accrual period in which a global knockout event occurs (the "knockout period"). "Keep" means that the parties retain settlement rights at the end of the knckout period, fixed at the prevailing accrued notional, and settlement rights for all future accrual periods are extinguished. "Lose" means that settlement rights for the knockout period and all future accrual periods are extinguished, and the product is effectively extinguished. This element should be produced in case of a global knockout barrier (barrierType= "Knockout", scope="Global"), and omitted otherwise.
	 *
	 */
	FxAccrualKnockoutBarrierRetentionEnum getAccrualRetention();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an 'FxRateObservable' structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an 'FxRateObservable' structure.
	 *
	 */
	FxRateObservableReference getObservableReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 */
	List<? extends InformationSource> getInformationSource();

	/*********************** Build Methods  ***********************/
	FxAccrualBarrier build();
	
	FxAccrualBarrier.FxAccrualBarrierBuilder toBuilder();
	
	static FxAccrualBarrier.FxAccrualBarrierBuilder builder() {
		return new FxAccrualBarrier.FxAccrualBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualBarrier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualBarrier> getType() {
		return FxAccrualBarrier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
		processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
		processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("triggerRate"), processor, Schedule.class, getTriggerRate());
		processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
		processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.class, getObservationStartTime());
		processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.class, getObservationEndTime());
		processor.processBasic(path.newSubPath("accrualRetention"), FxAccrualKnockoutBarrierRetentionEnum.class, getAccrualRetention(), this);
		processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.class, getObservableReference());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualBarrierBuilder extends FxAccrualBarrier, FxComplexBarrierBase.FxComplexBarrierBaseBuilder {
		FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference();
		@Override
		FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index);
		@Override
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setId(String id);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum barrierType);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setStyle(FxBarrierStyleEnum style);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setScope(FxBarrierScopeEnum scope);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setCondition(ConditionEnum condition);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setTriggerRate(Schedule triggerRate);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setObservationStartDate(ZonedDateTime observationStartDate);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setObservationStartTime(BusinessCenterTime observationStartTime);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setObservationEndDate(ZonedDateTime observationEndDate);
		@Override
		FxAccrualBarrier.FxAccrualBarrierBuilder setObservationEndTime(BusinessCenterTime observationEndTime);
		FxAccrualBarrier.FxAccrualBarrierBuilder setAccrualRetention(FxAccrualKnockoutBarrierRetentionEnum accrualRetention);
		FxAccrualBarrier.FxAccrualBarrierBuilder setObservableReference(FxRateObservableReference observableReference);
		FxAccrualBarrier.FxAccrualBarrierBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxAccrualBarrier.FxAccrualBarrierBuilder addInformationSource(InformationSource informationSource);
		FxAccrualBarrier.FxAccrualBarrierBuilder addInformationSource(InformationSource informationSource, int idx);
		FxAccrualBarrier.FxAccrualBarrierBuilder addInformationSource(List<? extends InformationSource> informationSource);
		FxAccrualBarrier.FxAccrualBarrierBuilder setInformationSource(List<? extends InformationSource> informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("barrierType"), FxBarrierTypeSimpleEnum.class, getBarrierType(), this);
			processor.processBasic(path.newSubPath("style"), FxBarrierStyleEnum.class, getStyle(), this);
			processor.processBasic(path.newSubPath("scope"), FxBarrierScopeEnum.class, getScope(), this);
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("triggerRate"), processor, Schedule.ScheduleBuilder.class, getTriggerRate());
			processor.processBasic(path.newSubPath("observationStartDate"), ZonedDateTime.class, getObservationStartDate(), this);
			processRosetta(path.newSubPath("observationStartTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationStartTime());
			processor.processBasic(path.newSubPath("observationEndDate"), ZonedDateTime.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("observationEndTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getObservationEndTime());
			processor.processBasic(path.newSubPath("accrualRetention"), FxAccrualKnockoutBarrierRetentionEnum.class, getAccrualRetention(), this);
			processRosetta(path.newSubPath("observableReference"), processor, FxRateObservableReference.FxRateObservableReferenceBuilder.class, getObservableReference());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
		}
		

		FxAccrualBarrier.FxAccrualBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualBarrier  ***********************/
	class FxAccrualBarrierImpl extends FxComplexBarrierBase.FxComplexBarrierBaseImpl implements FxAccrualBarrier {
		private final FxAccrualKnockoutBarrierRetentionEnum accrualRetention;
		private final FxRateObservableReference observableReference;
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final List<? extends InformationSource> informationSource;
		
		protected FxAccrualBarrierImpl(FxAccrualBarrier.FxAccrualBarrierBuilder builder) {
			super(builder);
			this.accrualRetention = builder.getAccrualRetention();
			this.observableReference = ofNullable(builder.getObservableReference()).map(f->f.build()).orElse(null);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accrualRetention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualRetention")
		public FxAccrualKnockoutBarrierRetentionEnum getAccrualRetention() {
			return accrualRetention;
		}
		
		@Override
		@RosettaAttribute("observableReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observableReference")
		public FxRateObservableReference getObservableReference() {
			return observableReference;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxAccrualBarrier build() {
			return this;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder toBuilder() {
			FxAccrualBarrier.FxAccrualBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualBarrier.FxAccrualBarrierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccrualRetention()).ifPresent(builder::setAccrualRetention);
			ofNullable(getObservableReference()).ifPresent(builder::setObservableReference);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualBarrier _that = getType().cast(o);
		
			if (!Objects.equals(accrualRetention, _that.getAccrualRetention())) return false;
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualRetention != null ? accrualRetention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualBarrier {" +
				"accrualRetention=" + this.accrualRetention + ", " +
				"observableReference=" + this.observableReference + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualBarrier  ***********************/
	class FxAccrualBarrierBuilderImpl extends FxComplexBarrierBase.FxComplexBarrierBaseBuilderImpl implements FxAccrualBarrier.FxAccrualBarrierBuilder {
	
		protected FxAccrualKnockoutBarrierRetentionEnum accrualRetention;
		protected FxRateObservableReference.FxRateObservableReferenceBuilder observableReference;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		
		@Override
		@RosettaAttribute("accrualRetention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualRetention")
		public FxAccrualKnockoutBarrierRetentionEnum getAccrualRetention() {
			return accrualRetention;
		}
		
		@Override
		@RosettaAttribute("observableReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observableReference")
		public FxRateObservableReference.FxRateObservableReferenceBuilder getObservableReference() {
			return observableReference;
		}
		
		@Override
		public FxRateObservableReference.FxRateObservableReferenceBuilder getOrCreateObservableReference() {
			FxRateObservableReference.FxRateObservableReferenceBuilder result;
			if (observableReference!=null) {
				result = observableReference;
			}
			else {
				result = observableReference = FxRateObservableReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index) {
			if (informationSource==null) {
				this.informationSource = new ArrayList<>();
			}
			return getIndex(informationSource, index, () -> {
						InformationSource.InformationSourceBuilder newInformationSource = InformationSource.builder();
						return newInformationSource;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("barrierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierType")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setBarrierType(FxBarrierTypeSimpleEnum _barrierType) {
			this.barrierType = _barrierType == null ? null : _barrierType;
			return this;
		}
		
		@RosettaAttribute("style")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("style")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setStyle(FxBarrierStyleEnum _style) {
			this.style = _style == null ? null : _style;
			return this;
		}
		
		@RosettaAttribute("scope")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scope")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setScope(FxBarrierScopeEnum _scope) {
			this.scope = _scope == null ? null : _scope;
			return this;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setCondition(ConditionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerRate")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setTriggerRate(Schedule _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setObservationStartDate(ZonedDateTime _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate;
			return this;
		}
		
		@RosettaAttribute("observationStartTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartTime")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setObservationStartTime(BusinessCenterTime _observationStartTime) {
			this.observationStartTime = _observationStartTime == null ? null : _observationStartTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndDate")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setObservationEndDate(ZonedDateTime _observationEndDate) {
			this.observationEndDate = _observationEndDate == null ? null : _observationEndDate;
			return this;
		}
		
		@RosettaAttribute("observationEndTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationEndTime")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setObservationEndTime(BusinessCenterTime _observationEndTime) {
			this.observationEndTime = _observationEndTime == null ? null : _observationEndTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualRetention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accrualRetention")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setAccrualRetention(FxAccrualKnockoutBarrierRetentionEnum _accrualRetention) {
			this.accrualRetention = _accrualRetention == null ? null : _accrualRetention;
			return this;
		}
		
		@RosettaAttribute("observableReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observableReference")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setObservableReference(FxRateObservableReference _observableReference) {
			this.observableReference = _observableReference == null ? null : _observableReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder addInformationSource(InformationSource _informationSource) {
			if (_informationSource != null) {
				this.informationSource.add(_informationSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder addInformationSource(InformationSource _informationSource, int idx) {
			getIndex(this.informationSource, idx, () -> _informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (final InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder setInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources == null) {
				this.informationSource = new ArrayList<>();
			} else {
				this.informationSource = informationSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxAccrualBarrier build() {
			return new FxAccrualBarrier.FxAccrualBarrierImpl(this);
		}
		
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder prune() {
			super.prune();
			if (observableReference!=null && !observableReference.prune().hasData()) observableReference = null;
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccrualRetention()!=null) return true;
			if (getObservableReference()!=null && getObservableReference().hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualBarrier.FxAccrualBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualBarrier.FxAccrualBarrierBuilder o = (FxAccrualBarrier.FxAccrualBarrierBuilder) other;
			
			merger.mergeRosetta(getObservableReference(), o.getObservableReference(), this::setObservableReference);
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			
			merger.mergeBasic(getAccrualRetention(), o.getAccrualRetention(), this::setAccrualRetention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualBarrier _that = getType().cast(o);
		
			if (!Objects.equals(accrualRetention, _that.getAccrualRetention())) return false;
			if (!Objects.equals(observableReference, _that.getObservableReference())) return false;
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualRetention != null ? accrualRetention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (observableReference != null ? observableReference.hashCode() : 0);
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualBarrierBuilder {" +
				"accrualRetention=" + this.accrualRetention + ", " +
				"observableReference=" + this.observableReference + ", " +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource +
			'}' + " " + super.toString();
		}
	}
}
