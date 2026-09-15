package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.OptionFeaturesMeta;
import fpml.consolidated.option.shared.Asian;
import fpml.consolidated.option.shared.Barrier;
import fpml.consolidated.option.shared.Knock;
import fpml.consolidated.option.shared.PassThrough;
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
@RosettaDataType(value="OptionFeatures", builder=OptionFeatures.OptionFeaturesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OptionFeatures", model="fpml", builder=OptionFeatures.OptionFeaturesBuilderImpl.class, version="2.1.1")
public interface OptionFeatures extends RosettaModelObject {

	OptionFeaturesMeta metaData = new OptionFeaturesMeta();

	/*********************** Getter Methods  ***********************/
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dividend adjustment of the contract is driven by the difference between the Expected Dividend, and the Actual Dividend, which is multiplied by an agreed Factor to produce a Deviation, which is used as the basis for adjusting the contract. The parties acknowledge that in determining the Call Strike Price of the Transaction the parties have assumed that the Dividend scheduled to be paid by the Issuer to holders of record of the Shares, in the period set out in Column headed Relevant Period will equal per Share the amount stated in respect of such Relevant Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dividend adjustment of the contract is driven by the difference between the Expected Dividend, and the Actual Dividend, which is multiplied by an agreed Factor to produce a Deviation, which is used as the basis for adjusting the contract. The parties acknowledge that in determining the Call Strike Price of the Transaction the parties have assumed that the Dividend scheduled to be paid by the Issuer to holders of record of the Shares, in the period set out in Column headed Relevant Period will equal per Share the amount stated in respect of such Relevant Period.
	 *
	 */
	DividendAdjustment getDividendAdjustment();

	/*********************** Build Methods  ***********************/
	OptionFeatures build();
	
	OptionFeatures.OptionFeaturesBuilder toBuilder();
	
	static OptionFeatures.OptionFeaturesBuilder builder() {
		return new OptionFeatures.OptionFeaturesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionFeatures> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionFeatures> getType() {
		return OptionFeatures.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("asian"), processor, Asian.class, getAsian());
		processRosetta(path.newSubPath("barrier"), processor, Barrier.class, getBarrier());
		processRosetta(path.newSubPath("knock"), processor, Knock.class, getKnock());
		processRosetta(path.newSubPath("passThrough"), processor, PassThrough.class, getPassThrough());
		processRosetta(path.newSubPath("dividendAdjustment"), processor, DividendAdjustment.class, getDividendAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionFeaturesBuilder extends OptionFeatures, RosettaModelObjectBuilder {
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
		DividendAdjustment.DividendAdjustmentBuilder getOrCreateDividendAdjustment();
		@Override
		DividendAdjustment.DividendAdjustmentBuilder getDividendAdjustment();
		OptionFeatures.OptionFeaturesBuilder setAsian(Asian asian);
		OptionFeatures.OptionFeaturesBuilder setBarrier(Barrier barrier);
		OptionFeatures.OptionFeaturesBuilder setKnock(Knock knock);
		OptionFeatures.OptionFeaturesBuilder setPassThrough(PassThrough passThrough);
		OptionFeatures.OptionFeaturesBuilder setDividendAdjustment(DividendAdjustment dividendAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("asian"), processor, Asian.AsianBuilder.class, getAsian());
			processRosetta(path.newSubPath("barrier"), processor, Barrier.BarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("knock"), processor, Knock.KnockBuilder.class, getKnock());
			processRosetta(path.newSubPath("passThrough"), processor, PassThrough.PassThroughBuilder.class, getPassThrough());
			processRosetta(path.newSubPath("dividendAdjustment"), processor, DividendAdjustment.DividendAdjustmentBuilder.class, getDividendAdjustment());
		}
		

		OptionFeatures.OptionFeaturesBuilder prune();
	}

	/*********************** Immutable Implementation of OptionFeatures  ***********************/
	class OptionFeaturesImpl implements OptionFeatures {
		private final Asian asian;
		private final Barrier barrier;
		private final Knock knock;
		private final PassThrough passThrough;
		private final DividendAdjustment dividendAdjustment;
		
		protected OptionFeaturesImpl(OptionFeatures.OptionFeaturesBuilder builder) {
			this.asian = ofNullable(builder.getAsian()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
			this.knock = ofNullable(builder.getKnock()).map(f->f.build()).orElse(null);
			this.passThrough = ofNullable(builder.getPassThrough()).map(f->f.build()).orElse(null);
			this.dividendAdjustment = ofNullable(builder.getDividendAdjustment()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("dividendAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendAdjustment")
		public DividendAdjustment getDividendAdjustment() {
			return dividendAdjustment;
		}
		
		@Override
		public OptionFeatures build() {
			return this;
		}
		
		@Override
		public OptionFeatures.OptionFeaturesBuilder toBuilder() {
			OptionFeatures.OptionFeaturesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionFeatures.OptionFeaturesBuilder builder) {
			ofNullable(getAsian()).ifPresent(builder::setAsian);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getKnock()).ifPresent(builder::setKnock);
			ofNullable(getPassThrough()).ifPresent(builder::setPassThrough);
			ofNullable(getDividendAdjustment()).ifPresent(builder::setDividendAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeatures _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			if (!Objects.equals(dividendAdjustment, _that.getDividendAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			_result = 31 * _result + (dividendAdjustment != null ? dividendAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeatures {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough + ", " +
				"dividendAdjustment=" + this.dividendAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionFeatures  ***********************/
	class OptionFeaturesBuilderImpl implements OptionFeatures.OptionFeaturesBuilder {
	
		protected Asian.AsianBuilder asian;
		protected Barrier.BarrierBuilder barrier;
		protected Knock.KnockBuilder knock;
		protected PassThrough.PassThroughBuilder passThrough;
		protected DividendAdjustment.DividendAdjustmentBuilder dividendAdjustment;
		
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
		
		@Override
		@RosettaAttribute("dividendAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendAdjustment")
		public DividendAdjustment.DividendAdjustmentBuilder getDividendAdjustment() {
			return dividendAdjustment;
		}
		
		@Override
		public DividendAdjustment.DividendAdjustmentBuilder getOrCreateDividendAdjustment() {
			DividendAdjustment.DividendAdjustmentBuilder result;
			if (dividendAdjustment!=null) {
				result = dividendAdjustment;
			}
			else {
				result = dividendAdjustment = DividendAdjustment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("asian")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asian")
		@Override
		public OptionFeatures.OptionFeaturesBuilder setAsian(Asian _asian) {
			this.asian = _asian == null ? null : _asian.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public OptionFeatures.OptionFeaturesBuilder setBarrier(Barrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("knock")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knock")
		@Override
		public OptionFeatures.OptionFeaturesBuilder setKnock(Knock _knock) {
			this.knock = _knock == null ? null : _knock.toBuilder();
			return this;
		}
		
		@RosettaAttribute("passThrough")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("passThrough")
		@Override
		public OptionFeatures.OptionFeaturesBuilder setPassThrough(PassThrough _passThrough) {
			this.passThrough = _passThrough == null ? null : _passThrough.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendAdjustment")
		@Override
		public OptionFeatures.OptionFeaturesBuilder setDividendAdjustment(DividendAdjustment _dividendAdjustment) {
			this.dividendAdjustment = _dividendAdjustment == null ? null : _dividendAdjustment.toBuilder();
			return this;
		}
		
		@Override
		public OptionFeatures build() {
			return new OptionFeatures.OptionFeaturesImpl(this);
		}
		
		@Override
		public OptionFeatures.OptionFeaturesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeatures.OptionFeaturesBuilder prune() {
			if (asian!=null && !asian.prune().hasData()) asian = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (knock!=null && !knock.prune().hasData()) knock = null;
			if (passThrough!=null && !passThrough.prune().hasData()) passThrough = null;
			if (dividendAdjustment!=null && !dividendAdjustment.prune().hasData()) dividendAdjustment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsian()!=null && getAsian().hasData()) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getKnock()!=null && getKnock().hasData()) return true;
			if (getPassThrough()!=null && getPassThrough().hasData()) return true;
			if (getDividendAdjustment()!=null && getDividendAdjustment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionFeatures.OptionFeaturesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionFeatures.OptionFeaturesBuilder o = (OptionFeatures.OptionFeaturesBuilder) other;
			
			merger.mergeRosetta(getAsian(), o.getAsian(), this::setAsian);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getKnock(), o.getKnock(), this::setKnock);
			merger.mergeRosetta(getPassThrough(), o.getPassThrough(), this::setPassThrough);
			merger.mergeRosetta(getDividendAdjustment(), o.getDividendAdjustment(), this::setDividendAdjustment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionFeatures _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(passThrough, _that.getPassThrough())) return false;
			if (!Objects.equals(dividendAdjustment, _that.getDividendAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (knock != null ? knock.hashCode() : 0);
			_result = 31 * _result + (passThrough != null ? passThrough.hashCode() : 0);
			_result = 31 * _result + (dividendAdjustment != null ? dividendAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionFeaturesBuilder {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier + ", " +
				"knock=" + this.knock + ", " +
				"passThrough=" + this.passThrough + ", " +
				"dividendAdjustment=" + this.dividendAdjustment +
			'}';
		}
	}
}
