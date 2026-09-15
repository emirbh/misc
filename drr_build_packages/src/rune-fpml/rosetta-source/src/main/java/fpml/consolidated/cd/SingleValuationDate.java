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
import fpml.consolidated.cd.meta.SingleValuationDateMeta;
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
@RosettaDataType(value="SingleValuationDate", builder=SingleValuationDate.SingleValuationDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SingleValuationDate", model="fpml", builder=SingleValuationDate.SingleValuationDateBuilderImpl.class, version="2.1.1")
public interface SingleValuationDate extends RosettaModelObject {

	SingleValuationDateMeta metaData = new SingleValuationDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day
	 *
	 */
	Integer getBusinessDays();

	/*********************** Build Methods  ***********************/
	SingleValuationDate build();
	
	SingleValuationDate.SingleValuationDateBuilder toBuilder();
	
	static SingleValuationDate.SingleValuationDateBuilder builder() {
		return new SingleValuationDate.SingleValuationDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SingleValuationDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SingleValuationDate> getType() {
		return SingleValuationDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("businessDays"), Integer.class, getBusinessDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SingleValuationDateBuilder extends SingleValuationDate, RosettaModelObjectBuilder {
		SingleValuationDate.SingleValuationDateBuilder setBusinessDays(Integer businessDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("businessDays"), Integer.class, getBusinessDays(), this);
		}
		

		SingleValuationDate.SingleValuationDateBuilder prune();
	}

	/*********************** Immutable Implementation of SingleValuationDate  ***********************/
	class SingleValuationDateImpl implements SingleValuationDate {
		private final Integer businessDays;
		
		protected SingleValuationDateImpl(SingleValuationDate.SingleValuationDateBuilder builder) {
			this.businessDays = builder.getBusinessDays();
		}
		
		@Override
		@RosettaAttribute("businessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDays")
		public Integer getBusinessDays() {
			return businessDays;
		}
		
		@Override
		public SingleValuationDate build() {
			return this;
		}
		
		@Override
		public SingleValuationDate.SingleValuationDateBuilder toBuilder() {
			SingleValuationDate.SingleValuationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SingleValuationDate.SingleValuationDateBuilder builder) {
			ofNullable(getBusinessDays()).ifPresent(builder::setBusinessDays);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleValuationDate {" +
				"businessDays=" + this.businessDays +
			'}';
		}
	}

	/*********************** Builder Implementation of SingleValuationDate  ***********************/
	class SingleValuationDateBuilderImpl implements SingleValuationDate.SingleValuationDateBuilder {
	
		protected Integer businessDays;
		
		@Override
		@RosettaAttribute("businessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessDays")
		public Integer getBusinessDays() {
			return businessDays;
		}
		
		@RosettaAttribute("businessDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessDays")
		@Override
		public SingleValuationDate.SingleValuationDateBuilder setBusinessDays(Integer _businessDays) {
			this.businessDays = _businessDays == null ? null : _businessDays;
			return this;
		}
		
		@Override
		public SingleValuationDate build() {
			return new SingleValuationDate.SingleValuationDateImpl(this);
		}
		
		@Override
		public SingleValuationDate.SingleValuationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleValuationDate.SingleValuationDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleValuationDate.SingleValuationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SingleValuationDate.SingleValuationDateBuilder o = (SingleValuationDate.SingleValuationDateBuilder) other;
			
			
			merger.mergeBasic(getBusinessDays(), o.getBusinessDays(), this::setBusinessDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleValuationDateBuilder {" +
				"businessDays=" + this.businessDays +
			'}';
		}
	}
}
