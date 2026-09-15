package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.accruals.meta.FxOptionStrikePriceMeta;
import fpml.consolidated.shared.Step;
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
 * Provision A type that describes the rate of exchange at which the option has been struck.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes the rate of exchange at which the option has been struck.
 *
 */
@RosettaDataType(value="FxOptionStrikePrice", builder=FxOptionStrikePrice.FxOptionStrikePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxOptionStrikePrice", model="fpml", builder=FxOptionStrikePrice.FxOptionStrikePriceBuilderImpl.class, version="2.1.1")
public interface FxOptionStrikePrice extends FxAccrualStrike {

	FxOptionStrikePriceMeta metaData = new FxOptionStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which the strike rate is quoted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which the strike rate is quoted.
	 *
	 */
	StrikeQuoteBasisEnum getStrikeQuoteBasis();

	/*********************** Build Methods  ***********************/
	FxOptionStrikePrice build();
	
	FxOptionStrikePrice.FxOptionStrikePriceBuilder toBuilder();
	
	static FxOptionStrikePrice.FxOptionStrikePriceBuilder builder() {
		return new FxOptionStrikePrice.FxOptionStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxOptionStrikePrice> getType() {
		return FxOptionStrikePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("strikeQuoteBasis"), StrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionStrikePriceBuilder extends FxOptionStrikePrice, FxAccrualStrike.FxAccrualStrikeBuilder {
		@Override
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setId(String id);
		@Override
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setInitialValue(BigDecimal initialValue);
		@Override
		FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step step);
		@Override
		FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step step, int idx);
		@Override
		FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(List<? extends Step> step);
		@Override
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setStep(List<? extends Step> step);
		FxOptionStrikePrice.FxOptionStrikePriceBuilder setStrikeQuoteBasis(StrikeQuoteBasisEnum strikeQuoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("strikeQuoteBasis"), StrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
		}
		

		FxOptionStrikePrice.FxOptionStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionStrikePrice  ***********************/
	class FxOptionStrikePriceImpl extends FxAccrualStrike.FxAccrualStrikeImpl implements FxOptionStrikePrice {
		private final StrikeQuoteBasisEnum strikeQuoteBasis;
		
		protected FxOptionStrikePriceImpl(FxOptionStrikePrice.FxOptionStrikePriceBuilder builder) {
			super(builder);
			this.strikeQuoteBasis = builder.getStrikeQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strikeQuoteBasis")
		public StrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		public FxOptionStrikePrice build() {
			return this;
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder toBuilder() {
			FxOptionStrikePrice.FxOptionStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionStrikePrice.FxOptionStrikePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeQuoteBasis()).ifPresent(builder::setStrikeQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionStrikePrice {" +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOptionStrikePrice  ***********************/
	class FxOptionStrikePriceBuilderImpl extends FxAccrualStrike.FxAccrualStrikeBuilderImpl implements FxOptionStrikePrice.FxOptionStrikePriceBuilder {
	
		protected StrikeQuoteBasisEnum strikeQuoteBasis;
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("strikeQuoteBasis")
		public StrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (final Step toAdd : steps) {
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
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setStep(List<? extends Step> steps) {
			if (steps == null) {
				this.step = new ArrayList<>();
			} else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strikeQuoteBasis")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("strikeQuoteBasis")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder setStrikeQuoteBasis(StrikeQuoteBasisEnum _strikeQuoteBasis) {
			this.strikeQuoteBasis = _strikeQuoteBasis == null ? null : _strikeQuoteBasis;
			return this;
		}
		
		@Override
		public FxOptionStrikePrice build() {
			return new FxOptionStrikePrice.FxOptionStrikePriceImpl(this);
		}
		
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionStrikePrice.FxOptionStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxOptionStrikePrice.FxOptionStrikePriceBuilder o = (FxOptionStrikePrice.FxOptionStrikePriceBuilder) other;
			
			
			merger.mergeBasic(getStrikeQuoteBasis(), o.getStrikeQuoteBasis(), this::setStrikeQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionStrikePriceBuilder {" +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}' + " " + super.toString();
		}
	}
}
