package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxTargetAccumulationRegionMeta;
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
@RosettaDataType(value="FxTargetAccumulationRegion", builder=FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetAccumulationRegion", model="fpml", builder=FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilderImpl.class, version="2.1.1")
public interface FxTargetAccumulationRegion extends RosettaModelObject {

	FxTargetAccumulationRegionMeta metaData = new FxTargetAccumulationRegionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the upper bound of a payoff region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the upper bound of a payoff region.
	 *
	 */
	FxTargetRegionUpperBound getUpperBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the lower bound of a payoff region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the lower bound of a payoff region.
	 *
	 */
	FxTargetRegionLowerBound getLowerBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This is the factor that increases gain, not notional. Used to support Accelerated TARFs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This is the factor that increases gain, not notional. Used to support Accelerated TARFs.
	 *
	 */
	BigDecimal getMultiplier();

	/*********************** Build Methods  ***********************/
	FxTargetAccumulationRegion build();
	
	FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder toBuilder();
	
	static FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder() {
		return new FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetAccumulationRegion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetAccumulationRegion> getType() {
		return FxTargetAccumulationRegion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.class, getUpperBound());
		processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.class, getLowerBound());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetAccumulationRegionBuilder extends FxTargetAccumulationRegion, RosettaModelObjectBuilder {
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound();
		@Override
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound();
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getOrCreateLowerBound();
		@Override
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getLowerBound();
		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setUpperBound(FxTargetRegionUpperBound upperBound);
		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setLowerBound(FxTargetRegionLowerBound lowerBound);
		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setMultiplier(BigDecimal multiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder.class, getUpperBound());
			processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder.class, getLowerBound());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		}
		

		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetAccumulationRegion  ***********************/
	class FxTargetAccumulationRegionImpl implements FxTargetAccumulationRegion {
		private final FxTargetRegionUpperBound upperBound;
		private final FxTargetRegionLowerBound lowerBound;
		private final BigDecimal multiplier;
		
		protected FxTargetAccumulationRegionImpl(FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder) {
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.multiplier = builder.getMultiplier();
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public FxTargetRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public FxTargetRegionLowerBound getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public FxTargetAccumulationRegion build() {
			return this;
		}
		
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder toBuilder() {
			FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder) {
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetAccumulationRegion _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetAccumulationRegion {" +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"multiplier=" + this.multiplier +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetAccumulationRegion  ***********************/
	class FxTargetAccumulationRegionBuilderImpl implements FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder {
	
		protected FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder upperBound;
		protected FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder lowerBound;
		protected BigDecimal multiplier;
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound() {
			FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = FxTargetRegionUpperBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getLowerBound() {
			return lowerBound;
		}
		
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getOrCreateLowerBound() {
			FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder result;
			if (lowerBound!=null) {
				result = lowerBound;
			}
			else {
				result = lowerBound = FxTargetRegionLowerBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upperBound")
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setUpperBound(FxTargetRegionUpperBound _upperBound) {
			this.upperBound = _upperBound == null ? null : _upperBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lowerBound")
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setLowerBound(FxTargetRegionLowerBound _lowerBound) {
			this.lowerBound = _lowerBound == null ? null : _lowerBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@Override
		public FxTargetAccumulationRegion build() {
			return new FxTargetAccumulationRegion.FxTargetAccumulationRegionImpl(this);
		}
		
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder prune() {
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder o = (FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder) other;
			
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetAccumulationRegion _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetAccumulationRegionBuilder {" +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"multiplier=" + this.multiplier +
			'}';
		}
	}
}
