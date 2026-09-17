package fpml.consolidated.volatility.swaps;

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
import fpml.consolidated.eq.shared.CalculatedAmount;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.volatility.swaps.meta.VolatilityAmountMeta;
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
@RosettaDataType(value="VolatilityAmount", builder=VolatilityAmount.VolatilityAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilityAmount", model="fpml", builder=VolatilityAmount.VolatilityAmountBuilderImpl.class, version="2.1.1")
public interface VolatilityAmount extends CalculatedAmount {

	VolatilityAmountMeta metaData = new VolatilityAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies Volatility.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies Volatility.
	 *
	 */
	Volatility getVolatility();

	/*********************** Build Methods  ***********************/
	VolatilityAmount build();
	
	VolatilityAmount.VolatilityAmountBuilder toBuilder();
	
	static VolatilityAmount.VolatilityAmountBuilder builder() {
		return new VolatilityAmount.VolatilityAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilityAmount> getType() {
		return VolatilityAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
		processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
		processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
		processRosetta(path.newSubPath("volatility"), processor, Volatility.class, getVolatility());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityAmountBuilder extends VolatilityAmount, CalculatedAmount.CalculatedAmountBuilder {
		Volatility.VolatilityBuilder getOrCreateVolatility();
		@Override
		Volatility.VolatilityBuilder getVolatility();
		@Override
		VolatilityAmount.VolatilityAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		@Override
		VolatilityAmount.VolatilityAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		@Override
		VolatilityAmount.VolatilityAmountBuilder setOptionsExchangeDividends(Boolean optionsExchangeDividends);
		@Override
		VolatilityAmount.VolatilityAmountBuilder setAdditionalDividends(Boolean additionalDividends);
		@Override
		VolatilityAmount.VolatilityAmountBuilder setAllDividends(Boolean allDividends);
		VolatilityAmount.VolatilityAmountBuilder setVolatility(Volatility volatility);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
			processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
			processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
			processRosetta(path.newSubPath("volatility"), processor, Volatility.VolatilityBuilder.class, getVolatility());
		}
		

		VolatilityAmount.VolatilityAmountBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityAmount  ***********************/
	class VolatilityAmountImpl extends CalculatedAmount.CalculatedAmountImpl implements VolatilityAmount {
		private final Volatility volatility;
		
		protected VolatilityAmountImpl(VolatilityAmount.VolatilityAmountBuilder builder) {
			super(builder);
			this.volatility = ofNullable(builder.getVolatility()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("volatility")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("volatility")
		public Volatility getVolatility() {
			return volatility;
		}
		
		@Override
		public VolatilityAmount build() {
			return this;
		}
		
		@Override
		public VolatilityAmount.VolatilityAmountBuilder toBuilder() {
			VolatilityAmount.VolatilityAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityAmount.VolatilityAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVolatility()).ifPresent(builder::setVolatility);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityAmount _that = getType().cast(o);
		
			if (!Objects.equals(volatility, _that.getVolatility())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatility != null ? volatility.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityAmount {" +
				"volatility=" + this.volatility +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityAmount  ***********************/
	class VolatilityAmountBuilderImpl extends CalculatedAmount.CalculatedAmountBuilderImpl implements VolatilityAmount.VolatilityAmountBuilder {
	
		protected Volatility.VolatilityBuilder volatility;
		
		@Override
		@RosettaAttribute("volatility")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("volatility")
		public Volatility.VolatilityBuilder getVolatility() {
			return volatility;
		}
		
		@Override
		public Volatility.VolatilityBuilder getOrCreateVolatility() {
			Volatility.VolatilityBuilder result;
			if (volatility!=null) {
				result = volatility;
			}
			else {
				result = volatility = Volatility.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder setObservationStartDate(AdjustableOrRelativeDate _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionsExchangeDividends")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder setOptionsExchangeDividends(Boolean _optionsExchangeDividends) {
			this.optionsExchangeDividends = _optionsExchangeDividends == null ? null : _optionsExchangeDividends;
			return this;
		}
		
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalDividends")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder setAdditionalDividends(Boolean _additionalDividends) {
			this.additionalDividends = _additionalDividends == null ? null : _additionalDividends;
			return this;
		}
		
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allDividends")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder setAllDividends(Boolean _allDividends) {
			this.allDividends = _allDividends == null ? null : _allDividends;
			return this;
		}
		
		@RosettaAttribute("volatility")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("volatility")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder setVolatility(Volatility _volatility) {
			this.volatility = _volatility == null ? null : _volatility.toBuilder();
			return this;
		}
		
		@Override
		public VolatilityAmount build() {
			return new VolatilityAmount.VolatilityAmountImpl(this);
		}
		
		@Override
		public VolatilityAmount.VolatilityAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder prune() {
			super.prune();
			if (volatility!=null && !volatility.prune().hasData()) volatility = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVolatility()!=null && getVolatility().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityAmount.VolatilityAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VolatilityAmount.VolatilityAmountBuilder o = (VolatilityAmount.VolatilityAmountBuilder) other;
			
			merger.mergeRosetta(getVolatility(), o.getVolatility(), this::setVolatility);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityAmount _that = getType().cast(o);
		
			if (!Objects.equals(volatility, _that.getVolatility())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatility != null ? volatility.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityAmountBuilder {" +
				"volatility=" + this.volatility +
			'}' + " " + super.toString();
		}
	}
}
