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
import drr.base.util.datetime.meta.ValuePeriodMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ValuePeriod", builder=ValuePeriod.ValuePeriodBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ValuePeriod", model="drr", builder=ValuePeriod.ValuePeriodBuilderImpl.class, version="7.7.0")
public interface ValuePeriod extends ValuePeriodBase {

	ValuePeriodMeta metaData = new ValuePeriodMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();

	/*********************** Build Methods  ***********************/
	ValuePeriod build();
	
	ValuePeriod.ValuePeriodBuilder toBuilder();
	
	static ValuePeriod.ValuePeriodBuilder builder() {
		return new ValuePeriod.ValuePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuePeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuePeriod> getType() {
		return ValuePeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuePeriodBuilder extends ValuePeriod, ValuePeriodBase.ValuePeriodBaseBuilder {
		@Override
		ValuePeriod.ValuePeriodBuilder setEffectiveDate(Date effectiveDate);
		@Override
		ValuePeriod.ValuePeriodBuilder setEndDate(Date endDate);
		ValuePeriod.ValuePeriodBuilder setValue(BigDecimal value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		}
		

		ValuePeriod.ValuePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of ValuePeriod  ***********************/
	class ValuePeriodImpl extends ValuePeriodBase.ValuePeriodBaseImpl implements ValuePeriod {
		private final BigDecimal value;
		
		protected ValuePeriodImpl(ValuePeriod.ValuePeriodBuilder builder) {
			super(builder);
			this.value = builder.getValue();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		public ValuePeriod build() {
			return this;
		}
		
		@Override
		public ValuePeriod.ValuePeriodBuilder toBuilder() {
			ValuePeriod.ValuePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuePeriod.ValuePeriodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuePeriod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuePeriod {" +
				"value=" + this.value +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuePeriod  ***********************/
	class ValuePeriodBuilderImpl extends ValuePeriodBase.ValuePeriodBaseBuilderImpl implements ValuePeriod.ValuePeriodBuilder {
	
		protected BigDecimal value;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public ValuePeriod.ValuePeriodBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public ValuePeriod.ValuePeriodBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ValuePeriod.ValuePeriodBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		public ValuePeriod build() {
			return new ValuePeriod.ValuePeriodImpl(this);
		}
		
		@Override
		public ValuePeriod.ValuePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuePeriod.ValuePeriodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuePeriod.ValuePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ValuePeriod.ValuePeriodBuilder o = (ValuePeriod.ValuePeriodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuePeriod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuePeriodBuilder {" +
				"value=" + this.value +
			'}' + " " + super.toString();
		}
	}
}
