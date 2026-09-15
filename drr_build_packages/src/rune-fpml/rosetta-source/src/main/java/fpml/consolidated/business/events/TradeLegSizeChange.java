package fpml.consolidated.business.events;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.business.events.meta.TradeLegSizeChangeMeta;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.NumberOfOptionsReference;
import fpml.consolidated.shared.NumberOfUnitsReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing a change to the size of a single leg or stream of a trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing a change to the size of a single leg or stream of a trade.
 *
 */
@RosettaDataType(value="TradeLegSizeChange", builder=TradeLegSizeChange.TradeLegSizeChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeLegSizeChange", model="fpml", builder=TradeLegSizeChange.TradeLegSizeChangeBuilderImpl.class, version="2.1.1")
public interface TradeLegSizeChange extends RosettaModelObject {

	TradeLegSizeChangeMeta metaData = new TradeLegSizeChangeMeta();

	/*********************** Getter Methods  ***********************/
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
	NotionalReference getNotionalReference();
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
	NonNegativeMoney getChangeInNotionalAmount();
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
	NonNegativeMoney getOutstandingNotionalAmount();
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
	NumberOfOptionsReference getNumberOfOptionsReference();
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
	BigDecimal getChangeInNumberOfOptions();
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
	BigDecimal getOutstandingNumberOfOptions();
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
	NumberOfUnitsReference getNumberOfUnitsReference();
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
	BigDecimal getChangeInNumberOfUnits();
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
	BigDecimal getOutstandingNumberOfUnits();
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
	NotionalReference getNotionalScheduleReference();
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
	NonNegativeAmountSchedule getChangeInNotionalSchedule();
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
	NonNegativeAmountSchedule getOutstandingNotionalSchedule();
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
	AmountReference getKnownAmountReference();
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
	NonNegativeMoney getChangeInKnownAmount();
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
	NonNegativeMoney getOutstandingKnownAmount();

	/*********************** Build Methods  ***********************/
	TradeLegSizeChange build();
	
	TradeLegSizeChange.TradeLegSizeChangeBuilder toBuilder();
	
	static TradeLegSizeChange.TradeLegSizeChangeBuilder builder() {
		return new TradeLegSizeChange.TradeLegSizeChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegSizeChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeLegSizeChange> getType() {
		return TradeLegSizeChange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.class, getChangeInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.class, getOutstandingNotionalAmount());
		processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.class, getNumberOfOptionsReference());
		processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.class, getNumberOfUnitsReference());
		processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.class, getNotionalScheduleReference());
		processRosetta(path.newSubPath("changeInNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getChangeInNotionalSchedule());
		processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getOutstandingNotionalSchedule());
		processRosetta(path.newSubPath("knownAmountReference"), processor, AmountReference.class, getKnownAmountReference());
		processRosetta(path.newSubPath("changeInKnownAmount"), processor, NonNegativeMoney.class, getChangeInKnownAmount());
		processRosetta(path.newSubPath("outstandingKnownAmount"), processor, NonNegativeMoney.class, getOutstandingKnownAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegSizeChangeBuilder extends TradeLegSizeChange, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference();
		@Override
		NotionalReference.NotionalReferenceBuilder getNotionalReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getChangeInNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingNotionalAmount();
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getOrCreateNumberOfOptionsReference();
		@Override
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getNumberOfOptionsReference();
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getOrCreateNumberOfUnitsReference();
		@Override
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getNumberOfUnitsReference();
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalScheduleReference();
		@Override
		NotionalReference.NotionalReferenceBuilder getNotionalScheduleReference();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateChangeInNotionalSchedule();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getChangeInNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateOutstandingNotionalSchedule();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOutstandingNotionalSchedule();
		AmountReference.AmountReferenceBuilder getOrCreateKnownAmountReference();
		@Override
		AmountReference.AmountReferenceBuilder getKnownAmountReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInKnownAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getChangeInKnownAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingKnownAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingKnownAmount();
		TradeLegSizeChange.TradeLegSizeChangeBuilder setNotionalReference(NotionalReference notionalReference);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setNumberOfOptionsReference(NumberOfOptionsReference numberOfOptionsReference);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNumberOfOptions(BigDecimal changeInNumberOfOptions);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setNumberOfUnitsReference(NumberOfUnitsReference numberOfUnitsReference);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNumberOfUnits(BigDecimal changeInNumberOfUnits);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setNotionalScheduleReference(NotionalReference notionalScheduleReference);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNotionalSchedule(NonNegativeAmountSchedule changeInNotionalSchedule);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNotionalSchedule(NonNegativeAmountSchedule outstandingNotionalSchedule);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setKnownAmountReference(AmountReference knownAmountReference);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInKnownAmount(NonNegativeMoney changeInKnownAmount);
		TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingKnownAmount(NonNegativeMoney outstandingKnownAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getChangeInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getOutstandingNotionalAmount());
			processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.NumberOfOptionsReferenceBuilder.class, getNumberOfOptionsReference());
			processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
			processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.NumberOfUnitsReferenceBuilder.class, getNumberOfUnitsReference());
			processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
			processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalScheduleReference());
			processRosetta(path.newSubPath("changeInNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getChangeInNotionalSchedule());
			processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getOutstandingNotionalSchedule());
			processRosetta(path.newSubPath("knownAmountReference"), processor, AmountReference.AmountReferenceBuilder.class, getKnownAmountReference());
			processRosetta(path.newSubPath("changeInKnownAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getChangeInKnownAmount());
			processRosetta(path.newSubPath("outstandingKnownAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getOutstandingKnownAmount());
		}
		

		TradeLegSizeChange.TradeLegSizeChangeBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegSizeChange  ***********************/
	class TradeLegSizeChangeImpl implements TradeLegSizeChange {
		private final NotionalReference notionalReference;
		private final NonNegativeMoney changeInNotionalAmount;
		private final NonNegativeMoney outstandingNotionalAmount;
		private final NumberOfOptionsReference numberOfOptionsReference;
		private final BigDecimal changeInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		private final NumberOfUnitsReference numberOfUnitsReference;
		private final BigDecimal changeInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		private final NotionalReference notionalScheduleReference;
		private final NonNegativeAmountSchedule changeInNotionalSchedule;
		private final NonNegativeAmountSchedule outstandingNotionalSchedule;
		private final AmountReference knownAmountReference;
		private final NonNegativeMoney changeInKnownAmount;
		private final NonNegativeMoney outstandingKnownAmount;
		
		protected TradeLegSizeChangeImpl(TradeLegSizeChange.TradeLegSizeChangeBuilder builder) {
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.changeInNotionalAmount = ofNullable(builder.getChangeInNotionalAmount()).map(f->f.build()).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).map(f->f.build()).orElse(null);
			this.numberOfOptionsReference = ofNullable(builder.getNumberOfOptionsReference()).map(f->f.build()).orElse(null);
			this.changeInNumberOfOptions = builder.getChangeInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
			this.numberOfUnitsReference = ofNullable(builder.getNumberOfUnitsReference()).map(f->f.build()).orElse(null);
			this.changeInNumberOfUnits = builder.getChangeInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
			this.notionalScheduleReference = ofNullable(builder.getNotionalScheduleReference()).map(f->f.build()).orElse(null);
			this.changeInNotionalSchedule = ofNullable(builder.getChangeInNotionalSchedule()).map(f->f.build()).orElse(null);
			this.outstandingNotionalSchedule = ofNullable(builder.getOutstandingNotionalSchedule()).map(f->f.build()).orElse(null);
			this.knownAmountReference = ofNullable(builder.getKnownAmountReference()).map(f->f.build()).orElse(null);
			this.changeInKnownAmount = ofNullable(builder.getChangeInKnownAmount()).map(f->f.build()).orElse(null);
			this.outstandingKnownAmount = ofNullable(builder.getOutstandingKnownAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalAmount")
		public NonNegativeMoney getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public NonNegativeMoney getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptionsReference")
		public NumberOfOptionsReference getNumberOfOptionsReference() {
			return numberOfOptionsReference;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfUnitsReference")
		public NumberOfUnitsReference getNumberOfUnitsReference() {
			return numberOfUnitsReference;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("notionalScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalScheduleReference")
		public NotionalReference getNotionalScheduleReference() {
			return notionalScheduleReference;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalSchedule")
		public NonNegativeAmountSchedule getChangeInNotionalSchedule() {
			return changeInNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalSchedule")
		public NonNegativeAmountSchedule getOutstandingNotionalSchedule() {
			return outstandingNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("knownAmountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knownAmountReference")
		public AmountReference getKnownAmountReference() {
			return knownAmountReference;
		}
		
		@Override
		@RosettaAttribute("changeInKnownAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInKnownAmount")
		public NonNegativeMoney getChangeInKnownAmount() {
			return changeInKnownAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingKnownAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingKnownAmount")
		public NonNegativeMoney getOutstandingKnownAmount() {
			return outstandingKnownAmount;
		}
		
		@Override
		public TradeLegSizeChange build() {
			return this;
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder toBuilder() {
			TradeLegSizeChange.TradeLegSizeChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegSizeChange.TradeLegSizeChangeBuilder builder) {
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getChangeInNotionalAmount()).ifPresent(builder::setChangeInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
			ofNullable(getNumberOfOptionsReference()).ifPresent(builder::setNumberOfOptionsReference);
			ofNullable(getChangeInNumberOfOptions()).ifPresent(builder::setChangeInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
			ofNullable(getNumberOfUnitsReference()).ifPresent(builder::setNumberOfUnitsReference);
			ofNullable(getChangeInNumberOfUnits()).ifPresent(builder::setChangeInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
			ofNullable(getNotionalScheduleReference()).ifPresent(builder::setNotionalScheduleReference);
			ofNullable(getChangeInNotionalSchedule()).ifPresent(builder::setChangeInNotionalSchedule);
			ofNullable(getOutstandingNotionalSchedule()).ifPresent(builder::setOutstandingNotionalSchedule);
			ofNullable(getKnownAmountReference()).ifPresent(builder::setKnownAmountReference);
			ofNullable(getChangeInKnownAmount()).ifPresent(builder::setChangeInKnownAmount);
			ofNullable(getOutstandingKnownAmount()).ifPresent(builder::setOutstandingKnownAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegSizeChange _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(changeInNotionalSchedule, _that.getChangeInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			if (!Objects.equals(knownAmountReference, _that.getKnownAmountReference())) return false;
			if (!Objects.equals(changeInKnownAmount, _that.getChangeInKnownAmount())) return false;
			if (!Objects.equals(outstandingKnownAmount, _that.getOutstandingKnownAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalSchedule != null ? changeInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (knownAmountReference != null ? knownAmountReference.hashCode() : 0);
			_result = 31 * _result + (changeInKnownAmount != null ? changeInKnownAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingKnownAmount != null ? outstandingKnownAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegSizeChange {" +
				"notionalReference=" + this.notionalReference + ", " +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"changeInNotionalSchedule=" + this.changeInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule + ", " +
				"knownAmountReference=" + this.knownAmountReference + ", " +
				"changeInKnownAmount=" + this.changeInKnownAmount + ", " +
				"outstandingKnownAmount=" + this.outstandingKnownAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegSizeChange  ***********************/
	class TradeLegSizeChangeBuilderImpl implements TradeLegSizeChange.TradeLegSizeChangeBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder notionalReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder changeInNotionalAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder outstandingNotionalAmount;
		protected NumberOfOptionsReference.NumberOfOptionsReferenceBuilder numberOfOptionsReference;
		protected BigDecimal changeInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
		protected NumberOfUnitsReference.NumberOfUnitsReferenceBuilder numberOfUnitsReference;
		protected BigDecimal changeInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
		protected NotionalReference.NotionalReferenceBuilder notionalScheduleReference;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder changeInNotionalSchedule;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder outstandingNotionalSchedule;
		protected AmountReference.AmountReferenceBuilder knownAmountReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder changeInKnownAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder outstandingKnownAmount;
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (changeInNotionalAmount!=null) {
				result = changeInNotionalAmount;
			}
			else {
				result = changeInNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (outstandingNotionalAmount!=null) {
				result = outstandingNotionalAmount;
			}
			else {
				result = outstandingNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptionsReference")
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getNumberOfOptionsReference() {
			return numberOfOptionsReference;
		}
		
		@Override
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getOrCreateNumberOfOptionsReference() {
			NumberOfOptionsReference.NumberOfOptionsReferenceBuilder result;
			if (numberOfOptionsReference!=null) {
				result = numberOfOptionsReference;
			}
			else {
				result = numberOfOptionsReference = NumberOfOptionsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfUnitsReference")
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getNumberOfUnitsReference() {
			return numberOfUnitsReference;
		}
		
		@Override
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getOrCreateNumberOfUnitsReference() {
			NumberOfUnitsReference.NumberOfUnitsReferenceBuilder result;
			if (numberOfUnitsReference!=null) {
				result = numberOfUnitsReference;
			}
			else {
				result = numberOfUnitsReference = NumberOfUnitsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("notionalScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalScheduleReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalScheduleReference() {
			return notionalScheduleReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalScheduleReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalScheduleReference!=null) {
				result = notionalScheduleReference;
			}
			else {
				result = notionalScheduleReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getChangeInNotionalSchedule() {
			return changeInNotionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateChangeInNotionalSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (changeInNotionalSchedule!=null) {
				result = changeInNotionalSchedule;
			}
			else {
				result = changeInNotionalSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOutstandingNotionalSchedule() {
			return outstandingNotionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateOutstandingNotionalSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (outstandingNotionalSchedule!=null) {
				result = outstandingNotionalSchedule;
			}
			else {
				result = outstandingNotionalSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knownAmountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knownAmountReference")
		public AmountReference.AmountReferenceBuilder getKnownAmountReference() {
			return knownAmountReference;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateKnownAmountReference() {
			AmountReference.AmountReferenceBuilder result;
			if (knownAmountReference!=null) {
				result = knownAmountReference;
			}
			else {
				result = knownAmountReference = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInKnownAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInKnownAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getChangeInKnownAmount() {
			return changeInKnownAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInKnownAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (changeInKnownAmount!=null) {
				result = changeInKnownAmount;
			}
			else {
				result = changeInKnownAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingKnownAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingKnownAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingKnownAmount() {
			return outstandingKnownAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingKnownAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (outstandingKnownAmount!=null) {
				result = outstandingKnownAmount;
			}
			else {
				result = outstandingKnownAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setNotionalReference(NotionalReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("changeInNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNotionalAmount")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNotionalAmount(NonNegativeMoney _changeInNotionalAmount) {
			this.changeInNotionalAmount = _changeInNotionalAmount == null ? null : _changeInNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNotionalAmount")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNotionalAmount(NonNegativeMoney _outstandingNotionalAmount) {
			this.outstandingNotionalAmount = _outstandingNotionalAmount == null ? null : _outstandingNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfOptionsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptionsReference")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setNumberOfOptionsReference(NumberOfOptionsReference _numberOfOptionsReference) {
			this.numberOfOptionsReference = _numberOfOptionsReference == null ? null : _numberOfOptionsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNumberOfOptions")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNumberOfOptions(BigDecimal _changeInNumberOfOptions) {
			this.changeInNumberOfOptions = _changeInNumberOfOptions == null ? null : _changeInNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNumberOfOptions(BigDecimal _outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = _outstandingNumberOfOptions == null ? null : _outstandingNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("numberOfUnitsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfUnitsReference")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setNumberOfUnitsReference(NumberOfUnitsReference _numberOfUnitsReference) {
			this.numberOfUnitsReference = _numberOfUnitsReference == null ? null : _numberOfUnitsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("changeInNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNumberOfUnits")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNumberOfUnits(BigDecimal _changeInNumberOfUnits) {
			this.changeInNumberOfUnits = _changeInNumberOfUnits == null ? null : _changeInNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNumberOfUnits(BigDecimal _outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = _outstandingNumberOfUnits == null ? null : _outstandingNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("notionalScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalScheduleReference")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setNotionalScheduleReference(NotionalReference _notionalScheduleReference) {
			this.notionalScheduleReference = _notionalScheduleReference == null ? null : _notionalScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("changeInNotionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNotionalSchedule")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInNotionalSchedule(NonNegativeAmountSchedule _changeInNotionalSchedule) {
			this.changeInNotionalSchedule = _changeInNotionalSchedule == null ? null : _changeInNotionalSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNotionalSchedule")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingNotionalSchedule(NonNegativeAmountSchedule _outstandingNotionalSchedule) {
			this.outstandingNotionalSchedule = _outstandingNotionalSchedule == null ? null : _outstandingNotionalSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("knownAmountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knownAmountReference")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setKnownAmountReference(AmountReference _knownAmountReference) {
			this.knownAmountReference = _knownAmountReference == null ? null : _knownAmountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("changeInKnownAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInKnownAmount")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setChangeInKnownAmount(NonNegativeMoney _changeInKnownAmount) {
			this.changeInKnownAmount = _changeInKnownAmount == null ? null : _changeInKnownAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingKnownAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingKnownAmount")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder setOutstandingKnownAmount(NonNegativeMoney _outstandingKnownAmount) {
			this.outstandingKnownAmount = _outstandingKnownAmount == null ? null : _outstandingKnownAmount.toBuilder();
			return this;
		}
		
		@Override
		public TradeLegSizeChange build() {
			return new TradeLegSizeChange.TradeLegSizeChangeImpl(this);
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder prune() {
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (changeInNotionalAmount!=null && !changeInNotionalAmount.prune().hasData()) changeInNotionalAmount = null;
			if (outstandingNotionalAmount!=null && !outstandingNotionalAmount.prune().hasData()) outstandingNotionalAmount = null;
			if (numberOfOptionsReference!=null && !numberOfOptionsReference.prune().hasData()) numberOfOptionsReference = null;
			if (numberOfUnitsReference!=null && !numberOfUnitsReference.prune().hasData()) numberOfUnitsReference = null;
			if (notionalScheduleReference!=null && !notionalScheduleReference.prune().hasData()) notionalScheduleReference = null;
			if (changeInNotionalSchedule!=null && !changeInNotionalSchedule.prune().hasData()) changeInNotionalSchedule = null;
			if (outstandingNotionalSchedule!=null && !outstandingNotionalSchedule.prune().hasData()) outstandingNotionalSchedule = null;
			if (knownAmountReference!=null && !knownAmountReference.prune().hasData()) knownAmountReference = null;
			if (changeInKnownAmount!=null && !changeInKnownAmount.prune().hasData()) changeInKnownAmount = null;
			if (outstandingKnownAmount!=null && !outstandingKnownAmount.prune().hasData()) outstandingKnownAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getChangeInNotionalAmount()!=null && getChangeInNotionalAmount().hasData()) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().hasData()) return true;
			if (getNumberOfOptionsReference()!=null && getNumberOfOptionsReference().hasData()) return true;
			if (getChangeInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			if (getNumberOfUnitsReference()!=null && getNumberOfUnitsReference().hasData()) return true;
			if (getChangeInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			if (getNotionalScheduleReference()!=null && getNotionalScheduleReference().hasData()) return true;
			if (getChangeInNotionalSchedule()!=null && getChangeInNotionalSchedule().hasData()) return true;
			if (getOutstandingNotionalSchedule()!=null && getOutstandingNotionalSchedule().hasData()) return true;
			if (getKnownAmountReference()!=null && getKnownAmountReference().hasData()) return true;
			if (getChangeInKnownAmount()!=null && getChangeInKnownAmount().hasData()) return true;
			if (getOutstandingKnownAmount()!=null && getOutstandingKnownAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegSizeChange.TradeLegSizeChangeBuilder o = (TradeLegSizeChange.TradeLegSizeChangeBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getChangeInNotionalAmount(), o.getChangeInNotionalAmount(), this::setChangeInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::setOutstandingNotionalAmount);
			merger.mergeRosetta(getNumberOfOptionsReference(), o.getNumberOfOptionsReference(), this::setNumberOfOptionsReference);
			merger.mergeRosetta(getNumberOfUnitsReference(), o.getNumberOfUnitsReference(), this::setNumberOfUnitsReference);
			merger.mergeRosetta(getNotionalScheduleReference(), o.getNotionalScheduleReference(), this::setNotionalScheduleReference);
			merger.mergeRosetta(getChangeInNotionalSchedule(), o.getChangeInNotionalSchedule(), this::setChangeInNotionalSchedule);
			merger.mergeRosetta(getOutstandingNotionalSchedule(), o.getOutstandingNotionalSchedule(), this::setOutstandingNotionalSchedule);
			merger.mergeRosetta(getKnownAmountReference(), o.getKnownAmountReference(), this::setKnownAmountReference);
			merger.mergeRosetta(getChangeInKnownAmount(), o.getChangeInKnownAmount(), this::setChangeInKnownAmount);
			merger.mergeRosetta(getOutstandingKnownAmount(), o.getOutstandingKnownAmount(), this::setOutstandingKnownAmount);
			
			merger.mergeBasic(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::setChangeInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			merger.mergeBasic(getChangeInNumberOfUnits(), o.getChangeInNumberOfUnits(), this::setChangeInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegSizeChange _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(changeInNotionalSchedule, _that.getChangeInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			if (!Objects.equals(knownAmountReference, _that.getKnownAmountReference())) return false;
			if (!Objects.equals(changeInKnownAmount, _that.getChangeInKnownAmount())) return false;
			if (!Objects.equals(outstandingKnownAmount, _that.getOutstandingKnownAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalSchedule != null ? changeInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (knownAmountReference != null ? knownAmountReference.hashCode() : 0);
			_result = 31 * _result + (changeInKnownAmount != null ? changeInKnownAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingKnownAmount != null ? outstandingKnownAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegSizeChangeBuilder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"changeInNotionalSchedule=" + this.changeInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule + ", " +
				"knownAmountReference=" + this.knownAmountReference + ", " +
				"changeInKnownAmount=" + this.changeInKnownAmount + ", " +
				"outstandingKnownAmount=" + this.outstandingKnownAmount +
			'}';
		}
	}
}
