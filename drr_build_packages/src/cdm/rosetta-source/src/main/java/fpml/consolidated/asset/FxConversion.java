package fpml.consolidated.asset;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.meta.FxConversionMeta;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.FxRate;
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
@RosettaDataType(value="FxConversion", builder=FxConversion.FxConversionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxConversion", model="fpml", builder=FxConversion.FxConversionBuilderImpl.class, version="2.1.1")
public interface FxConversion extends RosettaModelObject {

	FxConversionMeta metaData = new FxConversionMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	AmountReference getAmountRelativeTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a currency conversion rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a currency conversion rate.
	 *
	 */
	List<? extends FxRate> getFxRate();

	/*********************** Build Methods  ***********************/
	FxConversion build();
	
	FxConversion.FxConversionBuilder toBuilder();
	
	static FxConversion.FxConversionBuilder builder() {
		return new FxConversion.FxConversionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxConversion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxConversion> getType() {
		return FxConversion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.class, getAmountRelativeTo());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxConversionBuilder extends FxConversion, RosettaModelObjectBuilder {
		AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo();
		@Override
		AmountReference.AmountReferenceBuilder getAmountRelativeTo();
		FxRate.FxRateBuilder getOrCreateFxRate(int index);
		@Override
		List<? extends FxRate.FxRateBuilder> getFxRate();
		FxConversion.FxConversionBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		FxConversion.FxConversionBuilder addFxRate(FxRate fxRate);
		FxConversion.FxConversionBuilder addFxRate(FxRate fxRate, int idx);
		FxConversion.FxConversionBuilder addFxRate(List<? extends FxRate> fxRate);
		FxConversion.FxConversionBuilder setFxRate(List<? extends FxRate> fxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.AmountReferenceBuilder.class, getAmountRelativeTo());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
		}
		

		FxConversion.FxConversionBuilder prune();
	}

	/*********************** Immutable Implementation of FxConversion  ***********************/
	class FxConversionImpl implements FxConversion {
		private final AmountReference amountRelativeTo;
		private final List<? extends FxRate> fxRate;
		
		protected FxConversionImpl(FxConversion.FxConversionBuilder builder) {
			this.amountRelativeTo = ofNullable(builder.getAmountRelativeTo()).map(f->f.build()).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountRelativeTo")
		public AmountReference getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxRate")
		public List<? extends FxRate> getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxConversion build() {
			return this;
		}
		
		@Override
		public FxConversion.FxConversionBuilder toBuilder() {
			FxConversion.FxConversionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxConversion.FxConversionBuilder builder) {
			ofNullable(getAmountRelativeTo()).ifPresent(builder::setAmountRelativeTo);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxConversion _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxConversion {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxConversion  ***********************/
	class FxConversionBuilderImpl implements FxConversion.FxConversionBuilder {
	
		protected AmountReference.AmountReferenceBuilder amountRelativeTo;
		protected List<FxRate.FxRateBuilder> fxRate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountRelativeTo")
		public AmountReference.AmountReferenceBuilder getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo() {
			AmountReference.AmountReferenceBuilder result;
			if (amountRelativeTo!=null) {
				result = amountRelativeTo;
			}
			else {
				result = amountRelativeTo = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fxRate")
		public List<? extends FxRate.FxRateBuilder> getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxRate.FxRateBuilder getOrCreateFxRate(int index) {
			if (fxRate==null) {
				this.fxRate = new ArrayList<>();
			}
			return getIndex(fxRate, index, () -> {
						FxRate.FxRateBuilder newFxRate = FxRate.builder();
						return newFxRate;
					});
		}
		
		@RosettaAttribute("amountRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amountRelativeTo")
		@Override
		public FxConversion.FxConversionBuilder setAmountRelativeTo(AmountReference _amountRelativeTo) {
			this.amountRelativeTo = _amountRelativeTo == null ? null : _amountRelativeTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fxRate")
		@Override
		public FxConversion.FxConversionBuilder addFxRate(FxRate _fxRate) {
			if (_fxRate != null) {
				this.fxRate.add(_fxRate.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxConversion.FxConversionBuilder addFxRate(FxRate _fxRate, int idx) {
			getIndex(this.fxRate, idx, () -> _fxRate.toBuilder());
			return this;
		}
		
		@Override
		public FxConversion.FxConversionBuilder addFxRate(List<? extends FxRate> fxRates) {
			if (fxRates != null) {
				for (final FxRate toAdd : fxRates) {
					this.fxRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fxRate")
		@Override
		public FxConversion.FxConversionBuilder setFxRate(List<? extends FxRate> fxRates) {
			if (fxRates == null) {
				this.fxRate = new ArrayList<>();
			} else {
				this.fxRate = fxRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxConversion build() {
			return new FxConversion.FxConversionImpl(this);
		}
		
		@Override
		public FxConversion.FxConversionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxConversion.FxConversionBuilder prune() {
			if (amountRelativeTo!=null && !amountRelativeTo.prune().hasData()) amountRelativeTo = null;
			fxRate = fxRate.stream().filter(b->b!=null).<FxRate.FxRateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmountRelativeTo()!=null && getAmountRelativeTo().hasData()) return true;
			if (getFxRate()!=null && getFxRate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxConversion.FxConversionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxConversion.FxConversionBuilder o = (FxConversion.FxConversionBuilder) other;
			
			merger.mergeRosetta(getAmountRelativeTo(), o.getAmountRelativeTo(), this::setAmountRelativeTo);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::getOrCreateFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxConversion _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!ListEquals.listEquals(fxRate, _that.getFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxConversionBuilder {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"fxRate=" + this.fxRate +
			'}';
		}
	}
}
