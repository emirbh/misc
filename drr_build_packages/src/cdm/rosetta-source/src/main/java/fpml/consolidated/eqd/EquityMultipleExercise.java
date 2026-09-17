package fpml.consolidated.eqd;

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
import fpml.consolidated.eqd.meta.EquityMultipleExerciseMeta;
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
 * Provision A type for defining the multiple exercise provisions of an American or Bermuda style equity option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the multiple exercise provisions of an American or Bermuda style equity option.
 *
 */
@RosettaDataType(value="EquityMultipleExercise", builder=EquityMultipleExercise.EquityMultipleExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityMultipleExercise", model="fpml", builder=EquityMultipleExercise.EquityMultipleExerciseBuilderImpl.class, version="2.1.1")
public interface EquityMultipleExercise extends RosettaModelObject {

	EquityMultipleExerciseMeta metaData = new EquityMultipleExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When multiple exercise is applicable and this element is present it specifies that the number of options that can be exercised on a given exercise date must either be equal to the value of this element or be an integral multiple of it.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When multiple exercise is applicable and this element is present it specifies that the number of options that can be exercised on a given exercise date must either be equal to the value of this element or be an integral multiple of it.
	 *
	 */
	BigDecimal getIntegralMultipleExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When multiple exercise is applicable this element specifies the minimum number of options that can be exercised on a given exercise date. If this element is not present then the minimum number is deemed to be 1. Its value can be a fractional number as a result of corporate actions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When multiple exercise is applicable this element specifies the minimum number of options that can be exercised on a given exercise date. If this element is not present then the minimum number is deemed to be 1. Its value can be a fractional number as a result of corporate actions.
	 *
	 */
	BigDecimal getMinimumNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision When multiple exercise is applicable this element specifies the maximum number of options that can be exercised on a given exercise date. If this element is not present then the maximum number is deemed to be the same as the number of options. Its value can be a fractional number as a result of corporate actions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When multiple exercise is applicable this element specifies the maximum number of options that can be exercised on a given exercise date. If this element is not present then the maximum number is deemed to be the same as the number of options. Its value can be a fractional number as a result of corporate actions.
	 *
	 */
	BigDecimal getMaximumNumberOfOptions();

	/*********************** Build Methods  ***********************/
	EquityMultipleExercise build();
	
	EquityMultipleExercise.EquityMultipleExerciseBuilder toBuilder();
	
	static EquityMultipleExercise.EquityMultipleExerciseBuilder builder() {
		return new EquityMultipleExercise.EquityMultipleExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityMultipleExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityMultipleExercise> getType() {
		return EquityMultipleExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("integralMultipleExercise"), BigDecimal.class, getIntegralMultipleExercise(), this);
		processor.processBasic(path.newSubPath("minimumNumberOfOptions"), BigDecimal.class, getMinimumNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("maximumNumberOfOptions"), BigDecimal.class, getMaximumNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityMultipleExerciseBuilder extends EquityMultipleExercise, RosettaModelObjectBuilder {
		EquityMultipleExercise.EquityMultipleExerciseBuilder setIntegralMultipleExercise(BigDecimal integralMultipleExercise);
		EquityMultipleExercise.EquityMultipleExerciseBuilder setMinimumNumberOfOptions(BigDecimal minimumNumberOfOptions);
		EquityMultipleExercise.EquityMultipleExerciseBuilder setMaximumNumberOfOptions(BigDecimal maximumNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("integralMultipleExercise"), BigDecimal.class, getIntegralMultipleExercise(), this);
			processor.processBasic(path.newSubPath("minimumNumberOfOptions"), BigDecimal.class, getMinimumNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("maximumNumberOfOptions"), BigDecimal.class, getMaximumNumberOfOptions(), this);
		}
		

		EquityMultipleExercise.EquityMultipleExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityMultipleExercise  ***********************/
	class EquityMultipleExerciseImpl implements EquityMultipleExercise {
		private final BigDecimal integralMultipleExercise;
		private final BigDecimal minimumNumberOfOptions;
		private final BigDecimal maximumNumberOfOptions;
		
		protected EquityMultipleExerciseImpl(EquityMultipleExercise.EquityMultipleExerciseBuilder builder) {
			this.integralMultipleExercise = builder.getIntegralMultipleExercise();
			this.minimumNumberOfOptions = builder.getMinimumNumberOfOptions();
			this.maximumNumberOfOptions = builder.getMaximumNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("integralMultipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("integralMultipleExercise")
		public BigDecimal getIntegralMultipleExercise() {
			return integralMultipleExercise;
		}
		
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNumberOfOptions")
		public BigDecimal getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNumberOfOptions")
		public BigDecimal getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@Override
		public EquityMultipleExercise build() {
			return this;
		}
		
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder toBuilder() {
			EquityMultipleExercise.EquityMultipleExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityMultipleExercise.EquityMultipleExerciseBuilder builder) {
			ofNullable(getIntegralMultipleExercise()).ifPresent(builder::setIntegralMultipleExercise);
			ofNullable(getMinimumNumberOfOptions()).ifPresent(builder::setMinimumNumberOfOptions);
			ofNullable(getMaximumNumberOfOptions()).ifPresent(builder::setMaximumNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleExercise, _that.getIntegralMultipleExercise())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleExercise != null ? integralMultipleExercise.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityMultipleExercise {" +
				"integralMultipleExercise=" + this.integralMultipleExercise + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityMultipleExercise  ***********************/
	class EquityMultipleExerciseBuilderImpl implements EquityMultipleExercise.EquityMultipleExerciseBuilder {
	
		protected BigDecimal integralMultipleExercise;
		protected BigDecimal minimumNumberOfOptions;
		protected BigDecimal maximumNumberOfOptions;
		
		@Override
		@RosettaAttribute("integralMultipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("integralMultipleExercise")
		public BigDecimal getIntegralMultipleExercise() {
			return integralMultipleExercise;
		}
		
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNumberOfOptions")
		public BigDecimal getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNumberOfOptions")
		public BigDecimal getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@RosettaAttribute("integralMultipleExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("integralMultipleExercise")
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder setIntegralMultipleExercise(BigDecimal _integralMultipleExercise) {
			this.integralMultipleExercise = _integralMultipleExercise == null ? null : _integralMultipleExercise;
			return this;
		}
		
		@RosettaAttribute("minimumNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumNumberOfOptions")
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder setMinimumNumberOfOptions(BigDecimal _minimumNumberOfOptions) {
			this.minimumNumberOfOptions = _minimumNumberOfOptions == null ? null : _minimumNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("maximumNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumNumberOfOptions")
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder setMaximumNumberOfOptions(BigDecimal _maximumNumberOfOptions) {
			this.maximumNumberOfOptions = _maximumNumberOfOptions == null ? null : _maximumNumberOfOptions;
			return this;
		}
		
		@Override
		public EquityMultipleExercise build() {
			return new EquityMultipleExercise.EquityMultipleExerciseImpl(this);
		}
		
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIntegralMultipleExercise()!=null) return true;
			if (getMinimumNumberOfOptions()!=null) return true;
			if (getMaximumNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityMultipleExercise.EquityMultipleExerciseBuilder o = (EquityMultipleExercise.EquityMultipleExerciseBuilder) other;
			
			
			merger.mergeBasic(getIntegralMultipleExercise(), o.getIntegralMultipleExercise(), this::setIntegralMultipleExercise);
			merger.mergeBasic(getMinimumNumberOfOptions(), o.getMinimumNumberOfOptions(), this::setMinimumNumberOfOptions);
			merger.mergeBasic(getMaximumNumberOfOptions(), o.getMaximumNumberOfOptions(), this::setMaximumNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(integralMultipleExercise, _that.getIntegralMultipleExercise())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (integralMultipleExercise != null ? integralMultipleExercise.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityMultipleExerciseBuilder {" +
				"integralMultipleExercise=" + this.integralMultipleExercise + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}';
		}
	}
}
