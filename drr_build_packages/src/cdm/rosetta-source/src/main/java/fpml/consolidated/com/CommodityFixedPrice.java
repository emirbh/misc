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
import fpml.consolidated.com.meta.CommodityFixedPriceMeta;
import fpml.consolidated.shared.Currency;
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
 * Provision A type defining the Commodity Fixed Price.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the Commodity Fixed Price.
 *
 */
@RosettaDataType(value="CommodityFixedPrice", builder=CommodityFixedPrice.CommodityFixedPriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityFixedPrice", model="fpml", builder=CommodityFixedPrice.CommodityFixedPriceBuilderImpl.class, version="2.1.1")
public interface CommodityFixedPrice extends RosettaModelObject {

	CommodityFixedPriceMeta metaData = new CommodityFixedPriceMeta();

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
	 * Provision The Fixed Price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Fixed Price.
	 *
	 */
	BigDecimal getPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency used to specify the fixed price or level in terms of a price per unit of commodity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency used to specify the fixed price or level in terms of a price per unit of commodity.
	 *
	 */
	Currency getPriceCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The unit of measure used to specify the fixed price or level in terms of a price per unit of commodity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The unit of measure used to specify the fixed price or level in terms of a price per unit of commodity.
	 *
	 */
	QuantityUnit getPriceUnit();

	/*********************** Build Methods  ***********************/
	CommodityFixedPrice build();
	
	CommodityFixedPrice.CommodityFixedPriceBuilder toBuilder();
	
	static CommodityFixedPrice.CommodityFixedPriceBuilder builder() {
		return new CommodityFixedPrice.CommodityFixedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFixedPrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityFixedPrice> getType() {
		return CommodityFixedPrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("priceCurrency"), processor, Currency.class, getPriceCurrency());
		processRosetta(path.newSubPath("priceUnit"), processor, QuantityUnit.class, getPriceUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFixedPriceBuilder extends CommodityFixedPrice, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreatePriceCurrency();
		@Override
		Currency.CurrencyBuilder getPriceCurrency();
		QuantityUnit.QuantityUnitBuilder getOrCreatePriceUnit();
		@Override
		QuantityUnit.QuantityUnitBuilder getPriceUnit();
		CommodityFixedPrice.CommodityFixedPriceBuilder setId(String id);
		CommodityFixedPrice.CommodityFixedPriceBuilder setPrice(BigDecimal price);
		CommodityFixedPrice.CommodityFixedPriceBuilder setPriceCurrency(Currency priceCurrency);
		CommodityFixedPrice.CommodityFixedPriceBuilder setPriceUnit(QuantityUnit priceUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("priceCurrency"), processor, Currency.CurrencyBuilder.class, getPriceCurrency());
			processRosetta(path.newSubPath("priceUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getPriceUnit());
		}
		

		CommodityFixedPrice.CommodityFixedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFixedPrice  ***********************/
	class CommodityFixedPriceImpl implements CommodityFixedPrice {
		private final String id;
		private final BigDecimal price;
		private final Currency priceCurrency;
		private final QuantityUnit priceUnit;
		
		protected CommodityFixedPriceImpl(CommodityFixedPrice.CommodityFixedPriceBuilder builder) {
			this.id = builder.getId();
			this.price = builder.getPrice();
			this.priceCurrency = ofNullable(builder.getPriceCurrency()).map(f->f.build()).orElse(null);
			this.priceUnit = ofNullable(builder.getPriceUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceCurrency")
		public Currency getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		@RosettaAttribute("priceUnit")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceUnit")
		public QuantityUnit getPriceUnit() {
			return priceUnit;
		}
		
		@Override
		public CommodityFixedPrice build() {
			return this;
		}
		
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder toBuilder() {
			CommodityFixedPrice.CommodityFixedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFixedPrice.CommodityFixedPriceBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getPriceCurrency()).ifPresent(builder::setPriceCurrency);
			ofNullable(getPriceUnit()).ifPresent(builder::setPriceUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPrice _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(priceUnit, _that.getPriceUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.hashCode() : 0);
			_result = 31 * _result + (priceUnit != null ? priceUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPrice {" +
				"id=" + this.id + ", " +
				"price=" + this.price + ", " +
				"priceCurrency=" + this.priceCurrency + ", " +
				"priceUnit=" + this.priceUnit +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFixedPrice  ***********************/
	class CommodityFixedPriceBuilderImpl implements CommodityFixedPrice.CommodityFixedPriceBuilder {
	
		protected String id;
		protected BigDecimal price;
		protected Currency.CurrencyBuilder priceCurrency;
		protected QuantityUnit.QuantityUnitBuilder priceUnit;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceCurrency")
		public Currency.CurrencyBuilder getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreatePriceCurrency() {
			Currency.CurrencyBuilder result;
			if (priceCurrency!=null) {
				result = priceCurrency;
			}
			else {
				result = priceCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceUnit")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceUnit")
		public QuantityUnit.QuantityUnitBuilder getPriceUnit() {
			return priceUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreatePriceUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (priceUnit!=null) {
				result = priceUnit;
			}
			else {
				result = priceUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("price")
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder setPrice(BigDecimal _price) {
			this.price = _price == null ? null : _price;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("priceCurrency")
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder setPriceCurrency(Currency _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceUnit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("priceUnit")
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder setPriceUnit(QuantityUnit _priceUnit) {
			this.priceUnit = _priceUnit == null ? null : _priceUnit.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFixedPrice build() {
			return new CommodityFixedPrice.CommodityFixedPriceImpl(this);
		}
		
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder prune() {
			if (priceCurrency!=null && !priceCurrency.prune().hasData()) priceCurrency = null;
			if (priceUnit!=null && !priceUnit.prune().hasData()) priceUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPrice()!=null) return true;
			if (getPriceCurrency()!=null && getPriceCurrency().hasData()) return true;
			if (getPriceUnit()!=null && getPriceUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPrice.CommodityFixedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFixedPrice.CommodityFixedPriceBuilder o = (CommodityFixedPrice.CommodityFixedPriceBuilder) other;
			
			merger.mergeRosetta(getPriceCurrency(), o.getPriceCurrency(), this::setPriceCurrency);
			merger.mergeRosetta(getPriceUnit(), o.getPriceUnit(), this::setPriceUnit);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPrice _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(priceUnit, _that.getPriceUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.hashCode() : 0);
			_result = 31 * _result + (priceUnit != null ? priceUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceBuilder {" +
				"id=" + this.id + ", " +
				"price=" + this.price + ", " +
				"priceCurrency=" + this.priceCurrency + ", " +
				"priceUnit=" + this.priceUnit +
			'}';
		}
	}
}
