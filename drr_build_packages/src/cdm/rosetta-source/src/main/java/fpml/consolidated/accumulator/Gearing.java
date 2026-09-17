package fpml.consolidated.accumulator;

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
import fpml.consolidated.accumulator.meta.GearingMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Leverage or Gearing. Optional condition where if shares fall below trigger price, number of shares puchased increase by the gearing factor.
 *
 */
@RosettaDataType(value="Gearing", builder=Gearing.GearingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Gearing", model="fpml", builder=Gearing.GearingBuilderImpl.class, version="2.1.1")
public interface Gearing extends RosettaModelObject {

	GearingMeta metaData = new GearingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Increase in number of shares purchased.
	 *
	 */
	BigDecimal getGearingFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If specified, gearing factor applied only if share price falls below this trigger price.
	 *
	 */
	BigDecimal getLeverageTriggerPrice();

	/*********************** Build Methods  ***********************/
	Gearing build();
	
	Gearing.GearingBuilder toBuilder();
	
	static Gearing.GearingBuilder builder() {
		return new Gearing.GearingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Gearing> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Gearing> getType() {
		return Gearing.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("gearingFactor"), BigDecimal.class, getGearingFactor(), this);
		processor.processBasic(path.newSubPath("leverageTriggerPrice"), BigDecimal.class, getLeverageTriggerPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GearingBuilder extends Gearing, RosettaModelObjectBuilder {
		Gearing.GearingBuilder setGearingFactor(BigDecimal gearingFactor);
		Gearing.GearingBuilder setLeverageTriggerPrice(BigDecimal leverageTriggerPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("gearingFactor"), BigDecimal.class, getGearingFactor(), this);
			processor.processBasic(path.newSubPath("leverageTriggerPrice"), BigDecimal.class, getLeverageTriggerPrice(), this);
		}
		

		Gearing.GearingBuilder prune();
	}

	/*********************** Immutable Implementation of Gearing  ***********************/
	class GearingImpl implements Gearing {
		private final BigDecimal gearingFactor;
		private final BigDecimal leverageTriggerPrice;
		
		protected GearingImpl(Gearing.GearingBuilder builder) {
			this.gearingFactor = builder.getGearingFactor();
			this.leverageTriggerPrice = builder.getLeverageTriggerPrice();
		}
		
		@Override
		@RosettaAttribute("gearingFactor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("gearingFactor")
		public BigDecimal getGearingFactor() {
			return gearingFactor;
		}
		
		@Override
		@RosettaAttribute("leverageTriggerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leverageTriggerPrice")
		public BigDecimal getLeverageTriggerPrice() {
			return leverageTriggerPrice;
		}
		
		@Override
		public Gearing build() {
			return this;
		}
		
		@Override
		public Gearing.GearingBuilder toBuilder() {
			Gearing.GearingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Gearing.GearingBuilder builder) {
			ofNullable(getGearingFactor()).ifPresent(builder::setGearingFactor);
			ofNullable(getLeverageTriggerPrice()).ifPresent(builder::setLeverageTriggerPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Gearing _that = getType().cast(o);
		
			if (!Objects.equals(gearingFactor, _that.getGearingFactor())) return false;
			if (!Objects.equals(leverageTriggerPrice, _that.getLeverageTriggerPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (gearingFactor != null ? gearingFactor.hashCode() : 0);
			_result = 31 * _result + (leverageTriggerPrice != null ? leverageTriggerPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Gearing {" +
				"gearingFactor=" + this.gearingFactor + ", " +
				"leverageTriggerPrice=" + this.leverageTriggerPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of Gearing  ***********************/
	class GearingBuilderImpl implements Gearing.GearingBuilder {
	
		protected BigDecimal gearingFactor;
		protected BigDecimal leverageTriggerPrice;
		
		@Override
		@RosettaAttribute("gearingFactor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("gearingFactor")
		public BigDecimal getGearingFactor() {
			return gearingFactor;
		}
		
		@Override
		@RosettaAttribute("leverageTriggerPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leverageTriggerPrice")
		public BigDecimal getLeverageTriggerPrice() {
			return leverageTriggerPrice;
		}
		
		@RosettaAttribute("gearingFactor")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("gearingFactor")
		@Override
		public Gearing.GearingBuilder setGearingFactor(BigDecimal _gearingFactor) {
			this.gearingFactor = _gearingFactor == null ? null : _gearingFactor;
			return this;
		}
		
		@RosettaAttribute("leverageTriggerPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leverageTriggerPrice")
		@Override
		public Gearing.GearingBuilder setLeverageTriggerPrice(BigDecimal _leverageTriggerPrice) {
			this.leverageTriggerPrice = _leverageTriggerPrice == null ? null : _leverageTriggerPrice;
			return this;
		}
		
		@Override
		public Gearing build() {
			return new Gearing.GearingImpl(this);
		}
		
		@Override
		public Gearing.GearingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Gearing.GearingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGearingFactor()!=null) return true;
			if (getLeverageTriggerPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Gearing.GearingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Gearing.GearingBuilder o = (Gearing.GearingBuilder) other;
			
			
			merger.mergeBasic(getGearingFactor(), o.getGearingFactor(), this::setGearingFactor);
			merger.mergeBasic(getLeverageTriggerPrice(), o.getLeverageTriggerPrice(), this::setLeverageTriggerPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Gearing _that = getType().cast(o);
		
			if (!Objects.equals(gearingFactor, _that.getGearingFactor())) return false;
			if (!Objects.equals(leverageTriggerPrice, _that.getLeverageTriggerPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (gearingFactor != null ? gearingFactor.hashCode() : 0);
			_result = 31 * _result + (leverageTriggerPrice != null ? leverageTriggerPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GearingBuilder {" +
				"gearingFactor=" + this.gearingFactor + ", " +
				"leverageTriggerPrice=" + this.leverageTriggerPrice +
			'}';
		}
	}
}
