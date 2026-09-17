package fpml.consolidated.option.shared;

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
import fpml.consolidated.option.shared.meta.OptionFeatureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining option features.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining option features.
 *
 */
@RosettaDataType(value="OptionFeature", builder=OptionFeature.OptionFeatureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionFeature", model="fpml", builder=OptionFeature.OptionFeatureBuilderImpl.class, version="2.1.1")
public interface OptionFeature extends RosettaModelObject {

	OptionFeatureMeta metaData = new OptionFeatureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A quanto or composite FX feature.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A quanto or composite FX feature.
	 *
	 */
	FxFeature getFxFeature();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A simple strategy feature.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A simple strategy feature.
	 *
	 */
	StrategyFeature getStrategyFeature();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An option where and average price is taken on valuation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An option where and average price is taken on valuation.
	 *
	 */
	Asian getAsian();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An option with a barrier feature.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An option with a barrier feature.
	 *
	 */
	Barrier getBarrier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A knock feature.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A knock feature.
	 *
	 */
	Knock getKnock();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Pass through payments from the underlyer, such as dividends.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Pass through payments from the underlyer, such as dividends.
	 *
	 */
	PassThrough getPassThrough();

	/*********************** Build Methods  ***********************/
	OptionFeature build();
	
	OptionFeature.OptionFeatureBuilder toBuilder();
	
	static OptionFeature.OptionFeatureBuilder builder() {
		return new OptionFeature.OptionFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionFeature> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionFeature> getType() {
		return OptionFeature.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.class, getStrategyFeature());
		processRosetta(path.newSubPath("asian"), processor, Asian.class, getAsian());
		processRosetta(path.newSubPath("barrier"), processor, Barrier.class, getBarrier());
		processRosetta(path.newSubPath("knock"), processor, Knock.class, getKnock());
		processRosetta(path.newSubPath("passThrough"), processor, PassThrough.class, getPassThrough());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionFeatureBuilder extends OptionFeature, RosettaModelObjectBuilder {
		FxFeature.FxFeatureBuilder getOrCreateFxFeature();
		@Override
		FxFeature.FxFeatureBuilder getFxFeature();
		StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature();
		@Override
		StrategyFeature.StrategyFeatureBuilder getStrategyFeature();
		Asian.AsianBuilder getOrCreateAsian();
		@Override
		Asian.AsianBuilder getAsian();
		Barrier.BarrierBuilder getOrCreateBarrier();
		@Override
		Barrier.BarrierBuilder getBarrier();
		Knock.KnockBuilder getOrCreateKnock();
		@Override
		Knock.KnockBuilder getKnock();
		PassThrough.PassThroughBuilder getOrCreatePassThrough();
		@Override
		PassThrough.PassThroughBuilder getPassThrough();
		OptionFeature.OptionFeatureBuilder setFxFeature(FxFeature fxFeature);
		OptionFeature.OptionFeatureBuilder setStrategyFeature(StrategyFeature strategyFeature);
		OptionFeature.OptionFeatureBuilder setAsian(Asian asian);
		OptionFeature.OptionFeatureBuilder setBarrier(Barrier barrier);
		OptionFeature.OptionFeatureBuilder setKnock(Knock knock);
		OptionFeature.OptionFeatureBuilder setPassThrough(PassThrough passThrough);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("strategyFeature"), processor, StrategyFeature.StrategyFeatureBuilder.class, getStrategyFeature());
			processRosetta(path.newSubPath("asian"), processor, Asian.AsianBuilder.class, getAsian());
			processRosetta(path.newSubPath("barrier"), processor, Barrier.BarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("knock"), processor, Knock.KnockBuilder.class, getKnock());
			processRosetta(path.newSubPath("passThrough"), processor, PassThrough.PassThroughBuilder.class, getPassThrough());
		}
		

		OptionFeature.OptionFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of OptionFeature  ***********************/
	class OptionFeatureImpl implements OptionFeature {
		private final FxFeature fxFeature;
		private final StrategyFeature strategyFeature;
		private final Asian asian;
		private final Barrier barrier;
		private final Knock knock;
		private final PassThrough passThrough;
		
		protected OptionFeatureImpl(OptionFeature.OptionFeatureBuilder builder) {
			this.fxFeature = ofNullable(builder.getFxFeature()).map(f->f.build()).orElse(null);
			this.strategyFeature = ofNullable(builder.getStrategyFeature()).map(f->f.build()).orElse(null);
			this.asian = ofNullable(builder.getAsian()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
			this.knock = ofNullable(builder.getKnock()).map(f->f.build()).orElse(null);
			this.passThrough = ofNullable(builder.getPassThrough()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFeature")
		public FxFeature getFxFeature() {
			return fxFeature;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strategyFeature")
		public StrategyFeature getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		@RosettaAttribute("asian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asian")
		public Asian getAsian() {
			return asian;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public Barrier getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("knock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knock")
		public Knock getKnock() {
			return knock;
		}
		
		@Override
		@RosettaAttribute("passThrough")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("passThrough")
		public PassThrough getPassThrough() {
			return passThrough;
		}
		
		@Override
		public OptionFeature build() {
			return this;
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder toBuilder() {
			OptionFeature.OptionFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionFeature.OptionFeatureBuilder builder) {
			ofNullable(getFxFeature()).ifPresent(builder::setFxFeature);
			ofNullable(getStrategyFeature()).ifPresent(builder::setStrategyFeature);
			ofNullable(getAsian()).ifPresent(builder::setAsian);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getKnock()).ifPresent(builder::setKnock);
			ofNullable(getPassThrough()).ifPresent(builder::setPassThrough);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeature _that = getType().cast(o);
		
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeature {" +
				"fxFeature=" + this.fxFeature + ", " +
				"strategyFeature=" + this.strategyFeature + ", " +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionFeature  ***********************/
	class OptionFeatureBuilderImpl implements OptionFeature.OptionFeatureBuilder {
	
		protected FxFeature.FxFeatureBuilder fxFeature;
		protected StrategyFeature.StrategyFeatureBuilder strategyFeature;
		protected Asian.AsianBuilder asian;
		protected Barrier.BarrierBuilder barrier;
		protected Knock.KnockBuilder knock;
		protected PassThrough.PassThroughBuilder passThrough;
		
		@Override
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxFeature")
		public FxFeature.FxFeatureBuilder getFxFeature() {
			return fxFeature;
		}
		
		@Override
		public FxFeature.FxFeatureBuilder getOrCreateFxFeature() {
			FxFeature.FxFeatureBuilder result;
			if (fxFeature!=null) {
				result = fxFeature;
			}
			else {
				result = fxFeature = FxFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strategyFeature")
		public StrategyFeature.StrategyFeatureBuilder getStrategyFeature() {
			return strategyFeature;
		}
		
		@Override
		public StrategyFeature.StrategyFeatureBuilder getOrCreateStrategyFeature() {
			StrategyFeature.StrategyFeatureBuilder result;
			if (strategyFeature!=null) {
				result = strategyFeature;
			}
			else {
				result = strategyFeature = StrategyFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("asian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asian")
		public Asian.AsianBuilder getAsian() {
			return asian;
		}
		
		@Override
		public Asian.AsianBuilder getOrCreateAsian() {
			Asian.AsianBuilder result;
			if (asian!=null) {
				result = asian;
			}
			else {
				result = asian = Asian.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public Barrier.BarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public Barrier.BarrierBuilder getOrCreateBarrier() {
			Barrier.BarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = Barrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knock")
		public Knock.KnockBuilder getKnock() {
			return knock;
		}
		
		@Override
		public Knock.KnockBuilder getOrCreateKnock() {
			Knock.KnockBuilder result;
			if (knock!=null) {
				result = knock;
			}
			else {
				result = knock = Knock.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("passThrough")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("passThrough")
		public PassThrough.PassThroughBuilder getPassThrough() {
			return passThrough;
		}
		
		@Override
		public PassThrough.PassThroughBuilder getOrCreatePassThrough() {
			PassThrough.PassThroughBuilder result;
			if (passThrough!=null) {
				result = passThrough;
			}
			else {
				result = passThrough = PassThrough.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fxFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxFeature")
		@Override
		public OptionFeature.OptionFeatureBuilder setFxFeature(FxFeature _fxFeature) {
			this.fxFeature = _fxFeature == null ? null : _fxFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strategyFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strategyFeature")
		@Override
		public OptionFeature.OptionFeatureBuilder setStrategyFeature(StrategyFeature _strategyFeature) {
			this.strategyFeature = _strategyFeature == null ? null : _strategyFeature.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asian")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asian")
		@Override
		public OptionFeature.OptionFeatureBuilder setAsian(Asian _asian) {
			this.asian = _asian == null ? null : _asian.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public OptionFeature.OptionFeatureBuilder setBarrier(Barrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("knock")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knock")
		@Override
		public OptionFeature.OptionFeatureBuilder setKnock(Knock _knock) {
			this.knock = _knock == null ? null : _knock.toBuilder();
			return this;
		}
		
		@RosettaAttribute("passThrough")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("passThrough")
		@Override
		public OptionFeature.OptionFeatureBuilder setPassThrough(PassThrough _passThrough) {
			this.passThrough = _passThrough == null ? null : _passThrough.toBuilder();
			return this;
		}
		
		@Override
		public OptionFeature build() {
			return new OptionFeature.OptionFeatureImpl(this);
		}
		
		@Override
		public OptionFeature.OptionFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeature.OptionFeatureBuilder prune() {
			if (fxFeature!=null && !fxFeature.prune().hasData()) fxFeature = null;
			if (strategyFeature!=null && !strategyFeature.prune().hasData()) strategyFeature = null;
			if (asian!=null && !asian.prune().hasData()) asian = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (knock!=null && !knock.prune().hasData()) knock = null;
			if (passThrough!=null && !passThrough.prune().hasData()) passThrough = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxFeature()!=null && getFxFeature().hasData()) return true;
			if (getStrategyFeature()!=null && getStrategyFeature().hasData()) return true;
			if (getAsian()!=null && getAsian().hasData()) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getKnock()!=null && getKnock().hasData()) return true;
			if (getPassThrough()!=null && getPassThrough().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeature.OptionFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionFeature.OptionFeatureBuilder o = (OptionFeature.OptionFeatureBuilder) other;
			
			merger.mergeRosetta(getFxFeature(), o.getFxFeature(), this::setFxFeature);
			merger.mergeRosetta(getStrategyFeature(), o.getStrategyFeature(), this::setStrategyFeature);
			merger.mergeRosetta(getAsian(), o.getAsian(), this::setAsian);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getKnock(), o.getKnock(), this::setKnock);
			merger.mergeRosetta(getPassThrough(), o.getPassThrough(), this::setPassThrough);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeature _that = getType().cast(o);
		
			if (!Objects.equals(fxFeature, _that.getFxFeature())) return false;
			if (!Objects.equals(strategyFeature, _that.getStrategyFeature())) return false;
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFeature != null ? fxFeature.hashCode() : 0);
			_result = 31 * _result + (strategyFeature != null ? strategyFeature.hashCode() : 0);
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeatureBuilder {" +
				"fxFeature=" + this.fxFeature + ", " +
				"strategyFeature=" + this.strategyFeature + ", " +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough +
			'}';
		}
	}
}
