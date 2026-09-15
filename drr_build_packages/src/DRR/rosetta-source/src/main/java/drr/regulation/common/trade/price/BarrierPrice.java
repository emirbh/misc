package drr.regulation.common.trade.price;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
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
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.trade.price.meta.BarrierPriceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="BarrierPrice", builder=BarrierPrice.BarrierPriceBuilderImpl.class, version="7.7.0")
@RuneDataType(value="BarrierPrice", model="drr", builder=BarrierPrice.BarrierPriceBuilderImpl.class, version="7.7.0")
public interface BarrierPrice extends RosettaModelObject {

	BarrierPriceMeta metaData = new BarrierPriceMeta();

	/*********************** Getter Methods  ***********************/
	PriceFormat getPrice();
	PriceNotationEnum getNotation();
	ISOCurrencyCodeEnum getCurrency();

	/*********************** Build Methods  ***********************/
	BarrierPrice build();
	
	BarrierPrice.BarrierPriceBuilder toBuilder();
	
	static BarrierPrice.BarrierPriceBuilder builder() {
		return new BarrierPrice.BarrierPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BarrierPrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BarrierPrice> getType() {
		return BarrierPrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("price"), processor, PriceFormat.class, getPrice());
		processor.processBasic(path.newSubPath("notation"), PriceNotationEnum.class, getNotation(), this);
		processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BarrierPriceBuilder extends BarrierPrice, RosettaModelObjectBuilder {
		PriceFormat.PriceFormatBuilder getOrCreatePrice();
		@Override
		PriceFormat.PriceFormatBuilder getPrice();
		BarrierPrice.BarrierPriceBuilder setPrice(PriceFormat price);
		BarrierPrice.BarrierPriceBuilder setNotation(PriceNotationEnum notation);
		BarrierPrice.BarrierPriceBuilder setCurrency(ISOCurrencyCodeEnum currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("price"), processor, PriceFormat.PriceFormatBuilder.class, getPrice());
			processor.processBasic(path.newSubPath("notation"), PriceNotationEnum.class, getNotation(), this);
			processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
		}
		

		BarrierPrice.BarrierPriceBuilder prune();
	}

	/*********************** Immutable Implementation of BarrierPrice  ***********************/
	class BarrierPriceImpl implements BarrierPrice {
		private final PriceFormat price;
		private final PriceNotationEnum notation;
		private final ISOCurrencyCodeEnum currency;
		
		protected BarrierPriceImpl(BarrierPrice.BarrierPriceBuilder builder) {
			this.price = ofNullable(builder.getPrice()).map(f->f.build()).orElse(null);
			this.notation = builder.getNotation();
			this.currency = builder.getCurrency();
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("price")
		public PriceFormat getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("notation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notation")
		public PriceNotationEnum getNotation() {
			return notation;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		public BarrierPrice build() {
			return this;
		}
		
		@Override
		public BarrierPrice.BarrierPriceBuilder toBuilder() {
			BarrierPrice.BarrierPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BarrierPrice.BarrierPriceBuilder builder) {
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getNotation()).ifPresent(builder::setNotation);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BarrierPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(notation, _that.getNotation())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (notation != null ? notation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BarrierPrice {" +
				"price=" + this.price + ", " +
				"notation=" + this.notation + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of BarrierPrice  ***********************/
	class BarrierPriceBuilderImpl implements BarrierPrice.BarrierPriceBuilder {
	
		protected PriceFormat.PriceFormatBuilder price;
		protected PriceNotationEnum notation;
		protected ISOCurrencyCodeEnum currency;
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("price")
		public PriceFormat.PriceFormatBuilder getPrice() {
			return price;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePrice() {
			PriceFormat.PriceFormatBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notation")
		public PriceNotationEnum getNotation() {
			return notation;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("price")
		@Override
		public BarrierPrice.BarrierPriceBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notation")
		@Override
		public BarrierPrice.BarrierPriceBuilder setNotation(PriceNotationEnum _notation) {
			this.notation = _notation == null ? null : _notation;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public BarrierPrice.BarrierPriceBuilder setCurrency(ISOCurrencyCodeEnum _currency) {
			this.currency = _currency == null ? null : _currency;
			return this;
		}
		
		@Override
		public BarrierPrice build() {
			return new BarrierPrice.BarrierPriceImpl(this);
		}
		
		@Override
		public BarrierPrice.BarrierPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BarrierPrice.BarrierPriceBuilder prune() {
			if (price!=null && !price.prune().hasData()) price = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrice()!=null && getPrice().hasData()) return true;
			if (getNotation()!=null) return true;
			if (getCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BarrierPrice.BarrierPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BarrierPrice.BarrierPriceBuilder o = (BarrierPrice.BarrierPriceBuilder) other;
			
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			
			merger.mergeBasic(getNotation(), o.getNotation(), this::setNotation);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BarrierPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(notation, _that.getNotation())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (notation != null ? notation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BarrierPriceBuilder {" +
				"price=" + this.price + ", " +
				"notation=" + this.notation + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
