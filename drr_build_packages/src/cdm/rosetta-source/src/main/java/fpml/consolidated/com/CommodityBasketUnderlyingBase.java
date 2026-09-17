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
import fpml.consolidated.com.meta.CommodityBasketUnderlyingBaseMeta;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
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
@RosettaDataType(value="CommodityBasketUnderlyingBase", builder=CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBasketUnderlyingBase", model="fpml", builder=CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl.class, version="2.1.1")
public interface CommodityBasketUnderlyingBase extends RosettaModelObject {

	CommodityBasketUnderlyingBaseMeta metaData = new CommodityBasketUnderlyingBaseMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the role of the option buyer with regard to this underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the role of the option buyer with regard to this underlyer.
	 *
	 */
	PayerReceiverEnum getDirection();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the underlying component. At the time of the initial schema design, only underlyers of type Commodity are supported; the choice group in the future could offer the possibility of adding other types later.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the underlying component. At the time of the initial schema design, only underlyers of type Commodity are supported; the choice group in the future could offer the possibility of adding other types later.
	 *
	 */
	Commodity getCommodity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The dates on which the option will price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The dates on which the option will price.
	 *
	 */
	CommodityPricingDates getPricingDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Method of Averaging if there is more than one Pricing Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Method of Averaging if there is more than one Pricing Date.
	 *
	 */
	AveragingMethodEnum getAveragingMethod();

	/*********************** Build Methods  ***********************/
	CommodityBasketUnderlyingBase build();
	
	CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder toBuilder();
	
	static CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder() {
		return new CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketUnderlyingBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBasketUnderlyingBase> getType() {
		return CommodityBasketUnderlyingBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketUnderlyingBaseBuilder extends CommodityBasketUnderlyingBase, RosettaModelObjectBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		@Override
		Commodity.CommodityBuilder getCommodity();
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		@Override
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setId(String id);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setDirection(PayerReceiverEnum direction);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setCommodity(Commodity commodity);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		}
		

		CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketUnderlyingBase  ***********************/
	class CommodityBasketUnderlyingBaseImpl implements CommodityBasketUnderlyingBase {
		private final String id;
		private final PayerReceiverEnum direction;
		private final Commodity commodity;
		private final CommodityPricingDates pricingDates;
		private final AveragingMethodEnum averagingMethod;
		
		protected CommodityBasketUnderlyingBaseImpl(CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder) {
			this.id = builder.getId();
			this.direction = builder.getDirection();
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("direction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction")
		public PayerReceiverEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		public CommodityBasketUnderlyingBase build() {
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder toBuilder() {
			CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDirection()).ifPresent(builder::setDirection);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketUnderlyingBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingBase {" +
				"id=" + this.id + ", " +
				"direction=" + this.direction + ", " +
				"commodity=" + this.commodity + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBasketUnderlyingBase  ***********************/
	class CommodityBasketUnderlyingBaseBuilderImpl implements CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder {
	
		protected String id;
		protected PayerReceiverEnum direction;
		protected Commodity.CommodityBuilder commodity;
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected AveragingMethodEnum averagingMethod;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("direction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction")
		public PayerReceiverEnum getDirection() {
			return direction;
		}
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates() {
			CommodityPricingDates.CommodityPricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = CommodityPricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("direction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setDirection(PayerReceiverEnum _direction) {
			this.direction = _direction == null ? null : _direction;
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodity")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingDates")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingBase build() {
			return new CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl(this);
		}
		
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder prune() {
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getDirection()!=null) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder o = (CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDirection(), o.getDirection(), this::setDirection);
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketUnderlyingBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(direction, _that.getDirection())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (direction != null ? direction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingBaseBuilder {" +
				"id=" + this.id + ", " +
				"direction=" + this.direction + ", " +
				"commodity=" + this.commodity + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod +
			'}';
		}
	}
}
