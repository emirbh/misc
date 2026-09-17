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
import fpml.consolidated.shared.meta.OffsetPrevailingTimeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Allows the specification of a time that may be on a day prior or subsequent to the day in question. This type is intended for use with a day of the week (i.e. where no actual date is specified) as part of, for example, a period that runs from 23:00-07:00 on a series of days and where holidays on the actual days would affect the entire time period.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Allows the specification of a time that may be on a day prior or subsequent to the day in question. This type is intended for use with a day of the week (i.e. where no actual date is specified) as part of, for example, a period that runs from 23:00-07:00 on a series of days and where holidays on the actual days would affect the entire time period.
 *
 */
@RosettaDataType(value="OffsetPrevailingTime", builder=OffsetPrevailingTime.OffsetPrevailingTimeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OffsetPrevailingTime", model="fpml", builder=OffsetPrevailingTime.OffsetPrevailingTimeBuilderImpl.class, version="2.1.1")
public interface OffsetPrevailingTime extends RosettaModelObject {

	OffsetPrevailingTimeMeta metaData = new OffsetPrevailingTimeMeta();

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
	PrevailingTime getTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether time applies to the actual day specified (in which case this element should be omitted) the day prior to that day (in which case periodMultiplier should be -1 and period should be Day) or the day subsequent to that day (in which case periodMultiplier should be 1 and period should be Day).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether time applies to the actual day specified (in which case this element should be omitted) the day prior to that day (in which case periodMultiplier should be -1 and period should be Day) or the day subsequent to that day (in which case periodMultiplier should be 1 and period should be Day).
	 *
	 */
	Offset getOffset();

	/*********************** Build Methods  ***********************/
	OffsetPrevailingTime build();
	
	OffsetPrevailingTime.OffsetPrevailingTimeBuilder toBuilder();
	
	static OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder() {
		return new OffsetPrevailingTime.OffsetPrevailingTimeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OffsetPrevailingTime> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OffsetPrevailingTime> getType() {
		return OffsetPrevailingTime.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("time"), processor, PrevailingTime.class, getTime());
		processRosetta(path.newSubPath("offset"), processor, Offset.class, getOffset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OffsetPrevailingTimeBuilder extends OffsetPrevailingTime, RosettaModelObjectBuilder {
		PrevailingTime.PrevailingTimeBuilder getOrCreateTime();
		@Override
		PrevailingTime.PrevailingTimeBuilder getTime();
		Offset.OffsetBuilder getOrCreateOffset();
		@Override
		Offset.OffsetBuilder getOffset();
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder setTime(PrevailingTime time);
		OffsetPrevailingTime.OffsetPrevailingTimeBuilder setOffset(Offset offset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("time"), processor, PrevailingTime.PrevailingTimeBuilder.class, getTime());
			processRosetta(path.newSubPath("offset"), processor, Offset.OffsetBuilder.class, getOffset());
		}
		

		OffsetPrevailingTime.OffsetPrevailingTimeBuilder prune();
	}

	/*********************** Immutable Implementation of OffsetPrevailingTime  ***********************/
	class OffsetPrevailingTimeImpl implements OffsetPrevailingTime {
		private final PrevailingTime time;
		private final Offset offset;
		
		protected OffsetPrevailingTimeImpl(OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder) {
			this.time = ofNullable(builder.getTime()).map(f->f.build()).orElse(null);
			this.offset = ofNullable(builder.getOffset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public PrevailingTime getTime() {
			return time;
		}
		
		@Override
		@RosettaAttribute("offset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offset")
		public Offset getOffset() {
			return offset;
		}
		
		@Override
		public OffsetPrevailingTime build() {
			return this;
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder toBuilder() {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OffsetPrevailingTime.OffsetPrevailingTimeBuilder builder) {
			ofNullable(getTime()).ifPresent(builder::setTime);
			ofNullable(getOffset()).ifPresent(builder::setOffset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OffsetPrevailingTime _that = getType().cast(o);
		
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OffsetPrevailingTime {" +
				"time=" + this.time + ", " +
				"offset=" + this.offset +
			'}';
		}
	}

	/*********************** Builder Implementation of OffsetPrevailingTime  ***********************/
	class OffsetPrevailingTimeBuilderImpl implements OffsetPrevailingTime.OffsetPrevailingTimeBuilder {
	
		protected PrevailingTime.PrevailingTimeBuilder time;
		protected Offset.OffsetBuilder offset;
		
		@Override
		@RosettaAttribute("time")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("time")
		public PrevailingTime.PrevailingTimeBuilder getTime() {
			return time;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (time!=null) {
				result = time;
			}
			else {
				result = time = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("offset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offset")
		public Offset.OffsetBuilder getOffset() {
			return offset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateOffset() {
			Offset.OffsetBuilder result;
			if (offset!=null) {
				result = offset;
			}
			else {
				result = offset = Offset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("time")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("time")
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder setTime(PrevailingTime _time) {
			this.time = _time == null ? null : _time.toBuilder();
			return this;
		}
		
		@RosettaAttribute("offset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offset")
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder setOffset(Offset _offset) {
			this.offset = _offset == null ? null : _offset.toBuilder();
			return this;
		}
		
		@Override
		public OffsetPrevailingTime build() {
			return new OffsetPrevailingTime.OffsetPrevailingTimeImpl(this);
		}
		
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder prune() {
			if (time!=null && !time.prune().hasData()) time = null;
			if (offset!=null && !offset.prune().hasData()) offset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTime()!=null && getTime().hasData()) return true;
			if (getOffset()!=null && getOffset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OffsetPrevailingTime.OffsetPrevailingTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OffsetPrevailingTime.OffsetPrevailingTimeBuilder o = (OffsetPrevailingTime.OffsetPrevailingTimeBuilder) other;
			
			merger.mergeRosetta(getTime(), o.getTime(), this::setTime);
			merger.mergeRosetta(getOffset(), o.getOffset(), this::setOffset);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OffsetPrevailingTime _that = getType().cast(o);
		
			if (!Objects.equals(time, _that.getTime())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (time != null ? time.hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OffsetPrevailingTimeBuilder {" +
				"time=" + this.time + ", " +
				"offset=" + this.offset +
			'}';
		}
	}
}
