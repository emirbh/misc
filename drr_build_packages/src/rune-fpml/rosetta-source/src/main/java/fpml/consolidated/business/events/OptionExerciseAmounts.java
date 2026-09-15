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
import fpml.consolidated.business.events.meta.OptionExerciseAmountsMeta;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
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
@RosettaDataType(value="OptionExerciseAmounts", builder=OptionExerciseAmounts.OptionExerciseAmountsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionExerciseAmounts", model="fpml", builder=OptionExerciseAmounts.OptionExerciseAmountsBuilderImpl.class, version="2.1.1")
public interface OptionExerciseAmounts extends RosettaModelObject {

	OptionExerciseAmountsMeta metaData = new OptionExerciseAmountsMeta();

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
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 *
	 */
	Money getExerciseInNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 */
	Money getOutstandingNotionalAmount();
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
	 * Provision Specifies the amount by which the option should be exercised expressed as notional schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the amount by which the option should be exercised expressed as notional schedule.
	 *
	 */
	NonNegativeAmountSchedule getExerciseInNotionalSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Notional schedule after the Change
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Notional schedule after the Change
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
	NumberOfOptionsReference getNumberOfOptionsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 *
	 */
	BigDecimal getExerciseInNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
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
	 * Provision Specifies the fixed amount by which the option should be exercised express as number of units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised express as number of units.
	 *
	 */
	BigDecimal getExerciseInNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 */
	BigDecimal getOutstandingNumberOfUnits();

	/*********************** Build Methods  ***********************/
	OptionExerciseAmounts build();
	
	OptionExerciseAmounts.OptionExerciseAmountsBuilder toBuilder();
	
	static OptionExerciseAmounts.OptionExerciseAmountsBuilder builder() {
		return new OptionExerciseAmounts.OptionExerciseAmountsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseAmounts> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionExerciseAmounts> getType() {
		return OptionExerciseAmounts.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.class, getExerciseInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.class, getOutstandingNotionalAmount());
		processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.class, getNotionalScheduleReference());
		processRosetta(path.newSubPath("exerciseInNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getExerciseInNotionalSchedule());
		processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.class, getOutstandingNotionalSchedule());
		processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.class, getNumberOfOptionsReference());
		processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.class, getNumberOfUnitsReference());
		processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseAmountsBuilder extends OptionExerciseAmounts, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference();
		@Override
		NotionalReference.NotionalReferenceBuilder getNotionalReference();
		Money.MoneyBuilder getOrCreateExerciseInNotionalAmount();
		@Override
		Money.MoneyBuilder getExerciseInNotionalAmount();
		Money.MoneyBuilder getOrCreateOutstandingNotionalAmount();
		@Override
		Money.MoneyBuilder getOutstandingNotionalAmount();
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalScheduleReference();
		@Override
		NotionalReference.NotionalReferenceBuilder getNotionalScheduleReference();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateExerciseInNotionalSchedule();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getExerciseInNotionalSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateOutstandingNotionalSchedule();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOutstandingNotionalSchedule();
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getOrCreateNumberOfOptionsReference();
		@Override
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getNumberOfOptionsReference();
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getOrCreateNumberOfUnitsReference();
		@Override
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getNumberOfUnitsReference();
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setNotionalReference(NotionalReference notionalReference);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNotionalAmount(Money exerciseInNotionalAmount);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNotionalAmount(Money outstandingNotionalAmount);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setNotionalScheduleReference(NotionalReference notionalScheduleReference);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNotionalSchedule(NonNegativeAmountSchedule exerciseInNotionalSchedule);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNotionalSchedule(NonNegativeAmountSchedule outstandingNotionalSchedule);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setNumberOfOptionsReference(NumberOfOptionsReference numberOfOptionsReference);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNumberOfOptions(BigDecimal exerciseInNumberOfOptions);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setNumberOfUnitsReference(NumberOfUnitsReference numberOfUnitsReference);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNumberOfUnits(BigDecimal exerciseInNumberOfUnits);
		OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.MoneyBuilder.class, getExerciseInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.MoneyBuilder.class, getOutstandingNotionalAmount());
			processRosetta(path.newSubPath("notionalScheduleReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalScheduleReference());
			processRosetta(path.newSubPath("exerciseInNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getExerciseInNotionalSchedule());
			processRosetta(path.newSubPath("outstandingNotionalSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getOutstandingNotionalSchedule());
			processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.NumberOfOptionsReferenceBuilder.class, getNumberOfOptionsReference());
			processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
			processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.NumberOfUnitsReferenceBuilder.class, getNumberOfUnitsReference());
			processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		}
		

		OptionExerciseAmounts.OptionExerciseAmountsBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseAmounts  ***********************/
	class OptionExerciseAmountsImpl implements OptionExerciseAmounts {
		private final NotionalReference notionalReference;
		private final Money exerciseInNotionalAmount;
		private final Money outstandingNotionalAmount;
		private final NotionalReference notionalScheduleReference;
		private final NonNegativeAmountSchedule exerciseInNotionalSchedule;
		private final NonNegativeAmountSchedule outstandingNotionalSchedule;
		private final NumberOfOptionsReference numberOfOptionsReference;
		private final BigDecimal exerciseInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		private final NumberOfUnitsReference numberOfUnitsReference;
		private final BigDecimal exerciseInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		
		protected OptionExerciseAmountsImpl(OptionExerciseAmounts.OptionExerciseAmountsBuilder builder) {
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.exerciseInNotionalAmount = ofNullable(builder.getExerciseInNotionalAmount()).map(f->f.build()).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).map(f->f.build()).orElse(null);
			this.notionalScheduleReference = ofNullable(builder.getNotionalScheduleReference()).map(f->f.build()).orElse(null);
			this.exerciseInNotionalSchedule = ofNullable(builder.getExerciseInNotionalSchedule()).map(f->f.build()).orElse(null);
			this.outstandingNotionalSchedule = ofNullable(builder.getOutstandingNotionalSchedule()).map(f->f.build()).orElse(null);
			this.numberOfOptionsReference = ofNullable(builder.getNumberOfOptionsReference()).map(f->f.build()).orElse(null);
			this.exerciseInNumberOfOptions = builder.getExerciseInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
			this.numberOfUnitsReference = ofNullable(builder.getNumberOfUnitsReference()).map(f->f.build()).orElse(null);
			this.exerciseInNumberOfUnits = builder.getExerciseInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		public Money getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public Money getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalScheduleReference")
		public NotionalReference getNotionalScheduleReference() {
			return notionalScheduleReference;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalSchedule")
		public NonNegativeAmountSchedule getExerciseInNotionalSchedule() {
			return exerciseInNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalSchedule")
		public NonNegativeAmountSchedule getOutstandingNotionalSchedule() {
			return outstandingNotionalSchedule;
		}
		
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfOptionsReference")
		public NumberOfOptionsReference getNumberOfOptionsReference() {
			return numberOfOptionsReference;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
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
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		public OptionExerciseAmounts build() {
			return this;
		}
		
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder toBuilder() {
			OptionExerciseAmounts.OptionExerciseAmountsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseAmounts.OptionExerciseAmountsBuilder builder) {
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getExerciseInNotionalAmount()).ifPresent(builder::setExerciseInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
			ofNullable(getNotionalScheduleReference()).ifPresent(builder::setNotionalScheduleReference);
			ofNullable(getExerciseInNotionalSchedule()).ifPresent(builder::setExerciseInNotionalSchedule);
			ofNullable(getOutstandingNotionalSchedule()).ifPresent(builder::setOutstandingNotionalSchedule);
			ofNullable(getNumberOfOptionsReference()).ifPresent(builder::setNumberOfOptionsReference);
			ofNullable(getExerciseInNumberOfOptions()).ifPresent(builder::setExerciseInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
			ofNullable(getNumberOfUnitsReference()).ifPresent(builder::setNumberOfUnitsReference);
			ofNullable(getExerciseInNumberOfUnits()).ifPresent(builder::setExerciseInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmounts _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(exerciseInNotionalSchedule, _that.getExerciseInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalSchedule != null ? exerciseInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmounts {" +
				"notionalReference=" + this.notionalReference + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"exerciseInNotionalSchedule=" + this.exerciseInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule + ", " +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseAmounts  ***********************/
	class OptionExerciseAmountsBuilderImpl implements OptionExerciseAmounts.OptionExerciseAmountsBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder notionalReference;
		protected Money.MoneyBuilder exerciseInNotionalAmount;
		protected Money.MoneyBuilder outstandingNotionalAmount;
		protected NotionalReference.NotionalReferenceBuilder notionalScheduleReference;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder exerciseInNotionalSchedule;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder outstandingNotionalSchedule;
		protected NumberOfOptionsReference.NumberOfOptionsReferenceBuilder numberOfOptionsReference;
		protected BigDecimal exerciseInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
		protected NumberOfUnitsReference.NumberOfUnitsReferenceBuilder numberOfUnitsReference;
		protected BigDecimal exerciseInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
		
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
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		public Money.MoneyBuilder getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateExerciseInNotionalAmount() {
			Money.MoneyBuilder result;
			if (exerciseInNotionalAmount!=null) {
				result = exerciseInNotionalAmount;
			}
			else {
				result = exerciseInNotionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public Money.MoneyBuilder getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateOutstandingNotionalAmount() {
			Money.MoneyBuilder result;
			if (outstandingNotionalAmount!=null) {
				result = outstandingNotionalAmount;
			}
			else {
				result = outstandingNotionalAmount = Money.builder();
			}
			
			return result;
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
		@RosettaAttribute("exerciseInNotionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getExerciseInNotionalSchedule() {
			return exerciseInNotionalSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateExerciseInNotionalSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (exerciseInNotionalSchedule!=null) {
				result = exerciseInNotionalSchedule;
			}
			else {
				result = exerciseInNotionalSchedule = NonNegativeAmountSchedule.builder();
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
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
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
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setNotionalReference(NotionalReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNotionalAmount(Money _exerciseInNotionalAmount) {
			this.exerciseInNotionalAmount = _exerciseInNotionalAmount == null ? null : _exerciseInNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNotionalAmount")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNotionalAmount(Money _outstandingNotionalAmount) {
			this.outstandingNotionalAmount = _outstandingNotionalAmount == null ? null : _outstandingNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalScheduleReference")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setNotionalScheduleReference(NotionalReference _notionalScheduleReference) {
			this.notionalScheduleReference = _notionalScheduleReference == null ? null : _notionalScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseInNotionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNotionalSchedule")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNotionalSchedule(NonNegativeAmountSchedule _exerciseInNotionalSchedule) {
			this.exerciseInNotionalSchedule = _exerciseInNotionalSchedule == null ? null : _exerciseInNotionalSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNotionalSchedule")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNotionalSchedule(NonNegativeAmountSchedule _outstandingNotionalSchedule) {
			this.outstandingNotionalSchedule = _outstandingNotionalSchedule == null ? null : _outstandingNotionalSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfOptionsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfOptionsReference")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setNumberOfOptionsReference(NumberOfOptionsReference _numberOfOptionsReference) {
			this.numberOfOptionsReference = _numberOfOptionsReference == null ? null : _numberOfOptionsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNumberOfOptions(BigDecimal _exerciseInNumberOfOptions) {
			this.exerciseInNumberOfOptions = _exerciseInNumberOfOptions == null ? null : _exerciseInNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNumberOfOptions(BigDecimal _outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = _outstandingNumberOfOptions == null ? null : _outstandingNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("numberOfUnitsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfUnitsReference")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setNumberOfUnitsReference(NumberOfUnitsReference _numberOfUnitsReference) {
			this.numberOfUnitsReference = _numberOfUnitsReference == null ? null : _numberOfUnitsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setExerciseInNumberOfUnits(BigDecimal _exerciseInNumberOfUnits) {
			this.exerciseInNumberOfUnits = _exerciseInNumberOfUnits == null ? null : _exerciseInNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder setOutstandingNumberOfUnits(BigDecimal _outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = _outstandingNumberOfUnits == null ? null : _outstandingNumberOfUnits;
			return this;
		}
		
		@Override
		public OptionExerciseAmounts build() {
			return new OptionExerciseAmounts.OptionExerciseAmountsImpl(this);
		}
		
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder prune() {
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (exerciseInNotionalAmount!=null && !exerciseInNotionalAmount.prune().hasData()) exerciseInNotionalAmount = null;
			if (outstandingNotionalAmount!=null && !outstandingNotionalAmount.prune().hasData()) outstandingNotionalAmount = null;
			if (notionalScheduleReference!=null && !notionalScheduleReference.prune().hasData()) notionalScheduleReference = null;
			if (exerciseInNotionalSchedule!=null && !exerciseInNotionalSchedule.prune().hasData()) exerciseInNotionalSchedule = null;
			if (outstandingNotionalSchedule!=null && !outstandingNotionalSchedule.prune().hasData()) outstandingNotionalSchedule = null;
			if (numberOfOptionsReference!=null && !numberOfOptionsReference.prune().hasData()) numberOfOptionsReference = null;
			if (numberOfUnitsReference!=null && !numberOfUnitsReference.prune().hasData()) numberOfUnitsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getExerciseInNotionalAmount()!=null && getExerciseInNotionalAmount().hasData()) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().hasData()) return true;
			if (getNotionalScheduleReference()!=null && getNotionalScheduleReference().hasData()) return true;
			if (getExerciseInNotionalSchedule()!=null && getExerciseInNotionalSchedule().hasData()) return true;
			if (getOutstandingNotionalSchedule()!=null && getOutstandingNotionalSchedule().hasData()) return true;
			if (getNumberOfOptionsReference()!=null && getNumberOfOptionsReference().hasData()) return true;
			if (getExerciseInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			if (getNumberOfUnitsReference()!=null && getNumberOfUnitsReference().hasData()) return true;
			if (getExerciseInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseAmounts.OptionExerciseAmountsBuilder o = (OptionExerciseAmounts.OptionExerciseAmountsBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getExerciseInNotionalAmount(), o.getExerciseInNotionalAmount(), this::setExerciseInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::setOutstandingNotionalAmount);
			merger.mergeRosetta(getNotionalScheduleReference(), o.getNotionalScheduleReference(), this::setNotionalScheduleReference);
			merger.mergeRosetta(getExerciseInNotionalSchedule(), o.getExerciseInNotionalSchedule(), this::setExerciseInNotionalSchedule);
			merger.mergeRosetta(getOutstandingNotionalSchedule(), o.getOutstandingNotionalSchedule(), this::setOutstandingNotionalSchedule);
			merger.mergeRosetta(getNumberOfOptionsReference(), o.getNumberOfOptionsReference(), this::setNumberOfOptionsReference);
			merger.mergeRosetta(getNumberOfUnitsReference(), o.getNumberOfUnitsReference(), this::setNumberOfUnitsReference);
			
			merger.mergeBasic(getExerciseInNumberOfOptions(), o.getExerciseInNumberOfOptions(), this::setExerciseInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			merger.mergeBasic(getExerciseInNumberOfUnits(), o.getExerciseInNumberOfUnits(), this::setExerciseInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseAmounts _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(notionalScheduleReference, _that.getNotionalScheduleReference())) return false;
			if (!Objects.equals(exerciseInNotionalSchedule, _that.getExerciseInNotionalSchedule())) return false;
			if (!Objects.equals(outstandingNotionalSchedule, _that.getOutstandingNotionalSchedule())) return false;
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalScheduleReference != null ? notionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalSchedule != null ? exerciseInNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalSchedule != null ? outstandingNotionalSchedule.hashCode() : 0);
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseAmountsBuilder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"notionalScheduleReference=" + this.notionalScheduleReference + ", " +
				"exerciseInNotionalSchedule=" + this.exerciseInNotionalSchedule + ", " +
				"outstandingNotionalSchedule=" + this.outstandingNotionalSchedule + ", " +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}
}
