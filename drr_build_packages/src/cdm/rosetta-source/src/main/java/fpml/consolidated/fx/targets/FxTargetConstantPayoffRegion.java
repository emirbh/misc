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
import fpml.consolidated.fx.targets.meta.FxTargetConstantPayoffRegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A fixing region in which the payoff is a constant value (a binary|digital payoff, or zero).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A fixing region in which the payoff is a constant value (a binary|digital payoff, or zero).
 *
 */
@RosettaDataType(value="FxTargetConstantPayoffRegion", builder=FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetConstantPayoffRegion", model="fpml", builder=FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilderImpl.class, version="2.1.1")
public interface FxTargetConstantPayoffRegion extends FxTargetPayoffRegion {

	FxTargetConstantPayoffRegionMeta metaData = new FxTargetConstantPayoffRegionMeta();

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
	 * Provision A binary|digital payoff, expressed either as a cash payment, or a (non-zero) fixing adjustment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A binary|digital payoff, expressed either as a cash payment, or a (non-zero) fixing adjustment.
	 *
	 */
	FxTargetConstantPayoff getPayoff();
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
	FxTargetPhysicalSettlement getPhysicalSettlement();

	/*********************** Build Methods  ***********************/
	FxTargetConstantPayoffRegion build();
	
	FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder toBuilder();
	
	static FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder() {
		return new FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetConstantPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetConstantPayoffRegion> getType() {
		return FxTargetConstantPayoffRegion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.class, getUpperBound());
		processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.class, getLowerBound());
		processRosetta(path.newSubPath("payoff"), processor, FxTargetConstantPayoff.class, getPayoff());
		processRosetta(path.newSubPath("physicalSettlement"), processor, FxTargetPhysicalSettlement.class, getPhysicalSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetConstantPayoffRegionBuilder extends FxTargetConstantPayoffRegion, FxTargetPayoffRegion.FxTargetPayoffRegionBuilder {
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound();
		@Override
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound();
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getOrCreateLowerBound();
		@Override
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getLowerBound();
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getOrCreatePayoff();
		@Override
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getPayoff();
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		@Override
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getPhysicalSettlement();
		@Override
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setId(String id);
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setUpperBound(FxTargetRegionUpperBound upperBound);
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setLowerBound(FxTargetRegionLowerBound lowerBound);
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPayoff(FxTargetConstantPayoff payoff);
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPhysicalSettlement(FxTargetPhysicalSettlement physicalSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder.class, getUpperBound());
			processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder.class, getLowerBound());
			processRosetta(path.newSubPath("payoff"), processor, FxTargetConstantPayoff.FxTargetConstantPayoffBuilder.class, getPayoff());
			processRosetta(path.newSubPath("physicalSettlement"), processor, FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder.class, getPhysicalSettlement());
		}
		

		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetConstantPayoffRegion  ***********************/
	class FxTargetConstantPayoffRegionImpl extends FxTargetPayoffRegion.FxTargetPayoffRegionImpl implements FxTargetConstantPayoffRegion {
		private final FxTargetRegionUpperBound upperBound;
		private final FxTargetRegionLowerBound lowerBound;
		private final FxTargetConstantPayoff payoff;
		private final FxTargetPhysicalSettlement physicalSettlement;
		
		protected FxTargetConstantPayoffRegionImpl(FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder) {
			super(builder);
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.payoff = ofNullable(builder.getPayoff()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("payoff")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoff")
		public FxTargetConstantPayoff getPayoff() {
			return payoff;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public FxTargetPhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public FxTargetConstantPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder toBuilder() {
			FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getPayoff()).ifPresent(builder::setPayoff);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetConstantPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffRegion {" +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"payoff=" + this.payoff + ", " +
				"physicalSettlement=" + this.physicalSettlement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetConstantPayoffRegion  ***********************/
	class FxTargetConstantPayoffRegionBuilderImpl extends FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl implements FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder {
	
		protected FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder upperBound;
		protected FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder lowerBound;
		protected FxTargetConstantPayoff.FxTargetConstantPayoffBuilder payoff;
		protected FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder physicalSettlement;
		
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
		@RosettaAttribute("payoff")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoff")
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getPayoff() {
			return payoff;
		}
		
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getOrCreatePayoff() {
			FxTargetConstantPayoff.FxTargetConstantPayoffBuilder result;
			if (payoff!=null) {
				result = payoff;
			}
			else {
				result = payoff = FxTargetConstantPayoff.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = FxTargetPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upperBound")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setUpperBound(FxTargetRegionUpperBound _upperBound) {
			this.upperBound = _upperBound == null ? null : _upperBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lowerBound")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setLowerBound(FxTargetRegionLowerBound _lowerBound) {
			this.lowerBound = _lowerBound == null ? null : _lowerBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payoff")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payoff")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPayoff(FxTargetConstantPayoff _payoff) {
			this.payoff = _payoff == null ? null : _payoff.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlement")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPhysicalSettlement(FxTargetPhysicalSettlement _physicalSettlement) {
			this.physicalSettlement = _physicalSettlement == null ? null : _physicalSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetConstantPayoffRegion build() {
			return new FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionImpl(this);
		}
		
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder prune() {
			super.prune();
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			if (payoff!=null && !payoff.prune().hasData()) payoff = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getPayoff()!=null && getPayoff().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder o = (FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder) other;
			
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeRosetta(getPayoff(), o.getPayoff(), this::setPayoff);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetConstantPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffRegionBuilder {" +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"payoff=" + this.payoff + ", " +
				"physicalSettlement=" + this.physicalSettlement +
			'}' + " " + super.toString();
		}
	}
}
