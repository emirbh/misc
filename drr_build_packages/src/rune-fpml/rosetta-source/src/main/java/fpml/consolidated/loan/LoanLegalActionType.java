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
import fpml.consolidated.loan.meta.LoanLegalActionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a legal action type.
 *
 */
@RosettaDataType(value="LoanLegalActionType", builder=LoanLegalActionType.LoanLegalActionTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionType", model="fpml", builder=LoanLegalActionType.LoanLegalActionTypeBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionType extends RosettaModelObject {

	LoanLegalActionTypeMeta metaData = new LoanLegalActionTypeMeta();

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
	String getLoanLegalActionTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanLegalActionType build();
	
	LoanLegalActionType.LoanLegalActionTypeBuilder toBuilder();
	
	static LoanLegalActionType.LoanLegalActionTypeBuilder builder() {
		return new LoanLegalActionType.LoanLegalActionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionType> getType() {
		return LoanLegalActionType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("loanLegalActionTypeScheme"), String.class, getLoanLegalActionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionTypeBuilder extends LoanLegalActionType, RosettaModelObjectBuilder {
		LoanLegalActionType.LoanLegalActionTypeBuilder setValue(String value);
		LoanLegalActionType.LoanLegalActionTypeBuilder setLoanLegalActionTypeScheme(String loanLegalActionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("loanLegalActionTypeScheme"), String.class, getLoanLegalActionTypeScheme(), this);
		}
		

		LoanLegalActionType.LoanLegalActionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionType  ***********************/
	class LoanLegalActionTypeImpl implements LoanLegalActionType {
		private final String value;
		private final String loanLegalActionTypeScheme;
		
		protected LoanLegalActionTypeImpl(LoanLegalActionType.LoanLegalActionTypeBuilder builder) {
			this.value = builder.getValue();
			this.loanLegalActionTypeScheme = builder.getLoanLegalActionTypeScheme();
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
		@RosettaAttribute("loanLegalActionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanLegalActionTypeScheme")
		public String getLoanLegalActionTypeScheme() {
			return loanLegalActionTypeScheme;
		}
		
		@Override
		public LoanLegalActionType build() {
			return this;
		}
		
		@Override
		public LoanLegalActionType.LoanLegalActionTypeBuilder toBuilder() {
			LoanLegalActionType.LoanLegalActionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionType.LoanLegalActionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLoanLegalActionTypeScheme()).ifPresent(builder::setLoanLegalActionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanLegalActionTypeScheme, _that.getLoanLegalActionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionTypeScheme != null ? loanLegalActionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionType {" +
				"value=" + this.value + ", " +
				"loanLegalActionTypeScheme=" + this.loanLegalActionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionType  ***********************/
	class LoanLegalActionTypeBuilderImpl implements LoanLegalActionType.LoanLegalActionTypeBuilder {
	
		protected String value;
		protected String loanLegalActionTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanLegalActionTypeScheme")
		public String getLoanLegalActionTypeScheme() {
			return loanLegalActionTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanLegalActionType.LoanLegalActionTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("loanLegalActionTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanLegalActionTypeScheme")
		@Override
		public LoanLegalActionType.LoanLegalActionTypeBuilder setLoanLegalActionTypeScheme(String _loanLegalActionTypeScheme) {
			this.loanLegalActionTypeScheme = _loanLegalActionTypeScheme == null ? null : _loanLegalActionTypeScheme;
			return this;
		}
		
		@Override
		public LoanLegalActionType build() {
			return new LoanLegalActionType.LoanLegalActionTypeImpl(this);
		}
		
		@Override
		public LoanLegalActionType.LoanLegalActionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionType.LoanLegalActionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLoanLegalActionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionType.LoanLegalActionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionType.LoanLegalActionTypeBuilder o = (LoanLegalActionType.LoanLegalActionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLoanLegalActionTypeScheme(), o.getLoanLegalActionTypeScheme(), this::setLoanLegalActionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanLegalActionTypeScheme, _that.getLoanLegalActionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionTypeScheme != null ? loanLegalActionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionTypeBuilder {" +
				"value=" + this.value + ", " +
				"loanLegalActionTypeScheme=" + this.loanLegalActionTypeScheme +
			'}';
		}
	}
}
