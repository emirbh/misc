package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FallbackReferencePriceMeta;
import fpml.consolidated.shared.SettlementRateOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision If present indicates alternative price sources
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision If present indicates alternative price sources
 *
 */
@RosettaDataType(value="FallbackReferencePrice", builder=FallbackReferencePrice.FallbackReferencePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FallbackReferencePrice", model="fpml", builder=FallbackReferencePrice.FallbackReferencePriceBuilderImpl.class, version="2.1.1")
public interface FallbackReferencePrice extends FxFallbackReferencePrice {

	FallbackReferencePriceMeta metaData = new FallbackReferencePriceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FallbackReferencePrice build();
	
	FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder();
	
	static FallbackReferencePrice.FallbackReferencePriceBuilder builder() {
		return new FallbackReferencePrice.FallbackReferencePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FallbackReferencePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FallbackReferencePrice> getType() {
		return FallbackReferencePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.class, getSecondaryRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FallbackReferencePriceBuilder extends FallbackReferencePrice, FxFallbackReferencePrice.FxFallbackReferencePriceBuilder {
		@Override
		FallbackReferencePrice.FallbackReferencePriceBuilder setPrimaryRateSource(SettlementRateOption primaryRateSource);
		@Override
		FallbackReferencePrice.FallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource);
		@Override
		FallbackReferencePrice.FallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource, int idx);
		@Override
		FallbackReferencePrice.FallbackReferencePriceBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource);
		@Override
		FallbackReferencePrice.FallbackReferencePriceBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSecondaryRateSource());
		}
		

		FallbackReferencePrice.FallbackReferencePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FallbackReferencePrice  ***********************/
	class FallbackReferencePriceImpl extends FxFallbackReferencePrice.FxFallbackReferencePriceImpl implements FallbackReferencePrice {
		
		protected FallbackReferencePriceImpl(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			super(builder);
		}
		
		@Override
		public FallbackReferencePrice build() {
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			FallbackReferencePrice.FallbackReferencePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackReferencePrice.FallbackReferencePriceBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePrice {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FallbackReferencePrice  ***********************/
	class FallbackReferencePriceBuilderImpl extends FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl implements FallbackReferencePrice.FallbackReferencePriceBuilder {
	
		
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryRateSource")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setPrimaryRateSource(SettlementRateOption _primaryRateSource) {
			this.primaryRateSource = _primaryRateSource == null ? null : _primaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryRateSource")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption _secondaryRateSource) {
			if (_secondaryRateSource != null) {
				this.secondaryRateSource.add(_secondaryRateSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption _secondaryRateSource, int idx) {
			getIndex(this.secondaryRateSource, idx, () -> _secondaryRateSource.toBuilder());
			return this;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
			if (secondaryRateSources != null) {
				for (final SettlementRateOption toAdd : secondaryRateSources) {
					this.secondaryRateSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryRateSource")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
			if (secondaryRateSources == null) {
				this.secondaryRateSource = new ArrayList<>();
			} else {
				this.secondaryRateSource = secondaryRateSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FallbackReferencePrice build() {
			return new FallbackReferencePrice.FallbackReferencePriceImpl(this);
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FallbackReferencePrice.FallbackReferencePriceBuilder o = (FallbackReferencePrice.FallbackReferencePriceBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackReferencePriceBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
