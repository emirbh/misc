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
import fpml.consolidated.loan.meta.IneligiblePartyReasonTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a legal action lender ineligible reason type.
 *
 */
@RosettaDataType(value="IneligiblePartyReasonType", builder=IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IneligiblePartyReasonType", model="fpml", builder=IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilderImpl.class, version="2.1.1")
public interface IneligiblePartyReasonType extends RosettaModelObject {

	IneligiblePartyReasonTypeMeta metaData = new IneligiblePartyReasonTypeMeta();

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
	String getIneligiblePartyReasonTypeScheme();

	/*********************** Build Methods  ***********************/
	IneligiblePartyReasonType build();
	
	IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder toBuilder();
	
	static IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder builder() {
		return new IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IneligiblePartyReasonType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IneligiblePartyReasonType> getType() {
		return IneligiblePartyReasonType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("ineligiblePartyReasonTypeScheme"), String.class, getIneligiblePartyReasonTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IneligiblePartyReasonTypeBuilder extends IneligiblePartyReasonType, RosettaModelObjectBuilder {
		IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder setValue(String value);
		IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder setIneligiblePartyReasonTypeScheme(String ineligiblePartyReasonTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("ineligiblePartyReasonTypeScheme"), String.class, getIneligiblePartyReasonTypeScheme(), this);
		}
		

		IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder prune();
	}

	/*********************** Immutable Implementation of IneligiblePartyReasonType  ***********************/
	class IneligiblePartyReasonTypeImpl implements IneligiblePartyReasonType {
		private final String value;
		private final String ineligiblePartyReasonTypeScheme;
		
		protected IneligiblePartyReasonTypeImpl(IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder builder) {
			this.value = builder.getValue();
			this.ineligiblePartyReasonTypeScheme = builder.getIneligiblePartyReasonTypeScheme();
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
		@RosettaAttribute("ineligiblePartyReasonTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligiblePartyReasonTypeScheme")
		public String getIneligiblePartyReasonTypeScheme() {
			return ineligiblePartyReasonTypeScheme;
		}
		
		@Override
		public IneligiblePartyReasonType build() {
			return this;
		}
		
		@Override
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder toBuilder() {
			IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIneligiblePartyReasonTypeScheme()).ifPresent(builder::setIneligiblePartyReasonTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IneligiblePartyReasonType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(ineligiblePartyReasonTypeScheme, _that.getIneligiblePartyReasonTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (ineligiblePartyReasonTypeScheme != null ? ineligiblePartyReasonTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IneligiblePartyReasonType {" +
				"value=" + this.value + ", " +
				"ineligiblePartyReasonTypeScheme=" + this.ineligiblePartyReasonTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IneligiblePartyReasonType  ***********************/
	class IneligiblePartyReasonTypeBuilderImpl implements IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder {
	
		protected String value;
		protected String ineligiblePartyReasonTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("ineligiblePartyReasonTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ineligiblePartyReasonTypeScheme")
		public String getIneligiblePartyReasonTypeScheme() {
			return ineligiblePartyReasonTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("ineligiblePartyReasonTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ineligiblePartyReasonTypeScheme")
		@Override
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder setIneligiblePartyReasonTypeScheme(String _ineligiblePartyReasonTypeScheme) {
			this.ineligiblePartyReasonTypeScheme = _ineligiblePartyReasonTypeScheme == null ? null : _ineligiblePartyReasonTypeScheme;
			return this;
		}
		
		@Override
		public IneligiblePartyReasonType build() {
			return new IneligiblePartyReasonType.IneligiblePartyReasonTypeImpl(this);
		}
		
		@Override
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIneligiblePartyReasonTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder o = (IneligiblePartyReasonType.IneligiblePartyReasonTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIneligiblePartyReasonTypeScheme(), o.getIneligiblePartyReasonTypeScheme(), this::setIneligiblePartyReasonTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IneligiblePartyReasonType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(ineligiblePartyReasonTypeScheme, _that.getIneligiblePartyReasonTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (ineligiblePartyReasonTypeScheme != null ? ineligiblePartyReasonTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IneligiblePartyReasonTypeBuilder {" +
				"value=" + this.value + ", " +
				"ineligiblePartyReasonTypeScheme=" + this.ineligiblePartyReasonTypeScheme +
			'}';
		}
	}
}
