package drr.regulation.hkma.rewrite.trade;

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
import drr.regulation.hkma.rewrite.trade.meta.NotionalQuantityScheduleLeg2ReportMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="NotionalQuantityScheduleLeg2Report", builder=NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="NotionalQuantityScheduleLeg2Report", model="drr", builder=NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilderImpl.class, version="7.7.0")
public interface NotionalQuantityScheduleLeg2Report extends RosettaModelObject {

	NotionalQuantityScheduleLeg2ReportMeta metaData = new NotionalQuantityScheduleLeg2ReportMeta();

	/*********************** Getter Methods  ***********************/
	Date getEffectiveDate();
	Date getEndDate();
	BigDecimal getQuantity();

	/*********************** Build Methods  ***********************/
	NotionalQuantityScheduleLeg2Report build();
	
	NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder toBuilder();
	
	static NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder builder() {
		return new NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalQuantityScheduleLeg2Report> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalQuantityScheduleLeg2Report> getType() {
		return NotionalQuantityScheduleLeg2Report.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalQuantityScheduleLeg2ReportBuilder extends NotionalQuantityScheduleLeg2Report, RosettaModelObjectBuilder {
		NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder setEffectiveDate(Date effectiveDate);
		NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder setEndDate(Date endDate);
		NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder setQuantity(BigDecimal quantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		}
		

		NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalQuantityScheduleLeg2Report  ***********************/
	class NotionalQuantityScheduleLeg2ReportImpl implements NotionalQuantityScheduleLeg2Report {
		private final Date effectiveDate;
		private final Date endDate;
		private final BigDecimal quantity;
		
		protected NotionalQuantityScheduleLeg2ReportImpl(NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder builder) {
			this.effectiveDate = builder.getEffectiveDate();
			this.endDate = builder.getEndDate();
			this.quantity = builder.getQuantity();
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
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public NotionalQuantityScheduleLeg2Report build() {
			return this;
		}
		
		@Override
		public NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder toBuilder() {
			NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityScheduleLeg2Report _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantityScheduleLeg2Report {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"endDate=" + this.endDate + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalQuantityScheduleLeg2Report  ***********************/
	class NotionalQuantityScheduleLeg2ReportBuilderImpl implements NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder {
	
		protected Date effectiveDate;
		protected Date endDate;
		protected BigDecimal quantity;
		
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
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder setEndDate(Date _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantity")
		@Override
		public NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@Override
		public NotionalQuantityScheduleLeg2Report build() {
			return new NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportImpl(this);
		}
		
		@Override
		public NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getQuantity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder o = (NotionalQuantityScheduleLeg2Report.NotionalQuantityScheduleLeg2ReportBuilder) other;
			
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityScheduleLeg2Report _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantityScheduleLeg2ReportBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"endDate=" + this.endDate + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}
}
