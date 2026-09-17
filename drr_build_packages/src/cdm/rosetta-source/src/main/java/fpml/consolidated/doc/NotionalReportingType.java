package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.NotionalReportingTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision How a notional is to be reported for this reporting regime. E.g. for ESMA EMIR, it would be Nominal or Monetary Amount
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision How a notional is to be reported for this reporting regime. E.g. for ESMA EMIR, it would be Nominal or Monetary Amount
 *
 */
@RosettaDataType(value="NotionalReportingType", builder=NotionalReportingType.NotionalReportingTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NotionalReportingType", model="fpml", builder=NotionalReportingType.NotionalReportingTypeBuilderImpl.class, version="2.1.1")
public interface NotionalReportingType extends RosettaModelObject {

	NotionalReportingTypeMeta metaData = new NotionalReportingTypeMeta();

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
	String getNotionalTypeScheme();

	/*********************** Build Methods  ***********************/
	NotionalReportingType build();
	
	NotionalReportingType.NotionalReportingTypeBuilder toBuilder();
	
	static NotionalReportingType.NotionalReportingTypeBuilder builder() {
		return new NotionalReportingType.NotionalReportingTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalReportingType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalReportingType> getType() {
		return NotionalReportingType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("notionalTypeScheme"), String.class, getNotionalTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalReportingTypeBuilder extends NotionalReportingType, RosettaModelObjectBuilder {
		NotionalReportingType.NotionalReportingTypeBuilder setValue(String value);
		NotionalReportingType.NotionalReportingTypeBuilder setNotionalTypeScheme(String notionalTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("notionalTypeScheme"), String.class, getNotionalTypeScheme(), this);
		}
		

		NotionalReportingType.NotionalReportingTypeBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalReportingType  ***********************/
	class NotionalReportingTypeImpl implements NotionalReportingType {
		private final String value;
		private final String notionalTypeScheme;
		
		protected NotionalReportingTypeImpl(NotionalReportingType.NotionalReportingTypeBuilder builder) {
			this.value = builder.getValue();
			this.notionalTypeScheme = builder.getNotionalTypeScheme();
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
		@RosettaAttribute("notionalTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalTypeScheme")
		public String getNotionalTypeScheme() {
			return notionalTypeScheme;
		}
		
		@Override
		public NotionalReportingType build() {
			return this;
		}
		
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder toBuilder() {
			NotionalReportingType.NotionalReportingTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalReportingType.NotionalReportingTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getNotionalTypeScheme()).ifPresent(builder::setNotionalTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalReportingType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(notionalTypeScheme, _that.getNotionalTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (notionalTypeScheme != null ? notionalTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalReportingType {" +
				"value=" + this.value + ", " +
				"notionalTypeScheme=" + this.notionalTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalReportingType  ***********************/
	class NotionalReportingTypeBuilderImpl implements NotionalReportingType.NotionalReportingTypeBuilder {
	
		protected String value;
		protected String notionalTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("notionalTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalTypeScheme")
		public String getNotionalTypeScheme() {
			return notionalTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("notionalTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalTypeScheme")
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder setNotionalTypeScheme(String _notionalTypeScheme) {
			this.notionalTypeScheme = _notionalTypeScheme == null ? null : _notionalTypeScheme;
			return this;
		}
		
		@Override
		public NotionalReportingType build() {
			return new NotionalReportingType.NotionalReportingTypeImpl(this);
		}
		
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getNotionalTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalReportingType.NotionalReportingTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalReportingType.NotionalReportingTypeBuilder o = (NotionalReportingType.NotionalReportingTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getNotionalTypeScheme(), o.getNotionalTypeScheme(), this::setNotionalTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalReportingType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(notionalTypeScheme, _that.getNotionalTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (notionalTypeScheme != null ? notionalTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalReportingTypeBuilder {" +
				"value=" + this.value + ", " +
				"notionalTypeScheme=" + this.notionalTypeScheme +
			'}';
		}
	}
}
