package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.CalculatedAmountMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An abstract base class for all calculated money amounts, which are in the currency of the cash multiplier of the calculation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract base class for all calculated money amounts, which are in the currency of the cash multiplier of the calculation.
 *
 */
@RosettaDataType(value="CalculatedAmount", builder=CalculatedAmount.CalculatedAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculatedAmount", model="fpml", builder=CalculatedAmount.CalculatedAmountBuilderImpl.class, version="2.1.1")
public interface CalculatedAmount extends RosettaModelObject {

	CalculatedAmountMeta metaData = new CalculatedAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the date on which a calculation or an observation will be performed for the purpose of calculating the amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the date on which a calculation or an observation will be performed for the purpose of calculating the amount.
	 *
	 */
	AdjustableRelativeOrPeriodicDates getCalculationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The start of the period over which observations are made which are used in the calculation Used when the observation start date differs from the trade date such as for forward starting swaps. Observation Start Date in accordance with the ISDA 2002 Equity Derivatives Definitions. Observation Period Start Date in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start of the period over which observations are made which are used in the calculation Used when the observation start date differs from the trade date such as for forward starting swaps. Observation Start Date in accordance with the ISDA 2002 Equity Derivatives Definitions. Observation Period Start Date in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 *
	 */
	AdjustableOrRelativeDate getObservationStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then options exchange dividends are applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then options exchange dividends are applicable.
	 *
	 */
	Boolean getOptionsExchangeDividends();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then additional dividends are applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then additional dividends are applicable.
	 *
	 */
	Boolean getAdditionalDividends();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Represents the European Master Confirmation value of 'All Dividends' which, when applicable, signifies that, for a given Ex-Date, the daily observed Share Price for that day is adjusted (reduced) by the cash dividend and/or the cash value of any non cash dividend per Share (including Extraordinary Dividends) declared by the Issuer. All Dividends in accordance with the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Represents the European Master Confirmation value of 'All Dividends' which, when applicable, signifies that, for a given Ex-Date, the daily observed Share Price for that day is adjusted (reduced) by the cash dividend and/or the cash value of any non cash dividend per Share (including Extraordinary Dividends) declared by the Issuer. All Dividends in accordance with the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	Boolean getAllDividends();

	/*********************** Build Methods  ***********************/
	CalculatedAmount build();
	
	CalculatedAmount.CalculatedAmountBuilder toBuilder();
	
	static CalculatedAmount.CalculatedAmountBuilder builder() {
		return new CalculatedAmount.CalculatedAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculatedAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculatedAmount> getType() {
		return CalculatedAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
		processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
		processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculatedAmountBuilder extends CalculatedAmount, RosettaModelObjectBuilder {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates();
		@Override
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateObservationStartDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getObservationStartDate();
		CalculatedAmount.CalculatedAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		CalculatedAmount.CalculatedAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		CalculatedAmount.CalculatedAmountBuilder setOptionsExchangeDividends(Boolean optionsExchangeDividends);
		CalculatedAmount.CalculatedAmountBuilder setAdditionalDividends(Boolean additionalDividends);
		CalculatedAmount.CalculatedAmountBuilder setAllDividends(Boolean allDividends);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
			processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
			processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
		}
		

		CalculatedAmount.CalculatedAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CalculatedAmount  ***********************/
	class CalculatedAmountImpl implements CalculatedAmount {
		private final AdjustableRelativeOrPeriodicDates calculationDates;
		private final AdjustableOrRelativeDate observationStartDate;
		private final Boolean optionsExchangeDividends;
		private final Boolean additionalDividends;
		private final Boolean allDividends;
		
		protected CalculatedAmountImpl(CalculatedAmount.CalculatedAmountBuilder builder) {
			this.calculationDates = ofNullable(builder.getCalculationDates()).map(f->f.build()).orElse(null);
			this.observationStartDate = ofNullable(builder.getObservationStartDate()).map(f->f.build()).orElse(null);
			this.optionsExchangeDividends = builder.getOptionsExchangeDividends();
			this.additionalDividends = builder.getAdditionalDividends();
			this.allDividends = builder.getAllDividends();
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartDate")
		public AdjustableOrRelativeDate getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionsExchangeDividends")
		public Boolean getOptionsExchangeDividends() {
			return optionsExchangeDividends;
		}
		
		@Override
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalDividends")
		public Boolean getAdditionalDividends() {
			return additionalDividends;
		}
		
		@Override
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allDividends")
		public Boolean getAllDividends() {
			return allDividends;
		}
		
		@Override
		public CalculatedAmount build() {
			return this;
		}
		
		@Override
		public CalculatedAmount.CalculatedAmountBuilder toBuilder() {
			CalculatedAmount.CalculatedAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculatedAmount.CalculatedAmountBuilder builder) {
			ofNullable(getCalculationDates()).ifPresent(builder::setCalculationDates);
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getOptionsExchangeDividends()).ifPresent(builder::setOptionsExchangeDividends);
			ofNullable(getAdditionalDividends()).ifPresent(builder::setAdditionalDividends);
			ofNullable(getAllDividends()).ifPresent(builder::setAllDividends);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(optionsExchangeDividends, _that.getOptionsExchangeDividends())) return false;
			if (!Objects.equals(additionalDividends, _that.getAdditionalDividends())) return false;
			if (!Objects.equals(allDividends, _that.getAllDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeDividends != null ? optionsExchangeDividends.hashCode() : 0);
			_result = 31 * _result + (additionalDividends != null ? additionalDividends.hashCode() : 0);
			_result = 31 * _result + (allDividends != null ? allDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedAmount {" +
				"calculationDates=" + this.calculationDates + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"optionsExchangeDividends=" + this.optionsExchangeDividends + ", " +
				"additionalDividends=" + this.additionalDividends + ", " +
				"allDividends=" + this.allDividends +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculatedAmount  ***********************/
	class CalculatedAmountBuilderImpl implements CalculatedAmount.CalculatedAmountBuilder {
	
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder calculationDates;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder observationStartDate;
		protected Boolean optionsExchangeDividends;
		protected Boolean additionalDividends;
		protected Boolean allDividends;
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (calculationDates!=null) {
				result = calculationDates;
			}
			else {
				result = calculationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationStartDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateObservationStartDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (observationStartDate!=null) {
				result = observationStartDate;
			}
			else {
				result = observationStartDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionsExchangeDividends")
		public Boolean getOptionsExchangeDividends() {
			return optionsExchangeDividends;
		}
		
		@Override
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalDividends")
		public Boolean getAdditionalDividends() {
			return additionalDividends;
		}
		
		@Override
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allDividends")
		public Boolean getAllDividends() {
			return allDividends;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder setObservationStartDate(AdjustableOrRelativeDate _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionsExchangeDividends")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder setOptionsExchangeDividends(Boolean _optionsExchangeDividends) {
			this.optionsExchangeDividends = _optionsExchangeDividends == null ? null : _optionsExchangeDividends;
			return this;
		}
		
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalDividends")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder setAdditionalDividends(Boolean _additionalDividends) {
			this.additionalDividends = _additionalDividends == null ? null : _additionalDividends;
			return this;
		}
		
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allDividends")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder setAllDividends(Boolean _allDividends) {
			this.allDividends = _allDividends == null ? null : _allDividends;
			return this;
		}
		
		@Override
		public CalculatedAmount build() {
			return new CalculatedAmount.CalculatedAmountImpl(this);
		}
		
		@Override
		public CalculatedAmount.CalculatedAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder prune() {
			if (calculationDates!=null && !calculationDates.prune().hasData()) calculationDates = null;
			if (observationStartDate!=null && !observationStartDate.prune().hasData()) observationStartDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationDates()!=null && getCalculationDates().hasData()) return true;
			if (getObservationStartDate()!=null && getObservationStartDate().hasData()) return true;
			if (getOptionsExchangeDividends()!=null) return true;
			if (getAdditionalDividends()!=null) return true;
			if (getAllDividends()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculatedAmount.CalculatedAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculatedAmount.CalculatedAmountBuilder o = (CalculatedAmount.CalculatedAmountBuilder) other;
			
			merger.mergeRosetta(getCalculationDates(), o.getCalculationDates(), this::setCalculationDates);
			merger.mergeRosetta(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			
			merger.mergeBasic(getOptionsExchangeDividends(), o.getOptionsExchangeDividends(), this::setOptionsExchangeDividends);
			merger.mergeBasic(getAdditionalDividends(), o.getAdditionalDividends(), this::setAdditionalDividends);
			merger.mergeBasic(getAllDividends(), o.getAllDividends(), this::setAllDividends);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculatedAmount _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(optionsExchangeDividends, _that.getOptionsExchangeDividends())) return false;
			if (!Objects.equals(additionalDividends, _that.getAdditionalDividends())) return false;
			if (!Objects.equals(allDividends, _that.getAllDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeDividends != null ? optionsExchangeDividends.hashCode() : 0);
			_result = 31 * _result + (additionalDividends != null ? additionalDividends.hashCode() : 0);
			_result = 31 * _result + (allDividends != null ? allDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculatedAmountBuilder {" +
				"calculationDates=" + this.calculationDates + ", " +
				"observationStartDate=" + this.observationStartDate + ", " +
				"optionsExchangeDividends=" + this.optionsExchangeDividends + ", " +
				"additionalDividends=" + this.additionalDividends + ", " +
				"allDividends=" + this.allDividends +
			'}';
		}
	}
}
