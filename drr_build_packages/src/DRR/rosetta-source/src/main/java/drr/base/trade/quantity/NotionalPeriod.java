package drr.base.trade.quantity;

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
import drr.base.trade.quantity.meta.NotionalPeriodMeta;
import drr.base.util.datetime.ValuePeriod;
import java.math.BigDecimal;


/**
 * @version 7.7.0
 */
@RosettaDataType(value="NotionalPeriod", builder=NotionalPeriod.NotionalPeriodBuilderImpl.class, version="7.7.0")
@RuneDataType(value="NotionalPeriod", model="drr", builder=NotionalPeriod.NotionalPeriodBuilderImpl.class, version="7.7.0")
public interface NotionalPeriod extends ValuePeriod {

	NotionalPeriodMeta metaData = new NotionalPeriodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	NotionalPeriod build();
	
	NotionalPeriod.NotionalPeriodBuilder toBuilder();
	
	static NotionalPeriod.NotionalPeriodBuilder builder() {
		return new NotionalPeriod.NotionalPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalPeriod> getType() {
		return NotionalPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalPeriodBuilder extends NotionalPeriod, ValuePeriod.ValuePeriodBuilder {
		@Override
		NotionalPeriod.NotionalPeriodBuilder setEffectiveDate(Date effectiveDate);
		@Override
		NotionalPeriod.NotionalPeriodBuilder setEndDate(Date endDate);
		@Override
		NotionalPeriod.NotionalPeriodBuilder setValue(BigDecimal value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		}
		

		NotionalPeriod.NotionalPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalPeriod  ***********************/
	class NotionalPeriodImpl extends ValuePeriod.ValuePeriodImpl implements NotionalPeriod {
		
		protected NotionalPeriodImpl(NotionalPeriod.NotionalPeriodBuilder builder) {
			super(builder);
		}
		
		@Override
		public NotionalPeriod build() {
			return this;
		}
		
		@Override
		public NotionalPeriod.NotionalPeriodBuilder toBuilder() {
			NotionalPeriod.NotionalPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalPeriod.NotionalPeriodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalPeriod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NotionalPeriod  ***********************/
	class NotionalPeriodBuilderImpl extends ValuePeriod.ValuePeriodBuilderImpl implements NotionalPeriod.NotionalPeriodBuilder {
	
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public NotionalPeriod.NotionalPeriodBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public NotionalPeriod.NotionalPeriodBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public NotionalPeriod.NotionalPeriodBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		public NotionalPeriod build() {
			return new NotionalPeriod.NotionalPeriodImpl(this);
		}
		
		@Override
		public NotionalPeriod.NotionalPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalPeriod.NotionalPeriodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalPeriod.NotionalPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			NotionalPeriod.NotionalPeriodBuilder o = (NotionalPeriod.NotionalPeriodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalPeriodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
