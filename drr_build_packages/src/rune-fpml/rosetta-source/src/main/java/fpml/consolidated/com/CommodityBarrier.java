package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.com.meta.CommodityBarrierMeta;
import fpml.consolidated.fpmlenum.CommodityKnockEnum;
import fpml.consolidated.shared.PositiveMoney;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The specification of how a barrier option will trigger (that is, knock-in or knock-out) or expire based on the position of the spot rate relative to trigger level.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The specification of how a barrier option will trigger (that is, knock-in or knock-out) or expire based on the position of the spot rate relative to trigger level.
 *
 */
@RosettaDataType(value="CommodityBarrier", builder=CommodityBarrier.CommodityBarrierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBarrier", model="fpml", builder=CommodityBarrier.CommodityBarrierBuilderImpl.class, version="2.1.1")
public interface CommodityBarrier extends RosettaModelObject {

	CommodityBarrierMeta metaData = new CommodityBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The knock feature of a commodity barrier option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The knock feature of a commodity barrier option.
	 *
	 */
	CommodityKnockEnum getKnock();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision In the case of barrier options where the option automatically expires and the barrier is breached in such a way to to result in a "knock-out" vent, this amount is paid to the the option holder so as to refund or rebate a portion of any premium paid.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision In the case of barrier options where the option automatically expires and the barrier is breached in such a way to to result in a "knock-out" vent, this amount is paid to the the option holder so as to refund or rebate a portion of any premium paid.
	 *
	 */
	PositiveMoney getFeaturePaymentAmount();
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
	CommodityTrigger getTrigger();

	/*********************** Build Methods  ***********************/
	CommodityBarrier build();
	
	CommodityBarrier.CommodityBarrierBuilder toBuilder();
	
	static CommodityBarrier.CommodityBarrierBuilder builder() {
		return new CommodityBarrier.CommodityBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBarrier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBarrier> getType() {
		return CommodityBarrier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("knock"), CommodityKnockEnum.class, getKnock(), this);
		processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.class, getFeaturePaymentAmount());
		processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.class, getTrigger());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBarrierBuilder extends CommodityBarrier, RosettaModelObjectBuilder {
		PositiveMoney.PositiveMoneyBuilder getOrCreateFeaturePaymentAmount();
		@Override
		PositiveMoney.PositiveMoneyBuilder getFeaturePaymentAmount();
		CommodityTrigger.CommodityTriggerBuilder getOrCreateTrigger();
		@Override
		CommodityTrigger.CommodityTriggerBuilder getTrigger();
		CommodityBarrier.CommodityBarrierBuilder setKnock(CommodityKnockEnum knock);
		CommodityBarrier.CommodityBarrierBuilder setFeaturePaymentAmount(PositiveMoney featurePaymentAmount);
		CommodityBarrier.CommodityBarrierBuilder setTrigger(CommodityTrigger trigger);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("knock"), CommodityKnockEnum.class, getKnock(), this);
			processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getFeaturePaymentAmount());
			processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.CommodityTriggerBuilder.class, getTrigger());
		}
		

		CommodityBarrier.CommodityBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBarrier  ***********************/
	class CommodityBarrierImpl implements CommodityBarrier {
		private final CommodityKnockEnum knock;
		private final PositiveMoney featurePaymentAmount;
		private final CommodityTrigger trigger;
		
		protected CommodityBarrierImpl(CommodityBarrier.CommodityBarrierBuilder builder) {
			this.knock = builder.getKnock();
			this.featurePaymentAmount = ofNullable(builder.getFeaturePaymentAmount()).map(f->f.build()).orElse(null);
			this.trigger = ofNullable(builder.getTrigger()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("knock")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("knock")
		public CommodityKnockEnum getKnock() {
			return knock;
		}
		
		@Override
		@RosettaAttribute("featurePaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("featurePaymentAmount")
		public PositiveMoney getFeaturePaymentAmount() {
			return featurePaymentAmount;
		}
		
		@Override
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trigger")
		public CommodityTrigger getTrigger() {
			return trigger;
		}
		
		@Override
		public CommodityBarrier build() {
			return this;
		}
		
		@Override
		public CommodityBarrier.CommodityBarrierBuilder toBuilder() {
			CommodityBarrier.CommodityBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBarrier.CommodityBarrierBuilder builder) {
			ofNullable(getKnock()).ifPresent(builder::setKnock);
			ofNullable(getFeaturePaymentAmount()).ifPresent(builder::setFeaturePaymentAmount);
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBarrier _that = getType().cast(o);
		
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knock != null ? knock.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBarrier {" +
				"knock=" + this.knock + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount + ", " +
				"trigger=" + this.trigger +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBarrier  ***********************/
	class CommodityBarrierBuilderImpl implements CommodityBarrier.CommodityBarrierBuilder {
	
		protected CommodityKnockEnum knock;
		protected PositiveMoney.PositiveMoneyBuilder featurePaymentAmount;
		protected CommodityTrigger.CommodityTriggerBuilder trigger;
		
		@Override
		@RosettaAttribute("knock")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("knock")
		public CommodityKnockEnum getKnock() {
			return knock;
		}
		
		@Override
		@RosettaAttribute("featurePaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("featurePaymentAmount")
		public PositiveMoney.PositiveMoneyBuilder getFeaturePaymentAmount() {
			return featurePaymentAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateFeaturePaymentAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (featurePaymentAmount!=null) {
				result = featurePaymentAmount;
			}
			else {
				result = featurePaymentAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trigger")
		public CommodityTrigger.CommodityTriggerBuilder getTrigger() {
			return trigger;
		}
		
		@Override
		public CommodityTrigger.CommodityTriggerBuilder getOrCreateTrigger() {
			CommodityTrigger.CommodityTriggerBuilder result;
			if (trigger!=null) {
				result = trigger;
			}
			else {
				result = trigger = CommodityTrigger.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("knock")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("knock")
		@Override
		public CommodityBarrier.CommodityBarrierBuilder setKnock(CommodityKnockEnum _knock) {
			this.knock = _knock == null ? null : _knock;
			return this;
		}
		
		@RosettaAttribute("featurePaymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("featurePaymentAmount")
		@Override
		public CommodityBarrier.CommodityBarrierBuilder setFeaturePaymentAmount(PositiveMoney _featurePaymentAmount) {
			this.featurePaymentAmount = _featurePaymentAmount == null ? null : _featurePaymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("trigger")
		@Override
		public CommodityBarrier.CommodityBarrierBuilder setTrigger(CommodityTrigger _trigger) {
			this.trigger = _trigger == null ? null : _trigger.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBarrier build() {
			return new CommodityBarrier.CommodityBarrierImpl(this);
		}
		
		@Override
		public CommodityBarrier.CommodityBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBarrier.CommodityBarrierBuilder prune() {
			if (featurePaymentAmount!=null && !featurePaymentAmount.prune().hasData()) featurePaymentAmount = null;
			if (trigger!=null && !trigger.prune().hasData()) trigger = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getKnock()!=null) return true;
			if (getFeaturePaymentAmount()!=null && getFeaturePaymentAmount().hasData()) return true;
			if (getTrigger()!=null && getTrigger().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBarrier.CommodityBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBarrier.CommodityBarrierBuilder o = (CommodityBarrier.CommodityBarrierBuilder) other;
			
			merger.mergeRosetta(getFeaturePaymentAmount(), o.getFeaturePaymentAmount(), this::setFeaturePaymentAmount);
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::setTrigger);
			
			merger.mergeBasic(getKnock(), o.getKnock(), this::setKnock);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBarrier _that = getType().cast(o);
		
			if (!Objects.equals(knock, _that.getKnock())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knock != null ? knock.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBarrierBuilder {" +
				"knock=" + this.knock + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount + ", " +
				"trigger=" + this.trigger +
			'}';
		}
	}
}
