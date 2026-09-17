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
import fpml.consolidated.doc.meta.VerificationMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type used to represent the type of mechanism that can be used to verify a trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type used to represent the type of mechanism that can be used to verify a trade.
 *
 */
@RosettaDataType(value="VerificationMethod", builder=VerificationMethod.VerificationMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VerificationMethod", model="fpml", builder=VerificationMethod.VerificationMethodBuilderImpl.class, version="2.1.1")
public interface VerificationMethod extends RosettaModelObject {

	VerificationMethodMeta metaData = new VerificationMethodMeta();

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
	String getVerificationMethodScheme();

	/*********************** Build Methods  ***********************/
	VerificationMethod build();
	
	VerificationMethod.VerificationMethodBuilder toBuilder();
	
	static VerificationMethod.VerificationMethodBuilder builder() {
		return new VerificationMethod.VerificationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VerificationMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VerificationMethod> getType() {
		return VerificationMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("verificationMethodScheme"), String.class, getVerificationMethodScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VerificationMethodBuilder extends VerificationMethod, RosettaModelObjectBuilder {
		VerificationMethod.VerificationMethodBuilder setValue(String value);
		VerificationMethod.VerificationMethodBuilder setVerificationMethodScheme(String verificationMethodScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("verificationMethodScheme"), String.class, getVerificationMethodScheme(), this);
		}
		

		VerificationMethod.VerificationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of VerificationMethod  ***********************/
	class VerificationMethodImpl implements VerificationMethod {
		private final String value;
		private final String verificationMethodScheme;
		
		protected VerificationMethodImpl(VerificationMethod.VerificationMethodBuilder builder) {
			this.value = builder.getValue();
			this.verificationMethodScheme = builder.getVerificationMethodScheme();
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
		@RosettaAttribute("verificationMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationMethodScheme")
		public String getVerificationMethodScheme() {
			return verificationMethodScheme;
		}
		
		@Override
		public VerificationMethod build() {
			return this;
		}
		
		@Override
		public VerificationMethod.VerificationMethodBuilder toBuilder() {
			VerificationMethod.VerificationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VerificationMethod.VerificationMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getVerificationMethodScheme()).ifPresent(builder::setVerificationMethodScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VerificationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(verificationMethodScheme, _that.getVerificationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (verificationMethodScheme != null ? verificationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationMethod {" +
				"value=" + this.value + ", " +
				"verificationMethodScheme=" + this.verificationMethodScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of VerificationMethod  ***********************/
	class VerificationMethodBuilderImpl implements VerificationMethod.VerificationMethodBuilder {
	
		protected String value;
		protected String verificationMethodScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("verificationMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationMethodScheme")
		public String getVerificationMethodScheme() {
			return verificationMethodScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public VerificationMethod.VerificationMethodBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("verificationMethodScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("verificationMethodScheme")
		@Override
		public VerificationMethod.VerificationMethodBuilder setVerificationMethodScheme(String _verificationMethodScheme) {
			this.verificationMethodScheme = _verificationMethodScheme == null ? null : _verificationMethodScheme;
			return this;
		}
		
		@Override
		public VerificationMethod build() {
			return new VerificationMethod.VerificationMethodImpl(this);
		}
		
		@Override
		public VerificationMethod.VerificationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationMethod.VerificationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getVerificationMethodScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationMethod.VerificationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VerificationMethod.VerificationMethodBuilder o = (VerificationMethod.VerificationMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getVerificationMethodScheme(), o.getVerificationMethodScheme(), this::setVerificationMethodScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VerificationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(verificationMethodScheme, _that.getVerificationMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (verificationMethodScheme != null ? verificationMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationMethodBuilder {" +
				"value=" + this.value + ", " +
				"verificationMethodScheme=" + this.verificationMethodScheme +
			'}';
		}
	}
}
