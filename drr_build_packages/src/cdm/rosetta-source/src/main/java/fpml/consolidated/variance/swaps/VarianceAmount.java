package fpml.consolidated.variance.swaps;

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
import fpml.consolidated.eq.shared.Variance;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.variance.swaps.meta.VarianceAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Calculation of a Variance Amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Calculation of a Variance Amount.
 *
 */
@RosettaDataType(value="VarianceAmount", builder=VarianceAmount.VarianceAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VarianceAmount", model="fpml", builder=VarianceAmount.VarianceAmountBuilderImpl.class, version="2.1.1")
public interface VarianceAmount extends CalculatedAmount {

	VarianceAmountMeta metaData = new VarianceAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies Variance.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies Variance.
	 *
	 */
	Variance getVariance();

	/*********************** Build Methods  ***********************/
	VarianceAmount build();
	
	VarianceAmount.VarianceAmountBuilder toBuilder();
	
	static VarianceAmount.VarianceAmountBuilder builder() {
		return new VarianceAmount.VarianceAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VarianceAmount> getType() {
		return VarianceAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.class, getObservationStartDate());
		processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
		processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
		processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
		processRosetta(path.newSubPath("variance"), processor, Variance.class, getVariance());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceAmountBuilder extends VarianceAmount, CalculatedAmount.CalculatedAmountBuilder {
		Variance.VarianceBuilder getOrCreateVariance();
		@Override
		Variance.VarianceBuilder getVariance();
		@Override
		VarianceAmount.VarianceAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		@Override
		VarianceAmount.VarianceAmountBuilder setObservationStartDate(AdjustableOrRelativeDate observationStartDate);
		@Override
		VarianceAmount.VarianceAmountBuilder setOptionsExchangeDividends(Boolean optionsExchangeDividends);
		@Override
		VarianceAmount.VarianceAmountBuilder setAdditionalDividends(Boolean additionalDividends);
		@Override
		VarianceAmount.VarianceAmountBuilder setAllDividends(Boolean allDividends);
		VarianceAmount.VarianceAmountBuilder setVariance(Variance variance);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("observationStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getObservationStartDate());
			processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
			processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
			processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
			processRosetta(path.newSubPath("variance"), processor, Variance.VarianceBuilder.class, getVariance());
		}
		

		VarianceAmount.VarianceAmountBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceAmount  ***********************/
	class VarianceAmountImpl extends CalculatedAmount.CalculatedAmountImpl implements VarianceAmount {
		private final Variance variance;
		
		protected VarianceAmountImpl(VarianceAmount.VarianceAmountBuilder builder) {
			super(builder);
			this.variance = ofNullable(builder.getVariance()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("variance")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("variance")
		public Variance getVariance() {
			return variance;
		}
		
		@Override
		public VarianceAmount build() {
			return this;
		}
		
		@Override
		public VarianceAmount.VarianceAmountBuilder toBuilder() {
			VarianceAmount.VarianceAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceAmount.VarianceAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVariance()).ifPresent(builder::setVariance);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceAmount _that = getType().cast(o);
		
			if (!Objects.equals(variance, _that.getVariance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (variance != null ? variance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceAmount {" +
				"variance=" + this.variance +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceAmount  ***********************/
	class VarianceAmountBuilderImpl extends CalculatedAmount.CalculatedAmountBuilderImpl implements VarianceAmount.VarianceAmountBuilder {
	
		protected Variance.VarianceBuilder variance;
		
		@Override
		@RosettaAttribute("variance")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("variance")
		public Variance.VarianceBuilder getVariance() {
			return variance;
		}
		
		@Override
		public Variance.VarianceBuilder getOrCreateVariance() {
			Variance.VarianceBuilder result;
			if (variance!=null) {
				result = variance;
			}
			else {
				result = variance = Variance.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public VarianceAmount.VarianceAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("observationStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationStartDate")
		@Override
		public VarianceAmount.VarianceAmountBuilder setObservationStartDate(AdjustableOrRelativeDate _observationStartDate) {
			this.observationStartDate = _observationStartDate == null ? null : _observationStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionsExchangeDividends")
		@Override
		public VarianceAmount.VarianceAmountBuilder setOptionsExchangeDividends(Boolean _optionsExchangeDividends) {
			this.optionsExchangeDividends = _optionsExchangeDividends == null ? null : _optionsExchangeDividends;
			return this;
		}
		
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalDividends")
		@Override
		public VarianceAmount.VarianceAmountBuilder setAdditionalDividends(Boolean _additionalDividends) {
			this.additionalDividends = _additionalDividends == null ? null : _additionalDividends;
			return this;
		}
		
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allDividends")
		@Override
		public VarianceAmount.VarianceAmountBuilder setAllDividends(Boolean _allDividends) {
			this.allDividends = _allDividends == null ? null : _allDividends;
			return this;
		}
		
		@RosettaAttribute("variance")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("variance")
		@Override
		public VarianceAmount.VarianceAmountBuilder setVariance(Variance _variance) {
			this.variance = _variance == null ? null : _variance.toBuilder();
			return this;
		}
		
		@Override
		public VarianceAmount build() {
			return new VarianceAmount.VarianceAmountImpl(this);
		}
		
		@Override
		public VarianceAmount.VarianceAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceAmount.VarianceAmountBuilder prune() {
			super.prune();
			if (variance!=null && !variance.prune().hasData()) variance = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVariance()!=null && getVariance().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceAmount.VarianceAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VarianceAmount.VarianceAmountBuilder o = (VarianceAmount.VarianceAmountBuilder) other;
			
			merger.mergeRosetta(getVariance(), o.getVariance(), this::setVariance);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceAmount _that = getType().cast(o);
		
			if (!Objects.equals(variance, _that.getVariance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (variance != null ? variance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceAmountBuilder {" +
				"variance=" + this.variance +
			'}' + " " + super.toString();
		}
	}
}
