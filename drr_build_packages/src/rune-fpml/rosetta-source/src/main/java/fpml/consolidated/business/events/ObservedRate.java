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
import fpml.consolidated.business.events.meta.ObservedRateMeta;
import fpml.consolidated.shared.InformationSource;
import java.math.BigDecimal;
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
@RosettaDataType(value="ObservedRate", builder=ObservedRate.ObservedRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservedRate", model="fpml", builder=ObservedRate.ObservedRateBuilderImpl.class, version="2.1.1")
public interface ObservedRate extends RosettaModelObject {

	ObservedRateMeta metaData = new ObservedRateMeta();

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
	BigDecimal getRate();
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
	ObservedRate build();
	
	ObservedRate.ObservedRateBuilder toBuilder();
	
	static ObservedRate.ObservedRateBuilder builder() {
		return new ObservedRate.ObservedRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservedRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservedRate> getType() {
		return ObservedRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservedRateBuilder extends ObservedRate, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreateInformationSource();
		@Override
		InformationSource.InformationSourceBuilder getInformationSource();
		ObservedRate.ObservedRateBuilder setRate(BigDecimal rate);
		ObservedRate.ObservedRateBuilder setDate(ZonedDateTime date);
		ObservedRate.ObservedRateBuilder setTime(LocalTime time);
		ObservedRate.ObservedRateBuilder setInformationSource(InformationSource informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processor.processBasic(path.newSubPath("time"), LocalTime.class, getTime(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
		}
		

		ObservedRate.ObservedRateBuilder prune();
	}

	/*********************** Immutable Implementation of ObservedRate  ***********************/
	class ObservedRateImpl implements ObservedRate {
		private final BigDecimal rate;
		private final ZonedDateTime date;
		private final LocalTime time;
		private final InformationSource informationSource;
		
		protected ObservedRateImpl(ObservedRate.ObservedRateBuilder builder) {
			this.rate = builder.getRate();
			this.date = builder.getDate();
			this.time = builder.getTime();
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
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
		public ObservedRate build() {
			return this;
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder toBuilder() {
			ObservedRate.ObservedRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservedRate.ObservedRateBuilder builder) {
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedRate {" +
				"rate=" + this.rate + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservedRate  ***********************/
	class ObservedRateBuilderImpl implements ObservedRate.ObservedRateBuilder {
	
		protected BigDecimal rate;
		protected ZonedDateTime date;
		protected LocalTime time;
		protected InformationSource.InformationSourceBuilder informationSource;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
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
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rate")
		@Override
		public ObservedRate.ObservedRateBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public ObservedRate.ObservedRateBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public ObservedRate.ObservedRateBuilder setTime(LocalTime _time) {
			this.time = _time == null ? null : _time;
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("informationSource")
		@Override
		public ObservedRate.ObservedRateBuilder setInformationSource(InformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@Override
		public ObservedRate build() {
			return new ObservedRate.ObservedRateImpl(this);
		}
		
		@Override
		public ObservedRate.ObservedRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedRate.ObservedRateBuilder prune() {
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRate()!=null) return true;
			if (getDate()!=null) return true;
			if (getTime()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservedRate.ObservedRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservedRate.ObservedRateBuilder o = (ObservedRate.ObservedRateBuilder) other;
			
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservedRate _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservedRateBuilder {" +
				"rate=" + this.rate + ", " +
				"date=" + this.date + ", " +
				"time=" + this.time + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}
}
