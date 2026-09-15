package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.CreditEventTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes which credit event is taking place, e.g. Bankruptcy, FailureToPay, etc.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes which credit event is taking place, e.g. Bankruptcy, FailureToPay, etc.
 *
 */
@RosettaDataType(value="CreditEventType", builder=CreditEventType.CreditEventTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditEventType", model="fpml", builder=CreditEventType.CreditEventTypeBuilderImpl.class, version="2.1.1")
public interface CreditEventType extends RosettaModelObject {

	CreditEventTypeMeta metaData = new CreditEventTypeMeta();

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
	String getCreditEventTypeScheme();

	/*********************** Build Methods  ***********************/
	CreditEventType build();
	
	CreditEventType.CreditEventTypeBuilder toBuilder();
	
	static CreditEventType.CreditEventTypeBuilder builder() {
		return new CreditEventType.CreditEventTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditEventType> getType() {
		return CreditEventType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditEventTypeScheme"), String.class, getCreditEventTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventTypeBuilder extends CreditEventType, RosettaModelObjectBuilder {
		CreditEventType.CreditEventTypeBuilder setValue(String value);
		CreditEventType.CreditEventTypeBuilder setCreditEventTypeScheme(String creditEventTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditEventTypeScheme"), String.class, getCreditEventTypeScheme(), this);
		}
		

		CreditEventType.CreditEventTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventType  ***********************/
	class CreditEventTypeImpl implements CreditEventType {
		private final String value;
		private final String creditEventTypeScheme;
		
		protected CreditEventTypeImpl(CreditEventType.CreditEventTypeBuilder builder) {
			this.value = builder.getValue();
			this.creditEventTypeScheme = builder.getCreditEventTypeScheme();
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
		@RosettaAttribute("creditEventTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventTypeScheme")
		public String getCreditEventTypeScheme() {
			return creditEventTypeScheme;
		}
		
		@Override
		public CreditEventType build() {
			return this;
		}
		
		@Override
		public CreditEventType.CreditEventTypeBuilder toBuilder() {
			CreditEventType.CreditEventTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventType.CreditEventTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditEventTypeScheme()).ifPresent(builder::setCreditEventTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditEventTypeScheme, _that.getCreditEventTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditEventTypeScheme != null ? creditEventTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventType {" +
				"value=" + this.value + ", " +
				"creditEventTypeScheme=" + this.creditEventTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEventType  ***********************/
	class CreditEventTypeBuilderImpl implements CreditEventType.CreditEventTypeBuilder {
	
		protected String value;
		protected String creditEventTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditEventTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventTypeScheme")
		public String getCreditEventTypeScheme() {
			return creditEventTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CreditEventType.CreditEventTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("creditEventTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEventTypeScheme")
		@Override
		public CreditEventType.CreditEventTypeBuilder setCreditEventTypeScheme(String _creditEventTypeScheme) {
			this.creditEventTypeScheme = _creditEventTypeScheme == null ? null : _creditEventTypeScheme;
			return this;
		}
		
		@Override
		public CreditEventType build() {
			return new CreditEventType.CreditEventTypeImpl(this);
		}
		
		@Override
		public CreditEventType.CreditEventTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventType.CreditEventTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditEventTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventType.CreditEventTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEventType.CreditEventTypeBuilder o = (CreditEventType.CreditEventTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditEventTypeScheme(), o.getCreditEventTypeScheme(), this::setCreditEventTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditEventTypeScheme, _that.getCreditEventTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditEventTypeScheme != null ? creditEventTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventTypeBuilder {" +
				"value=" + this.value + ", " +
				"creditEventTypeScheme=" + this.creditEventTypeScheme +
			'}';
		}
	}
}
