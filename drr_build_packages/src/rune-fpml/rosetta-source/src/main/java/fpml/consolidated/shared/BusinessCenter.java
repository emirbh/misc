package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.BusinessCenterMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location scheme.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location scheme.
 *
 */
@RosettaDataType(value="BusinessCenter", builder=BusinessCenter.BusinessCenterBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BusinessCenter", model="fpml", builder=BusinessCenter.BusinessCenterBuilderImpl.class, version="2.1.1")
public interface BusinessCenter extends RosettaModelObject {

	BusinessCenterMeta metaData = new BusinessCenterMeta();

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
	String getValue();
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
	String getBusinessCenterScheme();
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

	/*********************** Build Methods  ***********************/
	BusinessCenter build();
	
	BusinessCenter.BusinessCenterBuilder toBuilder();
	
	static BusinessCenter.BusinessCenterBuilder builder() {
		return new BusinessCenter.BusinessCenterBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessCenter> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessCenter> getType() {
		return BusinessCenter.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("businessCenterScheme"), String.class, getBusinessCenterScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessCenterBuilder extends BusinessCenter, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder setValue(String value);
		BusinessCenter.BusinessCenterBuilder setBusinessCenterScheme(String businessCenterScheme);
		BusinessCenter.BusinessCenterBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("businessCenterScheme"), String.class, getBusinessCenterScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BusinessCenter.BusinessCenterBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessCenter  ***********************/
	class BusinessCenterImpl implements BusinessCenter {
		private final String value;
		private final String businessCenterScheme;
		private final String id;
		
		protected BusinessCenterImpl(BusinessCenter.BusinessCenterBuilder builder) {
			this.value = builder.getValue();
			this.businessCenterScheme = builder.getBusinessCenterScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("businessCenterScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenterScheme")
		public String getBusinessCenterScheme() {
			return businessCenterScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BusinessCenter build() {
			return this;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder toBuilder() {
			BusinessCenter.BusinessCenterBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCenter.BusinessCenterBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBusinessCenterScheme()).ifPresent(builder::setBusinessCenterScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenter _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(businessCenterScheme, _that.getBusinessCenterScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (businessCenterScheme != null ? businessCenterScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenter {" +
				"value=" + this.value + ", " +
				"businessCenterScheme=" + this.businessCenterScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessCenter  ***********************/
	class BusinessCenterBuilderImpl implements BusinessCenter.BusinessCenterBuilder {
	
		protected String value;
		protected String businessCenterScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("businessCenterScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenterScheme")
		public String getBusinessCenterScheme() {
			return businessCenterScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public BusinessCenter.BusinessCenterBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("businessCenterScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenterScheme")
		@Override
		public BusinessCenter.BusinessCenterBuilder setBusinessCenterScheme(String _businessCenterScheme) {
			this.businessCenterScheme = _businessCenterScheme == null ? null : _businessCenterScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BusinessCenter.BusinessCenterBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public BusinessCenter build() {
			return new BusinessCenter.BusinessCenterImpl(this);
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenter.BusinessCenterBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBusinessCenterScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenter.BusinessCenterBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCenter.BusinessCenterBuilder o = (BusinessCenter.BusinessCenterBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBusinessCenterScheme(), o.getBusinessCenterScheme(), this::setBusinessCenterScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenter _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(businessCenterScheme, _that.getBusinessCenterScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (businessCenterScheme != null ? businessCenterScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenterBuilder {" +
				"value=" + this.value + ", " +
				"businessCenterScheme=" + this.businessCenterScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
