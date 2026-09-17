package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxMultipleExerciseMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Describes the limits on the size of notional when multiple exercise is allowed.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes the limits on the size of notional when multiple exercise is allowed.
 *
 */
@RosettaDataType(value="FxMultipleExercise", builder=FxMultipleExercise.FxMultipleExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxMultipleExercise", model="fpml", builder=FxMultipleExercise.FxMultipleExerciseBuilderImpl.class, version="2.1.1")
public interface FxMultipleExercise extends RosettaModelObject {

	FxMultipleExerciseMeta metaData = new FxMultipleExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The minimum amount of notional that can be exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum amount of notional that can be exercised.
	 *
	 */
	NonNegativeMoney getMinimumNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum amount of notiional that can be exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum amount of notiional that can be exercised.
	 *
	 */
	NonNegativeMoney getMaximumNotionalAmount();

	/*********************** Build Methods  ***********************/
	FxMultipleExercise build();
	
	FxMultipleExercise.FxMultipleExerciseBuilder toBuilder();
	
	static FxMultipleExercise.FxMultipleExerciseBuilder builder() {
		return new FxMultipleExercise.FxMultipleExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxMultipleExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxMultipleExercise> getType() {
		return FxMultipleExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("minimumNotionalAmount"), processor, NonNegativeMoney.class, getMinimumNotionalAmount());
		processRosetta(path.newSubPath("maximumNotionalAmount"), processor, NonNegativeMoney.class, getMaximumNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxMultipleExerciseBuilder extends FxMultipleExercise, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMinimumNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getMinimumNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMaximumNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getMaximumNotionalAmount();
		FxMultipleExercise.FxMultipleExerciseBuilder setMinimumNotionalAmount(NonNegativeMoney minimumNotionalAmount);
		FxMultipleExercise.FxMultipleExerciseBuilder setMaximumNotionalAmount(NonNegativeMoney maximumNotionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("minimumNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getMinimumNotionalAmount());
			processRosetta(path.newSubPath("maximumNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getMaximumNotionalAmount());
		}
		

		FxMultipleExercise.FxMultipleExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of FxMultipleExercise  ***********************/
	class FxMultipleExerciseImpl implements FxMultipleExercise {
		private final NonNegativeMoney minimumNotionalAmount;
		private final NonNegativeMoney maximumNotionalAmount;
		
		protected FxMultipleExerciseImpl(FxMultipleExercise.FxMultipleExerciseBuilder builder) {
			this.minimumNotionalAmount = ofNullable(builder.getMinimumNotionalAmount()).map(f->f.build()).orElse(null);
			this.maximumNotionalAmount = ofNullable(builder.getMaximumNotionalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNotionalAmount")
		public NonNegativeMoney getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNotionalAmount")
		public NonNegativeMoney getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		public FxMultipleExercise build() {
			return this;
		}
		
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder toBuilder() {
			FxMultipleExercise.FxMultipleExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxMultipleExercise.FxMultipleExerciseBuilder builder) {
			ofNullable(getMinimumNotionalAmount()).ifPresent(builder::setMinimumNotionalAmount);
			ofNullable(getMaximumNotionalAmount()).ifPresent(builder::setMaximumNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxMultipleExercise {" +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"maximumNotionalAmount=" + this.maximumNotionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxMultipleExercise  ***********************/
	class FxMultipleExerciseBuilderImpl implements FxMultipleExercise.FxMultipleExerciseBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder minimumNotionalAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder maximumNotionalAmount;
		
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMinimumNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (minimumNotionalAmount!=null) {
				result = minimumNotionalAmount;
			}
			else {
				result = minimumNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMaximumNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (maximumNotionalAmount!=null) {
				result = maximumNotionalAmount;
			}
			else {
				result = maximumNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("minimumNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumNotionalAmount")
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder setMinimumNotionalAmount(NonNegativeMoney _minimumNotionalAmount) {
			this.minimumNotionalAmount = _minimumNotionalAmount == null ? null : _minimumNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("maximumNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumNotionalAmount")
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder setMaximumNotionalAmount(NonNegativeMoney _maximumNotionalAmount) {
			this.maximumNotionalAmount = _maximumNotionalAmount == null ? null : _maximumNotionalAmount.toBuilder();
			return this;
		}
		
		@Override
		public FxMultipleExercise build() {
			return new FxMultipleExercise.FxMultipleExerciseImpl(this);
		}
		
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder prune() {
			if (minimumNotionalAmount!=null && !minimumNotionalAmount.prune().hasData()) minimumNotionalAmount = null;
			if (maximumNotionalAmount!=null && !maximumNotionalAmount.prune().hasData()) maximumNotionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMinimumNotionalAmount()!=null && getMinimumNotionalAmount().hasData()) return true;
			if (getMaximumNotionalAmount()!=null && getMaximumNotionalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxMultipleExercise.FxMultipleExerciseBuilder o = (FxMultipleExercise.FxMultipleExerciseBuilder) other;
			
			merger.mergeRosetta(getMinimumNotionalAmount(), o.getMinimumNotionalAmount(), this::setMinimumNotionalAmount);
			merger.mergeRosetta(getMaximumNotionalAmount(), o.getMaximumNotionalAmount(), this::setMaximumNotionalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxMultipleExercise _that = getType().cast(o);
		
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxMultipleExerciseBuilder {" +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"maximumNotionalAmount=" + this.maximumNotionalAmount +
			'}';
		}
	}
}
