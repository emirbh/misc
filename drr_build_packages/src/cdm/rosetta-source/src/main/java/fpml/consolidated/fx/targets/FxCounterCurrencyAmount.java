package fpml.consolidated.fx.targets;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.fx.targets.meta.FxCounterCurrencyAmountMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NonNegativeStep;
import java.math.BigDecimal;
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
@RosettaDataType(value="FxCounterCurrencyAmount", builder=FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxCounterCurrencyAmount", model="fpml", builder=FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilderImpl.class, version="2.1.1")
public interface FxCounterCurrencyAmount extends NonNegativeAmountSchedule {

	FxCounterCurrencyAmountMeta metaData = new FxCounterCurrencyAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision In case of multiple counter currency notionals, a strike reference to the appropriate strike may be provided.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision In case of multiple counter currency notionals, a strike reference to the appropriate strike may be provided.
	 *
	 */
	FxStrikeReference getStrikeReference();

	/*********************** Build Methods  ***********************/
	FxCounterCurrencyAmount build();
	
	FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder toBuilder();
	
	static FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder() {
		return new FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCounterCurrencyAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxCounterCurrencyAmount> getType() {
		return FxCounterCurrencyAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, NonNegativeStep.class, getStep());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.class, getStrikeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCounterCurrencyAmountBuilder extends FxCounterCurrencyAmount, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder {
		FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference();
		@Override
		FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference();
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setId(String id);
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setInitialValue(BigDecimal initialValue);
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep step);
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep step, int idx);
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(List<? extends NonNegativeStep> step);
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStep(List<? extends NonNegativeStep> step);
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setCurrency(Currency currency);
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStrikeReference(FxStrikeReference strikeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, NonNegativeStep.NonNegativeStepBuilder.class, getStep());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.FxStrikeReferenceBuilder.class, getStrikeReference());
		}
		

		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder prune();
	}

	/*********************** Immutable Implementation of FxCounterCurrencyAmount  ***********************/
	class FxCounterCurrencyAmountImpl extends NonNegativeAmountSchedule.NonNegativeAmountScheduleImpl implements FxCounterCurrencyAmount {
		private final FxStrikeReference strikeReference;
		
		protected FxCounterCurrencyAmountImpl(FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder) {
			super(builder);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxCounterCurrencyAmount build() {
			return this;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder toBuilder() {
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCounterCurrencyAmount _that = getType().cast(o);
		
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCounterCurrencyAmount {" +
				"strikeReference=" + this.strikeReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxCounterCurrencyAmount  ***********************/
	class FxCounterCurrencyAmountBuilderImpl extends NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilderImpl implements FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder {
	
		protected FxStrikeReference.FxStrikeReferenceBuilder strikeReference;
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxStrikeReference.FxStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxStrikeReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(NonNegativeStep _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder addStep(List<? extends NonNegativeStep> steps) {
			if (steps != null) {
				for (final NonNegativeStep toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("step")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStep(List<? extends NonNegativeStep> steps) {
			if (steps == null) {
				this.step = new ArrayList<>();
			} else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder setStrikeReference(FxStrikeReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@Override
		public FxCounterCurrencyAmount build() {
			return new FxCounterCurrencyAmount.FxCounterCurrencyAmountImpl(this);
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder prune() {
			super.prune();
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder o = (FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder) other;
			
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCounterCurrencyAmount _that = getType().cast(o);
		
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCounterCurrencyAmountBuilder {" +
				"strikeReference=" + this.strikeReference +
			'}' + " " + super.toString();
		}
	}
}
