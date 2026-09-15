package drr.base.util.datetime;

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
import drr.base.util.datetime.meta.ValuePeriodBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ValuePeriodBase", builder=ValuePeriodBase.ValuePeriodBaseBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ValuePeriodBase", model="drr", builder=ValuePeriodBase.ValuePeriodBaseBuilderImpl.class, version="7.7.0")
public interface ValuePeriodBase extends RosettaModelObject {

	ValuePeriodBaseMeta metaData = new ValuePeriodBaseMeta();

	/*********************** Getter Methods  ***********************/
	Date getEffectiveDate();
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	ValuePeriodBase build();
	
	ValuePeriodBase.ValuePeriodBaseBuilder toBuilder();
	
	static ValuePeriodBase.ValuePeriodBaseBuilder builder() {
		return new ValuePeriodBase.ValuePeriodBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuePeriodBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuePeriodBase> getType() {
		return ValuePeriodBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuePeriodBaseBuilder extends ValuePeriodBase, RosettaModelObjectBuilder {
		ValuePeriodBase.ValuePeriodBaseBuilder setEffectiveDate(Date effectiveDate);
		ValuePeriodBase.ValuePeriodBaseBuilder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		ValuePeriodBase.ValuePeriodBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ValuePeriodBase  ***********************/
	class ValuePeriodBaseImpl implements ValuePeriodBase {
		private final Date effectiveDate;
		private final Date endDate;
		
		protected ValuePeriodBaseImpl(ValuePeriodBase.ValuePeriodBaseBuilder builder) {
			this.effectiveDate = builder.getEffectiveDate();
			this.endDate = builder.getEndDate();
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public ValuePeriodBase build() {
			return this;
		}
		
		@Override
		public ValuePeriodBase.ValuePeriodBaseBuilder toBuilder() {
			ValuePeriodBase.ValuePeriodBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuePeriodBase.ValuePeriodBaseBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuePeriodBase _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuePeriodBase {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuePeriodBase  ***********************/
	class ValuePeriodBaseBuilderImpl implements ValuePeriodBase.ValuePeriodBaseBuilder {
	
		protected Date effectiveDate;
		protected Date endDate;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public ValuePeriodBase.ValuePeriodBaseBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public ValuePeriodBase.ValuePeriodBaseBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@Override
		public ValuePeriodBase build() {
			return new ValuePeriodBase.ValuePeriodBaseImpl(this);
		}
		
		@Override
		public ValuePeriodBase.ValuePeriodBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuePeriodBase.ValuePeriodBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null) return true;
			if (getEndDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuePeriodBase.ValuePeriodBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuePeriodBase.ValuePeriodBaseBuilder o = (ValuePeriodBase.ValuePeriodBaseBuilder) other;
			
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuePeriodBase _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuePeriodBaseBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
