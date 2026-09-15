package fpml.consolidated.msg;

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
import fpml.consolidated.msg.meta.VerificationStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The verification status of the position as reported by the sender (Verified, Disputed).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The verification status of the position as reported by the sender (Verified, Disputed).
 *
 */
@RosettaDataType(value="VerificationStatus", builder=VerificationStatus.VerificationStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VerificationStatus", model="fpml", builder=VerificationStatus.VerificationStatusBuilderImpl.class, version="2.1.1")
public interface VerificationStatus extends RosettaModelObject {

	VerificationStatusMeta metaData = new VerificationStatusMeta();

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
	String getVerificationStatusScheme();

	/*********************** Build Methods  ***********************/
	VerificationStatus build();
	
	VerificationStatus.VerificationStatusBuilder toBuilder();
	
	static VerificationStatus.VerificationStatusBuilder builder() {
		return new VerificationStatus.VerificationStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VerificationStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VerificationStatus> getType() {
		return VerificationStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("verificationStatusScheme"), String.class, getVerificationStatusScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VerificationStatusBuilder extends VerificationStatus, RosettaModelObjectBuilder {
		VerificationStatus.VerificationStatusBuilder setValue(String value);
		VerificationStatus.VerificationStatusBuilder setVerificationStatusScheme(String verificationStatusScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("verificationStatusScheme"), String.class, getVerificationStatusScheme(), this);
		}
		

		VerificationStatus.VerificationStatusBuilder prune();
	}

	/*********************** Immutable Implementation of VerificationStatus  ***********************/
	class VerificationStatusImpl implements VerificationStatus {
		private final String value;
		private final String verificationStatusScheme;
		
		protected VerificationStatusImpl(VerificationStatus.VerificationStatusBuilder builder) {
			this.value = builder.getValue();
			this.verificationStatusScheme = builder.getVerificationStatusScheme();
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
		@RosettaAttribute("verificationStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationStatusScheme")
		public String getVerificationStatusScheme() {
			return verificationStatusScheme;
		}
		
		@Override
		public VerificationStatus build() {
			return this;
		}
		
		@Override
		public VerificationStatus.VerificationStatusBuilder toBuilder() {
			VerificationStatus.VerificationStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VerificationStatus.VerificationStatusBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getVerificationStatusScheme()).ifPresent(builder::setVerificationStatusScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VerificationStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(verificationStatusScheme, _that.getVerificationStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (verificationStatusScheme != null ? verificationStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationStatus {" +
				"value=" + this.value + ", " +
				"verificationStatusScheme=" + this.verificationStatusScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of VerificationStatus  ***********************/
	class VerificationStatusBuilderImpl implements VerificationStatus.VerificationStatusBuilder {
	
		protected String value;
		protected String verificationStatusScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("verificationStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("verificationStatusScheme")
		public String getVerificationStatusScheme() {
			return verificationStatusScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public VerificationStatus.VerificationStatusBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("verificationStatusScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("verificationStatusScheme")
		@Override
		public VerificationStatus.VerificationStatusBuilder setVerificationStatusScheme(String _verificationStatusScheme) {
			this.verificationStatusScheme = _verificationStatusScheme == null ? null : _verificationStatusScheme;
			return this;
		}
		
		@Override
		public VerificationStatus build() {
			return new VerificationStatus.VerificationStatusImpl(this);
		}
		
		@Override
		public VerificationStatus.VerificationStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatus.VerificationStatusBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getVerificationStatusScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VerificationStatus.VerificationStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VerificationStatus.VerificationStatusBuilder o = (VerificationStatus.VerificationStatusBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getVerificationStatusScheme(), o.getVerificationStatusScheme(), this::setVerificationStatusScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VerificationStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(verificationStatusScheme, _that.getVerificationStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (verificationStatusScheme != null ? verificationStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VerificationStatusBuilder {" +
				"value=" + this.value + ", " +
				"verificationStatusScheme=" + this.verificationStatusScheme +
			'}';
		}
	}
}
