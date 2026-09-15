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
import fpml.consolidated.loan.meta.LoanLegalActionTaskTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that uniquely identifies a task type within a legal action structure.
 *
 */
@RosettaDataType(value="LoanLegalActionTaskType", builder=LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionTaskType", model="fpml", builder=LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionTaskType extends RosettaModelObject {

	LoanLegalActionTaskTypeMeta metaData = new LoanLegalActionTaskTypeMeta();

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
	String getLegalActionTaskTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanLegalActionTaskType build();
	
	LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder toBuilder();
	
	static LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder builder() {
		return new LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionTaskType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionTaskType> getType() {
		return LoanLegalActionTaskType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("legalActionTaskTypeScheme"), String.class, getLegalActionTaskTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionTaskTypeBuilder extends LoanLegalActionTaskType, RosettaModelObjectBuilder {
		LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder setValue(String value);
		LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder setLegalActionTaskTypeScheme(String legalActionTaskTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("legalActionTaskTypeScheme"), String.class, getLegalActionTaskTypeScheme(), this);
		}
		

		LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionTaskType  ***********************/
	class LoanLegalActionTaskTypeImpl implements LoanLegalActionTaskType {
		private final String value;
		private final String legalActionTaskTypeScheme;
		
		protected LoanLegalActionTaskTypeImpl(LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder builder) {
			this.value = builder.getValue();
			this.legalActionTaskTypeScheme = builder.getLegalActionTaskTypeScheme();
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
		@RosettaAttribute("legalActionTaskTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionTaskTypeScheme")
		public String getLegalActionTaskTypeScheme() {
			return legalActionTaskTypeScheme;
		}
		
		@Override
		public LoanLegalActionTaskType build() {
			return this;
		}
		
		@Override
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder toBuilder() {
			LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLegalActionTaskTypeScheme()).ifPresent(builder::setLegalActionTaskTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legalActionTaskTypeScheme, _that.getLegalActionTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legalActionTaskTypeScheme != null ? legalActionTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionTaskType {" +
				"value=" + this.value + ", " +
				"legalActionTaskTypeScheme=" + this.legalActionTaskTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionTaskType  ***********************/
	class LoanLegalActionTaskTypeBuilderImpl implements LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder {
	
		protected String value;
		protected String legalActionTaskTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("legalActionTaskTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalActionTaskTypeScheme")
		public String getLegalActionTaskTypeScheme() {
			return legalActionTaskTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("legalActionTaskTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalActionTaskTypeScheme")
		@Override
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder setLegalActionTaskTypeScheme(String _legalActionTaskTypeScheme) {
			this.legalActionTaskTypeScheme = _legalActionTaskTypeScheme == null ? null : _legalActionTaskTypeScheme;
			return this;
		}
		
		@Override
		public LoanLegalActionTaskType build() {
			return new LoanLegalActionTaskType.LoanLegalActionTaskTypeImpl(this);
		}
		
		@Override
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLegalActionTaskTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder o = (LoanLegalActionTaskType.LoanLegalActionTaskTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLegalActionTaskTypeScheme(), o.getLegalActionTaskTypeScheme(), this::setLegalActionTaskTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legalActionTaskTypeScheme, _that.getLegalActionTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legalActionTaskTypeScheme != null ? legalActionTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionTaskTypeBuilder {" +
				"value=" + this.value + ", " +
				"legalActionTaskTypeScheme=" + this.legalActionTaskTypeScheme +
			'}';
		}
	}
}
