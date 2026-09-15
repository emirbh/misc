package drr.base.trade.price;

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
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.meta.PricePeriodMeta;
import drr.base.util.datetime.ValuePeriodBase;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="PricePeriod", builder=PricePeriod.PricePeriodBuilderImpl.class, version="7.7.0")
@RuneDataType(value="PricePeriod", model="drr", builder=PricePeriod.PricePeriodBuilderImpl.class, version="7.7.0")
public interface PricePeriod extends ValuePeriodBase {

	PricePeriodMeta metaData = new PricePeriodMeta();

	/*********************** Getter Methods  ***********************/
	PriceFormat getPrice();

	/*********************** Build Methods  ***********************/
	PricePeriod build();
	
	PricePeriod.PricePeriodBuilder toBuilder();
	
	static PricePeriod.PricePeriodBuilder builder() {
		return new PricePeriod.PricePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricePeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricePeriod> getType() {
		return PricePeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processRosetta(path.newSubPath("price"), processor, PriceFormat.class, getPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricePeriodBuilder extends PricePeriod, ValuePeriodBase.ValuePeriodBaseBuilder {
		PriceFormat.PriceFormatBuilder getOrCreatePrice();
		@Override
		PriceFormat.PriceFormatBuilder getPrice();
		@Override
		PricePeriod.PricePeriodBuilder setEffectiveDate(Date effectiveDate);
		@Override
		PricePeriod.PricePeriodBuilder setEndDate(Date endDate);
		PricePeriod.PricePeriodBuilder setPrice(PriceFormat price);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processRosetta(path.newSubPath("price"), processor, PriceFormat.PriceFormatBuilder.class, getPrice());
		}
		

		PricePeriod.PricePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of PricePeriod  ***********************/
	class PricePeriodImpl extends ValuePeriodBase.ValuePeriodBaseImpl implements PricePeriod {
		private final PriceFormat price;
		
		protected PricePeriodImpl(PricePeriod.PricePeriodBuilder builder) {
			super(builder);
			this.price = ofNullable(builder.getPrice()).map(f->f.build()).orElse(null);
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
		public PricePeriod build() {
			return this;
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder toBuilder() {
			PricePeriod.PricePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricePeriod.PricePeriodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricePeriod _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricePeriod {" +
				"price=" + this.price +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PricePeriod  ***********************/
	class PricePeriodBuilderImpl extends ValuePeriodBase.ValuePeriodBaseBuilderImpl implements PricePeriod.PricePeriodBuilder {
	
		protected PriceFormat.PriceFormatBuilder price;
		
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
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public PricePeriod.PricePeriodBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public PricePeriod.PricePeriodBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("price")
		@Override
		public PricePeriod.PricePeriodBuilder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@Override
		public PricePeriod build() {
			return new PricePeriod.PricePeriodImpl(this);
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricePeriod.PricePeriodBuilder prune() {
			super.prune();
			if (price!=null && !price.prune().hasData()) price = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPrice()!=null && getPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricePeriod.PricePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PricePeriod.PricePeriodBuilder o = (PricePeriod.PricePeriodBuilder) other;
			
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PricePeriod _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricePeriodBuilder {" +
				"price=" + this.price +
			'}' + " " + super.toString();
		}
	}
}
