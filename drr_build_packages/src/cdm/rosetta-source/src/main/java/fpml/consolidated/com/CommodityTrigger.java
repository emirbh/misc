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
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.meta.CommodityTriggerMeta;
import fpml.consolidated.fpmlenum.TriggerTypeEnum;
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
 * Provision The barrier which, when breached, triggers the knock-in or knock-out of the barrier option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The barrier which, when breached, triggers the knock-in or knock-out of the barrier option.
 *
 */
@RosettaDataType(value="CommodityTrigger", builder=CommodityTrigger.CommodityTriggerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityTrigger", model="fpml", builder=CommodityTrigger.CommodityTriggerBuilderImpl.class, version="2.1.1")
public interface CommodityTrigger extends RosettaModelObject {

	CommodityTriggerMeta metaData = new CommodityTriggerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The amount used the specify the barrier in terms of an quantity of commodity or a change in the quantity of commodity. In confirmations this is often described as the "Strike Volume" or "Strike Quantity".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount used the specify the barrier in terms of an quantity of commodity or a change in the quantity of commodity. In confirmations this is often described as the "Strike Volume" or "Strike Quantity".
	 *
	 */
	BigDecimal getLevelQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The units (e.g. BCF) used to specify the barrier in terms of an quantity of commodity or change in the quantity of commodity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The units (e.g. BCF) used to specify the barrier in terms of an quantity of commodity or change in the quantity of commodity.
	 *
	 */
	QuantityUnit getLevelUnit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A barrier expressed as a percentage of notional quantity or commodity price level. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A barrier expressed as a percentage of notional quantity or commodity price level. A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getLevelPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A barrier expressed as a price level.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A barrier expressed as a price level.
	 *
	 */
	CommodityFixedPrice getLevelPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For barrier options: the specification of how an option will trigger or expire based on the position of the spot rate relative to the trigger level. For trades with selectable notionals: the specification of the conditions where one of the alternative notional values would apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For barrier options: the specification of how an option will trigger or expire based on the position of the spot rate relative to the trigger level. For trades with selectable notionals: the specification of the conditions where one of the alternative notional values would apply.
	 *
	 */
	TriggerTypeEnum getTriggerType();

	/*********************** Build Methods  ***********************/
	CommodityTrigger build();
	
	CommodityTrigger.CommodityTriggerBuilder toBuilder();
	
	static CommodityTrigger.CommodityTriggerBuilder builder() {
		return new CommodityTrigger.CommodityTriggerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityTrigger> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityTrigger> getType() {
		return CommodityTrigger.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("levelQuantity"), BigDecimal.class, getLevelQuantity(), this);
		processRosetta(path.newSubPath("levelUnit"), processor, QuantityUnit.class, getLevelUnit());
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processRosetta(path.newSubPath("levelPrice"), processor, CommodityFixedPrice.class, getLevelPrice());
		processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityTriggerBuilder extends CommodityTrigger, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateLevelUnit();
		@Override
		QuantityUnit.QuantityUnitBuilder getLevelUnit();
		CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateLevelPrice();
		@Override
		CommodityFixedPrice.CommodityFixedPriceBuilder getLevelPrice();
		CommodityTrigger.CommodityTriggerBuilder setLevelQuantity(BigDecimal levelQuantity);
		CommodityTrigger.CommodityTriggerBuilder setLevelUnit(QuantityUnit levelUnit);
		CommodityTrigger.CommodityTriggerBuilder setLevelPercentage(BigDecimal levelPercentage);
		CommodityTrigger.CommodityTriggerBuilder setLevelPrice(CommodityFixedPrice levelPrice);
		CommodityTrigger.CommodityTriggerBuilder setTriggerType(TriggerTypeEnum triggerType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("levelQuantity"), BigDecimal.class, getLevelQuantity(), this);
			processRosetta(path.newSubPath("levelUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getLevelUnit());
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processRosetta(path.newSubPath("levelPrice"), processor, CommodityFixedPrice.CommodityFixedPriceBuilder.class, getLevelPrice());
			processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
		}
		

		CommodityTrigger.CommodityTriggerBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityTrigger  ***********************/
	class CommodityTriggerImpl implements CommodityTrigger {
		private final BigDecimal levelQuantity;
		private final QuantityUnit levelUnit;
		private final BigDecimal levelPercentage;
		private final CommodityFixedPrice levelPrice;
		private final TriggerTypeEnum triggerType;
		
		protected CommodityTriggerImpl(CommodityTrigger.CommodityTriggerBuilder builder) {
			this.levelQuantity = builder.getLevelQuantity();
			this.levelUnit = ofNullable(builder.getLevelUnit()).map(f->f.build()).orElse(null);
			this.levelPercentage = builder.getLevelPercentage();
			this.levelPrice = ofNullable(builder.getLevelPrice()).map(f->f.build()).orElse(null);
			this.triggerType = builder.getTriggerType();
		}
		
		@Override
		@RosettaAttribute("levelQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelQuantity")
		public BigDecimal getLevelQuantity() {
			return levelQuantity;
		}
		
		@Override
		@RosettaAttribute("levelUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelUnit")
		public QuantityUnit getLevelUnit() {
			return levelUnit;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("levelPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPrice")
		public CommodityFixedPrice getLevelPrice() {
			return levelPrice;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		public CommodityTrigger build() {
			return this;
		}
		
		@Override
		public CommodityTrigger.CommodityTriggerBuilder toBuilder() {
			CommodityTrigger.CommodityTriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityTrigger.CommodityTriggerBuilder builder) {
			ofNullable(getLevelQuantity()).ifPresent(builder::setLevelQuantity);
			ofNullable(getLevelUnit()).ifPresent(builder::setLevelUnit);
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
			ofNullable(getLevelPrice()).ifPresent(builder::setLevelPrice);
			ofNullable(getTriggerType()).ifPresent(builder::setTriggerType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityTrigger _that = getType().cast(o);
		
			if (!Objects.equals(levelQuantity, _that.getLevelQuantity())) return false;
			if (!Objects.equals(levelUnit, _that.getLevelUnit())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(levelPrice, _that.getLevelPrice())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (levelQuantity != null ? levelQuantity.hashCode() : 0);
			_result = 31 * _result + (levelUnit != null ? levelUnit.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (levelPrice != null ? levelPrice.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTrigger {" +
				"levelQuantity=" + this.levelQuantity + ", " +
				"levelUnit=" + this.levelUnit + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"levelPrice=" + this.levelPrice + ", " +
				"triggerType=" + this.triggerType +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityTrigger  ***********************/
	class CommodityTriggerBuilderImpl implements CommodityTrigger.CommodityTriggerBuilder {
	
		protected BigDecimal levelQuantity;
		protected QuantityUnit.QuantityUnitBuilder levelUnit;
		protected BigDecimal levelPercentage;
		protected CommodityFixedPrice.CommodityFixedPriceBuilder levelPrice;
		protected TriggerTypeEnum triggerType;
		
		@Override
		@RosettaAttribute("levelQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelQuantity")
		public BigDecimal getLevelQuantity() {
			return levelQuantity;
		}
		
		@Override
		@RosettaAttribute("levelUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelUnit")
		public QuantityUnit.QuantityUnitBuilder getLevelUnit() {
			return levelUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateLevelUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (levelUnit!=null) {
				result = levelUnit;
			}
			else {
				result = levelUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("levelPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelPrice")
		public CommodityFixedPrice.CommodityFixedPriceBuilder getLevelPrice() {
			return levelPrice;
		}
		
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder getOrCreateLevelPrice() {
			CommodityFixedPrice.CommodityFixedPriceBuilder result;
			if (levelPrice!=null) {
				result = levelPrice;
			}
			else {
				result = levelPrice = CommodityFixedPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@RosettaAttribute("levelQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelQuantity")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder setLevelQuantity(BigDecimal _levelQuantity) {
			this.levelQuantity = _levelQuantity == null ? null : _levelQuantity;
			return this;
		}
		
		@RosettaAttribute("levelUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelUnit")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder setLevelUnit(QuantityUnit _levelUnit) {
			this.levelUnit = _levelUnit == null ? null : _levelUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("levelPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelPercentage")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder setLevelPercentage(BigDecimal _levelPercentage) {
			this.levelPercentage = _levelPercentage == null ? null : _levelPercentage;
			return this;
		}
		
		@RosettaAttribute("levelPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelPrice")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder setLevelPrice(CommodityFixedPrice _levelPrice) {
			this.levelPrice = _levelPrice == null ? null : _levelPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerType")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder setTriggerType(TriggerTypeEnum _triggerType) {
			this.triggerType = _triggerType == null ? null : _triggerType;
			return this;
		}
		
		@Override
		public CommodityTrigger build() {
			return new CommodityTrigger.CommodityTriggerImpl(this);
		}
		
		@Override
		public CommodityTrigger.CommodityTriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder prune() {
			if (levelUnit!=null && !levelUnit.prune().hasData()) levelUnit = null;
			if (levelPrice!=null && !levelPrice.prune().hasData()) levelPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLevelQuantity()!=null) return true;
			if (getLevelUnit()!=null && getLevelUnit().hasData()) return true;
			if (getLevelPercentage()!=null) return true;
			if (getLevelPrice()!=null && getLevelPrice().hasData()) return true;
			if (getTriggerType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityTrigger.CommodityTriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityTrigger.CommodityTriggerBuilder o = (CommodityTrigger.CommodityTriggerBuilder) other;
			
			merger.mergeRosetta(getLevelUnit(), o.getLevelUnit(), this::setLevelUnit);
			merger.mergeRosetta(getLevelPrice(), o.getLevelPrice(), this::setLevelPrice);
			
			merger.mergeBasic(getLevelQuantity(), o.getLevelQuantity(), this::setLevelQuantity);
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getTriggerType(), o.getTriggerType(), this::setTriggerType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityTrigger _that = getType().cast(o);
		
			if (!Objects.equals(levelQuantity, _that.getLevelQuantity())) return false;
			if (!Objects.equals(levelUnit, _that.getLevelUnit())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(levelPrice, _that.getLevelPrice())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (levelQuantity != null ? levelQuantity.hashCode() : 0);
			_result = 31 * _result + (levelUnit != null ? levelUnit.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (levelPrice != null ? levelPrice.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityTriggerBuilder {" +
				"levelQuantity=" + this.levelQuantity + ", " +
				"levelUnit=" + this.levelUnit + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"levelPrice=" + this.levelPrice + ", " +
				"triggerType=" + this.triggerType +
			'}';
		}
	}
}
