package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.ValuationDateMeta;
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
@RosettaDataType(value="ValuationDate", builder=ValuationDate.ValuationDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ValuationDate", model="fpml", builder=ValuationDate.ValuationDateBuilderImpl.class, version="2.1.1")
public interface ValuationDate extends RosettaModelObject {

	ValuationDateMeta metaData = new ValuationDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Where single valuation date is specified as being applicable for cash settlement, this element specifies the number of business days after satisfaction of all conditions to settlement when such valuation date occurs. ISDA 2003 Term: Single Valuation Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Where single valuation date is specified as being applicable for cash settlement, this element specifies the number of business days after satisfaction of all conditions to settlement when such valuation date occurs. ISDA 2003 Term: Single Valuation Date
	 *
	 */
	SingleValuationDate getSingleValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates
	 *
	 */
	MultipleValuationDates getMultipleValuationDates();

	/*********************** Build Methods  ***********************/
	ValuationDate build();
	
	ValuationDate.ValuationDateBuilder toBuilder();
	
	static ValuationDate.ValuationDateBuilder builder() {
		return new ValuationDate.ValuationDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationDate> getType() {
		return ValuationDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("singleValuationDate"), processor, SingleValuationDate.class, getSingleValuationDate());
		processRosetta(path.newSubPath("multipleValuationDates"), processor, MultipleValuationDates.class, getMultipleValuationDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationDateBuilder extends ValuationDate, RosettaModelObjectBuilder {
		SingleValuationDate.SingleValuationDateBuilder getOrCreateSingleValuationDate();
		@Override
		SingleValuationDate.SingleValuationDateBuilder getSingleValuationDate();
		MultipleValuationDates.MultipleValuationDatesBuilder getOrCreateMultipleValuationDates();
		@Override
		MultipleValuationDates.MultipleValuationDatesBuilder getMultipleValuationDates();
		ValuationDate.ValuationDateBuilder setSingleValuationDate(SingleValuationDate singleValuationDate);
		ValuationDate.ValuationDateBuilder setMultipleValuationDates(MultipleValuationDates multipleValuationDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("singleValuationDate"), processor, SingleValuationDate.SingleValuationDateBuilder.class, getSingleValuationDate());
			processRosetta(path.newSubPath("multipleValuationDates"), processor, MultipleValuationDates.MultipleValuationDatesBuilder.class, getMultipleValuationDates());
		}
		

		ValuationDate.ValuationDateBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationDate  ***********************/
	class ValuationDateImpl implements ValuationDate {
		private final SingleValuationDate singleValuationDate;
		private final MultipleValuationDates multipleValuationDates;
		
		protected ValuationDateImpl(ValuationDate.ValuationDateBuilder builder) {
			this.singleValuationDate = ofNullable(builder.getSingleValuationDate()).map(f->f.build()).orElse(null);
			this.multipleValuationDates = ofNullable(builder.getMultipleValuationDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("singleValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("singleValuationDate")
		public SingleValuationDate getSingleValuationDate() {
			return singleValuationDate;
		}
		
		@Override
		@RosettaAttribute("multipleValuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleValuationDates")
		public MultipleValuationDates getMultipleValuationDates() {
			return multipleValuationDates;
		}
		
		@Override
		public ValuationDate build() {
			return this;
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder toBuilder() {
			ValuationDate.ValuationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationDate.ValuationDateBuilder builder) {
			ofNullable(getSingleValuationDate()).ifPresent(builder::setSingleValuationDate);
			ofNullable(getMultipleValuationDates()).ifPresent(builder::setMultipleValuationDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(singleValuationDate, _that.getSingleValuationDate())) return false;
			if (!Objects.equals(multipleValuationDates, _that.getMultipleValuationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singleValuationDate != null ? singleValuationDate.hashCode() : 0);
			_result = 31 * _result + (multipleValuationDates != null ? multipleValuationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDate {" +
				"singleValuationDate=" + this.singleValuationDate + ", " +
				"multipleValuationDates=" + this.multipleValuationDates +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationDate  ***********************/
	class ValuationDateBuilderImpl implements ValuationDate.ValuationDateBuilder {
	
		protected SingleValuationDate.SingleValuationDateBuilder singleValuationDate;
		protected MultipleValuationDates.MultipleValuationDatesBuilder multipleValuationDates;
		
		@Override
		@RosettaAttribute("singleValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("singleValuationDate")
		public SingleValuationDate.SingleValuationDateBuilder getSingleValuationDate() {
			return singleValuationDate;
		}
		
		@Override
		public SingleValuationDate.SingleValuationDateBuilder getOrCreateSingleValuationDate() {
			SingleValuationDate.SingleValuationDateBuilder result;
			if (singleValuationDate!=null) {
				result = singleValuationDate;
			}
			else {
				result = singleValuationDate = SingleValuationDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multipleValuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleValuationDates")
		public MultipleValuationDates.MultipleValuationDatesBuilder getMultipleValuationDates() {
			return multipleValuationDates;
		}
		
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder getOrCreateMultipleValuationDates() {
			MultipleValuationDates.MultipleValuationDatesBuilder result;
			if (multipleValuationDates!=null) {
				result = multipleValuationDates;
			}
			else {
				result = multipleValuationDates = MultipleValuationDates.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("singleValuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("singleValuationDate")
		@Override
		public ValuationDate.ValuationDateBuilder setSingleValuationDate(SingleValuationDate _singleValuationDate) {
			this.singleValuationDate = _singleValuationDate == null ? null : _singleValuationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multipleValuationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleValuationDates")
		@Override
		public ValuationDate.ValuationDateBuilder setMultipleValuationDates(MultipleValuationDates _multipleValuationDates) {
			this.multipleValuationDates = _multipleValuationDates == null ? null : _multipleValuationDates.toBuilder();
			return this;
		}
		
		@Override
		public ValuationDate build() {
			return new ValuationDate.ValuationDateImpl(this);
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDate.ValuationDateBuilder prune() {
			if (singleValuationDate!=null && !singleValuationDate.prune().hasData()) singleValuationDate = null;
			if (multipleValuationDates!=null && !multipleValuationDates.prune().hasData()) multipleValuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSingleValuationDate()!=null && getSingleValuationDate().hasData()) return true;
			if (getMultipleValuationDates()!=null && getMultipleValuationDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDate.ValuationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationDate.ValuationDateBuilder o = (ValuationDate.ValuationDateBuilder) other;
			
			merger.mergeRosetta(getSingleValuationDate(), o.getSingleValuationDate(), this::setSingleValuationDate);
			merger.mergeRosetta(getMultipleValuationDates(), o.getMultipleValuationDates(), this::setMultipleValuationDates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(singleValuationDate, _that.getSingleValuationDate())) return false;
			if (!Objects.equals(multipleValuationDates, _that.getMultipleValuationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singleValuationDate != null ? singleValuationDate.hashCode() : 0);
			_result = 31 * _result + (multipleValuationDates != null ? multipleValuationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDateBuilder {" +
				"singleValuationDate=" + this.singleValuationDate + ", " +
				"multipleValuationDates=" + this.multipleValuationDates +
			'}';
		}
	}
}
