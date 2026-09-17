package fpml.consolidated.ird;

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
import fpml.consolidated.fpmlenum.StepRelativeToEnum;
import fpml.consolidated.ird.meta.NotionalStepRuleMeta;
import fpml.consolidated.shared.Frequency;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a parametric representation of the notional step schedule, i.e. parameters used to generate the notional balance on each step date. The step change in notional can be expressed in terms of either a fixed amount or as a percentage of either the initial notional or previous notional amount. This parametric representation is intended to cover the more common amortizing/accreting.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a parametric representation of the notional step schedule, i.e. parameters used to generate the notional balance on each step date. The step change in notional can be expressed in terms of either a fixed amount or as a percentage of either the initial notional or previous notional amount. This parametric representation is intended to cover the more common amortizing/accreting.
 *
 */
@RosettaDataType(value="NotionalStepRule", builder=NotionalStepRule.NotionalStepRuleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NotionalStepRule", model="fpml", builder=NotionalStepRule.NotionalStepRuleBuilderImpl.class, version="2.1.1")
public interface NotionalStepRule extends RosettaModelObject {

	NotionalStepRuleMeta metaData = new NotionalStepRuleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 *
	 */
	CalculationPeriodDatesReference getCalculationPeriodDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency at which the notional step changes occur. This frequency must be an integer multiple of the stream calculation period frequency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which the notional step changes occur. This frequency must be an integer multiple of the stream calculation period frequency.
	 *
	 */
	Frequency getStepFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Effective date of the first change in notional (i.e. a calculation period start date).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Effective date of the first change in notional (i.e. a calculation period start date).
	 *
	 */
	ZonedDateTime getFirstNotionalStepDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Effective date of the last change in notional (i.e. a calculation period start date).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Effective date of the last change in notional (i.e. a calculation period start date).
	 *
	 */
	ZonedDateTime getLastNotionalStepDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The explicit amount that the notional changes on each step date. This can be a positive or negative amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The explicit amount that the notional changes on each step date. This can be a positive or negative amount.
	 *
	 */
	BigDecimal getNotionalStepAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The percentage amount by which the notional changes on each step date. The percentage is either a percentage applied to the initial notional amount or the previous outstanding notional, depending on the value of the element stepRelativeTo. The percentage can be either positive or negative. A percentage of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The percentage amount by which the notional changes on each step date. The percentage is either a percentage applied to the initial notional amount or the previous outstanding notional, depending on the value of the element stepRelativeTo. The percentage can be either positive or negative. A percentage of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getNotionalStepRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the notionalStepRate should be applied to the initial notional or the previous notional in order to calculate the notional step change amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the notionalStepRate should be applied to the initial notional or the previous notional in order to calculate the notional step change amount.
	 *
	 */
	StepRelativeToEnum getStepRelativeTo();

	/*********************** Build Methods  ***********************/
	NotionalStepRule build();
	
	NotionalStepRule.NotionalStepRuleBuilder toBuilder();
	
	static NotionalStepRule.NotionalStepRuleBuilder builder() {
		return new NotionalStepRule.NotionalStepRuleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalStepRule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalStepRule> getType() {
		return NotionalStepRule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.class, getCalculationPeriodDatesReference());
		processRosetta(path.newSubPath("stepFrequency"), processor, Frequency.class, getStepFrequency());
		processor.processBasic(path.newSubPath("firstNotionalStepDate"), ZonedDateTime.class, getFirstNotionalStepDate(), this);
		processor.processBasic(path.newSubPath("lastNotionalStepDate"), ZonedDateTime.class, getLastNotionalStepDate(), this);
		processor.processBasic(path.newSubPath("notionalStepAmount"), BigDecimal.class, getNotionalStepAmount(), this);
		processor.processBasic(path.newSubPath("notionalStepRate"), BigDecimal.class, getNotionalStepRate(), this);
		processor.processBasic(path.newSubPath("stepRelativeTo"), StepRelativeToEnum.class, getStepRelativeTo(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalStepRuleBuilder extends NotionalStepRule, RosettaModelObjectBuilder {
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference();
		@Override
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference();
		Frequency.FrequencyBuilder getOrCreateStepFrequency();
		@Override
		Frequency.FrequencyBuilder getStepFrequency();
		NotionalStepRule.NotionalStepRuleBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference);
		NotionalStepRule.NotionalStepRuleBuilder setStepFrequency(Frequency stepFrequency);
		NotionalStepRule.NotionalStepRuleBuilder setFirstNotionalStepDate(ZonedDateTime firstNotionalStepDate);
		NotionalStepRule.NotionalStepRuleBuilder setLastNotionalStepDate(ZonedDateTime lastNotionalStepDate);
		NotionalStepRule.NotionalStepRuleBuilder setNotionalStepAmount(BigDecimal notionalStepAmount);
		NotionalStepRule.NotionalStepRuleBuilder setNotionalStepRate(BigDecimal notionalStepRate);
		NotionalStepRule.NotionalStepRuleBuilder setStepRelativeTo(StepRelativeToEnum stepRelativeTo);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder.class, getCalculationPeriodDatesReference());
			processRosetta(path.newSubPath("stepFrequency"), processor, Frequency.FrequencyBuilder.class, getStepFrequency());
			processor.processBasic(path.newSubPath("firstNotionalStepDate"), ZonedDateTime.class, getFirstNotionalStepDate(), this);
			processor.processBasic(path.newSubPath("lastNotionalStepDate"), ZonedDateTime.class, getLastNotionalStepDate(), this);
			processor.processBasic(path.newSubPath("notionalStepAmount"), BigDecimal.class, getNotionalStepAmount(), this);
			processor.processBasic(path.newSubPath("notionalStepRate"), BigDecimal.class, getNotionalStepRate(), this);
			processor.processBasic(path.newSubPath("stepRelativeTo"), StepRelativeToEnum.class, getStepRelativeTo(), this);
		}
		

		NotionalStepRule.NotionalStepRuleBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalStepRule  ***********************/
	class NotionalStepRuleImpl implements NotionalStepRule {
		private final CalculationPeriodDatesReference calculationPeriodDatesReference;
		private final Frequency stepFrequency;
		private final ZonedDateTime firstNotionalStepDate;
		private final ZonedDateTime lastNotionalStepDate;
		private final BigDecimal notionalStepAmount;
		private final BigDecimal notionalStepRate;
		private final StepRelativeToEnum stepRelativeTo;
		
		protected NotionalStepRuleImpl(NotionalStepRule.NotionalStepRuleBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).map(f->f.build()).orElse(null);
			this.stepFrequency = ofNullable(builder.getStepFrequency()).map(f->f.build()).orElse(null);
			this.firstNotionalStepDate = builder.getFirstNotionalStepDate();
			this.lastNotionalStepDate = builder.getLastNotionalStepDate();
			this.notionalStepAmount = builder.getNotionalStepAmount();
			this.notionalStepRate = builder.getNotionalStepRate();
			this.stepRelativeTo = builder.getStepRelativeTo();
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		@RosettaAttribute("stepFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepFrequency")
		public Frequency getStepFrequency() {
			return stepFrequency;
		}
		
		@Override
		@RosettaAttribute("firstNotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstNotionalStepDate")
		public ZonedDateTime getFirstNotionalStepDate() {
			return firstNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("lastNotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastNotionalStepDate")
		public ZonedDateTime getLastNotionalStepDate() {
			return lastNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("notionalStepAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalStepAmount")
		public BigDecimal getNotionalStepAmount() {
			return notionalStepAmount;
		}
		
		@Override
		@RosettaAttribute("notionalStepRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalStepRate")
		public BigDecimal getNotionalStepRate() {
			return notionalStepRate;
		}
		
		@Override
		@RosettaAttribute("stepRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepRelativeTo")
		public StepRelativeToEnum getStepRelativeTo() {
			return stepRelativeTo;
		}
		
		@Override
		public NotionalStepRule build() {
			return this;
		}
		
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder toBuilder() {
			NotionalStepRule.NotionalStepRuleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalStepRule.NotionalStepRuleBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
			ofNullable(getStepFrequency()).ifPresent(builder::setStepFrequency);
			ofNullable(getFirstNotionalStepDate()).ifPresent(builder::setFirstNotionalStepDate);
			ofNullable(getLastNotionalStepDate()).ifPresent(builder::setLastNotionalStepDate);
			ofNullable(getNotionalStepAmount()).ifPresent(builder::setNotionalStepAmount);
			ofNullable(getNotionalStepRate()).ifPresent(builder::setNotionalStepRate);
			ofNullable(getStepRelativeTo()).ifPresent(builder::setStepRelativeTo);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalStepRule _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(stepFrequency, _that.getStepFrequency())) return false;
			if (!Objects.equals(firstNotionalStepDate, _that.getFirstNotionalStepDate())) return false;
			if (!Objects.equals(lastNotionalStepDate, _that.getLastNotionalStepDate())) return false;
			if (!Objects.equals(notionalStepAmount, _that.getNotionalStepAmount())) return false;
			if (!Objects.equals(notionalStepRate, _that.getNotionalStepRate())) return false;
			if (!Objects.equals(stepRelativeTo, _that.getStepRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (stepFrequency != null ? stepFrequency.hashCode() : 0);
			_result = 31 * _result + (firstNotionalStepDate != null ? firstNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (lastNotionalStepDate != null ? lastNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (notionalStepAmount != null ? notionalStepAmount.hashCode() : 0);
			_result = 31 * _result + (notionalStepRate != null ? notionalStepRate.hashCode() : 0);
			_result = 31 * _result + (stepRelativeTo != null ? stepRelativeTo.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalStepRule {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"stepFrequency=" + this.stepFrequency + ", " +
				"firstNotionalStepDate=" + this.firstNotionalStepDate + ", " +
				"lastNotionalStepDate=" + this.lastNotionalStepDate + ", " +
				"notionalStepAmount=" + this.notionalStepAmount + ", " +
				"notionalStepRate=" + this.notionalStepRate + ", " +
				"stepRelativeTo=" + this.stepRelativeTo +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalStepRule  ***********************/
	class NotionalStepRuleBuilderImpl implements NotionalStepRule.NotionalStepRuleBuilder {
	
		protected CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder calculationPeriodDatesReference;
		protected Frequency.FrequencyBuilder stepFrequency;
		protected ZonedDateTime firstNotionalStepDate;
		protected ZonedDateTime lastNotionalStepDate;
		protected BigDecimal notionalStepAmount;
		protected BigDecimal notionalStepRate;
		protected StepRelativeToEnum stepRelativeTo;
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodDatesReference")
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference() {
			CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder result;
			if (calculationPeriodDatesReference!=null) {
				result = calculationPeriodDatesReference;
			}
			else {
				result = calculationPeriodDatesReference = CalculationPeriodDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stepFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepFrequency")
		public Frequency.FrequencyBuilder getStepFrequency() {
			return stepFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateStepFrequency() {
			Frequency.FrequencyBuilder result;
			if (stepFrequency!=null) {
				result = stepFrequency;
			}
			else {
				result = stepFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstNotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstNotionalStepDate")
		public ZonedDateTime getFirstNotionalStepDate() {
			return firstNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("lastNotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastNotionalStepDate")
		public ZonedDateTime getLastNotionalStepDate() {
			return lastNotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("notionalStepAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalStepAmount")
		public BigDecimal getNotionalStepAmount() {
			return notionalStepAmount;
		}
		
		@Override
		@RosettaAttribute("notionalStepRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalStepRate")
		public BigDecimal getNotionalStepRate() {
			return notionalStepRate;
		}
		
		@Override
		@RosettaAttribute("stepRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("stepRelativeTo")
		public StepRelativeToEnum getStepRelativeTo() {
			return stepRelativeTo;
		}
		
		@RosettaAttribute("calculationPeriodDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodDatesReference")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder setCalculationPeriodDatesReference(CalculationPeriodDatesReference _calculationPeriodDatesReference) {
			this.calculationPeriodDatesReference = _calculationPeriodDatesReference == null ? null : _calculationPeriodDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("stepFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stepFrequency")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder setStepFrequency(Frequency _stepFrequency) {
			this.stepFrequency = _stepFrequency == null ? null : _stepFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("firstNotionalStepDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstNotionalStepDate")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder setFirstNotionalStepDate(ZonedDateTime _firstNotionalStepDate) {
			this.firstNotionalStepDate = _firstNotionalStepDate == null ? null : _firstNotionalStepDate;
			return this;
		}
		
		@RosettaAttribute("lastNotionalStepDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastNotionalStepDate")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder setLastNotionalStepDate(ZonedDateTime _lastNotionalStepDate) {
			this.lastNotionalStepDate = _lastNotionalStepDate == null ? null : _lastNotionalStepDate;
			return this;
		}
		
		@RosettaAttribute("notionalStepAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalStepAmount")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder setNotionalStepAmount(BigDecimal _notionalStepAmount) {
			this.notionalStepAmount = _notionalStepAmount == null ? null : _notionalStepAmount;
			return this;
		}
		
		@RosettaAttribute("notionalStepRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalStepRate")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder setNotionalStepRate(BigDecimal _notionalStepRate) {
			this.notionalStepRate = _notionalStepRate == null ? null : _notionalStepRate;
			return this;
		}
		
		@RosettaAttribute("stepRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("stepRelativeTo")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder setStepRelativeTo(StepRelativeToEnum _stepRelativeTo) {
			this.stepRelativeTo = _stepRelativeTo == null ? null : _stepRelativeTo;
			return this;
		}
		
		@Override
		public NotionalStepRule build() {
			return new NotionalStepRule.NotionalStepRuleImpl(this);
		}
		
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder prune() {
			if (calculationPeriodDatesReference!=null && !calculationPeriodDatesReference.prune().hasData()) calculationPeriodDatesReference = null;
			if (stepFrequency!=null && !stepFrequency.prune().hasData()) stepFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().hasData()) return true;
			if (getStepFrequency()!=null && getStepFrequency().hasData()) return true;
			if (getFirstNotionalStepDate()!=null) return true;
			if (getLastNotionalStepDate()!=null) return true;
			if (getNotionalStepAmount()!=null) return true;
			if (getNotionalStepRate()!=null) return true;
			if (getStepRelativeTo()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalStepRule.NotionalStepRuleBuilder o = (NotionalStepRule.NotionalStepRuleBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::setCalculationPeriodDatesReference);
			merger.mergeRosetta(getStepFrequency(), o.getStepFrequency(), this::setStepFrequency);
			
			merger.mergeBasic(getFirstNotionalStepDate(), o.getFirstNotionalStepDate(), this::setFirstNotionalStepDate);
			merger.mergeBasic(getLastNotionalStepDate(), o.getLastNotionalStepDate(), this::setLastNotionalStepDate);
			merger.mergeBasic(getNotionalStepAmount(), o.getNotionalStepAmount(), this::setNotionalStepAmount);
			merger.mergeBasic(getNotionalStepRate(), o.getNotionalStepRate(), this::setNotionalStepRate);
			merger.mergeBasic(getStepRelativeTo(), o.getStepRelativeTo(), this::setStepRelativeTo);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalStepRule _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(stepFrequency, _that.getStepFrequency())) return false;
			if (!Objects.equals(firstNotionalStepDate, _that.getFirstNotionalStepDate())) return false;
			if (!Objects.equals(lastNotionalStepDate, _that.getLastNotionalStepDate())) return false;
			if (!Objects.equals(notionalStepAmount, _that.getNotionalStepAmount())) return false;
			if (!Objects.equals(notionalStepRate, _that.getNotionalStepRate())) return false;
			if (!Objects.equals(stepRelativeTo, _that.getStepRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (stepFrequency != null ? stepFrequency.hashCode() : 0);
			_result = 31 * _result + (firstNotionalStepDate != null ? firstNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (lastNotionalStepDate != null ? lastNotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (notionalStepAmount != null ? notionalStepAmount.hashCode() : 0);
			_result = 31 * _result + (notionalStepRate != null ? notionalStepRate.hashCode() : 0);
			_result = 31 * _result + (stepRelativeTo != null ? stepRelativeTo.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalStepRuleBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"stepFrequency=" + this.stepFrequency + ", " +
				"firstNotionalStepDate=" + this.firstNotionalStepDate + ", " +
				"lastNotionalStepDate=" + this.lastNotionalStepDate + ", " +
				"notionalStepAmount=" + this.notionalStepAmount + ", " +
				"notionalStepRate=" + this.notionalStepRate + ", " +
				"stepRelativeTo=" + this.stepRelativeTo +
			'}';
		}
	}
}
