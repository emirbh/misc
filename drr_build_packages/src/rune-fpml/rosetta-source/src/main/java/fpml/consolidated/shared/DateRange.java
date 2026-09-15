package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.DateRangeMeta;
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
 * Provision A type defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the first and the last date. The first date must fall before the last date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the first and the last date. The first date must fall before the last date.
 *
 */
@RosettaDataType(value="DateRange", builder=DateRange.DateRangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DateRange", model="fpml", builder=DateRange.DateRangeBuilderImpl.class, version="2.1.1")
public interface DateRange extends RosettaModelObject {

	DateRangeMeta metaData = new DateRangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first date of a date range.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first date of a date range.
	 *
	 */
	ZonedDateTime getUnadjustedFirstDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last date of a date range.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last date of a date range.
	 *
	 */
	ZonedDateTime getUnadjustedLastDate();

	/*********************** Build Methods  ***********************/
	DateRange build();
	
	DateRange.DateRangeBuilder toBuilder();
	
	static DateRange.DateRangeBuilder builder() {
		return new DateRange.DateRangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateRange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DateRange> getType() {
		return DateRange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedFirstDate"), ZonedDateTime.class, getUnadjustedFirstDate(), this);
		processor.processBasic(path.newSubPath("unadjustedLastDate"), ZonedDateTime.class, getUnadjustedLastDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateRangeBuilder extends DateRange, RosettaModelObjectBuilder {
		DateRange.DateRangeBuilder setUnadjustedFirstDate(ZonedDateTime unadjustedFirstDate);
		DateRange.DateRangeBuilder setUnadjustedLastDate(ZonedDateTime unadjustedLastDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedFirstDate"), ZonedDateTime.class, getUnadjustedFirstDate(), this);
			processor.processBasic(path.newSubPath("unadjustedLastDate"), ZonedDateTime.class, getUnadjustedLastDate(), this);
		}
		

		DateRange.DateRangeBuilder prune();
	}

	/*********************** Immutable Implementation of DateRange  ***********************/
	class DateRangeImpl implements DateRange {
		private final ZonedDateTime unadjustedFirstDate;
		private final ZonedDateTime unadjustedLastDate;
		
		protected DateRangeImpl(DateRange.DateRangeBuilder builder) {
			this.unadjustedFirstDate = builder.getUnadjustedFirstDate();
			this.unadjustedLastDate = builder.getUnadjustedLastDate();
		}
		
		@Override
		@RosettaAttribute("unadjustedFirstDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedFirstDate")
		public ZonedDateTime getUnadjustedFirstDate() {
			return unadjustedFirstDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedLastDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedLastDate")
		public ZonedDateTime getUnadjustedLastDate() {
			return unadjustedLastDate;
		}
		
		@Override
		public DateRange build() {
			return this;
		}
		
		@Override
		public DateRange.DateRangeBuilder toBuilder() {
			DateRange.DateRangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRange.DateRangeBuilder builder) {
			ofNullable(getUnadjustedFirstDate()).ifPresent(builder::setUnadjustedFirstDate);
			ofNullable(getUnadjustedLastDate()).ifPresent(builder::setUnadjustedLastDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRange _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedFirstDate, _that.getUnadjustedFirstDate())) return false;
			if (!Objects.equals(unadjustedLastDate, _that.getUnadjustedLastDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedFirstDate != null ? unadjustedFirstDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedLastDate != null ? unadjustedLastDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRange {" +
				"unadjustedFirstDate=" + this.unadjustedFirstDate + ", " +
				"unadjustedLastDate=" + this.unadjustedLastDate +
			'}';
		}
	}

	/*********************** Builder Implementation of DateRange  ***********************/
	class DateRangeBuilderImpl implements DateRange.DateRangeBuilder {
	
		protected ZonedDateTime unadjustedFirstDate;
		protected ZonedDateTime unadjustedLastDate;
		
		@Override
		@RosettaAttribute("unadjustedFirstDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedFirstDate")
		public ZonedDateTime getUnadjustedFirstDate() {
			return unadjustedFirstDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedLastDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedLastDate")
		public ZonedDateTime getUnadjustedLastDate() {
			return unadjustedLastDate;
		}
		
		@RosettaAttribute("unadjustedFirstDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedFirstDate")
		@Override
		public DateRange.DateRangeBuilder setUnadjustedFirstDate(ZonedDateTime _unadjustedFirstDate) {
			this.unadjustedFirstDate = _unadjustedFirstDate == null ? null : _unadjustedFirstDate;
			return this;
		}
		
		@RosettaAttribute("unadjustedLastDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedLastDate")
		@Override
		public DateRange.DateRangeBuilder setUnadjustedLastDate(ZonedDateTime _unadjustedLastDate) {
			this.unadjustedLastDate = _unadjustedLastDate == null ? null : _unadjustedLastDate;
			return this;
		}
		
		@Override
		public DateRange build() {
			return new DateRange.DateRangeImpl(this);
		}
		
		@Override
		public DateRange.DateRangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRange.DateRangeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedFirstDate()!=null) return true;
			if (getUnadjustedLastDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRange.DateRangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRange.DateRangeBuilder o = (DateRange.DateRangeBuilder) other;
			
			
			merger.mergeBasic(getUnadjustedFirstDate(), o.getUnadjustedFirstDate(), this::setUnadjustedFirstDate);
			merger.mergeBasic(getUnadjustedLastDate(), o.getUnadjustedLastDate(), this::setUnadjustedLastDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRange _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedFirstDate, _that.getUnadjustedFirstDate())) return false;
			if (!Objects.equals(unadjustedLastDate, _that.getUnadjustedLastDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedFirstDate != null ? unadjustedFirstDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedLastDate != null ? unadjustedLastDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRangeBuilder {" +
				"unadjustedFirstDate=" + this.unadjustedFirstDate + ", " +
				"unadjustedLastDate=" + this.unadjustedLastDate +
			'}';
		}
	}
}
