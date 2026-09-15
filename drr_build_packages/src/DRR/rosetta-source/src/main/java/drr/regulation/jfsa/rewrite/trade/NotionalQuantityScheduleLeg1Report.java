package drr.regulation.jfsa.rewrite.trade;

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
import drr.regulation.jfsa.rewrite.trade.meta.NotionalQuantityScheduleLeg1ReportMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="NotionalQuantityScheduleLeg1Report", builder=NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="NotionalQuantityScheduleLeg1Report", model="drr", builder=NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilderImpl.class, version="7.7.0")
public interface NotionalQuantityScheduleLeg1Report extends RosettaModelObject {

	NotionalQuantityScheduleLeg1ReportMeta metaData = new NotionalQuantityScheduleLeg1ReportMeta();

	/*********************** Getter Methods  ***********************/
	Date getEffectiveDate();
	Date getEndDate();
	BigDecimal getValue();

	/*********************** Build Methods  ***********************/
	NotionalQuantityScheduleLeg1Report build();
	
	NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder toBuilder();
	
	static NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder builder() {
		return new NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalQuantityScheduleLeg1Report> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalQuantityScheduleLeg1Report> getType() {
		return NotionalQuantityScheduleLeg1Report.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalQuantityScheduleLeg1ReportBuilder extends NotionalQuantityScheduleLeg1Report, RosettaModelObjectBuilder {
		NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder setEffectiveDate(Date effectiveDate);
		NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder setEndDate(Date endDate);
		NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder setValue(BigDecimal value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		}
		

		NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalQuantityScheduleLeg1Report  ***********************/
	class NotionalQuantityScheduleLeg1ReportImpl implements NotionalQuantityScheduleLeg1Report {
		private final Date effectiveDate;
		private final Date endDate;
		private final BigDecimal value;
		
		protected NotionalQuantityScheduleLeg1ReportImpl(NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder builder) {
			this.effectiveDate = builder.getEffectiveDate();
			this.endDate = builder.getEndDate();
			this.value = builder.getValue();
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
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		public NotionalQuantityScheduleLeg1Report build() {
			return this;
		}
		
		@Override
		public NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder toBuilder() {
			NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityScheduleLeg1Report _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantityScheduleLeg1Report {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"endDate=" + this.endDate + ", " +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalQuantityScheduleLeg1Report  ***********************/
	class NotionalQuantityScheduleLeg1ReportBuilderImpl implements NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder {
	
		protected Date effectiveDate;
		protected Date endDate;
		protected BigDecimal value;
		
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
		public NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		public NotionalQuantityScheduleLeg1Report build() {
			return new NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportImpl(this);
		}
		
		@Override
		public NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder o = (NotionalQuantityScheduleLeg1Report.NotionalQuantityScheduleLeg1ReportBuilder) other;
			
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityScheduleLeg1Report _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantityScheduleLeg1ReportBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"endDate=" + this.endDate + ", " +
				"value=" + this.value +
			'}';
		}
	}
}
