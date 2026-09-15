package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.ObservedPriceMeta;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.NonNegativeMoney;
import java.time.LocalTime;
import java.time.ZonedDateTime;
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
@RosettaDataType(value="ObservedPrice", builder=ObservedPrice.ObservedPriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservedPrice", model="fpml", builder=ObservedPrice.ObservedPriceBuilderImpl.class, version="2.1.1")
public interface ObservedPrice extends RosettaModelObject {

	ObservedPriceMeta metaData = new ObservedPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The observed rate value which triggered the barrier event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The observed rate value which triggered the barrier event.
	 *
	 */
	NonNegativeMoney getPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when the rate was observed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when the rate was observed.
	 *
	 */
	ZonedDateTime getDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time when the rate ws observed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time when the rate ws observed.
	 *
	 */
	LocalTime getTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The source of the observation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The source of the observation.
	 *
	 */
	InformationSource getInformationSource();

	/*********************** Build Methods  ***********************/
	ObservedPrice build();
	
	ObservedPrice.ObservedPriceBuilder toBuilder();
	
	static ObservedPrice.ObservedPriceBuilder builder() {
		return new ObservedPrice.ObservedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservedPrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservedPrice> getType() {
		return ObservedPrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("price"), processor, NonNegativeMoney.class, getPrice());
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservedPriceBuilder extends ObservedPrice, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrice();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPrice();
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		@Override
		InformationSource.InformationSourceBuilder getInformationSource();
		ObservedPrice.ObservedPriceBuilder setPrice(NonNegativeMoney price);
		ObservedPrice.ObservedPriceBuilder setDate(ZonedDateTime date);
		ObservedPrice.ObservedPriceBuilder setTime(LocalTime time);
		ObservedPrice.ObservedPriceBuilder setInformationSource(InformationSource informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("price"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPrice());
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
		}
		

		ObservedPrice.ObservedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ObservedPrice  ***********************/
	class ObservedPriceImpl implements ObservedPrice {
		private final NonNegativeMoney price;
		private final ZonedDateTime date;
		private final LocalTime time;
		private final InformationSource informationSource;
		
		protected ObservedPriceImpl(ObservedPrice.ObservedPriceBuilder builder) {
			this.price = ofNullable(builder.getPrice()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
			this.time = builder.getTime();
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public NonNegativeMoney getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public InformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		public ObservedPrice build() {
			return this;
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder toBuilder() {
			ObservedPrice.ObservedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservedPrice.ObservedPriceBuilder builder) {
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedPrice {" +
				"price=" + this.price + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservedPrice  ***********************/
	class ObservedPriceBuilderImpl implements ObservedPrice.ObservedPriceBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder price;
		protected ZonedDateTime date;
		protected LocalTime time;
		protected InformationSource.InformationSourceBuilder informationSource;
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPrice() {
			return price;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public LocalTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("informationSource")
		public InformationSource.InformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource() {
			InformationSource.InformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public ObservedPrice.ObservedPriceBuilder setPrice(NonNegativeMoney _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public ObservedPrice.ObservedPriceBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public ObservedPrice.ObservedPriceBuilder setTime(LocalTime _time) {
			this.time = _time == null ? null : _time;
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public ObservedPrice.ObservedPriceBuilder setInformationSource(InformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@Override
		public ObservedPrice build() {
			return new ObservedPrice.ObservedPriceImpl(this);
		}
		
		@Override
		public ObservedPrice.ObservedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedPrice.ObservedPriceBuilder prune() {
			if (price!=null && !price.prune().hasData()) price = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrice()!=null && getPrice().hasData()) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedPrice.ObservedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservedPrice.ObservedPriceBuilder o = (ObservedPrice.ObservedPriceBuilder) other;
			
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedPrice _that = getType().cast(o);
		
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedPriceBuilder {" +
				"price=" + this.price + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}
}
