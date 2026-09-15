package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.PeriodicPaymentMeta;
import fpml.consolidated.fpmlenum.RollConventionEnum;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PaymentBase;
import fpml.consolidated.shared.Period;
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
@RosettaDataType(value="PeriodicPayment", builder=PeriodicPayment.PeriodicPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PeriodicPayment", model="fpml", builder=PeriodicPayment.PeriodicPaymentBuilderImpl.class, version="2.1.1")
public interface PeriodicPayment extends PaymentBase {

	PeriodicPaymentMeta metaData = new PeriodicPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time interval between regular fixed rate payer payment dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time interval between regular fixed rate payer payment dates.
	 *
	 */
	Period getPaymentFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The start date of the initial calculation period if such date is not equal to the trade’s effective date. It must only be specified if it is not equal to the effective date. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component (or in a transaction supplement FpML representation defined within the referenced general terms confirmation agreement).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start date of the initial calculation period if such date is not equal to the trade’s effective date. It must only be specified if it is not equal to the effective date. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component (or in a transaction supplement FpML representation defined within the referenced general terms confirmation agreement).
	 *
	 */
	ZonedDateTime getFirstPeriodStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first unadjusted fixed rate payer payment date. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component (or in a transaction supplement FpML representation defined within the referenced general terms confirmation agreement). ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first unadjusted fixed rate payer payment date. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component (or in a transaction supplement FpML representation defined within the referenced general terms confirmation agreement). ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 */
	ZonedDateTime getFirstPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last regular unadjusted fixed rate payer payment date. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component (or in a transaction supplement FpML representation defined within the referenced general terms confirmation agreement). This element should only be included if there is a final payment stub, i.e. where the last regular unadjusted fixed rate payer payment date is not equal to the scheduled termination date. ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last regular unadjusted fixed rate payer payment date. The applicable business day convention and business day are those specified in the dateAdjustments element within the generalTerms component (or in a transaction supplement FpML representation defined within the referenced general terms confirmation agreement). This element should only be included if there is a final payment stub, i.e. where the last regular unadjusted fixed rate payer payment date is not equal to the scheduled termination date. ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 */
	ZonedDateTime getLastRegularPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used in conjunction with the effectiveDate, scheduledTerminationDate, firstPaymentDate, lastRegularPaymentDate and paymentFrequency to determine the regular fixed rate payer payment dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used in conjunction with the effectiveDate, scheduledTerminationDate, firstPaymentDate, lastRegularPaymentDate and paymentFrequency to determine the regular fixed rate payer payment dates.
	 *
	 */
	RollConventionEnum getRollConvention();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fixed payment amount. ISDA 2003 Term: Fixed Amount
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fixed payment amount. ISDA 2003 Term: Fixed Amount
	 *
	 */
	Money getFixedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the terms relevant to calculating a fixed amount where the fixed amount is calculated by reference to a per annum fixed rate. There is no corresponding ISDA 2003 Term. The equivalent is Sec 5.1 "Calculation of Fixed Amount" but this in itself is not a defined Term.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the terms relevant to calculating a fixed amount where the fixed amount is calculated by reference to a per annum fixed rate. There is no corresponding ISDA 2003 Term. The equivalent is Sec 5.1 "Calculation of Fixed Amount" but this in itself is not a defined Term.
	 *
	 */
	FixedAmountCalculation getFixedAmountCalculation();
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
	FloatingAmountCalculation getFloatingAmountCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional cashflow-like structure allowing the equivalent representation of the periodic fixed payments in terms of a series of adjusted payment dates and amounts. This is intended to support application integration within an organisation and is not intended for use in inter-firm communication or confirmations. ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional cashflow-like structure allowing the equivalent representation of the periodic fixed payments in terms of a series of adjusted payment dates and amounts. This is intended to support application integration within an organisation and is not intended for use in inter-firm communication or confirmations. ISDA 2003 Term: Fixed Rate Payer Payment Date
	 *
	 */
	List<? extends AdjustedPaymentDates> getAdjustedPaymentDates();

	/*********************** Build Methods  ***********************/
	PeriodicPayment build();
	
	PeriodicPayment.PeriodicPaymentBuilder toBuilder();
	
	static PeriodicPayment.PeriodicPaymentBuilder builder() {
		return new PeriodicPayment.PeriodicPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PeriodicPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PeriodicPayment> getType() {
		return PeriodicPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("firstPeriodStartDate"), ZonedDateTime.class, getFirstPeriodStartDate(), this);
		processor.processBasic(path.newSubPath("firstPaymentDate"), ZonedDateTime.class, getFirstPaymentDate(), this);
		processor.processBasic(path.newSubPath("lastRegularPaymentDate"), ZonedDateTime.class, getLastRegularPaymentDate(), this);
		processor.processBasic(path.newSubPath("rollConvention"), RollConventionEnum.class, getRollConvention(), this);
		processRosetta(path.newSubPath("fixedAmount"), processor, Money.class, getFixedAmount());
		processRosetta(path.newSubPath("fixedAmountCalculation"), processor, FixedAmountCalculation.class, getFixedAmountCalculation());
		processRosetta(path.newSubPath("floatingAmountCalculation"), processor, FloatingAmountCalculation.class, getFloatingAmountCalculation());
		processRosetta(path.newSubPath("adjustedPaymentDates"), processor, AdjustedPaymentDates.class, getAdjustedPaymentDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodicPaymentBuilder extends PeriodicPayment, PaymentBase.PaymentBaseBuilder {
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		@Override
		Period.PeriodBuilder getPaymentFrequency();
		Money.MoneyBuilder getOrCreateFixedAmount();
		@Override
		Money.MoneyBuilder getFixedAmount();
		FixedAmountCalculation.FixedAmountCalculationBuilder getOrCreateFixedAmountCalculation();
		@Override
		FixedAmountCalculation.FixedAmountCalculationBuilder getFixedAmountCalculation();
		FloatingAmountCalculation.FloatingAmountCalculationBuilder getOrCreateFloatingAmountCalculation();
		@Override
		FloatingAmountCalculation.FloatingAmountCalculationBuilder getFloatingAmountCalculation();
		AdjustedPaymentDates.AdjustedPaymentDatesBuilder getOrCreateAdjustedPaymentDates(int index);
		@Override
		List<? extends AdjustedPaymentDates.AdjustedPaymentDatesBuilder> getAdjustedPaymentDates();
		@Override
		PeriodicPayment.PeriodicPaymentBuilder setId(String id);
		PeriodicPayment.PeriodicPaymentBuilder setPaymentFrequency(Period paymentFrequency);
		PeriodicPayment.PeriodicPaymentBuilder setFirstPeriodStartDate(ZonedDateTime firstPeriodStartDate);
		PeriodicPayment.PeriodicPaymentBuilder setFirstPaymentDate(ZonedDateTime firstPaymentDate);
		PeriodicPayment.PeriodicPaymentBuilder setLastRegularPaymentDate(ZonedDateTime lastRegularPaymentDate);
		PeriodicPayment.PeriodicPaymentBuilder setRollConvention(RollConventionEnum rollConvention);
		PeriodicPayment.PeriodicPaymentBuilder setFixedAmount(Money fixedAmount);
		PeriodicPayment.PeriodicPaymentBuilder setFixedAmountCalculation(FixedAmountCalculation fixedAmountCalculation);
		PeriodicPayment.PeriodicPaymentBuilder setFloatingAmountCalculation(FloatingAmountCalculation floatingAmountCalculation);
		PeriodicPayment.PeriodicPaymentBuilder addAdjustedPaymentDates(AdjustedPaymentDates adjustedPaymentDates);
		PeriodicPayment.PeriodicPaymentBuilder addAdjustedPaymentDates(AdjustedPaymentDates adjustedPaymentDates, int idx);
		PeriodicPayment.PeriodicPaymentBuilder addAdjustedPaymentDates(List<? extends AdjustedPaymentDates> adjustedPaymentDates);
		PeriodicPayment.PeriodicPaymentBuilder setAdjustedPaymentDates(List<? extends AdjustedPaymentDates> adjustedPaymentDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("firstPeriodStartDate"), ZonedDateTime.class, getFirstPeriodStartDate(), this);
			processor.processBasic(path.newSubPath("firstPaymentDate"), ZonedDateTime.class, getFirstPaymentDate(), this);
			processor.processBasic(path.newSubPath("lastRegularPaymentDate"), ZonedDateTime.class, getLastRegularPaymentDate(), this);
			processor.processBasic(path.newSubPath("rollConvention"), RollConventionEnum.class, getRollConvention(), this);
			processRosetta(path.newSubPath("fixedAmount"), processor, Money.MoneyBuilder.class, getFixedAmount());
			processRosetta(path.newSubPath("fixedAmountCalculation"), processor, FixedAmountCalculation.FixedAmountCalculationBuilder.class, getFixedAmountCalculation());
			processRosetta(path.newSubPath("floatingAmountCalculation"), processor, FloatingAmountCalculation.FloatingAmountCalculationBuilder.class, getFloatingAmountCalculation());
			processRosetta(path.newSubPath("adjustedPaymentDates"), processor, AdjustedPaymentDates.AdjustedPaymentDatesBuilder.class, getAdjustedPaymentDates());
		}
		

		PeriodicPayment.PeriodicPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of PeriodicPayment  ***********************/
	class PeriodicPaymentImpl extends PaymentBase.PaymentBaseImpl implements PeriodicPayment {
		private final Period paymentFrequency;
		private final ZonedDateTime firstPeriodStartDate;
		private final ZonedDateTime firstPaymentDate;
		private final ZonedDateTime lastRegularPaymentDate;
		private final RollConventionEnum rollConvention;
		private final Money fixedAmount;
		private final FixedAmountCalculation fixedAmountCalculation;
		private final FloatingAmountCalculation floatingAmountCalculation;
		private final List<? extends AdjustedPaymentDates> adjustedPaymentDates;
		
		protected PeriodicPaymentImpl(PeriodicPayment.PeriodicPaymentBuilder builder) {
			super(builder);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.firstPeriodStartDate = builder.getFirstPeriodStartDate();
			this.firstPaymentDate = builder.getFirstPaymentDate();
			this.lastRegularPaymentDate = builder.getLastRegularPaymentDate();
			this.rollConvention = builder.getRollConvention();
			this.fixedAmount = ofNullable(builder.getFixedAmount()).map(f->f.build()).orElse(null);
			this.fixedAmountCalculation = ofNullable(builder.getFixedAmountCalculation()).map(f->f.build()).orElse(null);
			this.floatingAmountCalculation = ofNullable(builder.getFloatingAmountCalculation()).map(f->f.build()).orElse(null);
			this.adjustedPaymentDates = ofNullable(builder.getAdjustedPaymentDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPeriodStartDate")
		public ZonedDateTime getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPaymentDate")
		public ZonedDateTime getFirstPaymentDate() {
			return firstPaymentDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastRegularPaymentDate")
		public ZonedDateTime getLastRegularPaymentDate() {
			return lastRegularPaymentDate;
		}
		
		@Override
		@RosettaAttribute("rollConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rollConvention")
		public RollConventionEnum getRollConvention() {
			return rollConvention;
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmount")
		public Money getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		@RosettaAttribute("fixedAmountCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmountCalculation")
		public FixedAmountCalculation getFixedAmountCalculation() {
			return fixedAmountCalculation;
		}
		
		@Override
		@RosettaAttribute("floatingAmountCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingAmountCalculation")
		public FloatingAmountCalculation getFloatingAmountCalculation() {
			return floatingAmountCalculation;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("adjustedPaymentDates")
		public List<? extends AdjustedPaymentDates> getAdjustedPaymentDates() {
			return adjustedPaymentDates;
		}
		
		@Override
		public PeriodicPayment build() {
			return this;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder toBuilder() {
			PeriodicPayment.PeriodicPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodicPayment.PeriodicPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getFirstPeriodStartDate()).ifPresent(builder::setFirstPeriodStartDate);
			ofNullable(getFirstPaymentDate()).ifPresent(builder::setFirstPaymentDate);
			ofNullable(getLastRegularPaymentDate()).ifPresent(builder::setLastRegularPaymentDate);
			ofNullable(getRollConvention()).ifPresent(builder::setRollConvention);
			ofNullable(getFixedAmount()).ifPresent(builder::setFixedAmount);
			ofNullable(getFixedAmountCalculation()).ifPresent(builder::setFixedAmountCalculation);
			ofNullable(getFloatingAmountCalculation()).ifPresent(builder::setFloatingAmountCalculation);
			ofNullable(getAdjustedPaymentDates()).ifPresent(builder::setAdjustedPaymentDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PeriodicPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstPaymentDate, _that.getFirstPaymentDate())) return false;
			if (!Objects.equals(lastRegularPaymentDate, _that.getLastRegularPaymentDate())) return false;
			if (!Objects.equals(rollConvention, _that.getRollConvention())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(fixedAmountCalculation, _that.getFixedAmountCalculation())) return false;
			if (!Objects.equals(floatingAmountCalculation, _that.getFloatingAmountCalculation())) return false;
			if (!ListEquals.listEquals(adjustedPaymentDates, _that.getAdjustedPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstPaymentDate != null ? firstPaymentDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPaymentDate != null ? lastRegularPaymentDate.hashCode() : 0);
			_result = 31 * _result + (rollConvention != null ? rollConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (fixedAmountCalculation != null ? fixedAmountCalculation.hashCode() : 0);
			_result = 31 * _result + (floatingAmountCalculation != null ? floatingAmountCalculation.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDates != null ? adjustedPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicPayment {" +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstPaymentDate=" + this.firstPaymentDate + ", " +
				"lastRegularPaymentDate=" + this.lastRegularPaymentDate + ", " +
				"rollConvention=" + this.rollConvention + ", " +
				"fixedAmount=" + this.fixedAmount + ", " +
				"fixedAmountCalculation=" + this.fixedAmountCalculation + ", " +
				"floatingAmountCalculation=" + this.floatingAmountCalculation + ", " +
				"adjustedPaymentDates=" + this.adjustedPaymentDates +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PeriodicPayment  ***********************/
	class PeriodicPaymentBuilderImpl extends PaymentBase.PaymentBaseBuilderImpl implements PeriodicPayment.PeriodicPaymentBuilder {
	
		protected Period.PeriodBuilder paymentFrequency;
		protected ZonedDateTime firstPeriodStartDate;
		protected ZonedDateTime firstPaymentDate;
		protected ZonedDateTime lastRegularPaymentDate;
		protected RollConventionEnum rollConvention;
		protected Money.MoneyBuilder fixedAmount;
		protected FixedAmountCalculation.FixedAmountCalculationBuilder fixedAmountCalculation;
		protected FloatingAmountCalculation.FloatingAmountCalculationBuilder floatingAmountCalculation;
		protected List<AdjustedPaymentDates.AdjustedPaymentDatesBuilder> adjustedPaymentDates = new ArrayList<>();
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period.PeriodBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePaymentFrequency() {
			Period.PeriodBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPeriodStartDate")
		public ZonedDateTime getFirstPeriodStartDate() {
			return firstPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("firstPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstPaymentDate")
		public ZonedDateTime getFirstPaymentDate() {
			return firstPaymentDate;
		}
		
		@Override
		@RosettaAttribute("lastRegularPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastRegularPaymentDate")
		public ZonedDateTime getLastRegularPaymentDate() {
			return lastRegularPaymentDate;
		}
		
		@Override
		@RosettaAttribute("rollConvention")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rollConvention")
		public RollConventionEnum getRollConvention() {
			return rollConvention;
		}
		
		@Override
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmount")
		public Money.MoneyBuilder getFixedAmount() {
			return fixedAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateFixedAmount() {
			Money.MoneyBuilder result;
			if (fixedAmount!=null) {
				result = fixedAmount;
			}
			else {
				result = fixedAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedAmountCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedAmountCalculation")
		public FixedAmountCalculation.FixedAmountCalculationBuilder getFixedAmountCalculation() {
			return fixedAmountCalculation;
		}
		
		@Override
		public FixedAmountCalculation.FixedAmountCalculationBuilder getOrCreateFixedAmountCalculation() {
			FixedAmountCalculation.FixedAmountCalculationBuilder result;
			if (fixedAmountCalculation!=null) {
				result = fixedAmountCalculation;
			}
			else {
				result = fixedAmountCalculation = FixedAmountCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingAmountCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingAmountCalculation")
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder getFloatingAmountCalculation() {
			return floatingAmountCalculation;
		}
		
		@Override
		public FloatingAmountCalculation.FloatingAmountCalculationBuilder getOrCreateFloatingAmountCalculation() {
			FloatingAmountCalculation.FloatingAmountCalculationBuilder result;
			if (floatingAmountCalculation!=null) {
				result = floatingAmountCalculation;
			}
			else {
				result = floatingAmountCalculation = FloatingAmountCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedPaymentDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("adjustedPaymentDates")
		public List<? extends AdjustedPaymentDates.AdjustedPaymentDatesBuilder> getAdjustedPaymentDates() {
			return adjustedPaymentDates;
		}
		
		@Override
		public AdjustedPaymentDates.AdjustedPaymentDatesBuilder getOrCreateAdjustedPaymentDates(int index) {
			if (adjustedPaymentDates==null) {
				this.adjustedPaymentDates = new ArrayList<>();
			}
			return getIndex(adjustedPaymentDates, index, () -> {
						AdjustedPaymentDates.AdjustedPaymentDatesBuilder newAdjustedPaymentDates = AdjustedPaymentDates.builder();
						return newAdjustedPaymentDates;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("firstPeriodStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstPeriodStartDate")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFirstPeriodStartDate(ZonedDateTime _firstPeriodStartDate) {
			this.firstPeriodStartDate = _firstPeriodStartDate == null ? null : _firstPeriodStartDate;
			return this;
		}
		
		@RosettaAttribute("firstPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstPaymentDate")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFirstPaymentDate(ZonedDateTime _firstPaymentDate) {
			this.firstPaymentDate = _firstPaymentDate == null ? null : _firstPaymentDate;
			return this;
		}
		
		@RosettaAttribute("lastRegularPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastRegularPaymentDate")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setLastRegularPaymentDate(ZonedDateTime _lastRegularPaymentDate) {
			this.lastRegularPaymentDate = _lastRegularPaymentDate == null ? null : _lastRegularPaymentDate;
			return this;
		}
		
		@RosettaAttribute("rollConvention")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rollConvention")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setRollConvention(RollConventionEnum _rollConvention) {
			this.rollConvention = _rollConvention == null ? null : _rollConvention;
			return this;
		}
		
		@RosettaAttribute("fixedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedAmount")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFixedAmount(Money _fixedAmount) {
			this.fixedAmount = _fixedAmount == null ? null : _fixedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedAmountCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedAmountCalculation")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFixedAmountCalculation(FixedAmountCalculation _fixedAmountCalculation) {
			this.fixedAmountCalculation = _fixedAmountCalculation == null ? null : _fixedAmountCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingAmountCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingAmountCalculation")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setFloatingAmountCalculation(FloatingAmountCalculation _floatingAmountCalculation) {
			this.floatingAmountCalculation = _floatingAmountCalculation == null ? null : _floatingAmountCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedPaymentDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("adjustedPaymentDates")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder addAdjustedPaymentDates(AdjustedPaymentDates _adjustedPaymentDates) {
			if (_adjustedPaymentDates != null) {
				this.adjustedPaymentDates.add(_adjustedPaymentDates.toBuilder());
			}
			return this;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder addAdjustedPaymentDates(AdjustedPaymentDates _adjustedPaymentDates, int idx) {
			getIndex(this.adjustedPaymentDates, idx, () -> _adjustedPaymentDates.toBuilder());
			return this;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder addAdjustedPaymentDates(List<? extends AdjustedPaymentDates> adjustedPaymentDatess) {
			if (adjustedPaymentDatess != null) {
				for (final AdjustedPaymentDates toAdd : adjustedPaymentDatess) {
					this.adjustedPaymentDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("adjustedPaymentDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("adjustedPaymentDates")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder setAdjustedPaymentDates(List<? extends AdjustedPaymentDates> adjustedPaymentDatess) {
			if (adjustedPaymentDatess == null) {
				this.adjustedPaymentDates = new ArrayList<>();
			} else {
				this.adjustedPaymentDates = adjustedPaymentDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PeriodicPayment build() {
			return new PeriodicPayment.PeriodicPaymentImpl(this);
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder prune() {
			super.prune();
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (fixedAmount!=null && !fixedAmount.prune().hasData()) fixedAmount = null;
			if (fixedAmountCalculation!=null && !fixedAmountCalculation.prune().hasData()) fixedAmountCalculation = null;
			if (floatingAmountCalculation!=null && !floatingAmountCalculation.prune().hasData()) floatingAmountCalculation = null;
			adjustedPaymentDates = adjustedPaymentDates.stream().filter(b->b!=null).<AdjustedPaymentDates.AdjustedPaymentDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getFirstPeriodStartDate()!=null) return true;
			if (getFirstPaymentDate()!=null) return true;
			if (getLastRegularPaymentDate()!=null) return true;
			if (getRollConvention()!=null) return true;
			if (getFixedAmount()!=null && getFixedAmount().hasData()) return true;
			if (getFixedAmountCalculation()!=null && getFixedAmountCalculation().hasData()) return true;
			if (getFloatingAmountCalculation()!=null && getFloatingAmountCalculation().hasData()) return true;
			if (getAdjustedPaymentDates()!=null && getAdjustedPaymentDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PeriodicPayment.PeriodicPaymentBuilder o = (PeriodicPayment.PeriodicPaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getFixedAmount(), o.getFixedAmount(), this::setFixedAmount);
			merger.mergeRosetta(getFixedAmountCalculation(), o.getFixedAmountCalculation(), this::setFixedAmountCalculation);
			merger.mergeRosetta(getFloatingAmountCalculation(), o.getFloatingAmountCalculation(), this::setFloatingAmountCalculation);
			merger.mergeRosetta(getAdjustedPaymentDates(), o.getAdjustedPaymentDates(), this::getOrCreateAdjustedPaymentDates);
			
			merger.mergeBasic(getFirstPeriodStartDate(), o.getFirstPeriodStartDate(), this::setFirstPeriodStartDate);
			merger.mergeBasic(getFirstPaymentDate(), o.getFirstPaymentDate(), this::setFirstPaymentDate);
			merger.mergeBasic(getLastRegularPaymentDate(), o.getLastRegularPaymentDate(), this::setLastRegularPaymentDate);
			merger.mergeBasic(getRollConvention(), o.getRollConvention(), this::setRollConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PeriodicPayment _that = getType().cast(o);
		
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(firstPeriodStartDate, _that.getFirstPeriodStartDate())) return false;
			if (!Objects.equals(firstPaymentDate, _that.getFirstPaymentDate())) return false;
			if (!Objects.equals(lastRegularPaymentDate, _that.getLastRegularPaymentDate())) return false;
			if (!Objects.equals(rollConvention, _that.getRollConvention())) return false;
			if (!Objects.equals(fixedAmount, _that.getFixedAmount())) return false;
			if (!Objects.equals(fixedAmountCalculation, _that.getFixedAmountCalculation())) return false;
			if (!Objects.equals(floatingAmountCalculation, _that.getFloatingAmountCalculation())) return false;
			if (!ListEquals.listEquals(adjustedPaymentDates, _that.getAdjustedPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (firstPeriodStartDate != null ? firstPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (firstPaymentDate != null ? firstPaymentDate.hashCode() : 0);
			_result = 31 * _result + (lastRegularPaymentDate != null ? lastRegularPaymentDate.hashCode() : 0);
			_result = 31 * _result + (rollConvention != null ? rollConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
			_result = 31 * _result + (fixedAmountCalculation != null ? fixedAmountCalculation.hashCode() : 0);
			_result = 31 * _result + (floatingAmountCalculation != null ? floatingAmountCalculation.hashCode() : 0);
			_result = 31 * _result + (adjustedPaymentDates != null ? adjustedPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodicPaymentBuilder {" +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"firstPeriodStartDate=" + this.firstPeriodStartDate + ", " +
				"firstPaymentDate=" + this.firstPaymentDate + ", " +
				"lastRegularPaymentDate=" + this.lastRegularPaymentDate + ", " +
				"rollConvention=" + this.rollConvention + ", " +
				"fixedAmount=" + this.fixedAmount + ", " +
				"fixedAmountCalculation=" + this.fixedAmountCalculation + ", " +
				"floatingAmountCalculation=" + this.floatingAmountCalculation + ", " +
				"adjustedPaymentDates=" + this.adjustedPaymentDates +
			'}' + " " + super.toString();
		}
	}
}
