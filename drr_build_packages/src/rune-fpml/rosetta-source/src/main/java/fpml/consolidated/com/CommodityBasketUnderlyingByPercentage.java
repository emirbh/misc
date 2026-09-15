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
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.meta.CommodityBasketUnderlyingByPercentageMeta;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
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
@RosettaDataType(value="CommodityBasketUnderlyingByPercentage", builder=CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBasketUnderlyingByPercentage", model="fpml", builder=CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilderImpl.class, version="2.1.1")
public interface CommodityBasketUnderlyingByPercentage extends CommodityBasketUnderlyingBase {

	CommodityBasketUnderlyingByPercentageMeta metaData = new CommodityBasketUnderlyingByPercentageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 */
	BigDecimal getConstituentWeight();

	/*********************** Build Methods  ***********************/
	CommodityBasketUnderlyingByPercentage build();
	
	CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder toBuilder();
	
	static CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder() {
		return new CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketUnderlyingByPercentage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBasketUnderlyingByPercentage> getType() {
		return CommodityBasketUnderlyingByPercentage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("constituentWeight"), BigDecimal.class, getConstituentWeight(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketUnderlyingByPercentageBuilder extends CommodityBasketUnderlyingByPercentage, CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder {
		@Override
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setId(String id);
		@Override
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setDirection(PayerReceiverEnum direction);
		@Override
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setCommodity(Commodity commodity);
		@Override
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setPricingDates(CommodityPricingDates pricingDates);
		@Override
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setConstituentWeight(BigDecimal constituentWeight);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("constituentWeight"), BigDecimal.class, getConstituentWeight(), this);
		}
		

		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketUnderlyingByPercentage  ***********************/
	class CommodityBasketUnderlyingByPercentageImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl implements CommodityBasketUnderlyingByPercentage {
		private final BigDecimal constituentWeight;
		
		protected CommodityBasketUnderlyingByPercentageImpl(CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder) {
			super(builder);
			this.constituentWeight = builder.getConstituentWeight();
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("constituentWeight")
		public BigDecimal getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage build() {
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder toBuilder() {
			CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getConstituentWeight()).ifPresent(builder::setConstituentWeight);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByPercentage _that = getType().cast(o);
		
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByPercentage {" +
				"constituentWeight=" + this.constituentWeight +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketUnderlyingByPercentage  ***********************/
	class CommodityBasketUnderlyingByPercentageBuilderImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl implements CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder {
	
		protected BigDecimal constituentWeight;
		
		@Override
		@RosettaAttribute("constituentWeight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("constituentWeight")
		public BigDecimal getConstituentWeight() {
			return constituentWeight;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("direction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setDirection(PayerReceiverEnum _direction) {
			this.direction = _direction == null ? null : _direction;
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodity")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingDates")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("constituentWeight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("constituentWeight")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setConstituentWeight(BigDecimal _constituentWeight) {
			this.constituentWeight = _constituentWeight == null ? null : _constituentWeight;
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage build() {
			return new CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageImpl(this);
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getConstituentWeight()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder o = (CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder) other;
			
			
			merger.mergeBasic(getConstituentWeight(), o.getConstituentWeight(), this::setConstituentWeight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByPercentage _that = getType().cast(o);
		
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByPercentageBuilder {" +
				"constituentWeight=" + this.constituentWeight +
			'}' + " " + super.toString();
		}
	}
}
