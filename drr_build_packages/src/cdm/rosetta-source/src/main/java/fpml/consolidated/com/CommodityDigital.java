package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityDigitalMeta;
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
 * Provision Defined the conditions under which the digital option can triggers and, if triggered, what payment results.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defined the conditions under which the digital option can triggers and, if triggered, what payment results.
 *
 */
@RosettaDataType(value="CommodityDigital", builder=CommodityDigital.CommodityDigitalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityDigital", model="fpml", builder=CommodityDigital.CommodityDigitalBuilderImpl.class, version="2.1.1")
public interface CommodityDigital extends RosettaModelObject {

	CommodityDigitalMeta metaData = new CommodityDigitalMeta();

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
	CommodityTrigger getTrigger();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The cash payment that is made when the digital barrier is breached.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The cash payment that is made when the digital barrier is breached.
	 *
	 */
	PositiveMoney getFeaturePaymentAmount();

	/*********************** Build Methods  ***********************/
	CommodityDigital build();
	
	CommodityDigital.CommodityDigitalBuilder toBuilder();
	
	static CommodityDigital.CommodityDigitalBuilder builder() {
		return new CommodityDigital.CommodityDigitalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDigital> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityDigital> getType() {
		return CommodityDigital.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.class, getTrigger());
		processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.class, getFeaturePaymentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDigitalBuilder extends CommodityDigital, RosettaModelObjectBuilder {
		CommodityTrigger.CommodityTriggerBuilder getOrCreateTrigger();
		@Override
		CommodityTrigger.CommodityTriggerBuilder getTrigger();
		PositiveMoney.PositiveMoneyBuilder getOrCreateFeaturePaymentAmount();
		@Override
		PositiveMoney.PositiveMoneyBuilder getFeaturePaymentAmount();
		CommodityDigital.CommodityDigitalBuilder setTrigger(CommodityTrigger trigger);
		CommodityDigital.CommodityDigitalBuilder setFeaturePaymentAmount(PositiveMoney featurePaymentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("trigger"), processor, CommodityTrigger.CommodityTriggerBuilder.class, getTrigger());
			processRosetta(path.newSubPath("featurePaymentAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getFeaturePaymentAmount());
		}
		

		CommodityDigital.CommodityDigitalBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDigital  ***********************/
	class CommodityDigitalImpl implements CommodityDigital {
		private final CommodityTrigger trigger;
		private final PositiveMoney featurePaymentAmount;
		
		protected CommodityDigitalImpl(CommodityDigital.CommodityDigitalBuilder builder) {
			this.trigger = ofNullable(builder.getTrigger()).map(f->f.build()).orElse(null);
			this.featurePaymentAmount = ofNullable(builder.getFeaturePaymentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trigger")
		public CommodityTrigger getTrigger() {
			return trigger;
		}
		
		@Override
		@RosettaAttribute("featurePaymentAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("featurePaymentAmount")
		public PositiveMoney getFeaturePaymentAmount() {
			return featurePaymentAmount;
		}
		
		@Override
		public CommodityDigital build() {
			return this;
		}
		
		@Override
		public CommodityDigital.CommodityDigitalBuilder toBuilder() {
			CommodityDigital.CommodityDigitalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDigital.CommodityDigitalBuilder builder) {
			ofNullable(getTrigger()).ifPresent(builder::setTrigger);
			ofNullable(getFeaturePaymentAmount()).ifPresent(builder::setFeaturePaymentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigital _that = getType().cast(o);
		
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigital {" +
				"trigger=" + this.trigger + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDigital  ***********************/
	class CommodityDigitalBuilderImpl implements CommodityDigital.CommodityDigitalBuilder {
	
		protected CommodityTrigger.CommodityTriggerBuilder trigger;
		protected PositiveMoney.PositiveMoneyBuilder featurePaymentAmount;
		
		@Override
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.GETTER)
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
		
		@RosettaAttribute("trigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trigger")
		@Override
		public CommodityDigital.CommodityDigitalBuilder setTrigger(CommodityTrigger _trigger) {
			this.trigger = _trigger == null ? null : _trigger.toBuilder();
			return this;
		}
		
		@RosettaAttribute("featurePaymentAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("featurePaymentAmount")
		@Override
		public CommodityDigital.CommodityDigitalBuilder setFeaturePaymentAmount(PositiveMoney _featurePaymentAmount) {
			this.featurePaymentAmount = _featurePaymentAmount == null ? null : _featurePaymentAmount.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDigital build() {
			return new CommodityDigital.CommodityDigitalImpl(this);
		}
		
		@Override
		public CommodityDigital.CommodityDigitalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigital.CommodityDigitalBuilder prune() {
			if (trigger!=null && !trigger.prune().hasData()) trigger = null;
			if (featurePaymentAmount!=null && !featurePaymentAmount.prune().hasData()) featurePaymentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrigger()!=null && getTrigger().hasData()) return true;
			if (getFeaturePaymentAmount()!=null && getFeaturePaymentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigital.CommodityDigitalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDigital.CommodityDigitalBuilder o = (CommodityDigital.CommodityDigitalBuilder) other;
			
			merger.mergeRosetta(getTrigger(), o.getTrigger(), this::setTrigger);
			merger.mergeRosetta(getFeaturePaymentAmount(), o.getFeaturePaymentAmount(), this::setFeaturePaymentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigital _that = getType().cast(o);
		
			if (!Objects.equals(trigger, _that.getTrigger())) return false;
			if (!Objects.equals(featurePaymentAmount, _that.getFeaturePaymentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trigger != null ? trigger.hashCode() : 0);
			_result = 31 * _result + (featurePaymentAmount != null ? featurePaymentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalBuilder {" +
				"trigger=" + this.trigger + ", " +
				"featurePaymentAmount=" + this.featurePaymentAmount +
			'}';
		}
	}
}
