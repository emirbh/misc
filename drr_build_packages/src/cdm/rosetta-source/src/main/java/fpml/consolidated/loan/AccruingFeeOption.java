package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.loan.meta.AccruingFeeOptionMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents the accruing fee option associated within a facility.
 *
 */
@RosettaDataType(value="AccruingFeeOption", builder=AccruingFeeOption.AccruingFeeOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccruingFeeOption", model="fpml", builder=AccruingFeeOption.AccruingFeeOptionBuilderImpl.class, version="2.1.1")
public interface AccruingFeeOption extends FeeRateOptionBase {

	AccruingFeeOptionMeta metaData = new AccruingFeeOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The accruing fee type for which a rate is being provided.
	 *
	 */
	AccruingFeeType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A freetext field which allows the sender to add further details around the business event.
	 *
	 */
	String getCalculationDefinition();

	/*********************** Build Methods  ***********************/
	AccruingFeeOption build();
	
	AccruingFeeOption.AccruingFeeOptionBuilder toBuilder();
	
	static AccruingFeeOption.AccruingFeeOptionBuilder builder() {
		return new AccruingFeeOption.AccruingFeeOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccruingFeeOption> getType() {
		return AccruingFeeOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processRosetta(path.newSubPath("type"), processor, AccruingFeeType.class, _getType());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("calculationDefinition"), String.class, getCalculationDefinition(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeOptionBuilder extends AccruingFeeOption, FeeRateOptionBase.FeeRateOptionBaseBuilder {
		AccruingFeeType.AccruingFeeTypeBuilder getOrCreateType();
		@Override
		AccruingFeeType.AccruingFeeTypeBuilder _getType();
		@Override
		AccruingFeeOption.AccruingFeeOptionBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		@Override
		AccruingFeeOption.AccruingFeeOptionBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		@Override
		AccruingFeeOption.AccruingFeeOptionBuilder setPaymentFrequency(Period paymentFrequency);
		@Override
		AccruingFeeOption.AccruingFeeOptionBuilder setRate(BigDecimal rate);
		AccruingFeeOption.AccruingFeeOptionBuilder setType(AccruingFeeType type);
		AccruingFeeOption.AccruingFeeOptionBuilder setStartDate(ZonedDateTime startDate);
		AccruingFeeOption.AccruingFeeOptionBuilder setEndDate(ZonedDateTime endDate);
		AccruingFeeOption.AccruingFeeOptionBuilder setCalculationDefinition(String calculationDefinition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processRosetta(path.newSubPath("type"), processor, AccruingFeeType.AccruingFeeTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("calculationDefinition"), String.class, getCalculationDefinition(), this);
		}
		

		AccruingFeeOption.AccruingFeeOptionBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeOption  ***********************/
	class AccruingFeeOptionImpl extends FeeRateOptionBase.FeeRateOptionBaseImpl implements AccruingFeeOption {
		private final AccruingFeeType type;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final String calculationDefinition;
		
		protected AccruingFeeOptionImpl(AccruingFeeOption.AccruingFeeOptionBuilder builder) {
			super(builder);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.calculationDefinition = builder.getCalculationDefinition();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public AccruingFeeType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("calculationDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDefinition")
		public String getCalculationDefinition() {
			return calculationDefinition;
		}
		
		@Override
		public AccruingFeeOption build() {
			return this;
		}
		
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder toBuilder() {
			AccruingFeeOption.AccruingFeeOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeOption.AccruingFeeOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getCalculationDefinition()).ifPresent(builder::setCalculationDefinition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeOption _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(calculationDefinition, _that.getCalculationDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (calculationDefinition != null ? calculationDefinition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeOption {" +
				"type=" + this.type + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"calculationDefinition=" + this.calculationDefinition +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeOption  ***********************/
	class AccruingFeeOptionBuilderImpl extends FeeRateOptionBase.FeeRateOptionBaseBuilderImpl implements AccruingFeeOption.AccruingFeeOptionBuilder {
	
		protected AccruingFeeType.AccruingFeeTypeBuilder type;
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected String calculationDefinition;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public AccruingFeeType.AccruingFeeTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder getOrCreateType() {
			AccruingFeeType.AccruingFeeTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = AccruingFeeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("calculationDefinition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDefinition")
		public String getCalculationDefinition() {
			return calculationDefinition;
		}
		
		@RosettaAttribute("accrualOptionId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualOptionId")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setAccrualOptionId(AccrualTypeId _accrualOptionId) {
			this.accrualOptionId = _accrualOptionId == null ? null : _accrualOptionId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setType(AccruingFeeType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("calculationDefinition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDefinition")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder setCalculationDefinition(String _calculationDefinition) {
			this.calculationDefinition = _calculationDefinition == null ? null : _calculationDefinition;
			return this;
		}
		
		@Override
		public AccruingFeeOption build() {
			return new AccruingFeeOption.AccruingFeeOptionImpl(this);
		}
		
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getCalculationDefinition()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AccruingFeeOption.AccruingFeeOptionBuilder o = (AccruingFeeOption.AccruingFeeOptionBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getCalculationDefinition(), o.getCalculationDefinition(), this::setCalculationDefinition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeOption _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(calculationDefinition, _that.getCalculationDefinition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (calculationDefinition != null ? calculationDefinition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeOptionBuilder {" +
				"type=" + this.type + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"calculationDefinition=" + this.calculationDefinition +
			'}' + " " + super.toString();
		}
	}
}
