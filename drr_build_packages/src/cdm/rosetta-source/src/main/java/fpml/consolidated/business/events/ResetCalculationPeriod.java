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
import fpml.consolidated.business.events.meta.ResetCalculationPeriodMeta;
import fpml.consolidated.shared.DayCountFraction;
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
 * Provision The period calculation details for a calculation/accrual period. This will include information about the dates and duration of the accrual period, the rate fixing(s), the notional in effect, and the amount of the accrual.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The period calculation details for a calculation/accrual period. This will include information about the dates and duration of the accrual period, the rate fixing(s), the notional in effect, and the amount of the accrual.
 *
 */
@RosettaDataType(value="ResetCalculationPeriod", builder=ResetCalculationPeriod.ResetCalculationPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResetCalculationPeriod", model="fpml", builder=ResetCalculationPeriod.ResetCalculationPeriodBuilderImpl.class, version="2.1.1")
public interface ResetCalculationPeriod extends RosettaModelObject {

	ResetCalculationPeriodMeta metaData = new ResetCalculationPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date that defines the beginning of the calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date that defines the beginning of the calculation period.
	 *
	 */
	ZonedDateTime getAdjustedStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date that defines the end of the calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date that defines the end of the calculation period.
	 *
	 */
	ZonedDateTime getAdjustedEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of days from the adjusted effective / start date to the adjusted termination / end date calculated in accordance with the applicable day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of days from the adjusted effective / start date to the adjusted termination / end date calculated in accordance with the applicable day count fraction.
	 *
	 */
	Integer getNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification for how the number of days between two dates is calculated for purposes of calculation of a fixed or floating payment amount and the basis for how many days are assumed to be in a year. Day Count Fraction is an ISDA term. The equivalent AFB (Association Francaise de Banques) term is Calculation Basis.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification for how the number of days between two dates is calculated for purposes of calculation of a fixed or floating payment amount and the basis for how many days are assumed to be in a year. Day Count Fraction is an ISDA term. The equivalent AFB (Association Francaise de Banques) term is Calculation Basis.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The year fraction value of the calculation period, result of applying the ISDA rules for day count fraction defined in the ISDA Annex.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The year fraction value of the calculation period, result of applying the ISDA rules for day count fraction defined in the ISDA Annex.
	 *
	 */
	BigDecimal getDayCountYearFraction();

	/*********************** Build Methods  ***********************/
	ResetCalculationPeriod build();
	
	ResetCalculationPeriod.ResetCalculationPeriodBuilder toBuilder();
	
	static ResetCalculationPeriod.ResetCalculationPeriodBuilder builder() {
		return new ResetCalculationPeriod.ResetCalculationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetCalculationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetCalculationPeriod> getType() {
		return ResetCalculationPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedStartDate"), ZonedDateTime.class, getAdjustedStartDate(), this);
		processor.processBasic(path.newSubPath("adjustedEndDate"), ZonedDateTime.class, getAdjustedEndDate(), this);
		processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("dayCountYearFraction"), BigDecimal.class, getDayCountYearFraction(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetCalculationPeriodBuilder extends ResetCalculationPeriod, RosettaModelObjectBuilder {
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		ResetCalculationPeriod.ResetCalculationPeriodBuilder setAdjustedStartDate(ZonedDateTime adjustedStartDate);
		ResetCalculationPeriod.ResetCalculationPeriodBuilder setAdjustedEndDate(ZonedDateTime adjustedEndDate);
		ResetCalculationPeriod.ResetCalculationPeriodBuilder setNumberOfDays(Integer numberOfDays);
		ResetCalculationPeriod.ResetCalculationPeriodBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		ResetCalculationPeriod.ResetCalculationPeriodBuilder setDayCountYearFraction(BigDecimal dayCountYearFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustedStartDate"), ZonedDateTime.class, getAdjustedStartDate(), this);
			processor.processBasic(path.newSubPath("adjustedEndDate"), ZonedDateTime.class, getAdjustedEndDate(), this);
			processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("dayCountYearFraction"), BigDecimal.class, getDayCountYearFraction(), this);
		}
		

		ResetCalculationPeriod.ResetCalculationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of ResetCalculationPeriod  ***********************/
	class ResetCalculationPeriodImpl implements ResetCalculationPeriod {
		private final ZonedDateTime adjustedStartDate;
		private final ZonedDateTime adjustedEndDate;
		private final Integer numberOfDays;
		private final DayCountFraction dayCountFraction;
		private final BigDecimal dayCountYearFraction;
		
		protected ResetCalculationPeriodImpl(ResetCalculationPeriod.ResetCalculationPeriodBuilder builder) {
			this.adjustedStartDate = builder.getAdjustedStartDate();
			this.adjustedEndDate = builder.getAdjustedEndDate();
			this.numberOfDays = builder.getNumberOfDays();
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.dayCountYearFraction = builder.getDayCountYearFraction();
		}
		
		@Override
		@RosettaAttribute("adjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedStartDate")
		public ZonedDateTime getAdjustedStartDate() {
			return adjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("adjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEndDate")
		public ZonedDateTime getAdjustedEndDate() {
			return adjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("dayCountYearFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountYearFraction")
		public BigDecimal getDayCountYearFraction() {
			return dayCountYearFraction;
		}
		
		@Override
		public ResetCalculationPeriod build() {
			return this;
		}
		
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder toBuilder() {
			ResetCalculationPeriod.ResetCalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetCalculationPeriod.ResetCalculationPeriodBuilder builder) {
			ofNullable(getAdjustedStartDate()).ifPresent(builder::setAdjustedStartDate);
			ofNullable(getAdjustedEndDate()).ifPresent(builder::setAdjustedEndDate);
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getDayCountYearFraction()).ifPresent(builder::setDayCountYearFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(adjustedStartDate, _that.getAdjustedStartDate())) return false;
			if (!Objects.equals(adjustedEndDate, _that.getAdjustedEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(dayCountYearFraction, _that.getDayCountYearFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedStartDate != null ? adjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEndDate != null ? adjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (dayCountYearFraction != null ? dayCountYearFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetCalculationPeriod {" +
				"adjustedStartDate=" + this.adjustedStartDate + ", " +
				"adjustedEndDate=" + this.adjustedEndDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"dayCountYearFraction=" + this.dayCountYearFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of ResetCalculationPeriod  ***********************/
	class ResetCalculationPeriodBuilderImpl implements ResetCalculationPeriod.ResetCalculationPeriodBuilder {
	
		protected ZonedDateTime adjustedStartDate;
		protected ZonedDateTime adjustedEndDate;
		protected Integer numberOfDays;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected BigDecimal dayCountYearFraction;
		
		@Override
		@RosettaAttribute("adjustedStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedStartDate")
		public ZonedDateTime getAdjustedStartDate() {
			return adjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("adjustedEndDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedEndDate")
		public ZonedDateTime getAdjustedEndDate() {
			return adjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountYearFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountYearFraction")
		public BigDecimal getDayCountYearFraction() {
			return dayCountYearFraction;
		}
		
		@RosettaAttribute("adjustedStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedStartDate")
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder setAdjustedStartDate(ZonedDateTime _adjustedStartDate) {
			this.adjustedStartDate = _adjustedStartDate == null ? null : _adjustedStartDate;
			return this;
		}
		
		@RosettaAttribute("adjustedEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedEndDate")
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder setAdjustedEndDate(ZonedDateTime _adjustedEndDate) {
			this.adjustedEndDate = _adjustedEndDate == null ? null : _adjustedEndDate;
			return this;
		}
		
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfDays")
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder setNumberOfDays(Integer _numberOfDays) {
			this.numberOfDays = _numberOfDays == null ? null : _numberOfDays;
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountYearFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountYearFraction")
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder setDayCountYearFraction(BigDecimal _dayCountYearFraction) {
			this.dayCountYearFraction = _dayCountYearFraction == null ? null : _dayCountYearFraction;
			return this;
		}
		
		@Override
		public ResetCalculationPeriod build() {
			return new ResetCalculationPeriod.ResetCalculationPeriodImpl(this);
		}
		
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder prune() {
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedStartDate()!=null) return true;
			if (getAdjustedEndDate()!=null) return true;
			if (getNumberOfDays()!=null) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getDayCountYearFraction()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetCalculationPeriod.ResetCalculationPeriodBuilder o = (ResetCalculationPeriod.ResetCalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			merger.mergeBasic(getAdjustedStartDate(), o.getAdjustedStartDate(), this::setAdjustedStartDate);
			merger.mergeBasic(getAdjustedEndDate(), o.getAdjustedEndDate(), this::setAdjustedEndDate);
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			merger.mergeBasic(getDayCountYearFraction(), o.getDayCountYearFraction(), this::setDayCountYearFraction);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(adjustedStartDate, _that.getAdjustedStartDate())) return false;
			if (!Objects.equals(adjustedEndDate, _that.getAdjustedEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(dayCountYearFraction, _that.getDayCountYearFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedStartDate != null ? adjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (adjustedEndDate != null ? adjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (dayCountYearFraction != null ? dayCountYearFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetCalculationPeriodBuilder {" +
				"adjustedStartDate=" + this.adjustedStartDate + ", " +
				"adjustedEndDate=" + this.adjustedEndDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"dayCountYearFraction=" + this.dayCountYearFraction +
			'}';
		}
	}
}
