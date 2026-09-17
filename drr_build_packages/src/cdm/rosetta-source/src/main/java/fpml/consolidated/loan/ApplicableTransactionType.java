package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.ApplicableTransactionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme that describes transaction types.
 *
 */
@RosettaDataType(value="ApplicableTransactionType", builder=ApplicableTransactionType.ApplicableTransactionTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApplicableTransactionType", model="fpml", builder=ApplicableTransactionType.ApplicableTransactionTypeBuilderImpl.class, version="2.1.1")
public interface ApplicableTransactionType extends RosettaModelObject {

	ApplicableTransactionTypeMeta metaData = new ApplicableTransactionTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getApplicableTransactionTypeScheme();

	/*********************** Build Methods  ***********************/
	ApplicableTransactionType build();
	
	ApplicableTransactionType.ApplicableTransactionTypeBuilder toBuilder();
	
	static ApplicableTransactionType.ApplicableTransactionTypeBuilder builder() {
		return new ApplicableTransactionType.ApplicableTransactionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableTransactionType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableTransactionType> getType() {
		return ApplicableTransactionType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("applicableTransactionTypeScheme"), String.class, getApplicableTransactionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableTransactionTypeBuilder extends ApplicableTransactionType, RosettaModelObjectBuilder {
		ApplicableTransactionType.ApplicableTransactionTypeBuilder setValue(String value);
		ApplicableTransactionType.ApplicableTransactionTypeBuilder setApplicableTransactionTypeScheme(String applicableTransactionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("applicableTransactionTypeScheme"), String.class, getApplicableTransactionTypeScheme(), this);
		}
		

		ApplicableTransactionType.ApplicableTransactionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableTransactionType  ***********************/
	class ApplicableTransactionTypeImpl implements ApplicableTransactionType {
		private final String value;
		private final String applicableTransactionTypeScheme;
		
		protected ApplicableTransactionTypeImpl(ApplicableTransactionType.ApplicableTransactionTypeBuilder builder) {
			this.value = builder.getValue();
			this.applicableTransactionTypeScheme = builder.getApplicableTransactionTypeScheme();
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
		@RosettaAttribute("applicableTransactionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableTransactionTypeScheme")
		public String getApplicableTransactionTypeScheme() {
			return applicableTransactionTypeScheme;
		}
		
		@Override
		public ApplicableTransactionType build() {
			return this;
		}
		
		@Override
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder toBuilder() {
			ApplicableTransactionType.ApplicableTransactionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableTransactionType.ApplicableTransactionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getApplicableTransactionTypeScheme()).ifPresent(builder::setApplicableTransactionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableTransactionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(applicableTransactionTypeScheme, _that.getApplicableTransactionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (applicableTransactionTypeScheme != null ? applicableTransactionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableTransactionType {" +
				"value=" + this.value + ", " +
				"applicableTransactionTypeScheme=" + this.applicableTransactionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicableTransactionType  ***********************/
	class ApplicableTransactionTypeBuilderImpl implements ApplicableTransactionType.ApplicableTransactionTypeBuilder {
	
		protected String value;
		protected String applicableTransactionTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("applicableTransactionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableTransactionTypeScheme")
		public String getApplicableTransactionTypeScheme() {
			return applicableTransactionTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("applicableTransactionTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicableTransactionTypeScheme")
		@Override
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder setApplicableTransactionTypeScheme(String _applicableTransactionTypeScheme) {
			this.applicableTransactionTypeScheme = _applicableTransactionTypeScheme == null ? null : _applicableTransactionTypeScheme;
			return this;
		}
		
		@Override
		public ApplicableTransactionType build() {
			return new ApplicableTransactionType.ApplicableTransactionTypeImpl(this);
		}
		
		@Override
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getApplicableTransactionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableTransactionType.ApplicableTransactionTypeBuilder o = (ApplicableTransactionType.ApplicableTransactionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getApplicableTransactionTypeScheme(), o.getApplicableTransactionTypeScheme(), this::setApplicableTransactionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableTransactionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(applicableTransactionTypeScheme, _that.getApplicableTransactionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (applicableTransactionTypeScheme != null ? applicableTransactionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableTransactionTypeBuilder {" +
				"value=" + this.value + ", " +
				"applicableTransactionTypeScheme=" + this.applicableTransactionTypeScheme +
			'}';
		}
	}
}
