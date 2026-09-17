package fpml.consolidated.correlation.swaps;

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
import fpml.consolidated.correlation.swaps.meta.CorrelationAmountMeta;
import fpml.consolidated.eq.shared.CalculatedAmount;
import fpml.consolidated.eq.shared.Correlation;
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
 * Provision Correlation Amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Correlation Amount.
 *
 */
@RosettaDataType(value="CorrelationAmount", builder=CorrelationAmount.CorrelationAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorrelationAmount", model="fpml", builder=CorrelationAmount.CorrelationAmountBuilderImpl.class, version="2.1.1")
public interface CorrelationAmount extends CalculatedAmount {

	CorrelationAmountMeta metaData = new CorrelationAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies Correlation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies Correlation.
	 *
	 */
	Correlation getCorrelation();

	/*********************** Build Methods  ***********************/
	CorrelationAmount build();
	
	CorrelationAmount.CorrelationAmountBuilder toBuilder();
	
	static CorrelationAmount.CorrelationAmountBuilder builder() {
		return new CorrelationAmount.CorrelationAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorrelationAmount> getType() {
		return CorrelationAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
		processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
		processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
		processRosetta(path.newSubPath("correlation"), processor, Correlation.class, getCorrelation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationAmountBuilder extends CorrelationAmount, CalculatedAmount.CalculatedAmountBuilder {
		Correlation.CorrelationBuilder getOrCreateCorrelation();
		@Override
		Correlation.CorrelationBuilder getCorrelation();
		@Override
		CorrelationAmount.CorrelationAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		@Override
		CorrelationAmount.CorrelationAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		@Override
		CorrelationAmount.CorrelationAmountBuilder setOptionsExchangeDividends(Boolean optionsExchangeDividends);
		@Override
		CorrelationAmount.CorrelationAmountBuilder setAdditionalDividends(Boolean additionalDividends);
		@Override
		CorrelationAmount.CorrelationAmountBuilder setAllDividends(Boolean allDividends);
		CorrelationAmount.CorrelationAmountBuilder setCorrelation(Correlation correlation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
			processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
			processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
			processRosetta(path.newSubPath("correlation"), processor, Correlation.CorrelationBuilder.class, getCorrelation());
		}
		

		CorrelationAmount.CorrelationAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationAmount  ***********************/
	class CorrelationAmountImpl extends CalculatedAmount.CalculatedAmountImpl implements CorrelationAmount {
		private final Correlation correlation;
		
		protected CorrelationAmountImpl(CorrelationAmount.CorrelationAmountBuilder builder) {
			super(builder);
			this.correlation = ofNullable(builder.getCorrelation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlation")
		public Correlation getCorrelation() {
			return correlation;
		}
		
		@Override
		public CorrelationAmount build() {
			return this;
		}
		
		@Override
		public CorrelationAmount.CorrelationAmountBuilder toBuilder() {
			CorrelationAmount.CorrelationAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationAmount.CorrelationAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCorrelation()).ifPresent(builder::setCorrelation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationAmount _that = getType().cast(o);
		
			if (!Objects.equals(correlation, _that.getCorrelation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlation != null ? correlation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationAmount {" +
				"correlation=" + this.correlation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrelationAmount  ***********************/
	class CorrelationAmountBuilderImpl extends CalculatedAmount.CalculatedAmountBuilderImpl implements CorrelationAmount.CorrelationAmountBuilder {
	
		protected Correlation.CorrelationBuilder correlation;
		
		@Override
		@RosettaAttribute("correlation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("correlation")
		public Correlation.CorrelationBuilder getCorrelation() {
			return correlation;
		}
		
		@Override
		public Correlation.CorrelationBuilder getOrCreateCorrelation() {
			Correlation.CorrelationBuilder result;
			if (correlation!=null) {
				result = correlation;
			}
			else {
				result = correlation = Correlation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder setObservationStartDate(AdjustableOrRelativeDate _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionsExchangeDividends")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder setOptionsExchangeDividends(Boolean _optionsExchangeDividends) {
			this.optionsExchangeDividends = _optionsExchangeDividends == null ? null : _optionsExchangeDividends;
			return this;
		}
		
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalDividends")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder setAdditionalDividends(Boolean _additionalDividends) {
			this.additionalDividends = _additionalDividends == null ? null : _additionalDividends;
			return this;
		}
		
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allDividends")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder setAllDividends(Boolean _allDividends) {
			this.allDividends = _allDividends == null ? null : _allDividends;
			return this;
		}
		
		@RosettaAttribute("correlation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("correlation")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder setCorrelation(Correlation _correlation) {
			this.correlation = _correlation == null ? null : _correlation.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationAmount build() {
			return new CorrelationAmount.CorrelationAmountImpl(this);
		}
		
		@Override
		public CorrelationAmount.CorrelationAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder prune() {
			super.prune();
			if (correlation!=null && !correlation.prune().hasData()) correlation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCorrelation()!=null && getCorrelation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationAmount.CorrelationAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CorrelationAmount.CorrelationAmountBuilder o = (CorrelationAmount.CorrelationAmountBuilder) other;
			
			merger.mergeRosetta(getCorrelation(), o.getCorrelation(), this::setCorrelation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationAmount _that = getType().cast(o);
		
			if (!Objects.equals(correlation, _that.getCorrelation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (correlation != null ? correlation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationAmountBuilder {" +
				"correlation=" + this.correlation +
			'}' + " " + super.toString();
		}
	}
}
