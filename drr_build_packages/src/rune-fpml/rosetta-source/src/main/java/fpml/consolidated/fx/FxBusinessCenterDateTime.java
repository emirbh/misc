package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxBusinessCenterDateTimeMeta;
import fpml.consolidated.shared.BusinessCenterTime;
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
@RosettaDataType(value="FxBusinessCenterDateTime", builder=FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxBusinessCenterDateTime", model="fpml", builder=FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilderImpl.class, version="2.1.1")
public interface FxBusinessCenterDateTime extends RosettaModelObject {

	FxBusinessCenterDateTimeMeta metaData = new FxBusinessCenterDateTimeMeta();

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
	ZonedDateTime getDate();
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
	BusinessCenterTime getTime();

	/*********************** Build Methods  ***********************/
	FxBusinessCenterDateTime build();
	
	FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder toBuilder();
	
	static FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder() {
		return new FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxBusinessCenterDateTime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxBusinessCenterDateTime> getType() {
		return FxBusinessCenterDateTime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processRosetta(path.newSubPath("time"), processor, BusinessCenterTime.class, getTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxBusinessCenterDateTimeBuilder extends FxBusinessCenterDateTime, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getTime();
		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setDate(ZonedDateTime date);
		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setTime(BusinessCenterTime time);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processRosetta(path.newSubPath("time"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getTime());
		}
		

		FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder prune();
	}

	/*********************** Immutable Implementation of FxBusinessCenterDateTime  ***********************/
	class FxBusinessCenterDateTimeImpl implements FxBusinessCenterDateTime {
		private final ZonedDateTime date;
		private final BusinessCenterTime time;
		
		protected FxBusinessCenterDateTimeImpl(FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder) {
			this.date = builder.getDate();
			this.time = ofNullable(builder.getTime()).map(f->f.build()).orElse(null);
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
		public BusinessCenterTime getTime() {
			return time;
		}
		
		@Override
		public FxBusinessCenterDateTime build() {
			return this;
		}
		
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder toBuilder() {
			FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBusinessCenterDateTime _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBusinessCenterDateTime {" +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}

	/*********************** Builder Implementation of FxBusinessCenterDateTime  ***********************/
	class FxBusinessCenterDateTimeBuilderImpl implements FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder {
	
		protected ZonedDateTime date;
		protected BusinessCenterTime.BusinessCenterTimeBuilder time;
		
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
		public BusinessCenterTime.BusinessCenterTimeBuilder getTime() {
			return time;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (time!=null) {
				result = time;
			}
			else {
				result = time = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder setTime(BusinessCenterTime _time) {
			this.time = _time == null ? null : _time.toBuilder();
			return this;
		}
		
		@Override
		public FxBusinessCenterDateTime build() {
			return new FxBusinessCenterDateTime.FxBusinessCenterDateTimeImpl(this);
		}
		
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder prune() {
			if (time!=null && !time.prune().hasData()) time = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getTime()!=null && getTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder o = (FxBusinessCenterDateTime.FxBusinessCenterDateTimeBuilder) other;
			
			merger.mergeRosetta(getTime(), o.getTime(), this::setTime);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxBusinessCenterDateTime _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxBusinessCenterDateTimeBuilder {" +
				"date=" + this.date + ", " +
				"time=" + this.time +
			'}';
		}
	}
}
