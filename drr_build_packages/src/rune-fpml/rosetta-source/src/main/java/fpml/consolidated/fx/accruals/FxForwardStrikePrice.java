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
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.accruals.meta.FxForwardStrikePriceMeta;
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
 * Provision A type that describes the rate of exchange between the two currencies of the leg of a deal.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes the rate of exchange between the two currencies of the leg of a deal.
 *
 */
@RosettaDataType(value="FxForwardStrikePrice", builder=FxForwardStrikePrice.FxForwardStrikePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxForwardStrikePrice", model="fpml", builder=FxForwardStrikePrice.FxForwardStrikePriceBuilderImpl.class, version="2.1.1")
public interface FxForwardStrikePrice extends FxAccrualStrike {

	FxForwardStrikePriceMeta metaData = new FxForwardStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Quoted Currency Pair that is used across the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Quoted Currency Pair that is used across the product.
	 *
	 */
	QuoteBasisEnum getQuoteBasis();

	/*********************** Build Methods  ***********************/
	FxForwardStrikePrice build();
	
	FxForwardStrikePrice.FxForwardStrikePriceBuilder toBuilder();
	
	static FxForwardStrikePrice.FxForwardStrikePriceBuilder builder() {
		return new FxForwardStrikePrice.FxForwardStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxForwardStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxForwardStrikePrice> getType() {
		return FxForwardStrikePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxForwardStrikePriceBuilder extends FxForwardStrikePrice, FxAccrualStrike.FxAccrualStrikeBuilder {
		@Override
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setId(String id);
		@Override
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setInitialValue(BigDecimal initialValue);
		@Override
		FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step step);
		@Override
		FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step step, int idx);
		@Override
		FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(List<? extends Step> step);
		@Override
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setStep(List<? extends Step> step);
		FxForwardStrikePrice.FxForwardStrikePriceBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		}
		

		FxForwardStrikePrice.FxForwardStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FxForwardStrikePrice  ***********************/
	class FxForwardStrikePriceImpl extends FxAccrualStrike.FxAccrualStrikeImpl implements FxForwardStrikePrice {
		private final QuoteBasisEnum quoteBasis;
		
		protected FxForwardStrikePriceImpl(FxForwardStrikePrice.FxForwardStrikePriceBuilder builder) {
			super(builder);
			this.quoteBasis = builder.getQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		public FxForwardStrikePrice build() {
			return this;
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder toBuilder() {
			FxForwardStrikePrice.FxForwardStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxForwardStrikePrice.FxForwardStrikePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardStrikePrice {" +
				"quoteBasis=" + this.quoteBasis +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxForwardStrikePrice  ***********************/
	class FxForwardStrikePriceBuilderImpl extends FxAccrualStrike.FxAccrualStrikeBuilderImpl implements FxForwardStrikePrice.FxForwardStrikePriceBuilder {
	
		protected QuoteBasisEnum quoteBasis;
		
		@Override
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder addStep(List<? extends Step> steps) {
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
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setStep(List<? extends Step> steps) {
			if (steps == null) {
				this.step = new ArrayList<>();
			} else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quoteBasis")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder setQuoteBasis(QuoteBasisEnum _quoteBasis) {
			this.quoteBasis = _quoteBasis == null ? null : _quoteBasis;
			return this;
		}
		
		@Override
		public FxForwardStrikePrice build() {
			return new FxForwardStrikePrice.FxForwardStrikePriceImpl(this);
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxForwardStrikePrice.FxForwardStrikePriceBuilder o = (FxForwardStrikePrice.FxForwardStrikePriceBuilder) other;
			
			
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxForwardStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxForwardStrikePriceBuilder {" +
				"quoteBasis=" + this.quoteBasis +
			'}' + " " + super.toString();
		}
	}
}
