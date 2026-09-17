package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.CashSettlementPaymentDateMeta;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.BusinessDateRange;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the cash settlement payment date(s) as either a set of explicit dates, together with applicable adjustments, or as a date relative to some other (anchor) date, or as any date in a range of contiguous business days.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the cash settlement payment date(s) as either a set of explicit dates, together with applicable adjustments, or as a date relative to some other (anchor) date, or as any date in a range of contiguous business days.
 *
 */
@RosettaDataType(value="CashSettlementPaymentDate", builder=CashSettlementPaymentDate.CashSettlementPaymentDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashSettlementPaymentDate", model="fpml", builder=CashSettlementPaymentDate.CashSettlementPaymentDateBuilderImpl.class, version="2.1.1")
public interface CashSettlementPaymentDate extends RosettaModelObject {

	CashSettlementPaymentDateMeta metaData = new CashSettlementPaymentDateMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 *
	 */
	AdjustableDates getAdjustableDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A date specified as some offset to another date (the anchor date).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date specified as some offset to another date (the anchor date).
	 *
	 */
	RelativeDateOffset getRelativeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A range of contiguous business days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A range of contiguous business days.
	 *
	 */
	BusinessDateRange getBusinessDateRange();

	/*********************** Build Methods  ***********************/
	CashSettlementPaymentDate build();
	
	CashSettlementPaymentDate.CashSettlementPaymentDateBuilder toBuilder();
	
	static CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder() {
		return new CashSettlementPaymentDate.CashSettlementPaymentDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlementPaymentDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashSettlementPaymentDate> getType() {
		return CashSettlementPaymentDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
		processRosetta(path.newSubPath("businessDateRange"), processor, BusinessDateRange.class, getBusinessDateRange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementPaymentDateBuilder extends CashSettlementPaymentDate, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		@Override
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		BusinessDateRange.BusinessDateRangeBuilder getOrCreateBusinessDateRange();
		@Override
		BusinessDateRange.BusinessDateRangeBuilder getBusinessDateRange();
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setId(String id);
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setAdjustableDates(AdjustableDates adjustableDates);
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setRelativeDate(RelativeDateOffset relativeDate);
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setBusinessDateRange(BusinessDateRange businessDateRange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
			processRosetta(path.newSubPath("businessDateRange"), processor, BusinessDateRange.BusinessDateRangeBuilder.class, getBusinessDateRange());
		}
		

		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlementPaymentDate  ***********************/
	class CashSettlementPaymentDateImpl implements CashSettlementPaymentDate {
		private final String id;
		private final AdjustableDates adjustableDates;
		private final RelativeDateOffset relativeDate;
		private final BusinessDateRange businessDateRange;
		
		protected CashSettlementPaymentDateImpl(CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder) {
			this.id = builder.getId();
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
			this.businessDateRange = ofNullable(builder.getBusinessDateRange()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDates")
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDate")
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		@RosettaAttribute("businessDateRange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDateRange")
		public BusinessDateRange getBusinessDateRange() {
			return businessDateRange;
		}
		
		@Override
		public CashSettlementPaymentDate build() {
			return this;
		}
		
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder toBuilder() {
			CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
			ofNullable(getBusinessDateRange()).ifPresent(builder::setBusinessDateRange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(businessDateRange, _that.getBusinessDateRange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (businessDateRange != null ? businessDateRange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementPaymentDate {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"businessDateRange=" + this.businessDateRange +
			'}';
		}
	}

	/*********************** Builder Implementation of CashSettlementPaymentDate  ***********************/
	class CashSettlementPaymentDateBuilderImpl implements CashSettlementPaymentDate.CashSettlementPaymentDateBuilder {
	
		protected String id;
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
		protected BusinessDateRange.BusinessDateRangeBuilder businessDateRange;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustableDates")
		public AdjustableDates.AdjustableDatesBuilder getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (adjustableDates!=null) {
				result = adjustableDates;
			}
			else {
				result = adjustableDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessDateRange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDateRange")
		public BusinessDateRange.BusinessDateRangeBuilder getBusinessDateRange() {
			return businessDateRange;
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder getOrCreateBusinessDateRange() {
			BusinessDateRange.BusinessDateRangeBuilder result;
			if (businessDateRange!=null) {
				result = businessDateRange;
			}
			else {
				result = businessDateRange = BusinessDateRange.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("adjustableDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustableDates")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setAdjustableDates(AdjustableDates _adjustableDates) {
			this.adjustableDates = _adjustableDates == null ? null : _adjustableDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeDate")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setRelativeDate(RelativeDateOffset _relativeDate) {
			this.relativeDate = _relativeDate == null ? null : _relativeDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessDateRange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessDateRange")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setBusinessDateRange(BusinessDateRange _businessDateRange) {
			this.businessDateRange = _businessDateRange == null ? null : _businessDateRange.toBuilder();
			return this;
		}
		
		@Override
		public CashSettlementPaymentDate build() {
			return new CashSettlementPaymentDate.CashSettlementPaymentDateImpl(this);
		}
		
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			if (businessDateRange!=null && !businessDateRange.prune().hasData()) businessDateRange = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			if (getBusinessDateRange()!=null && getBusinessDateRange().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashSettlementPaymentDate.CashSettlementPaymentDateBuilder o = (CashSettlementPaymentDate.CashSettlementPaymentDateBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			merger.mergeRosetta(getBusinessDateRange(), o.getBusinessDateRange(), this::setBusinessDateRange);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(businessDateRange, _that.getBusinessDateRange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (businessDateRange != null ? businessDateRange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementPaymentDateBuilder {" +
				"id=" + this.id + ", " +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"businessDateRange=" + this.businessDateRange +
			'}';
		}
	}
}
